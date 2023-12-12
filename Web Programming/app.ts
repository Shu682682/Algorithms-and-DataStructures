class Information {
    private _author: string;
    private _time: string;

    constructor(author: string, time: string) {
        this._author = author;
        this._time = time;
    }

    get author() {
        return this._author;
    }

    set author(value: string) {
        this._author = value;
    }

    get time() {
        return this._time;
    }

    set time(value: string) {
        this._time = value;
    }

    public printInfo() {
        // 创建新的段落元素
        const p = document.createElement('p');
        const info = `This website create by ${this._author}, in ${this._time}.`;
        p.innerHTML = info;
       
        document.body.appendChild(p);
    }
}


const sayHi = (name: string) => {
    alert(`Hello, my name is ${name}!`);
};


let myInformation = new Information("Sofia", "Dec 2023");


window.onload = () => {
    const sayHiButton = document.getElementById("Say Hi");
    const printInfoButton = document.getElementById("Print Information");

    if (sayHiButton) {
        sayHiButton.onclick = () => sayHi("Sofia");
    }

    if (printInfoButton) {
        printInfoButton.onclick = () => myInformation.printInfo();
    }
};
