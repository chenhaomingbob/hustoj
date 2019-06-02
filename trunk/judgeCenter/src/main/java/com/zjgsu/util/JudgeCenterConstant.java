package com.zjgsu.util;

/**
 * @author chm 神魔法
 * @date 2019/5/31 20:08
 */
public class JudgeCenterConstant {
    /**
     * mq  消息的关键字
     */
    public static final String QUESTION_WAITING_JUDGE = "QuestionWaitingJudge";
    /**
     * 文件分割符
     */
    public static final String FILE_SEPARATOR = "/";
    /**
     * 问题的标准测试输入,输出文件前缀 (这个只起到规范作用)
     * 注意：在hustoj中 标准输入文件和标准输出文件的前缀必须相同
     */
    public static final String PROBLEM_Test_FILE_NAME_PREFIX = "testPoint#";
    /**
     * 问题的标准测试输入文件后置 (这个会影响到hustoj judge的读取)
     */
    public static final String PROBLEM_INPUT_FILE_NAME_SUFFIX = ".in";
    /**
     * 问题的标准测试输出文件后置 (这个会影响到hustoj judge的读取)
     */
    public static final String PROBLEM_OUTPUT_FILE_NAME_SUFFIX = ".out";

}
