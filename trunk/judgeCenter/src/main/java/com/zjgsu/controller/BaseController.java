package com.zjgsu.controller;

import com.zjgsu.dto.ApiResult;
import com.zjgsu.util.ApiResultStatus;
import org.apache.commons.lang3.StringUtils;

/**
 * @author chm 神魔法
 * @date 2019/6/1 19:02
 */
public class BaseController {
    protected ApiResult successResult(String message, Object data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ApiResultStatus.SUCCESS);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }

    protected ApiResult commonFaileResult() {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(ApiResultStatus.SERVICE_ERROR);
        apiResult.setMessage("服务器出错");
        return apiResult;
    }

}
