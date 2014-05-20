var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBB;
(function (DBB) {
    var KiwarigakuMaeAto_Design = (function (_super) {
        __extends(KiwarigakuMaeAto_Design, _super);
        function KiwarigakuMaeAto_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KiwarigakuMaeAto_Design.myLayout, fieldName);
        }
        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText1", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[34]["fieldName"] + "_" + this.layout.items[0].items[0].items[34].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[34]["fieldName"] + "_" + this.layout.items[0].items[0].items[34].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[34]["fieldName"] + "_" + this.layout.items[0].items[0].items[34].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[34]["fieldName"] + "_" + this.layout.items[0].items[0].items[34].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[34].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[74]["fieldName"] + "_" + this.layout.items[0].items[0].items[74].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[74]["fieldName"] + "_" + this.layout.items[0].items[0].items[74].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[74]["fieldName"] + "_" + this.layout.items[0].items[0].items[74].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[74]["fieldName"] + "_" + this.layout.items[0].items[0].items[74].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[74].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[94]["fieldName"] + "_" + this.layout.items[0].items[0].items[94].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[94]["fieldName"] + "_" + this.layout.items[0].items[0].items[94].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[94]["fieldName"] + "_" + this.layout.items[0].items[0].items[94].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[94]["fieldName"] + "_" + this.layout.items[0].items[0].items[94].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[94].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoKiText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText1", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[75]["fieldName"] + "_" + this.layout.items[0].items[0].items[75].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[75]["fieldName"] + "_" + this.layout.items[0].items[0].items[75].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[75]["fieldName"] + "_" + this.layout.items[0].items[0].items[75].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[75]["fieldName"] + "_" + this.layout.items[0].items[0].items[75].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[75].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[95]["fieldName"] + "_" + this.layout.items[0].items[0].items[95].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[95]["fieldName"] + "_" + this.layout.items[0].items[0].items[95].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[95]["fieldName"] + "_" + this.layout.items[0].items[0].items[95].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[95]["fieldName"] + "_" + this.layout.items[0].items[0].items[95].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[95].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[115]["fieldName"] + "_" + this.layout.items[0].items[0].items[115].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[115]["fieldName"] + "_" + this.layout.items[0].items[0].items[115].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[115]["fieldName"] + "_" + this.layout.items[0].items[0].items[115].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[115]["fieldName"] + "_" + this.layout.items[0].items[0].items[115].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[115].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoMaeKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[155]["fieldName"] + "_" + this.layout.items[0].items[0].items[155].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[155]["fieldName"] + "_" + this.layout.items[0].items[0].items[155].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[155]["fieldName"] + "_" + this.layout.items[0].items[0].items[155].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[155]["fieldName"] + "_" + this.layout.items[0].items[0].items[155].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[155].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi1", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[36].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[56].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[76].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[96].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoTextVisi6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[116].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[76].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[96].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelVisi6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[116].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[16].items[1]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[76].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[96].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoLabelText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[116].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoKeiVisi", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[156].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoAtoKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[156].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[17]["fieldName"] + "_" + this.layout.items[0].items[0].items[17].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[17]["fieldName"] + "_" + this.layout.items[0].items[0].items[17].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[17]["fieldName"] + "_" + this.layout.items[0].items[0].items[17].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[17]["fieldName"] + "_" + this.layout.items[0].items[0].items[17].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[17].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText4", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[97]["fieldName"] + "_" + this.layout.items[0].items[0].items[97].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[97]["fieldName"] + "_" + this.layout.items[0].items[0].items[97].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[97]["fieldName"] + "_" + this.layout.items[0].items[0].items[97].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[97]["fieldName"] + "_" + this.layout.items[0].items[0].items[97].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[97].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenText6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[117]["fieldName"] + "_" + this.layout.items[0].items[0].items[117].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[117]["fieldName"] + "_" + this.layout.items[0].items[0].items[117].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[117]["fieldName"] + "_" + this.layout.items[0].items[0].items[117].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[117]["fieldName"] + "_" + this.layout.items[0].items[0].items[117].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[117].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "TokuchoZougenKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[157]["fieldName"] + "_" + this.layout.items[0].items[0].items[157].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[157]["fieldName"] + "_" + this.layout.items[0].items[0].items[157].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[157]["fieldName"] + "_" + this.layout.items[0].items[0].items[157].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[157]["fieldName"] + "_" + this.layout.items[0].items[0].items[157].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[157].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[18]["fieldName"] + "_" + this.layout.items[0].items[0].items[18].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[18]["fieldName"] + "_" + this.layout.items[0].items[0].items[18].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[18]["fieldName"] + "_" + this.layout.items[0].items[0].items[18].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[18]["fieldName"] + "_" + this.layout.items[0].items[0].items[18].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[18].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[38]["fieldName"] + "_" + this.layout.items[0].items[0].items[38].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[38]["fieldName"] + "_" + this.layout.items[0].items[0].items[38].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[38]["fieldName"] + "_" + this.layout.items[0].items[0].items[38].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[38]["fieldName"] + "_" + this.layout.items[0].items[0].items[38].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[38].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[48]["fieldName"] + "_" + this.layout.items[0].items[0].items[48].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[48]["fieldName"] + "_" + this.layout.items[0].items[0].items[48].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[48]["fieldName"] + "_" + this.layout.items[0].items[0].items[48].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[48]["fieldName"] + "_" + this.layout.items[0].items[0].items[48].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[48].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText5", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText7", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[88]["fieldName"] + "_" + this.layout.items[0].items[0].items[88].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[88]["fieldName"] + "_" + this.layout.items[0].items[0].items[88].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[88]["fieldName"] + "_" + this.layout.items[0].items[0].items[88].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[88]["fieldName"] + "_" + this.layout.items[0].items[0].items[88].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[88].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText9", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[108]["fieldName"] + "_" + this.layout.items[0].items[0].items[108].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[108]["fieldName"] + "_" + this.layout.items[0].items[0].items[108].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[108]["fieldName"] + "_" + this.layout.items[0].items[0].items[108].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[108]["fieldName"] + "_" + this.layout.items[0].items[0].items[108].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[108].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[118]["fieldName"] + "_" + this.layout.items[0].items[0].items[118].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[118]["fieldName"] + "_" + this.layout.items[0].items[0].items[118].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[118]["fieldName"] + "_" + this.layout.items[0].items[0].items[118].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[118]["fieldName"] + "_" + this.layout.items[0].items[0].items[118].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[118].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[128]["fieldName"] + "_" + this.layout.items[0].items[0].items[128].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[128]["fieldName"] + "_" + this.layout.items[0].items[0].items[128].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[128]["fieldName"] + "_" + this.layout.items[0].items[0].items[128].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[128]["fieldName"] + "_" + this.layout.items[0].items[0].items[128].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[128].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[138]["fieldName"] + "_" + this.layout.items[0].items[0].items[138].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[138]["fieldName"] + "_" + this.layout.items[0].items[0].items[138].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[138]["fieldName"] + "_" + this.layout.items[0].items[0].items[138].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[138]["fieldName"] + "_" + this.layout.items[0].items[0].items[138].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[138].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoKiText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[148]["fieldName"] + "_" + this.layout.items[0].items[0].items[148].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[148]["fieldName"] + "_" + this.layout.items[0].items[0].items[148].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[148]["fieldName"] + "_" + this.layout.items[0].items[0].items[148].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[148]["fieldName"] + "_" + this.layout.items[0].items[0].items[148].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[148].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[19]["fieldName"] + "_" + this.layout.items[0].items[0].items[19].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[19]["fieldName"] + "_" + this.layout.items[0].items[0].items[19].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[19]["fieldName"] + "_" + this.layout.items[0].items[0].items[19].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[19]["fieldName"] + "_" + this.layout.items[0].items[0].items[19].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[19].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText4", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[59]["fieldName"] + "_" + this.layout.items[0].items[0].items[59].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[59]["fieldName"] + "_" + this.layout.items[0].items[0].items[59].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[59]["fieldName"] + "_" + this.layout.items[0].items[0].items[59].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[59]["fieldName"] + "_" + this.layout.items[0].items[0].items[59].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[59].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText7", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[89]["fieldName"] + "_" + this.layout.items[0].items[0].items[89].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[89]["fieldName"] + "_" + this.layout.items[0].items[0].items[89].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[89]["fieldName"] + "_" + this.layout.items[0].items[0].items[89].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[89]["fieldName"] + "_" + this.layout.items[0].items[0].items[89].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[89].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText9", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[109]["fieldName"] + "_" + this.layout.items[0].items[0].items[109].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[109]["fieldName"] + "_" + this.layout.items[0].items[0].items[109].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[109]["fieldName"] + "_" + this.layout.items[0].items[0].items[109].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[109]["fieldName"] + "_" + this.layout.items[0].items[0].items[109].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[109].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[119]["fieldName"] + "_" + this.layout.items[0].items[0].items[119].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[119]["fieldName"] + "_" + this.layout.items[0].items[0].items[119].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[119]["fieldName"] + "_" + this.layout.items[0].items[0].items[119].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[119]["fieldName"] + "_" + this.layout.items[0].items[0].items[119].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[119].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[129]["fieldName"] + "_" + this.layout.items[0].items[0].items[129].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[129]["fieldName"] + "_" + this.layout.items[0].items[0].items[129].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[129]["fieldName"] + "_" + this.layout.items[0].items[0].items[129].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[129]["fieldName"] + "_" + this.layout.items[0].items[0].items[129].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[129].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[139]["fieldName"] + "_" + this.layout.items[0].items[0].items[139].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[139]["fieldName"] + "_" + this.layout.items[0].items[0].items[139].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[139]["fieldName"] + "_" + this.layout.items[0].items[0].items[139].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[139]["fieldName"] + "_" + this.layout.items[0].items[0].items[139].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[139].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[149]["fieldName"] + "_" + this.layout.items[0].items[0].items[149].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[149]["fieldName"] + "_" + this.layout.items[0].items[0].items[149].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[149]["fieldName"] + "_" + this.layout.items[0].items[0].items[149].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[149]["fieldName"] + "_" + this.layout.items[0].items[0].items[149].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[149].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoMaeKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[159]["fieldName"] + "_" + this.layout.items[0].items[0].items[159].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[159]["fieldName"] + "_" + this.layout.items[0].items[0].items[159].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[159]["fieldName"] + "_" + this.layout.items[0].items[0].items[159].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[159]["fieldName"] + "_" + this.layout.items[0].items[0].items[159].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[159].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[20].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[30].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi3", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[40].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[50].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[60].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi6", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[70].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[80].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[90].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[100].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[110].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[120].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[130].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[140].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoTextVisi14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[150].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[20].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi4", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[60].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[80].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[90].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi9", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi10", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[120].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[130].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[140].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelVisi14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[150].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText1", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[20].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText2", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText4", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[60].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText7", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[80].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText8", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[90].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText9", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText10", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[120].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[130].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[140].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoLabelText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[150].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoKeiVisi", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0].items[160].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoAtoKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[160].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText1", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[31]["fieldName"] + "_" + this.layout.items[0].items[0].items[31].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[31]["fieldName"] + "_" + this.layout.items[0].items[0].items[31].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[31]["fieldName"] + "_" + this.layout.items[0].items[0].items[31].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[31]["fieldName"] + "_" + this.layout.items[0].items[0].items[31].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[31].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText4", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[61]["fieldName"] + "_" + this.layout.items[0].items[0].items[61].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[61]["fieldName"] + "_" + this.layout.items[0].items[0].items[61].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[61]["fieldName"] + "_" + this.layout.items[0].items[0].items[61].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[61]["fieldName"] + "_" + this.layout.items[0].items[0].items[61].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[61].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText7", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText8", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[101]["fieldName"] + "_" + this.layout.items[0].items[0].items[101].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[101]["fieldName"] + "_" + this.layout.items[0].items[0].items[101].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[101]["fieldName"] + "_" + this.layout.items[0].items[0].items[101].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[101]["fieldName"] + "_" + this.layout.items[0].items[0].items[101].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[101].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText10", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[121]["fieldName"] + "_" + this.layout.items[0].items[0].items[121].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[121]["fieldName"] + "_" + this.layout.items[0].items[0].items[121].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[121]["fieldName"] + "_" + this.layout.items[0].items[0].items[121].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[121]["fieldName"] + "_" + this.layout.items[0].items[0].items[121].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[121].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[131]["fieldName"] + "_" + this.layout.items[0].items[0].items[131].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[131]["fieldName"] + "_" + this.layout.items[0].items[0].items[131].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[131]["fieldName"] + "_" + this.layout.items[0].items[0].items[131].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[131]["fieldName"] + "_" + this.layout.items[0].items[0].items[131].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[131].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[141]["fieldName"] + "_" + this.layout.items[0].items[0].items[141].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[141]["fieldName"] + "_" + this.layout.items[0].items[0].items[141].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[141]["fieldName"] + "_" + this.layout.items[0].items[0].items[141].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[141]["fieldName"] + "_" + this.layout.items[0].items[0].items[141].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[141].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[151]["fieldName"] + "_" + this.layout.items[0].items[0].items[151].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[151]["fieldName"] + "_" + this.layout.items[0].items[0].items[151].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[151]["fieldName"] + "_" + this.layout.items[0].items[0].items[151].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[151]["fieldName"] + "_" + this.layout.items[0].items[0].items[151].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[151].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "FuchoZougenKeiText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[161]["fieldName"] + "_" + this.layout.items[0].items[0].items[161].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[161]["fieldName"] + "_" + this.layout.items[0].items[0].items[161].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[161]["fieldName"] + "_" + this.layout.items[0].items[0].items[161].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[161]["fieldName"] + "_" + this.layout.items[0].items[0].items[161].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[161].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText1", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText2", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[32]["fieldName"] + "_" + this.layout.items[0].items[0].items[32].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[32]["fieldName"] + "_" + this.layout.items[0].items[0].items[32].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[32]["fieldName"] + "_" + this.layout.items[0].items[0].items[32].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[32]["fieldName"] + "_" + this.layout.items[0].items[0].items[32].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[32].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText3", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText4", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[52]["fieldName"] + "_" + this.layout.items[0].items[0].items[52].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[52]["fieldName"] + "_" + this.layout.items[0].items[0].items[52].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[52]["fieldName"] + "_" + this.layout.items[0].items[0].items[52].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[52]["fieldName"] + "_" + this.layout.items[0].items[0].items[52].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[52].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText5", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[62]["fieldName"] + "_" + this.layout.items[0].items[0].items[62].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[62]["fieldName"] + "_" + this.layout.items[0].items[0].items[62].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[62]["fieldName"] + "_" + this.layout.items[0].items[0].items[62].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[62]["fieldName"] + "_" + this.layout.items[0].items[0].items[62].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[62].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText6", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText7", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText8", {
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


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText9", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[102]["fieldName"] + "_" + this.layout.items[0].items[0].items[102].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[102]["fieldName"] + "_" + this.layout.items[0].items[0].items[102].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[102]["fieldName"] + "_" + this.layout.items[0].items[0].items[102].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[102]["fieldName"] + "_" + this.layout.items[0].items[0].items[102].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[102].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText10", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[112]["fieldName"] + "_" + this.layout.items[0].items[0].items[112].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[112]["fieldName"] + "_" + this.layout.items[0].items[0].items[112].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[112]["fieldName"] + "_" + this.layout.items[0].items[0].items[112].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[112]["fieldName"] + "_" + this.layout.items[0].items[0].items[112].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[112].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText11", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[122]["fieldName"] + "_" + this.layout.items[0].items[0].items[122].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[122]["fieldName"] + "_" + this.layout.items[0].items[0].items[122].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[122]["fieldName"] + "_" + this.layout.items[0].items[0].items[122].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[122]["fieldName"] + "_" + this.layout.items[0].items[0].items[122].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[122].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText12", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[132]["fieldName"] + "_" + this.layout.items[0].items[0].items[132].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[132]["fieldName"] + "_" + this.layout.items[0].items[0].items[132].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[132]["fieldName"] + "_" + this.layout.items[0].items[0].items[132].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[132]["fieldName"] + "_" + this.layout.items[0].items[0].items[132].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[132].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText13", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[142]["fieldName"] + "_" + this.layout.items[0].items[0].items[142].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[142]["fieldName"] + "_" + this.layout.items[0].items[0].items[142].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[142]["fieldName"] + "_" + this.layout.items[0].items[0].items[142].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[142]["fieldName"] + "_" + this.layout.items[0].items[0].items[142].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[142].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "NokigenText14", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[152]["fieldName"] + "_" + this.layout.items[0].items[0].items[152].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[152]["fieldName"] + "_" + this.layout.items[0].items[0].items[152].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[152]["fieldName"] + "_" + this.layout.items[0].items[0].items[152].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[152]["fieldName"] + "_" + this.layout.items[0].items[0].items[152].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0].items[152].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KiwarigakuMaeAto_Design.prototype, "KiwarigakuTableHtml", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["html"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["html"] = value;
                } else {
                    this.layout.items[0].items[0]["html"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KiwarigakuMaeAto_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("TokuchoKiText1");
            Uz.JSControlUtil.registProperty("TokuchoKiText2");
            Uz.JSControlUtil.registProperty("TokuchoKiText3");
            Uz.JSControlUtil.registProperty("TokuchoKiText4");
            Uz.JSControlUtil.registProperty("TokuchoKiText5");
            Uz.JSControlUtil.registProperty("TokuchoKiText6");
            Uz.JSControlUtil.registProperty("TokuchoMaeText1");
            Uz.JSControlUtil.registProperty("TokuchoMaeText2");
            Uz.JSControlUtil.registProperty("TokuchoMaeText3");
            Uz.JSControlUtil.registProperty("TokuchoMaeText4");
            Uz.JSControlUtil.registProperty("TokuchoMaeText5");
            Uz.JSControlUtil.registProperty("TokuchoMaeText6");
            Uz.JSControlUtil.registProperty("TokuchoMaeKeiText");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi1");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi2");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi3");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi4");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi5");
            Uz.JSControlUtil.registProperty("TokuchoAtoTextVisi6");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi1");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi2");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi3");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi4");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi5");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelVisi6");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText1");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText2");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText3");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText4");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText5");
            Uz.JSControlUtil.registProperty("TokuchoAtoLabelText6");
            Uz.JSControlUtil.registProperty("TokuchoAtoKeiVisi");
            Uz.JSControlUtil.registProperty("TokuchoAtoKeiText");
            Uz.JSControlUtil.registProperty("TokuchoZougenText1");
            Uz.JSControlUtil.registProperty("TokuchoZougenText2");
            Uz.JSControlUtil.registProperty("TokuchoZougenText3");
            Uz.JSControlUtil.registProperty("TokuchoZougenText4");
            Uz.JSControlUtil.registProperty("TokuchoZougenText5");
            Uz.JSControlUtil.registProperty("TokuchoZougenText6");
            Uz.JSControlUtil.registProperty("TokuchoZougenKeiText");
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
            Uz.JSControlUtil.registProperty("FuchoMaeText1");
            Uz.JSControlUtil.registProperty("FuchoMaeText2");
            Uz.JSControlUtil.registProperty("FuchoMaeText3");
            Uz.JSControlUtil.registProperty("FuchoMaeText4");
            Uz.JSControlUtil.registProperty("FuchoMaeText5");
            Uz.JSControlUtil.registProperty("FuchoMaeText6");
            Uz.JSControlUtil.registProperty("FuchoMaeText7");
            Uz.JSControlUtil.registProperty("FuchoMaeText8");
            Uz.JSControlUtil.registProperty("FuchoMaeText9");
            Uz.JSControlUtil.registProperty("FuchoMaeText10");
            Uz.JSControlUtil.registProperty("FuchoMaeText11");
            Uz.JSControlUtil.registProperty("FuchoMaeText12");
            Uz.JSControlUtil.registProperty("FuchoMaeText13");
            Uz.JSControlUtil.registProperty("FuchoMaeText14");
            Uz.JSControlUtil.registProperty("FuchoMaeKeiText");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi1");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi2");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi3");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi4");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi5");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi6");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi7");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi8");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi9");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi10");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi11");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi12");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi13");
            Uz.JSControlUtil.registProperty("FuchoAtoTextVisi14");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi1");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi2");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi3");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi4");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi5");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi6");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi7");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi8");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi9");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi10");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi11");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi12");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi13");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelVisi14");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText1");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText2");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText3");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText4");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText5");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText6");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText7");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText8");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText9");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText10");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText11");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText12");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText13");
            Uz.JSControlUtil.registProperty("FuchoAtoLabelText14");
            Uz.JSControlUtil.registProperty("FuchoAtoKeiVisi");
            Uz.JSControlUtil.registProperty("FuchoAtoKeiText");
            Uz.JSControlUtil.registProperty("FuchoZougenText1");
            Uz.JSControlUtil.registProperty("FuchoZougenText2");
            Uz.JSControlUtil.registProperty("FuchoZougenText3");
            Uz.JSControlUtil.registProperty("FuchoZougenText4");
            Uz.JSControlUtil.registProperty("FuchoZougenText5");
            Uz.JSControlUtil.registProperty("FuchoZougenText6");
            Uz.JSControlUtil.registProperty("FuchoZougenText7");
            Uz.JSControlUtil.registProperty("FuchoZougenText8");
            Uz.JSControlUtil.registProperty("FuchoZougenText9");
            Uz.JSControlUtil.registProperty("FuchoZougenText10");
            Uz.JSControlUtil.registProperty("FuchoZougenText11");
            Uz.JSControlUtil.registProperty("FuchoZougenText12");
            Uz.JSControlUtil.registProperty("FuchoZougenText13");
            Uz.JSControlUtil.registProperty("FuchoZougenText14");
            Uz.JSControlUtil.registProperty("FuchoZougenKeiText");
            Uz.JSControlUtil.registProperty("NokigenText1");
            Uz.JSControlUtil.registProperty("NokigenText2");
            Uz.JSControlUtil.registProperty("NokigenText3");
            Uz.JSControlUtil.registProperty("NokigenText4");
            Uz.JSControlUtil.registProperty("NokigenText5");
            Uz.JSControlUtil.registProperty("NokigenText6");
            Uz.JSControlUtil.registProperty("NokigenText7");
            Uz.JSControlUtil.registProperty("NokigenText8");
            Uz.JSControlUtil.registProperty("NokigenText9");
            Uz.JSControlUtil.registProperty("NokigenText10");
            Uz.JSControlUtil.registProperty("NokigenText11");
            Uz.JSControlUtil.registProperty("NokigenText12");
            Uz.JSControlUtil.registProperty("NokigenText13");
            Uz.JSControlUtil.registProperty("NokigenText14");
            Uz.JSControlUtil.registProperty("KiwarigakuTableHtml");
        };

        KiwarigakuMaeAto_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["TokuchoKiText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[6]["fieldName"] + "_" + this.layout.items[0].items[0].items[6].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[34]["fieldName"] + "_" + this.layout.items[0].items[0].items[34].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[54]["fieldName"] + "_" + this.layout.items[0].items[0].items[54].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[74]["fieldName"] + "_" + this.layout.items[0].items[0].items[74].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[94]["fieldName"] + "_" + this.layout.items[0].items[0].items[94].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoKiText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[114]["fieldName"] + "_" + this.layout.items[0].items[0].items[114].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[7]["fieldName"] + "_" + this.layout.items[0].items[0].items[7].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[35]["fieldName"] + "_" + this.layout.items[0].items[0].items[35].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[55]["fieldName"] + "_" + this.layout.items[0].items[0].items[55].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[75]["fieldName"] + "_" + this.layout.items[0].items[0].items[75].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[95]["fieldName"] + "_" + this.layout.items[0].items[0].items[95].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[115]["fieldName"] + "_" + this.layout.items[0].items[0].items[115].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoMaeKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[155]["fieldName"] + "_" + this.layout.items[0].items[0].items[155].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoTextVisi1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoTextVisi2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoTextVisi3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoTextVisi4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoTextVisi5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoTextVisi6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelVisi6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoLabelText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[16]["fieldName"] + "_" + this.layout.items[0].items[0].items[16].items[1]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoLabelText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[36]["fieldName"] + "_" + this.layout.items[0].items[0].items[36].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoLabelText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[56]["fieldName"] + "_" + this.layout.items[0].items[0].items[56].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoLabelText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[76]["fieldName"] + "_" + this.layout.items[0].items[0].items[76].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoLabelText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[96]["fieldName"] + "_" + this.layout.items[0].items[0].items[96].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoLabelText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[116]["fieldName"] + "_" + this.layout.items[0].items[0].items[116].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoAtoKeiVisi"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TokuchoAtoKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[156]["fieldName"] + "_" + this.layout.items[0].items[0].items[156].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[17]["fieldName"] + "_" + this.layout.items[0].items[0].items[17].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[37]["fieldName"] + "_" + this.layout.items[0].items[0].items[37].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[57]["fieldName"] + "_" + this.layout.items[0].items[0].items[57].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[77]["fieldName"] + "_" + this.layout.items[0].items[0].items[77].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[97]["fieldName"] + "_" + this.layout.items[0].items[0].items[97].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[117]["fieldName"] + "_" + this.layout.items[0].items[0].items[117].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["TokuchoZougenKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[157]["fieldName"] + "_" + this.layout.items[0].items[0].items[157].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[18]["fieldName"] + "_" + this.layout.items[0].items[0].items[18].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[28]["fieldName"] + "_" + this.layout.items[0].items[0].items[28].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[38]["fieldName"] + "_" + this.layout.items[0].items[0].items[38].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[48]["fieldName"] + "_" + this.layout.items[0].items[0].items[48].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[58]["fieldName"] + "_" + this.layout.items[0].items[0].items[58].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[68]["fieldName"] + "_" + this.layout.items[0].items[0].items[68].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[78]["fieldName"] + "_" + this.layout.items[0].items[0].items[78].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[88]["fieldName"] + "_" + this.layout.items[0].items[0].items[88].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[98]["fieldName"] + "_" + this.layout.items[0].items[0].items[98].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[108]["fieldName"] + "_" + this.layout.items[0].items[0].items[108].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[118]["fieldName"] + "_" + this.layout.items[0].items[0].items[118].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[128]["fieldName"] + "_" + this.layout.items[0].items[0].items[128].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[138]["fieldName"] + "_" + this.layout.items[0].items[0].items[138].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoKiText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[148]["fieldName"] + "_" + this.layout.items[0].items[0].items[148].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[19]["fieldName"] + "_" + this.layout.items[0].items[0].items[19].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[29]["fieldName"] + "_" + this.layout.items[0].items[0].items[29].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[39]["fieldName"] + "_" + this.layout.items[0].items[0].items[39].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[49]["fieldName"] + "_" + this.layout.items[0].items[0].items[49].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[59]["fieldName"] + "_" + this.layout.items[0].items[0].items[59].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[69]["fieldName"] + "_" + this.layout.items[0].items[0].items[69].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[79]["fieldName"] + "_" + this.layout.items[0].items[0].items[79].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[89]["fieldName"] + "_" + this.layout.items[0].items[0].items[89].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[99]["fieldName"] + "_" + this.layout.items[0].items[0].items[99].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[109]["fieldName"] + "_" + this.layout.items[0].items[0].items[109].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[119]["fieldName"] + "_" + this.layout.items[0].items[0].items[119].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[129]["fieldName"] + "_" + this.layout.items[0].items[0].items[129].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[139]["fieldName"] + "_" + this.layout.items[0].items[0].items[139].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[149]["fieldName"] + "_" + this.layout.items[0].items[0].items[149].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoMaeKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[159]["fieldName"] + "_" + this.layout.items[0].items[0].items[159].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoTextVisi1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoTextVisi14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelVisi14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoLabelText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[20]["fieldName"] + "_" + this.layout.items[0].items[0].items[20].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[30]["fieldName"] + "_" + this.layout.items[0].items[0].items[30].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[40]["fieldName"] + "_" + this.layout.items[0].items[0].items[40].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[50]["fieldName"] + "_" + this.layout.items[0].items[0].items[50].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[60]["fieldName"] + "_" + this.layout.items[0].items[0].items[60].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[70]["fieldName"] + "_" + this.layout.items[0].items[0].items[70].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[80]["fieldName"] + "_" + this.layout.items[0].items[0].items[80].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[90]["fieldName"] + "_" + this.layout.items[0].items[0].items[90].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[100]["fieldName"] + "_" + this.layout.items[0].items[0].items[100].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[110]["fieldName"] + "_" + this.layout.items[0].items[0].items[110].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[120]["fieldName"] + "_" + this.layout.items[0].items[0].items[120].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[130]["fieldName"] + "_" + this.layout.items[0].items[0].items[130].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[140]["fieldName"] + "_" + this.layout.items[0].items[0].items[140].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoLabelText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[150]["fieldName"] + "_" + this.layout.items[0].items[0].items[150].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoAtoKeiVisi"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["FuchoAtoKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[160]["fieldName"] + "_" + this.layout.items[0].items[0].items[160].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[21]["fieldName"] + "_" + this.layout.items[0].items[0].items[21].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[31]["fieldName"] + "_" + this.layout.items[0].items[0].items[31].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[41]["fieldName"] + "_" + this.layout.items[0].items[0].items[41].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[51]["fieldName"] + "_" + this.layout.items[0].items[0].items[51].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[61]["fieldName"] + "_" + this.layout.items[0].items[0].items[61].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[71]["fieldName"] + "_" + this.layout.items[0].items[0].items[71].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[81]["fieldName"] + "_" + this.layout.items[0].items[0].items[81].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[91]["fieldName"] + "_" + this.layout.items[0].items[0].items[91].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[101]["fieldName"] + "_" + this.layout.items[0].items[0].items[101].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[111]["fieldName"] + "_" + this.layout.items[0].items[0].items[111].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[121]["fieldName"] + "_" + this.layout.items[0].items[0].items[121].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[131]["fieldName"] + "_" + this.layout.items[0].items[0].items[131].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[141]["fieldName"] + "_" + this.layout.items[0].items[0].items[141].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[151]["fieldName"] + "_" + this.layout.items[0].items[0].items[151].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["FuchoZougenKeiText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[161]["fieldName"] + "_" + this.layout.items[0].items[0].items[161].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText1"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[22]["fieldName"] + "_" + this.layout.items[0].items[0].items[22].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText2"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[32]["fieldName"] + "_" + this.layout.items[0].items[0].items[32].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText3"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[42]["fieldName"] + "_" + this.layout.items[0].items[0].items[42].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText4"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[52]["fieldName"] + "_" + this.layout.items[0].items[0].items[52].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText5"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[62]["fieldName"] + "_" + this.layout.items[0].items[0].items[62].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText6"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[72]["fieldName"] + "_" + this.layout.items[0].items[0].items[72].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText7"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[82]["fieldName"] + "_" + this.layout.items[0].items[0].items[82].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText8"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[92]["fieldName"] + "_" + this.layout.items[0].items[0].items[92].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText9"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[102]["fieldName"] + "_" + this.layout.items[0].items[0].items[102].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText10"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[112]["fieldName"] + "_" + this.layout.items[0].items[0].items[112].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText11"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[122]["fieldName"] + "_" + this.layout.items[0].items[0].items[122].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText12"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[132]["fieldName"] + "_" + this.layout.items[0].items[0].items[132].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText13"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[142]["fieldName"] + "_" + this.layout.items[0].items[0].items[142].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["NokigenText14"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[152]["fieldName"] + "_" + this.layout.items[0].items[0].items[152].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["KiwarigakuTableHtml"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["html"];

            return editablePropertyInfo;
        };
        KiwarigakuMaeAto_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KiwarigakuMaeAto",
                    "items": [
                        {
                            "fieldName": "tblKiwariGakuMaeAto",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku2",
                                    "items": [
                                        {
                                            "fieldName": "lblTokucho",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "特別徴収",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku4",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku5",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku6",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "更正前",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku7",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "4月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku8",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku9",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku3",
                                    "items": [
                                        {
                                            "fieldName": "lblFucho",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "普通徴収",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R1C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku10",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "更正後",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku11",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "増減",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku12",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku13",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "更正前",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku14",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "更正後",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku15",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "増減",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku16",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "納期限",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R2C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku17",
                                    "items": [
                                        {
                                            "fieldName": "txtTokuchoAto1",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
                                        },
                                        {
                                            "fieldName": "lblTokuchoAto1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku18",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku19",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku20",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku21",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto1",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku22",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku23",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R3C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku24",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "5月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku28",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku29",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku30",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku31",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto2",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku32",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku33",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R4C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku34",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "6月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku35",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "2期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku36",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku37",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtTokuchoAto2",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku38",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku39",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku40",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku41",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto3",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku42",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku43",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R5C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku44",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "7月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku48",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku49",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku50",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku51",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto4",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku52",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku53",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R6C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku54",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "8月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku55",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "3期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku56",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku57",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtTokuchoAto3",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku58",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku59",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku60",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku61",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto5",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku62",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku63",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R7C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku64",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "9月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku68",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku69",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku70",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku71",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto6",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku72",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku73",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R8C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku74",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "10月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku75",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "4期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku76",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku77",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtTokuchoAto4",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku78",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku79",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku80",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku81",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto7",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku82",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku83",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R9C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku84",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "11月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku88",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku89",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku90",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku91",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto8",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku92",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku93",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R10C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku94",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "12月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku95",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "5期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku96",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku97",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtTokuchoAto5",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku98",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku99",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku100",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku101",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto9",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku102",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku103",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R11C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku104",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku108",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku109",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku110",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku111",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto10",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku112",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku113",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R12C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku114",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "2月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C1"
                                },
                                {
                                    "fieldName": "celKiwarigaku115",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoKi6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "6期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku116",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMae6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku117",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAto6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtTokuchoAto6",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku118",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougen6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku119",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku120",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku121",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto11",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku122",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku123",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R13C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku124",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "3月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku128",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku129",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku130",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku131",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto12",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku132",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku133",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R14C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku134",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "4月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku138",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku139",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku140",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku141",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto13",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku142",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku143",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R15C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku144",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "5月",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku148",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku149",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoKi14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "1期",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku150",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMae14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku151",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAto14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
                                        },
                                        {
                                            "fieldName": "txtFuchoAto14",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "70",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "text": "",
                                            "isPrivateInfo": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPassword": false,
                                            "isComboBox": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku152",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougen14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku153",
                                    "items": [
                                        {
                                            "fieldName": "lblNokigen14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "80",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "平99.99.99",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R16C10"
                                },
                                {
                                    "fieldName": "celKiwarigaku154",
                                    "items": [
                                        {
                                            "fieldName": "lblTsuki15",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "required": false,
                                            "align": 1,
                                            "text": "合計",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C2"
                                },
                                {
                                    "fieldName": "celKiwarigaku156",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoMaeKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C3"
                                },
                                {
                                    "fieldName": "celKiwarigaku157",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoAtoKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C4"
                                },
                                {
                                    "fieldName": "celKiwarigaku158",
                                    "items": [
                                        {
                                            "fieldName": "lblTokuchoZougenKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C5"
                                },
                                {
                                    "fieldName": "celKiwarigaku159",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C6"
                                },
                                {
                                    "fieldName": "celKiwarigaku160",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoMaeKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C7"
                                },
                                {
                                    "fieldName": "celKiwarigaku161",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoAtoKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C8"
                                },
                                {
                                    "fieldName": "celKiwarigaku162",
                                    "items": [
                                        {
                                            "fieldName": "lblFuchoZougenKei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "70",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 2,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "align": 2,
                                            "text": "12,345",
                                            "isPrivateInfo": false
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C9"
                                },
                                {
                                    "fieldName": "celKiwarigaku163",
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
                                    "marginLeft": 0,
                                    "marginRight": 0,
                                    "connectTd": "R17C10"
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "html": "<table border=\"1\">\n  <tbody>\n    <tr bgcolor=\"lightgrey\"><td id='R1C1'></td><td colspan=\"4\" id='R1C2'></td><td colspan=\"5\"  id='R1C6'></td></tr>\n    <tr bgcolor=\"lightgrey\" ><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td><td id='R2C7'></td><td id='R2C8'></td><td id='R2C9'></td><td id='R2C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td><td id='R3C6'></td><td id='R3C7'></td><td id='R3C8'></td><td id='R3C9'></td><td id='R3C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R4C1'></td><td id='R4C2'></td><td id='R4C3'></td><td id='R4C4'></td><td id='R4C5'></td><td id='R4C6'></td><td id='R4C7'></td><td id='R4C8'></td><td id='R4C9'></td><td id='R4C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R5C1'></td><td id='R5C2'></td><td id='R5C3'></td><td id='R5C4'></td><td id='R5C5'></td><td id='R5C6'></td><td id='R5C7'></td><td id='R5C8'></td><td id='R5C9'></td><td id='R5C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R6C1'></td><td id='R6C2'></td><td id='R6C3'></td><td id='R6C4'></td><td id='R6C5'></td><td id='R6C6'></td><td id='R6C7'></td><td id='R6C8'></td><td id='R6C9'></td><td id='R6C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R7C1'></td><td id='R7C2'></td><td id='R7C3'></td><td id='R7C4'></td><td id='R7C5'></td><td id='R7C6'></td><td id='R7C7'></td><td id='R7C8'></td><td id='R7C9'></td><td id='R7C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R8C1'></td><td id='R8C2'></td><td id='R8C3'></td><td id='R8C4'></td><td id='R8C5'></td><td id='R8C6'></td><td id='R8C7'></td><td id='R8C8'></td><td id='R8C9'></td><td id='R8C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R9C1'></td><td id='R9C2'></td><td id='R9C3'></td><td id='R9C4'></td><td id='R9C5'></td><td id='R9C6'></td><td id='R9C7'></td><td id='R9C8'></td><td id='R9C9'></td><td id='R9C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R10C1'></td><td id='R10C2'></td><td id='R10C3'></td><td id='R10C4'></td><td id='R10C5'></td><td id='R10C6'></td><td id='R10C7'></td><td id='R10C8'></td><td id='R10C9'></td><td id='R10C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R11C1'></td><td id='R11C2'></td><td id='R11C3'></td><td id='R11C4'></td><td id='R11C5'></td><td id='R11C6'></td><td id='R11C7'></td><td id='R11C8'></td><td id='R11C9'></td><td id='R11C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R12C1'></td><td id='R12C2'></td><td id='R12C3'></td><td id='R12C4'></td><td id='R12C5'></td><td id='R12C6'></td><td id='R12C7'></td><td id='R12C8'></td><td id='R12C9'></td><td id='R12C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R13C1'></td><td id='R13C2'></td><td id='R13C3'></td><td id='R13C4'></td><td id='R13C5'></td><td id='R13C6'></td><td id='R13C7'></td><td id='R13C8'></td><td id='R13C9'></td><td id='R13C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R14C1'></td><td id='R14C2'></td><td id='R14C3'></td><td id='R14C4'></td><td id='R14C5'></td><td id='R14C6'></td><td id='R14C7'></td><td id='R14C8'></td><td id='R14C9'></td><td id='R14C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R15C1'></td><td id='R15C2'></td><td id='R15C3'></td><td id='R15C4'></td><td id='R15C5'></td><td id='R15C6'></td><td id='R15C7'></td><td id='R15C8'></td><td id='R15C9'></td><td id='R15C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R16C1'></td><td id='R16C2'></td><td id='R16C3'></td><td id='R16C4'></td><td id='R16C5'></td><td id='R16C6'></td><td id='R16C7'></td><td id='R16C8'></td><td id='R16C9'></td><td id='R16C10'></td></tr>\n    <tr><td bgcolor=\"lightgrey\" id='R17C1'></td><td id='R17C2'></td><td id='R17C3'></td><td id='R17C4'></td><td id='R17C5'></td><td id='R17C6'></td><td id='R17C7'></td><td id='R17C8'></td><td id='R17C9'></td><td id='R17C10'></td></tr>\n  </tbody>\n</table>\n"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "M",
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
                    "marginLeft": "XS",
                    "marginRight": "XS",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KiwarigakuMaeAto"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false,
                    "backgroundColor": 0,
                    "widthAuto": true,
                    "isGroupBox": false
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
            "marginLeft": 0,
            "marginRight": 0,
            "relation": [],
            "businessId": "DBB",
            "controlName": "KiwarigakuMaeAto",
            "marginTop": 0,
            "marginBottom": 0,
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
                    "publicChildFieldName": "lblTokuchoMae1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText1"
                },
                {
                    "publicChildFieldName": "lblTokuchoMae2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText2"
                },
                {
                    "publicChildFieldName": "lblTokuchoMae3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText3"
                },
                {
                    "publicChildFieldName": "lblTokuchoMae4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText4"
                },
                {
                    "publicChildFieldName": "lblTokuchoMae5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText5"
                },
                {
                    "publicChildFieldName": "lblTokuchoMae6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeText6"
                },
                {
                    "publicChildFieldName": "lblTokuchoMaeKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoMaeKeiText"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi1"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi2"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi3"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi4"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi5"
                },
                {
                    "publicChildFieldName": "txtTokuchoAto6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoTextVisi6"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi1"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi2"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi3"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi4"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi5"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoLabelVisi6"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText1"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText2"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText3"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText4"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText5"
                },
                {
                    "publicChildFieldName": "lblTokuchoAto6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoLabelText6"
                },
                {
                    "publicChildFieldName": "lblTokuchoAtoKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "TokuchoAtoKeiVisi"
                },
                {
                    "publicChildFieldName": "lblTokuchoAtoKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoAtoKeiText"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen1",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText1"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen2",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText2"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen3",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText3"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen4",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText4"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen5",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText5"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougen6",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenText6"
                },
                {
                    "publicChildFieldName": "lblTokuchoZougenKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "TokuchoZougenKeiText"
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
                    "publicChildFieldName": "lblFuchoMae1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText1"
                },
                {
                    "publicChildFieldName": "lblFuchoMae2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText2"
                },
                {
                    "publicChildFieldName": "lblFuchoMae3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText3"
                },
                {
                    "publicChildFieldName": "lblFuchoMae4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText4"
                },
                {
                    "publicChildFieldName": "lblFuchoMae5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText5"
                },
                {
                    "publicChildFieldName": "lblFuchoMae6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText6"
                },
                {
                    "publicChildFieldName": "lblFuchoMae7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText7"
                },
                {
                    "publicChildFieldName": "lblFuchoMae8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText8"
                },
                {
                    "publicChildFieldName": "lblFuchoMae9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText9"
                },
                {
                    "publicChildFieldName": "lblFuchoMae10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText10"
                },
                {
                    "publicChildFieldName": "lblFuchoMae11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText11"
                },
                {
                    "publicChildFieldName": "lblFuchoMae12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText12"
                },
                {
                    "publicChildFieldName": "lblFuchoMae13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText13"
                },
                {
                    "publicChildFieldName": "lblFuchoMae14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeText14"
                },
                {
                    "publicChildFieldName": "lblFuchoMaeKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoMaeKeiText"
                },
                {
                    "publicChildFieldName": "txtFuchoAto1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi1"
                },
                {
                    "publicChildFieldName": "txtFuchoAto2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi2"
                },
                {
                    "publicChildFieldName": "txtFuchoAto3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi3"
                },
                {
                    "publicChildFieldName": "txtFuchoAto4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi4"
                },
                {
                    "publicChildFieldName": "txtFuchoAto5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi5"
                },
                {
                    "publicChildFieldName": "txtFuchoAto6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi6"
                },
                {
                    "publicChildFieldName": "txtFuchoAto7",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi7"
                },
                {
                    "publicChildFieldName": "txtFuchoAto8",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi8"
                },
                {
                    "publicChildFieldName": "txtFuchoAto9",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi9"
                },
                {
                    "publicChildFieldName": "txtFuchoAto10",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi10"
                },
                {
                    "publicChildFieldName": "txtFuchoAto11",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi11"
                },
                {
                    "publicChildFieldName": "txtFuchoAto12",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi12"
                },
                {
                    "publicChildFieldName": "txtFuchoAto13",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi13"
                },
                {
                    "publicChildFieldName": "txtFuchoAto14",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoTextVisi14"
                },
                {
                    "publicChildFieldName": "lblFuchoAto1",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi1"
                },
                {
                    "publicChildFieldName": "lblFuchoAto2",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi2"
                },
                {
                    "publicChildFieldName": "lblFuchoAto3",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi3"
                },
                {
                    "publicChildFieldName": "lblFuchoAto4",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi4"
                },
                {
                    "publicChildFieldName": "lblFuchoAto5",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi5"
                },
                {
                    "publicChildFieldName": "lblFuchoAto6",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi6"
                },
                {
                    "publicChildFieldName": "lblFuchoAto7",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi7"
                },
                {
                    "publicChildFieldName": "lblFuchoAto8",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi8"
                },
                {
                    "publicChildFieldName": "lblFuchoAto9",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi9"
                },
                {
                    "publicChildFieldName": "lblFuchoAto10",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi10"
                },
                {
                    "publicChildFieldName": "lblFuchoAto11",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi11"
                },
                {
                    "publicChildFieldName": "lblFuchoAto12",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi12"
                },
                {
                    "publicChildFieldName": "lblFuchoAto13",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi13"
                },
                {
                    "publicChildFieldName": "lblFuchoAto14",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoLabelVisi14"
                },
                {
                    "publicChildFieldName": "lblFuchoAto1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText1"
                },
                {
                    "publicChildFieldName": "lblFuchoAto2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText2"
                },
                {
                    "publicChildFieldName": "lblFuchoAto3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText3"
                },
                {
                    "publicChildFieldName": "lblFuchoAto4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText4"
                },
                {
                    "publicChildFieldName": "lblFuchoAto5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText5"
                },
                {
                    "publicChildFieldName": "lblFuchoAto6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText6"
                },
                {
                    "publicChildFieldName": "lblFuchoAto7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText7"
                },
                {
                    "publicChildFieldName": "lblFuchoAto8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText8"
                },
                {
                    "publicChildFieldName": "lblFuchoAto9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText9"
                },
                {
                    "publicChildFieldName": "lblFuchoAto10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText10"
                },
                {
                    "publicChildFieldName": "lblFuchoAto11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText11"
                },
                {
                    "publicChildFieldName": "lblFuchoAto12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText12"
                },
                {
                    "publicChildFieldName": "lblFuchoAto13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText13"
                },
                {
                    "publicChildFieldName": "lblFuchoAto14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoLabelText14"
                },
                {
                    "publicChildFieldName": "lblFuchoAtoKei",
                    "publicChildProperty": "visible",
                    "newPropertyName": "FuchoAtoKeiVisi"
                },
                {
                    "publicChildFieldName": "lblFuchoAtoKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoAtoKeiText"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen1",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText1"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen2",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText2"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen3",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText3"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen4",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText4"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen5",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText5"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen6",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText6"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen7",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText7"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen8",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText8"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen9",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText9"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen10",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText10"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen11",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText11"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen12",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText12"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen13",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText13"
                },
                {
                    "publicChildFieldName": "lblFuchoZougen14",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenText14"
                },
                {
                    "publicChildFieldName": "lblFuchoZougenKei",
                    "publicChildProperty": "text",
                    "newPropertyName": "FuchoZougenKeiText"
                },
                {
                    "publicChildFieldName": "lblNokigen1",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText1"
                },
                {
                    "publicChildFieldName": "lblNokigen2",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText2"
                },
                {
                    "publicChildFieldName": "lblNokigen3",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText3"
                },
                {
                    "publicChildFieldName": "lblNokigen4",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText4"
                },
                {
                    "publicChildFieldName": "lblNokigen5",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText5"
                },
                {
                    "publicChildFieldName": "lblNokigen6",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText6"
                },
                {
                    "publicChildFieldName": "lblNokigen7",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText7"
                },
                {
                    "publicChildFieldName": "lblNokigen8",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText8"
                },
                {
                    "publicChildFieldName": "lblNokigen9",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText9"
                },
                {
                    "publicChildFieldName": "lblNokigen10",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText10"
                },
                {
                    "publicChildFieldName": "lblNokigen11",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText11"
                },
                {
                    "publicChildFieldName": "lblNokigen12",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText12"
                },
                {
                    "publicChildFieldName": "lblNokigen13",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText13"
                },
                {
                    "publicChildFieldName": "lblNokigen14",
                    "publicChildProperty": "text",
                    "newPropertyName": "NokigenText14"
                },
                {
                    "publicChildFieldName": "tblKiwariGakuMaeAto",
                    "publicChildProperty": "html",
                    "newPropertyName": "KiwarigakuTableHtml"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KiwarigakuMaeAto_Design;
    })(Uz.CommonChildDiv);
    DBB.KiwarigakuMaeAto_Design = KiwarigakuMaeAto_Design;
})(DBB || (DBB = {}));
