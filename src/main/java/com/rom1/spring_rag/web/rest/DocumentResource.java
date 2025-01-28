package com.rom1.spring_rag.web.rest;

import com.rom1.spring_rag.domain.Document;
import com.rom1.spring_rag.repository.dto.DocumentDTO;
import com.rom1.spring_rag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DocumentResource {

    private final Logger log = LoggerFactory.getLogger(DocumentResource.class);

    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to save Document : {}", document);
        Document result = documentService.buildAndSave(document);

        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getAllDocuments() {
        log.debug("REST request to get all Documents");
        List<Document> documents = documentService.findAll();

        return ResponseEntity.ok(documents);
    }

    @GetMapping("/documents/dto")
    public ResponseEntity<List<DocumentDTO>> getAllDocumentsDTO() {
        log.debug("REST request to get all Documents DTO");
        List<DocumentDTO> documents = documentService.findAllDTO();

        return ResponseEntity.ok(documents);
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        log.debug("REST request to get Document : {}", id);
        Document document = documentService.findById(id).orElse(null);

        return ResponseEntity.ok(document);
    }

}