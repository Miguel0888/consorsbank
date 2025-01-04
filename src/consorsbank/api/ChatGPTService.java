package consorsbank.api;

import okhttp3.*;

import java.io.IOException;

public class ChatGPTService {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "DEIN_API_KEY";

    public String sendMessage(String message) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String jsonRequest = "{"
                + "\"model\": \"gpt-4\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]"
                + "}";

        RequestBody body = RequestBody.create(jsonRequest, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
