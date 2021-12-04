package PIUGame.States;

import java.awt.*;

import PIUGame.RefLinks;

public abstract class State {

    private static State previousState  = null;     // < Referinta catre starea anterioara a jocului.
    private static State currentState   = null;     // < Referinta catre starea curenta a jocului: game, meniu, settings, about etc.
    protected RefLinks refLink;
    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }

    public static State GetState()
    {
        return currentState;
    }

    public static State GetPreviousState(){
        return previousState;
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
    ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);


}
