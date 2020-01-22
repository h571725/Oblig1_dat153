package com.example.oblig1.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oblig1.R;


import java.util.ArrayList;
import java.util.HashMap;

public class QuizRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<QuizItem> items;
    private HashMap<QuizItem, String> userAnswers;

    public QuizRecyclerViewAdapter(ArrayList<QuizItem> items, HashMap<QuizItem, String> userAnswers) {
        this.items = items;
        this.userAnswers = userAnswers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cellForRow = layoutInflater.inflate(R.layout.quiz_item, parent, false);
        return new ViewHolder(cellForRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView userAnswerTextView = holder.itemView.findViewById(R.id.userAnswerTextView);
        TextView correctAnswerTextView = holder.itemView.findViewById(R.id.correctAnswerTextView);
        ImageView image = holder.itemView.findViewById(R.id.imageView);
        QuizItem item =items.get(position);
        correctAnswerTextView.setText(item.getCorrectAnswer());
        userAnswerTextView.setText(userAnswers.get(item));
        image.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
