package com.db.articledirect.Repository;

import com.db.articledirect.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    public List<Article> findByStatus(String status);

}
