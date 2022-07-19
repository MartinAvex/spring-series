package com.xavier.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Man extends Person{

    private String sexual;

    public Man(String name, Address address, String sexual) {
        super(name, address);
        this.sexual = sexual;
    }

    @Override
    public String toString() {
        return "Man(" +
                "name=" + getName() + ", " + "address=" + getAddress() + ", " + "sexual=" + getSexual() +
                ")";
    }
}
