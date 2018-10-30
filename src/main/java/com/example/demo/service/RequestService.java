package com.example.demo.service;

import java.util.Hashtable;
import java.util.Map;
import com.example.demo.util.HttpClient;

public class RequestService {
    String url = "http://10.17.252.3:9764/services/zfw_build_poly_service.HTTPEndpoint";

    public String getPoly(int rownum, int rownum_start) {
        String action ="";//"/_postselectbuildpoly";
        Map<String, Integer> map = new Hashtable<>();
        map.put("rownum", rownum);
        map.put("rownum_start", rownum_start);
        String result = HttpClient.doPost(url + action, map);
        return result;
    }
}
