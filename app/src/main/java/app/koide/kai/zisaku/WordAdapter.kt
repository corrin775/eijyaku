package layout

import android.annotation.SuppressLint
import android.location.LocationListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.koide.kai.zisaku.Word
import app.koide.kai.zisaku.WordViewHolder
import app.koide.kai.zisaku.databinding.ItemDataCellBinding

class WordAdapter (
    private val onClickCellListener: OnCellClickListener
    ) : RecyclerView.Adapter<WordViewHolder>(){
        private val wordList: MutableList<Word> = mutableListOf()
        override fun getItemCount(): Int = wordList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
                val binding = ItemDataCellBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return WordViewHolder(binding)
        }

        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
                val word = wordList[position]
                holder.binding.JPtext.text = word.jp
                holder.binding.Entext.text = word.english

                holder.binding.root.setOnClickListener{
                        onClickCellListener.onCLick(position)

                }
        }

        @SuppressLint("NotifDataSetChanged")
        fun updateWordList(newList: List<Word>){
                wordList.clear()
                wordList.addAll(newList)
                notifyDataSetChanged()
        }


        interface OnCellClickListener{
                fun onCLick(position: Int)
        }


    }

