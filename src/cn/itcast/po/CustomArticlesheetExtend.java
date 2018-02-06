package cn.itcast.po;

public class CustomArticlesheetExtend extends ArticlesheetWithBLOBs {
    private Adminsheet adminsheet;
    private Categorysheet categorysheet;

    public Adminsheet getAdminsheet() {
        return adminsheet;
    }

    public void setAdminsheet(Adminsheet adminsheet) {
        this.adminsheet = adminsheet;
    }

    public Categorysheet getCategorysheet() {
        return categorysheet;
    }

    public void setCategorysheet(Categorysheet categorysheet) {
        this.categorysheet = categorysheet;
    }
}
