package criadorappreactnext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */

public class CriadorAppReactNext {

    private static String caminhoRaizProjeto;

    public static String getCaminhoRaizProjeto() {
        return caminhoRaizProjeto;
    }

    public static void setCaminhoRaizProjeto(String aCaminhoRaizProjeto) {
        caminhoRaizProjeto = aCaminhoRaizProjeto;
    }
    
    /**
     * 
     * @param pastaRaiz
     * @param comando
     * @param jTextArea1 
     */
    public static void executarComando(String pastaRaiz, String comando, JTextArea jTextArea1) {
        try {
            
            
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd /d "+ pastaRaiz + " && " + comando);

            builder.redirectErrorStream(true);

            Process p = builder.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            try {
                
                StringBuilder sb = new StringBuilder();
                
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                
                String everything = sb.toString();
                
                jTextArea1.setText(everything);
                
            } finally {
                br.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param pastaRaiz
     * @param comando
     * @param jTextArea1 
     */
    public static void exerComandoSemSaida(String pastaRaiz, String comando, JTextArea jTextArea1) {
        try {
            
            
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd /d "+ pastaRaiz + " && " + comando);

            builder.redirectErrorStream(true);

            Process p = builder.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            try {
               /* 
                StringBuilder sb = new StringBuilder();
                
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                
                String everything = sb.toString();
                */
               // jTextArea1.setText(everything);
                
            } finally {
                br.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
