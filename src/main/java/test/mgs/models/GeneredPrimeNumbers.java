package test.mgs.models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * test from "MGS.BET"
 * класс генерации простых чисел с использованием сита Эратосфена
 *
 * @author Anton Shatkovskiy
 * created 02.08.2022
 */
public class GeneredPrimeNumbers {

    private final List<Integer> arrays;

    public GeneredPrimeNumbers (int size) {
        this.arrays = primeNumbersTill(size);
    }

    public List<Integer> getArrays() {
        return arrays;
    }

    private List<Integer> primeNumbersTill(int size) {
        boolean prime[] = new boolean[size + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= size; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= size; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= size; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

}
