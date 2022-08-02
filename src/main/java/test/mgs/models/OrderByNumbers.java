package test.mgs.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * test from "MGS.BET"
 * класс генерации по 5 последовательностям
 *
 * @author Anton Shatkovskiy
 * created 02.08.2022
 */
public class OrderByNumbers {

    private final GeneredPrimeNumbers generedPrimeNumbers = new GeneredPrimeNumbers(20000);
    private final List<List<Integer>> generatedOrderByList;

    public OrderByNumbers(int size) {
        this.generatedOrderByList = generatedOrderBy(size);
    }

    private List<List<Integer>> generatedOrderBy(int size) {
        List<List<Integer>> newList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                int x = random.nextInt(200);
                list.add(generedPrimeNumbers.getArrays().get(x));
                generedPrimeNumbers.getArrays().remove(x);
            }
            newList.add(list);
        }
        return newList;
    }

    public List<List<Integer>> getGeneratedOrderByList() {
        return generatedOrderByList;
    }

    public List<List<Integer>> getGeneratedOrderByListOf(int size) {
        return generatedOrderBy(size);
    }

}
