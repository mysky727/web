package cn.yupcd.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.yupcd.web.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
