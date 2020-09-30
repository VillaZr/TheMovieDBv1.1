package com.example.themoviedb;

import java.io.IOException;

public interface RecyclerViewClickInterface {
    void onItemClick(int position) throws IOException;
    void onLongItemClick(int position);
}
