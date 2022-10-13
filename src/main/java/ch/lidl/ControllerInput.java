package ch.lidl;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class ControllerInput {
    public static void main (String[] args){
        Controller controller = null;

        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i = 0; i < controllers.length; i++){
            if(controllers[i].getType() == Controller.Type.STICK) {
                controller = controllers[i];
            }
        }

        EventQueue eventQueue = controller.getEventQueue();
        Event event = new Event();

        long lastTime = System.nanoTime();
        double clockTime = 120.0;
        double ns = (1 * Math.pow(10, 9)) / clockTime;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

             Component component = event.getComponent();

            controller.poll();
            eventQueue.getNextEvent(event);

            if(delta >= 1) {
                if(component != null){
                Component.Identifier identifier = component.getIdentifier();
                if(identifier == Component.Identifier.Button._5){
                    System.out.println("Button 5");
                } else if (identifier == Component.Identifier.Button._0) {
                    System.out.println("Button 0");
                }
                eventQueue = controller.getEventQueue();
                component = event.getComponent();
                }
        }

    }
}
}
