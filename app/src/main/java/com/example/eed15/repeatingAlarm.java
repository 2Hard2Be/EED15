package com.example.eed15;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Fragment;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by Peto-1 on 12/28/2014.
 */
//ESTA SERA LA CLASE QUE MANEJE LA ALARMA Y SERA ACCIONADA DESDE EL MAIN, SOLO REVISAR SI
// DEBE SER SUBCLASE DE ACTIVITY O NO (PUES CORRE EN BACKGROUND NO SE PODRA INTERACTUAR CON ELLA)
//    PROBABLEMENTE NO LLEVE EXTENDS

public class repeatingAlarm extends IntentService {

    public repeatingAlarm(){

        super("repeatingAlarm");
    }

@Override

//ATENCION REVISAR SI REALMENTE FUNCIONA: AL DAR ONCREATE CREAR LOS INTENTS Y LA ALARMA?? O SERA
//MEJOR REVISAR SI NO HA SIDO CREADA ANTES (PROBABLEMENTE ESTE CORRECTO SOLO HEADS UP


    protected void onHandleIntent (Intent intent){




//    Falta crear la clase notificacion (tendria que ser el intent que llame la notificacion de la barra)
    Intent intentNotification = new Intent(repeatingAlarm.this,notificacion.class);


//    Falta usar el pending intent, contexto repeatingAlarm y llamara al intentNotification que debera
//    invocar la notificacion en la barra de tareas
    PendingIntent pendingIntentNoti = PendingIntent.getActivity(repeatingAlarm.this,0,intentNotification,0);

//    Aqui crea el alarmManager, guiate segun la pagina web android-er y los ejemlos
//Inicializando objeto del tipo alarma...beeep....beeep

   int alarmType = AlarmManager.ELAPSED_REALTIME;
    final int FIFTEEN_SEC_MILLIS = 20000;
    AlarmManager alarmManager = (AlarmManager)

//            ATENCION AQUI MODIFIQUE Y QUITE EL REPEATING ALARM COMO CONTEXTO
            getSystemService(repeatingAlarm.ALARM_SERVICE);
    alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
            FIFTEEN_SEC_MILLIS, pendingIntentNoti);

    Toast.makeText(repeatingAlarm.this,"Alarma 20 segundos",Toast.LENGTH_SHORT).show();



}

}
