package com.trabalhoengsw.revi.controllers;

import java.util.List;

public interface Controller<T> {
    T createElement(T element);
    List<T> getElements();
    T getElementById(Integer id);
    T updateElement(Integer id, T element);
    void deleteElement(Integer id);
}
