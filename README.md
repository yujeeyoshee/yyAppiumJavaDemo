# yyAppiumJavaDemo

Maven project for testing Appium locally and generating .zip file for AWD Device Farm testing.  It is written in a way where device dependency as well as APK dependency are specified when starting the Appium server and not in the test code itself.  This allows this project to be used not only for Ipercron Launcher app but any other apps.


### Start the Appium server

```
appium --pre-launch --platform-name Android --device-name avdName --app apkPath
```

For example
```
appium --pre-launch --platform-name Android --device-name appium_test_avd_1 --app ../apks/simpleButton-debug.apk
```


### Test locally (command line)

For all,
```
mvn -Dtest=* test
```

For each one,
```
mvn -Dtest=SimpleButtonTests test
```


### Test locally (IntelliJ)

Right click on the Appium test file, and "Run"


### Package a zip file for AWS device farm
```
mvn clean package
```
