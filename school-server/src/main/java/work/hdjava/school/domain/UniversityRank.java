package work.hdjava.school.domain;

import com.alibaba.excel.annotation.ExcelIgnore;import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Author suncl
 * Date: 2022/10/5 21:49
 * Description:  该文件的描述
 */
@TableName(value = "university_rank")
public class UniversityRank {
    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 地区
     */
    @TableField(value = "area")
    private String area;

    /**
     * 类型
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 得分
     */
    @TableField(value = "score")
    private String score;

    /**
     * 专业
     */
    @TableField(value = "majar")
    private String majar;

    /**
     * 年度
     */
    @TableField(value = "`year`")
    private String year;

    /**
     * 名次
     */
    @TableField(value = "`rank`")
    private Integer rank;

    /**
     * 学校名称
     */
    @TableField(value = "school")
    private String school;

    /**
     * 入库时间
     */
    @TableField(value = "op_date")
    private Date opDate;

    /**
     * 冗余1
     */
    @TableField(value = "extr1")
    private String extr1;

    /**
     * 冗余1
     */
    @TableField(value = "extr2")
    private String extr2;

    /**
     * 冗余1
     */
    @TableField(value = "extr3")
    private String extr3;

    /**
     * 冗余1
     */
    @TableField(value = "extr4")
    private String extr4;

    /**
     * 冗余1
     */
    @TableField(value = "extr5")
    private String extr5;

    /**
     * 冗余1
     */
    @TableField(value = "extr6")
    private String extr6;

    /**
     * 冗余1
     */
    @TableField(value = "extr7")
    private String extr7;

    /**
     * 冗余1
     */
    @TableField(value = "extr8")
    private String extr8;

    /**
     * 冗余1
     */
    @TableField(value = "extr9")
    private String extr9;

    /**
     * 冗余1
     */
    @TableField(value = "extr10")
    private String extr10;
    @TableField(exist = false)
    @ApiModelProperty(value = "当前页码")
    @ExcelIgnore
    private Long pageIndex = 1l;
    @TableField(exist = false)
    @ApiModelProperty(value = "页大小")
    @ExcelIgnore
    private Long pageSize = 10l;
    @TableField(exist = false)
    @ApiModelProperty(value = "起始时间")
    @ExcelIgnore
    private String startDate;
    @TableField(exist = false)
    @ApiModelProperty(value = "结束时间")
    @ExcelIgnore
    private String endDate;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取得分
     *
     * @return score - 得分
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置得分
     *
     * @param score 得分
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取专业
     *
     * @return majar - 专业
     */
    public String getMajar() {
        return majar;
    }

    /**
     * 设置专业
     *
     * @param majar 专业
     */
    public void setMajar(String majar) {
        this.majar = majar;
    }

    /**
     * 获取年度
     *
     * @return year - 年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取名次
     *
     * @return rank - 名次
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置名次
     *
     * @param rank 名次
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取学校名称
     *
     * @return school - 学校名称
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置学校名称
     *
     * @param school 学校名称
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取入库时间
     *
     * @return op_date - 入库时间
     */
    public Date getOpDate() {
        return opDate;
    }

    /**
     * 设置入库时间
     *
     * @param opDate 入库时间
     */
    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    /**
     * 获取冗余1
     *
     * @return extr1 - 冗余1
     */
    public String getExtr1() {
        return extr1;
    }

    /**
     * 设置冗余1
     *
     * @param extr1 冗余1
     */
    public void setExtr1(String extr1) {
        this.extr1 = extr1;
    }

    /**
     * 获取冗余1
     *
     * @return extr2 - 冗余1
     */
    public String getExtr2() {
        return extr2;
    }

    /**
     * 设置冗余1
     *
     * @param extr2 冗余1
     */
    public void setExtr2(String extr2) {
        this.extr2 = extr2;
    }

    /**
     * 获取冗余1
     *
     * @return extr3 - 冗余1
     */
    public String getExtr3() {
        return extr3;
    }

    /**
     * 设置冗余1
     *
     * @param extr3 冗余1
     */
    public void setExtr3(String extr3) {
        this.extr3 = extr3;
    }

    /**
     * 获取冗余1
     *
     * @return extr4 - 冗余1
     */
    public String getExtr4() {
        return extr4;
    }

    /**
     * 设置冗余1
     *
     * @param extr4 冗余1
     */
    public void setExtr4(String extr4) {
        this.extr4 = extr4;
    }

    /**
     * 获取冗余1
     *
     * @return extr5 - 冗余1
     */
    public String getExtr5() {
        return extr5;
    }

    /**
     * 设置冗余1
     *
     * @param extr5 冗余1
     */
    public void setExtr5(String extr5) {
        this.extr5 = extr5;
    }

    /**
     * 获取冗余1
     *
     * @return extr6 - 冗余1
     */
    public String getExtr6() {
        return extr6;
    }

    /**
     * 设置冗余1
     *
     * @param extr6 冗余1
     */
    public void setExtr6(String extr6) {
        this.extr6 = extr6;
    }

    /**
     * 获取冗余1
     *
     * @return extr7 - 冗余1
     */
    public String getExtr7() {
        return extr7;
    }

    /**
     * 设置冗余1
     *
     * @param extr7 冗余1
     */
    public void setExtr7(String extr7) {
        this.extr7 = extr7;
    }

    /**
     * 获取冗余1
     *
     * @return extr8 - 冗余1
     */
    public String getExtr8() {
        return extr8;
    }

    /**
     * 设置冗余1
     *
     * @param extr8 冗余1
     */
    public void setExtr8(String extr8) {
        this.extr8 = extr8;
    }

    /**
     * 获取冗余1
     *
     * @return extr9 - 冗余1
     */
    public String getExtr9() {
        return extr9;
    }

    /**
     * 设置冗余1
     *
     * @param extr9 冗余1
     */
    public void setExtr9(String extr9) {
        this.extr9 = extr9;
    }

    /**
     * 获取冗余1
     *
     * @return extr10 - 冗余1
     */
    public String getExtr10() {
        return extr10;
    }

    /**
     * 设置冗余1
     *
     * @param extr10 冗余1
     */
    public void setExtr10(String extr10) {
        this.extr10 = extr10;
    }


    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}