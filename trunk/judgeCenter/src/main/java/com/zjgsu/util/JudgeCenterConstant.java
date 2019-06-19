package com.zjgsu.util;

/**
 * @author chm 神魔法
 * @date 2019/5/31 20:08
 */
public class JudgeCenterConstant {
    /**
     * ip
     */
    public static String HOST_IP = null;
    /**
     * name
     */
    public static String HOST_NAME = null;
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
    /**
     * 测试文件的类型 输入
     */
    public static final int TEST_FILE_INPUT_TYPE = 1;
    /**
     * 测试文件的类型 输出
     */
    public static final int TEST_FILE_OUTPUT_TYPE = 2;

    /**
     * question type-填空
     */
    public static final int QUESTION_TYPE_NORMAL_FILL=1;
    /**
     * question type-选择题
     */
    public static final int QUESTION_TYPE_CHOICE=2;
    /**
     * question type-判断
     */
    public static final int QUESTION_TYPE_JUDGMENT=3;
    /**
     * question type-程序填空题
     */
    public static final int QUESTION_TYPE_PROGRAM_FILL=4;
    /**
     * question type-程序改错
     */
    public static final int QUESTION_TYPE_PROGRAM_CORRECTION=5;
    /**
     * question type-编程题
     */
    public static final int QUESTION_TYPE_PROGRAM=6;

    /**
     * 用户提交已被评判
     */
    public static final int USER_SUBMIT_STATUS_FINISHED=1;

}
