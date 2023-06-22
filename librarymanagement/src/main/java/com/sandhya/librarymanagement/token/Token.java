package com.sandhya.librarymanagement.token;

import com.sandhya.librarymanagement.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType=TokenType.BEARER;

    private boolean expired;

    public boolean revoked;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="user_Id")
    private User user;

}
