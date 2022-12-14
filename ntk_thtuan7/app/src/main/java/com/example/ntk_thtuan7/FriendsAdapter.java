package com.example.ntk_thtuan7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends FirebaseRecyclerAdapter<FriendsModel,FriendsAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FriendsAdapter(@NonNull FirebaseRecyclerOptions<FriendsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull FriendsModel model) {
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity= (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.view_pager,new Detail(model.getName(),model.getAge(),model.getImage())).addToBackStack(null).commit();

            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.image.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update))
                        .setExpanded(true, 1350)
                        .create();

                View view = dialogPlus.getHolderView();
                //anh xa
                EditText name = view.findViewById(R.id.edt_name);
                EditText age    = view.findViewById(R.id.edt_tuoi);

                EditText image   = view.findViewById(R.id.edt_address_image);

                Button btn_update = view.findViewById(R.id.btn_update);
                name.setText(model.getName());
                age.setText(model.getAge());

                image.setText(model.getImage());

                dialogPlus.show();

                btn_update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("age",age.getText().toString());

                        map.put("image",image.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("friend")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(),"Succesfully Updated ",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.name.getContext(),"Updated Failur2 ",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Remove");
                builder.setMessage("Deleted Data can't be recovered!");
                // xoa
                builder.setPositiveButton("Delete ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("friend")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(),"Removed was not done",Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });



    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_friend,parent,false);

        return new myViewHolder(view) ;

    }

    class  myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        ImageView edit,remove;
        TextView name,age;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            edit=itemView.findViewById(R.id.imgChat);
            remove=itemView.findViewById(R.id.imgPhone);

            image = (CircleImageView)itemView.findViewById(R.id.img1);
            name =(TextView)itemView.findViewById(R.id.nametext);
            age =(TextView)itemView.findViewById(R.id.nameage);
        }
    }
}
