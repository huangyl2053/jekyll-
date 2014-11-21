var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBB;
(function (DBB) {
    var Kiwarigaku_Design = (function (_super) {
        __extends(Kiwarigaku_Design, _super);
        function Kiwarigaku_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, Kiwarigaku_Design.myLayout, fieldName);
        }
        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[6].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[25].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[39].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[53].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[67].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[81].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[6].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[25].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[39].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[53].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[67].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuchoKiVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[81].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[7].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[26].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[40].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[54].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[68].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[82].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[7].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[26].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[40].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[54].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[68].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsuGakuVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[82].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[13].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[27].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[41].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[55].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[69].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[83].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[13].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[27].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[41].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[55].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[69].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[83].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofuGakuVisible14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[14].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[21].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[28].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[35].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[42].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[49].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[56].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[63].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[70].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[77].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[84].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[91].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[98].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[105].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[14].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[21].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[28].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[35].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[42].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[49].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[56].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[63].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[70].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[77].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[84].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[91].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[98].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKiVisible14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[105].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[15].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[22].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[29].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[36].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[43].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[50].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[57].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[64].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[71].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[78].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[85].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[92].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[99].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[106].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[15].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[22].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[29].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[36].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[43].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[50].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[57].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[64].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[71].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[78].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[85].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[92].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[99].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsuGakuVisible14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[106].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[23].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[30].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[37].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[44].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[51].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[58].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[65].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[72].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[79].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[86].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[93].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[100].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[107].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[23].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[30].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[37].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[44].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[51].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[58].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[65].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[72].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[79].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[86].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[93].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[100].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofuGakuVisible14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[107].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsugakuKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[110].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuKibetsugakuKeiVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[110].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofugakuKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[111].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "TokuNofugakuKeiVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[111].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsugakuKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[113].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoKibetsugakuKeiVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[113].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNoufugakuKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[114].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(Kiwarigaku_Design.prototype, "FuchoNofugakuKeiVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[114].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Kiwarigaku_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("TokuchoKiText1");
            Uz.JSControlUtil.registProperty("TokuchoKiText2");
            Uz.JSControlUtil.registProperty("TokuchoKiText3");
            Uz.JSControlUtil.registProperty("TokuchoKiText4");
            Uz.JSControlUtil.registProperty("TokuchoKiText5");
            Uz.JSControlUtil.registProperty("TokuchoKiText6");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible1");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible2");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible3");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible4");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible5");
            Uz.JSControlUtil.registProperty("TokuchoKiVisible6");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText1");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText2");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText3");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText4");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText5");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuText6");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible1");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible2");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible3");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible4");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible5");
            Uz.JSControlUtil.registProperty("TokuKibetsuGakuVisible6");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText1");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText2");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText3");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText4");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText5");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText6");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText7");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText8");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText9");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText10");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText11");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText12");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText13");
            Uz.JSControlUtil.registProperty("TokuNofuGakuText14");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible1");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible2");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible3");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible4");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible5");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible6");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible7");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible8");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible9");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible10");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible11");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible12");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible13");
            Uz.JSControlUtil.registProperty("TokuNofuGakuVisible14");
            Uz.JSControlUtil.registProperty("FuchoKiText1");
            Uz.JSControlUtil.registProperty("FuchoKiText2");
            Uz.JSControlUtil.registProperty("FuchoKiText3");
            Uz.JSControlUtil.registProperty("FuchoKiText4");
            Uz.JSControlUtil.registProperty("FuchoKiText5");
            Uz.JSControlUtil.registProperty("FuchoKiText6");
            Uz.JSControlUtil.registProperty("FuchoKiText7");
            Uz.JSControlUtil.registProperty("FuchoKiText8");
            Uz.JSControlUtil.registProperty("FuchoKiText9");
            Uz.JSControlUtil.registProperty("FuchoKiText10");
            Uz.JSControlUtil.registProperty("FuchoKiText11");
            Uz.JSControlUtil.registProperty("FuchoKiText12");
            Uz.JSControlUtil.registProperty("FuchoKiText13");
            Uz.JSControlUtil.registProperty("FuchoKiText14");
            Uz.JSControlUtil.registProperty("FuchoKiVisible1");
            Uz.JSControlUtil.registProperty("FuchoKiVisible2");
            Uz.JSControlUtil.registProperty("FuchoKiVisible3");
            Uz.JSControlUtil.registProperty("FuchoKiVisible4");
            Uz.JSControlUtil.registProperty("FuchoKiVisible5");
            Uz.JSControlUtil.registProperty("FuchoKiVisible6");
            Uz.JSControlUtil.registProperty("FuchoKiVisible7");
            Uz.JSControlUtil.registProperty("FuchoKiVisible8");
            Uz.JSControlUtil.registProperty("FuchoKiVisible9");
            Uz.JSControlUtil.registProperty("FuchoKiVisible10");
            Uz.JSControlUtil.registProperty("FuchoKiVisible11");
            Uz.JSControlUtil.registProperty("FuchoKiVisible12");
            Uz.JSControlUtil.registProperty("FuchoKiVisible13");
            Uz.JSControlUtil.registProperty("FuchoKiVisible14");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText1");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText2");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText3");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText4");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText5");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText6");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText7");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText8");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText9");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText10");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText11");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText12");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText13");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuText14");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible1");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible2");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible3");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible4");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible5");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible6");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible7");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible8");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible9");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible10");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible11");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible12");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible13");
            Uz.JSControlUtil.registProperty("FuchoKibetsuGakuVisible14");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText1");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText2");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText3");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText4");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText5");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText6");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText7");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText8");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText9");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText10");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText11");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText12");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText13");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuText14");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible1");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible2");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible3");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible4");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible5");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible6");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible7");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible8");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible9");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible10");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible11");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible12");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible13");
            Uz.JSControlUtil.registProperty("FuchoNofuGakuVisible14");
            Uz.JSControlUtil.registProperty("TokuKibetsugakuKeiText");
            Uz.JSControlUtil.registProperty("TokuKibetsugakuKeiVisible");
            Uz.JSControlUtil.registProperty("TokuNofugakuKeiText");
            Uz.JSControlUtil.registProperty("TokuNofugakuKeiVisible");
            Uz.JSControlUtil.registProperty("FuchoKibetsugakuKeiText");
            Uz.JSControlUtil.registProperty("FuchoKibetsugakuKeiVisible");
            Uz.JSControlUtil.registProperty("FuchoNoufugakuKeiText");
            Uz.JSControlUtil.registProperty("FuchoNofugakuKeiVisible");
        };

        Kiwarigaku_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["TokuchoKiText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoKiVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[25]["fieldName"] + "_" + this.layout.items[0].items[0].items[25].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoKiVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoKiVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[53]["fieldName"] + "_" + this.layout.items[0].items[0].items[53].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoKiVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[67]["fieldName"] + "_" + this.layout.items[0].items[0].items[67].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoKiVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsuGakuVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[26]["fieldName"] + "_" + this.layout.items[0].items[0].items[26].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsuGakuVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofuGakuText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[13]["fieldName"] + "_" + this.layout.items[0].items[0].items[13].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[27]["fieldName"] + "_" + this.layout.items[0].items[0].items[27].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[83]["fieldName"] + "_" + this.layout.items[0].items[0].items[83].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofuGakuVisible14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[14]["fieldName"] + "_" + this.layout.items[0].items[0].items[14].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[63]["fieldName"] + "_" + this.layout.items[0].items[0].items[63].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[84]["fieldName"] + "_" + this.layout.items[0].items[0].items[84].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKiVisible14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[105]["fieldName"] + "_" + this.layout.items[0].items[0].items[105].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsuGakuVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[15]["fieldName"] + "_" + this.layout.items[0].items[0].items[15].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[43]["fieldName"] + "_" + this.layout.items[0].items[0].items[43].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[64]["fieldName"] + "_" + this.layout.items[0].items[0].items[64].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[85]["fieldName"] + "_" + this.layout.items[0].items[0].items[85].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsuGakuVisible14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[106]["fieldName"] + "_" + this.layout.items[0].items[0].items[106].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofuGakuVisible1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[23]["fieldName"] + "_" + this.layout.items[0].items[0].items[23].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[44]["fieldName"] + "_" + this.layout.items[0].items[0].items[44].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[65]["fieldName"] + "_" + this.layout.items[0].items[0].items[65].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[86]["fieldName"] + "_" + this.layout.items[0].items[0].items[86].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[93]["fieldName"] + "_" + this.layout.items[0].items[0].items[93].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNofuGakuVisible14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[107]["fieldName"] + "_" + this.layout.items[0].items[0].items[107].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuKibetsugakuKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuKibetsugakuKeiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuNofugakuKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuNofugakuKeiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoKibetsugakuKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKibetsugakuKeiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[113]["fieldName"] + "_" + this.layout.items[0].items[0].items[113].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoNoufugakuKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoNofugakuKeiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];

            return editablePropertyInfo;
        };
        Kiwarigaku_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "Kiwarigaku",
                    "items": [
                        {
                            "fieldName": "tblKiwariGaku",
                            "items": [
                                {
                                    "fieldName": "celKiwarigaku1",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku1",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku2",
                                    "items": [
                                        {
                                            "fieldName": "lblTokucho",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokucho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "特別徴収",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku2",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku4",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku4",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku5",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku5",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku6",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "65px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "期別額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku6",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku7",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "4月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku7",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku8",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku8",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku9",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku9",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku3",
                                    "items": [
                                        {
                                            "fieldName": "lblFucho",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFucho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "普通徴収",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku3",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku10",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "65px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "納付額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku10",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku11",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku12",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "65px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "期別額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku13",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "65px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "納付額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku13",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku17",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku17",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku18",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku18",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku19",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku19",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku20",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku20",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku24",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "5月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku24",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku25",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku25",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku26",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku26",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku27",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku27",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku28",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku28",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku29",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku29",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku30",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku30",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku34",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "6月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku34",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku35",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "2期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku35",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku36",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku36",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku37",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku37",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku38",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku38",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku39",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku39",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku40",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku40",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku44",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "7月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku44",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku45",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku45",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku46",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku46",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku47",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku47",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku48",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku48",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku49",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku49",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku50",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku50",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku54",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "8月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku54",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku55",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "3期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku55",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku56",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku56",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku57",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku57",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku58",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku58",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku59",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku59",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku60",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku60",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku64",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "9月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku64",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku65",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku65",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku66",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku66",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku67",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku67",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku68",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku68",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku69",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku69",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku70",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku70",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku74",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki7",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "10月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku74",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku75",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "4期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku75",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku76",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku76",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku77",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku77",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku78",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi7",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku78",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku79",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku7",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku79",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku80",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku7",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku80",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku84",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki8",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "11月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku84",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku85",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku85",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku86",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku86",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku87",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku87",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku88",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi8",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku88",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku89",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku8",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku89",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku90",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku8",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku90",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku94",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki9",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "12月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku94",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku95",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "5期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku95",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku96",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku96",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku97",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku97",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku98",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi9",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku98",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku99",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku9",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku99",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku100",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku9",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku100",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku104",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki10",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku104",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku105",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku105",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku106",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku106",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku107",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku107",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku108",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi10",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku108",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku109",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku10",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku109",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku110",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku10",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku110",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku114",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki11",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "2月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku114",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku115",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuchoKi6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "6期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku115",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku116",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGaku6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGaku6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku116",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku117",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGaku6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGaku6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku117",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku118",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi11",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku118",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku119",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku11",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku119",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku120",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku11",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku120",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku124",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki12",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "3月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku124",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku125",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku125",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku126",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku126",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku127",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku127",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku128",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi12",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku128",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku129",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku12",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku129",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku130",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku12",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku130",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku134",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki13",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "4月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku134",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku135",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku135",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku136",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku136",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku137",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku137",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku138",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi13",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "1期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku138",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku139",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku13",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku139",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku140",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku13",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku140",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku144",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki14",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "5月",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku144",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku145",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku145",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku146",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku146",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku147",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku147",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku148",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "40px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKi14",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "14期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku148",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku149",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGaku14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGaku14",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku149",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku150",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGaku14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGaku14",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku150",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R16C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku154",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki15",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTsuki15",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "合計",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku154",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku155",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku155",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku156",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuKibetsuGakuKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuKibetsuGakuKei",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku156",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku157",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuNofuGakuKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokuNofuGakuKei",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku157",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku158",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku158",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku159",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKibetsuGakuKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoKibetsuGakuKei",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku159",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku160",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoNofuGakuKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60px",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFuchoNofuGakuKei",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celKiwarigaku160",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R17C7"
                                }
                            ],
                            "controlType": "TablePanel",
                            "width": "XS",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "tblKiwariGaku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:11pt\">\n  <tbody>\n    <tr bgcolor=#d7ebf6><td id='R1C1'></td><td colspan=\"3\" id='R1C2'></td><td colspan=\"3\"  id='R1C6'></td></tr>\n    <tr bgcolor=#d7ebf6 ><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td><td id='R2C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R3C1'></td><td bgcolor=#d7ebf6 id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td bgcolor=#d7ebf6 id='R3C5'></td><td id='R3C6'></td><td id='R3C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R4C1'></td><td bgcolor=#d7ebf6 id='R4C2'></td><td id='R4C3'></td><td id='R4C4'></td><td bgcolor=#d7ebf6 id='R4C5'></td><td id='R4C6'></td><td id='R4C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R5C1'></td><td bgcolor=#d7ebf6 id='R5C2'></td><td id='R5C3'></td><td id='R5C4'></td><td bgcolor=#d7ebf6 id='R5C5'></td><td id='R5C6'></td><td id='R5C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R6C1'></td><td bgcolor=#d7ebf6 id='R6C2'></td><td id='R6C3'></td><td id='R6C4'></td><td bgcolor=#d7ebf6 id='R6C5'></td><td id='R6C6'></td><td id='R6C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R7C1'></td><td bgcolor=#d7ebf6 id='R7C2'></td><td id='R7C3'></td><td id='R7C4'></td><td bgcolor=#d7ebf6 id='R7C5'></td><td id='R7C6'></td><td id='R7C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R8C1'></td><td bgcolor=#d7ebf6 id='R8C2'></td><td id='R8C3'></td><td id='R8C4'></td><td bgcolor=#d7ebf6 id='R8C5'></td><td id='R8C6'></td><td id='R8C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R9C1'></td><td bgcolor=#d7ebf6 id='R9C2'></td><td id='R9C3'></td><td id='R9C4'></td><td bgcolor=#d7ebf6 id='R9C5'></td><td id='R9C6'></td><td id='R9C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R10C1'></td><td bgcolor=#d7ebf6 id='R10C2'></td><td id='R10C3'></td><td id='R10C4'></td><td bgcolor=#d7ebf6 id='R10C5'></td><td id='R10C6'></td><td id='R10C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R11C1'></td><td bgcolor=#d7ebf6 id='R11C2'></td><td id='R11C3'></td><td id='R11C4'></td><td bgcolor=#d7ebf6 id='R11C5'></td><td id='R11C6'></td><td id='R11C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R12C1'></td><td bgcolor=#d7ebf6 id='R12C2'></td><td id='R12C3'></td><td id='R12C4'></td><td bgcolor=#d7ebf6 id='R12C5'></td><td id='R12C6'></td><td id='R12C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R13C1'></td><td bgcolor=#d7ebf6 id='R13C2'></td><td id='R13C3'></td><td id='R13C4'></td><td bgcolor=#d7ebf6 id='R13C5'></td><td id='R13C6'></td><td id='R13C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R14C1'></td><td bgcolor=#d7ebf6 id='R14C2'></td><td id='R14C3'></td><td id='R14C4'></td><td bgcolor=#d7ebf6 id='R14C5'></td><td id='R14C6'></td><td id='R14C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R15C1'></td><td bgcolor=#d7ebf6 id='R15C2'></td><td id='R15C3'></td><td id='R15C4'></td><td bgcolor=#d7ebf6 id='R15C5'></td><td id='R15C6'></td><td id='R15C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R16C1'></td><td bgcolor=#d7ebf6 id='R16C2'></td><td id='R16C3'></td><td id='R16C4'></td><td bgcolor=#d7ebf6 id='R16C5'></td><td id='R16C6'></td><td id='R16C7'></td></tr>\n    <tr><td bgcolor=#d7ebf6 id='R17C1'></td><td bgcolor=#d7ebf6 id='R17C2'></td><td id='R17C3'></td><td id='R17C4'></td><td bgcolor=#d7ebf6 id='R17C5'></td><td id='R17C6'></td><td id='R17C7'></td></tr>\n  </tbody>\n</table>\n"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G2",
                    "visible": true,
                    "displayNone": false,
                    "disabled": false,
                    "accessKey": "",
                    "nextFocusFieldName": "",
                    "wrap": false,
                    "dependencies": [],
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "0em",
                    "marginRight": "0em",
                    "selectControlID": "Kiwarigaku",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0em",
                    "marginBottom": "0em",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "Kiwarigaku"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": true,
                    "backgroundColor": 0,
                    "widthAuto": true,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "canPost": true
                }
            ],
            "controlType": "CommonChildDiv",
            "width": "XS",
            "visible": true,
            "displayNone": false,
            "disabled": false,
            "accessKey": "",
            "nextFocusFieldName": "",
            "wrap": false,
            "dependencies": [],
            "float": 0,
            "toolTip": "",
            "authorityMode": 0,
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBB",
            "controlName": "Kiwarigaku",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "lblTokuchoKi1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText1"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText2"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText3"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText4"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText5"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoKiText6"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible1"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible2"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible3"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible4"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible5"
                },
                {
                    "publicChildFieldName": "lblTokuchoKi6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoKiVisible6"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText1"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText2"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText3"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText4"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText5"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsuGakuText6"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible1"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible2"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible3"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible4"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible5"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGaku6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsuGakuVisible6"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText1"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText2"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText3"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText4"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText5"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofuGakuText6"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText7"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText8"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText9"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText10"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText11"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText12"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText13"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuText14"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible1"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible2"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible3"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible4"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible5"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGaku6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible6"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible7"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible8"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible9"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible10"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible11"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible12"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible13"
                },
                {
                    "publicChildFieldName": "Kiwarigaku",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofuGakuVisible14"
                },
                {
                    "publicChildFieldName": "lblFuchoKi1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText1"
                },
                {
                    "publicChildFieldName": "lblFuchoKi2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText2"
                },
                {
                    "publicChildFieldName": "lblFuchoKi3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText3"
                },
                {
                    "publicChildFieldName": "lblFuchoKi4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText4"
                },
                {
                    "publicChildFieldName": "lblFuchoKi5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText5"
                },
                {
                    "publicChildFieldName": "lblFuchoKi6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText6"
                },
                {
                    "publicChildFieldName": "lblFuchoKi7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText7"
                },
                {
                    "publicChildFieldName": "lblFuchoKi8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText8"
                },
                {
                    "publicChildFieldName": "lblFuchoKi9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText9"
                },
                {
                    "publicChildFieldName": "lblFuchoKi10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText10"
                },
                {
                    "publicChildFieldName": "lblFuchoKi11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText11"
                },
                {
                    "publicChildFieldName": "lblFuchoKi12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText12"
                },
                {
                    "publicChildFieldName": "lblFuchoKi13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText13"
                },
                {
                    "publicChildFieldName": "lblFuchoKi14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKiText14"
                },
                {
                    "publicChildFieldName": "lblFuchoKi1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible1"
                },
                {
                    "publicChildFieldName": "lblFuchoKi2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible2"
                },
                {
                    "publicChildFieldName": "lblFuchoKi3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible3"
                },
                {
                    "publicChildFieldName": "lblFuchoKi4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible4"
                },
                {
                    "publicChildFieldName": "lblFuchoKi5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible5"
                },
                {
                    "publicChildFieldName": "lblFuchoKi6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible6"
                },
                {
                    "publicChildFieldName": "lblFuchoKi7",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible7"
                },
                {
                    "publicChildFieldName": "lblFuchoKi8",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible8"
                },
                {
                    "publicChildFieldName": "lblFuchoKi9",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible9"
                },
                {
                    "publicChildFieldName": "lblFuchoKi10",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible10"
                },
                {
                    "publicChildFieldName": "lblFuchoKi11",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible11"
                },
                {
                    "publicChildFieldName": "lblFuchoKi12",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible12"
                },
                {
                    "publicChildFieldName": "lblFuchoKi13",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible13"
                },
                {
                    "publicChildFieldName": "lblFuchoKi14",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKiVisible14"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText1"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText2"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText3"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText4"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText5"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText6"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText7"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText8"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText9"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText10"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText11"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText12"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText13"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsuGakuText14"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible1"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible2"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible3"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible4"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible5"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible6"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku7",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible7"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku8",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible8"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku9",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible9"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku10",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible10"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku11",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible11"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku12",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible12"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku13",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible13"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGaku14",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsuGakuVisible14"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText1"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText2"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText3"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText4"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText5"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText6"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText7"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText8"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText9"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText10"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText11"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText12"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText13"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNofuGakuText14"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible1"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible2"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible3"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible4"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible5"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible6"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku7",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible7"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku8",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible8"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku9",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible9"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku10",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible10"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku11",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible11"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku12",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible12"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku13",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible13"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGaku14",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofuGakuVisible14"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGakuKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuKibetsugakuKeiText"
                },
                {
                    "publicChildFieldName": "lblTokuKibetsuGakuKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuKibetsugakuKeiVisible"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGakuKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuNofugakuKeiText"
                },
                {
                    "publicChildFieldName": "lblTokuNofuGakuKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuNofugakuKeiVisible"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGakuKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoKibetsugakuKeiText"
                },
                {
                    "publicChildFieldName": "lblFuchoKibetsuGakuKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoKibetsugakuKeiVisible"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGakuKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoNoufugakuKeiText"
                },
                {
                    "publicChildFieldName": "lblFuchoNofuGakuKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoNofugakuKeiVisible"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return Kiwarigaku_Design;
    })(Uz.CommonChildDiv);
    DBB.Kiwarigaku_Design = Kiwarigaku_Design;

    (function (Kiwarigaku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        Kiwarigaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "Kiwarigaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.Kiwarigaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblKiwariGaku = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku"));
            };

            Controls.prototype.celKiwarigaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku1"));
            };

            Controls.prototype.celKiwarigaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku2"));
            };

            Controls.prototype.lblTokucho = function () {
                return new UZA.Label(this.convFiledName("lblTokucho"));
            };

            Controls.prototype.celKiwarigaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku4"));
            };

            Controls.prototype.lblTsuki = function () {
                return new UZA.Label(this.convFiledName("lblTsuki"));
            };

            Controls.prototype.celKiwarigaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku5"));
            };

            Controls.prototype.lblTokuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi"));
            };

            Controls.prototype.celKiwarigaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku6"));
            };

            Controls.prototype.lblTokuKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku"));
            };

            Controls.prototype.celKiwarigaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku7"));
            };

            Controls.prototype.lblTsuki1 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki1"));
            };

            Controls.prototype.celKiwarigaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku8"));
            };

            Controls.prototype.lblTokuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi1"));
            };

            Controls.prototype.celKiwarigaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku9"));
            };

            Controls.prototype.lblTokuKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku1"));
            };

            Controls.prototype.celKiwarigaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku3"));
            };

            Controls.prototype.lblFucho = function () {
                return new UZA.Label(this.convFiledName("lblFucho"));
            };

            Controls.prototype.celKiwarigaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku10"));
            };

            Controls.prototype.lblTokuNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku"));
            };

            Controls.prototype.celKiwarigaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku11"));
            };

            Controls.prototype.lblFuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi"));
            };

            Controls.prototype.celKiwarigaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku12"));
            };

            Controls.prototype.lblFuchoKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku"));
            };

            Controls.prototype.celKiwarigaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku13"));
            };

            Controls.prototype.lblFuchoNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku"));
            };

            Controls.prototype.celKiwarigaku17 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku17"));
            };

            Controls.prototype.lblTokuNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku1"));
            };

            Controls.prototype.celKiwarigaku18 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku18"));
            };

            Controls.prototype.lblFuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi1"));
            };

            Controls.prototype.celKiwarigaku19 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku19"));
            };

            Controls.prototype.lblFuchoKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku1"));
            };

            Controls.prototype.celKiwarigaku20 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku20"));
            };

            Controls.prototype.lblFuchoNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku1"));
            };

            Controls.prototype.celKiwarigaku24 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku24"));
            };

            Controls.prototype.lblTsuki2 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki2"));
            };

            Controls.prototype.celKiwarigaku25 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku25"));
            };

            Controls.prototype.celKiwarigaku26 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku26"));
            };

            Controls.prototype.celKiwarigaku27 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku27"));
            };

            Controls.prototype.celKiwarigaku28 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku28"));
            };

            Controls.prototype.lblFuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi2"));
            };

            Controls.prototype.celKiwarigaku29 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku29"));
            };

            Controls.prototype.lblFuchoKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku2"));
            };

            Controls.prototype.celKiwarigaku30 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku30"));
            };

            Controls.prototype.lblFuchoNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku2"));
            };

            Controls.prototype.celKiwarigaku34 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku34"));
            };

            Controls.prototype.lblTsuki3 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki3"));
            };

            Controls.prototype.celKiwarigaku35 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku35"));
            };

            Controls.prototype.lblTokuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi2"));
            };

            Controls.prototype.celKiwarigaku36 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku36"));
            };

            Controls.prototype.lblTokuKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku2"));
            };

            Controls.prototype.celKiwarigaku37 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku37"));
            };

            Controls.prototype.lblTokuNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku2"));
            };

            Controls.prototype.celKiwarigaku38 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku38"));
            };

            Controls.prototype.lblFuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi3"));
            };

            Controls.prototype.celKiwarigaku39 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku39"));
            };

            Controls.prototype.lblFuchoKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku3"));
            };

            Controls.prototype.celKiwarigaku40 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku40"));
            };

            Controls.prototype.lblFuchoNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku3"));
            };

            Controls.prototype.celKiwarigaku44 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku44"));
            };

            Controls.prototype.lblTsuki4 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki4"));
            };

            Controls.prototype.celKiwarigaku45 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku45"));
            };

            Controls.prototype.celKiwarigaku46 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku46"));
            };

            Controls.prototype.celKiwarigaku47 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku47"));
            };

            Controls.prototype.celKiwarigaku48 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku48"));
            };

            Controls.prototype.lblFuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi4"));
            };

            Controls.prototype.celKiwarigaku49 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku49"));
            };

            Controls.prototype.lblFuchoKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku4"));
            };

            Controls.prototype.celKiwarigaku50 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku50"));
            };

            Controls.prototype.lblFuchoNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku4"));
            };

            Controls.prototype.celKiwarigaku54 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku54"));
            };

            Controls.prototype.lblTsuki5 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki5"));
            };

            Controls.prototype.celKiwarigaku55 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku55"));
            };

            Controls.prototype.lblTokuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi3"));
            };

            Controls.prototype.celKiwarigaku56 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku56"));
            };

            Controls.prototype.lblTokuKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku3"));
            };

            Controls.prototype.celKiwarigaku57 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku57"));
            };

            Controls.prototype.lblTokuNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku3"));
            };

            Controls.prototype.celKiwarigaku58 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku58"));
            };

            Controls.prototype.lblFuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi5"));
            };

            Controls.prototype.celKiwarigaku59 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku59"));
            };

            Controls.prototype.lblFuchoKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku5"));
            };

            Controls.prototype.celKiwarigaku60 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku60"));
            };

            Controls.prototype.lblFuchoNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku5"));
            };

            Controls.prototype.celKiwarigaku64 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku64"));
            };

            Controls.prototype.lblTsuki6 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki6"));
            };

            Controls.prototype.celKiwarigaku65 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku65"));
            };

            Controls.prototype.celKiwarigaku66 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku66"));
            };

            Controls.prototype.celKiwarigaku67 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku67"));
            };

            Controls.prototype.celKiwarigaku68 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku68"));
            };

            Controls.prototype.lblFuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi6"));
            };

            Controls.prototype.celKiwarigaku69 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku69"));
            };

            Controls.prototype.lblFuchoKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku6"));
            };

            Controls.prototype.celKiwarigaku70 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku70"));
            };

            Controls.prototype.lblFuchoNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku6"));
            };

            Controls.prototype.celKiwarigaku74 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku74"));
            };

            Controls.prototype.lblTsuki7 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki7"));
            };

            Controls.prototype.celKiwarigaku75 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku75"));
            };

            Controls.prototype.lblTokuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi4"));
            };

            Controls.prototype.celKiwarigaku76 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku76"));
            };

            Controls.prototype.lblTokuKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku4"));
            };

            Controls.prototype.celKiwarigaku77 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku77"));
            };

            Controls.prototype.lblTokuNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku4"));
            };

            Controls.prototype.celKiwarigaku78 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku78"));
            };

            Controls.prototype.lblFuchoKi7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi7"));
            };

            Controls.prototype.celKiwarigaku79 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku79"));
            };

            Controls.prototype.lblFuchoKibetsuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku7"));
            };

            Controls.prototype.celKiwarigaku80 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku80"));
            };

            Controls.prototype.lblFuchoNofuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku7"));
            };

            Controls.prototype.celKiwarigaku84 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku84"));
            };

            Controls.prototype.lblTsuki8 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki8"));
            };

            Controls.prototype.celKiwarigaku85 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku85"));
            };

            Controls.prototype.celKiwarigaku86 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku86"));
            };

            Controls.prototype.celKiwarigaku87 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku87"));
            };

            Controls.prototype.celKiwarigaku88 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku88"));
            };

            Controls.prototype.lblFuchoKi8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi8"));
            };

            Controls.prototype.celKiwarigaku89 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku89"));
            };

            Controls.prototype.lblFuchoKibetsuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku8"));
            };

            Controls.prototype.celKiwarigaku90 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku90"));
            };

            Controls.prototype.lblFuchoNofuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku8"));
            };

            Controls.prototype.celKiwarigaku94 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku94"));
            };

            Controls.prototype.lblTsuki9 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki9"));
            };

            Controls.prototype.celKiwarigaku95 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku95"));
            };

            Controls.prototype.lblTokuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi5"));
            };

            Controls.prototype.celKiwarigaku96 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku96"));
            };

            Controls.prototype.lblTokuKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku5"));
            };

            Controls.prototype.celKiwarigaku97 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku97"));
            };

            Controls.prototype.lblTokuNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku5"));
            };

            Controls.prototype.celKiwarigaku98 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku98"));
            };

            Controls.prototype.lblFuchoKi9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi9"));
            };

            Controls.prototype.celKiwarigaku99 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku99"));
            };

            Controls.prototype.lblFuchoKibetsuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku9"));
            };

            Controls.prototype.celKiwarigaku100 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku100"));
            };

            Controls.prototype.lblFuchoNofuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku9"));
            };

            Controls.prototype.celKiwarigaku104 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku104"));
            };

            Controls.prototype.lblTsuki10 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki10"));
            };

            Controls.prototype.celKiwarigaku105 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku105"));
            };

            Controls.prototype.celKiwarigaku106 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku106"));
            };

            Controls.prototype.celKiwarigaku107 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku107"));
            };

            Controls.prototype.celKiwarigaku108 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku108"));
            };

            Controls.prototype.lblFuchoKi10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi10"));
            };

            Controls.prototype.celKiwarigaku109 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku109"));
            };

            Controls.prototype.lblFuchoKibetsuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku10"));
            };

            Controls.prototype.celKiwarigaku110 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku110"));
            };

            Controls.prototype.lblFuchoNofuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku10"));
            };

            Controls.prototype.celKiwarigaku114 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku114"));
            };

            Controls.prototype.lblTsuki11 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki11"));
            };

            Controls.prototype.celKiwarigaku115 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku115"));
            };

            Controls.prototype.lblTokuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi6"));
            };

            Controls.prototype.celKiwarigaku116 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku116"));
            };

            Controls.prototype.lblTokuKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku6"));
            };

            Controls.prototype.celKiwarigaku117 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku117"));
            };

            Controls.prototype.lblTokuNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku6"));
            };

            Controls.prototype.celKiwarigaku118 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku118"));
            };

            Controls.prototype.lblFuchoKi11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi11"));
            };

            Controls.prototype.celKiwarigaku119 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku119"));
            };

            Controls.prototype.lblFuchoKibetsuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku11"));
            };

            Controls.prototype.celKiwarigaku120 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku120"));
            };

            Controls.prototype.lblFuchoNofuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku11"));
            };

            Controls.prototype.celKiwarigaku124 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku124"));
            };

            Controls.prototype.lblTsuki12 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki12"));
            };

            Controls.prototype.celKiwarigaku125 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku125"));
            };

            Controls.prototype.celKiwarigaku126 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku126"));
            };

            Controls.prototype.celKiwarigaku127 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku127"));
            };

            Controls.prototype.celKiwarigaku128 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku128"));
            };

            Controls.prototype.lblFuchoKi12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi12"));
            };

            Controls.prototype.celKiwarigaku129 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku129"));
            };

            Controls.prototype.lblFuchoKibetsuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku12"));
            };

            Controls.prototype.celKiwarigaku130 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku130"));
            };

            Controls.prototype.lblFuchoNofuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku12"));
            };

            Controls.prototype.celKiwarigaku134 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku134"));
            };

            Controls.prototype.lblTsuki13 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki13"));
            };

            Controls.prototype.celKiwarigaku135 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku135"));
            };

            Controls.prototype.celKiwarigaku136 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku136"));
            };

            Controls.prototype.celKiwarigaku137 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku137"));
            };

            Controls.prototype.celKiwarigaku138 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku138"));
            };

            Controls.prototype.lblFuchoKi13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi13"));
            };

            Controls.prototype.celKiwarigaku139 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku139"));
            };

            Controls.prototype.lblFuchoKibetsuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku13"));
            };

            Controls.prototype.celKiwarigaku140 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku140"));
            };

            Controls.prototype.lblFuchoNofuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku13"));
            };

            Controls.prototype.celKiwarigaku144 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku144"));
            };

            Controls.prototype.lblTsuki14 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki14"));
            };

            Controls.prototype.celKiwarigaku145 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku145"));
            };

            Controls.prototype.celKiwarigaku146 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku146"));
            };

            Controls.prototype.celKiwarigaku147 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku147"));
            };

            Controls.prototype.celKiwarigaku148 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku148"));
            };

            Controls.prototype.lblFuchoKi14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi14"));
            };

            Controls.prototype.celKiwarigaku149 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku149"));
            };

            Controls.prototype.lblFuchoKibetsuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku14"));
            };

            Controls.prototype.celKiwarigaku150 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku150"));
            };

            Controls.prototype.lblFuchoNofuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku14"));
            };

            Controls.prototype.celKiwarigaku154 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku154"));
            };

            Controls.prototype.lblTsuki15 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki15"));
            };

            Controls.prototype.celKiwarigaku155 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku155"));
            };

            Controls.prototype.celKiwarigaku156 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku156"));
            };

            Controls.prototype.lblTokuKibetsuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGakuKei"));
            };

            Controls.prototype.celKiwarigaku157 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku157"));
            };

            Controls.prototype.lblTokuNofuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGakuKei"));
            };

            Controls.prototype.celKiwarigaku158 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku158"));
            };

            Controls.prototype.celKiwarigaku159 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku159"));
            };

            Controls.prototype.lblFuchoKibetsuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGakuKei"));
            };

            Controls.prototype.celKiwarigaku160 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku160"));
            };

            Controls.prototype.lblFuchoNofuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGakuKei"));
            };
            return Controls;
        })();
        Kiwarigaku.Controls = Controls;
    })(DBB.Kiwarigaku || (DBB.Kiwarigaku = {}));
    var Kiwarigaku = DBB.Kiwarigaku;
})(DBB || (DBB = {}));
