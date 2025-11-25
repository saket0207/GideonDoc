package com.document.gideon.respository;

import com.document.gideon.entity.Document;
import com.document.gideon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value = "select d from gideondb.documents d where user_id = :userId", nativeQuery = true)
    List<Document> findDocumentByUserId(@Param("userId") Long userId);

    List<Document> findByUserId(Long userId);
}
