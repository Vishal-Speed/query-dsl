package com.example.repository;

import com.example.entity.QUser;
import com.example.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findByName(String name) {
        QUser user = QUser.user;
        return new JPAQuery<>(em)
                .select(user)
                .from(user)
                .where(user.name.eq(name))
                .fetch();
    }

    @Override
    public List<User> findAdults() {
        QUser user = QUser.user;
        return new JPAQuery<>(em)
                .select(user)
                .from(user)
                .where(user.age.goe(18))
                .fetch();
    }

    @Override
    public List<User> findUserByNameAndAge(String name, Integer age) {
        QUser user = QUser.user;
        return new JPAQuery<>(em)
                .select(user)
                .from(user)
                .where(user.name.contains(name).and(user.age.goe(age)))
                .fetch();
    }
}
