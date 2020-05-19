package com.louise.blog.dao;

import com.louise.blog.model.Blog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBlogDao {
    //CRUD
    //Create
    boolean insertBlog(Blog blog);
    //Read
    List<Blog> selectAllBlogs();
    Optional<Blog> selectBlogById(UUID id);
    //Update
    boolean updateBlog(UUID id, Blog blog);
    //Delete
    boolean deleteBlog(UUID id);
}
