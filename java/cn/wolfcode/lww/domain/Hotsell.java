package cn.wolfcode.lww.domain;

public class Hotsell {
    /** 主键id*/
    private Integer id;

    /** 标题*/
    private String title;

    /** 价钱*/
    private Integer price;

    /** 照片*/
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}