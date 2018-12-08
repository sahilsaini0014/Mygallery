# My Gallery
## Introduction
Gallery is a layout widget used to display current selection at the center of the view and other items in a horizontally scrolling list (center-locked, horizontally scrolling list). Here is how it looks like:
(photo)
 Gallery is identified from the layout with FindViewById. The Adapter property is then used to set a custom [ImageAdapter]( https://alvinalexander.com/java/jwarehouse/apps-for-android/Panoramio/src/com/google/android/panoramio/ImageAdapter.java.shtml) as the source for all things to be shown in the gallery. Click here to know about [Adapters]( https://developer.android.com/reference/android/widget/Adapter) more.<br>
To accomplish something when a thing in the gallery is clicked, an unknown agent is bought in to the ItemClick event. It demonstrates a Toast that shows the file position of the selected thing (the position could be utilized to get the full image for some other task). <br>
![cupcake](https://user-images.githubusercontent.com/43186158/49691368-71abd280-fb0e-11e8-9420-c69f89163360.png)

<br>
There are a couple of factors, including a variety of IDs that reference the pictures saved in the drawable folder.<br>
Next is the class [Constructor](https://developer.android.com/reference/java/lang/reflect/Constructor) , where the Context for an ImageAdapter instance is defined and saved to a local field. Next, this implements some required methods acquired from BaseAdapter. <br>
The method takes every necessary step to apply a picture to an ImageView that will be inserted in the Gallery. In this method, the part Context is utilized to make another ImageView. The ImageView is set up by applying an image from the local array of drawable resources, setting the Gallery.LayoutParams tallness and width for the picture, setting the scale to fit the ImageView measurements, and after that at long last setting the foundation to utilize the styleable characteristic gained in the constructor. <br>

## History:
This widget was first introduced in Android level 1. Isn’t it amazing! It was one of the first widgets to be introduced in first versions of Android. As the Android kept on updating it was *deprecated* that is was no longer supported in Android 4.1 that is an earlier version of Android Jelly Bean. Gallery, one of the first android widgets was said goodbye. However, other similar scrolling widgets such as HorizontalScrollView and ViewPager are still supported (They belong to the same library). <br>

![jelly_bean](https://user-images.githubusercontent.com/43186158/49691380-a28c0780-fb0e-11e8-9866-166924ca7e66.jpg)


### Major Methods and Attributes 
I have explained complete usage requirements in the introduction. Gallery belongs to [Gallery.LayoutParams]. Here are the major Methods and attributes:<br>

* Attributes:
<br>

•	```android:animationDuration``` it sets how long animation should run when layout has changed. It uses millisecond as its unit.<br>
•	``` android:gravity ``` it specifies how an object should position its content, within it’s boundaries on both the X and Y axes.<br>
•	``` android:spacing ``` it makes space between children.<br>
•	``` android:entries ``` it is inherited from android.widget.AbsSpinner class. It act as a reference to an array resource that will populate the Spinner. <br>

<br>

* Methods
<br>

•	``` dispatchKeyEvent(KeyEvent event) ``` It dispactches a key event to the next view on the focus path.<br>
•	``` dispatchSetSelected(boolean) ``` it dispatch setSelected to all of this View’s children<br>
•	``` generateLayoutParams ``` It is derieved from ViewGroup.LayoutParams. It returns a new set of layout parametrs based on the supplied attributes set. <br>
•	``` onDown(MotionEvent) ``` It tells when tap occurs with down motionEvent.<br>
•	``` onKeyDown ```It handles left, right and clicking of the image.<br>
•	``` onFLing ``` It is notified when a fling event occurs with initial onDown MotionEvent and matching up MotionEvent.<br>
•	``` onTouchEvent (MotionEvent) ``` This method handles touch screen motion events.<br>
•	``` setgravity ```it tells the alignment of child views.<br>
•	``` setSpacing ``` It sets the spacing in different items in the gallery like different images.



## Code:
### GalleryAdapter.java
```
Packagecom.example.manna.mygallery;
	

	import android.content.Context;
	import android.support.annotation.NonNull;
	import android.support.annotation.Nullable;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.ArrayAdapter;
	import android.widget.ImageView;
	

	public class galleryAdapter extends ArrayAdapter<Integer> {
	

	

	private Context context;
	private Integer[] resources;
	

	

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
	

	if(convertView == null){
	

	convertView=new ImageView(getContext());
	}
	

	((ImageView)convertView).setImageResource(getItem(position));
	

	

	

	return convertView;
	}
	

	public galleryAdapter(@NonNull Context context, int resource, @NonNull Integer[] objects) {
	super(context, resource, objects);
	resources=objects;
	context=context;
	}
	


### Main.java


package com.example.manna.mygallery;
	

	import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.AdapterView;
	import android.widget.Gallery;
	import android.widget.ImageView;
	import android.widget.Toast;
	

	public class MainActivity extends AppCompatActivity {
	

	    private ImageView imageView;
	    private Gallery gallery;
	

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        imageView = (ImageView) findViewById(R.id.id_imageview);
	        gallery = (Gallery) findViewById(R.id.id_galleryview);
	

	        Integer img[]= {
	                R.drawable.sample_0,
	                R.drawable.sample_1,
	                R.drawable.sample_2,
	                R.drawable.sample_3,
	                R.drawable.sample_4,
	                R.drawable.sample_5,
	                R.drawable.sample_6,
	                R.drawable.sample_7,
	

	

	                R.drawable.sample_0,
	                R.drawable.sample_1,
	                R.drawable.sample_2,
	                R.drawable.sample_3,
	                R.drawable.sample_4,
	                R.drawable.sample_5,
	                R.drawable.sample_6,
	                R.drawable.sample_7,
	

	                R.drawable.sample_0,
	                R.drawable.sample_1,
	                R.drawable.sample_2,
	                R.drawable.sample_3,
	                R.drawable.sample_4,
	                R.drawable.sample_5,
	                R.drawable.sample_6,
	                R.drawable.sample_7,
	

	

	        };
	

	        gallery.setAdapter(new galleryAdapter(getApplicationContext(), 0,img));
	

	

	        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                imageView.setImageResource((Integer) parent.getItemAtPosition(position));
	            }
	        });
	

	    }
	} 
```

## Reference

Since I only studied from online website hence I am nming my refrences as following

[Ref1](https://developer.xamarin.com/api/type/Android.Widget.Gallery/)

[Ref2](https://docs.microsoft.com/en-us/xamarin/android/user-interface/controls/gallery)

[Ref3](https://developer.android.com/reference/android/widget/Gallery#summary)

[Ref4](https://www.youtube.com/watch?v=O1DCtbdAxQo)

