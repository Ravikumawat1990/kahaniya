package kahaniya.ravi.app.com.kahaniya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jaimin on 6/24/2015.
 */
public class CM {


    /**
     * Checking Internet is available or not
     *
     * @param context
     * @return
     */
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static void setSp(Context activity, String key, Object value) {
        SharedPreferences prefs = activity.getSharedPreferences(
                activity.getPackageName(), Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }

        editor.commit();
        editor = null;
        prefs = null;

    }

    /**
     * returns object of specific type from SharedPrefs
     *
     * @param activity
     * @param key          name of data in SP
     * @param defaultValue used if no value available for this key
     * @return
     */
    public static Object getSp(Context activity, String key, Object defaultValue) {
        SharedPreferences prefs = activity.getSharedPreferences(
                activity.getPackageName(), Activity.MODE_PRIVATE);
        if (defaultValue instanceof String) {
            return prefs.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return prefs.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return prefs.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Long) {
            return prefs.getLong(key, (Long) defaultValue);
        } else {
            return prefs.getFloat(key, (Float) defaultValue);
        }

    }

    // call this method when you don't have any data via intent
    public static void startActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);

        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_in_from_left,
                R.anim.push_out_to_right);

    }

    // call this method when you have to pass data in intent
    public static void startActivity(Intent intent, Activity activity) {

        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_in_from_left,
                R.anim.push_out_to_right);

    }

    // call this method when you have to pass data in intent
    public static void startActivityForResult(Intent intent, int resultcode, Activity activity) {

        activity.startActivityForResult(intent, resultcode);
        activity.overridePendingTransition(R.anim.push_in_from_left,
                R.anim.push_out_to_right);

    }

    public static void finishActivity(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(0, R.anim.push_out_to_left);
    }


    public static int getDeviceWidth(Activity activity) {

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }


    public static void showToast(String msg, Context context) {

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();


    }

    /**
     * Loading Image Progress
     */
    public static void loadImageProgess(ImageView imgProgress, Activity activity) {
        imgProgress.setVisibility(View.VISIBLE);
        Animation a = AnimationUtils.loadAnimation(activity, R.anim.scale);
        a.setDuration(1000);
        imgProgress.startAnimation(a);

        a.setInterpolator(new Interpolator() {
            private final int frameCount = 8;

            @Override
            public float getInterpolation(float input) {
                return (float) Math.floor(input * frameCount) / frameCount;
            }
        });
    }


    public static boolean isEmailValid(String email) {
        String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }


    // database Operation copy file asset to application database folder
    public static void copyDataBase(Context mActivity) throws IOException {

        InputStream myInput = new FileInputStream(new File("/data/data/"
                + mActivity.getPackageName() + "/databases/"
                + "b2b.sqlite"));
        File files = new File(Environment.getExternalStorageDirectory()
                + "/files/");
        files.mkdirs();
        String outFileName = Environment.getExternalStorageDirectory()
                + "/files/b2b.sqlite";
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int bufferLength;
        while ((bufferLength = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, bufferLength);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
        Log.d("tag", "Copy Database Done");
    }


}

