package com.example.news_app

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var otp : String
    private lateinit var Number : String
    private lateinit var otpsent : TextView
    private lateinit var resendotp : TextView
    private lateinit var getotp : TextView
    private lateinit var Verify : Button
    private lateinit var OTP : String
    private lateinit var resendToken : PhoneAuthProvider.ForceResendingToken

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = Firebase.auth
        otp = findViewById<EditText>(R.id.editText2).text.toString()
        Number = findViewById<EditText>(R.id.editText).text.toString()
        resendotp.visibility = View.INVISIBLE

        getotp.setOnClickListener {
            if (Number.length == 10)
            {
                var phoneNumber = "+91$Number"
                val options = PhoneAuthOptions.newBuilder(auth)
                    .setPhoneNumber(phoneNumber)
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(this)
                    .setCallbacks(callbacks)
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
                resendOTPVisibility()
            }
            else
            {
                Toast.makeText(this,"ENTER CORRECT NUMBER",Toast.LENGTH_SHORT).show()
            }
        }
        Verify = findViewById<Button>(R.id.button)
        Verify.setOnClickListener{
            if (otp.length == 6)
            {
             val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(OTP,otp)
                signInWithPhoneAuthCredential(credential)
            }
            else
            {
                Toast.makeText(this,"ENTER CORRECT OTP",Toast.LENGTH_SHORT).show()
            }
        }
        resendotp.setOnClickListener{
        var phoneNumber = "+91$Number"
            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(callbacks)
                .setForceResendingToken(resendToken)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }

     private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {

            Log.d("TAG", "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w("TAG", "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d("TAG", "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            OTP = verificationId
            resendToken = token
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Sign in success",Toast.LENGTH_SHORT)
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")
                    startActivity(Intent(this,MainActivity::class.java))

                    val user = task.result?.user
                } else {
                    Toast.makeText(this,"Sign in failed",Toast.LENGTH_SHORT)
                    // Sign in failed, display a message and update the UI
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(this,"The verification code entered was invalid",Toast.LENGTH_SHORT)
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    private fun resendOTPVisibility() {
        resendotp.isEnabled = false

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            resendotp.visibility = View.VISIBLE
            resendotp.isEnabled = true
        }, 60000)
    }
}