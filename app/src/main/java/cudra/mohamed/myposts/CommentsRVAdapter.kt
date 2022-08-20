package cudra.mohamed.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cudra.mohamed.myposts.databinding.CommentListItemBinding

class CommentsRVAdapter (var commentsList:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentPost=commentsList.get(position)
        with(holder.binding){
            tvPostIdComment.text=currentPost.postId.toString()
            tvIdComment.text=currentPost.id.toString()
            tvNameComment.text=currentPost.name
            tvEmailComment.text=currentPost.email
            tvBodyComment.text=currentPost.body
        }
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }
}
class CommentsViewHolder(var binding: CommentListItemBinding):RecyclerView.ViewHolder(binding.root){
}