package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("is_end")
    boolean isEnd;
    @SerializedName("pageable_count")
    int pageableCount;
    @SerializedName("total_count")
    int totalCount;


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getPageableCount() {
        return pageableCount;
    }

    public void setPageableCount(int pageableCount) {
        this.pageableCount = pageableCount;
    }
}
