package com.louise.blog.service;

import com.louise.blog.dao.IBlogDao;
import com.louise.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//service位于DAO下一步，用于包装DAO的方法，使其更精准，更适用于此app
//只能有一个service文件（因为需要用这个service class来声明一个service在controller中使用）
//但是可以通过@Repository来创建不同的service，并给它们设置不同的名字
@Repository("myfirstservice")
public class BlogService {
    private final IBlogDao blogDao;

    @Autowired
    public BlogService(@Qualifier("BlogDao") IBlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public boolean addBlog(String content,String title){
        Blog b = new Blog(title,content);
        return blogDao.insertBlog(b);
    }

    public List<Blog> selectAllBlogs(){
        return blogDao.selectAllBlogs();
    }

    public Optional<Blog> selectBlogById(int id){
        return blogDao.selectBlogById(id);
    }

    public boolean updateBlog(int id, String title, String content){
        Blog b = new Blog(id,title,content);
        return blogDao.updateBlog(b);
    }

    public boolean deleteBlog(int id){
        return blogDao.deleteBlog(id);
    }
}
