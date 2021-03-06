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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test blacklist functionality.
 */
public class BlacklistTest  {
    public static Log log = LogFactory.getLog(BlacklistTest.class);
    
    private Blacklist blacklist;
    
    @BeforeEach
    public void setUp() throws Exception {
        blacklist = Blacklist.getBlacklist();
        String FS = File.separator;
        String blacklistName = System.getProperty("project.build.directory") + FS + "classes" + "blacklist.txt";
        log.info("Processing Blacklist file: " + blacklistName);
        blacklist.loadBlacklistFromFile(blacklistName);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsBlacklisted0() {
        assertFalse(blacklist.isBlacklisted("four score and seven years ago.com"));
    }
    
    // test non-regex
    @Test
    public void testIsBlacklisted1() {
        assertTrue(blacklist.isBlacklisted("www.myblacklistedsite.com"));
    }
    
    // test the regex patterns
    @Test
    public void testIsBlacklisted2() {
        assertTrue(blacklist.isBlacklisted("www.lsotr.com"));
    }
    
    // test the regex patterns
    @Test
    public void testIsBlacklisted3() {
        assertTrue(blacklist.isBlacklisted("buymoreonline.com"));
    }
    
    // test the regex patterns
    @Test
    public void testIsBlacklisted4() {
        assertTrue(blacklist.isBlacklisted("diet-enlargement.com"));
    }
    
    // test the regex patterns
    @Test
    public void testIsBlacklisted5() {
        assertTrue(blacklist.isBlacklisted("viagra.com"));
    }
    

}
