package com.example.datachallenge.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.res.colorResource
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.datachallenge.Email
import com.example.datachallenge.R
import com.google.android.material.snackbar.Snackbar


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

                // toast
                val text = "Credenciales incorrectas!"
                val duration = Toast.LENGTH_SHORT
//                val toast = Toast.makeText(activity, text, duration) // in Activity
//                toast.setGravity(Gravity.CENTER, 0, 750);
//                toast.show()

  // ALTER DIALOG
//                val builder = AlertDialog.Builder(activity, androidx.transition.R.style.Base_V21_ThemeOverlay_AppCompat_Dialog)
//                builder.setTitle("Credenciales incorrectas!")
//                builder.setMessage(" Por favor, inténtalo de nuevo.")
//                builder.setPositiveButton("Aceptar") { dialog, which ->
//                    // Código a ejecutar cuando se hace clic en "Aceptar"
//                }
//                val alertDialog: AlertDialog = builder.create()
//                alertDialog.show()

                //snackbar
                val snackbar = Snackbar.make(v,text,duration)
                snackbar.setTextColor(Color.WHITE)
                snackbar.setBackgroundTint(getResources().getColor(R.color.colorPrimary))


                snackbar.show()




            }

        }

        return v
    }


}