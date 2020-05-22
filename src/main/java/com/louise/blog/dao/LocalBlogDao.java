package com.louise.blog.dao;

import com.louise.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("localBlogDao")
public class LocalBlogDao implements IBlogDao{
    private static List<Blog> DB = new ArrayList<>();

    public LocalBlogDao() {
        DB.add(new Blog("First Blog","Blog body"));
    }

    @Override
    public boolean insertBlog(Blog blog) {
        DB.add(blog);
        return true;
    }

    @Override
    public List<Blog> selectAllBlogs() {
        return DB;
    }

    @Override
    public Optional<Blog> selectBlogById(int id) {
        try{
            for(Blog b:DB){
            if(b.getId() == id){
                return Optional.of(b);
            }
        }
        }catch (Exception e){
            return Optional.empty();
        }
        return Optional.empty();

    }

    @Override
    public boolean updateBlog( Blog blog) {
        return false;
    }

    @Override
    public boolean deleteBlog(int id) {
        for(Blog b : DB){
            if(b.getId()==id){
                DB.remove(b);
            }
        }
        return true;
    }
}
