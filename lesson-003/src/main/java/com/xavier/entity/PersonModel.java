package com.xavier.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonModel {

    private UserModel userModel;

    private MenuModel menuModel;

}
