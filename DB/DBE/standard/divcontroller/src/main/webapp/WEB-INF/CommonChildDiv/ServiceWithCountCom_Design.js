var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var ServiceWithCountCom_Design = (function (_super) {
        __extends(ServiceWithCountCom_Design, _super);
        function ServiceWithCountCom_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ServiceWithCountCom_Design.myLayout, fieldName);
        }
        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_ServiceName", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["text"] = value;
                } else {
                    this.layout.items[0].items[0]["text"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_Frequency", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelLText"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelLText"] = value;
                } else {
                    this.layout.items[0].items[1]["labelLText"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ServiceWithCountCom_Design.prototype, "text_Unit", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelRText"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["labelRText"] = value;
                } else {
                    this.layout.items[0].items[1]["labelRText"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ServiceWithCountCom_Design.prototype, "radKaigoOrYobo_dataSource", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["selectedItem"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["selectedItem"] = value;
                } else {
                    this.layout.items[0].items[2]["selectedItem"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ServiceWithCountCom_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("text_ServiceName");
            Uz.JSControlUtil.registProperty("text_Frequency");
            Uz.JSControlUtil.registProperty("text_Unit");
            Uz.JSControlUtil.registProperty("radKaigoOrYobo_dataSource");
        };

        ServiceWithCountCom_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["text_ServiceName"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["text"];
            editablePropertyInfo["text_Frequency"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["text_Unit"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["labelRText"];
            editablePropertyInfo["radKaigoOrYobo_dataSource"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["selectedItem"];

            return editablePropertyInfo;
        };
        ServiceWithCountCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ServiceWithCountCom",
                    "items": [
                        {
                            "fieldName": "lblServiceName",
                            "items": [],
                            "controlType": "Label",
                            "width": "400px",
                            "visible": true,
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
                            "marginRight": "",
                            "selectControlID": "lblServiceName",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "align": 2,
                            "text": "サービス名称",
                            "isPrivateInfo": false,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtNum",
                            "items": [],
                            "controlType": "TextBoxNum",
                            "width": "24px",
                            "visible": true,
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
                            "marginRight": "0em",
                            "selectControlID": "txtNum_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "text": "",
                            "isPrivateInfo": false,
                            "decorationClass": "",
                            "maxLength": "3",
                            "minLength": 0,
                            "textAlign": 2,
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
                            "labelLText": "月",
                            "labelRText": "単位",
                            "labelLWidth": "30px",
                            "labelRWidth": "32px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "maxValue": "999",
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0,
                            "permitCharactor": "+-,.\\"
                        },
                        {
                            "fieldName": "radKaigoOrYobo",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "325px",
                            "visible": true,
                            "displayNone": true,
                            "disabled": true,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "radKaigoOrYobo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "value": "介護",
                                    "key": "1"
                                },
                                {
                                    "value": "予防",
                                    "key": "2"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 2,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
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
                    "selectControlID": "ServiceWithCountCom",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "XS",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        }
                    ],
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
                    "canPost": false
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
            "marginLeft": "XS",
            "marginRight": "XS",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBE",
            "controlName": "ServiceWithCountCom",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildProperty": "text",
                    "publicChildFieldName": "lblServiceName",
                    "newPropertyName": "text_ServiceName"
                },
                {
                    "publicChildProperty": "labelLText",
                    "publicChildFieldName": "txtNum",
                    "newPropertyName": "text_Frequency"
                },
                {
                    "publicChildProperty": "labelRText",
                    "publicChildFieldName": "txtNum",
                    "newPropertyName": "text_Unit"
                },
                {
                    "publicChildProperty": "selectedItem",
                    "publicChildFieldName": "radKaigoOrYobo",
                    "newPropertyName": "radKaigoOrYobo_dataSource"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return ServiceWithCountCom_Design;
    })(Uz.CommonChildDiv);
    DBE.ServiceWithCountCom_Design = ServiceWithCountCom_Design;

    (function (ServiceWithCountCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceWithCountCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceWithCountCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceWithCountCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblServiceName = function () {
                return new UZA.Label(this.convFiledName("lblServiceName"));
            };

            Controls.prototype.txtNum = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNum"));
            };

            Controls.prototype.radKaigoOrYobo = function () {
                return new UZA.RadioButton(this.convFiledName("radKaigoOrYobo"));
            };
            return Controls;
        })();
        ServiceWithCountCom.Controls = Controls;
    })(DBE.ServiceWithCountCom || (DBE.ServiceWithCountCom = {}));
    var ServiceWithCountCom = DBE.ServiceWithCountCom;
})(DBE || (DBE = {}));
