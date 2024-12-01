package ru.chernyukai.isforunis.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.userdetails.UserDetails;

@Accessors(chain = true)
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter //Генерируем геттеры
@Setter //Генерируем сеттеры
@ToString
@Entity(name = "Users")
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(sequenceName = "user_id_seq", name = "user_id_seq", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "user_id_seq")

    private Long id;

    private String username;

    private String password;

    private boolean expired;
    private boolean locked;
    private boolean enabled;


    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles.stream().map(UserRole::getUserAuthority).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}