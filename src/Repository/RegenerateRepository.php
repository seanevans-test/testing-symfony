<?php

namespace App\Repository;

use App\Entity\Regenerate;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Common\Persistence\ManagerRegistry;

/**
 * @method Regenerate|null find($id, $lockMode = null, $lockVersion = null)
 * @method Regenerate|null findOneBy(array $criteria, array $orderBy = null)
 * @method Regenerate[]    findAll()
 * @method Regenerate[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class RegenerateRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Regenerate::class);
    }
}
