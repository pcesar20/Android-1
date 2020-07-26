package br.com.pauloc.maxApp.commons.servicos;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* Adaptado por Mauricio Benigno,
 Obs: Não está funcionando bem, o SO mata o serviço quase um minuto após sua inicialização.
 Também foi feito uma tentativa de usar Broadcast para tentar executar a tarefa ou reiniciar
 o serviço, mas ambas sem sucesso. Não consegui identificar o motivo para que o app não captasse
 o broadcast.

 Solução abaixo proposta por Smita Kapse
 * em https://www.tutorialspoint.com/send-a-notification-when-the-android-app-is-closed*/

public class NotificationService extends Service {
    Timer timer ;
    TimerTask timerTask ;
    String TAG = "Timers" ;
    @Override
    public IBinder onBind (Intent arg0) {
        return null;
    }
    @Override
    public int onStartCommand (Intent intent , int flags , int startId) {
        Log. e ( TAG , "onStartCommand" ) ;
        super .onStartCommand(intent , flags , startId) ;
        startTimer() ;
        return START_STICKY ;
    }

    @Override
    public void onDestroy () {
        stopTimerTask();
        Log. e ( TAG , " Task Finish" ) ;
        super .onDestroy();
    }



    final Handler handler = new Handler();
    public void startTimer (){
        timer = new Timer();
        initializeTimerTask();
        timer .schedule( timerTask , 300000 , 300000 ) ; // A cada 5 minutos, durante 8 horas
    }
    public void stopTimerTask () {
        if (timer != null) {
            timer .cancel();
            timer = null;
        }
    }

    public void initializeTimerTask(){
        timerTask = new TimerTask(){
            public void run(){
                handler .post(new Runnable(){
                    public void run(){
                        Notification notification = new Notification();
                        notification.createNotification( getApplicationContext(),"Volte para o MaxApp","Toque para abrir",true);
                    }
                }) ;
            }
        } ;
    }
}