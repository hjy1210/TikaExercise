# Visual Studio Code

## 用 Vscode 開發 Java 程式的一次性設定

* 設定環境變數 JAVA_HOME 為 C:\Program Files\Java\jdk1.8.0_192
* Vscode 安裝 Java Extension Pack(它自動安裝 Language Support for Java by Red Hat, Debugger for Java, Java Test Runner, Maven for Java)
* 安裝 Apache Maven 3.5.4 並將它的 bin 放到 PATH 裡面

## 用 Vscode 成立 Maven 新專案

* ctrl+shift+p 選取 Generate from Maven Archetype > maven-archetype-quickstart
* groupId: full package name, artifactId: directory name
* destination directory: parent directory
* pom.xml 裡面的<maven.compiler.source>與<maven.compiler.target>由 1.7 改成 1.8

[這份文件](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)一定要讀，可以了解groupId, artifactId,...等的意義。也可以知道如何使用簡單有用的mvn指令得到專案的產出，以及產出如何讓java使用。

## 專案需要參考Tika

* 要參考 Tika，在 pom.xml 裡面增加
  
    ```code
    <dependency>
      <groupId>org.apache.tika</groupId>
      <artifactId>tika-app</artifactId>
      <version>1.19.1</version>
    </dependency>
    ```
* Maven 會將相關的 jar 與文件放到 `<user home dir>\.m2\repository` 裡面

## Language code

語言碼的清單在[這裡](https://en.wiktionary.org/wiki/Index:All_languages)

## Tika 的語言辨識功能

在 MyFirstTika.java 中，Tika 將 L:/Yh-Sort-Out/AllSortOfDocuments/regulardoc/02-考試分發的可行分發模式.doc 判為英文，應該研究如何讓 LanguageDetector 的 mixedLanguages 發揮功效。

## 在 VsCode 中製作可執行的 Jar

[building-a-runnable-jar-with-maven-2](https://stackoverflow.com/questions/2022032/building-a-runnable-jar-with-maven-2) 提到下面的方法來製作可執行的 Jar

* to build: mvn clean dependency:copy-dependencies package
* to execute (in target dir): java -cp myjar.jar:./dependency/* com.something.MyClass

套到自己的狀況(在Windows 中用;而非:)

* mvn clean dependency:copy-dependencies package
* java -cp TikaExercise-1.0-SNAPSHOT.jar;./dependency/* tw.org.dzudge.tikaexercise.LanguageDetection

這種方法在 target\dependency產生非常多的jar

或許可採用下面的方法，用mvn install 產生自己的jar，將它與tika-app-1.19.1.jar放在同一個工作目錄，用java 執行時指名main()所在的class。

* mvn package 在 target 目錄產生TikaExercise-1.0-SNAPSHOT.jar
* 將 tika-app-1.19.1.jar 抄到 target，切換將 target 當工作目錄
* java -cp TikaExercise-1.0-SNAPSHOT.jar;tika-app-1.19.1.jar tw.org.dzudge.tikaexercise.LanguageDetection

## 在 Eclipse 中製作可執行的 Jar

[這裡](https://stackoverflow.com/questions/11033603/how-to-create-a-jar-with-external-libraries-included-in-eclipse)提到：將專案 export 就有選項可製作成可執行的Jar。
