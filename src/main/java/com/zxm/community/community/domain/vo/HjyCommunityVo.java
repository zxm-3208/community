package com.zxm.community.community.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * @Auther: zxm
 * @Date: 2024/1/8 -  18:37
 * @Description: com.zxm.community.community.domain.vo
 * @version: 1.0
 */
public class HjyCommunityVo implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long communityId;

    /**
     * 小区名称
     */
    private String communityName;

    @Override
    public String toString() {
        return "HjyCommunityVo{" +
                "communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                '}';
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
