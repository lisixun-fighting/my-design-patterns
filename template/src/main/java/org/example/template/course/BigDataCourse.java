package org.example.template.course;

public class BigDataCourse extends NetworkCourse {

    private boolean needHomeWorkFlag = false;

    public BigDataCourse(boolean needHomeWorkFlag) {
        this.needHomeWorkFlag = needHomeWorkFlag;
    }

    @Override
    protected boolean needHomework() {
        return needHomeWorkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("check Big Data course components");
    }
}
