package snippets.jee.dto;

import java.io.Serializable;
import java.util.Date;

public class EmpDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer no;                // 编号
    private String name;            // 姓名
    private String sex;            // 性别
    private String job;                // 职位
    private EmpDTO mgr;                // 主管
    private Double salary;        // 月薪
    private Date hireDate;        // 入职日期
    private String status;    // 是否在职
    private String photo;        // 照片(路径)
    private String tel;                // 电话号码
    private Dept dept;

    public Integer getNo() {
        return no;
    }
    public void setNo(Integer no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public EmpDTO getMgr() {
        return mgr;
    }
    public void setMgr(EmpDTO mgr) {
        this.mgr = mgr;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
