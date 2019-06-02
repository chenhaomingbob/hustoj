# hustoj -- 流行的开源OJ系统。
### 本人的按照学校需求，进行二次开发
##### fork时，hustoj的最新修改
----
>2019-5-18 修订：16.04以上版本FB显示异常。 [基于OpenJudger的Windows集成便携版](https://github.com/>Azure99/WinHustOJ/releases) [浙传网盘](https://pan.cuz.edu.cn:8443/share/>287448cfc1b7f8b0073b1e11a7)
---

### 系统环境
-  ubuntu16  
-  mysql5.7
-  ~~php~~(干掉->Java Java天下第一)
-  ~~nginx~~(tomcat)

### 至2019-5-31 
- 数据库中添加了测试点表
- 修改了 <font color=red size=4> *trunk/core/judge_client/judge_client.cc* </font> 代码完成了在mysql数据库中，并添加了与之对应的日志.
### 至2019-6-2
- 搭建了Java端
- 成功脱离hustoj的php后台，完成judge的评判
- 准备入手完成其他几种类型题目的评判
### TODO
- [x] 将core与web代码分离，并删除php部分,再使其能适合我之后新搭建的后台
- [ ] 再次基于上增加评判选择题，填空等
- [x] 目前发现hustoj在创建本地评测文件时，只能通过http请求其php后台，搭建号平台后需要删除。

