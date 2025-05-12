# NeverCrash

[![JitPack](https://img.shields.io/jitpack/v/github/jenly1314/NeverCrash?logo=jitpack)](https://jitpack.io/#jenly1314/NeverCrash)
[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/NeverCrash/master/app/app-release.apk)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/NeverCrash?logo=open-source-initiative)](https://opensource.org/licenses/mit)


NeverCrash for Android 一个用于App全局捕获Crash的库。信NeverCrash，永不Crash。

## 效果展示
![Image](GIF.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/NeverCrash/master/app/app-release.apk) 体验效果
> 
## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
    ```

2. 在Module的 **build.gradle** 中添加依赖项

    ```gradle
    implementation 'com.github.jenly1314:NeverCrash:1.0.0'
    ```

## 使用

### 初始化

核心代码 (大道至简)
```Java
NeverCrash.init(CrashHandler);
```

### 完整代码示例

在Application的`onCreate`方法中进行初始化`NeverCrash`来全局捕获异常
```Java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if(BuildConfig.debug) {
                    Log.e("Jenly", Log.getStackTraceString(e));
                } else {
                    // TODO 上报异常
                }
            }
        });
    }
}
```

## 相关推荐
- [AppMonitor](https://github.com/jenly1314/AppMonitor) 可以轻松的监听App的前后台状态变化；Activity的活跃状态变化；设备的开关屏状态变化。

---

![footer](https://jenly1314.github.io/page/footer.svg)
   
   
