# Mangopay card registration demo

This is a basic demo of card registration using Mangopay payment platform. It has only one endpoint:

```
GET /card-registration
```

This returns the following JSON:

```javascript
{
  "accessKey": "1X0m87dmM2LiwFgxPLBJ",
  "baseURL": "https://api.sandbox.mangopay.com",
  "cardPreregistrationId": "12444838",
  "cardRegistrationURL": "https://homologation-webpayment.payline.com/webpayment/getToken",
  "cardType": "CB_VISA_MASTERCARD",
  "clientId": "sdk-unit-tests",
  "preregistrationData": "ObMObfSdwRfyE4QClGtUc6um8zvFYamY_t-LNSwKAxBisfd7z3cTgS83cCwyP9Gp7qGR3aNxrLUiPbx-Z--VxQ"
}
```

Basically, this creates a new CardRegistration object, which can be used by any client to make a test payment (it is used by demo apps of Mangopay, available on GitHub). It is configured with the same credentials as on all server-side test suites.

This is deployed on the following URL:
```
http://demo-mangopay.rhcloud.com/card-registration
```
