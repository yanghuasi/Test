package seekbar.ggh.com.myapplication.emaillogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import seekbar.ggh.com.myapplication.R;
import seekbar.ggh.com.myapplication.utils.WidgetUtils;

public class EmailLoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);
        Button buttonNormal = (Button) findViewById(R.id.btn_login);
        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showNormalDialog();
                showCustomizeDialog();
            }
        });
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(EmailLoginActivity.this);
        normalDialog.setIcon(R.drawable.scan_light);
        normalDialog.setTitle("");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
    private void showCustomizeDialog() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        final AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(EmailLoginActivity.this);
        final View dialogView = LayoutInflater.from(EmailLoginActivity.this)
                .inflate(R.layout.dialog_login,null);
        customizeDialog.setTitle("邮箱登录");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        EditText edit_text =
                                (EditText) dialogView.findViewById(R.id.et_mail);
                        //限制edittext输入内容，只能输入email格式
                        WidgetUtils.setEditTextInputString(edit_text,WidgetUtils.KEY_EMAIN);
                        EditText edit_text2 =
                                (EditText) dialogView.findViewById(R.id.et_password);
                        String content = edit_text.getText().toString();
                        if (content.contains("@") && content.contains(".com")) {

//                            class  Thread1 implements Runnable {
//                                public void run() {
//
//
//                                }
//                            }
//                            showWaitingDialog();//显示等待中的dialog
//                            startActivity(new Intent(EmailLoginActivity.this, EditActivity.class));
                            //输入接口
                            Toast.makeText(EmailLoginActivity.this,
                                    edit_text.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(EmailLoginActivity.this,
                                    edit_text2.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                customizeDialog.setCancelable(true);
            }
        });
        customizeDialog.show();
    }
    private void showWaitingDialog() {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
         */
        ProgressDialog waitingDialog=
                new ProgressDialog(EmailLoginActivity.this);
//        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }
}
