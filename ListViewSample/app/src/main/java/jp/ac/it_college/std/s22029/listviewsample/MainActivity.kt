package jp.ac.it_college.std.s22029.listviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import jp.ac.it_college.std.s22029.listviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lvMenu.onItemClickListener = ListItemClickListener()
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた定食名を取得
            val item = parent.getItemAtPosition(position) as String
            // トーストで表示する文字列を生成
            val show = "あなたが選んだ定食： $item"
            // トーストの表示
            Toast.makeText(this@MainActivity, show, Toast.LENGTH_LONG).show()
        }
    }
}