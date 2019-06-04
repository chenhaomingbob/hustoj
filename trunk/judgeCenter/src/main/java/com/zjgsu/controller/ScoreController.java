package com.zjgsu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author chm 神魔法
 * @date 2019/6/4 14:20
 */
@Controller
public class ScoreController {
    @GetMapping("/myTest")
    @ResponseBody
    public String myTest(@RequestParam("testId") String testId) {

        return testId;
    }

    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(ScoreController.class);
}
