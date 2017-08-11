package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    Path mPath1 = new Path();
    Path mPath2 = new Path();

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        // 这里 CCW 和 CW 没有影响
        mPath1.addCircle(200 + bitmap.getWidth() / 2 + 30, 200 + bitmap.getHeight() / 2 + 30, bitmap.getWidth() / 2 - 10, Direction.CCW);


        mPath2.addCircle(600 + bitmap.getWidth() / 2 + 30, 200 + bitmap.getHeight() / 2 + 30, bitmap.getWidth() / 2 - 10, Direction.CCW);
        mPath2.setFillType(FillType.INVERSE_WINDING);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.save();
        canvas.clipPath(mPath1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
