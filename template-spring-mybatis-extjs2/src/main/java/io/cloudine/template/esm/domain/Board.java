/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cloudine.template.esm.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * User Persistent Object.
 *
 * @author Edward KIM
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "b_id",
        "b_name",
        "c_date",
        "u_date",
        "member_id"
})
@XmlRootElement(name = "board")
public class Board implements Serializable {

    private Integer b_id;

    @NotNull
   	@Max(20)
    private String b_name;

    @NotNull
   	@Max(20)
    private Date c_date;

    @NotNull
   	@Max(20)
    private Date u_date;

    @NotNull
    private int member_id;

    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public Date getU_date() {
        return u_date;
    }

    public void setU_date(Date u_date) {
        this.u_date = u_date;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;

        Board board = (Board) o;

        if (getMember_id() != board.getMember_id()) return false;
        return getB_id().equals(board.getB_id());

    }

    @Override
    public int hashCode() {
        int result = getB_id().hashCode();
        result = 31 * result + getMember_id();
        return result;
    }

    @Override
    public String toString() {
        return "Board{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", c_date='" + c_date + '\'' +
                ", u_date='" + u_date + '\'' +
                ", member_id=" + member_id +
                '}';
    }
}