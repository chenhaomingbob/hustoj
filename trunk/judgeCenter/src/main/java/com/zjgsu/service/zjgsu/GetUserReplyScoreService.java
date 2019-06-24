package com.zjgsu.service.zjgsu;

import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.entity.hustoj.SolutionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;

/**
 * @author chm 神魔法
 * @date 2019/6/4 14:01
 */
public interface GetUserReplyScoreService {

    UserScoreDTO getScoreByReplyId(int submitId);

    void updateProgramInfo(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity);
}
