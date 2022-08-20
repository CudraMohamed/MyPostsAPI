package cudra.mohamed.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cudra.mohamed.myposts.databinding.ActivityCommentsBinding
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostId()
        setupToolbar()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0  //elvis operator(if expretion is null it assigns the variable on the left else the right
    }

    fun fetchPostId(){
        val apiClient=ApiClient.buildApiCLient(ApiInterface::class.java)
        val request=apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    binding.tvPostTitle.text=post?.title
                    binding.tvPostBody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun setupToolbar(){
        setSupportActionBar(binding.toolbarCom)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
    fun fetchComments(){
        var apiClient=ApiClient.buildApiCLient((ApiInterface::class.java))
        var request=apiClient.getComments()
        request.enqueue(object :Call<List<Comment>>{
            override fun clone(): Call<List<Comment>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<Comment>> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<Comment>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }
        })

    }

}