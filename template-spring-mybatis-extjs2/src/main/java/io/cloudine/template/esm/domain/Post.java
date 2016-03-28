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

/**
 * User Persistent Object.
 *
 * @author Edward KIM
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "p_id",
        "p_title",
        "p_content",
        "c_date",
        "u_date",
        "member_id"

})
@XmlRootElement(name = "post")
public class Post implements Serializable {

    private Integer p_id;

    @NotNull
   	@Max(20)
    private String p_title;

    @NotNull
   	@Max(20)
    private String p_content;

    @NotNull
   	@Max(20)
    private String c_date;

    @NotNull
    @Max(20)
    private String u_date;

    @NotNull
    private int member_id;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getU_date() {
        return u_date;
    }

    public void setU_date(String u_date) {
        this.u_date = u_date;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (getMember_id() != post.getMember_id()) return false;
        return getP_id().equals(post.getP_id());

    }

    @Override
    public int hashCode() {
        int result = getP_id().hashCode();
        result = 31 * result + getMember_id();
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "p_id=" + p_id +
                ", p_title='" + p_title + '\'' +
                ", p_content='" + p_content + '\'' +
                ", c_date='" + c_date + '\'' +
                ", u_date='" + u_date + '\'' +
                ", member_id=" + member_id +
                '}';
    }
}