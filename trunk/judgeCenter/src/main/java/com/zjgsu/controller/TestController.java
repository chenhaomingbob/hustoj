package com.zjgsu.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjgsu.dto.ApiResult;
import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.service.common.TestService;
import com.zjgsu.service.zjgsu.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author chm 神魔法
 * @date 19-6-24 上午10:17
 */
@Controller()
@RequestMapping("/test")
public class TestController extends BaseController {

    @PostMapping("/userSubmit")
    @ResponseBody
    public ApiResult postUserSubmit(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = this.commonFaileResult();
        Integer userSubmitId = testService.UserSubmit(jsonObject);
        if (userSubmitId != null && userSubmitId > 0) {
            JSONObject dataJsonObject = new JSONObject();
            dataJsonObject.put("userSubmitId", userSubmitId);
            apiResult = this.successResult(null, dataJsonObject);
        }
        return apiResult;
    }

    @GetMapping("/judge")
    @ResponseBody
    public ApiResult getJudge(int submitId) {
        judgeService.judgeQuestion(submitId);
        return this.successResult("接受处理判题请求", null);
    }

    @GetMapping("/submitInfo")
    @ResponseBody
    public ApiResult getSubmitInfo(int submitId){
        UserScoreDTO userScoreDTO = testService.getSubmitInfo(submitId);
        return this.successResult(null, userScoreDTO);
    }

    @Autowired
    private TestService testService;
    @Autowired
    private JudgeService judgeService;
}

