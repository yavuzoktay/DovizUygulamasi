package com.yavuzoktay.doviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yavuzoktay.doviz.models.DovizModel;
import com.yavuzoktay.doviz.networks.Factory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText girilen ;
    private TextView dolar ;
    private TextView euro ;
    private TextView sterlin;
    private ImageView imageViewDolar;
    private ImageView imageViewEuro;
    private ImageView imageViewSterlin;
    private ImageView imageViewLira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girilen = (EditText) findViewById(R.id.girilenDeger);
        dolar = (TextView) findViewById(R.id.dolar);
        euro = (TextView) findViewById(R.id.euro);
        sterlin = (TextView) findViewById(R.id.sterlin);
        imageViewDolar= (ImageView) findViewById(R.id.image_dolar);
        imageViewEuro= (ImageView) findViewById(R.id.image_euro);
        imageViewSterlin= (ImageView) findViewById(R.id.image_sterlin);
        imageViewLira= (ImageView) findViewById(R.id.image_lira);
        Picasso.with(getBaseContext()).load("http://www.dunyaegitim.com/wp-content/uploads/2014/05/amerika-bayragi-ikonu.png").into(imageViewDolar);
        Picasso.with(getBaseContext()).load("http://tr.seaicons.com/wp-content/uploads/2017/04/European-Union-Flag-icon.png").into(imageViewEuro);
        Picasso.with(getBaseContext()).load("http://www.saatkac.com/flags/big/gb.png").into(imageViewSterlin);
        Picasso.with(getBaseContext()).load("http://clipground.com/images/turkish-flag-clipart-13.jpg").into(imageViewLira);

        girilen.addTextChangedListener(this);
    }

        public void retrofit(final double v){
            Factory.getInstance().dovizModel().enqueue(new Callback<DovizModel>() {
                @Override
                public void onResponse(Call<DovizModel> call, Response<DovizModel> response) {
                    dolar.setText(Double.toString(v * response.body().rates.uSD));
                    euro.setText(Double.toString(v * response.body().rates.eUR));
                    sterlin.setText(Double.toString(v * response.body().rates.gBP));
                }

                @Override
                public void onFailure(Call<DovizModel> call, Throwable t) {

                }
            });
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (TextUtils.isEmpty(charSequence)) {
            retrofit(0);
        } else {
            retrofit(Double.parseDouble(charSequence.toString()));
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
