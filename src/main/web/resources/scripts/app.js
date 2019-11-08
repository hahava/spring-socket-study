let ws;
const url = "ws://localhost:8080/echo";

const tagElement = {
    "board": document.getElementById("board"),
    "create": {
        "row": function () {
            const tag = document.createElement("div");
            tag.setAttribute("class", "row");
            return tag;
        },
        "divId": function (id) {
            const tag = document.createElement("div");
            tag.setAttribute("class", "col-2 text-center");
            const p = document.createElement("p");
            p.textContent = id;
            tag.appendChild(p);
            return tag;
        },
        "divContent": function (content) {
            const tag = document.createElement("div");
            tag.setAttribute("class", "col-10 float-left");
            const p = document.createElement("p");
            p.textContent = content;
            tag.appendChild(p);
            return tag;
        }
    }
}

const connect = function () {
    ws = new WebSocket(url);

    ws.onopen = function (event) {
        console.log(event.type)
    };

    ws.onmessage = function (event) {
        console.log(event);
        log(event.data);
    };

    ws.onclose = function (event) {
        const closingMent = "----------connections is closed....-------------";
        log(closingMent);
    };
};

const echo = function () {
    if (ws != null) {
        let data = {
            "message": document.getElementById('message').value,
            "id": document.getElementById('id').value
        };
        ws.send(JSON.stringify(data));
    } else {
        connect();
    }
};

const log = function (message) {
    let board = document.getElementById('board');
    let data = JSON.parse(message);

    const row = tagElement.create.row();
    const divId = tagElement.create.divId(data.id);
    const divContent = tagElement.create.divContent(data.message);

    row.appendChild(divId);
    row.appendChild(divContent);
    board.appendChild(row);

};