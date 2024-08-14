package cl.praxis.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="t_user_role",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "role_id"))
    List<Role> roles;
}
