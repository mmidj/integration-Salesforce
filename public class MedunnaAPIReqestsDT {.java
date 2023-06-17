public class MedunnaAPIReqestsDT {
    
    
    public static void getUser(){
        
        HTTP http = new HTTP();
        
        HTTPRequest request = new HTTPRequest();
        
        request.setEndpoint('https://medunna.com/api/user?ssn=872-85-6654');
        request.setMethod('GET');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');
        
        HTTPResponse response  = http.send(request);
        //status code, body
        
        
        //JSON to APEX : deserialization
        //1. way
        Map<String,Object> mapData =(Map<String, Object>) JSON.deserializeUntyped(response.getBody());
        
        /*
        System.debug('firstname : '+ mapData.get('firstName'));
        System.debug('lastname : '+ mapData.get('lastName'));
        */
        //2. way
        User user =(User) JSON.deserialize(response.getBody(), User.class);
        
        System.debug('user login : '+ user.login);
        System.debug('email : '+ user.email);
        System.debug('ssn : '+ user.ssn);
    }
    
    
    
    
    public static void getUsers(){
        
        
        HTTP http = new HTTP();
        
        HTTPRequest request = new HTTPRequest();
        
        request.setEndpoint('https://medunna.com/api/users');
        
        request.setMethod('GET');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');
        
        HTTPResponse response = http.send(request);
        
        
        User [] users =(User[]) JSON.deserialize(response.getBody(), User[].class);
        
        
        for(User w: users){
            
            System.debug('firstname : '+ w.firstname);
            System.debug('lastname : '+ w.lastname);
            System.debug('email : '+ w.email);
        }
        
        
        
        
        
        
    }
    
    
    /*
     * {
    "id": 415620,
    "login": "john_doe11",
    "firstName": "John",
    "lastName": "Doe",
    "ssn": "872-85-6654",
    "email": "john11@doe.com",
    "imageUrl": null,
    "activated": false,
    "langKey": null,
    "createdBy": null,
    "createdDate": null,
    "lastModifiedBy": null,
    "lastModifiedDate": null,
    "authorities": null
}
     */
    
    public class User{
        
    
    public String login;
    public String firstName;
    public String lastName;
    public String ssn;
    public String email;
    public Boolean activated;
    public String langKey;
    
        
        
        
    }
    
    
    
    
    
}
Collapse



white_check_mark
eyes
raised_hands





8:42
Untitled
 
public class MedunnaRoomRequestsDT02 {
    
    public static void postRoom(){
        
        String jsonData = '{"description":"Ibrahim DT room creation","price":100,"roomNumber":5423653,"roomType":"TWIN","status":true}';
        
        
        HTTP http = new HTTP();
        
        
        HTTPRequest request = new HTTPRequest();
        //url, method, auth, body, content type
        
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('POST');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');
        
        //1. way
        request.setBody(jsonData);
        
        request.setHeader('Content-Type', 'application/json');
        
        
        HTTPResponse response = http.send(request);
        //status code, body
        
        
        System.debug('status code : '+response.getStatusCode() );
        System.debug('data : '+ response.getBody());
        
        
        
    }
    
    
    public static void postRoom2(){
        
        Room room = new Room();
        
        room.description = 'Ibrahim second room post request';
        
        room.price = 200;
        
        room.roomType = 'DELUXE';
        
        room.roomNumber = 53125253;
        
        room.status = true;
        
        HTTP http = new HTTP();
        
        
        HTTPRequest request = new HTTPRequest();
        //url, method, auth, body, content type
        
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('POST');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');
        
        //2. way
        request.setBody(JSON.serialize(room));
        
        request.setHeader('Content-Type', 'application/json');
        
        
        HTTPResponse response = http.send(request);
        //status code, body
        
        
        System.debug('status code : '+response.getStatusCode() );
        System.debug('data : '+ response.getBody());
        
        
        
    }
    
    
    
    
    
    public static void putRoom(){
        
        String jsonData = '{"description":"Ibrahim put request","id" : 418537,"price":300,"roomNumber":73246273,"roomType":"PREMIUM_DELUXE","status":true}';
        
        HTTP http = new HTTP();
        
        
        HTTPRequest request  = new HTTPRequest();
        
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('PUT');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');        
        
        request.setBody(jsonData);
        
        request.setHeader('Content-Type', 'application/json');
        
        HTTPResponse response = http.send(request);
        //status code, body
        
        System.debug('status code : '+response.getStatusCode() );
        
        System.debug('data : '+response.getBody() );
    }
    
     public static void putRoom2(){
        
         Room room = new Room();
         
         room.description = 'Instructor final update for the room';
         room.price = 350;
         room.roomType = 'TWIN';
         room.roomNumber = 46253632;
         room.status = true;
         room.id = 418537;
         
        
        HTTP http = new HTTP();
        
        
        HTTPRequest request  = new HTTPRequest();
        
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('PUT');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');        
        //2. way
        request.setBody(JSON.serialize(room));
        
        request.setHeader('Content-Type', 'application/json');
        
        HTTPResponse response = http.send(request);
        //status code, body
        
        System.debug('status code : '+response.getStatusCode() );
        
        System.debug('data : '+response.getBody() );
    }
    
    
    
    
    public static void deleteRoom(){
        
        
        HTTP http = new HTTP();
        
        HTTPRequest request = new HTTPRequest();
        
        //url, method, header
        
        request.setEndpoint('https://medunna.com/api/rooms/418537');
        
        request.setMethod('DELETE');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc1NDM3NDQxfQ.Ig405d1Rjj1H4GchFHgab7O_1xdKPaDEsaH1z8DKIB60nk9_zOjYRz0srNrgyfT0ShZdekp1VOK7VZ4seGQ7nA');
        
        
        HTTPResponse response = http.send(request);
        
        System.debug('status code : '+response.getStatusCode() );        
        
    }
    
    
    public class Room{
    /*    
        {
 
  "description": "string",
  "id": 0,
  "price": 0,
  "roomNumber": 0,
  "roomType": "TWIN",
  "status": true
}
       */ 
        
       public String  description;
       public Integer id;
       public Decimal price;
       public Integer roomNumber;
       public String  roomType;
       public Boolean status;
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}