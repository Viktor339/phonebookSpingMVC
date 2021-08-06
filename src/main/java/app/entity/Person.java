package app.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min=2,max =30,message = "Name should be between 2 and 30 characters")
    private String name;
    @Min(value = 0,message="Enter correct phone number")
    @Size(min=12,max =12,message = "Phone number should be 12 characters")
    private String phoneNumber;
    @NotEmpty(message = "Address should not be empty")
    private String address;
    @NotEmpty(message = "Second name should not be empty")
    @Size(min=2,max =30,message = "Name should be between 2 and 30 characters")
    private String secondName;

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
