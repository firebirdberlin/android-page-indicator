# Android Page Indicator

[![JitPack](https://jitpack.io/v/firebirdberlin/android-page-indicator.svg)](https://jitpack.io/#firebirdberlin/android-page-indicator)

An Android page indicator which can be used together with a ViewPager widget.

## Sponsoring

If you find this library useful, you can support its development:

[![Sponsor on GitHub](https://img.shields.io/badge/Sponsor%20on%20GitHub-grey?logo=github)](https://github.com/sponsors/firebirdberlin)
[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-yellow?logo=buymeacoffee)](https://www.buymeacoffee.com/firebirdberlin)

## Installation

This library is distributed with [JitPack.io](https://jitpack.io).

### Gradle

1.  Add JitPack to your project's `settings.gradle` file:
    ```groovy
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }
    ```
    *For older Gradle versions, add it to your root `build.gradle`:*
    ```groovy
    allprojects {
        repositories {
            //...
            maven { url 'https://jitpack.io' }
        }
    }
    ```

2.  Add the dependency to your app's `build.gradle` file. Replace `Tag` with the latest release version from the [releases page](https://github.com/firebirdberlin/android-page-indicator/releases).
    ```groovy
    dependencies {
        implementation 'com.github.firebirdberlin:android-page-indicator:Tag'
    }
    ```

### Maven

1. Add the JitPack repository to your `pom.xml`:
   ```xml
   <repositories>
       <repository>
           <id>jitpack.io</id>
           <url>https://jitpack.io</url>
       </repository>
   </repositories>
   ```

2. Add the dependency. Replace `Tag` with the latest release version from the [releases page](https://github.com/firebirdberlin/android-page-indicator/releases).
   ```xml
   <dependency>
       <groupId>com.github.firebirdberlin</groupId>
       <artifactId>android-page-indicator</artifactId>
       <version>Tag</version>
   </dependency>
   ```

## Usage

 * Add the page indicator to your layout
```
    <de.firebirdberlin.pageindicator.PageIndicator
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
import de.firebirdberlin.pageindicator.PageIndicator;

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
