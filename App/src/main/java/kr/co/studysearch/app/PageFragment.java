package kr.co.studysearch.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vio on 2013. 12. 12..
 */
public class PageFragment extends Fragment{
    public static final String[] CATEGORIES = {"Requested", "To Do", "In Progress", "Done", "Confirmed", "Rejected"};
    public static final String ARG_PAGE = "page";
    private int pageNum;

    public static PageFragment create(int pageNum){
        System.out.println("create" + pageNum);
        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNum);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    public PageFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pageNum = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.container, container, false);
        ((TextView)rootView.findViewById(R.id.category)).setText(CATEGORIES[pageNum]);

        ViewGroup taskList = (ViewGroup) rootView.findViewById(R.id.taskList);
        ViewGroup task = (ViewGroup) inflater.inflate(R.layout.task_layout, taskList, false);
        ((TextView)task.findViewById(R.id.title)).setText("hi");
        ((TextView)task.findViewById(R.id.inCharge)).setText("hello");
        ((TextView)task.findViewById(R.id.description)).setText("annyung");
        taskList.addView(task);
        return rootView;
    }
}
