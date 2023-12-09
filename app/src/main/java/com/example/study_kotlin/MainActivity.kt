package com.example.study_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.study_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
    };

    private fun Variable() { // 변수

        val name:String = "문병준"; // 읽기만 가능한 final 변수
        var age:Int = 20; // 읽기/쓰기 가능한 일반 변수
        var address = "서울"; // 타입생략이 가능

        // name = "홍길동" // 컴파일 오류
        age = 20; // 가능



        var str1 : String = "test";
        // str1 = null

        var str2 : String? = "test";
        str2 = null;

        // 변수에 null을 사용 하려면 변수 타입에 ?를 붙여 null을 사용 하겠다고 명시 해야함

        // str2.length 불가능
        // str2?.length null이 아니면 length null이면 null
        // str2!!.length // null이 아님을 단정

        val len = if(str2!= null) str2.length else -1; // = str2?.length ?: -1 ,  조건문을 통해 null을 검사 한 경우 컴파일 가능
        println("str2 : $str2, length : $len");
        println("str2 : $str2, lenght : ${str2?.length ?: -1}"); // null이면 -1 반환, 아니면 length 반환
    }
};