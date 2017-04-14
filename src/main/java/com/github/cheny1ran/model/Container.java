package com.github.cheny1ran.model;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/7.
 */

@Data
public class Container implements Serializable {

    private static final long serialVersionUID = -936142514251466806L;

    public static final String NAMESPACE = "/containers";

    private String id;

    /**
     * the options are stop remove
     */
    @NotNull
    private String instanceTriggeredStop = "stop";

    private boolean startOnCreate = true;

    private boolean publishAllPorts = false;

    private boolean privileged = false;

    private boolean stdinOpen = true;

    private boolean tty = true;

    private boolean readOnly = false;

    private String networkMode = "managed";

    private List<Container> dataVolumesFrom = new ArrayList<Container>();

    private List<String> dataVolumes = new ArrayList<String>();

    private List<String> dns = new ArrayList<String>();

    private List<String> dnsSearch = new ArrayList<String>();

    private List<Enum> capAdd = new ArrayList<Enum>();

    private List<Enum> capDrop = new ArrayList<Enum>();

    private List<String> devices = new ArrayList<String>();

    private LogConfig logConfig = new LogConfig();

    @NotNull
    private String imageUuid;

    private List<String> ports = new ArrayList<String>();

    private Map<String, Instance> instanceLinks = new HashMap<String, Instance>();

    private Map<String, String> labels = new HashMap<String, String>();

    private String name;

    private Map<String, String> environment = new HashMap<String, String>();

    private Integer count;

    private Integer createIndex;

    private String deploymentUnitUuid;

    private String description;

    private String externalId;

    private Date firstRunning;

    private String hostname;

    private Integer memoryReservation;

    private Integer milliCpuReservation;

    private Integer startCount;

    private String volumeDriver;

    private String workingDir;

    private String user;

    private String domainName;

    private Integer memorySwap;

    private Integer memory;

    private String cpuSet;

    private Integer cpuShares;

    /**
     * the options are host
     */
    private Enum pidMode;

    private Integer blkioWeight;

    private String cgroupParent;

    private String usernsMode;

    private Integer pidsLimit;

    private Integer diskQuota;

    private Integer cpuCount;

    private Integer cpuPercent;

    private Integer ioMaximumIOps;

    private Integer ioMaximumBandwidth;

    private Integer cpuPeriod;

    private Integer cpuQuota;

    private String cpuSetMems;

    private String isolation;

    private Integer kernelMemory;

    private Integer memorySwappiness;

    private Integer shmSize;

    private String uts;

    private String ipcMode;

    private String stopSignal;

    private Integer oomScoreAdj;

    private String ip;

    private String ip6;

    private Integer healthInterval;

    private Integer healthTimeout;

    private Integer healthRetries;

    private Host requestHostId;

    private List<String> command;

    private List<String> extraHosts;

    private DockerBuild build;
}