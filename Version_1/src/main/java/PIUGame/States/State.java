package PIUGame.States;

import PIUGame.RefLinks;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class State {

    private static State previousState = null;     // < Referinta catre starea anterioara a jocului.
    private static State currentState = null;     // < Referinta catre starea curenta a jocului: game, meniu, settings, about etc.
    protected RefLinks refLink;

    public State(RefLinks refLink) {
        this.refLink = refLink;
    }

    public static void setState(State state)
    {
        previousState = currentState;
        currentState = state;
    }

    public static State getPreviousState() {
        return previousState;
    }

    public static State getState()
    {
        return currentState;
    }

    ///Metoda destinata actualizarii starii curente
    public void Update(){};

    ///Metoda destinata desenarii starii curente
    public void Draw(Graphics g){};
}
