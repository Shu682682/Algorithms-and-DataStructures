var Information = /** @class */ (function () {
    function Information(author, time) {
        this._author= author;
        this._time = time;
    }
    Object.defineProperty(Information.prototype, "author", {
        get: function () {
            return this._author;
        },
        set: function (value) {
            this._author = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Information.prototype, "time", {
        get: function () {
            return this._time;
        },
        set: function (value) {
            this._time = value;
        },
        enumerable: false,
        configurable: true
    });
    Information.prototype.printInfo = function () {
        // 创建新的段落元素
        var p = document.createElement('p');
        var info = "This website is create by ".concat(this._author, " in ").concat(this._time, ".");
        p.innerHTML = info;
        document.body.appendChild(p);
    };
    return Information;
}());
var sayHi = function (name) {
    alert("Hello, my name is ".concat(name)+"!");
};
var myInformation = new Information("Sofia", "Dec 2023");
window.onload = function () {
    var sayHiButton = document.getElementById("Say Hi");
    var printInfoButton = document.getElementById("Print Information");
    if (sayHiButton) {
        sayHiButton.onclick = function () { return sayHi("Sofia"); };
    }
    if (printInfoButton) {
        printInfoButton.onclick = function () { return myInformation.printInfo(); };
    }
};
