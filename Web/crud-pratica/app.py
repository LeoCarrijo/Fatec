from flask import Flask, render_template, request, redirect, url_for
import mysql.connector

app = Flask(__name__)

db = mysql.connector.connect(host='127.0.0.1',
                                port=3306,
                                user='leocarrijo',
                                password='leocarrijo',
                                database='leocarrijo_database')
mycursor = db.cursor()

@app.route("/")
def root():
    return render_template('index.html')

@app.route("/formulario_usuario")
def formulario_usuario():
    return render_template('formulario_usuarios.html')
@app.route("/cadastrar_usuario", methods=['POST'])
def cadastrar_usuario():
    nome = request.form['nome']
    cpf = request.form['cpf'].replace('.', '').replace('-', '')
    email = request.form['email']
    senha = request.form['senha']
    query = "INSERT INTO usuarios (nome, cpf, email, senha) VALUES (%s,%s,%s,%s)"
    values = (nome, cpf, email, senha)
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
@app.route("/update_usuario/<user>")
def update_usuario(user):
    nome = request.form['nome']
    cpf = request.form['cpf'].replace('.', '').replace('-', '')
    email = request.form['email']
    senha = request.form['senha']
    query = "UPDATE usuarios SET nome = '" + nome + "', cpf = '"
    + cpf + "', email = '" + email + "', senha = '" + senha + "' WHERE cpf = '" + user + "'"
    mycursor.execute(query)
    db.commit()
    return redirect("/selecionar_usuarios")

@app.route("/formulario_cliente")
def formulario_cliente():
    return render_template('formulario_clientes.html')

app.run()