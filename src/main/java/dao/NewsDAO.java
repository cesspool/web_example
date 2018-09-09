package dao;

import model.News;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class NewsDAO {

    private static final Map<String, News> newsMap = new HashMap<>();

    static {
        initNews();
    }

    private static void initNews() {
        Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
        News news1 = new News("N01", "sport", "first", myCalendar.getTime() ,"sport");
        News news2 = new News("N02", "another", "second", myCalendar.getTime(),"notSport");

        newsMap.put(news1.getNumNews(), news1);
        newsMap.put(news2.getNumNews(), news2);
    }

    public List<News> getAllNews() {
        Collection<News> n = newsMap.values();
        List<News> allNews = new ArrayList<>();
        allNews.addAll(n);
        return allNews;
    }

    public void deleteNews(String numNews) {
        newsMap.remove(numNews);
    }

    public News updateNews(String id) {
        News updatedNews = newsMap.get(id);
        newsMap.replace(updatedNews.getNumNews(), updatedNews);
        return  updatedNews;
    }

    public News addNews(News someNews) {
        newsMap.put(someNews.getNumNews(),someNews);
        return  someNews;
    }

    public List<News> getNewsByCategory(String category) {
        List<News> news = new ArrayList<>();
        for (Map.Entry<String, News> entry : newsMap.entrySet()){
            if (entry.getValue().getCategory() == category) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

    public List<News> getNewsByName(String name) {
        List<News> news = new ArrayList<>();
        for (Map.Entry<String, News> entry : newsMap.entrySet()){
            if (entry.getValue().getName() == name) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

    public List<News> getNewsByContent(String content) {
        List<News> news = new ArrayList<>();
        for (Map.Entry<String, News> entry : newsMap.entrySet()){
            if (entry.getValue().getContent() == content) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

}
