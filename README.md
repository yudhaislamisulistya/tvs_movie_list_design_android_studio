# Task

 1. Menerapkan List View dan Recycle View
 2. Memiliki Data Minimal 50
 3. Memiliki Tampilan Yang Menarik
 4. Menerapkan Intent Implisit dan Explisit
 5. Menerapkan Animation
 6. Menerapkan Bottom Navigation Bar
 7. Menerapkan Action Bar
 8. Splash Screen
 9. Login dan Register
 10. Home Page
 11. Fitur Menu Minimal 4
 12. Detail Film


## 1. List View dan Recycle View

| ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/home.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/now_playing.jpg?raw=true) |
|--|--|

##### Contoh Implementasi Recylce View Dalam XML
```xml
<androidx.recyclerview.widget.RecyclerView  
  android:id="@+id/Rv_movies"  
  android:layout_width="0dp"  
  android:layout_height="wrap_content"  
  android:layout_marginStart="16dp"  
  android:layout_marginTop="16dp"  
  android:layout_marginEnd="8dp"  
  app:layout_constraintEnd_toEndOf="parent"  
  app:layout_constraintHorizontal_bias="0.0"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toBottomOf="@+id/textView" />
```

##### Contoh Implementasi List View Dalam XML
```xml
<androidx.recyclerview.widget.RecyclerView  
  android:id="@+id/Rv_movies"  
  android:layout_width="0dp"  
  android:layout_height="wrap_content"  
  android:layout_marginStart="16dp"  
  android:layout_marginTop="16dp"  
  android:layout_marginEnd="8dp"  
  app:layout_constraintEnd_toEndOf="parent"  
  app:layout_constraintHorizontal_bias="0.0"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toBottomOf="@+id/textView" />
```

```xml
<ListView  
  android:id="@+id/LS_NowPlaying"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  android:scrollbars="none"  
  android:divider="@android:color/transparent"  
  android:dividerHeight="10.0sp"/>
```
## 2. Data Film

 1. Trolls World Tour
 2. Bucin
 3. Malik Dan Elsa
 4. I Still Belive
 5. The Cave
 6. Tarung Sarung
 7. Walking Dead Tomate
 8. My Spy
 9. Jodohku Yang Mana ?
 10. Djorieg Salawe
 11. Roh Mati Paksa
 12. Trauma Center
 13. Killerman
 14. Grater Anda Hansel
 15. Teen Spirit
 16. The ShawShank
 17. The Goodfather
 18. The Goodfather 2
 19. The Dark Knight
 20. 12 Angry Man
 21. Kajilionare
 22. Unhinged
 23. Mulan
 24. Most Wanted
 25. The Spongebob
 26. Wonder Woman 1984
 27. The One And Only Ivan
 28. The Secret Garden
 29. Sputnik
 30. Antebellum
 31. Let Him Go
 32. Tesla
 33. The New Mutant
 34. Avanger End Game
 35. Justice League
 36. Midsommar
 37. Maleficient Mistess Of Evil
 38. Public Enemies
 39. Sembilan Belas
 40. Planet Earth 
 41. Planet Earth 2
 42. Band Of Brother
 43. Breaking Bad
 44. Cherynobyl
 45. The Wire
 46. Blue Planet
 47. The Last Dance
 48. Our Planet
 49. Cosmos
 50. Tenet

## 3. Tampilan Menarik
 
| ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/splash_screen.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/login.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/register.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/home.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/tv_show.jpg?raw=true) |
|--|--|--|--|--|
| ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/detail_movie.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/detail_tv_show.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/upcoming.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/now_playing.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/profile_with_action_bar.jpg?raw=true) |

## 4. Menerapkan Intent Implisit dan Explisit
| Explisit | Implisit |
|--|--|
| ![enter image description here](https://media.giphy.com/media/kGXaxvyQl63a6hWC5L/giphy.gif) | ![enter image description here](https://media.giphy.com/media/UtybUsYVl6UNfwJw87/giphy.gif) |


#### Contoh Implementasi Intent Explisit
```java
Intent login =new Intent(SplashScreen.this, Login.class);  
startActivity(login);
```

#### Contoh Implementasi Intent Implisit
```java
Intent streaminLinkYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse(movieStreamingLink));  
startActivity(streaminLinkYoutube);
```

## 5. Menerapkan Animation
| Animation |
|--|
| ![enter image description here](https://media.giphy.com/media/lrtS7pJBJme2IUGNFs/giphy.gif) |

#### Contoh Implementasi Animiation
```java
MovieThumbnailImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));  
MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));  
play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
```

## 6. Bottom Navigation Bar
![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/home.jpg?raw=true)

## 7. Action Bar
![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/profile_with_action_bar.jpg?raw=true)

## 8. Splash Screen
| Splash Creen |
|--|
| ![enter image description here](https://media.giphy.com/media/WTcivpmNs7MlkhjQJp/giphy.gif) |

```java
package com.example.asistensi1dan2tahap1.ui.splash_screen;  
  
import androidx.appcompat.app.AppCompatActivity;  
  
import android.content.Intent;  
import android.os.Bundle;  
import android.os.Handler;  
  
import com.example.asistensi1dan2tahap1.R;  
import com.example.asistensi1dan2tahap1.ui.login.Login;  
  
public class SplashScreen extends AppCompatActivity {  
    private int waktu_loading=4000;  
  @Override  
  protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
  setContentView(R.layout.activity_splash_screen);  
  
  
 new Handler().postDelayed(new Runnable() {  
            @Override  
  public void run() {  
                Intent login =new Intent(SplashScreen.this, Login.class);  
  startActivity(login);  
  finish();  
  }  
        },waktu_loading);  
  
  }  
}
```

## 9. Login dan Register
|Login|Register|
|--|--|
| ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/login.jpg?raw=true) | ![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/register.jpg?raw=true) |

#### Contoh Implementasi Login.xml
```xml
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  xmlns:tools="http://schemas.android.com/tools"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  android:background="@drawable/login_bg"  
  android:orientation="vertical"  
  tools:context=".ui.login.Login">  
  
 <ImageView  android:layout_width="150dp"  
  android:layout_height="150dp"  
  android:layout_gravity="center"  
  android:layout_marginTop="120dp"  
  android:src="@drawable/movies" />  
  
 <LinearLayout  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="14dp"  
  android:layout_marginRight="14dp"  
  android:background="@drawable/shape_linear_layout"  
  android:orientation="vertical"  
  android:paddingRight="12dp">  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_gravity="center"  
  android:layout_marginTop="14dp"  
  android:fontFamily="@font/kanit_medium"  
  android:text="Hello"  
  android:textColor="@color/colorWhite"  
  android:textSize="38dp" />  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_gravity="center"  
  android:layout_marginTop="-8dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Sign into your Account"  
  android:textColor="@color/colorWhite"  
  android:textSize="22dp" />  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="8dp"  
  android:layout_marginTop="20dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Email"  
  android:textColor="@color/colorWhite"  
  android:textSize="18dp" />  
  
 <EditText  android:textColor="@color/colorWhite"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:drawableRight="@drawable/ic" />  
  
  
 <TextView  android:layout_width="wrap_content"  
  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="8dp"  
  android:layout_marginTop="14dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Password"  
  android:textColor="@color/colorWhite"  
  android:textSize="18dp" />  
  
 <EditText  android:textColor="@color/colorWhite"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:drawableRight="@drawable/ic_pass" />  
  
 <TextView  android:layout_width="wrap_content"  
  
  android:layout_height="wrap_content"  
  android:layout_gravity="right"  
  android:layout_marginRight="12dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Forget your Password?"  
  android:textColor="@color/colorWhite"  
  android:textSize="14dp" />  
  
 <Button  android:layout_width="140dp"  
  android:layout_height="wrap_content"  
  android:layout_gravity="center"  
  android:layout_marginTop="28dp"  
  android:background="@drawable/btn_login"  
  android:text="Log In"  
  android:textColor="#ffff"  
  android:textSize="16dp"  
  android:onClick="goHomeScreen"/>  
  
 <LinearLayout  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginTop="22dp"  
  android:layout_marginBottom="8dp"  
  android:gravity="center"  
  android:orientation="horizontal">  
  
 <TextView  android:layout_width="wrap_content"  
  android:textColor="@color/colorWhite"  
  android:layout_height="wrap_content"  
  android:fontFamily="@font/kanit_regular"  
  android:text="don't have an Account"  
  android:textSize="18dp" />  
  
 <TextView  android:layout_width="wrap_content"  
  android:onClick="goRegisterScreen"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Register Now"  
  android:textColor="#ff7c17"  
  android:textSize="18dp" />  
 </LinearLayout>  
 </LinearLayout>  
</LinearLayout>
```
#### Contoh Implementasi Register.xml
```xml
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  xmlns:tools="http://schemas.android.com/tools"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  android:background="@drawable/login_bg"  
  android:orientation="vertical"  
  tools:context=".ui.register.Register">  
  
 <ImageView  android:layout_width="210dp"  
  android:layout_height="167dp"  
  android:layout_gravity="center"  
  android:layout_marginTop="84dp"  
  android:src="@drawable/movies" />  
  
 <LinearLayout  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="14dp"  
  android:layout_marginRight="14dp"  
  android:background="@drawable/shape_linear_layout"  
  android:orientation="vertical"  
  android:paddingRight="12dp">  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_gravity="center"  
  android:layout_marginTop="14dp"  
  android:fontFamily="@font/kanit_medium"  
  android:text="Create"  
  android:textColor="@color/colorWhite"  
  android:textSize="28dp" />  
  
  
 <TextView  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="8dp"  
  android:layout_marginTop="20dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Username"  
  android:textColor="@color/colorWhite"  
  android:textSize="18dp" />  
  
 <EditText  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:drawableRight="@drawable/ic_user" />  
  
  
 <TextView  android:layout_width="wrap_content"  
  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="8dp"  
  android:layout_marginTop="12dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Email"  
  android:textColor="@color/colorWhite"  
  android:textSize="18dp" />  
  
 <EditText  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:drawableRight="@drawable/ic" />  
  
  
 <TextView  android:layout_width="wrap_content"  
  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="8dp"  
  android:layout_marginTop="12dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Password"  
  android:textColor="@color/colorWhite"  
  android:textSize="18dp" />  
  
 <EditText  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:drawableRight="@drawable/ic_pass" />  
  
  
 <Button  android:layout_width="180dp"  
  android:layout_height="wrap_content"  
  android:layout_gravity="center"  
  android:layout_marginTop="40dp"  
  android:background="@drawable/btn_login"  
  android:text="Register Now"  
  android:textColor="#ffff"  
  android:textSize="16dp" />  
  
 <LinearLayout  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginTop="18dp"  
  android:layout_marginBottom="8dp"  
  android:gravity="center"  
  android:orientation="horizontal">  
  
 <TextView  android:layout_width="wrap_content"  
  android:textColor="@color/colorWhite"  
  android:layout_height="wrap_content"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Already have an Account"  
  android:textSize="18dp" />  
  
 <TextView  android:layout_width="wrap_content"  
  android:onClick="goLoginScreen"  
  android:layout_height="wrap_content"  
  android:layout_marginLeft="12dp"  
  android:fontFamily="@font/kanit_regular"  
  android:text="Log In"  
  android:textColor="#ff7c17"  
  android:textSize="18dp" />  
 </LinearLayout>  
 </LinearLayout>  
</LinearLayout>
```

## 10. Home Page
![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/home.jpg?raw=true)

# 11. Fitur Menu 4
![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/home.jpg?raw=true)

 1. Home
 2. Upcoming
 3. Now Playing
 4. Profile

## 12. Detail Film
![enter image description here](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/detail_movie.jpg?raw=true)

# Full Demo
[![asciicast](https://github.com/yudhaislamisulistya/tvs_movie_list_design_android_studio/blob/master/splash_screen.jpg?raw=true)](https://streamable.com/k5l8i4)

