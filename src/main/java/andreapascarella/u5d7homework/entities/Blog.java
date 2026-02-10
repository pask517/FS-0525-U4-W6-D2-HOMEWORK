package andreapascarella.u5d7homework.entities;

import andreapascarella.u5d7homework.enums.BlogCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Blog {

    private Long id;
    private BlogCategory blogCategory;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public Blog(BlogCategory blogCategory, String title, String cover, String content, int readingTime) {
        this.blogCategory = blogCategory;
        this.title = title;
        this.cover = "https://www.google.com/url?q=https://picsum.photos/200/300";
        this.content = content;
        this.readingTime = readingTime;
        Random rndm = new Random();
        this.id = rndm.nextLong(1, 1000);
    }
}
