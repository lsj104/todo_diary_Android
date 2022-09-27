package com.example.risingtest.src.main.write

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityTodoWirteBinding
import com.example.risingtest.src.main.write.todo.Memo
import com.example.risingtest.src.main.write.todo.SqliteHelper
import com.example.risingtest.src.main.write.todo.ToDoAdapter
import com.example.risingtest.src.main.write.todo.TodoWriteAdapter

class TodoWirteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoWirteBinding
    val helper = SqliteHelper(this, "memo", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoWirteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TodoWriteAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper.selectMemo())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        binding.btnTodoSave.setOnClickListener {
            if (binding.edittodo.text.toString().isNotEmpty()) {
                val memo = Memo(null, binding.edittodo.text.toString(), System.currentTimeMillis())
                helper.insertMemo(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()
                binding.edittodo.setText("")
            }
        }

    }
}