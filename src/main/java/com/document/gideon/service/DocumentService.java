package com.document.gideon.service;

import com.document.gideon.dto.DocumentRequest;
import com.document.gideon.dto.DocumentResponse;
import com.document.gideon.entity.Document;
import com.document.gideon.entity.User;
import com.document.gideon.respository.DocumentRepository;
import com.document.gideon.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    public DocumentResponse createDocument(DocumentRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Document document = Document.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .lastModified(LocalDateTime.now())
                .build();

        Document savedDocument =  documentRepository.save(document);
        return mapToResponse(savedDocument);
    }

    private DocumentResponse mapToResponse(Document document) {
        return new DocumentResponse(
                document.getId(),
                document.getTitle(),
                document.getContent(),
                document.getUser().getId(),
                document.getLastModified()
        );
    }

    public List<Document> getUserDocuments(Long userId){
        return documentRepository.findByUserId(userId);
    }

    public Document getDocumentsByID(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public DocumentResponse updateDocument(Long documentId, DocumentRequest request) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        document.setContent(request.getContent());
        document.setTitle(request.getTitle());
        document.setLastModified(LocalDateTime.now());
        Document updatedDocument = documentRepository.save(document);
        return mapToResponse(updatedDocument);
    }

    public void deleteDocument(Long documentId) {
        if(!documentRepository.existsById(documentId)){
            throw new RuntimeException("Document not found");
        }
        documentRepository.deleteById(documentId);
    }
}
