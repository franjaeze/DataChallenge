package com.example.datachallenge.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.datachallenge.Email
import com.example.datachallenge.R


class LoginFragment : Fragment() {
    lateinit var v: View;
    val users: Array<String> = arrayOf("fveron@gmail.com", "hola@mundo.com", "taller@progrmacion.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false)

        val b = v.findViewById<Button>(R.id.loginBtn)

        b.setOnClickListener{
            val f = v.findViewById<EditText>(R.id.username).text.toString();
            // el text es para obtener el valor del campo, y luego lo parceo a String

            val user: String = "fveron@gmail.com";

//            for (elemento in users) {
//                if (elemento == textoAComparar) {
//                    println("El texto coincide con un elemento del array.")
//                    break // Puedes usar break para salir del bucle si se encuentra una coincidencia
//                }
//            }
            if(f==user){
                val userEmail = Email(f); // asi se instancia una clase en kl, sin el new.Ojo que la debo importar antes
                val action = LoginFragmentDirections.actionLoginFragmentToDataFragment(userEmail)
                v.findNavController().navigate(action)
            } else {
                val text = "Credenciales incorrectas!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(activity, text, duration) // in Activity
                toast.setGravity(Gravity.CENTER, 0, 750);

                toast.show()


                val builder = AlertDialog.Builder(activity, androidx.transition.R.style.Base_V21_ThemeOverlay_AppCompat_Dialog)
                builder.setTitle("Credenciales incorrectas!")
                builder.setMessage(" Por favor, inténtalo de nuevo.")
                builder.setPositiveButton("Aceptar") { dialog, which ->
                    // Código a ejecutar cuando se hace clic en "Aceptar"
                }
    //snackbar
                val alertDialog: AlertDialog = builder.create()
                // Establecer la gravedad para centrar el AlertDialog
//                val window = alertDialog.window
//                val layoutParams = WindowManager.LayoutParams()
//                layoutParams.gravity = Gravity.CENTER
//                window?.attributes = layoutParams
                alertDialog.show()






            }

        }

        return v
    }


}