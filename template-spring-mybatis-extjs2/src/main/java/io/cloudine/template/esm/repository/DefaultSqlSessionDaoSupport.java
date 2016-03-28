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
package io.cloudine.template.esm.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * MyBatis 기반 DAO를 지원하기 위한 Spring Framework의 DAO Support.
 *
 * @author Edward KIM
 * @since 1.0
 */
public class DefaultSqlSessionDaoSupport extends SqlSessionDaoSupport {

    /**
     * {@link SqlSessionTemplate}을 반환한다.
     *
     * @return {@link SqlSessionTemplate}
     */
    public SqlSessionTemplate getSqlSessionTemplate() {
        if (this.getSqlSession() instanceof SqlSessionTemplate) {
            return (SqlSessionTemplate) this.getSqlSession();
        }
        throw new RuntimeException("Cannot get SqlSessionTemplate. SqlSession is not instance of SqlSessionTemplate.");
    }
}
