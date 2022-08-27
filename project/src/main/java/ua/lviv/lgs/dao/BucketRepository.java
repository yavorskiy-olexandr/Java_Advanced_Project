package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer>{

}
