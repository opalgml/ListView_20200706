package kr.co.tjoeun.listview_20200706.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.co.tjoeun.listview_20200706.R
import kr.co.tjoeun.listview_20200706.datas.Student

//코틀린 상속은 : <- (java extends 와 동일.) 로 사용하며 <> 제네릭 타입 선언
class StudentAdapter(val mContext: Context, val resId: Int, val mList: List<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

//    화면을 그려줄 때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

//        받아온 임시 row 가 null 인지 chk! -> null인 경우 inf를 이용하여 채워줬음
        if(tempRow == null)
        {
//            null인 경우 inf를 이용하여 tempRow를 채워주자.
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

//        진짜 row에는 절대 null이 아닌 tempRow를 복사. (null인 경우 tempRow를 채우는 전처리작업을 했으므로 null일 수 없음.)
        val row = tempRow!!
//        row 뿌려달라고 return 처리

        return row
    }
}