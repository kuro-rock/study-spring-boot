package com.example.sample.dto.user;

import org.seasar.doma.*;

import com.example.sample.dto.common.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

@Table(name = "user_roles")
@Entity
@Getter
@Setter
public class UserRole extends DomaDtoImpl {

    private static final long serialVersionUID = -6750983302974218054L;

    // 担当者役割ID
    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // ユーザーID
    Long user_id;

    // 役割キー
    String role_key;

    // 役割名
    String role_name;

    // 権限キー
    String permission_key;

    // 権限名
    String permission_name;
}
