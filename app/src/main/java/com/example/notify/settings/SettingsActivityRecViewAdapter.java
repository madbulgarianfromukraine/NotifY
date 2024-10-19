package com.example.notify.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notify.R;

import java.util.List;

public class SettingsActivityRecViewAdapter extends RecyclerView.Adapter<SettingsActivityRecViewAdapter.ViewHolder> {

    private List<Setting> settingsList;
    private Context context;

    public SettingsActivityRecViewAdapter(List<Setting> settingsList, Context context){
        this.settingsList = settingsList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_settings_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mainText.setText(settingsList.get(position).getMainText());
        holder.subText.setText(settingsList.get(position).getSubText());

    }

    @Override
    public int getItemCount() {
        return settingsList.size();
    }

    public void setSettingsList(List<Setting> settingsList) {
        this.settingsList = settingsList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mainText;
        private TextView subText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            mainText = (TextView) itemView.findViewById(R.id.mainText);
            subText = (TextView) itemView.findViewById(R.id.subText);
        }

    }
}
