from flask import Flask, request, Response
app = Flask(__name__)



@app.route('/skiers/<resortID>/seasons/<seasonID>/days/<dayID>/skiers/<skierID>', methods=['GET', 'POST'])
def skier(resortID, seasonID, dayID, skierID):
    if request.method == "POST":
        return Response(status=201)
    elif request.method == "GET":
        return dayID
    return "Hello"

@app.route('/ping', methods=['GET', 'POST'])
def ping():
    if request.method == "POST":
        return "pong"
    else:
        return "pong"

@app.route('/resorts/<resortID>', methods = ['GET', 'POST'])
def resort(resortID):
    return resortID

if __name__ == "__main__":
    app.run(host="0.0.0.0",port=8080)