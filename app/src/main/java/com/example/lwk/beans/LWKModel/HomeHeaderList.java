package com.example.lwk.beans.LWKModel;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class HomeHeaderList {

    /**
     * data : [{"boardCode":"05","programShowNum":10,"programTotalNum":1,"programPOList":[{"name":"4","type":"9","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466481215467.jpg","pcImage":"http://imgs.zhaidou.com/cms/201608/1470218659596.jpg"}]},{"boardCode":"06","programShowNum":3,"programTotalNum":3,"programPOList":[{"name":"111","type":"3","url":"productId=191105005213","pictureUrl":"http://imgs.zhaidou.com/cms/201608/1472551397539.jpg","price":"599.0","code":"191105005213"},{"name":"222","type":"3","url":"productId=191105005212","pictureUrl":"http://imgs.zhaidou.com/cms/201608/1472551345312.jpg","price":"998.0","code":"191105005212"},{"name":"333","type":"3","url":"productId=191105002873","pictureUrl":"http://imgs.zhaidou.com/cms/201609/1475030325355.jpg","price":"25000.0","code":"191105002873"}]}]
     * status : 200
     * message : null
     * code : null
     * suggestMsg : null
     * timestamp : 1480315372996
     */

    private int status;
    private Object message;
    private Object code;
    private Object suggestMsg;
    private long timestamp;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getSuggestMsg() {
        return suggestMsg;
    }

    public void setSuggestMsg(Object suggestMsg) {
        this.suggestMsg = suggestMsg;
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
         * boardCode : 05
         * programShowNum : 10
         * programTotalNum : 1
         * programPOList : [{"name":"4","type":"9","pictureUrl":"http://imgs.zhaidou.com/cms/201606/1466481215467.jpg","pcImage":"http://imgs.zhaidou.com/cms/201608/1470218659596.jpg"}]
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
             * name : 4
             * type : 9
             * pictureUrl : http://imgs.zhaidou.com/cms/201606/1466481215467.jpg
             * pcImage : http://imgs.zhaidou.com/cms/201608/1470218659596.jpg
             */

            private String name;
            private String type;
            private String pictureUrl;
            private String pcImage;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public String getPcImage() {
                return pcImage;
            }

            public void setPcImage(String pcImage) {
                this.pcImage = pcImage;
            }
        }
    }
}
