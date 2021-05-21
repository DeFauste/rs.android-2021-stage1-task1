package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var fiftyFifty: Int = (bill.sum() - bill[k]) / 2
        if (fiftyFifty != b) {
            var over: Int = b - fiftyFifty

            return over.toString()
        }

        return "Bon appetit"
    }
}
