package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import com.proyectoDBAPP.proyectoDBAPP.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
