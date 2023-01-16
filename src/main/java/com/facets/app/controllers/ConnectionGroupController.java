package com.facets.app.controllers;

import com.facets.app.models.ConnectionGroup;
import com.facets.app.models.FacetsResponseEntity;
import com.facets.app.services.ConnectionGroupService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/api/connectionGroup")
@Slf4j
public class ConnectionGroupController {

@Autowired
private ConnectionGroupService connectionGroupService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<FacetsResponseEntity<ConnectionGroup>> create(@RequestBody @NotNull ConnectionGroup
                                                                                connectionGroup) throws Exception {
        ConnectionGroup registeredConnectionGroup = connectionGroupService.createConnectionGroup(connectionGroup);
        return  ResponseEntity.ok(new FacetsResponseEntity<>(registeredConnectionGroup));
}

    @GetMapping(value = "/fetch/{nodeName}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<FacetsResponseEntity<ConnectionGroup>> fetchConnectionGroup(@PathVariable String nodeName)
        throws Exception {
    ConnectionGroup connectionGroup = connectionGroupService.fetchConnectionGroupForNode(nodeName);

    return ResponseEntity.ok(new FacetsResponseEntity<>(connectionGroup));

}

}
