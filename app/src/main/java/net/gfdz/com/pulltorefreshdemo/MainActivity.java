package net.gfdz.com.pulltorefreshdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import net.gfdz.com.pulltorefreshdemo.bean.Datas;
import net.gfdz.com.pulltorefreshdemo.utils.CommonAdapter;
import net.gfdz.com.pulltorefreshdemo.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private PullToRefreshListView pullToRefreshListView;
    private CommonAdapter adapter=null;
    private List<Datas> list01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list01=new ArrayList<>();
        Datas d=new Datas();
        d.setTitle("hello");
        list01.add(d);

        Datas d1=new Datas();
        d1.setTitle("hello1");
        list01.add(d1);

        Datas d2=new Datas();
        d2.setTitle("hello2");
        list01.add(d2);
        pullToRefreshListView= (PullToRefreshListView) findViewById(R.id.pull_to_refresh_List_view);
        adapter=new CommonAdapter<Datas>(this,list01,R.layout.cell) {
            @Override
            public void conver(ViewHolder holder, Datas datas) {
                ((TextView)holder.getView(R.id.tv01)).setText(datas.getTitle());

            }
        };
        pullToRefreshListView.setAdapter(adapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new AsyncTask<Void,Void,Void>(){

                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this,"complete",Toast.LENGTH_SHORT).show();
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        pullToRefreshListView.onRefreshComplete();
                        super.onPostExecute(aVoid);
                    }
                }.execute();
            }
        });
    }
}
