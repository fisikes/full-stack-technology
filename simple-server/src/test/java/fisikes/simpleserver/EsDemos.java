package fisikes.simpleserver;


import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsDemos {

    RestHighLevelClient client;

    @BeforeEach
    public void init() {
        // 创建带有用户名和密码的凭据提供者
        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "Huaun@2022"));

        // 创建 RestHighLevelClient 客户端
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.104.151", 9200, "http")
                ).setHttpClientConfigCallback(
                        httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                )
        );
    }


    @SneakyThrows
    @Test
    void test() {

        SearchRequest searchRequest = new SearchRequest("v2_exposure_domain")
                .source(new SearchSourceBuilder());

        final WildcardQueryBuilder queryBuilder = QueryBuilders.wildcardQuery("domain.keyword", "*.baidu.com");

        searchRequest.source()
                .size(1)
                .fetchSource("id",null)
                .query(queryBuilder);

        // 执行搜索请求
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        // 处理搜索响应
        final SearchHit[] hits = searchResponse.getHits().getHits();


        if (hits.length > 0) {
            System.out.println(true);
        }


    }
}
