package com.namget.data.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("is_end")
    boolean isEnd;
    @SerializedName("pageable_count")
    int pageableCount;
    @SerializedName("total_count")
    int totalCount;
}
