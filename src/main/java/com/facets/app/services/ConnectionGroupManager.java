package com.facets.app.services;

import com.facets.app.exceptions.ConnectionGroupValidationException;
import com.facets.app.exceptions.InvalidNodeException;
import com.facets.app.exceptions.NodeAlreadyRegisteredException;
import com.facets.app.models.ConnectionGroup;

import com.facets.app.models.Node;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConnectionGroupManager {

    private Map<String,String> nodeToConnectionGroupMap;

    private Map<String,ConnectionGroup> connectionGroupMap;

   @PostConstruct
    public void setUp(){
        nodeToConnectionGroupMap = new HashMap<>();
        connectionGroupMap = new HashMap<>();
    }


    public void registerNodesToConnectionGroup(ConnectionGroup connectionGroup) throws NodeAlreadyRegisteredException {
        List<Node> nodes = connectionGroup.getNodes();
        for (Node node : nodes) {
            if (nodeToConnectionGroupMap.containsKey(node.getName())) {
                throw new NodeAlreadyRegisteredException();
            }
            nodeToConnectionGroupMap.put(node.getName(),connectionGroup.getName());
        }
    }

    public ConnectionGroup registerConnectionGroup(ConnectionGroup connectionGroup) throws ConnectionGroupValidationException {
        if(connectionGroupMap.containsKey(connectionGroup.getName())){
            throw new ConnectionGroupValidationException();
        }
        connectionGroupMap.put(connectionGroup.getName(), connectionGroup);
        return connectionGroup;
    }

    public ConnectionGroup getConnectionGroupFromNode(String nodeName)throws Exception {
        if(!nodeToConnectionGroupMap.containsKey(nodeName)){
            throw new InvalidNodeException();
        }
        String connectionGroupName = nodeToConnectionGroupMap.get(nodeName);
        return connectionGroupMap.get(connectionGroupName);
    }
}
