package com.theflown.theflownapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.theflown.theflownapp.HeldIssueActivity;
import com.theflown.theflownapp.R;
import com.theflown.theflownapp.data.room.Issue;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.ViewHolder> {

    private static final String TAG = "IssueAdapter";
    // Store a member variable for the contacts
    private List<Issue> mIssue;
    private Context context;
    //to make items clickable
    private AdapterView.OnItemClickListener listener;
    private final LayoutInflater mInflater;


    // Pass in the IssueModel array into the constructor
    public IssueAdapter(Context con, List<Issue> pro) {
        this.context = con;
        this.mIssue = pro; //save list of issues in constructor
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = mInflater.inflate(R.layout.row_issue, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set the view attributes based on the data
        if (mIssue != null) {
            Log.e(TAG, mIssue.get(position).toString());
            holder.setProblemName(mIssue.get(position).getIssueName());
            holder.setProblemDesc(mIssue.get(position).getIssueDescription());
            holder.setProblemPhoto(mIssue.get(position).getPhoto());
//            holder.setProblemStatus(mIssue.get(position).getIssueStatus());
//            holder.setProblemPriority(mIssue.get(position).getIssuePriority());
            holder.setProblemSite(mIssue.get(position).getIssueSite());
            holder.setProblemProject(mIssue.get(position).getIssueProject());
            holder.setProblemDate(mIssue.get(position).getIssueDate());
            holder.setOwner(mIssue.get(position).getIssueOwner());
        } else {
            // Covers the case of data not being ready yet.
            //Toast.makeText(HeldIssueActivity.class, "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        if (mIssue != null)
            return mIssue.size();
        else return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView problemDescTxt, problemNameTxt, problemPriorityTxt, problemStatusTxt, problemSiteTxt, problemProjectTxt, problemDateTxt, problemOwnerTxt;
        SimpleDraweeView imgView;
        ConstraintLayout RowIssue;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            problemNameTxt = itemView.findViewById(R.id.rowProblemNameTxt);
            problemDescTxt = itemView.findViewById(R.id.rowProblemDescTxt);
            imgView = itemView.findViewById(R.id.problemImageView);
            problemStatusTxt = itemView.findViewById(R.id.rowProblemStatus);
            problemPriorityTxt = itemView.findViewById(R.id.rowProblemPriority);
            problemSiteTxt = itemView.findViewById(R.id.rowProblemSite);
            problemProjectTxt = itemView.findViewById(R.id.rowProblemProject);
            problemDateTxt = itemView.findViewById(R.id.rowProblemDate);
            //the following is for the OnClick Listener!!
            RowIssue = (ConstraintLayout) itemView.findViewById(R.id.row_issue);
            problemOwnerTxt = itemView.findViewById(R.id.rowProblemOwner);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (listener != null && position != RecyclerView.NO_POSITION) {
//                        listener.OnItemClick(mIssue.get(position));
//                    }
//                }
//            });

//            itemView.setOnClickListener(new View.OnClickListener(){
//                int position = getAdapterPosition();
//                if(listener != null && position != RecyclerView.NO_POSITION){
//                    listener.OnItemClick(issues.get(position));
//                }
//            });
//            itemView.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (listener != null && position != RecyclerView.NO_POSITION) {
//                        listener.OnItemClick(issues.get(position));
//                    }
//                }
//            });

        }

        void setProblemName(String Name) {
            problemNameTxt.setText(Name);
        }

        void setProblemDesc(String desc) {
            problemDescTxt.setText(desc);
        }

        void setProblemPhoto(final String imgPath) {
//
//            Log.d(TAG, "this is image   " +ApiClient.Base_Url+imgPath);
//            imgView.setImageURI(ApiClient.Base_Url+imgPath);
//            imgView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try {
//                        //noinspection unchecked
//                        new ImageViewer.Builder(context, Collections.singletonList(ApiClient.Base_Url + imgPath))
//                                .setStartPosition(0)
//                                .show();
//                    }catch (Exception ignored){
//                        Log.e(TAG,"error in set image in IssueAdapter class" + "onClick: ");
//                    }
//                }
//            });
//            imgView.setVisibility(View.VISIBLE);
        }

        //void setProblemStatus(int Status) {problemStatusTxt.setText(Status);}
        void setProblemStatus(int Status) {
            problemStatusTxt.setText(HeldIssueActivity.status.get(Status));//this gets the name of the status I have now
//            problemStatusTxt.setText(String.valueOf(Status));
        }

        void setProblemPriority(long Priority) {
            problemPriorityTxt.setText(HeldIssueActivity.priority.get((int) Priority));//this gets the name of the priority I have now
//            problemPriorityTxt.setText(String.valueOf(Priority));
        }

        void setProblemSite(int Site) {
            problemSiteTxt.setText(String.valueOf(Site));
        }

        void setProblemProject(int Project) {
            problemProjectTxt.setText(String.valueOf(Project));
        }

        void setProblemDate(long Date) {
            String date_n = new SimpleDateFormat("dd-M-yyyy hh:mm", Locale.getDefault()).format(Date);

            problemDateTxt.setText(String.valueOf(date_n));
        }

        void setOwner(int Owner) {
            problemOwnerTxt.setText(String.valueOf(Owner));
        }

    }

    public void setIssues(List<Issue> issues) {
        mIssue = issues;
        notifyDataSetChanged();
    }

//    public interface OnItemClickListener {
//        void OnItemClick(Issue issue);
//    }

//        public void setOnItemClickListener(OnItemClickListener listener) {
//            this.listener = listener;
//        }

}
