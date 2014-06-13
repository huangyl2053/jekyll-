var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KaigoAtenaInfo_Design = (function (_super) {
        __extends(KaigoAtenaInfo_Design, _super);
        function KaigoAtenaInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoAtenaInfo_Design.myLayout, fieldName);
        }
        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0].items[0]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_canOpenAndClose", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["canOpenAndClose"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["canOpenAndClose"] = value;
                } else {
                    this.layout.items[0].items[0]["canOpenAndClose"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_eraseBorderTop", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderTop"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderTop"] = value;
                } else {
                    this.layout.items[0].items[0]["eraseBorderTop"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_eraseBorderBottom", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderBottom"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderBottom"] = value;
                } else {
                    this.layout.items[0].items[0]["eraseBorderBottom"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_eraseBorderRight", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderRight"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderRight"] = value;
                } else {
                    this.layout.items[0].items[0]["eraseBorderRight"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "atenaInfo_eraseBorderLeft", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderLeft"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["eraseBorderLeft"] = value;
                } else {
                    this.layout.items[0].items[0]["eraseBorderLeft"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "AtenaKanaMeisho_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AtenaKanaMeisho_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AtenaKanaMeisho_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["AtenaKanaMeisho_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "AtenaMisho_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AtenaMeisho_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AtenaMeisho_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["AtenaMeisho_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "SeinengappiYMD_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SeinengappiYMD_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SeinengappiYMD_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["SeinengappiYMD_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "Nenrei_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Nenrei_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Nenrei_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["Nenrei_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "Seibetsu_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Seibetsu_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Seibetsu_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["Seibetsu_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "JuminShubetsu_Visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JuminShubetsu_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JuminShubetsu_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["JuminShubetsu_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "NihonjinGaikokujin_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["NihonjinGaikokujin_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["NihonjinGaikokujin_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["NihonjinGaikokujin_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "JuminJotai_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JuminJotai_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JuminJotai_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["JuminJotai_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "YubinNo_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["YubinNo_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["YubinNo_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["YubinNo_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "Jusho_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Jusho_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Jusho_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["Jusho_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "Gyoseiku_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Gyoseiku_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["Gyoseiku_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["Gyoseiku_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "ShikibetsuCode_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["ShikibetsuCode_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["ShikibetsuCode_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["ShikibetsuCode_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "KojinHojinCode_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["KojinHojinCode_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["KojinHojinCode_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["KojinHojinCode_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "SetaiCode_visible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SetaiCode_visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SetaiCode_visible"] = value;
                } else {
                    this.layout.items[0].items[0]["SetaiCode_visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "lblButtonMargin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["lblButtonMargin_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["lblButtonMargin_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["lblButtonMargin_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnMemo_DisplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnMemo_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnMemo_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnMemo_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnDainosha_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDainosya_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDainosya_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnDainosya_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnSofusaki_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnSofusaki_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnSofusaki_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnSofusaki_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnDainoSofusakiKakunin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDainoSofusakiKakunin_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDainoSofusakiKakunin_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnDainoSofusakiKakunin_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnKoza_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnKoza_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnKoza_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnKoza_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnRenrakusaki_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnRenrakusaki_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnRenrakusaki_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnRenrakusaki_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnShosai_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnShosai_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnShosai_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnShosai_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnAtenaRireki_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnAtenaRireki_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnAtenaRireki_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnAtenaRireki_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnSetaiIchiran_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnSetaiIchiran_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnSetaiIchiran_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnSetaiIchiran_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnDoitsunin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDoitsunin_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnDoitsunin_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnDoitsunin_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnToriatsukaiChui_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnToriatsukaiChui_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnToriatsukaiChui_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnToriatsukaiChui_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnEltax_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnEltax_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnEltax_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnEltax_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnShiyoJokyo_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnShiyoJokyo_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnShiyoJokyo_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnShiyoJokyo_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "btnAtesakiKakunin_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnAtesakiKakunin_displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["btnAtesakiKakunin_displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["btnAtesakiKakunin_displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "SubGyomuCode", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuCode"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuCode"] = value;
                } else {
                    this.layout.items[0].items[0]["SubGyomuCode"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "JukiYusennKubun", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JukiYusennKubun"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["JukiYusennKubun"] = value;
                } else {
                    this.layout.items[0].items[0]["JukiYusennKubun"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "AgeArrivalDay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AgeArrivalDay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["AgeArrivalDay"] = value;
                } else {
                    this.layout.items[0].items[0]["AgeArrivalDay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "SubGyomuUmu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuUmu"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuUmu"] = value;
                } else {
                    this.layout.items[0].items[0]["SubGyomuUmu"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "SubGyomuSearchUmu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuSearchUmu"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["SubGyomuSearchUmu"] = value;
                } else {
                    this.layout.items[0].items[0]["SubGyomuSearchUmu"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(KaigoAtenaInfo_Design.prototype, "DainoninHyojiUmu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["DainoninHyojiUmu"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["DainoninHyojiUmu"] = value;
                } else {
                    this.layout.items[0].items[0]["DainoninHyojiUmu"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KaigoAtenaInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("atenaInfo_title");
            Uz.JSControlUtil.registProperty("atenaInfo_canOpenAndClose");
            Uz.JSControlUtil.registProperty("atenaInfo_eraseBorderTop");
            Uz.JSControlUtil.registProperty("atenaInfo_eraseBorderBottom");
            Uz.JSControlUtil.registProperty("atenaInfo_eraseBorderRight");
            Uz.JSControlUtil.registProperty("atenaInfo_eraseBorderLeft");
            Uz.JSControlUtil.registProperty("AtenaKanaMeisho_visible");
            Uz.JSControlUtil.registProperty("AtenaMisho_visible");
            Uz.JSControlUtil.registProperty("SeinengappiYMD_visible");
            Uz.JSControlUtil.registProperty("Nenrei_visible");
            Uz.JSControlUtil.registProperty("Seibetsu_visible");
            Uz.JSControlUtil.registProperty("JuminShubetsu_Visible");
            Uz.JSControlUtil.registProperty("NihonjinGaikokujin_visible");
            Uz.JSControlUtil.registProperty("JuminJotai_visible");
            Uz.JSControlUtil.registProperty("YubinNo_visible");
            Uz.JSControlUtil.registProperty("Jusho_visible");
            Uz.JSControlUtil.registProperty("Gyoseiku_visible");
            Uz.JSControlUtil.registProperty("ShikibetsuCode_visible");
            Uz.JSControlUtil.registProperty("KojinHojinCode_visible");
            Uz.JSControlUtil.registProperty("SetaiCode_visible");
            Uz.JSControlUtil.registProperty("lblButtonMargin_displayNone");
            Uz.JSControlUtil.registProperty("btnMemo_DisplayNone");
            Uz.JSControlUtil.registProperty("btnDainosha_displayNone");
            Uz.JSControlUtil.registProperty("btnSofusaki_displayNone");
            Uz.JSControlUtil.registProperty("btnDainoSofusakiKakunin_displayNone");
            Uz.JSControlUtil.registProperty("btnKoza_displayNone");
            Uz.JSControlUtil.registProperty("btnRenrakusaki_displayNone");
            Uz.JSControlUtil.registProperty("btnShosai_displayNone");
            Uz.JSControlUtil.registProperty("btnAtenaRireki_displayNone");
            Uz.JSControlUtil.registProperty("btnSetaiIchiran_displayNone");
            Uz.JSControlUtil.registProperty("btnDoitsunin_displayNone");
            Uz.JSControlUtil.registProperty("btnToriatsukaiChui_displayNone");
            Uz.JSControlUtil.registProperty("btnEltax_displayNone");
            Uz.JSControlUtil.registProperty("btnShiyoJokyo_displayNone");
            Uz.JSControlUtil.registProperty("btnAtesakiKakunin_displayNone");
            Uz.JSControlUtil.registProperty("SubGyomuCode");
            Uz.JSControlUtil.registProperty("JukiYusennKubun");
            Uz.JSControlUtil.registProperty("AgeArrivalDay");
            Uz.JSControlUtil.registProperty("SubGyomuUmu");
            Uz.JSControlUtil.registProperty("SubGyomuSearchUmu");
            Uz.JSControlUtil.registProperty("DainoninHyojiUmu");
        };

        KaigoAtenaInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["atenaInfo_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["atenaInfo_canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["canOpenAndClose"];
            editablePropertyInfo["atenaInfo_eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["atenaInfo_eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["atenaInfo_eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["atenaInfo_eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["AtenaKanaMeisho_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["AtenaKanaMeisho_visible"];
            editablePropertyInfo["AtenaMisho_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["AtenaMeisho_visible"];
            editablePropertyInfo["SeinengappiYMD_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["SeinengappiYMD_visible"];
            editablePropertyInfo["Nenrei_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["Nenrei_visible"];
            editablePropertyInfo["Seibetsu_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["Seibetsu_visible"];
            editablePropertyInfo["JuminShubetsu_Visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["JuminShubetsu_visible"];
            editablePropertyInfo["NihonjinGaikokujin_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["NihonjinGaikokujin_visible"];
            editablePropertyInfo["JuminJotai_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["JuminJotai_visible"];
            editablePropertyInfo["YubinNo_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["YubinNo_visible"];
            editablePropertyInfo["Jusho_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["Jusho_visible"];
            editablePropertyInfo["Gyoseiku_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["Gyoseiku_visible"];
            editablePropertyInfo["ShikibetsuCode_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["ShikibetsuCode_visible"];
            editablePropertyInfo["KojinHojinCode_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["KojinHojinCode_visible"];
            editablePropertyInfo["SetaiCode_visible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["SetaiCode_visible"];
            editablePropertyInfo["lblButtonMargin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["lblButtonMargin_displayNone"];
            editablePropertyInfo["btnMemo_DisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnMemo_displayNone"];
            editablePropertyInfo["btnDainosha_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnDainosya_displayNone"];
            editablePropertyInfo["btnSofusaki_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnSofusaki_displayNone"];
            editablePropertyInfo["btnDainoSofusakiKakunin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnDainoSofusakiKakunin_displayNone"];
            editablePropertyInfo["btnKoza_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnKoza_displayNone"];
            editablePropertyInfo["btnRenrakusaki_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnRenrakusaki_displayNone"];
            editablePropertyInfo["btnShosai_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnShosai_displayNone"];
            editablePropertyInfo["btnAtenaRireki_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnAtenaRireki_displayNone"];
            editablePropertyInfo["btnSetaiIchiran_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnSetaiIchiran_displayNone"];
            editablePropertyInfo["btnDoitsunin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnDoitsunin_displayNone"];
            editablePropertyInfo["btnToriatsukaiChui_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnToriatsukaiChui_displayNone"];
            editablePropertyInfo["btnEltax_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnEltax_displayNone"];
            editablePropertyInfo["btnShiyoJokyo_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnShiyoJokyo_displayNone"];
            editablePropertyInfo["btnAtesakiKakunin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["btnAtesakiKakunin_displayNone"];
            editablePropertyInfo["SubGyomuCode"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["SubGyomuCode"];
            editablePropertyInfo["JukiYusennKubun"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["JukiYusennKubun"];
            editablePropertyInfo["AgeArrivalDay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["AgeArrivalDay"];
            editablePropertyInfo["SubGyomuUmu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["SubGyomuUmu"];
            editablePropertyInfo["SubGyomuSearchUmu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["SubGyomuSearchUmu"];
            editablePropertyInfo["DainoninHyojiUmu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["DainoninHyojiUmu"];

            return editablePropertyInfo;
        };
        KaigoAtenaInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoAtenaInfo",
                    "items": [
                        {
                            "fieldName": "atenaInfo",
                            "items": [],
                            "controlType": "CommonChildDiv",
                            "width": "XS",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0",
                            "marginRight": "0",
                            "selectControlID": "atenaInfo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "title": "",
                            "relation": [],
                            "businessId": "URA",
                            "controlName": "AtenaShokaiSimple",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [
                                {
                                    "key": "",
                                    "controlName": ""
                                }
                            ],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canOpenAndClose": true,
                            "eraseBorderTop": true,
                            "eraseBorderBottom": true,
                            "eraseBorderRight": true,
                            "eraseBorderLeft": true,
                            "AtenaKanaMeisho_visible": true,
                            "AtenaMeisho_visible": true,
                            "SeinengappiYMD_visible": true,
                            "Nenrei_visible": true,
                            "Seibetsu_visible": true,
                            "JuminShubetsu_visible": true,
                            "NihonjinGaikokujin_visible": true,
                            "JuminJotai_visible": true,
                            "YubinNo_visible": true,
                            "Jusho_visible": true,
                            "Gyoseiku_visible": true,
                            "ShikibetsuCode_visible": true,
                            "KojinHojinCode_visible": true,
                            "SetaiCode_visible": true,
                            "lblButtonMargin_displayNone": false,
                            "btnMemo_displayNone": false,
                            "btnDainosya_displayNone": false,
                            "btnSofusaki_displayNone": false,
                            "btnDainoSofusakiKakunin_displayNone": false,
                            "btnKoza_displayNone": false,
                            "btnRenrakusaki_displayNone": false,
                            "btnShosai_displayNone": false,
                            "btnAtenaRireki_displayNone": false,
                            "btnSetaiIchiran_displayNone": false,
                            "btnDoitsunin_displayNone": false,
                            "btnToriatsukaiChui_displayNone": false,
                            "btnEltax_displayNone": false,
                            "btnShiyoJokyo_displayNone": false,
                            "btnAtesakiKakunin_displayNone": false,
                            "SubGyomuCode": "",
                            "JukiYusennKubun": "1",
                            "AgeArrivalDay": "1",
                            "SubGyomuUmu": "0",
                            "SubGyomuSearchUmu": "0",
                            "DainoninHyojiUmu": "1"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G12",
                    "visible": true,
                    "displayNone": false,
                    "disabled": false,
                    "accessKey": "",
                    "nextFocusFieldName": "",
                    "wrap": false,
                    "dependencies": [],
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "KaigoAtenaInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KaigoAtenaInfo"
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
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto"
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
            "marginLeft": "0",
            "marginRight": "0",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "KaigoAtenaInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "title",
                    "newPropertyName": "atenaInfo_title"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "canOpenAndClose",
                    "newPropertyName": "atenaInfo_canOpenAndClose"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "eraseBorderTop",
                    "newPropertyName": "atenaInfo_eraseBorderTop"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "eraseBorderBottom",
                    "newPropertyName": "atenaInfo_eraseBorderBottom"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "eraseBorderRight",
                    "newPropertyName": "atenaInfo_eraseBorderRight"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "eraseBorderLeft",
                    "newPropertyName": "atenaInfo_eraseBorderLeft"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "AtenaKanaMeisho_visible",
                    "newPropertyName": "AtenaKanaMeisho_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "AtenaMeisho_visible",
                    "newPropertyName": "AtenaMisho_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "SeinengappiYMD_visible",
                    "newPropertyName": "SeinengappiYMD_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "Nenrei_visible",
                    "newPropertyName": "Nenrei_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "Seibetsu_visible",
                    "newPropertyName": "Seibetsu_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "JuminShubetsu_visible",
                    "newPropertyName": "JuminShubetsu_Visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "NihonjinGaikokujin_visible",
                    "newPropertyName": "NihonjinGaikokujin_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "JuminJotai_visible",
                    "newPropertyName": "JuminJotai_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "YubinNo_visible",
                    "newPropertyName": "YubinNo_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "Jusho_visible",
                    "newPropertyName": "Jusho_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "Gyoseiku_visible",
                    "newPropertyName": "Gyoseiku_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "ShikibetsuCode_visible",
                    "newPropertyName": "ShikibetsuCode_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "KojinHojinCode_visible",
                    "newPropertyName": "KojinHojinCode_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "SetaiCode_visible",
                    "newPropertyName": "SetaiCode_visible"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "lblButtonMargin_displayNone",
                    "newPropertyName": "lblButtonMargin_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnMemo_displayNone",
                    "newPropertyName": "btnMemo_DisplayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnDainosya_displayNone",
                    "newPropertyName": "btnDainosha_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnSofusaki_displayNone",
                    "newPropertyName": "btnSofusaki_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnDainoSofusakiKakunin_displayNone",
                    "newPropertyName": "btnDainoSofusakiKakunin_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnKoza_displayNone",
                    "newPropertyName": "btnKoza_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnRenrakusaki_displayNone",
                    "newPropertyName": "btnRenrakusaki_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnShosai_displayNone",
                    "newPropertyName": "btnShosai_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnAtenaRireki_displayNone",
                    "newPropertyName": "btnAtenaRireki_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnSetaiIchiran_displayNone",
                    "newPropertyName": "btnSetaiIchiran_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnDoitsunin_displayNone",
                    "newPropertyName": "btnDoitsunin_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnToriatsukaiChui_displayNone",
                    "newPropertyName": "btnToriatsukaiChui_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnEltax_displayNone",
                    "newPropertyName": "btnEltax_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnShiyoJokyo_displayNone",
                    "newPropertyName": "btnShiyoJokyo_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "btnAtesakiKakunin_displayNone",
                    "newPropertyName": "btnAtesakiKakunin_displayNone"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "SubGyomuCode",
                    "newPropertyName": "SubGyomuCode"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "JukiYusennKubun",
                    "newPropertyName": "JukiYusennKubun"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "AgeArrivalDay",
                    "newPropertyName": "AgeArrivalDay"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "SubGyomuUmu",
                    "newPropertyName": "SubGyomuUmu"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "SubGyomuSearchUmu",
                    "newPropertyName": "SubGyomuSearchUmu"
                },
                {
                    "publicChildFieldName": "atenaInfo",
                    "publicChildProperty": "DainoninHyojiUmu",
                    "newPropertyName": "DainoninHyojiUmu"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return KaigoAtenaInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoAtenaInfo_Design = KaigoAtenaInfo_Design;
})(DBZ || (DBZ = {}));
