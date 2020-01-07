package com.cloudwalk.entry;

import lombok.Data;

@Data
public class DataLinkPushBody {
    private String flowId;
    private String upNodeProject;
    private String upNodeIp;
    private String upNodePort;
    private String upNodeUrl;
    private String upNodeType;
    private String currentNodeProject;
    private String currentNodeIp;
    private String currentNodePort;
    private String currentNodeUrl;
    private String currentNodeType;
    private String downNodeProject;
    private String downNodeIp;
    private String downNodePort;
    private String downNodeUrl;
    private String downNodeType;
    private String dataKeyId;
    private String dataItemId;
    private String dataTime;
    private String nodeTime;
}
