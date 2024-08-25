package com.example.document.service;

import com.example.document.model.Document;
import com.example.document.model.Receiver;
import com.example.document.model.User;
import com.example.document.repository.DocumentRepository;
import com.example.document.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

//    @Autowired
//    private DocumentRepository documentRepository;
//
//    @Autowired
//    private ReceiverRepository receiverRepository;
//    public Document uploadDocument(MultipartFile file, String userName) throws IOException {
//        String tmpFolderPath = System.getProperty("java.io.tmpdir") + File.separator + userName + File.separator + file.getOriginalFilename();
//        File f = new File(tmpFolderPath);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        String filePath = String.valueOf(f);
//
//        file.transferTo(new File(filePath));
//
//        Receiver receiver = receiverRepository.findByUserName(userName).orElse(null);
//        if (receiver == null) {
//            throw new IllegalArgumentException("Invalid receiver ID");
//        }
//
//        Document document = new Document();
//        document.setFilePath(filePath);
//
//        document.setStatus("PENDING");
//        documentRepository.save(document);
//        return document;
//    }
//
//    public Document deleteDocument(Long documentId){
//        return documentRepository.deleteDocumentById(documentId);
//    }


    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> findDocumentsByReceiver(User receiver) {
        return documentRepository.findByReceiver(receiver);
    }

    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }
}
