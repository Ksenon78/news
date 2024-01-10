package news.example.news.response;

import java.util.Map;

public class NewsResponse {

    private Integer page;
    private Integer size;
    private Map<String, Double> quotes;

    public NewsResponse() {
    }

    public NewsResponse(Integer page, Integer size, Map<String, Double> quotes) {
        this.page = page;
        this.size = size;
        this.quotes = quotes;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Double> quotes) {
        this.quotes = quotes;
    }
}
