package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.ui.base.BaseViewHolder;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FilteredQuizListRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    public static final int VIEWTYPE_QUIZMODEL = 0;
    public static final int VIEWTYPE_NONE = 1;

    AdapterCallback adapterCallback;
    List<QuizModel> quizModelList;

    public AdapterCallback getAdapterCallback() {
        return adapterCallback;
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    public List<QuizModel> getQuizModelList() {
        return quizModelList;
    }

    public void setQuizModelList(List<QuizModel> quizModelList) {
        this.quizModelList = quizModelList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEWTYPE_QUIZMODEL)
        {
            View quizModelView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.viewholder_quizmodel,parent,false);
            return new QuizViewHolder(quizModelView);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface AdapterCallback
    {
        void onRetryClicked();
        void onItemClicked(int position, long id);
    }

    class QuizViewHolder extends BaseViewHolder
    {
        @BindView(R.id.iv_image)
        ImageView ivImage;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_content)
        TextView tvContent;

        @BindView(R.id.tv_info)
        TextView tvInfo;


        public QuizViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        @Override
        protected void clear() {
            tvTitle.setText("");
            tvContent.setText("");
            tvInfo.setText("");
            ivImage.setImageDrawable(null);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            if(quizModelList!=null && quizModelList.size()>position)
            {
                QuizModel quizModel = quizModelList.get(position);

                if(quizModel!=null)
                {
                    QMainPhoto mainPhoto = quizModel.getMainPhoto();
                    if(mainPhoto!=null && mainPhoto.getUrl()!=null && mainPhoto.getUrl().length()>0)
                    {
                        Glide.with(itemView.getContext())
                                .load(mainPhoto.getUrl())
                                .asBitmap()
                                .centerCrop()
                                .into(ivImage);
                    }

                    tvTitle.setText(quizModel.getTitle());
                    tvContent.setText(quizModel.getContent());
                }
            }
        }
    }
}
