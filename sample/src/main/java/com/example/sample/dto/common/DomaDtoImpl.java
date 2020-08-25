package com.example.sample.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.sample.dao.DefaultEntityListener;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Transient;
import org.seasar.doma.Version;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity(listener = DefaultEntityListener.class) // 自動的にシステム制御項目を更新するためにリスナーを指定する
@Setter
@Getter
public abstract class DomaDtoImpl implements DomaDto, Serializable {

    @JsonIgnore
    String createdBy;

    @JsonIgnore
    LocalDateTime createdAt;

    @JsonIgnore
    String updatedBy;

    @JsonIgnore
    LocalDateTime updatedAt;

    @JsonIgnore
    String deletedBy;

    @JsonIgnore
    LocalDateTime deletedAt;

    @Version
    @Column(name = "version")
    Integer version;

    @Transient
    @JsonIgnore
    String auditUser;

    @Transient
    @JsonIgnore
    LocalDateTime auditDateTime;
}
