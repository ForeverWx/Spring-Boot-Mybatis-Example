package com.sm.service.service;

import com.sm.service.dao.ArticleDao;
import com.sm.service.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired(required = false)
    private ArticleDao articleDao;

    public List<Article> list(String title) {
        return articleDao.list('%' + title + '%');
    }

    public Article details(Integer id) {
        return articleDao.details(id);
    }

    public Boolean update(Article article) {
        try {
            articleDao.update(article.getTitle(), article.getD_abstract(), article.getContent(), article.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean add(Article article) {
        try {
            articleDao.add(article.getTitle(), article.getD_abstract(), article.getContent());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) {
        try {
            articleDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
