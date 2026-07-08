package net.ehardt.aether;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BackgroundAudio")
public class BackgroundAudioPlugin extends Plugin {

    @PluginMethod
    public void enable(PluginCall call) {
        // best-effort: the foreground service works either way, this just
        // makes its notification visible (Android silently hides it if
        // POST_NOTIFICATIONS is denied, rather than failing)
        if (Build.VERSION.SDK_INT >= 33
            && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1001);
        }
        Intent intent = new Intent(getContext(), BackgroundAudioService.class);
        ContextCompat.startForegroundService(getContext(), intent);
        call.resolve();
    }

    @PluginMethod
    public void disable(PluginCall call) {
        getContext().stopService(new Intent(getContext(), BackgroundAudioService.class));
        call.resolve();
    }
}
