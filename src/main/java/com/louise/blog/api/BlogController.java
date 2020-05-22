package com.louise.blog.api;

import com.louise.blog.model.Blog;
import com.louise.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @PostMapping(path = "/update")
    public boolean updateBlog(@RequestBody Blog blog){
        return service.updateBlog(blog.getId(),blog.getTitle(),blog.getBody());
    }

    @GetMapping(path = "/getSingle/{id}")
    public Optional<Blog> getSingleBlog(@PathVariable int id){
        return service.selectBlogById(id);
    }

    @GetMapping(path = "/delete/{id}")
    public boolean deleteBlog(@PathVariable int id){
        return service.deleteBlog(id);
    }

}
