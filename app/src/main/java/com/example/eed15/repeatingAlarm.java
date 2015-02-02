package com.example.eed15;


import android.app.AlarmManager;

import android.app.IntentService;
import android.app.PendingIntent;

import android.content.Intent;

import android.os.SystemClock;

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

    Calendar now = Calendar.getInstance();
    Calendar alarma = Calendar.getInstance();

    alarma.set(Calendar.MILLISECOND, 0);
    alarma.set(Calendar.SECOND, 0);
    alarma.set(Calendar.MINUTE, 0);
    alarma.set(Calendar.HOUR_OF_DAY, 6);

    int horaactual = now.get(Calendar.HOUR_OF_DAY);
    int minutoactual = now.get(Calendar.MINUTE);
    int horaset = alarma.get(Calendar.HOUR_OF_DAY);

    if (horaactual == horaset) {
        int calculohora = 12;
        int millecminus = minutoactual*60*1000;
        int millisectoplay = (calculohora * 60*60*1000)-millecminus;
        final int FIFTEEN_SEC_MILLIS = millisectoplay;
        int alarmType = AlarmManager.ELAPSED_REALTIME;

        AlarmManager alarmManager = (AlarmManager)

//            ATENCION AQUI MODIFIQUE Y QUITE EL REPEATING ALARM COMO CONTEXTO
                getSystemService(repeatingAlarm.ALARM_SERVICE);
        alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                FIFTEEN_SEC_MILLIS, pendingIntentNoti);

        Toast.makeText(repeatingAlarm.this,"Alarma 20 segundos",Toast.LENGTH_SHORT).show();

}

    else {


        int calculohora = horaset - horaactual;

        if (calculohora < 0) {

            int calculohora2 = horaactual - horaset;
            int calculohora3 = 24 - calculohora2;
            int millecminus = minutoactual*60*1000;
            int millisectoplay = (calculohora3 * 60*60*1000)-millecminus;
            final int FIFTEEN_SEC_MILLIS = millisectoplay;

            int alarmType = AlarmManager.ELAPSED_REALTIME;

            AlarmManager alarmManager = (AlarmManager)

//            ATENCION AQUI MODIFIQUE Y QUITE EL REPEATING ALARM COMO CONTEXTO
                    getSystemService(repeatingAlarm.ALARM_SERVICE);
            alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                    FIFTEEN_SEC_MILLIS, pendingIntentNoti);

            Toast.makeText(repeatingAlarm.this, "Alarma 20 segundos", Toast.LENGTH_SHORT).show();
        } else {

            int calculohora4 = horaset - horaactual;
            int millecminus = minutoactual*60*1000;
            int millisectoplay = (calculohora4 * 60*60*1000)-millecminus;
            final int FIFTEEN_SEC_MILLIS = millisectoplay;

            int alarmType = AlarmManager.ELAPSED_REALTIME;

            AlarmManager alarmManager = (AlarmManager)

//            ATENCION AQUI MODIFIQUE Y QUITE EL REPEATING ALARM COMO CONTEXTO
                    getSystemService(repeatingAlarm.ALARM_SERVICE);
            alarmManager.setRepeating(alarmType, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                    FIFTEEN_SEC_MILLIS, pendingIntentNoti);

            Toast.makeText(repeatingAlarm.this, "Alarma 20 segundos", Toast.LENGTH_SHORT).show();


        }
    }
}

}
