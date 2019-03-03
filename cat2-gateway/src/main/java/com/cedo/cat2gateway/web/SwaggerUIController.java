package com.cedo.cat2gateway.web;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SwaggerUIController {
    @Value("${springfox.documentation.swagger.v2.host:localhost}")
    private String gatewayHost;
    @Value("${server.port}")
    private String gatewayPort;
    @Value("${spring.application.name}")
    private String gatewayName;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/serviceurl")
    public List<String> serviceUrl() {
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @GetMapping("/swagger-resources")
    public List<SwaggerResource> swaggerResourceList() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            //过滤本身
            if (service.equalsIgnoreCase(gatewayName)) {
                continue;
            }
            resources.add(swaggerResource(service, "/" + service + "/api-docs"));
        }
        return resources;
    }

    @GetMapping("/{serviceName}/api-docs")
    public String apiDocs(@PathVariable String serviceName) {
        String url = "http://"+serviceName+"/v2/api-docs";
        String json = restTemplate.getForEntity(url, String.class).getBody();
        String serverUrl = gatewayHost + ":" + gatewayPort + "/" + serviceName;
        String startStr = "\"host\":\"";
        int startIndex = json.indexOf(startStr) + startStr.length();
        int endIndex = json.indexOf("\"", startIndex);
        json = json.substring(0, startIndex) + serverUrl + json.substring(endIndex);

        return json;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

    @GetMapping("/swagger-resources/configuration/ui")
    public String ui() {
        Map<String,Object> uiConfig = new HashMap<>(16);
        uiConfig.put("apisSorter","alpha");
        uiConfig.put("deepLinking",true);
        uiConfig.put("defaultModelExpandDepth",1);
        uiConfig.put("defaultModelRendering","example");
        uiConfig.put("defaultModelsExpandDepth",1);
        uiConfig.put("displayOperationId",false);
        uiConfig.put("displayRequestDuration",false);
        uiConfig.put("docExpansion","none");
        uiConfig.put("filter",false);
        uiConfig.put("jsonEditor",false);
        uiConfig.put("operationsSorter","alpha");
        uiConfig.put("showExtensions",false);
        uiConfig.put("showRequestHeaders",false);
        uiConfig.put("supportedSubmitMethods",new String[]{"get", "put", "post", "delete", "options", "head", "patch", "trace"});
        uiConfig.put("tagsSorter","alpha");
        uiConfig.put("validatorUrl","");
        return JSON.toJSONString(uiConfig);
    }

    @GetMapping("/swagger-resources/configuration/security")
    public String security() {
        return "{}";
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
