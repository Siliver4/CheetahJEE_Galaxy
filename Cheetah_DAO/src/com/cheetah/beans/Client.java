package com.cheetah.beans;

/**
 * POJO class, representing a client.
 */
public class Client {

    private String name;
    private String surname;

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
            throw new BeanException("[CHEETAH_DAO] The surname is required");
        } else if (surname.length() > 10) {
            throw new BeanException("[CHEETAH_DAO] The surname is too long ( maximum 10 characters )");
        } else {
            this.surname = surname;
        }
    }
}