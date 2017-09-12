package com.zz.utils.string

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by ccgk on 2017/9/8.
 */
@Category(String)
class StringUtils {
    /**
     * 正则替代，根据匹配到的值自定义替换字符串
     * @param regex 正则表达式
     * @param closure 闭包 ，闭包参数为正则匹配的值
     * @return str
     */
    String replaceAll(String regex, closure) {
        Matcher matcher = Pattern.compile(regex).matcher(this)
        //closure 不为闭包，调用原始replaceAll
        if(!closure instanceof Closure){
            return matcher.replaceAll(closure)
        }
        //动态修改replaceAll方法
        Matcher.metaClass.replaceAll = {
            delegate.reset()
            boolean result = find()
            if(!result) return delegate.text.toString()
            StringBuffer sb = new StringBuffer()
            while (result){
                delegate.appendReplacement(sb,closure(delegate[delegate.index]))
                result = delegate.find()
            }
            delegate.appendTail(sb)
            return sb.toString()
        }
        return matcher.replaceAll()
    }
}
