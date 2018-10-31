# Visual Studio Code

## 用 Vscode 開發 Java 程式的一次性設定

* 設定環境變數 JAVA_HOME 為 C:\Program Files\Java\jdk1.8.0_192
* Vscode 安裝 Java Extension Pack(它自動安裝 Language Support for Java by Red Hat, Debugger for Java, Java Test Runner, Maven for Java)
* 安裝 Apache Maven 3.5.4 並將它的 bin 放到 PATH 裡面

## 用 Vscode 成立 Maven 新專案

* ctrl+shift+p 選取 Generate from Maven Archetype > maven-archetype-quickstart
* groupId: name space, artifactId: package name, package name: full package name
* destination directory: parent directory
* pom.xml 裡面的<maven.compiler.source>與<maven.compiler.target>由 1.7 改成 1.8

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
