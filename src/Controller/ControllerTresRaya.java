/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TresRaya;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class ControllerTresRaya {
    private boolean permitir = true;
    TresRaya tresraya = new TresRaya();
    private int matriz[][] = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    public void cambiarturno(){
        if (tresraya.getTurno() == 0) {
            tresraya.setTurno(1);
            //System.out.println(tresraya.getTurno());
        } else {
            tresraya.setTurno(0);
            //System.out.println(tresraya.getTurno());
        }
    }
    public void cambiarvariable(JLabel jb [], int casilla){
        //
        String n = new String();
        if(jb[casilla-1].getText().equals("")&&permitir){
            if(tresraya.getTurno() == 0){
                n = "X";
            }else{
                n = "O";
            }
            cambiarturno();
            jb[casilla-1].setText(n);
        }        
    }
    public void reinicio(JLabel [][] casillas){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = 0;
                casillas[i][j].setText(" ");
            }
        }
       
    }
    public void ganador(JLabel jb[], JLabel ganadorX, JLabel ganadorO){
        for (int i = 0; i < matriz.length; i++) {
            if (jb[matriz[i][0]-1].getText().equals("X")&& 
                jb[matriz[i][1]-1].getText().equals("X")&&
                jb[matriz[i][2]-1].getText().equals("X")){
                JOptionPane.showMessageDialog(null, "Ha Ganado X !Felicitaciones!");
                ganadorX.setText(Integer.toString(Integer.parseInt(ganadorX.getText())+1));
                permitir = false;
                
            }
            if (jb[matriz[i][0]-1].getText().equals("O")&& 
                jb[matriz[i][1]-1].getText().equals("O")&&
                jb[matriz[i][2]-1].getText().equals("O")){
                JOptionPane.showMessageDialog(null, "Ha Ganado O !Felicitaciones!");
                ganadorO.setText(Integer.toString(Integer.parseInt(ganadorO.getText())+1));
                permitir = false;
            }
        }
    }
}
