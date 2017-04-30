package ohtu;
import javax.swing.JTextField;
public class Erotus implements Komento {
    private Sovelluslogiikka io;
    JTextField tuloskentta;
    JTextField syotekentta;
    private int prev;
    public Erotus(Sovelluslogiikka io, JTextField t1, JTextField t2){
        this.tuloskentta = t1;
        this.syotekentta = t2;
        this.io = io;
    }
        @Override
    public void suorita() {
        prev = Integer.parseInt(syotekentta.getText());
        io.miinus(prev);
        syotekentta.setText("");
        tuloskentta.setText("" + io.tulos());
    }
        @Override
    public void peru(){
        io.plus(prev);
        syotekentta.setText("");
        tuloskentta.setText("" + io.tulos());
        
    }
}