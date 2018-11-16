import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Class; // pode-se usar diretamente sem fazer a importa��o


public class BDConect{
	static Connection connection = null;
	static ResultSet result      = null;
	static Statement statement   = null;
        
 
	//Dados do SGBD
	static String  usuario = "postgres";
	//static String  senha  = "postgres"; //- Postgres 9.???
	static String  senha  = "utfpr";
	//static String url = "jdbc:postgresql://localhost:5432/BDCom"; // nome da fonte de dados - Postgres 9.??
	static String url = "jdbc:postgresql://localhost:5432/agro"; // nome da fonte de dados - Postgres 10.??
	

	//m�todo para estabelecer uma conex�o com SGBD

	public static void getConect(){
		try{
			Class classe = Class.forName("org.postgresql.Driver"); //encontrar para outros sgbd onde esta o .driver dele

			//System.out.println("\nClasse - toString   : "+classe.toString());
			//System.out.println("\nClasse - getName : "+classe.getName());

			connection = DriverManager.getConnection(url,usuario,senha);

			statement = connection.createStatement();
		}

		catch(ClassNotFoundException erro){
			System.out.println("\n\nNao encontrou o Driver do BD --> "+erro+"!");
                        		erro.printStackTrace();

		}
		catch(SQLException erro){
			System.out.println("\n\nProblemas de conex�o do SQL--> "+erro+"!");
			System.exit(0);
		}
	}

	public static void main(String args[]){
		//inSQL("insert into clientes(cpf, nome) values (4, 'brhue')");
		//updSQL("delete from clientes where pk_cli = 4");
		//updSQL("update clientes set debito = 0 where pk_cli = 700");
		//updSQL("update clientes set salario = 0 where pk_cli = 700");
		//System.out.print(setResult("select fis_cpf from fisica where pes_login = 'aaa' and pes_senha = 123 "));
                // int y = BuscaCnpjJur("select cnpj from pessoa where pes_login = 'aa' and pes_senha =4444 ");
                // System.out.println(y);
                
	}
	



	//metodo para a execucao de uma inser��o
	public static Boolean inSQL(String sql){
		boolean boolIns = true;
		try{
			getConect();
			boolIns = statement.execute(sql);//classe statement: execute (retorna booleano), result(recebe)(int) = executeQuery(retorna conj. de registros), recebe(int) = executeUpdate(retorna a quantidade de registros afetados)
                        System.out.println(boolIns);
                }
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
		}
		close();
                return boolIns;
	}


	//metodo para a execucao de uma atualiza��o
	public static int updSQL(String sql){
		int intUpd = 0;
		try{
			getConect();
			intUpd = statement.executeUpdate(sql);
              
		}
		catch(SQLException erro){
			System.out.println("Erro ao Atualizar! "+erro);
		}
		close();
                return intUpd;
	}


	//metodo para a execucao de uma consulta
	public static int BuscaCpfFis(String sql){
		ResultSet result = null;
                   int x = 0;
		try{
			getConect();
			result = statement.executeQuery(sql);
			close();
			
		}	
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
       
                
		try{
			while(result.next()){
                             x = +result.getInt("cpf");
                            //System.out.println("\n-CPF:"+ result.getInt("cpf") + "\n-Nome:"+result.getString("nome")+ "\n-Idade:"+result.getInt("idade")+ "\n-Sexo:"+result.getString("sexo"));       
			}
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);	
		}
      
               return x;
    	}
        
        public static int BuscaCnpjJur(String sql){
		ResultSet result = null;
                   int x = 0;
		try{
			getConect();
			result = statement.executeQuery(sql);
			close();
			
		}	
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
       
                
		try{
			while(result.next()){
                             x = +result.getInt("cnpj");
                           }
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);	
		}
      
               return x;
    	}
        
        public static void setAniResult(String sql){
		ResultSet result = null;
		try{
			getConect();
			result = statement.executeQuery(sql);
			close();
			
		}	
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
		try{
			while(result.next()){
				System.out.println("\n-Codigo:"+ result.getInt("cod_an") + "\n-Nome:"+result.getString("nome")+ "\n-Idade:"+result.getInt("idade")+ "\n-Raca:"+result.getString("raça")+ "\n-Peso:"+result.getInt("peso")+ "\n-Cpf_FK:"+result.getInt("cpf_fk"));
                  
			}
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);	
		}
    	}

/*public static Clientes setBuscaCPF(String sql){
		ResultSet result = null;
		try{
			getConect();
			result = statement.executeQuery(sql);
			close();
			
		}	
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
                Clientes cli = new Clientes();
		try{
			while(result.next()){
				//System.out.println("\n-CPF:"+ result.getInt("cpf") + "\n-Nome:"+result.getString("nome")+ "\n-Idade:"+result.getInt("idade")+ "\n-Sexo:"+result.getString("sexo"));       
                                
                                
                                cli.setCpf(result.getInt("cpf"));
                                cli.setNome(result.getString("nome"));
                                cli.setIdade(result.getInt("idade"));
                                cli.setSexo(result.getString("sexo"));
                                
                        }
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);	
		}
                return cli;
                                
    	}

public static Animais setBuscaCPFAni(String sql){
		ResultSet result = null;
		try{
			getConect();
			result = statement.executeQuery(sql);
			close();
			
		}	
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
                Animais anii = new Animais();
		try{
			while(result.next()){
				//System.out.println("\n-CPF:"+ result.getInt("cpf") + "\n-Nome:"+result.getString("nome")+ "\n-Idade:"+result.getInt("idade")+ "\n-Sexo:"+result.getString("sexo"));       
                                
                                
                                anii.setCodan(result.getInt("cod_an"));
                                anii.setNome(result.getString("nome"));
                                anii.setIdade(result.getInt("idade"));
                                anii.setRaca(result.getString("raça"));
                                anii.setPeso(result.getInt("peso"));
                                
                        }
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);	
		}
                return anii;
                                
    	}*/
        public static void setResult(String sql){
		ResultSet result = null;
		try{
			getConect();
			result = statement.executeQuery(sql);

		}
		catch(SQLException erro){
			System.out.println("\n\nErro de SQL BDConecta "+erro+"! -- de SQL em BDConecta");
			System.exit(0);
		}
		try{
		    //Mostra lt = new Mostra();
                   Mostra x = new Mostra();
                   x.setVisible(true);
                   x.fbi(result);
                    
                    
                    //lt.fbi(result);
		}
		catch(SQLException errSql){
			System.out.println("Error de SQL "+errSql+"! -- Erro na Consulta");
			System.exit(0);
		}
    	}
	
	//metodo para encerrar a conexao
	public static void close(){
		
		try{
			if(!connection.isClosed()) connection.close();
		}
		catch(SQLException erro){
			System.out.println("\n\nErro ao desconectar a: "+url+"! -- Erro de Desconexao!");
						
		}
	}

}

