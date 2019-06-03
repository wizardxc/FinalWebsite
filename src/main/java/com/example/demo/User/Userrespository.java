package com.example.demo.User;

import com.example.demo.Num.Num;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrespository extends JpaRepository<User,String> {
    public User findByUid(int uid );
}
