package com.facets.app.services;

import com.facets.app.models.ConnectionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionGroupService {

    @Autowired
    private ConnectionGroupManager connectionGroupManager;


    public ConnectionGroup createConnectionGroup(ConnectionGroup connectionGroup) throws Exception {
        connectionGroupManager.registerNodesToConnectionGroup(connectionGroup);
        return connectionGroupManager.registerConnectionGroup(connectionGroup);
    }

    public ConnectionGroup fetchConnectionGroupForNode(String node) throws Exception {
        return connectionGroupManager.getConnectionGroupFromNode(node);
    }
}
