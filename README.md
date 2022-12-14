<h1 align="center"> 🚀 Groceries Store - Sample for the SonarQube</h1>

## About
Groceries Store is a project to help people order grocery online. The main purpose of this project is to demonstrate modern Android development skills in real production environment, reduce the learning curve when jump into Android development world and integrate the SonarQube.

## Sonar Server Configuration: (For Windowns, Check [offical document](https://www.sonarqube.org/) for the other OS)

#Step1
```
1. Download and install Java 11 on your system.
2. Download the SonarQube Community Edition zip file
3. Download the SonarScanners (Code Analyzer)
4. Download the Flutter Plug-In (For Flutter Only)
```

#Step2
```
Set Environment Path:
1. JDK ==> ..\SonarLocal\jdk-11.0.17+8\bin
2. Sonarqube ==> ..\SonarLocal\sonarqube-8.9.10.61524\bin\windows-x86-64
3. Sonarscanner ==> ..\SonarLocal\sonar-scanner-4.7.0.2747-windows\bin
```

#Step3
```
1. Open wrapper.conf ==> (File Path ..\SonarLocal\sonarqube-8.9.10.61524\conf\)
2. Update wrapper.java.command=../SonarLocal/jdk-11.0.17+8/bin/java
```

#Step4 (This is very important)
```
1. Open command line
2. CD ..\SonarLocal\sonarqube-8.9.10.61524\bin\windows-x86-64
3. Type ==> startsonar
4. Hit http://localhost:9000/ or your server URL where you setup sonar
```

## Android Configuration

```
1. Root gradle, add url
   repositories {
   google()
   maven {
   ...
   url = uri("https://plugins.gradle.org/m2/")
   }
   }

2. App gradle
   plugins {
   ...
   id "org.sonarqube" version "3.2.0"
   }

3. Sonar Script
   sonarqube {
   properties {
   property "sonar.host.url", "http://localhost:9000/" // Default or your server URL
   property "sonar.projectKey", "<PROJECT-KEY>"
   property "sonar.projectName", "<PROJECT-Name>"
   property "sonar.projectVersion", 1.0
   property "sonar.java.source", "1.8"
   property "sonar.language", "java"
   property "sonar.sources", "src/main/java"
   property "sonar.exclusions", "**/*Generated.java"
   property "sonar.scm.disabled", "true"
   property "sonar.sourceEncoding", "UTF-8"
   property "sonar.login", "<TOKEN>"
   }
   }

4. Clean your project (Clearing your cache)
   ./gradlew sonarqube

Note: [Original Source Code Credit] (https://github.com/hieuwu/android-groceries-store) Only SonarQube Integration has added here. 
