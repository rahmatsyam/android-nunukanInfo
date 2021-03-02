package io.github.rahsyarigami.infonunukan.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CornerRadiusImageView extends androidx.appcompat.widget.AppCompatImageView {

    float radius = 13.0f;
    private Path path;
    RectF rect;

    public CornerRadiusImageView(Context context) {
        super(context);
        init();
    }

    public CornerRadiusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CornerRadiusImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        path.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
