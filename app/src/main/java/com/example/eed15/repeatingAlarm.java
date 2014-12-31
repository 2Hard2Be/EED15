package com.example.eed15;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by Peto-1 on 12/28/2014.
 */
//ESTA SERA LA CLASE QUE MANEJE LA ALARMA Y SERA ACCIONADA DESDE EL MAIN, SOLO REVISAR SI
// DEBE SER SUBCLASE DE ACTIVITY O NO (PUES CORRE EN BACKGROUND NO SE PODRA INTERACTUAR CON ELLA)
//    PROBABLEMENTE NO LLEVE EXTENDS

public class repeatingAlarm extends Activity {

@Override

//ATENCION REVISAR SI REALMENTE FUNCIONA: AL DAR ONCREATE CREAR LOS INTENTS Y LA ALARMA?? O SERA
//MEJOR REVISAR SI NO HA SIDO CREADA ANTES (PROBABLEMENTE ESTE CORRECTO SOLO HEADS UP
    public void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

//    Falta crear la clase notificacion (tendria que ser el intent que llame la notificacion de la barra)
    Intent intentNotification = new Intent(repeatingAlarm.this, notificacion.class);

//    Falta usar el pending intent, contexto repeatingAlarm y llamara al intentNotification que debera
//    invocar la notificacion en la barra de tareas
    PendingIntent pendingIntentNoti = PendingIntent.getService(repeatingAlarm.this,0,intentNotification,0);

//    Aqui crea el alarmManager, guiate segun la pagina web android-er y los ejemlos
//Inicializando objeto del tipo alarma...beeep....beeep

    AlarmManager laAlarma = (AlarmManager) getSystemService(ALARM_SERVICE);

//    Creando un objeto de la clase Calendar para determinar la fecha actual en la app, AHUUUU!!!

    Calendar calendario = Calendar.getInstance();
    calendario.setTimeInMillis(System.currentTimeMillis());

//    PARA FINES DE PRUEBA SE AJUSTO EL CALENDARIO A SUMAR 10 SEGUNDOS A LA HORA ACTUAL
//    EN EL PROGRAMA DEBERAS ECONTRAR LA FORMA DE QUE LLEGUE A LA MISMA HORA DEL DIA PARA EL CASO
//    6:00 AM O 12:00 AM

    calendario.add(Calendar.SECOND,10);
    laAlarma.set(AlarmManager.RTC_WAKEUP, calendario.getTimeInMillis(), pendingIntentNoti );

//    Este Toast solo es para indicar que la alarma ya esta hecha, para el mero programa
//    tu decides si se queda o no
    Toast.makeText(repeatingAlarm.this, "Lee la biblia diariamente", Toast.LENGTH_LONG).show();


//APARENTEMENTE YA ESTA HECHA LA ALARMA
//SIGUIENTE PASO CREAR LA CLASE notificacion EN UN NUEVO JAVA

}

}
