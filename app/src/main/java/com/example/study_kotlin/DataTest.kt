package com.example.study_kotlin

data class DataTest(val name: String, val email: String, val age: Int);
// 기본 생성자는 1개 이상의 매개 변수를 가져야함
// 모든 기본 생성자 매개 변수는 val 또는 var로 선언
// abstract, open, sealed, inner 문법과 같이 사용할 수 없음
// 데이터 클래스는 부모(슈퍼) 클래스의 함수나 변수에 접근할 수 없어 충돌이 나기때문에 상속을 지원하지 않음

