package com.shop.app.model.user.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.shop.app.model.user.QUser;
import com.shop.app.model.user.dto.RequestUser;
import org.springframework.util.StringUtils;


public class UserPredicate {
    public static Predicate nameSearch(String name){
        BooleanBuilder builder = new BooleanBuilder();
        QUser user = QUser.user;
        if (!StringUtils.isEmpty(name)){
            builder.and(user.name.eq(name));
        }
        return builder;
    }
}


