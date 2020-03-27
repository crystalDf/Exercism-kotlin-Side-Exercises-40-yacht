object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {

        dices.sort()

        return when (category) {
            YachtCategory.YACHT -> if (dices.toSet().size == 1) 50 else 0
            YachtCategory.ONES -> dices.filter { it == 1 }.sum()
            YachtCategory.TWOS -> dices.filter { it == 2 }.sum()
            YachtCategory.THREES -> dices.filter { it == 3 }.sum()
            YachtCategory.FOURS -> dices.filter { it == 4 }.sum()
            YachtCategory.FIVES -> dices.filter { it == 5 }.sum()
            YachtCategory.SIXES -> dices.filter { it == 6 }.sum()
            YachtCategory.FULL_HOUSE ->
                if ((dices.toSet().size == 2) && (dices[1] != dices[3]))
                    dices.sum() else 0
            YachtCategory.FOUR_OF_A_KIND ->
                if ((dices.toSet().size == 1) || ((dices.toSet().size == 2) && (dices[1] == dices[3])))
                    dices[1] * 4 else 0
            YachtCategory.LITTLE_STRAIGHT ->
                if (dices.toList() == (1..5).toList())
                    return 30 else 0
            YachtCategory.BIG_STRAIGHT ->
                if (dices.toList() == (2..6).toList())
                    return 30 else 0
            else -> dices.sum()
        }
    }
}
