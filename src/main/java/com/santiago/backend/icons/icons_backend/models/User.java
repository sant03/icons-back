package com.santiago.backend.icons.icons_backend.models;

import java.util.Date;

public class User {
	
	private Long dna;
    private String name;
    private String lastname;
    private String password;
    private Date bithDate;
    private String email;
    private Integer edad;
    private Long telefono;

    public User() {
    }

    

    public User(Long dna, String name, String lastname, String password, Date bithDate, String email, Integer edad,
            Long telefono) {
    	this.dna = dna;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.bithDate = bithDate;
        this.email = email;
        this.edad = edad;
        this.telefono = telefono;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public Date getBithDate() {
        return bithDate;
    }



    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }



	public Long getDna() {
		return dna;
	}



	public void setDna(Long dna) {
		this.dna = dna;
	}

}
