package br.com.dbccompany.myshop.storys;

public class RegisterStory {
    public static final String EPIC = "Gestão de Usuários";
    public static final String USER_STORY = "Cadastro de Novo Usuário";
    public static final String CE_REGISTER_01 = "Este este verifica se o sistema cria a conta do usuário com dados validos";
    public static final String CE_REGISTER_02 = "Este este verifica se o sistema impede a criação da conta do usuário sem inserir o primeiro nome";
    public static final String CE_REGISTER_03 = "Este este verifica se o sistema impede a criação da conta do usuário sem inserir o último nome";
    public static final String CE_REGISTER_04 = "Este este verifica se o sistema impede a criação da conta do usuário com email inválido";
    public static final String CE_REGISTER_05 = "Este este verifica se o sistema impede a criação da conta do usuário com senha menor que 5 caracteres";
}
