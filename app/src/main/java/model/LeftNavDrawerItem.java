package model;

/**
 * Created by herma on 17/06/2016.
 */
public class LeftNavDrawerItem {

    private boolean showNotify;
    private String title;


    public LeftNavDrawerItem() {

    }

    public LeftNavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
