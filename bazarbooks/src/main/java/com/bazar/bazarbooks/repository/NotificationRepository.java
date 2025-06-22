package com.bazar.bazarbooks.repository;

import com.bazar.bazarbooks.model.Notification;
import com.bazar.bazarbooks.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserOrderBySentDateDesc(User user);

    List<Notification> findByUser_IdUserAndReadFalseOrderBySentDateDesc(int idUser);

}
