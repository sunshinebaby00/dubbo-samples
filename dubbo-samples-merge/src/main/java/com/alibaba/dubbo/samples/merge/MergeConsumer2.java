/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.alibaba.dubbo.samples.merge;

import java.util.List;

import com.alibaba.dubbo.samples.merge.api.MergeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MergeConsumer2
 */
public class MergeConsumer2 {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/merge-consumer2.xml"});
        context.start();
        MergeService mergeService = (MergeService) context.getBean("mergeService");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                List<String> result = mergeService.mergeResult();
                System.out.println("(" + i + ") " + result);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
