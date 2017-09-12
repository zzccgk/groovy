package com.ccgk.utils.file

import com.zz.utils.file.FileUtil

/**
 * Created by zz on 2017/7/7.
 */
class FileUtilTest extends GroovyTestCase {
    void testGetFileSuffix() {
        assert FileUtil.getFileSuffix("xx.jsp") == ".jsp"
    }
}
