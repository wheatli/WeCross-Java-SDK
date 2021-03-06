package com.webank.wecrosssdk.rpc;

import com.webank.wecrosssdk.rpc.methods.response.GetDataResponse;
import com.webank.wecrosssdk.rpc.methods.response.SetDataResponse;
import com.webank.wecrosssdk.rpc.service.WeCrossRPCService;
import com.webank.wecrosssdk.rpc.service.WeCrossService;

public class GetAndSetTest {

    public static void main(String[] args) throws Exception {

        String server = "127.0.0.1:8250";

        WeCrossService weCrossService = new WeCrossRPCService(server);
        WeCrossRPC weCrossRPC = WeCrossRPC.init(weCrossService);

        // getData test
        System.out.println("*************** getData ***************");
        GetDataResponse getDataResponse =
                weCrossRPC.getData("payment.bcos.HelloWeCross", "get").send();
        System.out.println("Result: " + getDataResponse.toString());

        // setData test
        System.out.println("*************** getData ***************");
        SetDataResponse setDataResponse =
                weCrossRPC.setData("payment.bcos.HelloWeCross", "set", "data").send();
        System.out.println("Result: " + setDataResponse.toString());
    }
}
