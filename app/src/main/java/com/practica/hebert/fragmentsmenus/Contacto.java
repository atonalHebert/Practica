package com.practica.hebert.fragmentsmenus;

import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    private Toolbar toolbar ;
    private Button btnEnviarComentario ;
    private EditText edtNombreUsuario, edtCorreo, edtMensaje ;
    private TextInputLayout tilNombreUsuario, tilCorreo, tilMensaje ;
    final private String correo = CorreoContrasena.correo ;
    final private String contraseña = CorreoContrasena.contraseña ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        asignarReferenciasView() ;
        if(toolbar!=null) setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!camposLlenos()) return ;

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build() ;
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties() ;
                properties.put("mail.smtp.host","smtp.googlemail.com") ;
                properties.put("mail.smtp.socketFactory.port","465") ;
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory") ;
                properties.put("mail.smtp.auth","true") ;
                properties.put("mail.smtp.port","465") ;

                try{
                    final Session session = Session.getDefaultInstance(properties,new Authenticator(){
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication(correo, contraseña) ;
                        }
                    });
                    if(session!=null){
                        Message message = new MimeMessage(session) ;
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Práctica ANDROID");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(edtCorreo.getText().toString()));
                        message.setContent(edtMensaje.getText().toString(), "text/html; charset=utf-8");
                        Transport.send(message) ;
                    }
                    Toast.makeText(Contacto.this, "Comentario enviado" , Toast.LENGTH_SHORT).show() ;
                    finish();
                } catch (Exception e){
                    e.printStackTrace() ;
                    Toast.makeText(Contacto.this, "Correo inválido" , Toast.LENGTH_SHORT).show() ;
                }

            } // fin del método onClick
        }); // fin del método setOnClickListener


    } // fin del método onCreate

    private void asignarReferenciasView() {
        edtNombreUsuario = (EditText) findViewById(R.id.edtNombreUsuario) ;
        edtCorreo = (EditText) findViewById(R.id.edtCorreo) ;
        edtMensaje = (EditText) findViewById(R.id.edtMensaje) ;
        tilNombreUsuario = (TextInputLayout) findViewById(R.id.tilNombreUsuario) ;
        tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo) ;
        tilMensaje = (TextInputLayout) findViewById(R.id.tilMensaje) ;
        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario) ;
    } // fin del método asignarReferenciasView

    private boolean camposLlenos(){
        boolean camposLlenos = true ;
        if(edtNombreUsuario.getText().toString().isEmpty()){
          tilNombreUsuario.setError("Campo obligatorio");
          camposLlenos = false ;
        } else
            tilNombreUsuario.setErrorEnabled(false);
        if(edtCorreo.getText().toString().isEmpty()){
            tilCorreo.setError("Campo obligatorio");
            camposLlenos = false ;
        } else
            tilCorreo.setErrorEnabled(false);
        if(edtMensaje.getText().toString().isEmpty()){
            tilMensaje.setError("Campo obligatorio");
            camposLlenos = false ;
        } else
            tilMensaje.setErrorEnabled(false);
        return camposLlenos ;
    } // fin del método camposVacios
} // fin de la clase Contacto
