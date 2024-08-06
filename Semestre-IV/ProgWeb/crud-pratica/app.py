from flask import Flask, render_template, request, redirect, url_for
import mysql.connector

app = Flask(__name__)

db = mysql.connector.connect(host='127.0.0.1',
                                port=3306,
                                user='leocarrijo',
                                password='leocarrijo',
                                database='leocarrijo_database')
mycursor = db.cursor()

def pegar_dados_formulario_usuario():
    nome = request.form['nome']
    cpf = request.form['cpf'].replace('.', '').replace('-', '')
    email = request.form['email']
    senha = request.form['senha']
    return[nome, cpf, email, senha]

def pegar_dados_formulario_cliente():
    nome = request.form['nome']
    data_nascimento = request.form['data_nascimento']
    cpf = request.form['cpf'].replace('.', '').replace('-', '')
    rg = request.form['rg'].replace('.', '').replace('-', '')
    email = request.form['email']
    endereco = request.form['endereco']
    bairro = request.form['bairro']
    cidade = request.form['cidade']
    uf = request.form['uf']
    cep = request.form['cep'].replace('-', '')
    return [nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep]

@app.route("/")
def root():
    return render_template('index.html')

@app.route("/formulario_usuario")
def formulario_usuario():
    query = 'SELECT nome, cpf, email FROM usuarios'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_usuarios.html', acao='listar', opcao='', usuarios=resultado)
@app.route("/cadastrar_usuario", methods=['POST'])
def cadastrar_usuario():
    dados = pegar_dados_formulario_usuario()
    query = "INSERT INTO usuarios (nome, cpf, email, senha) VALUES (%s,%s,%s,%s)"
    values = (dados[0], dados[1], dados[2], dados[3])
    mycursor.execute(query, values)
    db.commit()
    return redirect('/selecionar_usuarios')

@app.route("/selecionar_usuarios")
def selecionar_usuarios():
    query = 'SELECT nome, cpf, email FROM usuarios'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_usuarios.html', acao='listar', opcao='cadastrado', usuarios=resultado)

@app.route("/alterar_usuario/<user>")
def alterar_usuario(user):
    query = 'SELECT nome, cpf, email FROM usuarios WHERE cpf = ' + user
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_usuarios.html', usuarios=resultado, opcao='alterar', acao='listar')
@app.route("/update_usuario/<user>", methods=['POST'])
def update_usuario(user):
    dados = pegar_dados_formulario_usuario()
    query = "UPDATE usuarios SET nome = '" + dados[0] + "', cpf = '" + dados[1] + "', email = '" + dados[2] + "', senha = '" + dados[3] + "' WHERE cpf = '" + dados[1] + "'"
    mycursor.execute(query)
    db.commit()
    return redirect("/selecionar_usuarios")

@app.route("/deletar_usuario/<user>", methods=['POST', 'GET'])
def deletar_usuario(user):
    query = "DELETE FROM usuarios WHERE cpf = '" + user + "'"
    mycursor.execute(query)
    db.commit()
    query = 'SELECT nome, cpf, email FROM usuarios'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template("formulario_usuarios.html", acao = 'listar', opcao = 'deletado', usuarios = resultado)

#---------------------------|FORMULARIO CLIENTE|---------------------------#

@app.route("/formulario_cliente")
def formulario_cliente():
    query = 'SELECT nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep FROM clientes'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_cliente.html', acao='listar', usuarios=resultado)
@app.route("/cadastrar_cliente", methods=['POST'])
def cadastrar_cliente():
    dados = pegar_dados_formulario_cliente()
    query = "INSERT INTO clientes (nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    values = (dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], dados[9])
    mycursor.execute(query, values)
    db.commit()
    return redirect('/selecionar_clientes')

@app.route("/selecionar_clientes")
def selecionar_clientes():
    query = 'SELECT nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep FROM clientes'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_cliente.html', acao='listar', opcao='cadastrado', usuarios=resultado)

@app.route("/deletar_cliente/<user>", methods=['POST', 'GET'])
def deletar_cliente(user):
    query = "DELETE FROM clientes WHERE cpf = '" + user + "'"
    mycursor.execute(query)
    db.commit()
    query = 'SELECT nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep FROM clientes'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template("formulario_cliente.html", acao = 'listar', opcao = 'deletado', usuarios = resultado)

@app.route("/alterar_cliente/<user>")
def alterar_cliente(user):
    query = 'SELECT nome, data_nascimento, cpf, rg, email, endereco, bairro, cidade, uf, cep FROM clientes WHERE cpf = ' + user
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('formulario_cliente.html', usuarios=resultado, opcao='alterar', acao='listar')
@app.route("/update_cliente/<user>", methods=['POST'])
def update_cliente(user):
    dados = pegar_dados_formulario_cliente()
    query = "UPDATE clientes SET nome = '" + dados[0] + "', data_nascimento = '" + dados[1] + "', cpf = '" + dados[2] + "', rg = '" + dados[3] + "', email = '" + dados[4] + "', endereco = '" + dados[5] + "', bairro = '" + dados[6] + "', cidade = '" + dados[7] + "', uf = '" + dados[8] + "', cep = '" + dados[9] + "' WHERE cpf = '" + dados[2] + "'"
    mycursor.execute(query)
    db.commit()
    return redirect("/selecionar_clientes")

app.run()