package com.example.study_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.study_kotlin.databinding.ActivityMainBinding
import java.util.Map

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding; // 변수의 초기화 미루기
    // var 키워드로 선언한 변수만 가능
    // 기본형(Primitive) 타입으로 분류되는 Int, Long, Short, Double, Float, Boolean, Byte에는 사용할 수 없음

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

    private fun visibilityModifier() {
        // public    -> 모든곳에서 접근 가능
        // protected -> 선언된 클래스 또는 하위 클래스에서만 접근 가능
        // internal  -> 같은 모듈에서만 접근 가능
        // private   -> 선언된 클래스 내에서만 접근 가능
    }

    class Box<T>(var content: T) { // 제네릭 , T = 타입파라미터, 어떤 타입의 요소든 다 담을 수 있음
        fun getContent(): T {
            return content;
        };
    };

    fun <T> printContent(content: T) { // 제네릭 함수
        println("Content: $content");
    }

    fun <T : Number> convertAndPrint(value: T) { // 제네릭 제약
        val convertedValue = value.toDouble() // Number 타입을 상속받은 타입만 허용됨
        println("Converted value: $convertedValue")
    }

    private fun generic() { // 제네릭
        // 파일 시점에 타입 불일치 오류를 잡아내므로 런타임 오류를 줄여줌
        // 하나의 제네릭 클래스 또는 함수를 여러 타입에 대해 재사용할 수 있음
        // 다양한 타입을 지원하면서도 타입 안전성을 유지

        val intBox = Box(10); // int타입 저장
        val stringBox = Box("adsfsd"); // String타입 저장
        val intValue = intBox.getContent();
        val stringValue = stringBox.getContent();

        printContent("gdg");
        printContent(123);
        convertAndPrint(123);
    }

    private fun collection() { // 컬렉션
        // List는 순서가 있는 데이터의 집합으로 중복된 요소를 가질 수 있음
        val immutableList = listOf(1, 2, 3, 4, 5); // 변경할 수 없는(immutable) 리스트
        val mutableList = mutableListOf("apple", "banana", "orange"); // 변경 가능한(mutable) 리스트

        // Set는 순서가 없고 중복 요소를 허용하지 않음
        val immutableSet = setOf(1, 2, 3, 4, 5); // setOf()는 변경할 수 없는 세트
        val mutableSet = mutableSetOf("apple", "banana", "orange"); // mutableSetOf()은 변경 가능한 세트

        // Map은 키-값 쌍의 집합으로, 각 키는 유일해야 함
        val immutableMap = mapOf("a" to 1, "b" to 2, "c" to 3); // mapOf()는 변경할 수 없는 맵
        val mutableMap = mutableMapOf("x" to "apple", "y" to "banana", "z" to "orange"); // mutableMapOf()은 변경 가능한 맵

        // 해쉬맵은 키와 값으로 이루어진 데이터를 저장하는 해시테이블 기반의 컬렉션
        val hashMap = mutableMapOf<String, Int>(); // 키는 String, 값은 Int인 빈 해쉬맵 생성
        hashMap["apple"] = 5; // "apple"이라는 키에 5라는 값을 할당
        hashMap["banana"] = 3; // "banana"라는 키에 3이라는 값을 할당

        // 맵과 해쉬맵의 차이점
        // 해쉬맵은 해시 테이블을 기반으로 하며,
        // 내부적으로 해시 함수를 사용하여 키-값 쌍을 저장
        // 이에 반해 일반적인 맵은 내부 구현체에 따라 다양한 방식으로 데이터를 관리
        // 일반적으로 해쉬맵이 더 빠름

        val set = setOf(1, 2, 3, 4, 5);
        val list = set.toList(); // 리스트로 변환
        println(list); // 출력: [1, 2, 3, 4, 5]

        val list2 = listOf(1, 2, 2, 3, 4, 4, 5);
        val set2 = list2.toSet(); // Set으로 변환
        println(set2); // 출력: [1, 2, 3, 4, 5];

        val pairsList = listOf("a" to 1, "b" to 2, "c" to 3);
        val map = pairsList.toMap(); // 컬렉션을 맵으로 변환, 키-값으로 구성 되어야함
        println(map["b"]); // 출력: 2

        val list3 = listOf("a" to 1, "b" to 2, "c" to 3);
        val hashMap2 = list3.toMap().toMutableMap(); // 리스트를 맵으로 변환한 후, 해당 맵을 해쉬맵으로 변환
        println(hashMap2["a"]); // 출력 : 1

    };

    private fun dataClass() { // 데이터 클래스
        val test1 = DataTest("이름","이메일",123);
        val test2 = DataTest("이름","이메일",123);
        val test3 = test1.copy(name = "이름3");
        println(test1); // 이름 이메일 123
        println(test3); // 이름3 이메일 123
        println(test1.hashCode()); // = println(test2.hashCode())
    }

    fun sum(a: Int, b: Int):Int { // 일반 함수
        // 가장 일반적인 함수 형태로, 매개변수를 받아 연산을 수행하고 값을 반환
        return a + b;
    };

    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int { // 고차 함수
        // 다른 함수를 매개변수로 받거나 함수를 반환하는 함수
        // 함수를 일급 객체(First-class Citizen)로 취급하고, 함수를 다루는 함수
        return operation(a, b);
    };

    fun calculate(a: Int, b: Int): Int { // 내부 함수
        // 다른 함수 내부에 정의된 함수
        // 해당 함수는 외부에서 직접 접근할 수 없고, 외부 함수 내부에서만 호출 가능
        fun add(): Int {
            return a + b;
        };
        return add();
    };

    val multiply = fun(x: Int, y: Int): Int { // 익명 함수
        // 이름 없이 정의된 함수로, 변수에 할당하여 사용 할 수 있음
        // 주로 고차 함수의 매개변수로 사용
        return x * y
    }

    val multiply2: (Int, Int) -> Int = { x, y -> x * y }; // 익명 함수 람다식

    fun String.removeFirstChar(): String { // 확장 함수
        // 이미 존재하는 클래스에 새로운 함수를 추가하는 기능
        // 클래스의 멤버 함수처럼 호출할 수 있지만, 해당 클래스를 직접 수정하지 않고도 함수를 추가할 수 있음
        return this.substring(1);
    };

    private fun function() { // 함수
        // 함수(Function)는 프로그래밍에서 특정 작업을 수행하는 블록 또는 코드 단위
        // 함수는 프로그래밍에서 핵심적인 요소로, 코드의 재사용성, 가독성, 유지보수성을 높이는 데 중요한 역할
        val result = sum(1,2);
        println(result); // 출력 : 3

        val addition = operateOnNumbers(5, 3) { x, y -> x + y };
        val multiplication = operateOnNumbers(5, 3) { x, y -> x * y };

        println(addition); // 출력: 8
        println(multiplication); // 출력: 15

        val result2 = calculate(5, 3);
        println(result2) // 출력: 8

        val result3 = multiply(5, 3);
        println(result3) // 출력: 15

        val originalString = "Hello";
        val modifiedString = originalString.removeFirstChar();
        println(modifiedString); // 출력: "ello"
    }




};