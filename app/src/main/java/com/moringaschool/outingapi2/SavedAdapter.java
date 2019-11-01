package com.moringaschool.outingapi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SavedAdapter extends BaseAdapter {
    private String[] mlocationNameText;
    private String[] mlocationTypeText;
    private String[] mlocationDescriptionText;
    private String[] mlocationDresscodeText;
    private String[] mlocationTimeText;
    private Context context;

    public SavedAdapter(String[] mlocationNameText, String[] mlocationTypeText, String[] mlocationDescriptionText, String[] mlocationDresscodeText, String[] mlocationTimeText, Context context) {
        this.mlocationNameText = mlocationNameText;
        this.mlocationTypeText = mlocationTypeText;
        this.mlocationDescriptionText = mlocationDescriptionText;
        this.mlocationDresscodeText = mlocationDresscodeText;
        this.mlocationTimeText = mlocationTimeText;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlocationNameText.length;


    }

    @Override
    public Object getItem(int position) {
        return mlocationNameText[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.saved,null);
        }
        TextView name=(TextView)convertView.findViewById(R.id.locationNameText);
        name.setText(mlocationNameText[position]);
        TextView type=(TextView)convertView.findViewById(R.id.locationTypeText);
        type.setText(mlocationTypeText[position]);
        TextView Description=(TextView)convertView.findViewById(R.id.locationDescriptionText);
        Description.setText(mlocationDescriptionText[position]);
        TextView Dresscode=(TextView)convertView.findViewById(R.id.locationDressCodeText);
        Dresscode.setText(mlocationDresscodeText[position]);
        TextView time=(TextView)convertView.findViewById(R.id.locationTimeText);
        time.setText(mlocationTimeText[position]);
        return  convertView;
    }
}
