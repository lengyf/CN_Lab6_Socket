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
        jb=new JButton("����") ;
        jb. addActionListener(this) ;
        jp1=new JPanel() ;
        this. add(jsp, "Center") ;
        jp1. add(jtf) ;
        jp1. add(jb) ;
        this. add(jp1, "South") ;
        this. setTitle("(�ͻ���) ") ;
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
                String info=br. readLine() ; //��ȡ�ӷ�������������Ϣ
                jta. append("�������Կͻ���˵�� "+info+"\r\n") ;
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
            jta. append("�ͻ��˶Է�����˵�� "+info+"\r\n") ;
            pw. println(info) ;
         }
   }
}
