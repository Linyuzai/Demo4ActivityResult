# Demo4ActivityResult

```
<dependency>
    <groupId>com.linyuzai</groupId>
    <artifactId>aresult</artifactId>
    <version>1.0.3</version>
    <type>pom</type>
</dependency>

compile 'com.linyuzai:aresult:1.0.3'
//Dont forget RxJava2
compile 'io.reactivex.rxjava2:rxjava:2.1.7'
```
How to use
```
private AResult mResult;
mResult = new AResult(this);

//RxJava
mResult.startForResult(SecondActivity.class)
    .filter(AResultMessage::isOk)
    .map(AResultMessage::getData)
    .subscribe(it -> Log.i("AResult", it.toString()));

//Callback
mResult.startForResult(SecondActivity.class, result -> Log.i("AResult", result.toString()));
```
