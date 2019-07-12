package com.heartrate.hrmonitor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.heartrate.hrmonitor.R.id;
import com.heartrate.hrmonitor.model.TMT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.heartrate.hrmonitor.repository.LocalStorage;
import kotlin.Metadata;
//import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006&"},
        d2 = {"Lcom/hepicar/listeneverything/TMT_Hard;", "Landroid/support/v4/app/Fragment;", "()V", "boolA", "", "boolB", "boolC", "boolD", "boolE", "boolF", "boolG", "boolH", "boolI", "boolJ", "tmtData", "", "Lcom/hepicar/listeneverything/model/TMT;", "getTmtData", "()Ljava/util/List;", "setTmtData", "(Ljava/util/List;)V", "TMT", "", "view", "Landroid/view/View;", "TMTAddData", "timestamp", "", "data", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app"}
)
public final class TMT_Hard extends Fragment {
    private boolean boolA;
    private boolean boolB;
    private boolean boolC;
    private boolean boolD;
    private boolean boolE;
    private boolean boolF;
    private boolean boolG;
    private boolean boolH;
    private boolean boolI;
    private boolean boolJ;
    @NotNull
    private List tmtData = (List)(new ArrayList());
    //public static final TMT_Hard.Companion Companion = new TMT_Hard().Companion((DefaultConstructorMarker)null);
    private HashMap _$_findViewCache;

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View var10000 = inflater.inflate(R.layout.tmt_hard, container, false);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "inflater.inflate(R.layou…hard, container, false)");
        View view = var10000;
        this.TMT(view);
        return view;
    }

    @NotNull
    public final List getTmtData() {
        return this.tmtData;
    }

    public final void setTmtData(@NotNull List var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.tmtData = var1;
    }

    public final void TMT(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ((Button)view.findViewById(id.a_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (!TMT_Hard.this.boolA) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.a_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolA = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.b_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolA && !TMT_Hard.this.boolB) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.b_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolB = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.c_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolB && !TMT_Hard.this.boolC) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.c_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolC = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.d_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolC && !TMT_Hard.this.boolD) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.d_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolD = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.e_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolD && !TMT_Hard.this.boolE) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.e_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolE = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.f_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolE && !TMT_Hard.this.boolF) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.f_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolF = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.g_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolF && !TMT_Hard.this.boolG) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.g_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolG = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.h_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_Hard.this.boolG && !TMT_Hard.this.boolH) {
                    ((Button)TMT_Hard.this._$_findCachedViewById(id.h_hard)).setBackgroundResource(R.drawable.colorchange);
                    TMT_Hard.this.boolH = true;
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_Hard.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.next_hard)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                LocalStorage.Companion.saveToCSVTMT(TMT_Hard.this.getTmtData(), "hard");
                TMT_Hard.this.getTmtData().clear();
                FragmentActivity var10000 = TMT_Hard.this.getActivity();
                if (var10000 == null) {
                    Intrinsics.throwNpe();
                }

                Intrinsics.checkExpressionValueIsNotNull(var10000, "activity!!");
                var10000.getSupportFragmentManager().beginTransaction().replace(id.fragment_tmt, (Fragment)(new TMT_25())).commit();
            }
        }));
    }

    public final void TMTAddData(long timestamp, int data) {
        TMT tmt = new TMT(timestamp);
        tmt.setValue(data);
        this.tmtData.add(tmt);
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            View var10000 = this.getView();
            if (var10000 == null) {
                return null;
            }

            var2 = var10000.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    @Metadata(
            mv = {1, 1, 15},
            bv = {1, 0, 3},
            k = 1,
            d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
            d2 = {"Lcom/hepicar/listeneverything/TMT_Hard$Companion;", "", "()V", "newInstance", "Lcom/hepicar/listeneverything/TMT_Hard;", "app"}
    )
    public static final class Companion {
        @NotNull
        public final TMT_Hard newInstance() {
            return new TMT_Hard();
        }

        private Companion() {
        }

        // $FF: synthetic method
        //public Companion(DefaultConstructorMarker $constructor_marker) {
        //    this();
        //}
    }
}
