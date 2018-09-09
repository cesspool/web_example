package controller;

import dao.NewsDAO;
import model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {

    @Autowired
    private NewsDAO newsDAO;

    @RequestMapping(value = "/news",
                method = RequestMethod.GET,
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<News> getNews() {
        try {
            List<News> list = newsDAO.getAllNews();
            return list;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }


     @RequestMapping (value = "/news/category/{category}",
                method = RequestMethod.GET,
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
     @ResponseBody
     public List<News> getNewsByCategory(@PathVariable("category") String category) {
        try {
            List<News> list = newsDAO.getNewsByCategory(category);
            return list;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
     }

     @RequestMapping (value = "/news/name/{name}",
                method = RequestMethod.GET,
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
     @ResponseBody
     public List<News> getNewsByName(@PathVariable("name") String name) {
        try{
            List<News> list = newsDAO.getNewsByName(name);
            return list;
        } catch (Exception ex){
            ex.getMessage();
            return null;
        }
     }

    @RequestMapping (value = "/news/content/{content}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<News> getNewsByContent(@PathVariable("content") String content) {
        try{
            List<News> list = newsDAO.getNewsByContent(content);
            return list;
        } catch (Exception ex){
            ex.getMessage();
            return null;
        }
    }

    @RequestMapping (value = "/news",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public News addNews(@RequestBody News news) {
        return newsDAO.addNews(news);
    }

    @RequestMapping (value ="/news/{id}",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public News updateNews(@PathVariable("id") String id) {
        return newsDAO.updateNews(id);
    }

    @RequestMapping (value="/news/{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteNews(@PathVariable("id") String id) {
        newsDAO.deleteNews(id);
    }
}
