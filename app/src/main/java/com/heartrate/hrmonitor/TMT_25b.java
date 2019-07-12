package com.heartrate.hrmonitor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
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
        d2 = {"Lcom/hepicar/listeneverything/TMT_25bb;", "Landroid/support/v4/app/Fragment;", "()V", "boolA", "", "boolB", "boolC", "boolD", "boolE", "boolF", "boolG", "boolH", "boolI", "boolJ", "tmtData", "", "Lcom/hepicar/listeneverything/model/TMT;", "getTmtData", "()Ljava/util/List;", "setTmtData", "(Ljava/util/List;)V", "TMT", "", "view", "Landroid/view/View;", "TMTAddData", "timestamp", "", "data", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app"}
)
public final class TMT_25b extends Fragment {
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
    private boolean boolK;
    private boolean boolL;
    private boolean boolM;
    private boolean boolN;
    private boolean boolO;
    private boolean boolP;
    private boolean boolQ;
    private boolean boolR;
    private boolean boolS;
    private boolean boolT;
    private boolean boolU;
    private boolean boolV;
    private boolean boolW;
    private boolean boolX;
    private boolean boolY;
    @NotNull
    private List tmtData = (List)(new ArrayList());
    //public static final TMT_25bb.Companion Companion = new TMT_25bb().Companion((DefaultConstructorMarker)null);
    private HashMap _$_findViewCache;

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View var10000 = inflater.inflate(R.layout.tmt_25b, container, false);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "inflater.inflate(R.layou…25b, container, false)");
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
        ((Button)view.findViewById(id.a_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (!TMT_25b.this.boolA) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.a_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolA = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.b_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolA && !TMT_25b.this.boolB) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.b_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolB = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.c_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolB && !TMT_25b.this.boolC) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.c_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolC = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.d_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolC && !TMT_25b.this.boolD) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.d_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolD = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.e_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolD && !TMT_25b.this.boolE) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.e_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolE = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.f_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolE && !TMT_25b.this.boolF) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.f_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolF = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.g_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolF && !TMT_25b.this.boolG) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.g_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolG = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.h_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolG && !TMT_25b.this.boolH) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.h_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolH = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.i_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolH && !TMT_25b.this.boolI) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.i_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolI = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.j_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolI && !TMT_25b.this.boolJ) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.j_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolJ = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.k_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolJ && !TMT_25b.this.boolK) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.k_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolK = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.l_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolK && !TMT_25b.this.boolL) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.l_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolL = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.m_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolL && !TMT_25b.this.boolM) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.m_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolM = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.n_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolM && !TMT_25b.this.boolN) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.n_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolN = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.o_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolN && !TMT_25b.this.boolO) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.o_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolO = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.p_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolO && !TMT_25b.this.boolP) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.p_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolP = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));((Button)view.findViewById(id.q_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolP && !TMT_25b.this.boolQ) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.q_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolQ = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.r_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolQ && !TMT_25b.this.boolR) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.r_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolR = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.s_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolR && !TMT_25b.this.boolS) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.s_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolS = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.t_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolS && !TMT_25b.this.boolT) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.t_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolT = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.u_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolT && !TMT_25b.this.boolU) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.u_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolU = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.v_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolU && !TMT_25b.this.boolV) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.v_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolV = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.w_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolV && !TMT_25b.this.boolW) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.w_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolW = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.x_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                if (TMT_25b.this.boolW && !TMT_25b.this.boolX) {
                    ((Button)TMT_25b.this._$_findCachedViewById(id.x_25b)).setBackgroundResource(R.drawable.colorchange);
                    TMT_25b.this.boolX = true;
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), 1);
                } else {
                    TMT_25b.this.TMTAddData(System.currentTimeMillis(), -1);
                }

            }
        }));
        ((Button)view.findViewById(id.next_25b)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View view) {
                LocalStorage.Companion.saveToCSVTMT(TMT_25b.this.getTmtData(), "25b");
                TMT_25b.this.getTmtData().clear();
                FragmentActivity var10000 = TMT_25b.this.getActivity();
                if (var10000 == null) {
                    Intrinsics.throwNpe();
                }
                //var10000.getSupportFragmentManager().beginTransaction().remove(id.fragment_tmt, (Fragment)(new TMT_25b())).commit();

                Intrinsics.checkExpressionValueIsNotNull(var10000, "activity!!");
                //var10000.getSupportFragmentManager().beginTransaction().remove(id.fragment_tmt).commit();
                var10000.getSupportFragmentManager().executePendingTransactions();
                Fragment fragment = getFragmentManager().findFragmentById(id.fragment_tmt);
                var10000.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                Intrinsics.checkParameterIsNotNull(view, "view");
                //View v = getLayoutInflater().inflate(R.layout.activity_main, null);
                //Button b = v.findViewById(id.finish);
                //b.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).onView();
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
            d2 = {"Lcom/hepicar/listeneverything/TMT_25bb$Companion;", "", "()V", "newInstance", "Lcom/hepicar/listeneverything/TMT_25bb;", "app"}
    )
    public static final class Companion {
        @NotNull
        public final TMT_25b newInstance() {
            return new TMT_25b();
        }

        private Companion() {
        }

        // $FF: synthetic method
        //public Companion(DefaultConstructorMarker $constructor_marker) {
        //    this();
        //}
    }
}
