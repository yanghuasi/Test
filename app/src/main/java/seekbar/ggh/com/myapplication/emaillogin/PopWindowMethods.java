package seekbar.ggh.com.myapplication.emaillogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import seekbar.ggh.com.myapplication.R;

public class PopWindowMethods extends Activity {
    private View mPopView;
    private PopupWindow mPopupWindow;
    private Button btn_pop_ok;
    private Button btn_pop_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_layout);

        InitPopWindow();
        InitView();
        InitClick();
    }

    /**
     *
     */
    private void InitClick() {
        // TODO Auto-generated method stub
        btn_pop_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "ok", 0).show();
            }
        });

        btn_pop_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "cancel", 0).show();
            }
        });
    }

    /**
     *
     */
    private void InitPopWindow() {
        // TODO Auto-generated method stub
        // 将布局文件转换成View对象，popupview 内容视图
        mPopView = getLayoutInflater().inflate(R.layout.popwindow_layout, null);
        // 将转换的View放置到 新建一个popuwindow对象中
        mPopupWindow = new PopupWindow(mPopView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 点击popuwindow外让其消失
        mPopupWindow.setOutsideTouchable(true);
        // mpopupWindow.setBackgroundDrawable(background);

    }

    /**
     *
     */
    private void InitView() {
        btn_pop_ok = (Button) mPopView.findViewById(R.id.btn_pop_ok);
        btn_pop_cancel = (Button) mPopView.findViewById(R.id.btn_pop_cancel);

    }

    @SuppressLint("NewApi")
    public void ShowPopWindow(View view) {
        if (mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        } else {
            // 设置PopupWindow 显示的形式 底部或者下拉等
            // 在某个位置显示
            mPopupWindow.showAtLocation(mPopView, Gravity.BOTTOM, 0, 30);
            // 作为下拉视图显示
            // mPopupWindow.showAsDropDown(mPopView, Gravity.CENTER, 200, 300);
        }

    }

}
