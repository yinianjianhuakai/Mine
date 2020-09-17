//package sdkdemo.demo.com.event;
//
//import android.util.Log;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Queue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class EventBus {
//    private static final    String   TAG      = "EventBus";
//    private volatile static EventBus instance = null;
//
//    private EventBus() {
//    }
//
//    private static class Holder{
//        private static EventBus instance = new EventBus();
//    }
//
//    private Map<Object, Object> map   = new HashMap<>();
//    private Queue<Event>        queue = new LinkedBlockingQueue<>();
//
//    public static EventBus getInstance() {
//        return Holder.instance;
//    }
//
//    public void register(Object obj) {
//        map.put(obj.getClass(), obj);
//    }
//
//    public void unRegister(Object obj) {
//        map.remove(obj);
//    }
//
//    public void sendMsg(Event event) {
//        queue.add(event);
//        if (map.isEmpty()) {
//            return;
//        }
//        event = queue.poll();
//        Class target = event.getTarget();
//        if (target != null) {
//            log("has target : " + target);
//            if (map.containsKey(target)) {
//                Object objValue = map.get(target);
//                if (objValue instanceof OnEventListener) {
//                    ((OnEventListener) objValue).onEvent(event);
//                }
//            }
//        } else {
//            for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                Object objValue = entry.getValue();
//                log("no target : " + entry.getKey());
//                if (objValue instanceof OnEventListener) {
//                    ((OnEventListener) objValue).onEvent(event);
//                }
//            }
//        }
//    }
//
//    private void log(String log) {
//        Log.i(TAG, log);
//    }
//}
