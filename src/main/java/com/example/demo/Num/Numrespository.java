package com.example.demo.Num;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Numrespository extends JpaRepository<Num,String> {
        @Transactional
        @Modifying(clearAutomatically = true)
        @Query(value = "update num set adminnum = adminnum+1 ",nativeQuery = true)
         void updateAdminNum();

        @Transactional
        @Modifying(clearAutomatically = true)
    @Query(value="update num set adminnum=adminnum-1",nativeQuery = true)
        void increaseAdminNum();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update num set booknum = booknum+1 ",nativeQuery = true)
    void updateBookNum();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update num set booknum=booknum-1",nativeQuery = true)
    void increaseBookNum();


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update num set usernum = usernum+1 ",nativeQuery = true)
    void updateUserNum();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update num set usernum=usernum-1",nativeQuery = true)
    void increaseUserNum();


}
