package com.louise.blog.dao;

import com.louise.blog.model.Blog;

import java.util.List;
import java.util.Optional;


public interface IBlogDao {
    //CRUD
    //Create
    boolean insertBlog(Blog blog);
    //Read
    List<Blog> selectAllBlogs();
    Optional<Blog> selectBlogById(int id);
    //Update
    boolean updateBlog(int id, Blog blog);
    //Delete
    boolean deleteBlog(int id);
}
