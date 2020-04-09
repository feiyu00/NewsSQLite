package com.example.localization;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.localization.dao.IUserDao;
import com.example.localization.dao.UserDaoImpl;
import com.example.localization.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    private String TAG = "Test";

    @Test
    public void testCreate(){

    }
    //软件教程
    //先启动模拟器，然后右键方法名运行，下面是绿色的代表运行成功
    //下面来查询数据库，看数据是否插入进去了
    //先启动cmd命令
    //进入sdk目录下面D:\android\Sdk\platform-tools
    //然后运行adb root 这一步一定要先启动模拟器，不然会提示找不到你的模拟器
    //而且不要启动了模拟器，还连接手机
    //已经root成功了，不确认的话可以多执行两边命令会出现下面的提示adbd is already running as root
    //然后进入D:\android\Sdk\tools\lib\monitor-x86_64下面找到monitor.exe如果你是64位就进去monitor-x86_64
    //下一步他会出现一个应用左边这样的
    //点击data/data/找到你的包名/点开找到databases点开
    //注意如果你用的是测试类他下面会出现名字一样的但是后面会跟test
    //然后导出数据库点击数据库名，这个导出
    //放到桌面
    //拖进去
    //然后点击你的表名再点击data
    //就可以看到插入的数据
    //注意，每次插入数据，更改数据，删除数据，都要重新导出数据库在查看
    @Test
    public void testInsert(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao =new UserDaoImpl(appContext);
        User user = new User();
        user.setSex("male");
        user.setAge(19);
        user.setUserName("lisi");
        user.setPassword("123456");
        long result = userDao.addUser(user);
        Log.d(TAG,"user add result ==== "+ result);
    }

    @Test
    public void testDelete(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDaoImpl dao =new UserDaoImpl(appContext);

    }
    @Test
    public void testUpdate(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

    }
    @Test
    public void testQuery(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        UserDaoImpl dao =new UserDaoImpl(appContext);

    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.localization", appContext.getPackageName());
    }
}
