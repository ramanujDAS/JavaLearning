package eventLoop.service;

import eventLoop.model.Event;
import eventLoop.model.EventResult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

public class EventLoop {
    private final Deque<Event> eventDeque;
    private final Deque<EventResult> processedEvents;

    private final Map<String, Function<String, String>> handlers;

    public EventLoop(Map<String, Function<String, String>> handlers) {
        this.handlers = handlers;
        this.eventDeque = new ArrayDeque<>();
        this.processedEvents = new LinkedList<>();
    }

    public EventLoop on(String key, Function<String, String> handler) {
        handlers.put(key, handler);
        return this;
    }

    public void dispatch(Event event) {
        eventDeque.add(event);
    }
}
