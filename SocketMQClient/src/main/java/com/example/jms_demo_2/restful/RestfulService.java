package com.example.jms_demo_2.restful;

import com.example.jms_demo_2.dto.request.SearchMgniRequest;
import com.example.jms_demo_2.dto.response.MgniListResponse;
import com.example.jms_demo_2.model.entity.Mgni;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestfulService {
    public static void getResponse(String request) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(request);

        String requestType = jsonObject.getString("requestType");

        JSONObject requestBodyJson = jsonObject.getJSONObject("request");
        String requestBody = JSONObject.valueToString(requestBodyJson);

        String response = "";

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/produce";
        ObjectMapper om=new ObjectMapper();
        om.findAndRegisterModules();
        switch (requestType) {

            case "search": {
                url += "/search";
                SearchMgniRequest searchMgniRequest=om.readValue(requestBody, SearchMgniRequest.class);
                List<Mgni> mgniList=restTemplate.postForObject(url,searchMgniRequest,List.class);
                response=om.writerWithDefaultPrettyPrinter().writeValueAsString(mgniList);
                System.out.println(response);
                break;
            }
            case "get": {
                MgniListResponse mgniList=restTemplate.getForObject(url,MgniListResponse.class);
                response=om.writerWithDefaultPrettyPrinter().writeValueAsString(mgniList);
                System.out.println(response);
                break;
            }

//            case "create": {
//                response = toString(transferService.createMgni(om.readValue(requestBody, DepositRequest.class)));
//                System.out.println(response);
//                break;
//            }
//            case "update": {
//                response = toString(transferService.updateMgni(jsonObject.getString("id"), om.readValue(requestBody, DepositRequest.class)));
//                System.out.println(response);
//                break;
//            }
//            case "delete": {
//                response = toString(transferService.deleteMgni(requestBodyJson.getString("id")));
//                System.out.println(response);
//                break;
//            }
            default: {
                System.out.println("請輸入有效查詢資料");
                break;
            }
        }
    }

}
