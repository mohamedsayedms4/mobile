package org.example.mobily.service.impl;


import org.example.mobily.model.Article;
import org.example.mobily.repository.ArticleRepository;
import org.example.mobily.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article not found with id: " + id));
    }

    @Override
    public Article findByTitle(String title) {
        // لو عايز تبحث بالعنوان محتاج تعمل method في ArticleRepository
        // مثلا: Optional<Article> findByTitle(String title);
        Optional<Article> articleOpt = articleRepository.findAll()
                .stream()
                .filter(a -> a.getTitle().equalsIgnoreCase(title))
                .findFirst();

        return articleOpt.orElseThrow(() -> new NoSuchElementException("Article not found with title: " + title));
    }

    @Override
    public Page<Article> findAll(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article update(Article article) {
        if (article.getId() == null) {
            throw new IllegalArgumentException("Article ID must not be null for update.");
        }
        if (!articleRepository.existsById(article.getId())) {
            throw new NoSuchElementException("Article not found with id: " + article.getId());
        }
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> findTop(int page, int size) {
        return articleRepository.findAllByOrderByCreatedAtDesc(PageRequest.of(page, size));
    }

}
