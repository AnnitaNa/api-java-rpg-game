package com.Avanade.desafio.services;

import org.springframework.stereotype.Service;

@Service
public class DiceService {

    public long throwDice(long sides) {
        long max = sides;
        int min = 1;
        int random = (int) (Math.random() * max + min);

        return  random;
    }

    public long throwAllDices(long num, long sides) {
        long sum =0;
        for (int i =0; i<num; i++) {
          sum =   this.throwDice(sides);
        }
        return sum;
    }

}
