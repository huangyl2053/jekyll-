var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var SetaiShotokuIchiran_Design = (function (_super) {
        __extends(SetaiShotokuIchiran_Design, _super);
        function SetaiShotokuIchiran_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SetaiShotokuIchiran_Design.myLayout, fieldName);
        }
        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "txtKijunYmdVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[0]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "txtKijunYmdReadOnly", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["readOnly"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["readOnly"] = value;
                } else {
                    this.layout.items[0].items[0]["readOnly"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "txtKazeiNendoVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[1]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "txtKazeiNendoReadOnly", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["readOnly"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["readOnly"] = value;
                } else {
                    this.layout.items[0].items[1]["readOnly"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "ddlKazeiNendoVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[2]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "ddlKazeiNendoDataSource", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["dataSource"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["dataSource"] = value;
                } else {
                    this.layout.items[0].items[2]["dataSource"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnSaihyojiVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[3]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnSaihyojiOnClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[3]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "chkIchiranAllOnClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[5]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnNarabeteHyojuVisible", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["visible"] = value;
                } else {
                    this.layout.items[0].items[7]["visible"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnNarabeteHyojuOnClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[7]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "dgSetaishotokuGridSetting", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["gridSetting"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["gridSetting"] = value;
                } else {
                    this.layout.items[0].items[8]["gridSetting"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "dgSetaishotokuWidth", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["width"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["width"] = value;
                } else {
                    this.layout.items[0].items[8]["width"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "dgSetaishotokuOnSelect", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelect"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelect"] = value;
                } else {
                    this.layout.items[0].items[8]["onSelect"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "dgSetaishotokuDbClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelectByDblClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelectByDblClick"] = value;
                } else {
                    this.layout.items[0].items[8]["onSelectByDblClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "dgSetaishotokuBySelectButton", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelectBySelectButton"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["onSelectBySelectButton"] = value;
                } else {
                    this.layout.items[0].items[8]["onSelectBySelectButton"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "ddlKazeiNendoDisplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[2]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnNarabeteHyoJiDisplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[7]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "txtSetaiCodeDisyplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[4]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SetaiShotokuIchiran_Design.prototype, "btnSaihyojiDisplayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[3]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        SetaiShotokuIchiran_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("txtKijunYmdVisible");
            Uz.JSControlUtil.registProperty("txtKijunYmdReadOnly");
            Uz.JSControlUtil.registProperty("txtKazeiNendoVisible");
            Uz.JSControlUtil.registProperty("txtKazeiNendoReadOnly");
            Uz.JSControlUtil.registProperty("ddlKazeiNendoVisible");
            Uz.JSControlUtil.registProperty("ddlKazeiNendoDataSource");
            Uz.JSControlUtil.registProperty("btnSaihyojiVisible");
            Uz.JSControlUtil.registProperty("btnSaihyojiOnClick");
            Uz.JSControlUtil.registProperty("chkIchiranAllOnClick");
            Uz.JSControlUtil.registProperty("btnNarabeteHyojuVisible");
            Uz.JSControlUtil.registProperty("btnNarabeteHyojuOnClick");
            Uz.JSControlUtil.registProperty("dgSetaishotokuGridSetting");
            Uz.JSControlUtil.registProperty("dgSetaishotokuWidth");
            Uz.JSControlUtil.registProperty("dgSetaishotokuOnSelect");
            Uz.JSControlUtil.registProperty("dgSetaishotokuDbClick");
            Uz.JSControlUtil.registProperty("dgSetaishotokuBySelectButton");
            Uz.JSControlUtil.registProperty("ddlKazeiNendoDisplayNone");
            Uz.JSControlUtil.registProperty("btnNarabeteHyoJiDisplayNone");
            Uz.JSControlUtil.registProperty("txtSetaiCodeDisyplayNone");
            Uz.JSControlUtil.registProperty("btnSaihyojiDisplayNone");
        };

        SetaiShotokuIchiran_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["txtKijunYmdVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["txtKijunYmdReadOnly"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["readOnly"];
            editablePropertyInfo["txtKazeiNendoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["txtKazeiNendoReadOnly"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["readOnly"];
            editablePropertyInfo["ddlKazeiNendoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["ddlKazeiNendoDataSource"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["dataSource"];
            editablePropertyInfo["btnSaihyojiVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["btnSaihyojiOnClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["chkIchiranAllOnClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["btnNarabeteHyojuVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["btnNarabeteHyojuOnClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["dgSetaishotokuGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["dgSetaishotokuWidth"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["width"];
            editablePropertyInfo["dgSetaishotokuOnSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["dgSetaishotokuDbClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["dgSetaishotokuBySelectButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["onSelectBySelectButton"];
            editablePropertyInfo["ddlKazeiNendoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnNarabeteHyoJiDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtSetaiCodeDisyplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnSaihyojiDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];

            return editablePropertyInfo;
        };
        SetaiShotokuIchiran_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SetaiShotokuIchiran",
                    "items": [
                        {
                            "fieldName": "txtSetaiIchiranKijunYMD",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85",
                            "visible": true,
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
                            "marginRight": "XS",
                            "selectControlID": "txtSetaiIchiranKijunYMD_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "基準日",
                            "labelRText": "",
                            "labelLWidth": "50",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSetaiIchiranKazeiNendo",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "35",
                            "visible": true,
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
                            "selectControlID": "txtSetaiIchiranKazeiNendo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "住民税課税年度",
                            "labelRText": "",
                            "labelLWidth": "115",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "ddlSetaiIchiranKazeiNendo",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "60",
                            "visible": true,
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
                            "selectControlID": "ddlSetaiIchiranKazeiNendo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "住民税課税年度",
                            "labelRText": "",
                            "labelLWidth": "115",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "key0",
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "平26"
                                }
                            ],
                            "disabledItem": []
                        },
                        {
                            "fieldName": "btnSaiHyoji",
                            "items": [],
                            "controlType": "Button",
                            "width": "160",
                            "visible": true,
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
                            "selectControlID": "btnSaiHyoji",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "再表示する",
                            "onClick": "onClick_Saihyoji",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "txtSetaiIchiranSetaiCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "120",
                            "visible": true,
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
                            "selectControlID": "txtSetaiIchiranSetaiCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "世帯コード",
                            "labelRText": "",
                            "labelLWidth": "85",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": 1
                        },
                        {
                            "fieldName": "chkSetaiIchiranAll",
                            "items": [],
                            "controlType": "CheckBoxList",
                            "width": "200",
                            "visible": true,
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
                            "selectControlID": "chkSetaiIchiranAll_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "最新の世帯員を表示する"
                                }
                            ],
                            "onClick": "",
                            "icon": [],
                            "selectedItems": [],
                            "newLineItemNumber": 1,
                            "minCheckedItem": 0,
                            "maxCheckedItem": 2,
                            "spaceSize": "M",
                            "isAllSelectable": false,
                            "isAllSelectableBreakLine": false,
                            "disabledItem": []
                        },
                        {
                            "fieldName": "lblSetaiIchiranMsg",
                            "items": [],
                            "controlType": "Label",
                            "width": "L",
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
                            "marginRight": "XS",
                            "selectControlID": "lblSetaiIchiranMsg",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "※基準日時点の世帯員を表示しています。",
                            "decorationClass": "",
                            "align": 0
                        },
                        {
                            "fieldName": "btnNarabeteHyoji",
                            "items": [],
                            "controlType": "Button",
                            "width": "160",
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
                            "marginRight": "XS",
                            "selectControlID": "btnNarabeteHyoji",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "並べて表示する",
                            "onClick": "onClick_Hikaku",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "dgSetaiShotoku",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1040",
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
                            "selectControlID": "dgSetaiShotoku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "height": "Auto",
                            "dataSource": [],
                            "selectedItems": [],
                            "gridSetting": {
                                "rowHeight": 40,
                                "isMultiSelectable": true,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": true,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "識別コード",
                                            "combineItem": [
                                                "txtKetsugo01"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "氏名",
                                            "combineItem": [
                                                "txtShimei"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "メモ",
                                            "combineItem": [
                                                "btnMemo"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "同一世帯",
                                            "combineItem": [
                                                "txtSonzaiUmuKijunbi",
                                                "txtSonzaiUmuChokkin"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "生年月日・性別",
                                            "combineItem": [
                                                "txtKetsugo02"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "種別",
                                            "combineItem": [
                                                "txtShubetsu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "異動日",
                                            "combineItem": [
                                                "txtIdoYMD"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "把握",
                                            "combineItem": [
                                                "txtHaaku"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "住民税",
                                            "combineItem": [
                                                "txtJuminzei"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "合計所得金額",
                                            "combineItem": [
                                                "txtKetsugo03"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "同月ｻｰﾋﾞｽ",
                                            "combineItem": [
                                                "txtDougetsuService"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "住基情報",
                                            "combineItem": [
                                                "txtJukiIdoYMD",
                                                "txtJuteiYMD",
                                                "txtJukiIdoJiyu"
                                            ]
                                        }
                                    ],
                                    "frozenColumn": "txtShimei",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "識別コード",
                                        "dataName": "txtShikibetsuCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"{\\\"cellType\\\":0}\"",
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShikibetsuCode"
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "txtHihokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"{\\\"cellType\\\":0}\"",
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHihokenshaNo"
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "txtKetsugo01",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"{\\\"cellType\\\":0}\"",
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtShimei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"{\\\"cellType\\\":0}\"",
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "btnMemo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "メモ",
                                            "onClick": "",
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "基準日",
                                        "dataName": "txtSonzaiUmuKijunbi",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 65,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "直近",
                                        "dataName": "txtSonzaiUmuChokkin",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "生年月日・性別",
                                        "dataName": "txtSeinenGappi",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 130,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"{\\\"cellType\\\":0}\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtSeinenGappi"
                                    },
                                    {
                                        "columnName": "続柄",
                                        "dataName": "txtZokugara",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 130,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "続柄",
                                        "dataName": "txtKetsugo02",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 130,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtShubetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 70,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtIdoYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtHaaku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtJuminzei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "合計所得金額",
                                        "dataName": "txtGoukeiShotoku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 110,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "年金収入額",
                                        "dataName": "txtNenkinShunyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 110,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "年金収入額",
                                        "dataName": "txtKetsugo03",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": "\"null\"",
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "データNo",
                                        "dataName": "txtDataNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "性別",
                                        "dataName": "txtSeibetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "",
                                        "dataName": "txtDougetsuService",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "異動日",
                                        "dataName": "txtJukiIdoYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "住定日",
                                        "dataName": "txtJuteiYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "異動事由",
                                        "dataName": "txtJukiIdoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onClick_SetaiKakunin",
                            "onSelectByDblClick": "onClick_SetaiKakunin",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G4",
                    "visible": true,
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
                    "selectControlID": "SetaiShotokuIchiran",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SetaiShotokuIchiran"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": true,
                    "eraseBorderBottom": true,
                    "eraseBorderRight": true,
                    "eraseBorderLeft": true,
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
            "controlName": "SetaiShotokuIchiran",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "txtSetaiIchiranKijunYMD",
                    "publicChildProperty": "visible",
                    "newPropertyName": "txtKijunYmdVisible"
                },
                {
                    "publicChildFieldName": "txtSetaiIchiranKijunYMD",
                    "publicChildProperty": "readOnly",
                    "newPropertyName": "txtKijunYmdReadOnly"
                },
                {
                    "publicChildFieldName": "txtSetaiIchiranKazeiNendo",
                    "publicChildProperty": "visible",
                    "newPropertyName": "txtKazeiNendoVisible"
                },
                {
                    "publicChildFieldName": "txtSetaiIchiranKazeiNendo",
                    "publicChildProperty": "readOnly",
                    "newPropertyName": "txtKazeiNendoReadOnly"
                },
                {
                    "publicChildFieldName": "ddlSetaiIchiranKazeiNendo",
                    "publicChildProperty": "visible",
                    "newPropertyName": "ddlKazeiNendoVisible"
                },
                {
                    "publicChildFieldName": "ddlSetaiIchiranKazeiNendo",
                    "publicChildProperty": "dataSource",
                    "newPropertyName": "ddlKazeiNendoDataSource"
                },
                {
                    "publicChildFieldName": "btnSaiHyoji",
                    "publicChildProperty": "visible",
                    "newPropertyName": "btnSaihyojiVisible"
                },
                {
                    "publicChildFieldName": "btnSaiHyoji",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "btnSaihyojiOnClick"
                },
                {
                    "publicChildFieldName": "chkSetaiIchiranAll",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "chkIchiranAllOnClick"
                },
                {
                    "publicChildFieldName": "btnNarabeteHyoji",
                    "publicChildProperty": "visible",
                    "newPropertyName": "btnNarabeteHyojuVisible"
                },
                {
                    "publicChildFieldName": "btnNarabeteHyoji",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "btnNarabeteHyojuOnClick"
                },
                {
                    "publicChildFieldName": "dgSetaiShotoku",
                    "publicChildProperty": "gridSetting",
                    "newPropertyName": "dgSetaishotokuGridSetting"
                },
                {
                    "publicChildFieldName": "dgSetaiShotoku",
                    "publicChildProperty": "width",
                    "newPropertyName": "dgSetaishotokuWidth"
                },
                {
                    "publicChildFieldName": "dgSetaiShotoku",
                    "publicChildProperty": "onSelect",
                    "newPropertyName": "dgSetaishotokuOnSelect"
                },
                {
                    "publicChildFieldName": "dgSetaiShotoku",
                    "publicChildProperty": "onSelectByDblClick",
                    "newPropertyName": "dgSetaishotokuDbClick"
                },
                {
                    "publicChildFieldName": "dgSetaiShotoku",
                    "publicChildProperty": "onSelectBySelectButton",
                    "newPropertyName": "dgSetaishotokuBySelectButton"
                },
                {
                    "publicChildFieldName": "ddlSetaiIchiranKazeiNendo",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "ddlKazeiNendoDisplayNone"
                },
                {
                    "publicChildFieldName": "btnNarabeteHyoji",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnNarabeteHyoJiDisplayNone"
                },
                {
                    "publicChildFieldName": "txtSetaiIchiranSetaiCode",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "txtSetaiCodeDisyplayNone"
                },
                {
                    "publicChildFieldName": "btnSaiHyoji",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnSaihyojiDisplayNone"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return SetaiShotokuIchiran_Design;
    })(Uz.CommonChildDiv);
    DBZ.SetaiShotokuIchiran_Design = SetaiShotokuIchiran_Design;
})(DBZ || (DBZ = {}));
