# rancher java api in processing
Any PR or issue is welcomed.

### How:

```  

    RancherAPI api = RancherAPI.init("RANCHER_URL", RANCHER_PORT,
                    "ACCESS_KEY",
                    "SECRET_KEY",
                    "PROJECT_ID");
                    
```

A `project` in the API is referred to as an environment in the UI and Rancher documentation.


```
    Container container = new Container();
    container.setName("testContainer");
    container.setImageUuid("docker:ubuntu:14.04.3");
    
    try{
        Container rstContainer = api.container.create(container);
        api.container.delete(rstContainer.getId());
    } catch (IOException e){
        log.error("error during rancher api operation");
    }
```

You can also use `WebsocketComponent` to listen to the message returned.  


```
    Stack stack = new Stack();
            stack.setName("testStackkk");
            stack.setDockerCompose("version: '2'\n" +
                    "services:\n" +
                    "  serviceName:\n" +
                    "    cap_add:\n" +
                    "    - ALL\n" +
                    "    image: imageUrl\n" +
                    "    environment:\n" +
                    "      example: example\n" +
                    "    extra_hosts:\n" +
                    "    - db.example.com:127.0.0.1\n" +
                    "    ports:\n" +
                    "    - 80:80/tcp\n");
    
            stack.setRancherCompose("RANCHER_COMPOSE_FILE_CONTENT");
    
            Stack stackRst = null;
            try {
                stackRst = api.stack.create(stack);
    
                RancherWebSocket webSocket = new FetchServicesWebSocket(stackRst.getId());
                WebSocketComponent component = new WebSocketComponent(api, webSocket);
                component.listen(600);
   
                webSocket = new FetchStackStateWebSocket(stackRst.getId());
                component = new WebSocketComponent(api, webSocket);
                component.listen(600);
    
            } catch (IOException e) {
                System.out.println("==========> stack create error");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("==========> websocket listening error");
                e.printStackTrace();
            }
            System.out.println("stack deployed successfully\n ");
    
```

Customize your websocket by extends `RancherWebSocket`.