package com.bazar.bazarbooks.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_notification") 
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;

    private String title;

    private String message;

    @Column(name = "`read`") 
    private boolean read;

    private LocalDateTime sentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
