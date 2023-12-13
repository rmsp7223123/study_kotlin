package com.example.study_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.study_kotlin.databinding.ActivityMainBinding
import java.util.Map

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

    private fun TypeConversion() { // 형변환

//        toByte() : Byte 타입으로 변환
//        toUByte() : unsigned 타입인 UByte 타입으로 변환
//        toShort() : Short 타입으로 변환
//        toUShort() : unsigned 타입인 UShort 타입으로 변환
//        toInt() : Int 타입으로 변환
//        toUInt() : unsigned 타입인 UInt 타입으로 변환
//        toLong() : Long 타입으로 변환
//        toULong() : unsigned 타입인 ULong 타입으로 변환
//        toFloat() : Float 타입으로 변환
//        toDouble() : Double 타입으로 변환
//        toChar() : Char 타입으로 변환
//        toString() : String 타입으로 변환
//        toBigInteger() : BigInteger 타입으로 변환
//        toBigDecimal() : BigDecimal 타입으로 변환

        val a: Long = 34;
        val b: Int = a.toInt();  // Long을 Int로 강제 형변환

        val str: String = "123";
        val c = Integer.parseInt(str);  // 정수 123으로 변환

        // 스마트 캐스트
        val map = Map.of<String, Any>("key1", "value1", "key2", 2);
        val a2 = map["key1"];
        if (a2 is String) { // if문의 조건식에서 is로 타입을 검사한 경우
            // 해당 if문 블록의 내부에서는 따로 형변환을 해주지 않아도 자동으로 검사한 타입으로 취급
            println(a2.length);
        };

        val input1:Any = "test";
        if (input1 is String) { // is로 자료형 체크 Int, Float, String 등이 사용가능
            val output1 : String = input1 as String; // as로 any 자료형을 String으로 변환
        };

        val output2:String? = input1 as String?; // 널허용자료형도 가능
        val output3 = input1 as? String // as?는 변환시 null이 반환될 수 있을 때 예외 상황을 만들지 않고 null을 반환
        val output4 = input1 as? String ?: "None"; // 형변환 실패시 None으로 초기화

    };

    private fun array() { // 배열
        var array = arrayOf(1,2,3); // 특정 값을 넣어서 배열을 생성하는 경우
        var array2 = Array(10) { 0 }; // 크기만 정해서 배열을 생성하는 경우
                                           // 크기가 10인 배열을 만드는 것을 의미하고, 중괄호 안의 0은 배열의 각 요소에 초기화할 값
        var anyArray = arrayOf(1,2,3,"adsfdsf",4,true); // 특정 타입을 지정하지 않은채로 배열을 생성하면 어떤 값이든 상관없음

        var arrayInt = arrayOf<Int>(1,2,3,4,5); // 특정 타입을 지정
        var arrayString = arrayOf<String>("adfa","asdfadsf");

        array2.set(0, 1000) //= array2[0] = 1000 0번 인덱스에 1000을 넣음
        array2.get(2) //= array[2]
    }
};