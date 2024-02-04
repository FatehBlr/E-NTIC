package com.elearning.backend.model.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRole {
    @Id
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    // @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    // private List<AppUser> users;

}
