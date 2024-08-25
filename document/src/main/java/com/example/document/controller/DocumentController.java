package com.example.document.controller;

import com.example.document.model.Document;
import com.example.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("userName") String userName) throws IOException {
        return ResponseEntity.ok(documentService.uploadDocument(file,userName));

    }

//    @GetMapping("receiver/{receiverId}")
//    public ResponseEntity<List<Document>> getDocument(@PathVariable Long receiverId){
//        return ResponseEntity.ok(documentService.getDocumentsForReceiver(receiverId));
//
//    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId){
        documentService.deleteDocument(documentId);
        return ResponseEntity.noContent().build();

    }
}
