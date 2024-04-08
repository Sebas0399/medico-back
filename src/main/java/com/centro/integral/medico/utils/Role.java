package com.centro.integral.medico.utils;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ENFERMERO(Arrays.asList(Permission.READ_ALL_PACIENTES)),
    ADMINISTRADOR(Arrays.asList(Permission.SAVE_HISTORIA, Permission.READ_ALL_PACIENTES));

    Role(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    private List<Permission> permissionList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
