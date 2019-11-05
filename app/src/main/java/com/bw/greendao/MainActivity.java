package com.bw.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bw.greendao.entity.UserEntity;
import com.bw.greendao.greendao.DaoMaster;
import com.bw.greendao.greendao.DaoSession;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLiteDatabase database;
    private DaoMaster.DevOpenHelper devOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

    }

    private void initData() {
        initGreendao();
    }

    private void initGreendao() {

        devOpenHelper=new DaoMaster.DevOpenHelper(this,"wdmall.db",null);
        database=devOpenHelper.getWritableDatabase();

        daoMaster=new DaoMaster(database);
        daoSession=daoMaster.newSession();

    }

    public void insert(View view) {
        UserEntity userEntity=new UserEntity();
        userEntity.name="yxs";
        userEntity.age=20;
        daoSession.insert(userEntity);
    }

    public void delete(View view) {

        daoSession.delete(userEntity);
    }

    UserEntity userEntity;
    public void update(View view) {
        userEntity.name="zxx";
        daoSession.update(userEntity);
    }

    public void query(View view) {
        List<UserEntity> userEntities = daoSession.loadAll(UserEntity.class);

        System.out.println("size"+userEntities.get(0).name);

    }
}
