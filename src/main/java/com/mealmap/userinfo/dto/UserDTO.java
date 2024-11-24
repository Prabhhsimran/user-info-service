package com.mealmap.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int userId;
    private String userName;
    //should be encrypted
    private String password;
    private String address;
    private String city;
}
