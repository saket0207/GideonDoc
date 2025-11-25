package com.document.gideon.controller;

import com.document.gideon.dto.DocumentRequest;
import com.document.gideon.dto.DocumentResponse;
import com.document.gideon.entity.Document;
import com.document.gideon.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    //GET ALL DOCUMENTS
    @GetMapping("/documents/user/{userId}")
    public List<Document> getDocuments(@PathVariable Long userId){
        return documentService.getUserDocuments(userId);
    }
    //GET DOCUMENT
    @GetMapping("/documents/{documentId}")
    public Document getDocument(Long documentId){
        return documentService.getDocumentsByID(documentId);
    }
    //CREATE DOCUMENT
    @PostMapping("/documents")
    public DocumentResponse createDocument(@RequestBody DocumentRequest request){
        return documentService.createDocument(request);
    }
    //EDIT DOCUMENT
    @PutMapping("/documents/{documentId}")
    public DocumentResponse editDocument(@PathVariable Long documentId, @RequestBody DocumentRequest request){

        return documentService.updateDocument(documentId, request);
    }
    @DeleteMapping("/documents/{documentId}")
    public void deleteDocument(@PathVariable Long documentId){
        documentService.deleteDocument(documentId);
    }
}
