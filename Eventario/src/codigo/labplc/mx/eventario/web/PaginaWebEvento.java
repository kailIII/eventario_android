package codigo.labplc.mx.eventario.web;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import codigo.labplc.mx.eventario.R;

public class PaginaWebEvento extends Activity implements OnClickListener {

	private String pagina;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina_web_evento);
		
		 final ActionBar ab = getActionBar();
	     ab.setDisplayShowHomeEnabled(false);
	     ab.setDisplayShowTitleEnabled(false);     
	     final LayoutInflater inflater = (LayoutInflater)getSystemService("layout_inflater");
	     View view = inflater.inflate(R.layout.abs_layout,null);   
	     ab.setDisplayShowCustomEnabled(true);
	     ((ImageView) view.findViewById(R.id.abs_layout_iv_logo)).setOnClickListener(this);;
	     ab.setCustomView(view,new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
	     ab.setCustomView(view);
		
		
		Bundle bundle = getIntent().getExtras();
		if(bundle!=null){
			 pagina =bundle.getString("pagina");
		}

		  WebView myWebView = (WebView) this.findViewById(R.id.pagina_evento_wb);
	      myWebView.loadUrl(pagina);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.abs_layout_iv_logo) {
	        	atras();
			}  
	    }
	
	/**
	 * sobreEscritura de onBack press
	 */
	public void atras(){
		super.onBackPressed();
	}
	
	
	
	 @Override
	public void onBackPressed() {
		 atras();
	}

}