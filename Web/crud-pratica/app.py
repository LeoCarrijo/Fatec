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
    return redirect('/formulario_usuario', usuario=nome, opcao='cadastrado')

@app.route

@app.route("/formulario_cliente")
def formulario_cliente():
    return render_template('formulario_clientes.html')

app.run()