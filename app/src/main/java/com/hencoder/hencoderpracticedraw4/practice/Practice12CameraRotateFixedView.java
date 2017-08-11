package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Camera mCamera = new Camera();
    Matrix mMatrix = new Matrix(); // 采用 Matrix 自定义操作顺序

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x1 = point1.x + bitmap.getWidth() / 2;
        int y1 = point1.y + bitmap.getHeight() / 2;
        int x2 = point2.x + bitmap.getWidth() / 2;
        int y2 = point2.y + bitmap.getHeight() / 2;


        canvas.save();
        mMatrix.reset();
//        mMatrix.preTranslate(-x1,-y1);
//        mMatrix.postTranslate(x1,y1);
//        canvas.concat(mMatrix);

        mCamera.save();
        mCamera.rotateX(30);
//        mCamera.applyToCanvas(canvas);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-x1,-y1);
        mMatrix.postTranslate(x1,y1);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        mMatrix.reset();
        mCamera.save();
        mCamera.rotateY(30);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-x2,-y2);
        mMatrix.postTranslate(x2,y2);

        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
