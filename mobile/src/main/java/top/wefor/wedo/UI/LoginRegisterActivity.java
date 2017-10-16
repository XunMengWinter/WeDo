package top.wefor.wedo.UI;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.text.InputType;
import android.view.View;

import butterknife.BindView;
import top.wefor.circularanim.CircularAnim;
import top.wefor.wedo.R;

/**
 * Created on 2017/10/16.
 *
 * @author ice
 */

public class LoginRegisterActivity extends BaseAppCompatActivity {
    @BindView(R.id.tableLayout) TabLayout mTableLayout;
    @BindView(R.id.name_et) TextInputEditText mNameEt;
    @BindView(R.id.phone_et) TextInputEditText mPhoneEt;
    @BindView(R.id.pwd_et) TextInputEditText mPwdEt;
    @BindView(R.id.enter_btn) AppCompatButton mEnterBtn;

    private boolean isLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        isLogin = false;
                        ((View)mNameEt.getParent()).setVisibility(View.VISIBLE);
                        mPwdEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        mEnterBtn.setText(R.string.register);
                        break;
                    case 1:
                        isLogin = true;
                        ((View)mNameEt.getParent()).setVisibility(View.GONE);
                        mPwdEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        mEnterBtn.setText(R.string.login);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircularAnim.hide(mEnterBtn)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                if (isLogin) {
                                    // login
                                    CircularAnim.fullActivity(mActivity, mEnterBtn)
                                            .go(new CircularAnim.OnAnimationEndListener() {
                                                @Override
                                                public void onAnimationEnd() {
                                                    go(MainActivity.class);
                                                    finish();
                                                }
                                            });
                                } else {
                                    // register
                                    CircularAnim.show(mEnterBtn).go();
                                    showToast("HHHHHHH");
                                }
                            }
                        });

            }
        });
    }


}
