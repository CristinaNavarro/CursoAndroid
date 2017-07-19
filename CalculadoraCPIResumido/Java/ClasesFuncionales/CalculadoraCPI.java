package ClasesFuncionales;

/**
 * Created by android7Ed on 29/06/2017.
 */

public class CalculadoraCPI {
    double x;
    double y;
    double z;
    double t;

    public CalculadoraCPI(){
        this.x=0;
        this.y=0;
        this.z=0;
        this.t=0;
    }

    public void entra(double numero){
        if(x==0){
            x = numero;
        }else if(y==0){
            y=x;
            x=numero;
        }else if(z==0){
            z=y;
            y=x;
            x = numero;
        }else{
            t=z;
            z=y;
            y=x;
            x = numero;
        }
    }

    public void suma(){
        x+=y;
        organizar();
    }

    public void resta(){
        x=y-x;
        organizar();
    }

    public void multiplica(){
        x*=y;
        organizar();
    }

    public void divide(){
        x=y/x;
        organizar();
    }

    public double getResultado(){
        return this.x;
    }

    public void organizar(){
        t=z;
        z=y;
    }

    public String toString(){
        return "CPI(x = " +this.x +" y = " +this.y +" z = " +this.z +" t = " +this.t +")";
    }
}
