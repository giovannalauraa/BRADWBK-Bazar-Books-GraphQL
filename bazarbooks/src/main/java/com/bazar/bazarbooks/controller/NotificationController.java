package com.bazar.bazarbooks.controller;

import com.bazar.bazarbooks.model.Notification;
import com.bazar.bazarbooks.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @QueryMapping
    public List<Notification> getAllNotificationsByUser(@Argument int idUser) {
        return notificationService.getAllNotificationsByUser(idUser);
    }

    @QueryMapping
    public List<Notification> getUnreadNotificationsByUser(@Argument int idUser) {
        return notificationService.getUnreadNotificationsByUser(idUser);
    }

    @QueryMapping
    public Notification getNotificationById(@Argument int id) {
        return notificationService.getNotificationById(id);
    }

    @MutationMapping
    public Notification createFavoriteNotification(@Argument int idUser, @Argument int bookId) {
        return notificationService.createFavoriteNotification(idUser, bookId);
    }

    @MutationMapping
    public String markNotificationAsRead(@Argument int id) {
        return notificationService.markNotificationAsRead(id) ? "Marcada como lida" : "Não encontrada";
    }

    @MutationMapping
    public String deleteNotification(@Argument int idUser, @Argument int id) {
        return notificationService.deleteNotification(idUser, id) ? "Deletada" : "Erro ao deletar";
    }
}
