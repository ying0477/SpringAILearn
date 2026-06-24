package com.rongqi.springai.tools;

import com.rongqi.springai.tools.service.FoodService;
import com.rongqi.springai.tools.service.ToolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTools {
    ChatClient chatClient;
    @BeforeEach
    public void init(@Autowired ChatModel chatModel) {
        chatClient = ChatClient.builder(chatModel).defaultTools(new FoodService(),new ToolService()).build();

    }
    @Test
    public void testTooles(@Autowired ChatClient.Builder chatClient){
        ChatClient build = chatClient.build();
        String result = build.prompt()
//                .user("武汉什么最好吃?")
//                .user("武汉今天雨大不大？")
                .tools(new FoodService())
                .call().content();
        System.out.println("result = " + result);
    }
}
