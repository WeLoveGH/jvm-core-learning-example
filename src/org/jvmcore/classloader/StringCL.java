package org.jvmcore.classloader; /*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author BYSocket
 * @since 2015-12-15 13:18:00
 *  类加载 - Class.forName
 */
public class StringCL {
    public static void main(String[] args) throws ClassNotFoundException {

        Class clzStr = Class.forName("java.lang.String");

        // 返回对象方法数组
        Method[] methods = clzStr.getDeclaredMethods();

        for (Method m : methods) {
            // 获取修饰符标志的字符串
            String mod = Modifier.toString(m.getModifiers());
            System.out.print(mod + " " + m.getName() + "(");
            Class<?>[] ps = m.getParameterTypes();
            if (ps.length == 0){
                System.out.print(')');
            }
            for (int i = 0; i < ps.length;i++) {
                char end = i == ps.length -1 ? ')':',';
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }

    }
}


/*

通过日志可以看到：
1：通过反射可以拿到一个类的所有信息，包括 public/private/static 等关键字修饰的方法
2：所以，只要知道一个类的全路径名，在类外私有方法也是可以调用的，所以，存在一定的安全性问题
3：

public equals(Object)
public toString()
public hashCode()
public compareTo(String)
public volatile compareTo(Object)
public indexOf(String,int)
public indexOf(String)
public indexOf(int,int)
public indexOf(int)
static indexOf(char[],int,int,char[],int,int,int)
static indexOf(char[],int,int,String,int)
public static valueOf(int)
public static valueOf(long)
public static valueOf(float)
public static valueOf(boolean)
public static valueOf(char[])
public static valueOf(char[],int,int)
public static valueOf(Object)
public static valueOf(char)
public static valueOf(double)
public charAt(int)
private static checkBounds(byte[],int,int)
public codePointAt(int)
public codePointBefore(int)
public codePointCount(int,int)
public compareToIgnoreCase(String)
public concat(String)
public contains(CharSequence)
public contentEquals(CharSequence)
public contentEquals(StringBuffer)
public static copyValueOf(char[])
public static copyValueOf(char[],int,int)
public endsWith(String)
public equalsIgnoreCase(String)
public static transient format(Locale,String,Object[])
public static transient format(String,Object[])
public getBytes(int,int,byte[],int)
public getBytes(Charset)
public getBytes(String)
public getBytes()
public getChars(int,int,char[],int)
 getChars(char[],int)
private indexOfSupplementary(int,int)
public native intern()
public isEmpty()
public static transient join(CharSequence,CharSequence[])
public static join(CharSequence,Iterable)
public lastIndexOf(int)
public lastIndexOf(String)
static lastIndexOf(char[],int,int,String,int)
public lastIndexOf(String,int)
public lastIndexOf(int,int)
static lastIndexOf(char[],int,int,char[],int,int,int)
private lastIndexOfSupplementary(int,int)
public length()
public matches(String)
private nonSyncContentEquals(AbstractStringBuilder)
public offsetByCodePoints(int,int)
public regionMatches(int,String,int,int)
public regionMatches(boolean,int,String,int,int)
public replace(char,char)
public replace(CharSequence,CharSequence)
public replaceAll(String,String)
public replaceFirst(String,String)
public split(String)
public split(String,int)
public startsWith(String,int)
public startsWith(String)
public subSequence(int,int)
public substring(int)
public substring(int,int)
public toCharArray()
public toLowerCase(Locale)
public toLowerCase()
public toUpperCase()
public toUpperCase(Locale)
public trim()

Process finished with exit code 0


 */