package com.facets.app.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ParallelConnector extends Connector {
 List<NodeConnectorMetaInfo> connectorMetaInfoList;

 public ParallelConnector() {
  super(ConnectorType.PARALLEL);
 }
}
