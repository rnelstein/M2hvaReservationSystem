package com.hva.m2mobi.m2hva_reservationsystem.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hva.m2mobi.m2hva_reservationsystem.R;
import com.hva.m2mobi.m2hva_reservationsystem.models.Reservation;

import java.util.List;

public class ReservationsOverviewAdapter extends RecyclerView.Adapter<ReservationsOverviewAdapter.ReservationsViewHolder> {
    private List<Reservation> mReservationList;
    private OnItemClickListener mListener;
    private Context mContext;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setReservationList(List<Reservation> list){
        mReservationList = list;
    }

    public static class ReservationsViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView date;
        private TextView time;
        private TextView attendees;
        private ImageView resRoom;


        public ReservationsViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.reservation_title);
            date = itemView.findViewById(R.id.reservation_date);
            time = itemView.findViewById(R.id.reservation_time);
            attendees = itemView.findViewById(R.id.reservation_attendees);
            resRoom = itemView.findViewById(R.id.imageResRoom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ReservationsOverviewAdapter(List<Reservation> reservationsList, Context context) {
        mReservationList = reservationsList;
        mContext = context;
    }

    @NonNull
    @Override
    public ReservationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell_reservationsoverview, parent, false);
        return new ReservationsViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationsViewHolder holder, int position) {
        Reservation currentItem = mReservationList.get(position);
        Glide.with(mContext).load(currentItem.getReservationRoom().getImage()).into(holder.resRoom);
        holder.title.setText(currentItem.getReservationRoom().getName());

        holder.date.setText(R.string.rsv_date);
        holder.time.setText(R.string.rsv_clock);
        holder.attendees.setText(R.string.rsv_user);
        holder.date.setText(String.format("%s %s", holder.date.getText(), currentItem.getDate()));
        holder.time.setText(String.format("%s %s - %s", holder.time.getText(), currentItem.getStartTime(), currentItem.getEndTime()));
        holder.attendees.setText(String.format("%s %s", holder.attendees.getText(), currentItem.getAttendees()));

        Typeface custom_font;
        custom_font = ResourcesCompat.getFont(holder.attendees.getContext(), R.font.fa_solid_900);
        holder.date.setTypeface(custom_font);
        holder.time.setTypeface(custom_font);
        holder.attendees.setTypeface(custom_font);
    }

    public void swapList(List<Reservation> newList) {
        mReservationList = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mReservationList.size();
    }
}
