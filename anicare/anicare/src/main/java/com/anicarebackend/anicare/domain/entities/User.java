package com.anicarebackend.anicare.domain.entities;

import java.util.UUID;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")//try to build more secure user based application
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @Column(name = "User_Id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "Username", nullable = false, updatable = true)
    private String name;

    @Column(name = "Password", nullable = false, updatable = true)
    private String password;

    @Column(name = "Email", nullable = false, updatable = true)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true) //users or owners can have many pets
    private List<Pet> pets;
}
