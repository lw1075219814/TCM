package com.example.tcm.myapplication.bean;

import java.util.List;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/12 16:39
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/12 16:39
 * @see
 */
public class LatestDailyListBean {

    /**
     * date : 20190312
     * stories : [{"title":"选购洁面产品，先要知道你脸上想洗掉的到底是什么","ga_prefix":"031216","images":["https://pic3.zhimg.com/v2-a2e2a4c25246c2c63804593415888196.jpg"],"multipic":true,"type":0,"id":9708789},{"title":"艾弗森绝对会从右侧过了你，可惜，你就是防不住","ga_prefix":"031209","images":["https://pic1.zhimg.com/v2-45faee4f7ee4514ae22a6640cf76951c.jpg"],"multipic":true,"type":0,"id":9708764},{"images":["https://pic4.zhimg.com/v2-dce76aa3c6bd3a824c89acbd2db24e33.jpg"],"type":0,"id":9708777,"ga_prefix":"031208","title":"没开玩笑，演了总统的喜剧演员，即将被选为总统"},{"title":"我混进了 00 后的 QQ 群，发现自己真的老了","ga_prefix":"031207","images":["https://pic2.zhimg.com/v2-8c65084a1e96476bf484830b86119009.jpg"],"multipic":true,"type":0,"id":9708771},{"images":["https://pic3.zhimg.com/v2-f59bd80ff355ab9cbed1c575c5251ca2.jpg"],"type":0,"id":9708756,"ga_prefix":"031206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-df37c250e5c21dac2b691d7c55faabb0.jpg","type":0,"id":9708777,"ga_prefix":"031208","title":"没开玩笑，演了总统的喜剧演员，即将被选为总统"},{"image":"https://pic2.zhimg.com/v2-12b05af66abb8c51360240b5875c3209.jpg","type":0,"id":9708771,"ga_prefix":"031207","title":"我混进了 00 后的 QQ 群，发现自己真的老了"},{"image":"https://pic2.zhimg.com/v2-3331984a954d0fc1ef59e0ec4f89662d.jpg","type":0,"id":9708667,"ga_prefix":"031021","title":"吃到《黑豹》甜头的漫威，就这么如法炮制了《惊奇队长》"},{"image":"https://pic1.zhimg.com/v2-e8f8cd35f19f714e3dcc3e45c7023fa8.jpg","type":0,"id":9708684,"ga_prefix":"031008","title":"为了微信的一个 bug，蔡徐坤的粉丝们差点跟腾讯势不两立"},{"image":"https://pic2.zhimg.com/v2-53f622cd066036eaffa39c5d9be534b9.jpg","type":0,"id":9708663,"ga_prefix":"030818","title":"这盘开胃菜，记得看《惊奇队长》之前享用（无剧透）"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 选购洁面产品，先要知道你脸上想洗掉的到底是什么
         * ga_prefix : 031216
         * images : ["https://pic3.zhimg.com/v2-a2e2a4c25246c2c63804593415888196.jpg"]
         * multipic : true
         * type : 0
         * id : 9708789
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-df37c250e5c21dac2b691d7c55faabb0.jpg
         * type : 0
         * id : 9708777
         * ga_prefix : 031208
         * title : 没开玩笑，演了总统的喜剧演员，即将被选为总统
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
