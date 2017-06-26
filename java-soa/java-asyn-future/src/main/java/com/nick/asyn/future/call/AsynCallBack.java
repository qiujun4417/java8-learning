package com.nick.asyn.future.call;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.CompletableFuture;

/**
 * Created by ningyang on 2017/6/26.
 */
public class AsynCallBack {

    public CloseableHttpAsyncClient httpAsyncClient;

    public AsynCallBack(CloseableHttpAsyncClient httpAsyncClient){
        this.httpAsyncClient = httpAsyncClient;
    }

    public CompletableFuture<String> getHttpData(String url){
        CompletableFuture asynFuture = new CompletableFuture();
        HttpPost post = new HttpPost(url);
        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(post);
        AsyncCharConsumer<HttpResponse> consumer = new AsyncCharConsumer<HttpResponse>() {
            HttpResponse response;

            @Override
            protected void onCharReceived(CharBuffer charBuffer, IOControl ioControl) throws IOException {

            }

            @Override
            protected void onResponseReceived(HttpResponse httpResponse) throws HttpException, IOException {
                this.response = httpResponse;
            }

            @Override
            protected HttpResponse buildResult(HttpContext httpContext) throws Exception {
                return response;
            }
        };

        FutureCallback<HttpResponse> callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                try {
                    asynFuture.complete(EntityUtils.toString(response.getEntity()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Exception e) {

            }

            @Override
            public void cancelled() {

            }
        };
        httpAsyncClient.execute(producer, consumer, callback);
        return asynFuture;
    }

}
