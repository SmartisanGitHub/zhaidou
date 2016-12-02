package com.example.lwk.beans.LWKModel;

import java.util.List;

/**
 * Created by LWK on 2016/11/27.
 */
public class ShopMiddle {


    /**
     * data : [{"boardCode":"01","programPOList":[{"code":"SHD2016N2M00098247","name":"商场广告图一","pcImage":"http://imgs.zhaidou.com/cms/201611/1480297980402.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1480297980377.jpg","type":"6","url":"activityCode=SHD2016N2M00098247&typeEnum=3"},{"code":"http://www.zhaidou.com/app.html","name":"迪拉索\u2014意大利高端奢华定制家居","pcImage":"http://imgs.zhaidou.com/cms/201607/1469763899318.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466416712451.jpg","type":"1","url":"http://www.zhaidou.com/app.html"},{"code":"SHD2016G7M4954735","name":"首页广告图","pcImage":"http://imgs.zhaidou.com/cms/201611/1480297065192.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1480297065083.jpg","type":"6","url":"activityCode=SHD2016G7M4954735&typeEnum=3"}],"programShowNum":10,"programTotalNum":3},{"boardCode":"02","programPOList":[{"code":"SHD2016K5M14057961","name":"专题一，一","pcImage":"http://imgs.zhaidou.com/cms/201610/1476694862205.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201610/1476694862177.jpg","type":"6","url":"activityCode=SHD2016K5M14057961&typeEnum=3"},{"code":"SHD2016M0Q17134117","name":"专题一，1","pcImage":"http://imgs.zhaidou.com/cms/201611/1478144419825.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1478144419760.jpg","type":"6","url":"activityCode=SHD2016M0Q17134117&typeEnum=3"},{"code":"SHD2016M0Q18187606","name":"专题一，2","pcImage":"http://imgs.zhaidou.com/cms/201610/1477891376518.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201610/1477891376483.jpg","type":"6","url":"activityCode=SHD2016M0Q18187606&typeEnum=3"},{"code":"SHD2016M0Q1930741","name":"专题一，3","pcImage":"http://imgs.zhaidou.com/cms/201610/1477891390617.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201610/1477891390590.jpg","type":"6","url":"activityCode=SHD2016M0Q1930741&typeEnum=3"},{"code":"SHD2016M0Q21517972","name":"专题一，4","pcImage":"http://imgs.zhaidou.com/cms/201610/1477891405354.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201610/1477891405317.jpg","type":"6","url":"activityCode=SHD2016M0Q21517972&typeEnum=3"},{"code":"SHD2016K5N10095337","name":"口碑排行榜","pcImage":"http://imgs.zhaidou.com/cms/201610/1477557959846.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201610/1477557959832.jpg","type":"6","url":"activityCode=SHD2016K5N10095337&typeEnum=3"},{"code":"SHD2016KFK59116662","name":"专题1","pcImage":"http://imgs.zhaidou.com/cms/201611/1478573936786.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1478573936762.jpg","type":"6","url":"activityCode=SHD2016KFK59116662&typeEnum=3"},{"code":"SHD2016NKM51306394","name":"专题2","pcImage":"http://imgs.zhaidou.com/cms/201611/1478573540174.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1478573540123.jpg","type":"6","url":"activityCode=SHD2016NKM51306394&typeEnum=3"},{"code":"SHD2016KFK52247539","name":"专题3","pcImage":"http://imgs.zhaidou.com/cms/201611/1478573865707.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1478573865680.jpg","type":"6","url":"activityCode=SHD2016KFK52247539&typeEnum=3"},{"code":"SHD2016KE227027630","name":"专题4","pcImage":"http://imgs.zhaidou.com/cms/201611/1479433704084.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1479433702882.jpg","type":"6","url":"activityCode=SHD2016KE227027630&typeEnum=3"}],"programShowNum":15,"programTotalNum":10},{"boardCode":"03","programPOList":[{"name":"天天刮奖","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466499985746.jpg","type":"1","url":"http://www.zhaidou.com/lotteries"},{"name":"软装图库","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466502769537.jpg","type":"12"},{"name":"色彩案例","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466500915976.jpg","type":"8"},{"name":"在线设计","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466501065069.jpg","type":"1","url":"http://m.zhaidou.com/design.html"}],"programShowNum":4,"programTotalNum":4}]
     * status : 200
     * timestamp : 1480468643988
     */

    private int status;
    private long timestamp;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * boardCode : 01
         * programPOList : [{"code":"SHD2016N2M00098247","name":"商场广告图一","pcImage":"http://imgs.zhaidou.com/cms/201611/1480297980402.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1480297980377.jpg","type":"6","url":"activityCode=SHD2016N2M00098247&typeEnum=3"},{"code":"http://www.zhaidou.com/app.html","name":"迪拉索\u2014意大利高端奢华定制家居","pcImage":"http://imgs.zhaidou.com/cms/201607/1469763899318.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466416712451.jpg","type":"1","url":"http://www.zhaidou.com/app.html"},{"code":"SHD2016G7M4954735","name":"首页广告图","pcImage":"http://imgs.zhaidou.com/cms/201611/1480297065192.jpg","pictureUrl":"http://imgs.zhaidou.com/cms/201611/1480297065083.jpg","type":"6","url":"activityCode=SHD2016G7M4954735&typeEnum=3"}]
         * programShowNum : 10
         * programTotalNum : 3
         */

        private String boardCode;
        private int programShowNum;
        private int programTotalNum;
        private List<ProgramPOListBean> programPOList;

        public String getBoardCode() {
            return boardCode;
        }

        public void setBoardCode(String boardCode) {
            this.boardCode = boardCode;
        }

        public int getProgramShowNum() {
            return programShowNum;
        }

        public void setProgramShowNum(int programShowNum) {
            this.programShowNum = programShowNum;
        }

        public int getProgramTotalNum() {
            return programTotalNum;
        }

        public void setProgramTotalNum(int programTotalNum) {
            this.programTotalNum = programTotalNum;
        }

        public List<ProgramPOListBean> getProgramPOList() {
            return programPOList;
        }

        public void setProgramPOList(List<ProgramPOListBean> programPOList) {
            this.programPOList = programPOList;
        }

        public static class ProgramPOListBean {
            /**
             * code : SHD2016N2M00098247
             * name : 商场广告图一
             * pcImage : http://imgs.zhaidou.com/cms/201611/1480297980402.jpg
             * pictureUrl : http://imgs.zhaidou.com/cms/201611/1480297980377.jpg
             * type : 6
             * url : activityCode=SHD2016N2M00098247&typeEnum=3
             */

            private String code;
            private String name;
            private String pcImage;
            private String pictureUrl;
            private String type;
            private String url;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPcImage() {
                return pcImage;
            }

            public void setPcImage(String pcImage) {
                this.pcImage = pcImage;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}


