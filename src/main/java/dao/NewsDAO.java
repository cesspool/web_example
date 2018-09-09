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
        Calendar myCalendar1 = new GregorianCalendar(2014, 2, 11);
        Calendar myCalendar2 = new GregorianCalendar(2015, 3, 24);
        Calendar myCalendar3 = new GregorianCalendar(2016, 4, 15);
        Calendar myCalendar4 = new GregorianCalendar(2017, 5, 17);


        News news1 = new News("N01", "box", "sport is something", myCalendar1.getTime() ,"sport");
        News news2 = new News("N02", "limitless", "fil was very interesting", myCalendar2.getTime(),"films");
        News news3 = new News("N03", "shrek", "cartoon was very fun", myCalendar3.getTime() ,"cartoons");
        News news4 = new News("N04", "yoga", "relas is healthy", myCalendar4.getTime(),"relax");
        News news5 = new News("N05", "lay", "fun is a fun", myCalendar3.getTime() ,"fun");
        News news6 = new News("N06", "school", "education helps people to be clever", myCalendar4.getTime(),"education");

        newsMap.put(news1.getNumNews(), news1);
        newsMap.put(news2.getNumNews(), news2);
        newsMap.put(news3.getNumNews(), news3);
        newsMap.put(news4.getNumNews(), news4);
        newsMap.put(news5.getNumNews(), news5);
        newsMap.put(news6.getNumNews(), news6);
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
            if (entry.getValue().getCategory().equals(category)) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

    public List<News> getNewsByName(String name) {
        List<News> news = new ArrayList<>();
        for (Map.Entry<String, News> entry : newsMap.entrySet()){
            if (entry.getValue().getName().equals(name)) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

    public List<News> getNewsByContent(String content) {
        List<News> news = new ArrayList<>();
        for (Map.Entry<String, News> entry : newsMap.entrySet()){
            if (entry.getValue().getContent().contains(content)) {
                news.add(entry.getValue());
            }
        }
        return news;
    }

}
