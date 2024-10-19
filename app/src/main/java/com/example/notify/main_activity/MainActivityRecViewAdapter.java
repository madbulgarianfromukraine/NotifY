package com.example.notify.main_activity;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notify.R;
import com.example.notify.settings.SettingsActivityRecViewAdapter;
import com.example.notify.utils.Utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

public class MainActivityRecViewAdapter extends RecyclerView.Adapter<MainActivityRecViewAdapter.ViewHolder>{

    private Context context;

    public MainActivityRecViewAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_note_item, parent, false);
        return new MainActivityRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleText.setText(Utils.getInstance().notes.get(position).getTitle());
        Instant instant = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            instant = (Utils.getInstance().notes.get(position).getTimeLastAccessed()).toInstant(ZoneOffset.UTC);
        }
        Date lastOnlineDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            lastOnlineDate = Date.from(instant);
        }

        // Get the relative time span string (e.g., "5 minutes ago")
        CharSequence relativeTime = DateUtils.getRelativeTimeSpanString(
                lastOnlineDate.getTime(),  // The time to display
                System.currentTimeMillis(),  // Current time
                DateUtils.MINUTE_IN_MILLIS);
        holder.noteText.setText("Lastly accessed " + relativeTime);
    }

    @Override
    public int getItemCount() {
        return Utils.getInstance().notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView noteText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.titleText);
            noteText = (TextView) itemView.findViewById(R.id.dateText);
        }

    }


}
