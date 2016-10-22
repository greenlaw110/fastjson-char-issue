package com.greenlaw110;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FastJsonCharIssue {

    public void fastJson() {
        System.out.println("\nFastJSON");
        System.out.println("----------------------------------------------------------");
        String input = "{\"v\":[\" \", \"a\", \"b\", \"c\"]}";
        System.out.printf("input: %s\n", input);
        ModelWithCharArray model = JSON.parseObject(input, ModelWithCharArray.class);
        System.out.printf("model: %s\n", model);
    }

    public void jackson() throws Exception {
        System.out.println("\nJackson");
        System.out.println("----------------------------------------------------------");
        ObjectMapper mapper = new ObjectMapper();
        String input = "{\"v\":[\" \", \"a\", \"b\", \"c\"]}";
        System.out.printf("input: %s\n", input);
        ModelWithCharArray model = mapper.readValue(input, ModelWithCharArray.class);
        System.out.printf("model: %s\n", model);
    }

    public static void main(String[] args) throws Exception {
        new FastJsonCharIssue().jackson();
        new FastJsonCharIssue().fastJson();
    }

}

