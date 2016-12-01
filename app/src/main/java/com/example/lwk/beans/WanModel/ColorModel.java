package com.example.lwk.beans.WanModel;

import java.util.List;

/**
 * Created by Shinelon on 2016/12/1.
 */
public class ColorModel {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{

        private List<PostsPOList> postsPOList;

        public List<PostsPOList> getPostsPOList() {
            return postsPOList;
        }

        public void setPostsPOList(List<PostsPOList> postsPOList) {
            this.postsPOList = postsPOList;
        }

        public class PostsPOList{
            private String imageUrl;
            private String url;
            private int views;
            private String title;
            private String id;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
