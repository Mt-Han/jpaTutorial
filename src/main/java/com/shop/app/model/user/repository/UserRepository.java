package com.shop.app.model.user.repository;

import com.querydsl.core.types.Predicate;
import com.shop.app.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface UserRepository extends JpaRepository<User,Long>, QuerydslPredicateExecutor<User> {
    User findByLoginId(String id);
}
