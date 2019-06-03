package com.example.demo.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookType_Numrespository   extends JpaRepository<BookType_Num,String> {
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "SELECT num FROM booktypenum ",nativeQuery = true)
//    List<Integer> getdata();
    BookType_Num findByName(String name);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update booktypenum set value =value +1 where name = :name ",nativeQuery = true)
    void update(@Param("name") String name );

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into booktypenum values (1,:name)",nativeQuery = true)
    void update2(@Param("name") String name );

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update booktypenum set value =value -1 where name = :name ",nativeQuery = true)
    void increase (@Param("name") String name );


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from booktypenum where name = :name  ",nativeQuery = true)
    void increase2(@Param("name") String name );
}
