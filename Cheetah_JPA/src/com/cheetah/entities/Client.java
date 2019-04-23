package com.cheetah.entities;

import javax.persistence.*;

/**
 * POJO class, representing a client.
 */
@Entity
@Table(name = "t_client_cli")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "cli_id" )
    private Long id;

    @Column( name = "cli_name" )
    private String name;

    @Column( name = "cli_surname" )
    private String surname;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws BeanException {
        if (surname.length() == 0) {
            throw new BeanException("[CHEETAH_JPA] The surname is required");
        } else if (surname.length() > 10) {
            throw new BeanException("[CHEETAH_JPA] The surname is too long ( maximum 10 characters )");
        } else {
            this.surname = surname;
        }
    }
}