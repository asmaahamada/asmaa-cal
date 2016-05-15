package asmaa;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class asm extends Application{
	String [] operator;
	String s="";
String [] ch;
double result=0;
TextField t=new TextField();
String  che="";
String  sub="";
int i=0;

public double arrcs(){
	String arrc="";
	String endcal="";
	int i=0;
	while(i<s.length()){
		if(s.charAt(i)=='('){
			i++;
			while(s.charAt(i)!=')'){
				arrc+=String.format(s.charAt(i)+"");
				i++;
			}

			endcal+=String.format(cal(arrc)+"");
			
		}
		if(s.charAt(i)==')'&&(i<s.length()-1)){
			
			if(s.charAt(i+2)=='('){
			//	arrc+=String.format(s.charAt(i+1)+"");
				//(2)+(3*2)
				endcal=String.format(s.charAt(i+1)+"");
				i++;
				while(s.charAt(i+2)!=')'){
					//endcal+=String.format(s.charAt(i+2)+"");
				endcal+=s.substring(i+2, s.length()-1);
					i++;
					
				}
				System.out.print(endcal);
				endcal+=String.format(cal(arrc)+"");
			}
			else{
				endcal+=s.substring(i, s.length());
				i++;
			}
			
		}
	
		 if(s.charAt(i)!='('){
			endcal+=String.format(s.charAt(i)+"");
			i++;
		}
	}
	return cal(endcal);
}

public double cal(String value ){
	ch=new String[value.length()];
    ch=value.split("[\\+\\-\\*\\/\\^\\%\\(\\)\\√\\!]");
 operator=new String[value.length()-1];
String reg="(\\d+)";
operator=value.split(reg);
result=Double.parseDouble(ch[0]);
for(int i=0;i<operator.length;i++){
try{
switch(operator[i])
 {
 case "+": 
	 result+=Double.parseDouble(ch[i]);
 break;
 case "-": 
	 result-=Double.parseDouble(ch[i]);
 break;
 case "*":
	 result*=Double.parseDouble(ch[i]);
 break;
 case "/":  result/=Double.parseDouble(ch[i]);
 break;
 case "^" : 
	 result=Math.pow(result,Double.parseDouble(ch[i]));
	 break;
 case "%" : 
	 result%=100;
	 break;
 case "√" :
	 result =Math.sqrt(Double.parseDouble(ch[i-1]));
	 break;
 case "!" :
     double fact = 1;
     double n = Integer.parseInt(ch[i-1]);
     for(double j= 1;j<=n;j++){
         fact = fact * j;
     }
result=fact;
	 break;
	 }
	}
    catch(ArrayIndexOutOfBoundsException e){
        result=0;
}
	}
return result;	
}


Button b1=	new Button("7");
Button b2=	new Button("8");
Button b3=	new Button("9");
Button b4=	new Button("%");
Button b5=	new Button("←");
Button b6=	new Button("⌂");
Button b7=	new Button("4");
Button b8=	new Button("5");
Button b9=	new Button("6");
Button b10=	new Button("*");
Button b11=	new Button("(");
Button b12=	new Button(")");
Button b13=	new Button("1");
Button b14=	new Button("2");
Button b15=	new Button("3");
Button b16=	new Button("-");
Button co=	new Button("cos");
Button lo=	new Button("log");
Button ex=	new Button("^");
Button li=	new Button("Ln");
Button si=	new Button("sin");
Button ep=	new Button("x^3");
Button b17=	new Button("x^2");
Button b18=	new Button("√");
	@Override
	public void start(Stage st){
		VBox pane=new VBox();
	pane.setPadding(new Insets(10, 10, 10, 10));
	pane.setStyle(
			"-fx-border-color: red;-fx-border-width: 3 ;-fx-background-color: lightgray;");
	pane.setSpacing(8);
	t.setPrefSize(230, 70);
	t.setStyle(
			"-fx-border-color: gray;-fx-border-width: 1 ;");
	t.setEditable(false);
pane.getChildren().add(t);
HBox h=new HBox(5);

b1.setPrefSize(45,30);
h.getChildren().add( b1);
b1.setStyle("-fx-background-color:gray ");
b1.setOnAction((ActionEvent e)->{
	s+=b1.getText();	
	settext(s);
});
b2.setPrefSize(45,30);
h.getChildren().add(b2);
b2.setStyle("-fx-background-color:gray ");
b2.setOnAction((ActionEvent e)->{
s+=b2.getText();
	settext(s);
});
b3.setPrefSize(45,30);
h.getChildren().add(b3);
b3.setStyle("-fx-background-color:gray ");
b3.setOnAction((ActionEvent e)->{
s+=b3.getText();
	settext(s);
});
b4.setPrefSize(45,30);
h.getChildren().add(b4);
b4.setStyle("-fx-background-color:gray ");
b4.setOnAction((ActionEvent e)->{	
s+=b4.getText();
	settext(s);
});
b5.setPrefSize(45,30);
b5.setStyle("-fx-background-color:gray ");
b5.setOnAction((ActionEvent e)->{
s=t.getText();
String  c= new String ();
c=s.substring(0,s.length()-1);
s=c;
settext(s);
});
h.getChildren().add(b5);

b6.setPrefSize(45,30);
b6.setStyle("-fx-background-color:gray ");
h.getChildren().add(b6);
b6.setOnAction((ActionEvent e)->{	
t.setText(" ");
s="";
});

co.setPrefSize(45,30);
co.setStyle("-fx-background-color:gray ");
h.getChildren().add(co);
co.setOnAction((ActionEvent e)->{	
	s+=co.getText();
	settext(s);
});

lo.setPrefSize(45,30);
lo.setStyle("-fx-background-color:gray ");
h.getChildren().add(lo);
lo.setOnAction((ActionEvent e)->{	
	s+=lo.getText();
	settext(s);
});

ex.setPrefSize(45,30);
ex.setStyle("-fx-background-color:gray ");
h.getChildren().add(ex);
ex.setOnAction((ActionEvent e)->{	
	s+=ex.getText();
	settext(s);
});

pane.getChildren().add(h);
HBox r=new HBox(5);

b7.setPrefSize(45,30);
b7.setStyle("-fx-background-color:gray ");
r.getChildren().add(b7);
b7.setOnAction((ActionEvent e)->{
s+=b7.getText();
	settext(s);
});

b8.setPrefSize(45,30);
b8.setStyle("-fx-background-color:gray ");
r.getChildren().add(b8);
b8.setOnAction((ActionEvent e)->{
s+=b8.getText();
	settext(s);
});

b9.setPrefSize(45,30);
b9.setStyle("-fx-background-color:gray ");
r.getChildren().add(b9);
b9.setOnAction((ActionEvent e)->{
s+=b9.getText();
	settext(s);
});

b10.setPrefSize(45,30);
b10.setStyle("-fx-background-color:gray ");
r.getChildren().add(b10);
b10.setOnAction((ActionEvent e)->{
s+=b10.getText();
	settext(s);
});

b11.setPrefSize(45,30);
b11.setStyle("-fx-background-color:gray ");
r.getChildren().add(b11);
b11.setOnAction((ActionEvent e)->{
s+=b11.getText();
	settext(s);
});

b12.setPrefSize(45,30);
r.getChildren().add(b12);
b12.setStyle("-fx-background-color:gray ");
b12.setOnAction((ActionEvent e)->{
s+=b12.getText();	
	settext(s);
});

si.setPrefSize(45,30);
si.setStyle("-fx-background-color:gray ");
r.getChildren().add(si);
si.setOnAction((ActionEvent e)->{	
	s+=si.getText();
	settext(s);
});

li.setPrefSize(45,30);
li.setStyle("-fx-background-color:gray ");
r.getChildren().add(li);
li.setOnAction((ActionEvent e)->{	
	s+=li.getText();
	settext(s);
});

ep.setPrefSize(47,30);
ep.setStyle("-fx-background-color:gray ");
r.getChildren().add(ep);
ep.setOnAction((ActionEvent e)->{	
	s+="^3";
	settext(s);
});

pane.getChildren().add(r);
HBox r1=new HBox(5);

b13.setStyle("-fx-background-color:gray ");
b13.setPrefSize(45,30);
r1.getChildren().add(b13);
b13.setOnAction((ActionEvent e)->{
s+=b13.getText();	
	settext(s);
});

b14.setPrefSize(45,30);
r1.getChildren().add(b14
		);
b14.setStyle("-fx-background-color:gray ");
b14.setOnAction((ActionEvent e)->{
s+=b14.getText();
	settext(s);
});

b15.setPrefSize(45,30);
r1.getChildren().add(b15);
b15.setStyle("-fx-background-color:gray ");
b15.setOnAction((ActionEvent e)->{
s+=b15.getText();
	
	settext(s);
});

b16.setPrefSize(45,30);
b16.setStyle("-fx-background-color:gray ");
r1.getChildren().add(b16);
b16.setOnAction((ActionEvent e)->{
s+=b16.getText();
	
	settext(s);
	
});

b17.setPrefSize(46,30);
b17.setStyle("-fx-background-color:gray ");
r.getChildren().add(b17);
r1.getChildren().add(b17);
b17.setOnAction((ActionEvent e)->{
s+="^2";
	
	settext(s);
});

b18.setPrefSize(45,30);
b18.setStyle("-fx-background-color:gray ");
r.getChildren().add(b18);
r1.getChildren().add(b18);
b18.setOnAction((ActionEvent e)->{
s+=b18.getText();

	settext(s);


});
Button ta=	new Button("tan");
ta.setPrefSize(45,30);
ta.setStyle("-fx-background-color:gray ");
r1.getChildren().add(ta);
ta.setOnAction((ActionEvent e)->{	
	s+=ta.getText();
	settext(s);
});
Button fa=	new Button("!");
fa.setPrefSize(45,30);
fa.setStyle("-fx-background-color:gray ");
r1.getChildren().add(fa);
fa.setOnAction((ActionEvent e)->{	
	s+=fa.getText();
	settext(s);
});
Button exp=	new Button("1/x");
exp.setPrefSize(45,30);
exp.setStyle("-fx-background-color:gray ");
r1.getChildren().add(exp);
exp.setOnAction((ActionEvent e)->{	
	s+="1/";
	settext(s);
});
pane.getChildren().add(r1);
HBox r2=new HBox(5);
Button b19=	new Button("0");
b19.setPrefSize(45,30);
b19.setStyle("-fx-background-color:gray ");
r2.getChildren().add(b19);
b19.setOnAction((ActionEvent e)->{
s+=b19.getText();
	settext(s);
});
Button b20=	new Button(".");
b20.setPrefSize(45,30);
b20.setStyle("-fx-background-color:gray ");
r2.getChildren().add(b20);
b20.setOnAction((ActionEvent e)->{
	if(s.charAt(s.length()-1)=='.')settext(s);
	else
	{
s+=b20.getText();
settext(s);
	}
});
Button b21=	new Button("/");
b21.setPrefSize(45,30);
b21.setStyle("-fx-background-color:gray ");
r2.getChildren().add(b21);
b21.setOnAction((ActionEvent e)->{
s+=b21.getText();
	settext(s);
});
Button b22=	new Button("+");
b22.setPrefSize(45,30);
b22.setStyle("-fx-background-color:gray ");
r2.getChildren().add(b22);
b22.setOnAction((ActionEvent e)->{
	s+=b22.getText();
	settext(s);
});
Button pi=	new Button("𝜋");
pi.setPrefSize(45,30);
pi.setStyle("-fx-background-color:gray ");
r2.getChildren().add(pi);
pi.setOnAction((ActionEvent e)->{	
	double x=Math.PI;
	s+=(x)+"";
	settext(s);
});
Button ee=	new Button("10^𝑥");
ee.setPrefSize(50,30);
ee.setStyle("-fx-background-color:gray ");
r2.getChildren().add(ee);
ee.setOnAction((ActionEvent e)->{	
	
	s+="10^";
	settext(s);
});
Button b23=	new Button("=");
b23.setPrefSize(80,30);
b23.setStyle("-fx-background-color:gray ");
r2.getChildren().add(b23);

b23.setOnAction((ActionEvent e)->{
	String tt=t.getText();
	
	if(tt.charAt(0)=='c'){
	String d=tt.substring(3,tt.length());
	result=Math.cos(Double.parseDouble(d)*Math.PI/180);
	settext(result+"");
	}
	else if(tt.charAt(0)=='s'){
		String d=tt.substring(3,tt.length());
		result=Math.sin(Double.parseDouble(d)*Math.PI/180);
		settext(result+"");
		}
	else if(tt.charAt(0)=='t'){
		String d=tt.substring(3,tt.length());
		result=Math.tan(Double.parseDouble(d)*Math.PI/180);
			settext(result+"");
	}
	else if(tt.charAt(0)=='l'){
		String d=tt.substring(3,tt.length());
		result=Math.log10((Double.parseDouble(d)));
			settext(result+"");
	}
	else if(tt.charAt(0)=='L'){
		String d=tt.substring(2,tt.length());
		result=Math.log((Double.parseDouble(d)));
			settext(result+"");
	}
	else{
String result1="";
//cal(split(s))+
result1=String.format(arrcs()+"");
settext(result1);
	}
});
pane.getChildren().add(r2);
Scene S=new Scene(pane,380,270);
st.setTitle("calculator");
st.setScene(S);
st.setResizable(false);
st.show();
	}
	public void settext(String s){
		t.setText(s);	
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		}}