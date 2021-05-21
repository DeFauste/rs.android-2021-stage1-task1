package subtask3

import java.lang.StringBuilder

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val array: ArrayList<String> = findElemnt(inputString,0).split("%!%") as ArrayList<String>
        array.remove("")

        return array.toTypedArray()
    }
    fun findElemnt(inputString: String, startIndex:Int): String{
        val result = StringBuilder()
        var index: Int = startIndex
        val minIndex:Int = findFirstEntry(inputString,startIndex)
        if (minIndex == -1) {
            return result.toString()
        }
        if(index < minIndex) index = minIndex
        var count = 0
        val open: Char = inputString[index]
        val close: Char = if(open.toInt() != 40) open+2 else  open+1
        for(i in index..(inputString.length-1)){
            if(open.equals(inputString[i]))
                count++

            if(close.equals(inputString[i]))
                count--
            if(count == 0){
                result.append(inputString.substring(index+1, i) + "%!%" + findElemnt(inputString,index+1))
                break
            }
        }

        return result.toString()
    }
    fun findFirstEntry(inputString: String, startIndex: Int):Int{
        val minIndex:ArrayList<Int> = arrayListOf(inputString.indexOf("(",startIndex),
            inputString.indexOf("[",startIndex),
            inputString.indexOf("<",startIndex))
        minIndex.sort()
        if(minIndex[0] != -1)
            return minIndex[0]
        else if(minIndex[1] != -1)
            return minIndex[1]
        else
            return minIndex[2]
    }
}
