package vn.java.springthymeleaftailwindcss.entity;

import jakarta.persistence.*;
import lombok.Data;
import vn.java.springthymeleaftailwindcss.enums.Status;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;

    private String createdBy;

    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_authorities",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    private Set<Authority> authorities = new HashSet<>();

    private Integer level;
}
