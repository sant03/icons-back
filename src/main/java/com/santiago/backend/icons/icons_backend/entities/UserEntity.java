package com.santiago.backend.icons.icons_backend.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UserEntity {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="usu_id")
    private Long dna;

    @Column(name = "usu_nombres")
    private String name;

    @Column(name = "usu_apellidos")
    private String lastname;

    @Column(name = "usu_contraseña")
    private String password;

    @Column(name = "usu_fecha_Nacimiento")
    private Date birthDate;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_telefono")
    private Long phone;

    @Column(name = "usu_edad")
    private Integer edad;

    public UserEntity() {
    }

    public UserEntity(Long id, Long dna, String name, String lastname, String password, Date birthDate, String email,
            Long phone, Integer edad) {
        this.id = id;
        this.dna = dna;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

	public Long getDna() {
		return dna;
	}

	public void setDna(Long dna) {
		this.dna = dna;
	}

}
