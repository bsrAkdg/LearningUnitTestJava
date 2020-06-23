package com.bsrakdg.noteapp.ui.notelist;

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsrakdg.noteapp.R;
import com.bsrakdg.noteapp.models.Note;
import com.bsrakdg.noteapp.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final String TAG = "NotesRecyclerAdapter";

    private List<Note> notes = new ArrayList<>();
    private OnNoteListener onNoteListener;

    NotesRecyclerAdapter(OnNoteListener onNoteListener) {
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_note_list_item, parent, false);
        return new ViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            String month = notes.get(position).getTimeStamp().substring(0, 2);
            month = DateUtil.getMonthFromNumber(month);
            String year = notes.get(position).getTimeStamp().substring(3);
            String timestamp = month + " " + year;
            ((ViewHolder) holder).timestamp.setText(timestamp);
            ((ViewHolder) holder).title.setText(notes.get(position).getTitle());
        } catch (NullPointerException e) {
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    Note getNote(int position) {
        if (notes.size() > 0) {
            return notes.get(position);
        }
        return null;
    }

    void removeNote(Note note) {
        notes.remove(note);
        notifyDataSetChanged();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public interface OnNoteListener {
        void onNoteClick(Note note);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView timestamp, title;
        OnNoteListener mOnNoteListener;

        ViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            timestamp = itemView.findViewById(R.id.note_timestamp);
            title = itemView.findViewById(R.id.note_title);
            mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getNote(getAdapterPosition()));
        }
    }
}

