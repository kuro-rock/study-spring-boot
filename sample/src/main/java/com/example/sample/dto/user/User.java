package com.example.sample.dto.user;

import javax.validation.constraints.Email;

import com.example.sample.dto.common.DomaDtoImpl;
import org.seasar.doma.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User extends DomaDtoImpl {

    private static final long serialVersionUID = 4512633005852272922L;

    @OriginalStates // 差分UPDATEのために定義する
    @JsonIgnore // APIのレスポンスに含めない
            User originalStates;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String name;

    @Email
    String email;

    @JsonIgnore
    String password;
}
