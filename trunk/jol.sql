/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.131
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 192.168.3.131:3306
 Source Schema         : jol

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 31/05/2019 14:08:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for balloon
-- ----------------------------
DROP TABLE IF EXISTS `balloon`;
CREATE TABLE `balloon`  (
  `balloon_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 0,
  PRIMARY KEY (`balloon_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for compileinfo
-- ----------------------------
DROP TABLE IF EXISTS `compileinfo`;
CREATE TABLE `compileinfo`  (
  `solution_id` int(11) NOT NULL DEFAULT 0,
  `error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`solution_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest`  (
  `contest_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `private` tinyint(4) NOT NULL DEFAULT 0,
  `langmask` int(11) NOT NULL DEFAULT 0 COMMENT 'bits for LANG to mask',
  `password` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `user_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`contest_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contest_problem
-- ----------------------------
DROP TABLE IF EXISTS `contest_problem`;
CREATE TABLE `contest_problem`  (
  `problem_id` int(11) NOT NULL DEFAULT 0,
  `contest_id` int(11) NULL DEFAULT NULL,
  `title` char(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `num` int(11) NOT NULL DEFAULT 0,
  `c_accepted` int(11) NOT NULL DEFAULT 0,
  `c_submit` int(11) NOT NULL DEFAULT 0,
  INDEX `Index_contest_id`(`contest_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of contest_problem
-- ----------------------------
INSERT INTO `contest_problem` VALUES (1000, 0, '', 0, 0, 0);

-- ----------------------------
-- Table structure for custominput
-- ----------------------------
DROP TABLE IF EXISTS `custominput`;
CREATE TABLE `custominput`  (
  `solution_id` int(11) NOT NULL DEFAULT 0,
  `input_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`solution_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog`  (
  `user_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ip` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  INDEX `user_log_index`(`user_id`, `time`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginlog
-- ----------------------------
INSERT INTO `loginlog` VALUES ('admin', 'no save', '192.168.3.1', '2019-05-30 02:26:41');
INSERT INTO `loginlog` VALUES ('admin', 'login ok', '192.168.3.1', '2019-05-30 02:26:48');
INSERT INTO `loginlog` VALUES ('admin', 'login ok', '192.168.3.1', '2019-05-31 12:49:07');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail`  (
  `mail_id` int(11) NOT NULL AUTO_INCREMENT,
  `to_user` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `from_user` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `new_mail` tinyint(1) NOT NULL DEFAULT 1,
  `reply` tinyint(4) NULL DEFAULT 0,
  `in_date` datetime(0) NULL DEFAULT NULL,
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  PRIMARY KEY (`mail_id`) USING BTREE,
  INDEX `uid`(`to_user`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` datetime(0) NOT NULL DEFAULT '2016-05-13 19:24:00',
  `importance` tinyint(4) NOT NULL DEFAULT 0,
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for online
-- ----------------------------
DROP TABLE IF EXISTS `online`;
CREATE TABLE `online`  (
  `hash` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ip` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `ua` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `refer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `lastmove` int(10) NOT NULL,
  `firsttime` int(10) NULL DEFAULT NULL,
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`hash`) USING HASH,
  UNIQUE INDEX `hash`(`hash`) USING HASH
) ENGINE = MEMORY CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for printer
-- ----------------------------
DROP TABLE IF EXISTS `printer`;
CREATE TABLE `printer`  (
  `printer_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `in_date` datetime(0) NOT NULL DEFAULT '2018-03-13 19:38:00',
  `status` smallint(6) NOT NULL DEFAULT 0,
  `worktime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `printer` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'LOCAL',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`printer_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege`  (
  `user_id` char(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `rightstr` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N'
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('admin', 'administrator', 'N');
INSERT INTO `privilege` VALUES ('admin', 'p1000', 'N');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `problem_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `input` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `output` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `sample_input` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `sample_output` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `spj` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `hint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `source` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `in_date` datetime(0) NULL DEFAULT NULL,
  `time_limit` int(11) NOT NULL DEFAULT 0,
  `memory_limit` int(11) NOT NULL DEFAULT 0,
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  `accepted` int(11) NULL DEFAULT 0,
  `submit` int(11) NULL DEFAULT 0,
  `solved` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`problem_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1000, 'A+B Problem', '<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">Calculate a+b</span>', '<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">Two integer a&#44;b (0≤ a&#44;b≤ 10)</span>', '<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">Output a+b</span>', '1 2', '3', '0', '<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">Q: Where are the input and the output? A: Your program shall always read input from stdin (Standard Input) and write output to stdout (Standard Output). For example&#44; you can use \'scanf\' in C or \'cin\' in C++ to read from stdin&#44; and use \'printf\' in C or \'cout\' in C++ to write to stdout. You shall not output any extra data to standard output other than that required by the problem&#44; otherwise you will get a \"Wrong Answer\". User programs are not allowed to open and read from/write to files. You will get a \"Runtime Error\" or a \"Wrong Answer\" if you try to do so. Here is a sample solution for problem 1000 using C++/G++:&nbsp;</span><br />\r\n<pre class=\"prettyprint lang-cpp\">#include &lt;iostream&gt; \r\nusing namespace std; \r\nint  main() \r\n{ \r\n    int a&#44;b; \r\n    cin &gt;&gt; a &gt;&gt; b; \r\n    cout &lt;&lt; a+b &lt;&lt; endl; \r\n    return 0; \r\n} </pre>\r\n<br />\r\n<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">It\'s important that the return type of main() must be int when you use G++/GCC&#44;or you may get compile error. Here is a sample solution for problem 1000 using C/GCC:&nbsp;</span><br />\r\n<pre class=\"prettyprint lang-cpp\">#include &lt;stdio.h&gt; \r\nint main() \r\n{ \r\n    int a&#44;b; \r\n    scanf(\"%d %d\"&#44;&amp;a&#44; &amp;b); \r\n    printf(\"%d\\n\"&#44;a+b); \r\n    return 0; \r\n} </pre>\r\n<br />\r\n<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">Here is a sample solution for problem 1000 using PASCAL:&nbsp;</span><br />\r\n<span style=\"color:#333333;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">program p1000(Input&#44;Output);&nbsp;&nbsp;</span><br />\r\n<pre class=\"prettyprint lang-pl\">var  \r\n  a&#44;b:Integer;  \r\nbegin  \r\n   Readln(a&#44;b);  \r\n   Writeln(a+b);  \r\nend. </pre>', '', '2019-05-30 02:28:29', 0, 32, 'Y', 15, 15, 0);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` datetime(0) NOT NULL DEFAULT '2016-05-13 19:24:00',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `topic_id` int(11) NOT NULL,
  `status` int(2) NOT NULL DEFAULT 0,
  `ip` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE,
  INDEX `author_id`(`author_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for runtimeinfo
-- ----------------------------
DROP TABLE IF EXISTS `runtimeinfo`;
CREATE TABLE `runtimeinfo`  (
  `solution_id` int(11) NOT NULL DEFAULT 0,
  `error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`solution_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of runtimeinfo
-- ----------------------------
INSERT INTO `runtimeinfo` VALUES (1001, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1002, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1003, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1004, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1005, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1006, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1007, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1008, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1009, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1010, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1011, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1012, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=1ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1013, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1014, 'time_space_table:\n/1000/sample.in: mem=1120k time=0ms\n/1000/test.in: mem=1120k time=0ms\n\n');
INSERT INTO `runtimeinfo` VALUES (1015, 'time_space_table:\n/1000/sample.in: mem=1120k time=1ms\n/1000/test.in: mem=1120k time=1ms\n\n');

-- ----------------------------
-- Table structure for share_code
-- ----------------------------
DROP TABLE IF EXISTS `share_code`;
CREATE TABLE `share_code`  (
  `share_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `share_code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `language` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `share_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`share_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sim
-- ----------------------------
DROP TABLE IF EXISTS `sim`;
CREATE TABLE `sim`  (
  `s_id` int(11) NOT NULL,
  `sim_s_id` int(11) NULL DEFAULT NULL,
  `sim` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for solution
-- ----------------------------
DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution`  (
  `solution_id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_id` int(11) NOT NULL DEFAULT 0,
  `user_id` char(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` int(11) NOT NULL DEFAULT 0,
  `memory` int(11) NOT NULL DEFAULT 0,
  `in_date` datetime(0) NOT NULL DEFAULT '2016-05-13 19:24:00',
  `result` smallint(6) NOT NULL DEFAULT 0,
  `language` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `ip` char(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `contest_id` int(11) NULL DEFAULT 0,
  `valid` tinyint(4) NOT NULL DEFAULT 1,
  `num` tinyint(4) NOT NULL DEFAULT -1,
  `code_length` int(11) NOT NULL DEFAULT 0,
  `judgetime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `pass_rate` decimal(3, 2) UNSIGNED NOT NULL DEFAULT 0.00,
  `lint_error` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `judger` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'LOCAL',
  PRIMARY KEY (`solution_id`) USING BTREE,
  INDEX `uid`(`user_id`) USING BTREE,
  INDEX `pid`(`problem_id`) USING BTREE,
  INDEX `res`(`result`) USING BTREE,
  INDEX `cid`(`contest_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1016 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of solution
-- ----------------------------
INSERT INTO `solution` VALUES (1001, 1000, 'admin', 0, 1120, '2019-05-30 02:28:57', 4, 0, '192.168.3.1', 0, 1, -1, 126, '2019-05-30 17:28:57', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1002, 1000, 'admin', 0, 1120, '2019-05-31 12:50:03', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 12:50:04', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1003, 1000, 'admin', 1, 1120, '2019-05-31 12:51:20', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 12:51:20', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1004, 1000, 'admin', 0, 1120, '2019-05-31 12:53:08', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 12:53:08', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1005, 1000, 'admin', 0, 1120, '2019-05-31 13:06:27', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:06:28', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1006, 1000, 'admin', 1, 1120, '2019-05-31 13:11:00', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:11:00', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1007, 1000, 'admin', 0, 1120, '2019-05-31 13:12:26', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:12:27', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1008, 1000, 'admin', 1, 1120, '2019-05-31 13:13:24', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:13:25', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1009, 1000, 'admin', 1, 1120, '2019-05-31 13:14:34', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:14:35', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1010, 1000, 'admin', 0, 1120, '2019-05-31 13:15:15', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:15:16', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1011, 1000, 'admin', 0, 1120, '2019-05-31 13:16:37', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:16:38', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1012, 1000, 'admin', 1, 1120, '2019-05-31 13:24:45', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:24:46', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1013, 1000, 'admin', 0, 1120, '2019-05-31 13:27:02', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:27:03', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1014, 1000, 'admin', 0, 1120, '2019-05-31 13:52:42', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 13:52:43', 1.00, 0, 'admin');
INSERT INTO `solution` VALUES (1015, 1000, 'admin', 1, 1120, '2019-05-31 14:06:30', 4, 1, '192.168.3.1', 0, 1, -1, 126, '2019-05-31 14:06:31', 1.00, 0, 'admin');

-- ----------------------------
-- Table structure for solution_test_points
-- ----------------------------
DROP TABLE IF EXISTS `solution_test_points`;
CREATE TABLE `solution_test_points`  (
  `test_point_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `solution_id` int(11) NULL DEFAULT NULL COMMENT '用户提交的id',
  `test_point_input_file` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '测试点的输入文件',
  `test_point_output_file` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '测试点的标准输出文件',
  `test_point_result` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '测试点的AC情况',
  `test_point_use_time` int(11) NULL DEFAULT NULL COMMENT '测试点的用例使用时间',
  `test_point_use_memory` int(255) NULL DEFAULT NULL COMMENT '测试点的用例使用内存',
  `test_point_judge_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '测试点的评判时间',
  PRIMARY KEY (`test_point_record_id`) USING BTREE,
  INDEX `idx_solution_id`(`solution_id`) USING BTREE COMMENT '根据业务得出'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of solution_test_points
-- ----------------------------
INSERT INTO `solution_test_points` VALUES (1, 1000, 'asd', 'asd', '3', 100, 100, '2019-05-31 11:15:02');
INSERT INTO `solution_test_points` VALUES (2, 1011, 'home/judge/data/1000/sample.in', '/home/judge/data/1000/sample.out', '4', 0, 1146880, '2019-05-31 13:20:21');
INSERT INTO `solution_test_points` VALUES (3, 1011, 'home/judge/data/1000/sample.in', '/home/judge/data/1000/sample.out', '4', 0, 1146880, '2019-05-31 13:20:25');
INSERT INTO `solution_test_points` VALUES (4, 1013, '/home/judge/data/1000/sample.in', '/home/judge/data/1000/sample.out', '4', 0, 1146880, '2019-05-31 13:27:03');
INSERT INTO `solution_test_points` VALUES (5, 1013, '/home/judge/data/1000/test.in', '/home/judge/data/1000/test.out', '4', 0, 1146880, '2019-05-31 13:27:03');
INSERT INTO `solution_test_points` VALUES (6, 1014, '/home/judge/data/1000/sample.in', '/home/judge/data/1000/sample.out', '4', 0, 1146880, '2019-05-31 13:52:43');
INSERT INTO `solution_test_points` VALUES (7, 1014, '/home/judge/data/1000/test.in', '/home/judge/data/1000/test.out', '4', 0, 1146880, '2019-05-31 13:52:43');
INSERT INTO `solution_test_points` VALUES (8, 1015, '/home/judge/data/1000/sample.in', '/home/judge/data/1000/sample.out', '4', 1, 1120, '2019-05-31 14:06:31');
INSERT INTO `solution_test_points` VALUES (9, 1015, '/home/judge/data/1000/test.in', '/home/judge/data/1000/test.out', '4', 1, 1120, '2019-05-31 14:06:31');

-- ----------------------------
-- Table structure for source_code
-- ----------------------------
DROP TABLE IF EXISTS `source_code`;
CREATE TABLE `source_code`  (
  `solution_id` int(11) NOT NULL,
  `source` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`solution_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source_code
-- ----------------------------
INSERT INTO `source_code` VALUES (1001, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1002, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1003, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1004, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1005, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1006, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1007, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1008, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1009, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1010, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1011, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1012, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1013, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1014, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code` VALUES (1015, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');

-- ----------------------------
-- Table structure for source_code_user
-- ----------------------------
DROP TABLE IF EXISTS `source_code_user`;
CREATE TABLE `source_code_user`  (
  `solution_id` int(11) NOT NULL,
  `source` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`solution_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source_code_user
-- ----------------------------
INSERT INTO `source_code_user` VALUES (1001, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1002, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1003, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1004, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1005, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1006, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1007, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1008, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1009, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1010, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1011, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1012, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1013, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1014, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');
INSERT INTO `source_code_user` VALUES (1015, '#include <stdio.h> \r\nint main() \r\n{ \r\n    int a,b; \r\n    scanf(\"%d %d\",&a, &b); \r\n    printf(\"%d\\n\",a+b); \r\n    return 0; \r\n} ');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varbinary(60) NOT NULL,
  `status` int(2) NOT NULL DEFAULT 0,
  `top_level` int(2) NOT NULL DEFAULT 0,
  `cid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NOT NULL,
  `author_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `cid`(`cid`, `pid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `submit` int(11) NULL DEFAULT 0,
  `solved` int(11) NULL DEFAULT 0,
  `defunct` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  `ip` varchar(46) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `accesstime` datetime(0) NULL DEFAULT NULL,
  `volume` int(11) NOT NULL DEFAULT 1,
  `language` int(11) NOT NULL DEFAULT 1,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reg_time` datetime(0) NULL DEFAULT NULL,
  `nick` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `school` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '', 15, 1, 'N', '192.168.3.1', '2019-05-31 12:49:07', 1, 1, '711zqN2eUF/XeECCryuXI92Neq1lYWNj', '2019-05-30 02:26:41', 'admin', '');

-- ----------------------------
-- Triggers structure for table sim
-- ----------------------------
DROP TRIGGER IF EXISTS `simfilter`;
delimiter ;;
CREATE TRIGGER `simfilter` BEFORE INSERT ON `sim` FOR EACH ROW begin
 declare new_user_id varchar(64);
 declare old_user_id varchar(64);
 select user_id from solution where solution_id=new.s_id into new_user_id;
 select user_id from solution where solution_id=new.sim_s_id into old_user_id;
 if old_user_id=new_user_id then
	set new.s_id=0;
 end if;
 
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
