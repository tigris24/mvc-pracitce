package com.example.mvcpractice2.mvc;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}