package org.example.mobily.service;

import org.example.mobily.model.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {

    Article findById(Long id);
    Article findByTitle(String title);
    Page<Article> findAll(int page, int size);
    Article save(Article article);
    void delete(Article article);
    Article update(Article article);
    Page<Article> findTop(int page, int size);
}
