
from flask import Flask, request, render_template
import mysql.connector

app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/cadastrar_usuario', methods=['POST'])
def inserir_usuario():
    nome = request.form['nome']
    cpf = request.form['cpf']
    email = request.form['email']
    senha = request.form['senha']
    db = mysql.connector.connect(host='201.23.3.86',
                                 port=5000,
                                 user='usr_aluno',
                                 password='E$tud@_m@1$',
                                 database='aula_fatec')
    mycursor = db.cursor()
    query = "INSERT INTO leocarrijo_tbusuario (nome, cpf, email, senha) VALUES (%s, %s, %s, %s)"
    values = (nome, cpf, email, senha)
    mycursor.execute(query,values)
    db.commit()
    return 'gravou'

@app.route('/caduser')
def lista_user():
    db = mysql.connector.connect(host='201.23.3.86',
                                 port=5000,
                                 user='usr_aluno',
                                 password='E$tud@_m@1$',
                                 database='aula_fatec')
    mycursor = db.cursor()
    query = 'select nome, cpf, email from leocarrijo_tbusuario'
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('cadusuario.html', usuarios=resultado)

@app.route('/alterar_usuario/<user>')
def alterar_usuario(user):
    db = mysql.connector.connect(host='201.23.3.86',
                                 port=5000,
                                 user='usr_aluno',
                                 password='E$tud@_m@1$',
                                 database='aula_fatec')
    mycursor = db.cursor()
    query = 'select nome, cpf, email from leocarrijo_tbusuario where id = ' + user
    mycursor.execute(query)
    resultado = mycursor.fetchall()
    return render_template('cadusuario.html', usuarios=resultado)

app.run()
