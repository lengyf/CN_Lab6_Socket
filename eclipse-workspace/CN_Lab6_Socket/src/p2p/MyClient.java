package p2p;

import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class MyClient extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea jta=null;
    JTextField jtf=null;
    JButton jb=null;
    JScrollPane jsp=null;
    JPanel jp1=null;
    PrintWriter pw=null;
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		MyClient mct=new MyClient() ;
    }
    public MyClient()
    {
        jta=new JTextArea() ;
        jtf=new JTextField(20) ;
        jsp=new JScrollPane(jta) ;
        jb=new JButton("发送") ;
        jb. addActionListener(this) ;
        jp1=new JPanel() ;
        this. add(jsp, "Center") ;
        jp1. add(jtf) ;
        jp1. add(jb) ;
        this. add(jp1, "South") ;
        this. setTitle("(客户端) ") ;
        this. setSize(400, 300) ;this. setVisible(true) ;
        try{
            @SuppressWarnings("resource")
			Socket s=new Socket("192.168.43.197", 8000) ;
            InputStreamReader isr=new
            InputStreamReader(s. getInputStream() ) ;
            BufferedReader br=new BufferedReader(isr) ;
            pw=new PrintWriter(s. getOutputStream() , true) ;
            while(true)
            {
                String info=br. readLine() ; //读取从服务器发来的信息
                jta. append("服务器对客户端说： "+info+"\r\n") ;
            }
        } catch(Exception e) {
            e. printStackTrace() ;
          }
    }
    public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
        if(e. getSource() ==jb)
        {
            String info=jtf. getText() ;
            jta. append("客户端对服务器说： "+info+"\r\n") ;
            pw. println(info) ;
         }
   }
}
