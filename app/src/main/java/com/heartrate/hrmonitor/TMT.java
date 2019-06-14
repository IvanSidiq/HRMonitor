package com.heartrate.hrmonitor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TMT extends Fragment {

    private int collected = 0;
    private boolean boolA = false;
    private boolean boolB = false;
    private boolean boolC = false;
    private boolean boolD = false;
    private boolean boolE = false;
    private boolean boolF = false;
    private boolean boolG = false;
    private boolean boolH = false;
    private boolean boolI = false;
    private boolean boolJ = false;

    public TMT(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tmt, parent, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Button next =(Button) view.findViewById(R.id.next);
        next.setVisibility(View.GONE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button a =(Button) view.findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button a =(Button) v.findViewById(R.id.a);
                a.setBackgroundResource(R.drawable.colorchange);
                boolA=true;
            }
        });

        Button b =(Button) view.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA==true){
                    Button b =(Button) v.findViewById(R.id.b);
                    b.setBackgroundResource(R.drawable.colorchange);

                    boolB=true;
                }
            }
        });

        Button c =(Button) view.findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB){
                    Button c =(Button) v.findViewById(R.id.c);
                    c.setBackgroundResource(R.drawable.colorchange);

                    boolC=true;
                }
            }
        });

        Button d =(Button) view.findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC){
                    Button d =(Button) v.findViewById(R.id.d);
                    d.setBackgroundResource(R.drawable.colorchange);

                    boolD=true;
                }
            }
        });

        Button e =(Button) view.findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD){
                    Button e =(Button) v.findViewById(R.id.e);
                    e.setBackgroundResource(R.drawable.colorchange);

                    boolE=true;
                }
            }
        });

        Button f =(Button) view.findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE){
                    Button f =(Button) v.findViewById(R.id.f);
                    f.setBackgroundResource(R.drawable.colorchange);

                    boolF=true;
                }
            }
        });

        Button g =(Button) view.findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF){
                    Button g =(Button) v.findViewById(R.id.g);
                    g.setBackgroundResource(R.drawable.colorchange);

                    boolG=true;
                }
            }
        });

        Button h =(Button) view.findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG){
                    Button h =(Button) v.findViewById(R.id.h);
                    h.setBackgroundResource(R.drawable.colorchange);

                    boolH=true;
                }
            }
        });

        Button i =(Button) view.findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG&&boolH){
                    Button i =(Button) v.findViewById(R.id.i);
                    i.setBackgroundResource(R.drawable.colorchange);

                    boolI=true;
                }
            }
        });

        Button j =(Button) view.findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG&&boolH&&boolI){
                    Button j =(Button) v.findViewById(R.id.j);
                    j.setBackgroundResource(R.drawable.colorchange);

                    boolJ=true;
                    Button next = (Button) v.findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
