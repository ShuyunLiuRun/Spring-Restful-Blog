package com.louise.blog.api;

import com.louise.blog.model.Blog;
import com.louise.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8001")
@RequestMapping("api/blog")
@RestController
public class BlogController {
    private final BlogService service;

    @Autowired
    //通过@Qualifier，按名字找到这个service
    public BlogController(@Qualifier("myfirstservice") BlogService service) {
        this.service = service;
    }


    @PostMapping
    public void addBlog(@RequestBody Blog blog){
        service.addBlog(blog.getBody(), blog.getTitle());
    }

    @GetMapping
    public List<Blog> getAllBlog(){

        return service.selectAllBlogs();
    }



}
