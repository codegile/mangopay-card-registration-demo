package com.mangopay.demo;

/**
 * 19/02/16 18:18
 *
 * @author catalin.craciun
 */
public class CardRegistrationResponse {
    private String accessKey;
    private String baseURL;
    private String cardPreregistrationId;
    private String cardRegistrationURL;
    private String cardType;
    private String clientId;
    private String preregistrationData;


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getCardPreregistrationId() {
        return cardPreregistrationId;
    }

    public void setCardPreregistrationId(String cardPreregistrationId) {
        this.cardPreregistrationId = cardPreregistrationId;
    }

    public String getCardRegistrationURL() {
        return cardRegistrationURL;
    }

    public void setCardRegistrationURL(String cardRegistrationURL) {
        this.cardRegistrationURL = cardRegistrationURL;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPreregistrationData() {
        return preregistrationData;
    }

    public void setPreregistrationData(String preregistrationData) {
        this.preregistrationData = preregistrationData;
    }


    @Override
    public String toString() {
        return "CardRegistrationResponse{" +
                "accessKey='" + accessKey + '\'' +
                ", baseURL='" + baseURL + '\'' +
                ", cardPreregistrationId='" + cardPreregistrationId + '\'' +
                ", cardRegistrationURL='" + cardRegistrationURL + '\'' +
                ", cardType='" + cardType + '\'' +
                ", clientId='" + clientId + '\'' +
                ", preregistrationData='" + preregistrationData + '\'' +
                '}';
    }
}
