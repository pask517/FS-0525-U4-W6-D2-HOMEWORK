package andreapascarella.u5d7homework.services;

import andreapascarella.u5d7homework.entities.Blog;
import andreapascarella.u5d7homework.exceptions.NotFoundException;
import andreapascarella.u5d7homework.payloads.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class BlogsService {
    private List<Blog> blogsDB = new ArrayList<>();

    public List<Blog> findAllBlogs() {
        return this.blogsDB;
    }

    public Blog saveBlog(NewBlogPayload payload) {
        Blog newBlog = new Blog(payload.getBlogCategory(), payload.getTitle(), payload.getCover(), payload.getContent(), payload.getReadingTime());
        this.blogsDB.add(newBlog);
        log.info("L'utente " + newBlog.getId() + " è stato aggiunto correttamente");
        return newBlog;
    }

    public Blog findById(long blogId) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public Blog findByIdAndUpdate(Long blogId, NewBlogPayload payload) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (Objects.equals(blog.getId(), blogId)) {
                found = blog;
                found.setCover(payload.getCover());
                found.setBlogCategory(payload.getBlogCategory());
                found.setTitle(payload.getTitle());
                found.setContent(payload.getContent());
                found.setReadingTime(payload.getReadingTime());
            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public void findByIdAndDelete(long blogId) {
        Blog found = null;
        for (Blog blog : this.blogsDB) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        this.blogsDB.remove(found);
    }
}
