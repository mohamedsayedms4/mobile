package org.example.mobily.controller;

import lombok.RequiredArgsConstructor;
import org.example.mobily.dto.UploadArticle;
import org.example.mobily.model.Article;
import org.example.mobily.service.ArticleService;
import org.example.mobily.service.ImageUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("*")
public class ArticleController {

    private final ArticleService articleService;
    private final ImageUploadUtil imageUploadUtil;

    // ✅ Get Article by ID
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.findById(id);
        return (article != null) ?
                ResponseEntity.ok(article) :
                ResponseEntity.notFound().build();
    }

    // ✅ Get Article by Title
    @GetMapping("/title/{title}")
    public ResponseEntity<Article> getArticleByTitle(@PathVariable String title) {
        Article article = articleService.findByTitle(title);
        return (article != null) ?
                ResponseEntity.ok(article) :
                ResponseEntity.notFound().build();
    }

    // ✅ Get All Articles (with pagination)
    @GetMapping
    public ResponseEntity<Page<Article>> getAllArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(articleService.findAll(page, size));
    }

    // ✅ Get Latest Articles (ordered by createdAt DESC)
    @GetMapping("/latest")
    public ResponseEntity<Page<Article>> getLatestArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(articleService.findTop(page, size));
    }

    // ✅ Create New Article
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Article> createArticle(
            @RequestPart("article") UploadArticle articleDto,
            @RequestPart(value = "banner", required = false) MultipartFile banner,
            @RequestPart(value = "images", required = false) MultipartFile[] images
    ) {
        String bannerUrl = (banner != null && !banner.isEmpty())
                ? imageUploadUtil.saveImage(banner)
                : null;

        List<String> imageUrls = (images != null && images.length > 0)
                ? imageUploadUtil.saveImages(images)
                : null;

        Article article = Article.builder()
                .title(articleDto.title())
                .description(articleDto.description())
                .bannerUrl(bannerUrl)
                .photo(imageUrls)
                .specificationsSection(articleDto.specificationsSection())
                .priceSection(articleDto.priceSection())
                .build();

        Article saved = articleService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ✅ Update Existing Article
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        Article updated = articleService.update(article);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete Article
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        Article article = articleService.findById(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        articleService.delete(article);
        return ResponseEntity.noContent().build();
    }
}
