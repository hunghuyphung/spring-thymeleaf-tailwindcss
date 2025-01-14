package vn.java.springthymeleaftailwindcss.entity;

import jakarta.persistence.*;
import lombok.Data;
import vn.java.springthymeleaftailwindcss.enums.Status;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sys_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String fullName;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
    private Role role;

    private String roleName;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;

    private String createdBy;

    private String updatedBy;

    private Integer level;

    private Long lockTime;

    private Integer failedAttempt;

    private Boolean accountNonLocked;

    @Enumerated(EnumType.STRING)
    private Status status;
}
