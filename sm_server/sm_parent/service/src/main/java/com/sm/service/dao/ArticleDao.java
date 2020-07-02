package com.sm.service.dao;

import com.sm.service.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    /**
     * 查询文章列表
     *
     * @return id="articleMap"  给results命名
     * Results 实体类结果映射
     */
    @Select("select * from d_article where title like #{title} and state=1 order by create_time desc")
    @Results(id = "d_article_list_Map", value = {
            /*将abstract 本地 映射 为 d_abstract*/
            @Result(column = "abstract", property = "d_abstract"),
    })
    List<Article> list(@Param("title") String title);


    @Select("select * from d_article where id = #{id}")
    @Results(id = "d_article_details_Map", value = {
            /*将abstract 本地 映射 为 d_abstract*/
            @Result(column = "abstract", property = "d_abstract"),
    })
    Article details(@Param("id") Integer id);

    @Select("update d_article set title=#{title},abstract=#{abstract},content=#{content},update_time=sysdate()  where id=#{article_id}")
    Boolean update(@Param("title") String title, @Param("abstract") String b_abstract, @Param("content") String content, @Param("article_id") Integer article_id);

    @Select("insert into d_article(title,abstract,content) value(#{title},#{abstract},#{content})")
    void add(String title, @Param("abstract") String d_abstract, String content);

    /*删除文章设置状态*/
    @Select("update d_article set state=0 where id=#{id}")
    Boolean delete(Integer id);

}
