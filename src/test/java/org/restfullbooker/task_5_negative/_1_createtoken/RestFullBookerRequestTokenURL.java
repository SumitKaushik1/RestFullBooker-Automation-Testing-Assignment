package org.restfullbooker.task_5_negative._1_createtoken;


import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.Customer;

import static io.restassured.RestAssured.given;

public class RestFullBookerRequestTokenURL {

    // when the RestfulBookerTokenTestCases clas is need the response firstly the RestFullBookerRequestTokenURL class is loadeed
    //then all the static variables is loaded it means the methods is called automaticlally
    public static final Response response;

    static {

        //here is the called who is handling the exception
        //it is the good practice to intialize the static variable in the static block (in this you can intialize the final variable also
        // otherwise without static block  you have to intialize the static variable in same line where it is decalared )
        response=restFullBookerRequestTokenURLRequest();
    }
    static  Response restFullBookerRequestTokenURLRequest(){
            /* payload.setUsername("admin");
                     payload.setPassword("password123");*/

                   /*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*/
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network






        Customer customer=new Customer("admin","password123");//directly passing the object to body
        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(customer);
        RequestSpecification requestSpecification= given();


        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.body(payload);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        /* Response response=*/ // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object
        //Response response=
                return requestSpecification.when().post();
    }
}
