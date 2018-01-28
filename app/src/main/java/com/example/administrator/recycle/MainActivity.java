package com.example.administrator.recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> s = new ArrayList<>();//newashdlkas
        s.add("ww1");
        s.add("ee2");
        s.add("rr3");
        s.add("aa4");
        s.add("ss5");
        s.add("ww6");
        s.add("ee7");
        s.add("rr8");
        s.add("aa9");
        s.add("ss10");

        s.add("ww11");
        s.add("ee12");
        s.add("rr13");
        s.add("aa14");
        s.add("ss15");
        s.add("ww16");
        s.add("ee17");
        s.add("rr18");
        s.add("aa19");
        s.add("ss20");

        s.add("ww21");
        s.add("ee22");
        s.add("rr23");
        s.add("aa24");
        s.add("ss");


       RecyclerView re = (RecyclerView) findViewById(R.id.recycle_view);
        re.setAdapter(new headdapt(s));
        linearLayoutManager  = new LinearLayoutManager(MainActivity.this);
        re.setLayoutManager(linearLayoutManager);
        re.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
            Log.i("zzz","x的值是："+dx+"y的值是"+dy);
                Log.i("zzzzz","recyclerView的ChildCount值是"+recyclerView.getChildCount());
                Log.i("zzzz","recyclerView的linearLayoutManager值是"+linearLayoutManager.getChildCount());
                Log.i("zzzz","recyclerView的findFirstVisibleItemPosition值是"+linearLayoutManager.findFirstVisibleItemPosition());
            }
        });
    }

    class headdapt extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        ArrayList<String> arrayList ;

        public headdapt(ArrayList<String> arrayList) {
            this.arrayList = arrayList;
        }
        @Override
        public int getItemViewType(int position) {
            if(position==getItemCount()-1){
                return TYPE_FOOTER;
            }else if(position==0){
                return TYPE_HEADER;
            }
            else {
                return TYPE_ITEM;
            }
        }
        private static final int TYPE_ITEM =0;       //普通Item View
        private static final int TYPE_FOOTER = 1;    //底部FootView
        private static final int TYPE_HEADER = 2;    //底部FootView
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             if(viewType==TYPE_ITEM){
                 View view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.item_he,null);
                 he he = new he(view);
                 return he;
             }else if(viewType==TYPE_HEADER){
                 Log.i("测试的","测试的head中viewType"+viewType);
                 View view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.item_load_more,null);
                 he1 h1= new he1(view);
                 return h1;
             }else if(viewType==TYPE_FOOTER){
                 Log.i("测试的","测试的foot中viewType"+viewType);
                 View view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.item_load_more,null);
                 he1 h1= new he1(view);
                 return h1;
             }
             return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if(holder instanceof he){
              he hh = (he) holder;
                Log.i("测试的","测试的"+position);
                hh.tv1.setText(arrayList.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return arrayList.size()+1;
        }
    }

    class he extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        public he(View itemView) {
            super(itemView);
            tv1  = (TextView) itemView.findViewById(R.id.text1);
            tv2 = (TextView) itemView.findViewById(R.id.text1);
        }
    }
    class he1 extends RecyclerView.ViewHolder{
        public he1(View itemView) {
            super(itemView);
        }
    }
}
