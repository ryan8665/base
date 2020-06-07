package com.nsoft.backendchannel.impl;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nsoft.ApplicationConfig;
import com.nsoft.backendchannel.BackendConnector;
import com.nsoft.backendchannel.model.message.Message;
import com.nsoft.backendchannel.model.message.rest.RestMessageRequest;
import com.nsoft.backendchannel.model.message.rest.RestMessageResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.logging.Level;


public class BackenedConnectorRest implements BackendConnector {

    private final static Logger log = Logger.getLogger(BackenedConnectorRest.class);
    private ApplicationConfig applicationConfig;
    private RestTemplate restTemplate;


    @Override
    public Message executeRequest(Message requestMessage) {
        if (requestMessage == null || !(requestMessage instanceof RestMessageRequest)) {
            log.error("Error, Bad requestMessage found in BackenedConnectorRest.executeRequest(Message requestMessage)."
                    + " requestMessage-->[" + requestMessage + "]");
//            throw new BadRequestException();
        }
        RestMessageRequest request = (RestMessageRequest) requestMessage;
        try {
            URI requestUri = new URI(request.getUri());
            log.info("Sending rest to Uri ---> "+request.getUri());
            Gson og = new Gson();
            String requestJson = og.toJson(request);
            log.info("requestJson ---> "+requestJson);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

//            String requestStr = request.getMessage();
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestJson, headers);
            log.info("Sending rest message... request.toString()-->[" + request.toString() + "] , "
                    + "requets.getMessage()-->[" + request.getMessage() + "]");
            ResponseEntity<String> responseEntity = restTemplate.exchange(requestUri, request.getHttpMethod(),
                    requestEntity, String.class);
            log.info("Receiving rest message... result-->[" + responseEntity.getBody() + "]");
            String responseStr = responseEntity.getBody();
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new StringReader(responseStr));
            reader.setLenient(true);
            RestMessageResponse responseObj;

//            if (requestMessage instanceof CurrencyStatementRequest) {
//                JsonParser parser = new JsonParser();
//                JsonArray jsonArray = parser.parse(responseStr).getAsJsonArray();
//                JsonObject object = new JsonObject();
//                object.add("statementDto", jsonArray);
//                responseObj = (RestMessageResponse) gson.fromJson(object, request.getResponseClass());
//            } else {
//                responseObj = (RestMessageResponse) gson.fromJson(responseStr, request.getResponseClass());
//            }

            responseObj = (RestMessageResponse) gson.fromJson(responseStr, request.getResponseClass());

            return responseObj;
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(BackenedConnectorRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException();
        } catch (ResourceAccessException ex) {
            logResponseCreationException(request, ex);
            throw new RuntimeException();
        } catch (Exception ex) {
            logResponseCreationException(request, ex);
            throw new RuntimeException();
        }
    }

    private void logResponseCreationException(RestMessageRequest request, Exception ex) {
        log.error("Exception occured whitle trying to instantiate rest response message. "
                + "request.toString-->[" + request.toString() + "] , "
                + "request.getMessage()-->[" + request.getMessage() + "]", ex);
    }

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }



    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
