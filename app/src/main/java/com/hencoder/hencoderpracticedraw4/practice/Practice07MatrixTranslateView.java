package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice07MatrixTranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice07MatrixTranslateView(Context context) {
        super(context);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07MatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Matrix mMatrix1 = new Matrix();
//    Matrix mMatrix2 = new Matrix(); // Matrix 可以通过reset方法后复用

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);


//        mMatrix1.postTranslate(-100,-100);
//        mMatrix2.postTranslate(200,100);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        // 使用 Matrix 前一定要reset!!!否则会出现问题
        mMatrix1.reset();
        mMatrix1.postTranslate(-100, -100);
        canvas.concat(mMatrix1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
//        canvas.concat(mMatrix2);
        mMatrix1.reset();
        mMatrix1.postTranslate(200, 100);
        canvas.concat(mMatrix1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
