package com.vukimphuc.employeemanagement.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private String gender;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String role;

    @OneToMany(mappedBy = "user",orphanRemoval = true ,cascade = CascadeType.ALL)
    private List<Work> works = new ArrayList<Work>();

    @OneToMany(mappedBy = "user", orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Submission> submission = new ArrayList<Submission>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authoritySet = new HashSet<>();
        authoritySet.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        return authoritySet;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return true ;
    }
}
