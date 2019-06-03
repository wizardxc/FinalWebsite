package com.example.demo.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Adminrespository extends JpaRepository<Admin,String> {
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update usertest set adminnum = ?, ",nativeQuery = true)
    public Admin findByNumber(int number );
}
