package com.example.sample.dao;

import com.example.sample.dto.user.UserRole;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import java.util.stream.Collector;

@ConfigAutowireable
@Dao
public interface UserRoleDao {

    /**
     * 権限を取得します。
     * 
     * @param id
     * @param collector
     * @param <R>
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectByUserId(Long id, final Collector<UserRole, ?, R> collector);
}
