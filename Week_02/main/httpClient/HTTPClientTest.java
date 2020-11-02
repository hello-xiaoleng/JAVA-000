package httpClient;

import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author chen jia
 * @date 2020/10/28 20:59
 */
public class HTTPClientTest {


    private static final String URL = "http://www.dongfangfuli.com/gw/app/categoryGoods/getCategoryGoodsList";

    public static void main(String[] args) {
        httpClient(URL);
        okHttp(URL);
    }

    private static void okHttp(String url) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url(url)
                .post(RequestBody.create("{\"cityId\":145,\"platform\":0,\"lowerPriceLimit\":\"\",\"priceCap\":\"\",\"sortField\":\"1\",\"categoryIdList\":[\"3\"],\"channelId\":\"2\",\"pageNumber\":1,\"pageSize\":20,\"goodsType\":\"0\",\"brandName\":\"\",\"wordsName\":\"\"}", mediaType))
                .build();
        Call call = okHttpClient.newCall(request);
        try (Response response = call.execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void httpClient(String url) {
        // 获得Http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(new StringEntity("{\"cityId\":145,\"platform\":0,\"lowerPriceLimit\":\"\",\"priceCap\":\"\",\"sortField\":\"1\",\"categoryIdList\":[\"3\"],\"channelId\":\"2\",\"pageNumber\":1,\"pageSize\":20,\"goodsType\":\"0\",\"brandName\":\"\",\"wordsName\":\"\"}", "UTF-8"));


        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            HttpEntity httpEntity = response.getEntity();
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
