package kr.co.tjoeun.listview_20200706.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listview_20200706.R
import kr.co.tjoeun.listview_20200706.datas.Student

//코틀린 상속은 : <- (java extends 와 동일.) 로 사용하며 <> 제네릭 타입 선언
class StudentAdapter(val mContext: Context, val resId: Int, val mList: List<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

//    화면을 그려줄 때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View { //getView 는 한 줄의 데이터를 가져옴
//        position파라미터는 몇 번의 데이터에 내용을 추가할지에 대한 파라미터값이 설정된다.

        var tempRow = convertView

//        받아온 임시 row 가 null 인지 chk! -> null인 경우 inf를 이용하여 채워줬음
        if(tempRow == null)
        {
//            null인 경우 inf를 이용하여 tempRow를 채워주자.
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

//        진짜 row에는 절대 null이 아닌 tempRow를 복사. (null인 경우 tempRow를 채우는 전처리작업을 했으므로 null일 수 없음.)
        val row = tempRow!!

//        row 내용을 실제에 맞게 변경
        val data = mList[position] //코틀린에서 ArrayList 값을 가져오는 방법 -> List.[ArrayList Number] (Ex. java -> List.get(index))

//        실제 내용(row 내용) 을 가져옴
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val address = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

//        데이터를 반영한다.
        nameTxt.text = data.name
        address.text = data.address

        /*
        val age = 2020 - data.birthYear +1
        ageTxt.text = "${age}세"
        */

        ageTxt.text = "${data.getKoreanAge()}세"

//        row 뿌려달라고 return 처리 (결과로 지정)
        return row
}
}