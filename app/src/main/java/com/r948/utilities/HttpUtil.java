package com.r948.utilities;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class HttpUtil {

    /**
     * 向指定 URL 发起一个 http 请求，请求方法为 post
     *
     * @param url  url
     * @param data data
     * @return http response body
     */
    public static String sendHttpPostRequest(@NonNull String url, @NonNull String subUrl, @NonNull String data) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(String.format(Locale.CHINA, "%s/%s/", url, subUrl)).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        try (OutputStream output = connection.getOutputStream()) {
            output.write(data.getBytes(StandardCharsets.UTF_8));
        }
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            for (String t; ; ) {
                if ((t = reader.readLine()) == null) break;
                buffer.append(t);
            }
        }
        connection.disconnect();
        return buffer.toString();
    }
}
