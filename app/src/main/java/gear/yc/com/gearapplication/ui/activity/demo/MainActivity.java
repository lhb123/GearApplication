package gear.yc.com.gearapplication.ui.activity.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import gear.yc.com.gearapplication.base.BaseActivity;
import gear.yc.com.gearapplication.R;
import gear.yc.com.gearlibrary.network.http.HttpInfo;

public class MainActivity extends BaseActivity {
    TextView hello_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello_tv = (TextView) findViewById(R.id.hello_tv);
        hello_tv.setOnClickListener(v -> Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", v1 -> hello_tv.setText("On Click Hello")).show());
        testOkHttp();

    }

    /**
     * git
     */
    public void testOkHttp(){
        try {
            HttpInfo.getInstance().getHttpOfGet("http://www.baidu.com",mHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            ExecutorService mExecutorS=Executors.newFixedThreadPool(3);
//            mExecutorS.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        String str = OkHttpManager.getInstance().getHttpOfGet("http://www.baidu.com").body().string();
//                        Message message =new Message();
//                        message.obj=str;
//                        mHandler.sendMessage(message);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//        OkHttpClient okHttpClient =new OkHttpClient();
//
//        FormBody formBodys=new FormBody.Builder()
//                .add("city","248").build();
//
//        final Request request =new Request.Builder()
//                .post(RequestBody.create(MediaType.parse("application/json"),"{\"module_id\":\"101\"}"))
//                .url("http://test.awu.cn/api/index.php?act=main").build();
//
//        final Call call=okHttpClient.newCall(request);
//



//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final Message message = new Message();
//                message.what = 1;
//                message.obj = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mHandler.sendMessage(message);
//                    }
//                });
//
//            }
//        });

    }

    Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            hello_tv.setText((String)msg.obj);
            return true;
        }
    });
}
