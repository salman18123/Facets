# Facets Node System

## Exposes 2 Apis 
1.create a connection group
```shell
Api Payload
   
   curl --location --request POST 'localhost:8080/api/connectionGroup' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"cg1",
    "nodes":[
        {
            "type":"BASIC_VIRTUAL_NODE",
            
            "name":"vNode1",
            "id":123,
            "nodeConnector":{
                "type":"SERIAL",
                "connectorMetaInfo":{
                    "name":"cn1",
                    "nodeName":"vNode2"
                }
            }
        },
        {
            
            "type":"BASIC_VIRTUAL_NODE",
            "name":"vNode2",
            "id":1234
            
        }
    ]
}'
```
2.search for a connection group 
  ```shell
   curl --location --request GET 'localhost:8080/api/connectionGroup/fetch/vNode2' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'
```

Swagger URL
   ```shell
   http://localhost:8080/swagger-ui/
```