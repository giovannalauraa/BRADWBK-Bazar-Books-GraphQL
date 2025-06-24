package com.bazar.bazarbooks.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private int idNotification;

    private String title;

    private String message;

    @Column(name = "is_read")
    private boolean read;

    @Column(name = "sent_date")
    private LocalDateTime sentDate;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
