package com.example.Rydo.Dtos;

public class UserResponseDTO {
    private Integer userId;
    private String name;
    private String email;
    private String Phone;
    UserResponseDTO(){}
    
    public UserResponseDTO(Integer userId, String name, String email,String Phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.Phone = Phone;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
