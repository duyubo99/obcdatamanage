package com.asisinfo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 数据操作日志
 */
@Entity(name="DATA_LOG")
public class DataLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String dataNum;//接口编号

    @Column
    private String tableName;//表名称

    @Column
    private String tableNameCn;//中文名称

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date downTime;//下载时间

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date importTime;//导入时间

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseTime;//发布时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataNum() {
        return dataNum;
    }

    public void setDataNum(String dataNum) {
        this.dataNum = dataNum;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNameCn() {
        return tableNameCn;
    }

    public void setTableNameCn(String tableNameCn) {
        this.tableNameCn = tableNameCn;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}
