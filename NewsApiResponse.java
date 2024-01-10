package news.example.news.outbound;

import java.util.List;

public class NewsApiResponse {
    private Pagination pagination;
    private List<NewsData> data;

    public List<NewsData> getData() {
        return data;
    }

    public void setData(List<NewsData> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
