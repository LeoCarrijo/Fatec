from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def root():
    return render_template('index.html')

@app.route('/calculo2grau')
def calculo2grau():
    return render_template('calculo2grau.html')

@app.route('/fahrenheit')
def fahrenheit():
    return render_template('fahrenheit.html')

@app.route('/calc_2grau', methods=['POST'])
def calc_2grau():
    a = float(request.form['a'])
    b = float(request.form['b'])
    c = float(request.form['c'])
    delta = b ** 2 - 4 * a * c
    if delta < 0:
        x1 = "(Não real)" + str((-b + (delta ** 0.5)) / (2 * a))
        x2 = "(Não real)" + str((-b - (delta ** 0.5)) / (2 * a))
    else:
        x1 = (-b + (delta ** 0.5)) / (2 * a)
        x2 = (-b - (delta ** 0.5)) / (2 * a)
    return render_template('calc_2grau.html', var_x1 = x1, var_x2 = x2)

@app.route('/calc_fahrenheit', methods=['GET'])
def calc_fahrenheit():
    args = request.args
    celsius = float(args.get('celsius'))
    fahr = celsius * (9/5) + 32
    return render_template('calc_fahrenheit.html', var_temp = fahr)

app.run()