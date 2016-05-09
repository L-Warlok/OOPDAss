
diary.class: diary.java
	javac diary.java

UniEvent.class: UniEvent.java
	javac UniEvent.java

LecutureEvent.class: LectureEvent.java
	javac LectureEvent.java

TuteEvent.class: TuteEvent.java
	javac TuteEvent.java

functionObject.class: functionObject.java
	javac functionObject.java

.PHONY:clean
clean:
	rm *s
