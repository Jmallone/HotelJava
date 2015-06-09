/*
 *                                                                                     
                                                                                    
        CCCCCCCCCCCCC                                                         iiii  
     CCC::::::::::::C                                                        i::::i 
   CC:::::::::::::::C                                                         iiii  
  C:::::CCCCCCCC::::C                                                               
 C:::::C       CCCCCC  aaaaaaaaaaaaa     qqqqqqqqq   qqqqquuuuuu    uuuuuu  iiiiiii 
C:::::C                a::::::::::::a   q:::::::::qqq::::qu::::u    u::::u  i:::::i 
C:::::C                aaaaaaaaa:::::a q:::::::::::::::::qu::::u    u::::u   i::::i 
C:::::C                         a::::aq::::::qqqqq::::::qqu::::u    u::::u   i::::i 
C:::::C                  aaaaaaa:::::aq:::::q     q:::::q u::::u    u::::u   i::::i 
C:::::C                aa::::::::::::aq:::::q     q:::::q u::::u    u::::u   i::::i 
C:::::C               a::::aaaa::::::aq:::::q     q:::::q u::::u    u::::u   i::::i 
 C:::::C       CCCCCCa::::a    a:::::aq::::::q    q:::::q u:::::uuuu:::::u   i::::i 
  C:::::CCCCCCCC::::Ca::::a    a:::::aq:::::::qqqqq:::::q u:::::::::::::::uui::::::i
   CC:::::::::::::::Ca:::::aaaa::::::a q::::::::::::::::q  u:::::::::::::::ui::::::i
     CCC::::::::::::C a::::::::::aa:::a qq::::::::::::::q   uu::::::::uu:::ui::::::i
        CCCCCCCCCCCCC  aaaaaaaaaa  aaaa   qqqqqqqq::::::q     uuuuuuuu  uuuuiiiiiiii
                                                  q:::::q                           
                                                  q:::::q                           
                                                 q:::::::q                          
                                                 q:::::::q                          
                                                 q:::::::q                          
                                                 qqqqqqqqq      
                                                                     
                                                                                    
 * 
 */
package br.michel.pacote1;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}