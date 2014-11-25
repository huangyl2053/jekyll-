var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var PrintContentsSetting_Design = (function (_super) {
        __extends(PrintContentsSetting_Design, _super);
        function PrintContentsSetting_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, PrintContentsSetting_Design.myLayout, fieldName);
        }
        Object.defineProperty(PrintContentsSetting_Design.prototype, "txtSendData_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[1]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PrintContentsSetting_Design.prototype, "PrintContentsSetting_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PrintContentsSetting_Design.prototype, "PrintContentsSetting_eraseBorder", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorder"] = value;
                } else {
                    this.layout.items[0]["eraseBorder"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        PrintContentsSetting_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("txtSendData_displayNone");
            Uz.JSControlUtil.registProperty("PrintContentsSetting_title");
            Uz.JSControlUtil.registProperty("PrintContentsSetting_eraseBorder");
        };

        PrintContentsSetting_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["txtSendData_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["PrintContentsSetting_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["PrintContentsSetting_eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];

            return editablePropertyInfo;
        };
        PrintContentsSetting_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "PrintContentsSetting",
                    "items": [
                        {
                            "fieldName": "txtIssueDate",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85px",
                            "visible": true,
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
                            "selectControlID": "txtIssueDate_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "発行日",
                            "labelRText": "",
                            "labelLWidth": "55px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSendDate",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "85px",
                            "visible": true,
                            "displayNone": true,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XL",
                            "marginRight": "XS",
                            "selectControlID": "txtSendDate_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "送付日",
                            "labelRText": "",
                            "labelLWidth": "55px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
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
                    "marginLeft": "XS",
                    "marginRight": "XS",
                    "selectControlID": "PrintContentsSetting",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "印字内容設定",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [],
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
            "businessId": "DBZ",
            "controlName": "PrintContentsSetting",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "txtSendDate",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "txtSendData_displayNone"
                },
                {
                    "publicChildFieldName": "PrintContentsSetting",
                    "publicChildProperty": "title",
                    "newPropertyName": "PrintContentsSetting_title"
                },
                {
                    "publicChildFieldName": "PrintContentsSetting",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "PrintContentsSetting_eraseBorder"
                }
            ],
            "dataPassingForDialog": [
                {
                    "key": "",
                    "controlName": ""
                }
            ],
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
        return PrintContentsSetting_Design;
    })(Uz.CommonChildDiv);
    DBZ.PrintContentsSetting_Design = PrintContentsSetting_Design;

    (function (PrintContentsSetting) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PrintContentsSetting.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PrintContentsSetting";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PrintContentsSetting = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIssueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIssueDate"));
            };

            Controls.prototype.txtSendDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendDate"));
            };
            return Controls;
        })();
        PrintContentsSetting.Controls = Controls;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));
