/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

/**
 *
 * @author nipun
 */
public class Supplier {

    
    
    private String code;
    private String agentFname;
    private String agentLname;
    private String company;
    private String oldCode;
    private String tp1;
    private String tp2;
    
    
    /**
     * @return the agentFname
     */
    public String getAgentFname() {
        return agentFname;
    }

    /**
     * @param agentFname the agentFname to set
     */
    public Supplier setAgentFname(String agentFname) {
        this.agentFname = agentFname;
        return this;
    }

    /**
     * @return the agentLname
     */
    public String getAgentLname() {
        return agentLname;
    }

    /**
     * @param agentLname the agentLname to set
     */
    public Supplier setAgentLname(String agentLname) {
        this.agentLname = agentLname;
        return this;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public Supplier setCompany(String company) {
        this.company = company;
        return this;
    }

    /**
     * @return the oldCode
     */
    public String getOldCode() {
        return oldCode;
    }

    /**
     * @param oldCode the oldCode to set
     */
    public Supplier setOldCode(String oldCode) {
        this.oldCode = oldCode;
        return this;
    }


    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public Supplier setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return the tp1
     */
    public String getTp1() {
        return tp1;
    }

    /**
     * @param tp1 the tp1 to set
     */
    public Supplier setTp1(String tp1) {
        this.tp1 = tp1;
        return this;
    }

    /**
     * @return the tp2
     */
    public String getTp2() {
        return tp2;
    }

    /**
     * @param tp2 the tp2 to set
     */
    public Supplier setTp2(String tp2) {
        this.tp2 = tp2;
        return this;
    }

}
