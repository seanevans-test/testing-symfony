<?php

namespace App\Controller;

use App\Entity\Post;
use App\Form\PostType;
use App\Repository\PostRepository;
use App\Services\FileUploader;
use App\Services\Notification;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


class PostController extends AbstractController
{
    /**
     * @Route("/", name="post.index")
     * @param PostRepository $postRepository
     * @return Response
     */
    public function index(PostRepository $postRepository)
    {
        $posts = $postRepository->findAll();
        return $this->render('post/index.html.twig', [
            'posts' => $posts
        ]);
    }

    /**
     * @Route("/post/create", name="post.create")
     * @param Request $request
     * @return string
     */
    public function create(Request $request, FileUploader $fileUploader, Notification $notification) {
        $post = new Post();

        $form = $this->createForm(PostType::class, $post);

        $form->handleRequest($request);

        if ($form->isSubmitted()) {
            $em =  $this->getDoctrine()->getManager();
            /** @var UploadedFile $file */
            $file = $request->files->get('post')['attachment'];

            if($file){
                $filename = $fileUploader->uploadFile($file);
                $post->setImage($filename);
                $em->persist($post);
                $em->flush();
            }
            return $this->redirect($this->generateUrl('post.index'));
        }

        return $this->render('post/create.html.twig', [
            'form' => $form->createView()
        ]);
    }

    /**
     * @Route("post/show/{id}", name="post.show")
     * @param Post $post
     * @return Response
     */
    public function show(Post $post) {
        return $this->render('post/show.html.twig', [
            'post' => $post
        ]);

    }

    /**
     * @Route("/post/delete/{id}", name="post.delete")
     * @param Post $post
     * @return Response
     */
    public function remove(Post $post) {
        $em = $this->getDoctrine()->getManager();
        $em->remove($post);
        $em->flush();

        $this->addFlash('success', 'Post was successfully removed');

        return $this->redirect($this->generateUrl('post.index'));
    }
}
