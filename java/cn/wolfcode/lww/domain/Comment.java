package cn.wolfcode.lww.domain;

public class Comment {
    /** 主键id*/
    private Integer id;

    /** 评论内容*/
    private String content;

    /** 所属用户*/
    private Integer uid;

    /** 所属文章*/
    private String artId;

    /** 评论时间*/
    private String time;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private  User user;

    /** */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}