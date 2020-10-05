package com.shop.app.model.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.app.model.user.QUser;
import com.shop.app.model.user.User;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UserRepositorySupport(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }
    public List<User> findByName(String name) {
        return queryFactory
                .selectFrom(QUser.user)
                .where(QUser.user.name.eq(name))
                .fetch();
    }
}
