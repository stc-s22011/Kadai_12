package jp.suntech.s22011.Kadai_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // buttonオブジェクト取得
        Button btSend=findViewById(R.id.btSend);
        Button btConfirm=findViewById(R.id.btConfirm);
        Button btClear=findViewById(R.id.btClear);

        // インスタンスを生成
        ClickListener listener=new ClickListener();

        // ボタンにリスナ設定
        btSend.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
        btConfirm.setOnClickListener(listener);
    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //EditText取得 p104
            EditText inputName=findViewById(R.id.etName);
            EditText inputMail=findViewById(R.id.etMail);
            EditText inputMailTitle=findViewById(R.id.etMailTitle);
            EditText inputComment=findViewById(R.id.etComment);

            // 押されてたボタン取得
            int id=v.getId();

            if(id==R.id.btSend){// 送信
                // 入力された文字取得
                String NameStr=inputName.getText().toString();
                String MailStr=inputMail.getText().toString();
                String MailTitleStr=inputMailTitle.getText().toString();
                String CommentStr=inputComment.getText().toString();

                // トーストの表示
                String show = "名前："+NameStr+", メールアドレス："+MailStr+", タイトル："+MailTitleStr+", 質疑応答："+CommentStr;
                Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();

            }else if(id==R.id.btClear){ // クリア
                inputName.setText("");
                inputMail.setText("");
                inputMailTitle.setText("");
                inputComment.setText("");

            }else if(id==R.id.btConfirm){ // 確認
                ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
            }

        }
    }
}