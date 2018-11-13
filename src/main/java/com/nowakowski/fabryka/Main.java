package com.nowakowski.fabryka;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Arrays.asList("input.json", "input.xml", "input.csv").forEach(x -> {
      System.out.println("Serializowanie: " + x);
      try {
        Serializer.serialize(new File(x));
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
