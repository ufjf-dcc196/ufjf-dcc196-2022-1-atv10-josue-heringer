package br.ufjf.dcc196.github;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    @Override
    public int getItemCount(){
        return usuarios.size();
    }



    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context contexto = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View usuarioView = inflater.inflate(R.layout.usuario_layout, parent, false);
        UsuarioViewHolder holder = new UsuarioViewHolder(usuarioView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        new DownloadImageTask((ImageView) holder.imageViewAvatar)
                .execute(usuario.getAvatar());
        holder.textViewBio.setText(usuario.getBio());
        holder.textViewLogin.setText(usuario.getLogin());
        holder.textViewCadastro.setText(usuario.getCadastro());
        holder.textViewRanking.setText(String.valueOf(position + 1));
       holder.textViewSeguidores.setText(String.valueOf(usuario.getSeguidores()));

    }



    public class UsuarioViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageViewAvatar;
        private TextView textViewBio;
        private TextView textViewLogin;
        private TextView textViewCadastro;
        private TextView textViewRanking;
        private TextView textViewSeguidores;
        public UsuarioViewHolder(@NonNull View itemView){
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
            textViewBio = itemView.findViewById(R.id.textViewBio);
            textViewLogin = itemView.findViewById(R.id.textViewLogin);
            textViewCadastro = itemView.findViewById(R.id.textViewCadastro);
            textViewRanking = itemView.findViewById(R.id.textViewRanking);
            textViewSeguidores = itemView.findViewById(R.id.textViewSeguidores);
        }
    }

    public void remove(int position) {
        if (position < 0 || position >= usuarios.size()) {
            return;
        }
        usuarios.remove(position);
    }

    public void add(Usuario usuario) {
        usuarios.add(usuario);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
