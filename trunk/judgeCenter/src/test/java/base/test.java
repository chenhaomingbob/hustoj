package base;

import com.alibaba.fastjson.JSON;
import com.zjgsu.dao.hustoj.SolutionTestPointsDao;
import com.zjgsu.dao.zjgsu.QuestionTestPointDao;
import com.zjgsu.dto.AnswerDTO;
import com.zjgsu.dto.UserReplyListDTO;
import com.zjgsu.entity.hustoj.SolutionTestPointsEntity;
import com.zjgsu.entity.zjgsu.QuestionTestPointEntity;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chm 神魔法
 * @date 2019/6/1 18:21
 */
public class test {
    @Test
    public void test111() {
        List<Integer> integerList;

    }
    @Test
    public void test1() {
        String code = "#include <stdio.h> \n" +
                "int main() \n" +
                "{ \n" +
                "    int a,b; \n" +
                "    scanf(\"%d %d\",&a, &b); \n" +
                "    printf(\"%d\\n\",a+b); \n" +
                "    return 0; \n" +
                "} ";
        System.out.println(code);
    }

    @Test
    public void test2() {
//        String fileName = "E:/Hub/Code/ZJGS/test.in";
//        File file = new File(fileName);
//        FileUtils.writeLines();

    }

    @Test
    public void test44() {
        UserReplyListDTO answerListDTO = new UserReplyListDTO();
        List<AnswerDTO> userReplyList = answerListDTO.getUserReplyList();
        userReplyList = new ArrayList<>();
        AnswerDTO answerDTO1 = new AnswerDTO();
        answerDTO1.setAnswer("123");
        answerDTO1.setNumber(123);
        userReplyList.add(answerDTO1);
        AnswerDTO answerDTO2 = new AnswerDTO();
        answerDTO2.setAnswer("123");
        answerDTO2.setNumber(143);
        userReplyList.add(answerDTO2);
        answerListDTO.setUserReplyList(userReplyList);
        System.out.printf(JSON.toJSONString(answerListDTO));
    }

    @Test
    public void test3() {
        String test = "{\"userReplyList\":[{\"answer\":\"123\",\"number\":123},{\"answer\":\"\",\"number\":123}]}";
        UserReplyListDTO userReplyListDTO = JSON.parseObject(test,UserReplyListDTO.class);
        List<AnswerDTO> userReplyList = userReplyListDTO.getUserReplyList();
        for (AnswerDTO answerDTO : userReplyList) {
            System.out.println(answerDTO.getNumber()+";"+answerDTO.getAnswer());
        }
    }

    @Test
    public void test33() {
        String test = "/home/judge/data/1000/testPoint#1.in";

        int i = test.lastIndexOf(".");
        System.out.println(test.substring(i-1,i));
    }

}
