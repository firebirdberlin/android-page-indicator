# Android Page Indicator

An Android page indicator which can be used together with a ViewPager widget.

## Installation
Build the library with
```
 $ ant release
```
In order to use it within your (ant) project add this line to the *project.properties*
```
android.library.reference.1=path/to/android-preferences
```

## Usage

 * Add the page indicator to your layout
```
    <com.firebirdberlin.pageindicator.PageIndicator
        xmlns:pageindicator="pageindicator"
        android:id="@+id/page_indicator"
        android:background="#000000"
        android:layout_width="match_parent"
        android:layout_marginTop="5dp"
        android:layout_marginBottom="5dp"
        android:layout_height="6dp"
        pageindicator:color="android:attr/textColor"/>
```
    Without specification the default color is the default android text color. You can
    specify the color using the attribute `pageindicator:color`. Valid values are:
        - Resources in the form "package:type/name", e.g. "android:attr/textColor"
        - Colors in HEX-notation, e.g. "#00FF00"

    The size is determined by the height of the view.

 * Configure the page indicator in your class:

 ```
import com.firebirdberlin.pageindicator.PageIndicator;

[...]

final PageIndicator pageIndicator = (PageIndicator) findViewById(R.id.page_indicator);
pageIndicator.setPageCount(num_pages);
pager.setOnPageChangeListener(new OnPageChangeListener() {
    public void onPageScrollStateChanged(int state) {}
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    public void onPageSelected(int position) {
        pageIndicator.setCurrentPage(position);
    }
});
 ```

