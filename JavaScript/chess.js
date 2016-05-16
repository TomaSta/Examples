/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = prepareChessboard;
var emptyField = {
    figure: "empty",
    color: "empty"
};
var figures = {
    blackRook: '&#9820',
    blackBishop: '&#9821',
    blackKnight: '&#9822',
    whiteRook: '&#9814',
    whiteBishop: '&#9815',
    whiteKnight: '&#9816'
};
var chessboard = [];
var currentFigure = {
    figure: "empty",
    color: "empty"
};

var currentMode = "free";

function followMode(row, column) {
    switch (currentMode) {
        case "setting":
            setNewFigure(row, column);
            break;
        case "free":
            showMoves(row, column);
            break;

        case "moving":
            makeMove(row, column);
            break;
    }
}
function prepareChessboard() {
    var divContent = "";
    for (var row = 0; row < 8; row++) {
        chessboard[row] = [];
        for (var column = 0; column < 8; column++) {
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            divContent = divContent + '<div onclick=followMode(' + row + ',' + column + ') id="field' + row + column + '"></div>';
        }
    }
    document.getElementById("chessboard").innerHTML = divContent;
    setChessboardColors();
}

function setChessboardColors() {
    var counter = 0;
    for (var row = 0; row < 8; row++) {
        for (var column = 0; column < 8; column++) {
            if (counter % 2 == 0) {
                document.getElementById("field" + row + column).className = "white";
            } else {
                document.getElementById("field" + row + column).className = "black";
            }
            counter++;
        }
        counter--;
    }
}

function takeNewFigure(figure, color) {
    if (currentMode == "free") {
        currentMode = "setting";
        currentFigure.figure = figure;
        currentFigure.color = color;
    } else {
        if (currentMode == "setting") {
            currentFigure.figure = "empty";
            currentFigure.color = "empty";
            currentMode = "free";
        }
    }
}

function setNewFigure(row, column) {

    if (chessboard[row][column].figure === "empty") {
        chessboard[row][column].figure = JSON.parse(JSON.stringify(currentFigure.figure));
        chessboard[row][column].color = JSON.parse(JSON.stringify(currentFigure.color));
        document.getElementById("field" + row + column).innerHTML = figures[currentFigure.figure];
        currentFigure.figure = "empty";
        currentFigure.color = "empty";
        currentMode = "free";
    }
}

function showMoves(row, column) {
    currentFigure.figure = JSON.parse(JSON.stringify(chessboard[row][column].figure));
    currentFigure.color = JSON.parse(JSON.stringify(chessboard[row][column].color));
    switch (chessboard[row][column].figure) {
        case "blackBishop":
            bishopMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;

        case "whiteBishop":
            bishopMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;

        case "blackRook":
            rookMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;

        case "whiteRook":
            rookMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;

        case "blackKnight":
            knightMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;

        case "whiteKnight":
            knightMovement(row, column);
            chessboard[row][column] = JSON.parse(JSON.stringify(emptyField));
            document.getElementById("field" + row + column).innerHTML = "";
            currentMode = "moving";
            break;
    }
}
function rookMovement(row, column) {
    var tmpRow = row;
    var tmpColumn = column;

//checking column
    row++;
    while (row < 8) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row++;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

    row = tmpRow - 1;
    while (row >= 0) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row--;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

//checking row
    row = tmpRow;
    column++;
    while (column < 8) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            column++;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

    column = tmpColumn - 1;
    while (column >= 0) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            column--;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }
}

function bishopMovement(row, column) {
    var tmpRow = row;
    var tmpColumn = column;
//checking slant /
//up
    row--;
    column++;
    while (row >= 0 && column < 8) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row--;
            column++;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

//down
    row = tmpRow + 1;
    column = tmpColumn - 1;
    while (row < 8 && column >= 0) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row++;
            column--;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

//checking slant \
//up
    row = tmpRow - 1;
    column = tmpColumn - 1;
    while (row >= 0 && column >= 0) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row--;
            column--;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }

//down
    row = tmpRow + 1;
    column = tmpColumn + 1;
    while (row < 8 && column < 8) {
        if (chessboard[row][column].figure == "empty") {
            document.getElementById("field" + row + column).className = "green";
            row++;
            column++;
        } else {
            if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
            break;
        }
    }
}

function knightMovement(row, column) {
    var possibilities = [{row: row + 2, column: column - 1}, {row: row + 2, column: column + 1},
        {row: row - 2, column: column - 1}, {row: row - 2, column: column + 1},
        {row: row + 1, column: column - 2}, {row: row - 1, column: column - 2},
        {row: row + 1, column: column + 2}, {row: row - 1, column: column + 2}];

    possibilities.forEach(p => {
        row = p.row;
        column = p.column;
        if (row < 8 && row >= 0 && column < 8 && column >= 0) {
            if (chessboard[row][column].figure == "empty") {
                document.getElementById("field" + row + column).className = "green";
            } else if (chessboard[row][column].color != currentFigure.color) {
                document.getElementById("field" + row + column).className = "red";
            }
        }
    });
}

function makeMove(row, column) {
	var element = document.getElementById("field" + row + column);
    if (element.className == "green" || element.className == "red") {
        chessboard[row][column].figure = JSON.parse(JSON.stringify(currentFigure.figure));
        chessboard[row][column].color = JSON.parse(JSON.stringify(currentFigure.color));
        element.innerHTML = figures[currentFigure.figure];
        console.log(currentFigure.figure);
        currentMode = "free";
        currentFigure.figure = "empty";
        currentFigure.color = "empty";
        setChessboardColors();
    }
}