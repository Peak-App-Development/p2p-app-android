package com.p2p.pumapp;

public class ViewItem {
    private String categoryTitle, info1, info2, info3;
    private boolean expandable;

    public ViewItem(String categoryTitle, String info1, String info2, String info3){
        this.categoryTitle = categoryTitle;
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
        expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }
}
