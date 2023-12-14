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

    private fun conditionalSentence() { // 조건문
        val number = 10;

        if (number > 0) { // if 문은 조건을 확인하여 특정 코드 블록을 실행
            println("양수");
        } else if (number < 0) {
            println("음수");
        } else {
            println("0");
        };


        when (number) { // when 문은 여러 경우(case)를 처리할 때 사용
            1 -> println("number는 1입니다.");
            2, 3 -> println("number는 2 또는 3입니다.");
            in 4..10 -> println("number는 4에서 10 사이입니다.");
            else -> println("그 외의 경우입니다.");
        };


        val result = if (number % 2 == 0) { // 표현식으로 사용하기
            "짝수입니다.";
        } else {
            "홀수입니다.";
        };
        println(result);



        val str = "123"
        try { // try 블록 안에서 예외가 발생할 수 있는 코드를 작성하고, 예외가 발생하면 catch 블록에서 해당 예외를 처리
            val num = str.toInt(); // 예외가 발생할 수 있는 코드
            println("숫자로 변환된 값: $num");
        } catch (e: NumberFormatException) { // 예외를 잡아서 처리하는 부분
            println("숫자로 변환할 수 없는 문자열입니다.");
        } catch (e: Exception) { // 다중 catch블록이 가능
            println("일반적인 예외 발생: ${e.message}")
        } finally { // 선택적으로 사용할 수 있는 finally 블록
            println("처리 완료");
        };

        val result2 = try { // 표현식으로 사용하기
            str.toInt();
        } catch (e: NumberFormatException) {
            -1;
        } finally {
            println("처리 완료");
        };
        println(result2);


        val name: String? = "이름"
        name?.let { // 객체가 null이 아닌 경우에 코드 블록을 실행
            println("Name: $it"); // name이 null이 아닐경우에 실행됨
        };


        val result3 = run {// 객체에 대해 수행할 코드 블록을 지정하고
                                          // 해당 객체를 이 블록의 수신 객체로 사용
            val x = 10;
            val y = 20;
            x + y;
        };
        println("Result: $result3");


        val value = 10;
        value.also { // 수신 객체를 인자로 받아 수신 객체를 그대로 반환
                           // 주로 수신 객체를 변경하지 않으면서 부수 효과를 가질 때 사용
            println("Value: $it"); // value 값을 출력
        }.let {
            println("It doubled: ${it * 2}"); // value 값의 2배를 출력
        };
    };

    private fun loop() { // 반복문
        fun main(args:Array<String>) {
            for(i: Int in 1..10) print("$i ");//1, 2, 3, 4, 5 ... 10
            val len: Int = 5;
            for(i in 1..len) print("$i ");//1, 2, 3, 4, 5
            for(i in 1 until len) print("$i ");//1, 2, 3, 4


            for(i: Int in 1..10 step(2)) print("$i ");//1, 3, 5, 7, 9
            for(i in 10..1 step(-1)) print("$i ");// 음수는 불가능

            for(i in 10 downTo 1) print("$i "); //10, 9, 8, 7 ... 1
            for(i in 10 downTo 1 step(2)) print("$i ");//10, 8, 6, 4, 2

            val arr: IntArray = intArrayOf(10, 20, 30, 40, 50); // 배열을 직접 입력해서 값을 호출
            for(i in arr) print("$i "); //10, 20, 30, 40, 50
            for(i in arr.reversed()) print("$i ");//50, 40, 30, 20, 10
            val list = listOf<String>("korea", "salmon", "T_T");
            for(i in list) print("$i ");// korea, salmon, T_T
            for(i in 0 until list.count()) print("${list[i]} ");//korea, salmon, T_T

            var a: Int = 1;
            while(a <= 10) print("${a++} ")// 1, 2, 3, 4, 5 ... 10
            do {print("${a--} ")} while(a > 0) //output : 11, 10, 9, 8, 7 ... 1

        }
    }
};