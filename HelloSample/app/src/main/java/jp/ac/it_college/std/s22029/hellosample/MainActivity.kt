package jp.ac.it_college.std.s22029.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.ac.it_college.std.s22029.hellosample.R.*
import jp.ac.it_college.std.s22029.hellosample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    ViewBinding 機能を使って画面を作る方法。
    activity_main.xml ファイルに対して ActivityMainBinding クラスが
    自動生成されます。（レイアウトファイル名 + Binding）
    */
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding クラスのインスタンスを生成してもらう。
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Binding クラスが管理しているビューを使う
        // setContentView(layout.activity_main)
        setContentView(binding.root)


        // ボタンを取ってくる
        //val  btClick = findViewById<Button>(R.id.btClick)
        // findViewById で取ってくるのは古い

        // リスナクラスのインスタンスを作る
        val listener = HelloListener()
        // Binding ボタンをリスナに設定する
        binding.btClick.setOnClickListener(listener)

    }

    private inner class HelloListener: View.OnClickListener {
        override fun onClick(v: View?){
            // 名前が入力されるであろう EditText を取ってくる
            //val input = findViewById<EditText>(id.etName)
            //val input = binding.etName

            // メッセージを出力する先の TextView を取ってくる
            // val output = findViewById<TextView>(id.tvOutout)
            //val output = binding.tvOutout

            // input(EditText) から入力内容を取り出して String型へ
            //val inputStr = input.text.toString()
            val inputStr = binding.etName.text.toString()

            // メッセージを出す
            // output.text = "${inputStr}さん、こんにちは"
            binding.tvOutout.text = "${inputStr}さん、こんにちは"
        }
    }
}}