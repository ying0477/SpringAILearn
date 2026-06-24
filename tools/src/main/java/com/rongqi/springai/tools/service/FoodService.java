package com.rongqi.springai.tools.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class FoodService {
    @Tool(description = "什么最好吃",name = "food")
    public String recommend(@ToolParam(description = "城市名")String city){
        return "热干面";
    }
    @Tool(description = "查询雨量")
    public String queryrain(@ToolParam(description = "城市") double city) {
        return "武汉没有下雨";
    }
}
