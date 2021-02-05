package br.com.recyclerview_atual

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val recycler by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val button by lazy { findViewById<Button>(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val aluno = getAluno()

        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = AlunoAdapter(aluno, object : ModeAluno{
            override fun retrieveAlunoAndPosition(aluno: Aluno, position: Int) {
                Toast.makeText(this@MainActivity, "$aluno, position = $position", Toast.LENGTH_LONG)
                        .show()
            }
        })

        recycler.adapter = adapter

        button.setOnClickListener {
            adapter.addAluno()
        }
    }

    private fun getAluno(): MutableList<Aluno> {
        val alunosList = mutableListOf<Aluno>()

        for(i in 0..30){
            val aluno = Aluno("Aluno $i", "Matrícula $i")
            alunosList.add(aluno)
        }
    return alunosList
    }

}