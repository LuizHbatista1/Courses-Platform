package com.api.users.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    private String confirmPassword;
    private Double balance = 0.0;
    private Integer totalCourses = 0 ;
    @Enumerated(EnumType.STRING)
    private RolesType role = RolesType.Common;

    public User(String firstName , String lastName , String email , String password , String confirmPassword) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == RolesType.ADMIN){

            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN") , new SimpleGrantedAuthority("COMMON"));

        }

        return List.of(new SimpleGrantedAuthority("ROLE_COMMON"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
