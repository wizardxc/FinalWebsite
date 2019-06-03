package com.example.demo.LoginAdmin;

import com.example.demo.LoginAdmin.LoginAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoginAdminrespository extends JpaRepository<LoginAdmin,String> {
    public LoginAdmin findByNumber(int number  );
    public boolean  existsAdminByUsername(String username);
    public LoginAdmin findByUsername(String username);
}
