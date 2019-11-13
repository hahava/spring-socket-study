let ws;
const url = "ws://localhost:8080/echo-endpoint";

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

const connect = () => {
    // handshake를 위한 메서드
    ws = webstomp.client(url);
    ws.connect({}, () => {
        ws.subscribe('/topic/echo', (message) => {
            log(message.body);
        })
    })
};

const echo = () => {
    if (ws != null) {
        let data = {
            "message": document.getElementById('message').value,
            "id": document.getElementById('id').value
        };
        ws.send('/app/echo', JSON.stringify(data));
    } else {
        connect();
    }
};

const log = (message) => {
    let board = document.getElementById('board');
    let data = JSON.parse(message);

    const row = tagElement.create.row();
    const divId = tagElement.create.divId(data.id);
    const divContent = tagElement.create.divContent(data.message);

    row.appendChild(divId);
    row.appendChild(divContent);
    board.appendChild(row);
};