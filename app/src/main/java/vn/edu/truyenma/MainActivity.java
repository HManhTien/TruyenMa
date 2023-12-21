package vn.edu.truyenma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.webkit.WebSettings;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;

    // khai bao các biến toàn cục nơi đây;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_menu();
            }
        });
    }
    public void chayweb(String index){

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Cho phép chạy mã JavaScript
        webView.loadUrl("file:///android_asset/"+index+".html");
    }
    public void Show_menu(){
        PopupMenu show_menu = new PopupMenu(this , btn);
        show_menu.getMenuInflater().inflate(R.menu.show_menu ,show_menu.getMenu());
        show_menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                txt = findViewById(R.id.textView);
                int itemId = item.getItemId();
               if(R.id.item1 == itemId){
                   txt.setText("Ma nữ");
                   chayweb("index");
               }else if (R.id.item2 == itemId) {
                   txt.setText("Số 2");
               }else if(R.id.item3== itemId){
                   txt.setText("Số 3");
               }else if(R.id.item4== itemId){
                   txt.setText("Số 4");
               }else{
                   txt.setText("Lỗi rồi");
               }
                return false;
            }
        });

        show_menu.show();
    }

}