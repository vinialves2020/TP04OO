package TP04;

import java.sql.Date;

public class Padronizacao {
    protected Date data;
    protected Float odometro;
    
    public Date getData() {
        return data;
    }
    public Float getOdometro() {
        return odometro;
    }
    public void setOdometro(Float odometro) {
        this.odometro = odometro;
    }
    public void setData(Date data) {
        this.data = data;
    }
}
