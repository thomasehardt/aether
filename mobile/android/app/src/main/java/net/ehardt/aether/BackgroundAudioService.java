package net.ehardt.aether;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;

// Minimal foreground service so audio keeps playing when the app is
// backgrounded. Android suspends/throttles a plain WebView Activity once
// it's no longer in the foreground; a mediaPlayback-type foreground service
// (with the required visible notification) is the standard, documented way
// around that — see BackgroundAudioPlugin for the JS-facing enable()/disable().
public class BackgroundAudioService extends Service {
    private static final String CHANNEL_ID = "aether_playback";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createChannelIfNeeded();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Aether")
            .setContentText("Ambient soundscape playing")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
            .build();
        ServiceCompat.startForeground(
            this,
            NOTIFICATION_ID,
            notification,
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
                ? ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
                : 0
        );
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ServiceCompat.stopForeground(this, ServiceCompat.STOP_FOREGROUND_REMOVE);
    }

    private void createChannelIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = getSystemService(NotificationManager.class);
            NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "Aether playback", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
        }
    }
}
