package andreapascarella.u5d7homework.controllers;

import andreapascarella.u5d7homework.entities.Blog;
import andreapascarella.u5d7homework.payloads.NewBlogPayload;
import andreapascarella.u5d7homework.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    private final BlogsService blogsService;

    @Autowired
    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload newBlogPayload) {
        return this.blogsService.saveBlog(newBlogPayload);
    }

    @GetMapping
    public List<Blog> findAllBlogs() {
        return this.blogsService.findAllBlogs();
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable Long blogId) {
        return this.blogsService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    public Blog getBlogByIdAndUpdate(@PathVariable long blogId, @RequestBody NewBlogPayload payload) {
        return this.blogsService.findByIdAndUpdate(blogId, payload);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void getBlogByIdAndDelete(@PathVariable long blogId) {
        this.blogsService.findByIdAndDelete(blogId);
    }
}
