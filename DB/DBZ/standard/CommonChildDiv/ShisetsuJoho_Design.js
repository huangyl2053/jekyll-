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
        ShisetsuJoho_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShisetsuJoho_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShisetsuJoho_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShisetsuJoho",
                    "items": [
                        {
                            "fieldName": "ddlDaichoShubetsu",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "200px",
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
                            "marginLeft": "0px",
                            "marginRight": "XS",
                            "selectControlID": "ddlDaichoShubetsu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "key": "hihokenshaDaicho",
                                    "value": "被保険者台帳"
                                },
                                {
                                    "key": "tekiyoJogaishaDaicho",
                                    "value": "適用除外者台帳"
                                },
                                {
                                    "key": "tashichosonJushochiTokureishaDaicho",
                                    "value": "他市町村住所地特例者台帳"
                                }
                            ],
                            "labelLText": "台帳種別",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "isBlankLine": false,
                            "disabledItem": []
                        },
                        {
                            "fieldName": "radShisetsuShurui",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "380px",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0px",
                            "marginRight": "0em",
                            "selectControlID": "radShisetsuShurui_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
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
                                    "key": "tekiyojogaishisetsu",
                                    "value": "適用除外施設"
                                }
                            ],
                            "required": false,
                            "labelLText": "施設種類",
                            "labelLWidth": "70px",
                            "labelLAlign": 2,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "S",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "txtShisetsuCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "83px",
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
                            "marginLeft": "0em",
                            "marginRight": "XS",
                            "selectControlID": "txtShisetsuCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "required": false,
                            "labelLText": "入所施設",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "10"
                        },
                        {
                            "fieldName": "btnJigyoshaInputGuide",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "20px",
                            "visible": true,
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
                            "selectControlID": "btnJigyoshaInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "",
                            "imageHeight": "",
                            "heightTextBoxMatches": true,
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
                            "width": "20px",
                            "visible": true,
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
                            "selectControlID": "btnOtherTokureiShisetsuInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "■",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "20px",
                            "imageHeight": "15px",
                            "heightTextBoxMatches": true,
                            "displayChildDivName": "DBZ.OtherTokureiShisetsuInputGuide",
                            "dataPassing": [
                                {
                                    "key": "otherShisetsuCode",
                                    "controlName": "txtShisetsuCode"
                                },
                                {
                                    "key": "otherShisetsuMeisho",
                                    "controlName": "txtShisetsuMeisho"
                                },
                                {
                                    "key": "selectRadioButtonKey",
                                    "controlName": "lblOtherShisetsuShurui"
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
                            "width": "20px",
                            "visible": true,
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
                            "selectControlID": "btnJogaiShisetsuInputGuide",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "",
                            "icon": 0,
                            "text": "■",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "20px",
                            "imageHeight": "15px",
                            "heightTextBoxMatches": true,
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
                            "width": "500px",
                            "visible": true,
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
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "decorationClass": "",
                            "permitCharactor": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "750px",
                    "visible": true,
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
                            "eventName": "onChange_ddlDaichoShubetsu",
                            "requestUrl": "dbz/db/dbz/ShisetsuJoho/onChange_ddlDaichoShubetsu"
                        },
                        {
                            "eventName": "onChange_onChange_radShisetsuShurui",
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
                    "eraseBorder": true,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "focusPositionID": "restoreLayoutButton",
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
            "controlName": "ShisetsuJoho",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [
                {
                    "eventName": "onChange_radShisetsuShurui"
                }
            ],
            "publicEventsAlias": []
        };
        return ShisetsuJoho_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShisetsuJoho_Design = ShisetsuJoho_Design;

    (function (ShisetsuJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShisetsuShurui = function () {
                return "onChange_radShisetsuShurui";
            };
            return Events;
        })();
        ShisetsuJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuJoho = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuJoho"));
            };

            Controls.prototype.ddlDaichoShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            };

            Controls.prototype.radShisetsuShurui = function () {
                return new UZA.RadioButton(this.convFiledName("radShisetsuShurui"));
            };

            Controls.prototype.txtShisetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnOtherTokureiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOtherTokureiShisetsuInputGuide"));
            };

            Controls.prototype.btnJogaiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJogaiShisetsuInputGuide"));
            };

            Controls.prototype.txtShisetsuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuMeisho"));
            };
            return Controls;
        })();
        ShisetsuJoho.Controls = Controls;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
