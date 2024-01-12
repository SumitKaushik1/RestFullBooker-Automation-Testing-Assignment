package org.restfullbooker.task_3_positive._3_GitId;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.bookingidToUpdate;
import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.deletedbookingid;
import static org.restfullbooker.task_3_positive._1_getallbooking.RestFullBookerGetAllBookingTestCases.bookingidToUpdate1;

public class RestFullBookerGetIdURL {

    static Response restfullBookerGetidgURL() throws JsonProcessingException {

        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        System.out.println(bookingidToUpdate1);
        requestSpecification.basePath("/booking/"+bookingidToUpdate1);


        Response response = requestSpecification.get();
        // Printing Response as string
        System.out.println(response.asString());

        return response;


    }
}
