package p2p;

import javax. swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io. *;
//implements AcionListener

public class MyServer extends JFrame implements ActionListener{
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
		MyServer msv=new MyServer();
    }
    public MyServer()
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
        this. setTitle("(��������) ") ;
        this. setSize(400, 300) ;
        this. setVisible(true) ;
        try{
			ServerSocket ss=new ServerSocket(8000) ; ////����������
                Socket s=ss. accept() ;
                InputStreamReader isr=new
                InputStreamReader(s. getInputStream() ) ;
                BufferedReader br=new BufferedReader(isr) ;
                pw=new PrintWriter(s. getOutputStream() , true) ;
                while(true)
                {
                    String info=br. readLine() ; //��ȡ��Ϣ
                    jta. append("�ͻ��˶Է�����˵�� "+info+"\r\n") ;
                }
        } catch(Exception e) {
              e. printStackTrace() ;
        }
    }
     public void actionPerformed(ActionEvent e) {//������·��Ͱ�ť
	// TODO Auto-generated method stub
	    if(e. getSource() ==jb)
	    {
	        String info=jtf. getText() ;
	        jta. append("�������Կͻ���˵�� "+info+"\r\n") ;
	        pw. println(info) ;
	        jtf. setText("") ; //��շ����ı���
	    }
	}
}
 



 


 

 
