package com.nowakowski.fabryka;

import java.util.List;

public class Entity {
  private String id;
  private String name;
  private List<String> list;

  public Entity() {
  }

  public Entity(String id, String name, List<String> list) {
    this.id = id;
    this.name = name;
    this.list = list;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "Entity{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", list=" + list +
        '}';
  }
}
