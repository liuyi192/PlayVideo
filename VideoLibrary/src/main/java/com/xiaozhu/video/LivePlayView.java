package com.xiaozhu.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

/**
 * @说明 直播
 * @作者 LY
 * @时间 2017/11/27 13:09
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class LivePlayView extends FrameLayout {
    private IjkVideoView videoView;
    private Context mContext;

    public LivePlayView(@NonNull Context context) {
        super(context, null);
    }

    public LivePlayView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
    }

    /**
     * 视频播放
     *
     * @param videoPath
     */
    public void play(String videoPath) {
        if (!TextUtils.isEmpty(videoPath)) {
            videoView.setVideoPath(videoPath);
        }
        videoView.start();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        videoView = new IjkVideoView(mContext);
        videoView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(videoView);
    }

    /**
     * 关闭播放
     */
    public void stopPlay(boolean mBackPressed) {
        if (mBackPressed || !videoView.isBackgroundPlayEnabled()) {
            videoView.stopPlayback();
            videoView.release(true);
            videoView.stopBackgroundPlay();
        } else {
            videoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();
    }

    public IjkVideoView getVideoView() {
        return videoView;
    }

    public void onPause() {
        if (videoView != null)
            videoView.pause();
    }

    public void onResume() {
        if (videoView != null)
            videoView.resume();
    }
}
