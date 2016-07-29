package activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by herma on 05/06/2016.
 */
public class SquareImageView extends ImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }


    public SquareImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());

    }
}
