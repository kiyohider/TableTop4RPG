package com.example.tabletopsupp.activity;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tabletopsupp.R;
import com.example.tabletopsupp.model.ItensMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class ItenCreation extends AppCompatActivity {

    private ImageView imageItem;
    private Button btnImageItem, btnCreateItem;
    private Uri selectedUri;
    private EditText itemName, itemDescription,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iten_creation);

        imageItem = findViewById(R.id.imageItem);
        btnImageItem = findViewById(R.id.btnItemImage);
        btnCreateItem = findViewById(R.id.addNewItem);
        itemName = findViewById(R.id.editItemName);
        itemDescription = findViewById(R.id.editItemDescription);
        weight = findViewById(R.id.editWeightItem);
        btnImageItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPhoto();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){

            selectedUri = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),selectedUri);
                imageItem.setImageDrawable(new BitmapDrawable(bitmap));
                btnImageItem.setAlpha(0);
            }
            catch (IOException e){
            }
        }

    }

    public void selectPhoto(){
       Intent intent = new Intent(Intent.ACTION_PICK);
       intent.setType("image/+");
       startActivityForResult(intent,0);

    }

    private void saveUserStore(){
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String filename = itemName.getText().toString();
        final StorageReference reference = FirebaseStorage.getInstance().getReference("/"+user+"/"+ filename);
        reference.putFile(selectedUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Log.i("testeuri",uri.toString());

                                String itemdescription = itemDescription.getText().toString();
                                String itemname = itemName.getText().toString();
                                String imageUrl = uri.toString();
                                int Weight = Integer.parseInt(weight.getText().toString());

                                ItensMaster itens = new ItensMaster(itemname,itemdescription,imageUrl,Weight);


                                FirebaseFirestore.getInstance().collection("users").document(user)
                                        .collection("utilites")
                                        .add(itens)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {

                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.i("testeuri",e.getMessage());
                                            }
                                        });
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("teste",e.getMessage(),e);
            }
        });
    }

    public void uploadItem(View view) {
        saveUserStore();
        Intent intent = new Intent(getApplicationContext(),GameMasterNavigation.class);
        startActivity(intent);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}