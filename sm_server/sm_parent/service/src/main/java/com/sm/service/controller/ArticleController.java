package com.sm.service.controller;

import com.sm.service.entity.Article;
import com.sm.service.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*文章分页列表*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
/*    PageInfo list_all(@PathVariable(value = "title") String title, @PathVariable(value = "current_index")
            Integer current_index, @PathVariable(value = "pagesize") Integer pagesize) throws Exception {  */
    PageInfo list_all(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "current_index", required = false)
            Integer current_index, @RequestParam(value = "pagesize", required = false) Integer pagesize) throws Exception {

        if (null == current_index) current_index = 1;
        if (null == pagesize) pagesize = 7;

        // 1.引入PageHelper分页插件
        // 2.在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(current_index, pagesize);

        List<Article> page_list = articleService.list(title);
        logger.info("获取文章列表");

        logger.info("title" + title);
        logger.info("pagesize" + pagesize);
        logger.info("current_index" + current_index);

        if (null != page_list) {
            // 3.startPage后面紧跟的这个查询就是一个分页查询
            // 4.使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo<Article> page_ = new PageInfo<Article>(page_list, 5);

            return page_;
        } else {
            return null;
        }
    }

    /*获取文章详情*/
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public Article details(@PathVariable(name = "id") Integer id) {
        logger.info("文章详情");
        logger.info("文章编号" + id);
        Article article = articleService.details(id);
        if (null != article) {
            logger.info("文章信息" + article);
            return article;
        } else {
            return null;
        }
    }

    /*修改文章信息*/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean update(@RequestBody Article article) {
        Boolean result = articleService.update(article);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    /*新增文章信息*/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody Article article) {
        Boolean result = articleService.add(article);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    /*删除文章信息*/
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Boolean delete(@PathVariable(value = "id") Integer id) {
        if (null != id) {
            Boolean result = articleService.delete(id);
            if (result) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
