package com.sven.feelingheader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreFooterLayout;
import com.sven.feelingheader.R;

/**
 * Created by Aspsine on 2015/9/2.
 */
public class FeelingFooter extends SwipeLoadMoreFooterLayout {
    private TextView tvLoadMore;
    private ImageView ivSuccess;
    private ProgressBar progressBar;

    private int mFooterHeight;

    public FeelingFooter(Context context) {
        this(context, null);
    }

    public FeelingFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeelingFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFooterHeight = getResources().getDimensionPixelOffset(R.dimen.load_more_footer_height_classic);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvLoadMore = (TextView) findViewById(R.id.tvLoadMore);
        ivSuccess = (ImageView) findViewById(R.id.ivSuccess);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }

    @Override
    public void onPrepare() {
        ivSuccess.setVisibility(GONE);
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            ivSuccess.setVisibility(GONE);
            progressBar.setVisibility(GONE);
            if (-y >= mFooterHeight) {
                tvLoadMore.setText("RELEASE TO LOAD MORE");
            } else {
                tvLoadMore.setText("SWIPE TO LOAD MORE");
            }
        }
    }

    @Override
    public void onLoadMore() {
        tvLoadMore.setText("LOADING MORE");
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(VISIBLE);
    }

    @Override
    public void onReset() {
        ivSuccess.setVisibility(GONE);
    }
}