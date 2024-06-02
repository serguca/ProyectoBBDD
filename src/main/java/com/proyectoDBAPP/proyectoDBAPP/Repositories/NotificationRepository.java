package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectoDBAPP.proyectoDBAPP.Models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
