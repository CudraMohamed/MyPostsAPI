package cudra.mohamed.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cudra.mohamed.myposts.databinding.PostListItemsBinding

class PostRvAdapter (var postList:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        binding.mcvPosts

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        with(holder.binding){
            tvUserId.text=currentPost.userId.toString()
            tvId.text=currentPost.id.toString()
            tvTitle.text=currentPost.title
            tvBody.text=currentPost.body
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostViewHolder(var binding: PostListItemsBinding):RecyclerView.ViewHolder(binding.root){}