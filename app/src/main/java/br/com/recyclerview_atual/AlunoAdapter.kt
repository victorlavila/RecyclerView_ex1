package br.com.recyclerview_atual

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter (private val alunoList: MutableList<Aluno>, val alunoSelected : ModeAluno) :
    RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunoAdapter.AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aluno_item, parent, false)
        return AlunoViewHolder(view)
    }

    override fun getItemCount() = alunoList.size

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val name = holder.name
        name.text = alunoList[position].nome

        val matricula = holder.matricula
        matricula.text = alunoList[position].matricula

        holder.itemView.setOnClickListener{
            alunoSelected.retrieveAlunoAndPosition(alunoList[position], position)
        }
    }

    fun addAluno(){
        alunoList.add(Aluno("Aluno ${alunoList.size}", "Matrícula ${alunoList.size}"))
        notifyDataSetChanged()
    }

    inner class AlunoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val name by lazy { view.findViewById<TextView>(R.id.aluno_nome) }
        val matricula by lazy { view.findViewById<TextView>(R.id.aluno_matricula) }
    }


}