var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "ShinseishaInfo";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.ShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            };

            Controls.prototype.radShinseishaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        ShinseishaInfo.Controls = Controls;
    })(DBC.ShinseishaInfo || (DBC.ShinseishaInfo = {}));
    var ShinseishaInfo = DBC.ShinseishaInfo;

    var ShinseishaInfo_Design = (function (_super) {
        __extends(ShinseishaInfo_Design, _super);
        function ShinseishaInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShinseishaInfo_Design.myLayout, fieldName);
        }
        Object.defineProperty(ShinseishaInfo_Design.prototype, "btnSearch_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[8]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ShinseishaInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnSearch_displayNone");
        };

        ShinseishaInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnSearch_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["displayNone"];

            return editablePropertyInfo;
        };
        ShinseishaInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShinseishaInfo",
                    "items": [
                        {
                            "fieldName": "txtShinseiYMD",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "75",
                            "visible": true,
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
                            "readOnly": false,
                            "placeHolder": "平26.07.01",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "申請日",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtUketsukeYMD",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "75",
                            "visible": true,
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
                            "readOnly": false,
                            "placeHolder": "平26.07.01",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "受付日",
                            "labelRText": "",
                            "labelLWidth": "45",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "radShinseishaKubun",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "380",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "required": false,
                            "onChange": "",
                            "labelLText": "区分",
                            "labelLWidth": "60",
                            "labelLAlign": 2,
                            "selectedItem": "family",
                            "dataSource": [
                                {
                                    "key": "myself",
                                    "value": "本人"
                                },
                                {
                                    "key": "family",
                                    "value": "家族"
                                },
                                {
                                    "key": "serviceJigyosha",
                                    "value": "サービス事業者"
                                },
                                {
                                    "key": "other",
                                    "value": "その他"
                                }
                            ],
                            "onClick": "",
                            "newLineItemNumber": 4,
                            "spaceSize": 1
                        },
                        {
                            "fieldName": "txtShinseishaName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "300",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "氏名",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtYubinNo",
                            "items": [],
                            "controlType": "TextBoxYubinNo",
                            "width": "S",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "住所",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtAddress",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "390",
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
                            "marginLeft": "5.3",
                            "marginRight": "XS",
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtTelNo",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "120",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "00000000000",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "電話番号",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtJigyoshaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "80",
                            "visible": true,
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
                            "readOnly": false,
                            "placeHolder": "1234567890",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "事業者番号",
                            "labelRText": "",
                            "labelLWidth": "75",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": "",
                            "formatLength": 1
                        },
                        {
                            "fieldName": "btnSearchJigyosha",
                            "items": [],
                            "controlType": "Button",
                            "width": "XS",
                            "visible": true,
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
                            "text": "Button1",
                            "onClick": "",
                            "appearance": 1,
                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                            "imageWidth": "18",
                            "imageHeight": "20"
                        }
                    ],
                    "controlType": "Panel",
                    "width": "480",
                    "visible": true,
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
                    "title": "申請者情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseishaJoho"
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
                    "widthAuto": false,
                    "isGroupBox": true
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
            "businessId": "DBC",
            "controlName": "ShinseishaInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnSearchJigyosha",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnSearch_displayNone"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return ShinseishaInfo_Design;
    })(Uz.CommonChildDiv);
    DBC.ShinseishaInfo_Design = ShinseishaInfo_Design;
})(DBC || (DBC = {}));
