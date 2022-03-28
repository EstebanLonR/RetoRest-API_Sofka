package com.co.sofka.model;

import java.util.List;
import java.util.Map;

public class Requests {
    private static Map<String, String> requestHeaders;
    private static String userEndPoint;
    private static String bodyRequest;
    private static String[] response;

    public static List<String> getMessageResponseRegister() {
        return messageResponseRegister;
    }

    public static void setMessageResponseRegister(List<String> messageResponseRegister) {
        Requests.messageResponseRegister = messageResponseRegister;
    }

    private static List<String> messageResponseRegister;


    public static String getBodyRequest() {
        return bodyRequest;
    }

    public static void setBodyRequest(String bodyRequest) {
        Requests.bodyRequest = bodyRequest;
    }

    public static String[] getResponse() {
        return response;
    }

    public static void setResponse(String[] response) {
        Requests.response = response;
    }

    public static Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public static void setRequestHeaders(Map<String, String> requestHeaders) {
        Requests.requestHeaders = requestHeaders;
    }

    public static String getUserEndPoint() {
        return userEndPoint;
    }

    public static void setUserEndPoint(String userEndPoint) {
        Requests.userEndPoint = userEndPoint;
    }


}
