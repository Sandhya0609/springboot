package com.sandhya.librarymanagement.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sandhya.librarymanagement.model.Permission;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.Managed;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),

    ADMIN(Set.of(
           Permission.ADMIN_CREATE,
            Permission.ADMIN_UPDATE,
           Permission.ADMIN_DELETE,
            Permission.ADMIN_READ
    )),

    MANAGER(Set.of(
            Permission.MANAGER_CREATE,
            Permission.MANAGER_DELETE,
            Permission.MANAGER_READ,
            Permission.MANAGER_UPDATE
    ));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){

        List<SimpleGrantedAuthority> authorities=getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
