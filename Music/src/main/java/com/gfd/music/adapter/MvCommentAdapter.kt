package com.gfd.music.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.gfd.common.ui.adapter.BaseAdapter
import com.gfd.common.ui.adapter.BaseViewHolder
import com.gfd.common.utils.FormatUtil
import com.gfd.common.utils.ImageLoader
import com.gfd.music.R
import com.gfd.music.entity.CommentData
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Author : 郭富东
 * @Date ：2018/8/17 - 17:48
 * @Email：878749089@qq.com
 * @descriptio：
 */
class MvCommentAdapter(val context: Context) : BaseAdapter<CommentData>(context) {
    override fun getItemLayoutId(): Int {
        return R.layout.item_mv_comment

    }

    override fun onBindView(holder: BaseViewHolder, position: Int) {
        val commentData = mDatas[position]
        val author = holder.getView<TextView>(R.id.tv_item_mvcomment_author)
        val good = holder.getView<TextView>(R.id.tv_item_mvcomment_good)
        val time = holder.getView<TextView>(R.id.tv_item_mvcomment_time)
        val content = holder.getView<TextView>(R.id.tv_item_mvcomment_content)
        val img = holder.getView<CircleImageView>(R.id.iv_item_mvcomment_pic)
        author.text = commentData.userName
        good.text = commentData.likedCount.toString()

        time.text = FormatUtil.formatDate(commentData.time)
        content.text = commentData.content
        ImageLoader.loadUrlImage(context,commentData.userPic,img)
    }

}