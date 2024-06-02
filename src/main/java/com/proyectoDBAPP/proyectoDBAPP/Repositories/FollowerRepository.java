package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import com.proyectoDBAPP.proyectoDBAPP.Models.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
}
