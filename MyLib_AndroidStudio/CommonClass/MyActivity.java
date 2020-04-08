package com.example.individualproject.CommonClass;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.individualproject.CommonClass.Wrapper.Wrapper;
import com.example.individualproject.CommonClass.Wrapper.WrapperButton;

public abstract class MyActivity extends AppCompatActivity {


    // $ Method //

    /** The Basic $ method, equal to <code>findViewById(id)</code>*/
    public <T extends View> T $(int id){
        return findViewById(id);
    }

    /** Use <code>Class&lt;T&gt;</code> to specified type, <code>((T)$(id))</code> have same functionality but ugly (may be)*/
    public <T extends View> T $(Class<T> tClass, int id){
        return $(id);
    }

    /** If you need to pass by reference and use it externally <br/>
     * 如果您需要通過引用並在外部使用*/
    public <T extends View> T $(Wrapper<T> wrapper, int id){
        return wrapper.s(this.<T>$(id));
    }

    /** Pass Button by reference and set onClickListener same time <br/>
     * 通過引用傳遞按鈕並同時設置 onClickListener*/
    public WrapperButton $(WrapperButton wrapperButton, int id, View.OnClickListener onClickListener){
        $(wrapperButton, id).setOnClickListener(onClickListener);
        return wrapperButton;
    }

    /** Set onClickListener to multiple id <br/>
     * 將 onClickListener 設置到多個 ID */
    public void $(View.OnClickListener onClickListener, int... ids){
        for (int id : ids) {
            $(id).setOnClickListener(onClickListener);
        }
    }

    /** Get ViewGroup by id <br/>
     * 按 ID 獲取 ViewGroup*/
    public ViewGroup $vg(int id){
        return $(id);
    }

    /** Get ViewGroup by id and addView (s) same time <br/>
     * 按 ID 獲取 ViewGroup 並同時添加視圖(s)*/
    public ViewGroup $vg(int id, View... childs){
        ViewGroup viewGroup = $vg(id);
        for(View child : childs){
            MyViewGroup.SafeAddView(viewGroup, child);
        }
        return viewGroup;
    }



}
