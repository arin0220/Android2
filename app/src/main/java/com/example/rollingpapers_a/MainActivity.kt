package com.example.rollingpapers_a


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : Activity() {
    private lateinit var nameEditText: EditText // 이름을 입력하는 EditText
    private lateinit var menuEditText: EditText // 메뉴를 입력하는 EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EditText 위젯을 findViewById를 사용하여 연결
        nameEditText = findViewById(R.id.name)
        menuEditText = findViewById(R.id.menu)
    }

    // 버튼 클릭 이벤트 핸들러 메서드
    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.shareButton -> {
                // 버튼이 클릭되었을 때 EditText에서 값을 가져와서 문자열로 변환
                val nameText = nameEditText.text.toString()
                val menuText = menuEditText.text.toString()

                // 가져온 값들을 이용하여 Toast 메시지 표시
                val message = "축하 받을 분의 성함 : $nameText \n 내용: $menuText"
                //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                // 공유 인텐트를 생성
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, message) // 메시지 변수를 공유할 데이터로 사용
                }

                // 공유 인텐트를 시작
                startActivity(Intent.createChooser(shareIntent, "텍스트 공유하기"))
            }
        }
    }

}
