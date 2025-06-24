package com.bazar.bazarbooks.service;

import com.bazar.bazarbooks.model.Notification;
import com.bazar.bazarbooks.model.User;
import com.bazar.bazarbooks.repository.NotificationRepository;
import com.bazar.bazarbooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Notification> getAllNotificationsByUser(int idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return notificationRepository.findByUserOrderBySentDateDesc(user);
    }

    public List<Notification> getUnreadNotificationsByUser(int idUser) {
        return notificationRepository.findByUser_IdUserAndReadFalseOrderBySentDateDesc(idUser);
    }

    public Notification getNotificationById(int id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification createFavoriteNotification(int idUser, int bookId) {
        Optional<User> userOpt = userRepository.findById(idUser);
        if (userOpt.isEmpty())
            return null;

        Notification n = new Notification();
        n.setTitle("Livro favoritado");
        n.setMessage("Você favoritou o livro com ID: " + bookId);
        n.setRead(false);
        n.setSentDate(LocalDateTime.now());
        n.setUser(userOpt.get());
   
        return notificationRepository.save(n);
    }

    public boolean markNotificationAsRead(int id) {
        Optional<Notification> opt = notificationRepository.findById(id);
        if (opt.isPresent()) {
            Notification n = opt.get();
            n.setRead(true);
            notificationRepository.save(n);
            return true;
        }
        return false;
    }

    public boolean deleteNotification(int idUser, int id) {
        Optional<Notification> opt = notificationRepository.findById(id);
        if (opt.isPresent() && opt.get().getUser().getIdUser() == idUser) {
            notificationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
