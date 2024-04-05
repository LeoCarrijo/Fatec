from flask import Flask, render_template, request

app = Flask(__name__)

# @app.route('/')
# def root():
#     return render_template('index.html', var_teste="teste")

@app.route('/')
def root():
    return render_template('tabuada.html')

@app.route('/calcula_tabuada', methods=['POST'])
def calcular():
    numero = int(request.form['numero'])
    res = {"tabuada_do" : numero, "valores" : []}
    for i in range(0, 11):
        r = numero * i
        res['valores'].append(r)
    return render_template('tabuada.html', resultado = res)

app.run(port=80)