package kr.co.tjoeun.listview_20200706.datas

import java.util.*

//신규 생성 시 class Stuent {} 로 클래스 파일이 생성된다.
//생성자 선언 시 class Stuent(){} <- 괄호 추가해주면 생성자를 만든 것.
//실습 클래스는 생성자에 String, Int 타입의 총 3개 매개변수를 추가해줌
class Student(val name: String, val address: String, val birthYear:Int) {

//    공통함수 만들기
    fun getKoreanAge() : Int
    {
        //return 2020 - this.birthYear + 1

        //Calendar.getInstance() -> 현재 시간 return
        val now = Calendar.getInstance()

        return now.get(Calendar.YEAR) - this.birthYear + 1
    }


}