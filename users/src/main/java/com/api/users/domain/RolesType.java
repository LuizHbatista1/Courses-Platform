package com.api.users.domain;

import javax.management.relation.Role;

public enum RolesType {

    ADMIN("admin"),
    Common("common");

    private String role;

    RolesType (String role){

        this.role = role;

    }

    public String getValue(){

        return role;

    }



}
