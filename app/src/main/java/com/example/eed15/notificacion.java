package com.example.eed15;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Peto-1 on 12/30/2014.
 */
public class notificacion extends Activity {


public void creadorNotificacion() {

//    Creando Notification builder
        NotificationCompat.Builder constructorNotificacion = new NotificationCompat.Builder(this);

//    Creando Intent para llamar al Main

        Intent intentalMain = new Intent(notificacion.this, main.class);

//    Colocando flag para que pase al frente del history stack, no se ejecuta si ya esta corriendo
//    ALERTA ESTO TE PUEDE DAR PROBLEMAS PUES LO TRAES DEL EJEMPLO SIN TENER CLARO PORQUE

        intentalMain.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

//crando pendint intent para llamar al inentalMain, ATENTO QUE NO SE SABE SI FLAG_UPDATE_CURRENT
//    ES REALMENTE NECESARIO?????

    PendingIntent napoLeon = PendingIntent.getActivity(this,0,intentalMain,PendingIntent.FLAG_UPDATE_CURRENT);

//    colocando pendint intent napoLeon al Notificationcompat.Builder llamado constructorNotificacion, creado
//    anteiormente
    constructorNotificacion.setContentIntent(napoLeon);

//    agrengando ticker ESTE SOLO ES PLANTE LO PODEMOS QUITAR pero diversion va primero

    constructorNotificacion.setTicker(getResources().getString(R.string.ticker));

//    Creando la imagen de la barra de tareas

    constructorNotificacion.setSmallIcon(R.drawable.noti_ico);

//    Cancelando la notificacion al darle clic

    constructorNotificacion.setAutoCancel(true);

//    ATENCION AQUI SEGUI CREANDO LA ANIMACION DE ABRIR EL EXAMINANDO SEGUN EL EJEMPLO DE CUSTOM
//    NOTIFICATION, ANTES PROBA LA APP CREANDO EL MAIN


    }


}
