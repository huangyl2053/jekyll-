var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var ShisetsuJoho_Design = (function (_super) {
        __extends(ShisetsuJoho_Design, _super);
        function ShisetsuJoho_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShisetsuJoho_Design.myLayout, fieldName);
        }
        Object.defineProperty(ShisetsuJoho_Design.prototype, "btnJigyoshaInputGuide_displayNone", {
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


        Object.defineProperty(ShisetsuJoho_Design.prototype, "btnOtherTokureiShisetsuInputGuide_displayNone", {
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


        Object.defineProperty(ShisetsuJoho_Design.prototype, "btnJogaiShisetsuInputGuide_displayNone", {
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


        Object.defineProperty(ShisetsuJoho_Design.prototype, "radShisetsuShurui_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[0]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShisetsuJoho_Design.prototype, "ShisetsuJoho_width", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["width"] = value;
                } else {
                    this.layout.items[0]["width"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ShisetsuJoho_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("btnOtherTokureiShisetsuInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("btnJogaiShisetsuInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("radShisetsuShurui_displayNone");
            Uz.JSControlUtil.registProperty("ShisetsuJoho_width");
        };

        ShisetsuJoho_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnJigyoshaInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnOtherTokureiShisetsuInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnJogaiShisetsuInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["radShisetsuShurui_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["ShisetsuJoho_width"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["width"];

            return editablePropertyInfo;
        };
        ShisetsuJoho_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShisetsuJoho",
                    "items": [
                        {
                            "fieldName": "radShisetsuShurui",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "420",
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
                            "selectControlID": "radShisetsuShurui_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onChange": "onChange_radShisetsuShurui",
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "key": "kaigoHokenShisetsu",
                                    "value": "介護保険施設"
                                },
                                {
                                    "key": "other",
                                    "value": "その他特例施設"
                                },
                                {
                                    "key": "tekiyoJogaiShisetsu",
                                    "value": "適用除外施設"
                                }
                            ],
                            "required": false,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "txtShisetsuCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "90",
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
                            "selectControlID": "txtShisetsuCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "required": false,
                            "labelLText": "入所施設",
                            "labelLWidth": "70",
                            "labelLAlign": 2,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "onBlur_txtShisetsuCode",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelRText": "",
                            "labelRWidth": "S",
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "10"
                        },
                        {
                            "fieldName": "btnJigyoshaInputGuide",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "20",
                            "visible": true,
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
                            "selectControlID": "btnJigyoshaInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "■",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                            "imageWidth": "20",
                            "imageHeight": "15",
                            "displayChildDivName": "DBZ.JigyoshaInputGuide",
                            "dataPassing": [
                                {
                                    "key": "jigyoshaCode",
                                    "controlName": "txtShisetsuCode"
                                },
                                {
                                    "key": "jigyoshaMeisho",
                                    "controlName": "txtShisetsuMeisho"
                                }
                            ],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "btnOtherTokureiShisetsuInputGuide",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "20",
                            "visible": true,
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
                            "selectControlID": "btnOtherTokureiShisetsuInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "■",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                            "imageWidth": "20",
                            "imageHeight": "15",
                            "displayChildDivName": "DBZ.OtherTokureiShisetsuInputGuide",
                            "dataPassing": [
                                {
                                    "key": "otherShisetsuCode",
                                    "controlName": "txtShisetsuCode"
                                },
                                {
                                    "key": "otherShisetsuMeisho",
                                    "controlName": "txtShisetsuMeisho"
                                }
                            ],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "btnJogaiShisetsuInputGuide",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "20",
                            "visible": true,
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
                            "selectControlID": "btnJogaiShisetsuInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "■",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                            "imageWidth": "20",
                            "imageHeight": "15",
                            "displayChildDivName": "DBZ.TekiyoJogaiShisetsuInputGuide",
                            "dataPassing": [
                                {
                                    "key": "shisetsuCode",
                                    "controlName": "txtShisetsuCode"
                                },
                                {
                                    "key": "shisetsuMeisho",
                                    "controlName": "txtShisetsuMeisho"
                                }
                            ],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "txtShisetsuMeisho",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "450",
                            "visible": true,
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
                            "selectControlID": "txtShisetsuMeisho_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "onChange": "",
                            "required": false,
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelRText": "",
                            "labelRWidth": "S",
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "800",
                    "visible": true,
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
                    "selectControlID": "ShisetsuJoho",
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
                            "postParameterPanelNames": "ShisetsuJoho"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onChange_radShisetsuShurui",
                            "requestUrl": "dbz/db/dbz/ShisetsuJoho/onChange_radShisetsuShurui"
                        },
                        {
                            "eventName": "onBlur_txtShisetsuCode",
                            "requestUrl": "dbz/db/dbz/ShisetsuJoho/onBlur_txtShisetsuCode"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "selectRow",
                            "value": ""
                        },
                        {
                            "propertyName": "inputMode",
                            "value": ""
                        }
                    ],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorderTop": true,
                    "eraseBorderBottom": true,
                    "eraseBorderRight": true,
                    "eraseBorderLeft": true,
                    "backgroundColor": 0,
                    "widthAuto": false,
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
            "controlName": "ShisetsuJoho",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnJigyoshaInputGuide",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnJigyoshaInputGuide_displayNone"
                },
                {
                    "publicChildFieldName": "btnOtherTokureiShisetsuInputGuide",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnOtherTokureiShisetsuInputGuide_displayNone"
                },
                {
                    "publicChildFieldName": "btnJogaiShisetsuInputGuide",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnJogaiShisetsuInputGuide_displayNone"
                },
                {
                    "publicChildFieldName": "radShisetsuShurui",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "radShisetsuShurui_displayNone"
                },
                {
                    "publicChildFieldName": "ShisetsuJoho",
                    "publicChildProperty": "width",
                    "newPropertyName": "ShisetsuJoho_width"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return ShisetsuJoho_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShisetsuJoho_Design = ShisetsuJoho_Design;
})(DBZ || (DBZ = {}));
