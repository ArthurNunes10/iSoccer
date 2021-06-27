/*OBSERVAÇÃO
IDE usada foi o Eclipse
JDK utilizado foi o JDK 13
login = admin
senha = admin
Nos exemplos em que forem solicidadas informações, digitar como o modelo sugerido. Como por exemplo: Adimplente/ Inadimplente ou Disponível/Indisponível
*/
package isoccer;

import java.util.Scanner;

public class ISoccer {

    static Scanner input;
    //informacoes dos funcionarios
   	static String[] nome_funcionario, funcao_funcionario, email_funcionario, cpf_funcionario, salario_funcionario, telefone_funcionario, crm, habilitacao, tipo_jogador, disponibilidade_jogador;
   	//informacoes dos socio torcedores
   	static String[] nome_torcedor, email_torcedor, cpf_torcedor, estado_pagamento, endereco_torcedor;
   	static String[][] valor_contribuicao;
   	//informacoes dos recursos
   	static String[] id_onibus, placa_onibus, tipo_onibus, disponibilidade_onibus, cp_onibus, manutencao_onibus, nome_estadio, disponibilidade_estadio, estadio_cp, estadio_bn, estadio_lan, nome_ct, dorm_ct, disp_ct;
	static int onibus_qnt = 0, estadio_qnt = 0, socio_qnt =  0, qnt_centro = 0;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);

		String login;
		String password;
		int contador = 1, opcao, flag = 0;

		nome_funcionario = new String[100];
		funcao_funcionario = new String[100];
		email_funcionario = new String[100];
		cpf_funcionario = new String[100];
		salario_funcionario = new String[100];
		telefone_funcionario = new String[100];
		crm = new String[100];
		habilitacao = new String[100];
		tipo_jogador = new String[100];
		disponibilidade_jogador = new String[100];
		nome_torcedor = new String[100];
		email_torcedor = new String[100];
		cpf_torcedor = new String[100];
		valor_contribuicao = new String[100][3];
		estado_pagamento = new String[100];
		endereco_torcedor = new String[100];
		placa_onibus = new String[100];
		tipo_onibus = new String[100];
		cp_onibus = new String[100];
		manutencao_onibus = new String[100];
		disponibilidade_onibus = new String[100];
		id_onibus = new String[100];
		nome_estadio = new String[100];
		estadio_cp = new String[100];
		estadio_bn = new String[100];
		estadio_lan = new String[100];
		disponibilidade_estadio = new String[100];
		nome_ct = new String[100];
		dorm_ct = new String[100];
		disp_ct = new String[100];

		while(true){
			if(flag==0){
				System.out.println("Bem vindo ao Sistema de Gerenciamento do Clube (SGC)");
				System.out.print("->Login:");
				login = input.nextLine();
				System.out.print("->Senha:");
				password = input.nextLine();
				flag = 1;

				if (!login.equals("admin") || !password.equals("admin")) {
					while((!login.equals("admin") || !password.equals("admin")) && (contador<3)){
						System.out.println("Login e Senha inválidos, por favor digite novamente:");
						contador++;
						System.out.printf("(Tentativa %d de 3)\n",contador);
						System.out.print("->Login:"); 
						login = input.nextLine();
						System.out.print("->Senha:");
						password = input.nextLine();
					}//while(!login.equals("admin") || !password.equals("admin") && contador<=3);

					if(!login.equals("admin") || !password.equals("admin") && contador>=3){
						System.out.println("#Login e Senha inválidos, por motivos de segurança o programa será encerrado");
						break;
					} 
				}
			}
			
			System.out.println("---\nEscolha uma das opções abaixo:");
			System.out.println("(1) Adicionar Funcionário");
			System.out.println("(2) Adicionar Sócio Torcedor");
			System.out.println("(3) Alterar estado de pagamento de Sócio Torcedor");
			System.out.println("(4) Atualizar valor de contribuição");
			System.out.println("(5) Gerenciar Recursos Físicos");
			System.out.println("(6) Relatório dos Funcionários");
			System.out.println("(7) Relatório dos Recursos Físicos");
			System.out.println("(8) Relatório Sócio Torcedor");
			System.out.println("(9) Relatório Geral");
			System.out.println("(0) Sair");
			System.out.print("->Opção:");

			opcao = input.nextInt(); input.nextLine();

			if(opcao == 0){
				System.out.println("Programa Encerrado");
				break;
			}
			switch(opcao){
				case 1:
				add_funcionario();
				break;

				case 2:
				add_socio();
				break;

				case 3:
				alterar_estado();
				break;

				case 4:
				atualizar_contribuicao();
				break;

				case 5:
				gerenciar_recursos();
				break;

				case 6:
				rel_fun();
				break;

				case 7:
				rel_rec();
				break;

				case 8:
				rel_soc();
				break;

				case 9:
				rel_geral();
				break;

				default:
                System.out.println("#Erro: Opção inválida.");
			}
		}
	input.close();	
	}
	//Metodos relativos ao cadastro dos funcionários
	static void add_funcionario(){
		int opcao;
		System.out.println("---\nEscolha a função do funcionário:");
		System.out.println("(1) Presidente");
		System.out.println("(2) Médico");
		System.out.println("(3) Técnico");
		System.out.println("(4) Preparador Físico");
		System.out.println("(5) Motorista");
		System.out.println("(6) Cozinheiro");
		System.out.println("(7) Advogado");
		System.out.println("(8) Jogador");
		System.out.print("->Opção:");
		opcao = input.nextInt(); input.nextLine();
		switch(opcao){
			case 1:
			add_presidente();
			break;

			case 2:
			add_medico();
			break;

			case 3:
			add_tecnico();
			break;

			case 4:
			add_preparador();
			break;

			case 5:
			add_motorista();
			break;

			case 6:
			add_cozinheiro();
			break;

			case 7:
			add_advogado();
			break;

			case 8:
			add_jogador();
			break;

			default:
            System.out.println("#Erro: Opção inválida.");
		}
	}	

	static void add_presidente(){
		String nome, email, cpf, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Presidente";
				break;
			}
		}
		System.out.println("Presidente adicionado com sucesso!!");
	}

	static void add_medico(){
		String nome, email, cpf, crm_med, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("CRM:");
		crm_med = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i] = cpf;
				crm[i] = crm_med;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Médico";
				break;
			}
		}
		System.out.println("Médico adicionado com sucesso!!");
	}

	static void add_tecnico(){
		String nome, email, cpf, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Técnico";
				break;
			}
		}
		System.out.println("Técnico adicionado com sucesso!!");
	}

	static void add_preparador(){
		String nome, email, cpf, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Preparador Físico";
				break;
			}
		}
		System.out.println("Preparador Físico adicionado com sucesso!!");
	}

	static void add_motorista(){
		String nome, email, cpf, habilitacao_motorista, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Habilitação:");
		habilitacao_motorista = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				habilitacao[i] = habilitacao_motorista;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Motorista";
				break;
			}
		}
		System.out.println("Motorista adicionado com sucesso!!");
	}

	static void add_cozinheiro(){
		String nome, email, cpf, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Cozinheiro";
				break;
			}
		}
		System.out.println("Cozinheiro adicionado com sucesso!!");
	}

	static void add_advogado(){
		String nome, email, cpf, salario, telefone;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				funcao_funcionario[i] = "Advogado";
				break;
			}
		}
		System.out.println("Advogado adicionado com sucesso!!");
	}

	static void add_jogador(){
		String nome, email, cpf, salario, telefone, posicao, disponibilidade;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Salário: R$");
		salario = input.nextLine();
		System.out.print("Telefone:");
		telefone = input.nextLine();
		System.out.print("Posição do Jogador:");
		posicao = input.nextLine();
		System.out.print("Disponibilidade [Disponível/Indisponível]:");
		disponibilidade = input.nextLine();

		for (int i=0; i<nome_funcionario.length; i++) {
			if (nome_funcionario[i] == null) {
				nome_funcionario[i] = nome;
				email_funcionario[i] = email;
				cpf_funcionario[i]  = cpf;
				salario_funcionario[i] = salario;
				telefone_funcionario[i] = telefone;
				tipo_jogador[i] = posicao;
				disponibilidade_jogador[i] = disponibilidade; 
				funcao_funcionario[i] = "Jogador";
				break;
			}
		}
		System.out.println("Jogador adicionado com sucesso!!");
	}
	//Metodos relativos ao cadastro dos socios torcedores
	static void add_socio(){
		String nome, email, cpf, endereco, contribuição, estado;
		int tipo;
		System.out.print("---\nNome completo:");
		nome = input.nextLine();
		System.out.print("Email:");
		email = input.nextLine();
		System.out.print("CPF:");
		cpf = input.nextLine();
		System.out.print("Endereço:");
		endereco = input.nextLine();
		System.out.println("Tipo de Associação:");
		System.out.println("(0) Júnior:");
		System.out.println("(1) Sênior:");
		System.out.println("(2) Elite:");
		System.out.print("->Opção:");
		tipo = input.nextInt();input.nextLine();
		while((tipo!=0)&&(tipo!=1)&&(tipo!=2)){
			System.out.println("Opção errada, digite novamente:");
			System.out.print("->Opção:");
			tipo = input.nextInt();input.nextLine();
		}
		System.out.print("Valor de Contribuição:R$");
		contribuição = input.nextLine();
		System.out.print("Estado de Pagamento[Adimplente/Inadimplente]:");
		estado = input.nextLine();

		for (int i=0; i<nome_torcedor.length; i++) {
			if (nome_torcedor[i] == null) {
				nome_torcedor[i] = nome;
				email_torcedor[i] = email;
				cpf_torcedor[i]  = cpf;
				endereco_torcedor[i] = endereco;
				valor_contribuicao[i][tipo] = contribuição;
				estado_pagamento[i] = estado;
				socio_qnt++;
				break;
			}
		}
		System.out.println("Sócio Torcedor adicionado com sucesso!!");
	}

	static void alterar_estado(){
		String nome, opcao;
		int flag =0;
		if (socio_qnt==0) {
			System.out.println("O clube não possui sócios");
		}
		else{
			System.out.println("---\nNome Completo do Sócio:");
			nome = input.nextLine();
			for (int i= 0 ;i<nome_torcedor.length ; i++) {
				if (nome_torcedor[i]!=null) {
					if (nome.equals(nome_torcedor[i])) {
						flag=1;
						System.out.println("Estado atual de pagamento:"+ estado_pagamento[i]);
						System.out.println("Deseja mudar o atual estado de pagamento? [S/N]:");
						System.out.print("->Opção:");
						opcao = input.nextLine();
						if (opcao.equals("S")) {
							if (estado_pagamento[i].equals("Adimplente")) {
								estado_pagamento[i] = "Inadimplente";
								System.out.println("Alteração realizada com sucesso!");
							}
							else{
								estado_pagamento[i] = "Adimplente";
								System.out.println("Alteração realizada com sucesso!");
							}
						}
						else {
							System.out.println("Alteração Cancelada!");
						}
						break;
					}
				}
			}
			if(flag==0){
				System.out.println("Sócio não encontrado, por favor, verifique a digitação!");
			}
		}
	}
	static void atualizar_contribuicao(){
		String nome, opcao;
		int tipo;
		int flag =0;
		if (socio_qnt==0) {
			System.out.println("O clube não possui sócios");
		}
		else{
			System.out.println("---\nNome Completo do Sócio:");
			nome = input.nextLine();
			System.out.println("Digite o tipo de associação:");
			System.out.println("(0) Júnior:");
			System.out.println("(1) Sênior:");
			System.out.println("(2) Elite:");
			System.out.print("->Opção:");
			tipo = input.nextInt();input.nextLine();
			while((tipo<0)||(tipo>2)){
				System.out.println("Opção inválida, digite novamente:");
				System.out.print("->Opção:");
				tipo = input.nextInt();input.nextLine();
			}
			for (int i= 0 ;i<nome_torcedor.length ; i++) {
				if((nome_torcedor[i]!=null)&&(valor_contribuicao[i][tipo]!=null)){
					if (nome.equals(nome_torcedor[i])) {
						flag=1;
						System.out.println("Contribuição Atual: R$"+ valor_contribuicao[i][tipo]);
						System.out.println("Deseja mudar o atual valor de contribuição? [S/N]:");
						System.out.print("->Opção:");
						opcao = input.nextLine();
						if (opcao.equals("S")) {
							System.out.print("Digite o novo valor de contribuição:R$");
							valor_contribuicao[i][tipo] = input.nextLine();
							System.out.println("Alteração realizada com sucesso!");
						}
						else {
							System.out.println("Alteração Cancelada!");
						}
						break;
					}
				}
			}
			if(flag==0){
				System.out.println("Sócio não encontrado, por favor, verifique a digitação!");
			}
		}
	}
	//Metodos relativos aos recursos fisicos
	static void gerenciar_recursos(){
		int opcao;
		System.out.println("---\nEscolha uma opção:");
		System.out.println("(1) Adicionar ônibus");
		System.out.println("(2) Buscar ônibus");
		System.out.println("(3) Adicionar Estádio");
		System.out.println("(4) Buscar Estádio");
		System.out.println("(5) Adicionar Centro de Treinamento");
		System.out.println("(6) Buscar Centro de Treinamento");
		System.out.print("->Opção:");
		opcao = input.nextInt(); input.nextLine();

		switch(opcao){
			case 1:
			add_onibus();
			break;

			case 2:
			buscar_onibus();
			break;

			case 3:
			add_estadio();
			break;

			case 4:
			buscar_estadio();
			break;

			case 5:
			add_centro();
			break;

			case 6:
			buscar_centro();
			break;

			default:
			 System.out.println("#Erro: Opção inválida.");
		}
	}

	static void add_onibus(){
		String tipo, placa, capacidade, manutencao, nome, disponibilidade;
		//onibus, placa_onibus, tipo_onibus, cp_onibus, manutencao_onibus,
		System.out.print("---\nTipo de ônibus:");
		tipo = input.nextLine();
		System.out.print("Placa do ônibus:");
		placa = input.nextLine();
		System.out.print("Digite uma identificação [Ex:Ônibus01]:");
		nome = input.nextLine();
		System.out.print("Capacidade de passageiros:");
		capacidade = input.nextLine();
		System.out.print("Data da última manutenção [xx/xx/xx]:");
		manutencao = input.nextLine();
		System.out.print("Disponibilidade [Disponível/Indisponível]:");
		disponibilidade = input.nextLine();

		for (int i=0; i<placa_onibus.length; i++) {
			if (placa_onibus[i] == null) {
				placa_onibus[i] = placa;
				tipo_onibus[i] = tipo;
				cp_onibus[i]  = capacidade;
				manutencao_onibus[i] = manutencao;
				disponibilidade_onibus[i] = disponibilidade;
				id_onibus[i] = nome;
				onibus_qnt++;
				break;
			}
		}
		System.out.println("Ônibus adicionado com sucesso!!");
	}

	static void buscar_onibus(){
		if (onibus_qnt==0) {
			System.out.println("Ônibus indisponíveis!!");
		}
		else {
			//System.out.println("Ônibus disponíveis:");
			for (int i=0; i<disponibilidade_onibus.length; i++) {
				if (!(disponibilidade_onibus[i] == null)) {
					System.out.println("---\n"+id_onibus[i]+"......("+disponibilidade_onibus[i]+")......"+"Capacidade:"+" "+cp_onibus[i]);
				}
				else {
					break;
				}
			}
		}
	}
	static void add_estadio(){
		String nome, lanchonete, capacidade, banheiro, disponibilidade;
		
		System.out.print("---\nNome do Estádio:");
		nome = input.nextLine();
		System.out.print("Capacidade:");
		capacidade = input.nextLine();
		System.out.print("Número de lanchonetes:");
		lanchonete = input.nextLine();
		System.out.print("Número de banheiros:");
		banheiro = input.nextLine();
		System.out.print("Disponibilidade [Disponível/Indisponível]:");
		disponibilidade = input.nextLine();

		for (int i=0; i<nome_estadio.length; i++) {
			if (nome_estadio[i] == null) {
				nome_estadio[i] = nome;
				estadio_cp[i] = capacidade;
				estadio_lan[i]  = lanchonete;
				estadio_bn[i] = banheiro;
				disponibilidade_estadio[i] = disponibilidade;
				estadio_qnt++;
				break;
			}
		}
		System.out.println("Estádio adicionado com sucesso!!");
	}
	static void buscar_estadio(){
		if (estadio_qnt==0) {
			System.out.println("Estádios indisponíveis!!");
		}
		else {
			//System.out.println("Ônibus disponíveis:");
			for (int i=0; i<disponibilidade_estadio.length; i++) {
				if (!(disponibilidade_estadio[i] == null)) {
					System.out.println("---\n-->"+nome_estadio[i]+"......("+disponibilidade_estadio[i]+")");
					System.out.println("#Capacidade de Pessoas:"+" "+estadio_cp[i]);
					System.out.println("#Quantidade de Banheiros:"+" "+estadio_bn[i]);
					System.out.println("#Quantidade de Lanchonetes:"+" "+estadio_lan[i]);
				}
				else {
					break;
				}
			}
		}
	}
	static void add_centro(){
		String nome, dormitorio, disponibilidade;
		
		System.out.print("---\nIdentificação do Centro de Treinamento:");
		nome = input.nextLine();
		System.out.print("Quantidade de Dormitórios:");
		dormitorio = input.nextLine();
		System.out.print("Disponibilidade [Disponível/Indisponível]:");
		disponibilidade = input.nextLine();

		for (int i=0; i<nome_ct.length; i++) {
			if (nome_ct[i] == null) {
				nome_ct[i] = nome;
				dorm_ct[i] = dormitorio;
				disp_ct[i] = disponibilidade;
				qnt_centro++;
				break;
			}
		}
		System.out.println("Centro de Treinamento adicionado com sucesso!!");
	}

	static void buscar_centro(){
		if (qnt_centro==0) {
			System.out.println("Centros de Treinamento indisponíveis!!");
		}
		else {
			for (int i=0; i<nome_ct.length; i++) {
				if (!(nome_ct[i] == null)) {
					System.out.println("---\n"+nome_ct[i]+"......("+disp_ct[i]+")......"+"Quantidade de dormitorios:"+" "+dorm_ct[i]);
				}
				else {
					break;
				}
			}
		}
	}
	//Metodos dos relatorios
	static void rel_fun(){
		int opcao;
		System.out.println("---\nEscolha uma opção:");
		System.out.println("(1) Relatório do Time");
		System.out.println("(2) Exibir Disponibilidade de Jogadores");
		System.out.println("(3) Relatório Serviços Gerais");
		System.out.print("->Opção:");
		opcao = input.nextInt(); input.nextLine();
		switch(opcao){

			case 1:
			show_team();
			break;

			case 2:
		    show_player();
			break;

			case 3:
		    general_services();
			break;

			default:
			System.out.println("#Erro Opção Inválida");
		}
	}
	static void show_team(){
		int flag1=0, flag2=0;
		System.out.println("---\n         /=/=/RELATÓRIO DO TIME/=/=/\n");
		
		System.out.println("### TÉCNICO ###");
		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Técnico")) {
				flag1=1;
				System.out.println("---\nNome: "+nome_funcionario[i]);
				System.out.println("Email: "+email_funcionario[i]);
				System.out.println("CPF: "+cpf_funcionario[i]);
				System.out.println("Salário: R$"+salario_funcionario[i]);
				System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}
		if (flag1==0) {
			System.out.println("Técnico não alocado");
		}

		System.out.println("\n### JOGADORES ###");

		for (int i=0; i<funcao_funcionario.length; i++) {
			if(funcao_funcionario[i]==null) {
				continue;
			}
			else {
				if (funcao_funcionario[i].equals("Jogador")) {
					flag2=1;
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
					System.out.println("Tipo: "+tipo_jogador[i]);
					System.out.println("Disponibilidade: "+disponibilidade_jogador[i]);
				}
			}
		}

		if (flag2==0) {
			System.out.println("Jogadores não adicionados");
		}
		flag1=0; flag2=0;
	}

	static void show_player(){
		int flag = 0;
		System.out.println("---\n       /=/=/STATUS DOS JOGADORES/=/=/\n");
		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Jogador")) {
					flag =1;
				System.out.println("---\nNome: "+nome_funcionario[i]+"...."+tipo_jogador[i]+"....("+disponibilidade_jogador[i]+")");
				}
			}
		}	
		if (flag == 0) {
			System.out.println("Jogadores não adicionados");
		}
	}
	static void general_services(){
		int flag1=0, flag2=0, flag3=0, flag4=0, flag5=0, flag6=0;
		System.out.println("---\n      /=/=/RELATÓRIO SERVIÇOS GERAIS/=/=/");

		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Presidente")) {
					if(flag1==0) {
						System.out.println("---\n### PRESIDENTES ###");
						flag1 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}


		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Médico")) {
					if(flag2==0) {	
						System.out.println("---\n### MÉDICOS ###");
						flag2 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("CRM: "+crm[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}

		

		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Preparador Físico")) {
					if(flag3==0) {	
						System.out.println("---\n### PREPARADORES FÍSICOS ###");
						flag3 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}	

		

		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Advogado")) {
					if(flag4==0) {	
						System.out.println("---\n### ADVOGADOS ###");
						flag4 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}

		

		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Motorista")) {
					if(flag5==0) {	
						System.out.println("---\n### MOTORISTAS ###");
						flag5 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Habilitação: "+habilitacao[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}

		
		for (int i=0; i<funcao_funcionario.length; i++) {
			if (funcao_funcionario[i]==null) {
				continue;
			}
			else{
				if (funcao_funcionario[i].equals("Cozinheiro")) {
					if(flag6==0) {	
						System.out.println("---\n### COZINHEIROS ###");
						flag6 = 1;
					}
					System.out.println("---\nNome: "+nome_funcionario[i]);
					System.out.println("Email: "+email_funcionario[i]);
					System.out.println("CPF: "+cpf_funcionario[i]);
					System.out.println("Salário: R$"+salario_funcionario[i]);
					System.out.println("Telefone: "+telefone_funcionario[i]);
				}
			}
		}
		if (flag1==0 && flag2==0 && flag3 == 0 && flag4 == 0 && flag5 ==0 && flag6 == 0) {
			System.out.println("#Nenhum profissional alocado no momento!");
		}
		flag1 = 0; flag2=0; flag3=0; flag4=0; flag5=0; flag6=0;
	}

	static void rel_rec(){
		System.out.println("---\n      /=/=/RELATÓRIO DOS RECURSOS/=/=/");
		System.out.println("---\n### ÔNIBUS ###");

		if (onibus_qnt==0) {
			System.out.println("Ônibus não adicionados!!");
		}
		else {
			//System.out.println("Ônibus disponíveis:");
			for (int i=0; i<disponibilidade_onibus.length; i++) {
				if (!(disponibilidade_onibus[i] == null)) {
					System.out.println("---\n"+id_onibus[i]+"......("+disponibilidade_onibus[i]+")......"+"Capacidade:"+" "+cp_onibus[i]+"......Tipo: "+tipo_onibus[i]+"......Placa: "+placa_onibus[i]+"......Última Manutenção: "+manutencao_onibus[i]);
				}
				else {
					break;
				}
			}
		}
		
		System.out.println("---\n### ESTADIOS ###");
		if (estadio_qnt==0) {
			System.out.println("Estádios não adicionados!!");
		}
		else {
			//System.out.println("Ônibus disponíveis:");
			for (int i=0; i<disponibilidade_estadio.length; i++) {
				if (!(disponibilidade_estadio[i] == null)) {
					System.out.println("---\n-->"+nome_estadio[i]+"......("+disponibilidade_estadio[i]+")");
					System.out.println("#Capacidade de Pessoas:"+" "+estadio_cp[i]);
					System.out.println("#Quantidade de Banheiros:"+" "+estadio_bn[i]);
					System.out.println("#Quantidade de Lanchonetes:"+" "+estadio_lan[i]);
				}
				else {
					break;
				}
			}
		}

		System.out.println("---\n### CENTROS DE TREINAMENTO ###");
		if (qnt_centro==0) {
			System.out.println("Centros de Treinamento não foram adicionados!!");
		}
		else {
			for (int i=0; i<nome_ct.length; i++) {
				if (!(nome_ct[i] == null)) {
					System.out.println("---\n"+nome_ct[i]+"......("+disp_ct[i]+")......"+"Quantidade de dormitorios:"+" "+dorm_ct[i]);
				}
				else {
					break;
				}
			}
		}
	}

	static void rel_soc(){
		int qnt_adim=0;
		System.out.println("---\n      /=/=/RELATÓRIO DOS SÓCIOS/=/=/");
		if (socio_qnt==0) {
			System.out.println("O clube ainda não possui sócios adicionados");
		}
		else{
			for (int i=0;i<estado_pagamento.length ;i++) {
				if(estado_pagamento[i]==null){
					continue;
				}
				else{
					if (estado_pagamento[i].equals("Adimplente")) {
						qnt_adim++;
					}
				}
			}
			System.out.println("# O clube possui "+socio_qnt+" sócio(s), sendo "+qnt_adim+" Adimplentes e " + (socio_qnt-qnt_adim) + " Inadimplentes");
			
			for (int i=0; i<estado_pagamento.length ; i++) {
				if(estado_pagamento[i]!=null){
					System.out.println("---\nNome:  "+nome_torcedor[i]);
				 	System.out.println("Email: "+email_torcedor[i]);
				 	System.out.println("CPF: "+cpf_torcedor[i]);
				 	System.out.println("Endereço: "+endereco_torcedor[i]);
				 	
				 	for (int j=0; j < 3 ; j++) {
				 		if(valor_contribuicao[i][j] != null){
				 			System.out.println("Valor Contribuição: R$"+valor_contribuicao[i][j]);
				 			if(j==0) {
				 				System.out.println("Tipo de Associação: Júnior");
				 			}
				 			else if(j==1) {
				 				System.out.println("Tipo de Associação: Sênior");
				 			}
				 			else {
				 				System.out.println("Tipo de Associação: Elite");
				 			}
				 		}
				 	}
					System.out.println("Estado de Pagamento: "+estado_pagamento[i]);
				}
			}
		}
	}

	static void rel_geral(){
		System.out.println("---\n         /=/=/RELATÓRIO GERAL/=/=/");
		show_team();
		general_services();
		rel_rec();
		rel_soc();
	}
}	
