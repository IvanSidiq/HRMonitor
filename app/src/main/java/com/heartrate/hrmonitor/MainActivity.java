package com.heartrate.hrmonitor;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;


import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import com.heartrate.hrmonitor.ImageProcessing;

public class MainActivity extends AppCompatActivity {
    //曲线
    private Timer timer = new Timer();

    private Timer timer2 = new Timer();
    //Timer任务，与Timer配套使用
    private TimerTask task;
    private TimerTask task2;
    private static int gx;
    private static int j;

    private static double flag = 1;
    private Handler handler;
    private Handler handler2;
    private String title = "pulse";
    private XYSeries series;
    private XYSeries series2;
    private XYMultipleSeriesDataset mDataset;
    private XYMultipleSeriesDataset mDataset2;
    private GraphicalView chart;
    private GraphicalView chart2;
    private XYMultipleSeriesRenderer renderer;
    private XYMultipleSeriesRenderer renderer2;
    private Context context;
    private int addX = -1;
    double addY;
    int[] xv = new int[1000];
    int[] yv = new int[1000];
    int[] hua=new int[]{9,10,11,12,13,14,13,12,11,10,9,8,7,6,7,8,9,10,11,10,10};

    private static final AtomicBoolean processing = new AtomicBoolean(false);
    //Android Phone preview control
    private static SurfaceView preview = null;
    private static ConstraintLayout previewL = null;
    //Preview settings information
    private static SurfaceHolder previewHolder = null;
    //Android Phone camera handle
    private static Camera camera = null;
    //private static View image = null;
    public static TextView mTV_Heart_Rate = null;
    public static TextView mTV_Heart_Rate20 = null;
    private static TextView mTV_Avg_Pixel_Values = null;
    private static TextView mTV_pulse = null;
    private static TextView mtvampuh = null;
    private static PowerManager.WakeLock wakeLock = null;
    private static int averageIndex = 0;
    private static final int averageArraySize = 11;
    private static final int[] averageArray = new int[averageArraySize];

    /**
     * Type enumeration
     */
    public static enum TYPE {
        GREEN, RED
    };

    //Set default type
    private static TYPE currentType = TYPE.GREEN;
    //Get current type
    public static TYPE getCurrent() {
        return currentType;
    }
    //Heartbeat subscript value
    private static int beatsIndex = 0;
    //Heartbeat array size
    private static final int beatsArraySize = 1;
    //心跳数组
    private static final int[] beatsArray = new int[beatsArraySize];
    //心跳脉冲
    private static double beats = 0;
    //开始时间
    private static long startTime = 0;
    private static double HR20 = 0;


    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (getFromPref(this, ALLOW_KEY)) {
                showSettingsAlert();
            } else if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA)

                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.CAMERA)) {
                    showAlert();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }
            }
        }


        initConfig();
    }

    /**
     * 初始化配置
     */
    @SuppressWarnings("deprecation")
    private void initConfig(){
        context = getApplicationContext();

        Button mulai = (Button) findViewById(R.id.mulai);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = System.currentTimeMillis();
                beats = 0;
                list.clear();

                //getSupportFragmentManager().beginTransaction()
                //.add(R.id.id_tmt1), firstFragment).commit();
                LinearLayout tmt = (LinearLayout) findViewById(R.id.id_tmt1);
                tmt.setVisibility(View.VISIBLE);
                mTV_Heart_Rate.setVisibility(View.VISIBLE);
            }
        });

        tMT();
        LinearLayout layout = (LinearLayout)findViewById(R.id.id_linearLayout_graph);
        //LinearLayout layout2 = (LinearLayout)findViewById(R.id.id_linearLayout_graph2);

        series = new XYSeries(title);
//        series2 = new XYSeries(title);

        mDataset = new XYMultipleSeriesDataset();
  //      mDataset2 = new XYMultipleSeriesDataset();

        mDataset.addSeries(series);
    //    mDataset2.addSeries(series2);

        int color = Color.GREEN;
        PointStyle style = PointStyle.CIRCLE;
        renderer = buildRenderer(color, style, true);
      //  renderer2 = buildRenderer(color, style, true);

        setChartSettings(renderer, "X", "Y", 0, 1000, 4,16, Color.WHITE, Color.WHITE);
        //setChartSettings2(renderer2, "X", "Y", 0, 1000, -1,1, Color.WHITE, Color.WHITE);

        chart = ChartFactory.getLineChartView(context, mDataset, renderer);
        //chart2 = ChartFactory.getLineChartView(context, mDataset2, renderer2);

        layout.addView(chart, new WindowManager.LayoutParams(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT));
        //layout2.addView(chart2, new WindowManager.LayoutParams(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT));

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                updateChart();
                super.handleMessage(msg);
            }
        };
        task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };

        timer.schedule(task, 1,8);

        /*handler2 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                updateChart2();
                super.handleMessage(msg);
            }
        };
        task2 = new TimerTask() {
            @Override
            public void run() {
                Message message2 = new Message();
                message2.what = 1;
                handler.sendMessage(message2);
            }
        };

        timer2.schedule(task2, 1,8);
*/
        preview = (SurfaceView) findViewById(R.id.id_preview);
        previewL = (ConstraintLayout) findViewById(R.id.id_tmt1);
        previewHolder = preview.getHolder();
        previewHolder.addCallback(surfaceCallback);
        previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        mTV_Heart_Rate = (TextView) findViewById(R.id.id_tv_heart_rate);
        mTV_Avg_Pixel_Values = (TextView) findViewById(R.id.id_tv_Avg_Pixel_Values);
        mTV_pulse = (TextView) findViewById(R.id.id_tv_pulse);
        mtvampuh = (TextView) findViewById(R.id.id_tv_pulsetime);
        mTV_Heart_Rate20 = (TextView) findViewById(R.id.id_tv_heart_rate20);

        mTV_Heart_Rate.setVisibility(View.GONE);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,  "My Tag");
    }

    //	曲线
    @Override
    public void onDestroy() {
        //当结束程序时关掉Timer
        timer.cancel();
        super.onDestroy();
        camera.setPreviewCallback(null);
        camera.stopPreview();
        camera.release();
        camera = null;
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    /**
     * 创建图表
     */
    protected XYMultipleSeriesRenderer buildRenderer(int color, PointStyle style, boolean fill) {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

        //Atur gaya kurva itu sendiri dalam bagan, termasuk warna, ukuran titik, dan ketebalan garis.
        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(Color.RED);
        r.setLineWidth(1);
        renderer.addSeriesRenderer(r);
        return renderer;
    }

    /**
     * 设置图标的样式
     * @param renderer
     * @param xTitle：x标题
     * @param yTitle：y标题
     * @param xMin：x最小长度
     * @param xMax：x最大长度
     * @param yMin:y最小长度
     * @param yMax：y最大长度
     * @param axesColor：颜色
     * @param labelsColor：标签
     */
    protected void setChartSettings(XYMultipleSeriesRenderer renderer, String xTitle, String yTitle,
                                    double xMin, double xMax, double yMin, double yMax, int axesColor, int labelsColor) {
        //Untuk render bagan, lihat dokumentasi api.
        renderer.setChartTitle(title);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setAxesColor(axesColor);
        renderer.setLabelsColor(labelsColor);
        renderer.setShowGrid(true);
        renderer.setGridColor(Color.GREEN);
        renderer.setXLabels(20);
        renderer.setYLabels(10);
        renderer.setXTitle("Time");
        renderer.setYTitle("mmHg");
        renderer.setYLabelsAlign(Paint.Align.RIGHT);
        renderer.setPointSize((float) 3 );
        renderer.setShowLegend(false);
    }

    protected void setChartSettings2(XYMultipleSeriesRenderer renderer2, String xTitle, String yTitle,
                                    double xMin, double xMax, double yMin, double yMax, int axesColor, int labelsColor) {
        //Untuk render bagan, lihat dokumentasi api.
        renderer2.setChartTitle(title);
        renderer2.setXTitle(xTitle);
        renderer2.setYTitle(yTitle);
        renderer2.setXAxisMin(xMin);
        renderer2.setXAxisMax(xMax);
        renderer2.setYAxisMin(yMin);
        renderer2.setYAxisMax(yMax);
        renderer2.setAxesColor(axesColor);
        renderer2.setLabelsColor(labelsColor);
        renderer2.setShowGrid(true);
        renderer2.setGridColor(Color.GREEN);
        renderer2.setXLabels(20);
        renderer2.setYLabels(10);
        renderer2.setXTitle("Time");
        renderer2.setYTitle("Benar >< Salah");
        renderer2.setYLabelsAlign(Paint.Align.RIGHT);
        renderer2.setPointSize((float) 3 );
        renderer2.setShowLegend(false);
    }


    /**
     * Perbarui informasi ikon
     */
    private void updateChart() {
        //Atur simpul berikutnya yang akan ditambahkan
        if(flag == 1) {
            addY = 10;
        }
        else {
            flag = 1;
            if(gx < 200){
                if(hua[20] > 1){
                    Toast.makeText(MainActivity.this, "Letakkan jari anda di belakang kamera dan tersinari oleh cahaya flash," +
                            "dan pastikan detak jantung anda sudah terhitung dan akan terlihat pada grafik" +
                            ", tolong tekan tombol berikut untuk memulai penghitungan", Toast.LENGTH_SHORT).show();
                    hua[20] = 0;
                }
                hua[20]++;
                return;
            }
            else {
                hua[20] = 10;
            }
            j = 0;
        }
        if(j < 20){
            addY=hua[j];
            j++;
        }

        //Hapus set poin lama dari dataset
        mDataset.removeSeries(series);

        //Tentukan berapa banyak poin dalam set titik saat ini, karena layar hanya dapat menampung 100 total, jadi ketika jumlah poin melebihi 100, panjangnya selalu 100.
        int length = series.getItemCount();
        int bz = 0;
        //addX = length;
        if (length > 1000) {
            //wakeLock.release();
            length = 1000;
            bz=1;
        }
        addX = length;
        //Ambil nilai-nilai dari titik lama atur x dan y ke dalam cadangan, dan tambah nilai x dengan 1, menyebabkan kurva bergerak ke kanan.
        for (int i = 0; i < length; i++) {
            xv[i] = (int) series.getX(i) - bz;
            yv[i] = (int) series.getY(i);
        }

        //Set point dihapus terlebih dahulu, siap untuk membuat set point baru
        series.clear();
        mDataset.addSeries(series);
        // Tambahkan poin yang baru dihasilkan ke set poin pertama, lalu tambahkan kembali serangkaian poin setelah transformasi koordinat ke titik yang ditetapkan dalam loop body
        // Di sini Anda dapat menguji efek membalik urutan, yaitu, pertama jalankan loop body, lalu tambahkan titik yang baru dibuat
        series.add(addX, addY);
        for (int k = 0; k < length; k++) {
            series.add(xv[k], yv[k]);
        }
        //Tambahkan set poin baru di dataset
        //mDataset.addSeries(series);

        //Lihat pembaruan, tanpa langkah ini, kurva tidak akan membuat dinamis
        //Jika di utas utama non-UI, Anda perlu memanggil postInvalidate (), api referensi khusus
        chart.invalidate();
    } //曲线

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onResume() {
        super.onResume();
        wakeLock.acquire();
        camera = Camera.open();
        //startTime = System.currentTimeMillis();
    }

    @Override
    public void onPause() {
        super.onPause();
        //wakeLock.release();
        //camera.setPreviewCallback(null);
        //camera.stopPreview();
        //camera.release();
        //camera = null;
    }

    private static List<String> list = new ArrayList<String>();
    private static android.hardware.Camera.PreviewCallback previewCallback = new PreviewCallback() {
        public void onPreviewFrame(byte[] data, Camera cam) {
            if (data == null) {
                throw new NullPointerException();
            }
            Camera.Size size = cam.getParameters().getPreviewSize();
            if (size == null) {
                throw new NullPointerException();
            }
            if (!processing.compareAndSet(false, true)) {
                return;
            }
            int width = size.width;
            int height = size.height;

            //Image Processing
            int imgAvg = ImageProcessing.decodeYUV420SPtoRedAvg(data.clone(),height,width);
            gx = imgAvg;
            mTV_Avg_Pixel_Values.setText("The average pixel value is" + String.valueOf(imgAvg));
            Log.d("ImgAvg ", String.valueOf(imgAvg));
            if (imgAvg == 0 || imgAvg == 255) {
                processing.set(false);
                return;
            }
            //Hitung rata-rata
            int averageArrayAvg = 0;
            int averageArrayCnt = 0;
            for (int i = 0; i < averageArray.length; i++) {
                if (averageArray[i] > 0) {
                    averageArrayAvg += averageArray[i];
                    averageArrayCnt++;
                }
            }

            //Hitung rata-rata
            int rollingAverage = (averageArrayCnt > 0)?(averageArrayAvg/averageArrayCnt):0;
            TYPE newType = currentType;
            long endTime = System.currentTimeMillis();
            double totalTimeInSecs = (endTime - startTime) / 1000d;
            if (imgAvg < rollingAverage) {
                newType = TYPE.RED;
                if (newType != currentType) {
                    beats++;
                    flag = 0;
                    mTV_pulse.setText("The number of pulses is " + String.valueOf(beats));
                    list.add(String.valueOf(totalTimeInSecs));

                }
            } else if (imgAvg > rollingAverage) {
                newType = TYPE.GREEN;
            }


            if(averageIndex == averageArraySize) {
                averageIndex = 0;
            }
            averageArray[averageIndex] = imgAvg;
            averageIndex++;

            if (newType != currentType) {
                currentType = newType;
            }

            //Dapatkan waktu akhir sistem (ms)

            if(totalTimeInSecs >=1){
                mTV_Heart_Rate.setText("Timers "+String.valueOf(totalTimeInSecs));
            }
            if (totalTimeInSecs >= 8) {
                double bps = (beats / totalTimeInSecs);
                int dpm = (int) (bps * 60d);
                if (dpm < 30 || dpm > 180|| imgAvg < 200) {
                    //startTime = System.currentTimeMillis();
                    processing.set(false);
                    return;
                }

                if(beatsIndex == beatsArraySize) {
                    beatsIndex = 0;
                }
                beatsArray[beatsIndex] = dpm;
                beatsIndex++;

                int beatsArrayAvg = 0;
                int beatsArrayCnt = 0;
                for (int i = 0; i < beatsArray.length; i++) {
                    if (beatsArray[i] > 0) {
                        beatsArrayAvg += beatsArray[i];
                        beatsArrayCnt++;
                    }
                }
                int beatsAvg = (beatsArrayAvg / beatsArrayCnt);
                /*mTV_Heart_Rate.setText("Heart Rate"+String.valueOf(beatsAvg) +
                        "  value:" + String.valueOf(beatsArray.length) +
                        "    " + String.valueOf(beatsIndex) +
                        "    " + String.valueOf(beatsArrayAvg) +
                        "    " + String.valueOf(beatsArrayCnt));*/
                if(beatsIndex == beatsArray.length){ HR20 = beatsAvg;}
                mTV_Heart_Rate20.setText("Your Heart Rate is "+String.valueOf(HR20));
                beats = 0;
                mtvampuh.setText("Time pulses " + (list));
                mTV_Heart_Rate.setVisibility(View.GONE);
                startTime = 0;
            }
            processing.set(false);
        }
    };

    private static SurfaceHolder.Callback surfaceCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                camera.setPreviewDisplay(previewHolder);
                camera.setPreviewCallback(previewCallback);
            } catch (Throwable t) {
                Log.e("PreviewDemo","Exception in setPreviewDisplay()", t);
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            Camera.Size size = getSmallestPreviewSize(width, height, parameters);
            if (size != null) {
                parameters.setPreviewSize(size.width, size.height);
            }
            camera.setParameters(parameters);
            camera.startPreview();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    };

    private static Camera.Size getSmallestPreviewSize(int width, int height, Camera.Parameters parameters) {
        Camera.Size result = null;
        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
            if (size.width <= width && size.height <= height) {
                if (result == null) {
                    result = size;
                }
                else {
                    int resultArea = result.width * result.height;
                    int newArea = size.width * size.height;
                    if (newArea < resultArea) {
                        result = size;
                    }
                }
            }
        }
        return result;
    }

    public static Boolean getFromPref(Context context, String key) {
        SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF,
                Context.MODE_PRIVATE);
        return (myPrefs.getBoolean(key, false));
    }
    private void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                MY_PERMISSIONS_REQUEST_CAMERA);
                    }
                });
        alertDialog.show();
    }
    private void showSettingsAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }

    /*private boolean boolA = false;
    private boolean boolB = false;
    private boolean boolC = false;
    private boolean boolD = false;
    private boolean boolE = false;
    private boolean boolF = false;
    private boolean boolG = false;
    private boolean boolH = false;
    private boolean boolI = false;
    private boolean boolJ = false;

    private void tMT(){

        Button next =(Button) findViewById(R.id.next);
        next.setVisibility(View.GONE);

        Button a =(Button) findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button a =(Button) findViewById(R.id.a);
                a.setBackgroundResource(R.drawable.colorchange);
                boolA=true;
            }
        });

        Button b =(Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA==true){
                    Button b =(Button) findViewById(R.id.b);
                    b.setBackgroundResource(R.drawable.colorchange);

                    boolB=true;
                }
            }
        });

        Button c =(Button) findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB){
                    Button c =(Button) findViewById(R.id.c);
                    c.setBackgroundResource(R.drawable.colorchange);

                    boolC=true;
                }
            }
        });

        Button d =(Button) findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC){
                    Button d =(Button) findViewById(R.id.d);
                    d.setBackgroundResource(R.drawable.colorchange);

                    boolD=true;
                }
            }
        });

        Button e =(Button) findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD){
                    Button e =(Button) findViewById(R.id.e);
                    e.setBackgroundResource(R.drawable.colorchange);

                    boolE=true;
                }
            }
        });

        Button f =(Button) findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE){
                    Button f =(Button) findViewById(R.id.f);
                    f.setBackgroundResource(R.drawable.colorchange);

                    boolF=true;
                }
            }
        });

        Button g =(Button) findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF){
                    Button g =(Button) findViewById(R.id.g);
                    g.setBackgroundResource(R.drawable.colorchange);

                    boolG=true;
                }
            }
        });

        Button h =(Button) findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG){
                    Button h =(Button) findViewById(R.id.h);
                    h.setBackgroundResource(R.drawable.colorchange);

                    boolH=true;
                }
            }
        });

        Button i =(Button) findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG&&boolH){
                    Button i =(Button) findViewById(R.id.i);
                    i.setBackgroundResource(R.drawable.colorchange);

                    boolI=true;
                }
            }
        });

        Button j =(Button) findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolA&&boolB&&boolC&&boolD&&boolE&&boolF&&boolG&&boolH&&boolI){
                    Button j =(Button) findViewById(R.id.j);
                    j.setBackgroundResource(R.drawable.colorchange);

                    boolJ=true;
                    Button next = (Button)findViewById(R.id.next);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }*/
}