package com.example.document.repository;

import com.example.document.model.Document;
import com.example.document.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  DocumentRepository extends JpaRepository<Document,Long> {
    List<Document> findByReceiverId(Long receiverId);

    public Document deleteDocumentById(Long documentId);

    List<Document> findByReceiver(User receiver);
}
