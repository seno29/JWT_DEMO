package com.db.articledirect.controller;

import com.db.articledirect.Repository.ArticleRepository;
import com.db.articledirect.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepo;

    @PostMapping("/addArticle")
    public String addArticle(@RequestBody Article article){
        try{
            articleRepo.save(article);
        }catch(Exception e){
            e.printStackTrace();
            return "Adding Failed: " + e.getMessage();
        }

        return "Article Added Success";
    }

    @GetMapping("/{status}")
    public List<Article> getArticleWithStatus(@PathVariable String status){
        List<Article> art;
        try{
            art = articleRepo.findByStatus(status);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return art;
    }

}
