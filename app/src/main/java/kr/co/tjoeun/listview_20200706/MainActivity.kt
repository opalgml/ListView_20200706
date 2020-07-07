package kr.co.tjoeun.listview_20200706

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20200706.adapters.StudentAdapter
import kr.co.tjoeun.listview_20200706.datas.Student

class MainActivity : AppCompatActivity() {

//    학생 목록을 담고있는 변수 (ArrayList) 선언
    val mStudentList = ArrayList<Student>()

//    초기화 작업을 이후에 처리하는 변수 -> lateinit
    lateinit var mAdapter: ArrayAdapter<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        lateinit 으로 선언한(미뤄둔 어뎁터 객체화) 를 실행
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

//        완성된 어뎁터를 리스트뷰와 연결
        studentListView.adapter = mAdapter

//        학생 목록 리스트뷰 이벤트 처리
        studentListView.setOnItemClickListener { parent, view, position, id ->

//            각 줄을 누르면 "눌려진 사람의 이름"을 Toast로 출력

//            눌려진 사람이 누군지
            val clickedUser = mStudentList[position]

//            토스트로 눌려진 사람의 이름을 출력한다.
            Toast.makeText(this, clickedUser.name, Toast.LENGTH_SHORT).show()

        }

        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
        mStudentList.add(Student("김미희", "서울시 중랑구", 1995))
        mStudentList.add(Student("김재영", "서울시 은평구", 1986))
        mStudentList.add(Student("박호준", "인천시 부평구", 1990))
        mStudentList.add(Student("이예원", "서울시 금천구", 1984))
        mStudentList.add(Student("조장우", "서울시 종로구", 1983))
        mStudentList.add(Student("채정실", "서울시 용산구", 1991))

        mAdapter.notifyDataSetChanged()

//        학생 목록 Long_Click 이벤트 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            AlertDialog
            val deleteAlert = AlertDialog.Builder(this)
            deleteAlert.setTitle("학생 명단 삭제")
            deleteAlert.setMessage("정말 이 학생을 삭제하시겠습니까?")
            deleteAlert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->  //setPositiveButton("버튼text", 실행내용)

//                확인 클릭 시 arrayList.remove 처리
                //            오랫동안 클릭된 대상자를 명단에서 삭제
                mStudentList.removeAt(position)

//            삭제 후 어뎁터 새로고침 처리
                mAdapter.notifyDataSetChanged()

            })

            deleteAlert.setNegativeButton("취소", null)
            deleteAlert.show()


//            주의사항 -> LongClick이벤트는 반드시 리턴 처리 필수 (RETURN TYPE -> BOOLEAN)
            return@setOnItemLongClickListener true

        }
    }
}