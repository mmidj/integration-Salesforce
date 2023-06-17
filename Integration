public class MedunnaAPIRequests {
    
    public static void getRoom(){
        
        
        //delivery guy
        
        HTTP http = new HTTP();
        
        HTTPRequest request = new HTTPRequest();
        
        //url, method, auth
        
        request.setEndpoint('https://medunna.com/api/rooms/417774');
        
        request.setMethod('GET');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc0OTE4OTMzfQ.AjROlyXlXS63ehxzJ7fZVRzPJjQ_0z-Z_yms5Nzy-U0hpRnYgQAHDjCVU9gKk6ryqx05F2RoiawH8Mdpsl9v3A');        
    
        HTTPResponse response = http.send(request);
    
       //1. way of converting  // json data
       Object apexObject =   JSON.deserializeUntyped(response.getBody());        
        
        System.debug('data : '+apexObject );
        
        //2. way of converting
        
        Map<String, Object> mapData =(Map<String, Object>) JSON.deserializeUntyped(response.getBody());
        
        System.debug('id : '+ mapData.get('id'));
        
        System.debug('room type : '+ mapData.get('roomType'));
         System.debug('desription : '+ mapData.get('description'));
        
        //3. way of converting from JSON to APEX
                         //json data
        Room room =(Room) JSON.deserialize(response.getBody(), Room.class);
        
        System.debug('room description : '+ room.description);
       
        System.debug('room price : '+ room.price);
        System.debug('room roomNumber : '+ room.roomNumber);
        System.debug('room roomType : '+ room.roomType);
        System.debug('room status : '+ room.status);
    }
    
    
    
    public static void roomPost(){
        
        
        HTTP http = new HTTP();
        
        String jsonData = '{"description":"Instructions of API  Web services by Ibrahim","price":180,"roomNumber":43266273,"roomType":"DELUXE","status":true}';
        
        HTTPRequest request = new HTTPRequest();
        
        //url, method, body, content-type, auth
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('POST');
        
        request.setBody(jsonData);
        
        request.setHeader('Content-Type', 'application/json');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc0OTE4OTMzfQ.AjROlyXlXS63ehxzJ7fZVRzPJjQ_0z-Z_yms5Nzy-U0hpRnYgQAHDjCVU9gKk6ryqx05F2RoiawH8Mdpsl9v3A');
    
        HTTPResponse response = http.send(request);    
        System.debug('status : '+response.getStatusCode() );
        
        System.debug('data : '+ response.getBody());
    }
    
    public static void roomPost2(){
        
        Room room = new Room();
        
        room.description = 'Ibrahim Salesforce integration class Amazing developers';
        
        room.price = 55;
        
        room.roomNumber = 63423263;
        
        room.roomType = 'TWIN';
        
        room.status = true;
        
        
        
        
        
        String data = JSON.serialize(room);
        
        HTTP http = new HTTP();
        
        HTTPRequest request = new HTTPRequest();
        //url, method,body,content-type, auth
        
        request.setEndpoint('https://medunna.com/api/rooms');
        
        request.setMethod('POST');
        
        request.setBody(data);
        
        request.setHeader('Content-Type', 'application/json');
        
        request.setHeader('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcnZlbC5ibGljayIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjc0OTE4OTMzfQ.AjROlyXlXS63ehxzJ7fZVRzPJjQ_0z-Z_yms5Nzy-U0hpRnYgQAHDjCVU9gKk6ryqx05F2RoiawH8Mdpsl9v3A');
        
        
        HttpResponse response = http.send(request);
        
        System.debug('status : '+ response.getStatusCode());
        System.debug('data : '+response.getBody() );
    }    
    
    
    public class Room{
        
      
        
        
   
    public String description;
    public Decimal price;
    public Integer roomNumber;
    public String roomType;
    public Boolean status;
        
        
        
    }
    
    
    
    
    
}
Collapse



8:53
Untitled
 
        
        API
        We use api for applications communication
        Request           Response 
        GET: 
        POST:
        PUT:
        PATCH
        DELETE
        Status Codes
        Send a GET request for a specific room 
        url / endpoint, Authorization, method 
        https://medunna.com/api/rooms/417774
        {
            
            "id": 417774,
            "roomNumber": 4360989,
            "roomType": "SUITE",
            "status": true,
            "price": 300.00,
            "description": "Mesut Post generation for room 2"
        }
        description=Mesut Post generation for room 2, id=417774, price=300, roomNumber=4360989, roomType=SUITE, status=true
        JSON.serialize
        class Room {
        String createdBy;
        String createdDate;
        Ineteger id;
        Integer roomNumber;
        String roomType;
        boolean status;
        decimal price;
        String description;
        }
        If you convert json data to Apex object, we call this deserialization
        JSON  to  APEX: deserialization
        APEX  to  JSON serialization
        Send a POST request for a single room
        url, method,body, auth, content-type
        POST: 
        endpoint: https://medunna.com/api/rooms
        body(data): 
                    {
                     
                      "description": "Instructions for API Web services by Ibrahim",
                      "price": 180,
                      "roomNumber": 43262367,
                      "roomType": "DELUXE",
                      "status": true
                    }
                    content-type: json
                    Auth: 
