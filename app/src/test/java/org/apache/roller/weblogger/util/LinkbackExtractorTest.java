/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */

package org.apache.roller.weblogger.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test linkback extractor.
 */
public class LinkbackExtractorTest  {

    public void testLinkbackExtractor() throws Exception {
        String[][] testrefs = new String[][]
        {
            // Second URL contains a link to the first
            {
                "http://cassandra.apache.org/",
                        "https://rollerweblogger.org/roller/entry/composite_keys_in_cassandra"
            },
            {
                "http://roller.apache.org/downloads/downloads.html",
                        "https://rollerweblogger.org/project/date/20140627"
            }
        };

        LinkbackExtractor le = new LinkbackExtractor(testrefs[0][0],testrefs[0][1]);
        assertEquals("Apache Cassandra", le.getTitle());
        
        le = new LinkbackExtractor(testrefs[1][0],testrefs[1][1]);
        assertEquals("Apache Roller", le.getTitle());

        // todo: le.getPermalink() and le.getExcerpt() working
    }

    
}
