package com.xiaozhu.video;

/**
 * @说明 清晰度
 * @作者 LY
 * @时间 2017/7/28 下午9:42
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class Clarity {
    public String grade;    // 清晰度等级
    public String p;        // 270P、480P、720P、1080P、4K ...
    public String videoUrl; // 视频链接地址

    public Clarity(String grade, String p, String videoUrl) {
        this.grade = grade;
        this.p = p;
        this.videoUrl = videoUrl;
    }
}
