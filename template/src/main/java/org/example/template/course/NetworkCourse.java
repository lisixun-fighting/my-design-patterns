package org.example.template.course;

public abstract class NetworkCourse {

    protected final void createCourse() {
        this.postSource();
        this.postNote();
        this.liveVideo();
        this.createPPT();
        if (needHomework())
            this.checkHomework();
    }

    abstract void checkHomework();

    protected boolean needHomework() {
        return false;
    }

    final void postSource() {
        System.out.println("post source");
    }

    final void postNote() {
        System.out.println("post note");
    }

    final void liveVideo() {
        System.out.println("live video");
    }

    final void createPPT() {
        System.out.println("create PPT");
    }
}
