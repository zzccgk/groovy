package com.zz.utils.file

/**
 * Created by zz on 2017/7/7.
 */
@Category(File)
class FileUtil {
    def getSuffix() {
        getSuffix(this.name)
    }
    def getSuffix(String path) {
        path.substring(path.lastIndexOf("."))
    }
}
