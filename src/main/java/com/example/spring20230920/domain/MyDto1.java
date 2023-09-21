package com.example.spring20230920.domain;

public class MyDto1 {
    // property 명 : get/set 업애고 소문자로 시작

    // name property
    // hameAddress property
    private String name;
    private String homeAddress;
    private String MYHOME;

    private Boolean married;

    private boolean checked;

    // 불리안은 get을 is로 읽어들일 수 있다.
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    // 불리안은 get을 is로 읽어들일 수 있다.
    public Boolean isMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    // 대문자로만 이루어져있으면 대문자를 property로 사용한다.
    public String getMYHOME() {
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
