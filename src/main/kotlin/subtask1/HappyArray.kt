package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size <= 2) return sadArray

        val happy: ArrayList<Int> = sadArray.toList() as ArrayList<Int>
        var i = 1
        while (true) {
            if (i == 0) i++
            if (i == happy.size - 1) break
            if (happy.get(i) > (happy.get(i - 1) + happy.get(i + 1))) {
                happy.removeAt(i)
                i--
                continue
            }
            i++
        }
        return happy.toIntArray()
    }
}
