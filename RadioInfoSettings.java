import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class RadioInfoSettings {
    public void openSettings(Context context){
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                intent.setClassName("com.android.settings", "com.android.settings.RadioInfo");
            } else {
                intent.setClassName("com.android.phone", "com.android.settings.phone.RadioInfo");
            }
            context.startActivity(intent);
        }catch (Exception e){
            Log.d("gobutton", "error is " + e);
            try {
                Runtime.getRuntime().exec("am start --user 0 -n com.android.settings/.RadioInfo");
            }catch (Exception e2){
                Log.d("gobutton", "second error is " + e2);
                Toast.makeText(context, "We are extreamly sorry, We will fix this essue in nexts updates", Toast.LENGTH_LONG).show();
            }
        }

    }
}
