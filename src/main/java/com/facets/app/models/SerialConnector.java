package com.facets.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SerialConnector extends Connector {



  private NodeConnectorMetaInfo connectorMetaInfo;


  public SerialConnector() {
    super(ConnectorType.SERIAL);
  }
}
