package com.rom1.spring_rag.repository.dto;


public record DocumentDTO(Long id, String title, String description, String author, String publisher, String publishedDate, String contentType) {
}
