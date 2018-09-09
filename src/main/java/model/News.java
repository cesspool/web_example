package model;

import java.util.Date;

public class News {
    private String numNews;
    private String name;
    private String content;
    private Date publicationDate;
    private String category;

    public News() {}

    public News(String numNews, String name, String content, Date publicationDate, String category) {
        this.numNews = numNews;
        this.name = name;
        this.content = content;
        this.publicationDate = publicationDate;
        this.category = category;
    }

    public String getNumNews() {
        return numNews;
    }

    public void setNumNews(String numNews) {
        this.numNews = numNews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
