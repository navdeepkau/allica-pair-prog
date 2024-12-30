package com.demo.practice.request;

import lombok.*;

@Data
@Getter
@Setter
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    // Getter and Setter Methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}



