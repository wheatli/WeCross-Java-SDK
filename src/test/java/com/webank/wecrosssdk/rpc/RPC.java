package com.webank.wecrosssdk.rpc;

import com.webank.wecrosssdk.rpc.methods.ResourcesResponse;
import com.webank.wecrosssdk.rpc.methods.Response;
import com.webank.wecrosssdk.rpc.methods.TransactionResponse;

public class RPC {

    public static WeCrossRPC weCrossRPC;

    public static void main(String[] args) throws Exception {

        String server = "127.0.0.1:8080";

        WeCrossRPCService weCrossRPCService = new WeCrossRPCService(server);
        weCrossRPC = WeCrossRPC.init(weCrossRPCService);

        // test exists
        Response response = weCrossRPC.exists("payment.bcos2.HelloWorldContract").send();
        System.out.println("Test exists: " + response.toString());

        // list test
        ResourcesResponse resourcesResponse = weCrossRPC.list(true).send();
        System.out.println("Resources: " + resourcesResponse.getResources());

        // call test
        TransactionResponse callTransactionResponse =
                weCrossRPC
                        .call(
                                "payment.bcos2.HelloWorldContract",
                                "setAndgetConstant",
                                "hello world",
                                10086)
                        .send();
        System.out.println(
                "Test call: " + callTransactionResponse.getCallContractResult().toString());

        // sendTransaction test
        TransactionResponse sendTransactionResponse =
                weCrossRPC
                        .sendTransaction(
                                "payment.bcos2.HelloWorldContract",
                                "setAndget",
                                "hello world",
                                10086)
                        .send();
        System.out.println(
                "Test sendTransaction: "
                        + sendTransactionResponse.getCallContractResult().toString());
    }
}