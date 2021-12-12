package PIUGame.States;

import PIUGame.RefLinks;
import lombok.Getter;

import java.awt.*;

public abstract class State {

    @Getter
    private static State previousState = null;     // Referinta catre starea anterioara a jocului.
    @Getter
    private static State currentState = null;     // Referinta catre starea curenta a jocului: game, meniu, settings, about etc.
    protected RefLinks refLink;

    public State(RefLinks refLink) {
        this.refLink = refLink;
    }

    public static void setState(State state) {
        previousState = currentState;
        currentState = state;
    }

    ///Metoda destinata actualizarii starii curente
    public void Update() {
    }

    ///Metoda destinata desenarii starii curente
    public void Draw(Graphics g) {
    }
}
