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
var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "台帳種別",
                    "施設種類",
                    "入力補助"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.台帳種別 = function () {
                return new Modes.台帳種別(this.controls);
            };

            ModeController.prototype.施設種類 = function () {
                return new Modes.施設種類(this.controls);
            };

            ModeController.prototype.入力補助 = function () {
                return new Modes.入力補助(this.controls);
            };
            return ModeController;
        })();
        ShisetsuJoho.ModeController = ModeController;

        (function (Modes) {
            var 台帳種別 = (function () {
                function 台帳種別(controls) {
                    this.controls = controls;
                }
                台帳種別.prototype.台帳種別表示する = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = false;
                };

                台帳種別.prototype.台帳種別非表示する = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                };
                return 台帳種別;
            })();
            Modes.台帳種別 = 台帳種別;

            var 施設種類 = (function () {
                function 施設種類(controls) {
                    this.controls = controls;
                }
                施設種類.prototype.施設種類を表示する = function () {
                    this.controls.radShisetsuShurui().displayNone = false;
                };

                施設種類.prototype.施設種類を表示しない = function () {
                    this.controls.radShisetsuShurui().displayNone = true;
                };
                return 施設種類;
            })();
            Modes.施設種類 = 施設種類;

            var 入力補助 = (function () {
                function 入力補助(controls) {
                    this.controls = controls;
                }
                入力補助.prototype.事業者を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };

                入力補助.prototype.他特例施設を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };

                入力補助.prototype.除外施設を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                };
                return 入力補助;
            })();
            Modes.入力補助 = 入力補助;
        })(ShisetsuJoho.Modes || (ShisetsuJoho.Modes = {}));
        var Modes = ShisetsuJoho.Modes;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuJoho.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var ShikakuHenkoRireki_Design = (function (_super) {
        __extends(ShikakuHenkoRireki_Design, _super);
        function ShikakuHenkoRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShikakuHenkoRireki_Design.myLayout, fieldName);
        }
        ShikakuHenkoRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShikakuHenkoRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShikakuHenkoRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShikakuHenkoRireki",
                    "items": [
                        {
                            "fieldName": "btnAdd",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "selectControlID": "btnAdd",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgHenko",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "870px",
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
                            "marginRight": "0px",
                            "selectControlID": "dgHenko",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "217px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "state"
                                    },
                                    {
                                        "columnName": "変更日",
                                        "dataName": "henkoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "henkoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoTodokedeDate"
                                    },
                                    {
                                        "columnName": "変更事由",
                                        "dataName": "henkoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoJiyu"
                                    },
                                    {
                                        "columnName": "変更事由Key",
                                        "dataName": "henkoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoJiyuKey"
                                    },
                                    {
                                        "columnName": "所在保険者",
                                        "dataName": "shozaiHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shozaiHokensha"
                                    },
                                    {
                                        "columnName": "措置元保険者",
                                        "dataName": "sochimotoHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochimotoHokensha"
                                    },
                                    {
                                        "columnName": "旧保険者",
                                        "dataName": "kyuHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kyuHokensha"
                                    },
                                    {
                                        "columnName": "処理日時",
                                        "dataName": "shoriDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shoriDate"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgHenko",
                            "onSelectByDblClick": "onSelectByDblClick_dgHenko",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgHenko",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgHenko",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "henkoTodokedeDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
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
                    "marginLeft": "0px",
                    "marginRight": "0px",
                    "selectControlID": "ShikakuHenkoRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "ShikakuHenkoRireki",
            "marginTop": "0px",
            "marginBottom": "0px",
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
                    "eventName": "onClick_btnAdd"
                },
                {
                    "eventName": "onSelect_dgHenko"
                },
                {
                    "eventName": "onSelectByDblClick_dgHenko"
                },
                {
                    "eventName": "onSelectByModifyButton_dgHenko"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgHenko"
                }
            ],
            "publicEventsAlias": []
        };
        return ShikakuHenkoRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShikakuHenkoRireki_Design = ShikakuHenkoRireki_Design;

    (function (ShikakuHenkoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgHenko = function () {
                return "onSelect_dgHenko";
            };

            Events.onSelectByDblClick_dgHenko = function () {
                return "onSelectByDblClick_dgHenko";
            };

            Events.onSelectByModifyButton_dgHenko = function () {
                return "onSelectByModifyButton_dgHenko";
            };

            Events.onSelectByDeleteButton_dgHenko = function () {
                return "onSelectByDeleteButton_dgHenko";
            };
            return Events;
        })();
        ShikakuHenkoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRireki = function () {
                return new UZA.Panel(this.convFiledName("ShikakuHenkoRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgHenko = function () {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            };
            return Controls;
        })();
        ShikakuHenkoRireki.Controls = Controls;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "ShoriNichijiDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.ShoriNichijiDisplayMode = function () {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        ShikakuHenkoRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgHenko().width = 870;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgHenko().width = 790;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgHenko().width = 750;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgHenko().width = 740;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgHenko().width = 670;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgHenko().width = 630;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgHenko().width = 620;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgHenko().width = 550;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgHenko().width = 510;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgHenko().width = 500;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgHenko().width = 430;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size12 = function () {
                    this.controls.dgHenko().width = 380;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgHenko().height = 450;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgHenko().height = 400;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgHenko().height = 350;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgHenko().height = 300;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgHenko().height = 250;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgHenko().height = 200;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(ShikakuHenkoRireki.Modes || (ShikakuHenkoRireki.Modes = {}));
        var Modes = ShikakuHenkoRireki.Modes;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuHenkoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuHenkoRireki.PublicProperties = PublicProperties;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var IryoHokenRireki_Design = (function (_super) {
        __extends(IryoHokenRireki_Design, _super);
        function IryoHokenRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, IryoHokenRireki_Design.myLayout, fieldName);
        }
        IryoHokenRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        IryoHokenRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        IryoHokenRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "IryoHokenRireki",
                    "items": [
                        {
                            "fieldName": "btnAddIryoHoken",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "selectControlID": "btnAddIryoHoken",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAddIryoHoken",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgIryoHokenRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "980px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgIryoHokenRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "state"
                                    },
                                    {
                                        "columnName": "加入日",
                                        "dataName": "kanyuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kanyuDate"
                                    },
                                    {
                                        "columnName": "脱退日",
                                        "dataName": "dattaiDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "dattaiDate"
                                    },
                                    {
                                        "columnName": "種別key",
                                        "dataName": "iryoHokenShubetsuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "iryoHokenShubetsuKey"
                                    },
                                    {
                                        "columnName": "種別",
                                        "dataName": "iryoHokenShubetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "iryoHokenShubetsu"
                                    },
                                    {
                                        "columnName": "保険者番号",
                                        "dataName": "hokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "hokenshaNo"
                                    },
                                    {
                                        "columnName": "保険者名称",
                                        "dataName": "hokenshaMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "hokenshaMeisho"
                                    },
                                    {
                                        "columnName": "保険者",
                                        "dataName": "hokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "hokensha"
                                    },
                                    {
                                        "columnName": "記号番号",
                                        "dataName": "kigoNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 270,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kigoNo"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgIryoHokenRireki",
                            "onSelectByDblClick": "onSelectByDbClick_dgIryoHokenRireki",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgIryoHokenRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgIryoHokenRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "hokensha",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1015px",
                    "visible": true,
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
                    "selectControlID": "IryoHokenRireki",
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
                            "postParameterPanelNames": "IryoHokenRireki"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "mode",
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
            "controlName": "IryoHokenRireki",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "",
                    "controlName": ""
                },
                {
                    "key": "",
                    "controlName": ""
                },
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
            "publicEvents": [
                {
                    "eventName": "onSelectByModifyButton_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelect_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelectByDbClick_dgIryoHokenRireki"
                },
                {
                    "eventName": "onClick_btnAddIryoHoken"
                }
            ],
            "publicEventsAlias": []
        };
        return IryoHokenRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.IryoHokenRireki_Design = IryoHokenRireki_Design;

    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddIryoHoken = function () {
                return "onClick_btnAddIryoHoken";
            };

            Events.onSelect_dgIryoHokenRireki = function () {
                return "onSelect_dgIryoHokenRireki";
            };

            Events.onSelectByDbClick_dgIryoHokenRireki = function () {
                return "onSelectByDbClick_dgIryoHokenRireki";
            };

            Events.onSelectByModifyButton_dgIryoHokenRireki = function () {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            };

            Events.onSelectByDeleteButton_dgIryoHokenRireki = function () {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            };
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenRireki"));
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };
            return Controls;
        })();
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Shokai = function () {
                    this.controls.dgIryoHokenRireki().readOnly = true;
                    this.controls.btnAddIryoHoken().displayNone = true;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 940;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.Toroku = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.ShikakuIdo = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;

            var WidthMode = (function () {
                function WidthMode(controls) {
                    this.controls = controls;
                }
                WidthMode.prototype.Width1 = function () {
                    this.controls.dgIryoHokenRireki().width = 800;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                WidthMode.prototype.Width2 = function () {
                    this.controls.dgIryoHokenRireki().width = 700;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return WidthMode;
            })();
            Modes.WidthMode = WidthMode;
        })(IryoHokenRireki.Modes || (IryoHokenRireki.Modes = {}));
        var Modes = IryoHokenRireki.Modes;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoHokenRireki.PublicProperties = PublicProperties;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var JushochiTokureiRireki_Design = (function (_super) {
        __extends(JushochiTokureiRireki_Design, _super);
        function JushochiTokureiRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JushochiTokureiRireki_Design.myLayout, fieldName);
        }
        JushochiTokureiRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JushochiTokureiRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JushochiTokureiRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JushochiTokureiRireki",
                    "items": [
                        {
                            "fieldName": "btnAdd",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "marginRight": "0px",
                            "selectControlID": "btnAdd",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "dgJushochiTokureiRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1098px",
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
                            "marginRight": "0px",
                            "selectControlID": "dgJushochiTokureiRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "192px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": true,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "適用",
                                            "combineItem": [
                                                "tekiyoDate",
                                                "tekiyoTodokedeDate",
                                                "tekiyoJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "解除",
                                            "combineItem": [
                                                "kaijoDate",
                                                "kaijoTodokedeDate",
                                                "kaijoJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "措置元情報",
                                            "combineItem": [
                                                "sochiHokenshaMeisho",
                                                "sochiHihokenshaNo"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "施設情報",
                                            "combineItem": [
                                                "nyushoDate",
                                                "taishoDate",
                                                "shisetsuShurui",
                                                "nyushoShisetsu"
                                            ]
                                        }
                                    ],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "適用日",
                                        "dataName": "tekiyoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "tekiyoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoTodokedeDate"
                                    },
                                    {
                                        "columnName": "適用事由",
                                        "dataName": "tekiyoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoJiyu"
                                    },
                                    {
                                        "columnName": "解除日",
                                        "dataName": "kaijoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "kaijoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoTodokedeDate"
                                    },
                                    {
                                        "columnName": "解除事由",
                                        "dataName": "kaijoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyu"
                                    },
                                    {
                                        "columnName": "保険者",
                                        "dataName": "sochiHokenshaMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochiHokenshaMeisho"
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "sochiHihokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 4,
                                        "cellDetails": {
                                            "cellType": 4,
                                            "maxLength": "100000000",
                                            "minLength": "0",
                                            "formatLength": "10",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochiHihokenshaNo"
                                    },
                                    {
                                        "columnName": "入所日",
                                        "dataName": "nyushoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "nyushoDate"
                                    },
                                    {
                                        "columnName": "退所日",
                                        "dataName": "taishoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "taishoDate"
                                    },
                                    {
                                        "columnName": "施設種類",
                                        "dataName": "shisetsuShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shisetsuShurui"
                                    },
                                    {
                                        "columnName": "入所施設",
                                        "dataName": "nyushoShisetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 250,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "nyushoShisetsu"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgJushochiTokureiRireki",
                            "onSelectByDblClick": "onSelectByDblClick_dgJushochiTokureiRireki",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgJushochiTokureiRireki",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgJushochiTokureiRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgJushochiTokureiRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "sochiHihokenshaNo",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
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
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "JushochiTokureiRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "JushochiTokureiRireki",
            "marginTop": "0px",
            "marginBottom": "0px",
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
                    "eventName": "onClick_btnAdd"
                },
                {
                    "eventName": "onSelect_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByDblClick_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectBySelectButton_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByModifyButton_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgJushochiTokureiRireki"
                }
            ],
            "publicEventsAlias": []
        };
        return JushochiTokureiRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.JushochiTokureiRireki_Design = JushochiTokureiRireki_Design;

    (function (JushochiTokureiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJushochiTokureiRireki = function () {
                return "onSelect_dgJushochiTokureiRireki";
            };

            Events.onSelectByDblClick_dgJushochiTokureiRireki = function () {
                return "onSelectByDblClick_dgJushochiTokureiRireki";
            };

            Events.onSelectBySelectButton_dgJushochiTokureiRireki = function () {
                return "onSelectBySelectButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByModifyButton_dgJushochiTokureiRireki = function () {
                return "onSelectByModifyButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByDeleteButton_dgJushochiTokureiRireki = function () {
                return "onSelectByDeleteButton_dgJushochiTokureiRireki";
            };
            return Events;
        })();
        JushochiTokureiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRireki = function () {
                return new UZA.Panel(this.convFiledName("JushochiTokureiRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJushochiTokureiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgJushochiTokureiRireki"));
            };
            return Controls;
        })();
        JushochiTokureiRireki.Controls = Controls;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            ModeController.prototype.TashichosonDisplayMode = function () {
                return new Modes.TashichosonDisplayMode(this.controls);
            };

            ModeController.prototype.TashichosonTeiseiDisplayMode = function () {
                return new Modes.TashichosonTeiseiDisplayMode(this.controls);
            };

            ModeController.prototype.TekiyoJogaiDisplayMode = function () {
                return new Modes.TekiyoJogaiDisplayMode(this.controls);
            };

            ModeController.prototype.TekiyoJogaiTeiseiDisplayMode = function () {
                return new Modes.TekiyoJogaiTeiseiDisplayMode(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRireki.ModeController = ModeController;
        (function (Modes) {
            var TashichosonDisplayMode = (function () {
                function TashichosonDisplayMode(controls) {
                    this.controls = controls;
                }
                TashichosonDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TashichosonDisplayMode;
            })();
            Modes.TashichosonDisplayMode = TashichosonDisplayMode;

            var TashichosonTeiseiDisplayMode = (function () {
                function TashichosonTeiseiDisplayMode(controls) {
                    this.controls = controls;
                }
                TashichosonTeiseiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonTeiseiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonTeiseiDisplayMode.prototype.IdoToroku_SelectButton = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TashichosonTeiseiDisplayMode;
            })();
            Modes.TashichosonTeiseiDisplayMode = TashichosonTeiseiDisplayMode;

            var TekiyoJogaiDisplayMode = (function () {
                function TekiyoJogaiDisplayMode(controls) {
                    this.controls = controls;
                }
                TekiyoJogaiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TekiyoJogaiDisplayMode;
            })();
            Modes.TekiyoJogaiDisplayMode = TekiyoJogaiDisplayMode;

            var TekiyoJogaiTeiseiDisplayMode = (function () {
                function TekiyoJogaiTeiseiDisplayMode(controls) {
                    this.controls = controls;
                }
                TekiyoJogaiTeiseiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().displayNone = true;

                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiTeiseiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().displayNone = false;

                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiTeiseiDisplayMode.prototype.IdoToroku_SelectButton = function () {
                    this.controls.btnAdd().displayNone = true;

                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TekiyoJogaiTeiseiDisplayMode;
            })();
            Modes.TekiyoJogaiTeiseiDisplayMode = TekiyoJogaiTeiseiDisplayMode;
        })(JushochiTokureiRireki.Modes || (JushochiTokureiRireki.Modes = {}));
        var Modes = JushochiTokureiRireki.Modes;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiRireki.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var JushochiTokureiRirekiList_Design = (function (_super) {
        __extends(JushochiTokureiRirekiList_Design, _super);
        function JushochiTokureiRirekiList_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JushochiTokureiRirekiList_Design.myLayout, fieldName);
        }
        JushochiTokureiRirekiList_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JushochiTokureiRirekiList_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JushochiTokureiRirekiList_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JushochiTokureiRirekiList",
                    "items": [
                        {
                            "fieldName": "btnAdd",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "selectControlID": "btnAdd",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgJutoku",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1070px",
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
                            "marginRight": "0px",
                            "selectControlID": "dgJutoku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "217px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "適用情報",
                                            "combineItem": [
                                                "tekiyoDate",
                                                "tekiyoTodokedeDate",
                                                "tekiyoJiyu",
                                                "tekiyoJiyuKey"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "解除情報",
                                            "combineItem": [
                                                "kaijoDate",
                                                "kaijoTodokedeDate",
                                                "kaijoJiyu",
                                                "kaijoJiyuKey"
                                            ]
                                        }
                                    ],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "state"
                                    },
                                    {
                                        "columnName": "適用日",
                                        "dataName": "tekiyoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "tekiyoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoTodokedeDate"
                                    },
                                    {
                                        "columnName": "適用事由",
                                        "dataName": "tekiyoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoJiyu"
                                    },
                                    {
                                        "columnName": "適用事由Key",
                                        "dataName": "tekiyoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoJiyuKey"
                                    },
                                    {
                                        "columnName": "解除日",
                                        "dataName": "kaijoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "kaijoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoTodokedeDate"
                                    },
                                    {
                                        "columnName": "解除事由",
                                        "dataName": "kaijoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyu"
                                    },
                                    {
                                        "columnName": "解除事由Key",
                                        "dataName": "kaijoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyuKey"
                                    },
                                    {
                                        "columnName": "所在保険者",
                                        "dataName": "shozaiHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shozaiHokensha"
                                    },
                                    {
                                        "columnName": "措置元保険者",
                                        "dataName": "sochimotoHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochimotoHokensha"
                                    },
                                    {
                                        "columnName": "旧保険者",
                                        "dataName": "kyuHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kyuHokensha"
                                    },
                                    {
                                        "columnName": "処理日時",
                                        "dataName": "shoriDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shoriDate"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgJutoku",
                            "onSelectByDblClick": "onSelectByDblClick_dgJutoku",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgJutoku",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgJutoku",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "tekiyoDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1075px",
                    "visible": true,
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
                    "marginRight": "0px",
                    "selectControlID": "JushochiTokureiRirekiList",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
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
                    "widthAuto": false,
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "JushochiTokureiRirekiList",
            "marginTop": "0px",
            "marginBottom": "0px",
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
                    "eventName": "onClick_btnAdd"
                },
                {
                    "eventName": "onSelect_dgJutoku"
                },
                {
                    "eventName": "onSelectByDblClick_dgJutoku"
                },
                {
                    "eventName": "onSelectByModifyButton_dgJutoku"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgJutoku"
                }
            ],
            "publicEventsAlias": []
        };
        return JushochiTokureiRirekiList_Design;
    })(Uz.CommonChildDiv);
    DBZ.JushochiTokureiRirekiList_Design = JushochiTokureiRirekiList_Design;

    (function (JushochiTokureiRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJutoku = function () {
                return "onSelect_dgJutoku";
            };

            Events.onSelectByDblClick_dgJutoku = function () {
                return "onSelectByDblClick_dgJutoku";
            };

            Events.onSelectByModifyButton_dgJutoku = function () {
                return "onSelectByModifyButton_dgJutoku";
            };

            Events.onSelectByDeleteButton_dgJutoku = function () {
                return "onSelectByDeleteButton_dgJutoku";
            };
            return Events;
        })();
        JushochiTokureiRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRirekiList = function () {
                return new UZA.Panel(this.convFiledName("JushochiTokureiRirekiList"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "ShoriNichijiDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.ShoriNichijiDisplayMode = function () {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRirekiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgJutoku().width = 1070;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgJutoku().width = 1030;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgJutoku().width = 1020;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgJutoku().width = 950;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgJutoku().width = 910;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgJutoku().width = 900;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgJutoku().width = 830;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgJutoku().width = 790;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgJutoku().width = 780;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgJutoku().width = 710;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgJutoku().width = 660;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgJutoku().height = 450;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgJutoku().height = 400;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgJutoku().height = 350;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgJutoku().height = 300;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgJutoku().height = 250;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgJutoku().height = 200;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(JushochiTokureiRirekiList.Modes || (JushochiTokureiRirekiList.Modes = {}));
        var Modes = JushochiTokureiRirekiList.Modes;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiRirekiList.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var ShikakuTokusoRireki_Design = (function (_super) {
        __extends(ShikakuTokusoRireki_Design, _super);
        function ShikakuTokusoRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShikakuTokusoRireki_Design.myLayout, fieldName);
        }
        ShikakuTokusoRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShikakuTokusoRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShikakuTokusoRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShikakuTokusoRireki",
                    "items": [
                        {
                            "fieldName": "btnAdd",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "selectControlID": "btnAdd",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgShikakuShutokuRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1090px",
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
                            "marginRight": "0px",
                            "selectControlID": "dgShikakuShutokuRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "217px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "取得情報",
                                            "combineItem": [
                                                "shutokuDate",
                                                "shutokuTodokedeDate",
                                                "shutokuJiyuKey",
                                                "shutokuJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "喪失情報",
                                            "combineItem": [
                                                "soshitsuDate",
                                                "soshitsuTodokedeDate",
                                                "soshitsuJiyuKey",
                                                "soshitsuJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "変更情報",
                                            "combineItem": [
                                                "henkoDate"
                                            ]
                                        }
                                    ],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "state"
                                    },
                                    {
                                        "columnName": "詳細",
                                        "dataName": "shosai",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "",
                                            "onClick": "onClickShosaiButton_dgShikakuShutokuRireki",
                                            "imageFileUrl": "/ur/urz/image/UR_Book_On.png",
                                            "imageWidth": "20",
                                            "imageHeight": "20"
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "取得日",
                                        "dataName": "shutokuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shutokuDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "shutokuTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shutokuTodokedeDate"
                                    },
                                    {
                                        "columnName": "取得事由Key",
                                        "dataName": "shutokuJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "shutokuJiyuKey"
                                    },
                                    {
                                        "columnName": "取得事由",
                                        "dataName": "shutokuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shutokuJiyu"
                                    },
                                    {
                                        "columnName": "被保区分",
                                        "dataName": "hihokenshaKubun",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 70,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "hihokenshaKubun"
                                    },
                                    {
                                        "columnName": "被保区分Key",
                                        "dataName": "hihokenshaKubunKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "hihokenshaKubunKey"
                                    },
                                    {
                                        "columnName": "喪失日",
                                        "dataName": "soshitsuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "soshitsuDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "soshitsuTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "soshitsuTodokedeDate"
                                    },
                                    {
                                        "columnName": "喪失事由Key",
                                        "dataName": "soshitsuJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "soshitsuJiyuKey"
                                    },
                                    {
                                        "columnName": "喪失事由",
                                        "dataName": "soshitsuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "soshitsuJiyu"
                                    },
                                    {
                                        "columnName": "変更日",
                                        "dataName": "henkoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": false,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoDate"
                                    },
                                    {
                                        "columnName": "住特区分",
                                        "dataName": "jutokuKubun",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 70,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jutokuKubun"
                                    },
                                    {
                                        "columnName": "所在保険者",
                                        "dataName": "shozaiHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shozaiHokensha"
                                    },
                                    {
                                        "columnName": "措置元保険者",
                                        "dataName": "sochimotoHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochimotoHokensha"
                                    },
                                    {
                                        "columnName": "旧保険者",
                                        "dataName": "kyuHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kyuHokensha"
                                    },
                                    {
                                        "columnName": "識別コード",
                                        "dataName": "shikibetsuCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shikibetsuCode"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgShikakuShutokuRireki",
                            "onSelectByDblClick": "onSelectByDblClick_dgShikakuShutokuRireki",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgShikakuShutokuRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgShikakuShutokuRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "jutokuTekiyoTodokedeDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1090px",
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
                    "marginRight": "0em",
                    "selectControlID": "ShikakuTokusoRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "onLoad_ShikakuShutokuTaishoshaJoho",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ShikakuTokusoRireki"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnJutokuTekiyo",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnShikakuShutoku",
                            "requestUrl": ""
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "mode",
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "ShikakuTokusoRireki",
            "marginTop": "0px",
            "marginBottom": "0px",
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
                    "eventName": "onSelect_dgShikakuShutokuRireki"
                },
                {
                    "eventName": "onSelectByDblClick_dgShikakuShutokuRireki"
                },
                {
                    "eventName": "onSelectByModifyButton_dgShikakuShutokuRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgShikakuShutokuRireki"
                },
                {
                    "eventName": "onClickShosaiButton_dgShikakuShutokuRireki"
                },
                {
                    "eventName": "onClick_btnAdd"
                }
            ],
            "publicEventsAlias": []
        };
        return ShikakuTokusoRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShikakuTokusoRireki_Design = ShikakuTokusoRireki_Design;

    (function (ShikakuTokusoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onLoad_ShikakuShutokuTaishoshaJoho = function () {
                return "onLoad_ShikakuShutokuTaishoshaJoho";
            };

            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgShikakuShutokuRireki = function () {
                return "onSelect_dgShikakuShutokuRireki";
            };

            Events.onSelectByDblClick_dgShikakuShutokuRireki = function () {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            };

            Events.onSelectByModifyButton_dgShikakuShutokuRireki = function () {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            };

            Events.onSelectByDeleteButton_dgShikakuShutokuRireki = function () {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            };
            return Events;
        })();
        ShikakuTokusoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuTokusoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuTokusoRireki = function () {
                return new UZA.Panel(this.convFiledName("ShikakuTokusoRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgShikakuShutokuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            };
            return Controls;
        })();
        ShikakuTokusoRireki.Controls = Controls;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        ShikakuTokusoRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1090;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1050;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1020;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 970;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 920;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 870;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 450;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 400;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 350;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 300;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 250;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 200;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(ShikakuTokusoRireki.Modes || (ShikakuTokusoRireki.Modes = {}));
        var Modes = ShikakuTokusoRireki.Modes;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuTokusoRireki.PublicProperties = PublicProperties;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var ShisetsuNyutaishoRirekiKanri_Design = (function (_super) {
        __extends(ShisetsuNyutaishoRirekiKanri_Design, _super);
        function ShisetsuNyutaishoRirekiKanri_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShisetsuNyutaishoRirekiKanri_Design.myLayout, fieldName);
        }
        ShisetsuNyutaishoRirekiKanri_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShisetsuNyutaishoRirekiKanri_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShisetsuNyutaishoRirekiKanri_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShisetsuNyutaishoRirekiKanri",
                    "items": [
                        {
                            "fieldName": "btnAddShisetsuNyutaisho",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
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
                            "selectControlID": "btnAddShisetsuNyutaisho",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAddShisetsuNyutaisho",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "dgShisetsuNyutaishoRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1030px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgShisetsuNyutaishoRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "入所日",
                                        "dataName": "nyushoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "nyushoDate"
                                    },
                                    {
                                        "columnName": "退所日",
                                        "dataName": "taishoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "施設コード",
                                        "dataName": "shisetsuCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "施設名称",
                                        "dataName": "shisetsuMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "入所施設",
                                        "dataName": "shisetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 390,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "台帳種別key",
                                        "dataName": "daichoShubetsuKey",
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
                                        "columnName": "台帳種別",
                                        "dataName": "daichoShubetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 180,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "施設種類key",
                                        "dataName": "shisetsuShuruiKey",
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
                                        "columnName": "施設種類",
                                        "dataName": "shisetsuShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgShisetsuNyutaishoRireki",
                            "onSelectByDblClick": "onSelectByDblClick_dgShisetsuNyutaishoRireki",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgShisetsuNyutaishoRireki",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgShisetsuNyutaishoRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgShisetsuNyutaishoRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "shisetsuShurui",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1035px",
                    "visible": true,
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
                    "selectControlID": "ShisetsuNyutaishoRirekiKanri",
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
                            "postParameterPanelNames": "ShisetsuNyutaishoRirekiKanri"
                        }
                    ],
                    "requestSettings": [],
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
            "controlName": "ShisetsuNyutaishoRirekiKanri",
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
                    "eventName": "onClick_btnAddShisetsuNyutaisho"
                },
                {
                    "eventName": "onSelect_dgShisetsuNyutaishoRireki"
                },
                {
                    "eventName": "onSelectByDblClick_dgShisetsuNyutaishoRireki"
                },
                {
                    "eventName": "onSelectBySelectButton_dgShisetsuNyutaishoRireki"
                },
                {
                    "eventName": "onSelectByModifyButton_dgShisetsuNyutaishoRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgShisetsuNyutaishoRireki"
                }
            ],
            "publicEventsAlias": []
        };
        return ShisetsuNyutaishoRirekiKanri_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShisetsuNyutaishoRirekiKanri_Design = ShisetsuNyutaishoRirekiKanri_Design;

    (function (ShisetsuNyutaishoRirekiKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShisetsuNyutaisho = function () {
                return "onClick_btnAddShisetsuNyutaisho";
            };

            Events.onSelect_dgShisetsuNyutaishoRireki = function () {
                return "onSelect_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDblClick_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDblClick_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectBySelectButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByModifyButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDeleteButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            };
            return Events;
        })();
        ShisetsuNyutaishoRirekiKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoRirekiKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoRirekiKanri = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoRirekiKanri"));
            };

            Controls.prototype.btnAddShisetsuNyutaisho = function () {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            };

            Controls.prototype.dgShisetsuNyutaishoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoRirekiKanri.Controls = Controls;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "表示モード",
                    "表示Heightサイズ",
                    "表示widthサイズ",
                    "台帳種別の列を"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.表示モード = function () {
                return new Modes.表示モード(this.controls);
            };

            ModeController.prototype.表示Heightサイズ = function () {
                return new Modes.表示heightサイズ(this.controls);
            };

            ModeController.prototype.表示widthサイズ = function () {
                return new Modes.表示widthサイズ(this.controls);
            };

            ModeController.prototype.台帳種別の列を = function () {
                return new Modes.台帳種別の列を(this.controls);
            };
            return ModeController;
        })();
        ShisetsuNyutaishoRirekiKanri.ModeController = ModeController;

        (function (Modes) {
            var 表示モード = (function () {
                function 表示モード(controls) {
                    this.controls = controls;
                }
                表示モード.prototype.登録 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                表示モード.prototype.照会 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = true;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                表示モード.prototype.資格異動 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 表示モード;
            })();
            Modes.表示モード = 表示モード;

            var 表示heightサイズ = (function () {
                function 表示heightサイズ(controls) {
                    this.controls = controls;
                }
                表示heightサイズ.prototype.サイズ200 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "200";
                };

                表示heightサイズ.prototype.サイズ250 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "250";
                };

                表示heightサイズ.prototype.サイズ300 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "300";
                };

                表示heightサイズ.prototype.サイズ350 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "350";
                };

                表示heightサイズ.prototype.サイズ400 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "400";
                };

                表示heightサイズ.prototype.サイズ450 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "450";
                };

                表示heightサイズ.prototype.サイズ500 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "500";
                };
                return 表示heightサイズ;
            })();
            Modes.表示heightサイズ = 表示heightサイズ;

            var 表示widthサイズ = (function () {
                function 表示widthサイズ(controls) {
                    this.controls = controls;
                }
                表示widthサイズ.prototype.モード1 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "1030";
                };

                表示widthサイズ.prototype.モード2 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "980";
                };

                表示widthサイズ.prototype.モード3 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "900";
                };

                表示widthサイズ.prototype.モード4 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "800";
                };

                表示widthサイズ.prototype.モード5 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "720";
                };
                return 表示widthサイズ;
            })();
            Modes.表示widthサイズ = 表示widthサイズ;

            var 台帳種別の列を = (function () {
                function 台帳種別の列を(controls) {
                    this.controls = controls;
                }
                台帳種別の列を.prototype.表示しない = function () {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                台帳種別の列を.prototype.表示する = function () {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 台帳種別の列を;
            })();
            Modes.台帳種別の列を = 台帳種別の列を;
        })(ShisetsuNyutaishoRirekiKanri.Modes || (ShisetsuNyutaishoRirekiKanri.Modes = {}));
        var Modes = ShisetsuNyutaishoRirekiKanri.Modes;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuNyutaishoRirekiKanri.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var ShoKaishuJokyoList_Design = (function (_super) {
        __extends(ShoKaishuJokyoList_Design, _super);
        function ShoKaishuJokyoList_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShoKaishuJokyoList_Design.myLayout, fieldName);
        }
        ShoKaishuJokyoList_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShoKaishuJokyoList_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShoKaishuJokyoList_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShoKaishuJokyoList",
                    "items": [
                        {
                            "fieldName": "dgShoKaishuJokyo",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "910px",
                            "visible": true,
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
                            "selectControlID": "dgShoKaishuJokyo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
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
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "交付証種類",
                                        "dataName": "kofushoShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 180,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付日",
                                        "dataName": "kofuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付事由Key",
                                        "dataName": "kofuJiyuKey",
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
                                        "columnName": "交付事由",
                                        "dataName": "kofuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付理由",
                                        "dataName": "kofuRiyu",
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
                                        "columnName": "回収日",
                                        "dataName": "kaishuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "回収事由Key",
                                        "dataName": "kaishuJiyuKey",
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
                                        "columnName": "回収事由",
                                        "dataName": "kaishuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "回収理由",
                                        "dataName": "kaishuRiyu",
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
                                        "columnName": "有効期限",
                                        "dataName": "yukoKigen",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "kaishuDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        }
                    ],
                    "controlType": "Panel",
                    "width": "945px",
                    "visible": true,
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
                    "selectControlID": "ShoKaishuJokyoList",
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
                            "postParameterPanelNames": "ShoKaishuJokyoList"
                        }
                    ],
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
                    "widthAuto": false,
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
            "controlName": "ShoKaishuJokyoList",
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
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return ShoKaishuJokyoList_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShoKaishuJokyoList_Design = ShoKaishuJokyoList_Design;

    (function (ShoKaishuJokyoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShoKaishuJokyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuJokyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuJokyoList = function () {
                return new UZA.Panel(this.convFiledName("ShoKaishuJokyoList"));
            };

            Controls.prototype.dgShoKaishuJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgShoKaishuJokyo"));
            };
            return Controls;
        })();
        ShoKaishuJokyoList.Controls = Controls;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "一覧パネル高さ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.一覧パネル高さ = function () {
                return new Modes.一覧パネル高さ(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoList.ModeController = ModeController;

        (function (Modes) {
            var 一覧パネル高さ = (function () {
                function 一覧パネル高さ(controls) {
                    this.controls = controls;
                }
                一覧パネル高さ.prototype.サイズ200 = function () {
                    this.controls.dgShoKaishuJokyo().height = "200";
                };

                一覧パネル高さ.prototype.サイズ250 = function () {
                    this.controls.dgShoKaishuJokyo().height = "250";
                };

                一覧パネル高さ.prototype.サイズ300 = function () {
                    this.controls.dgShoKaishuJokyo().height = "300";
                };

                一覧パネル高さ.prototype.サイズ350 = function () {
                    this.controls.dgShoKaishuJokyo().height = "350";
                };

                一覧パネル高さ.prototype.サイズ400 = function () {
                    this.controls.dgShoKaishuJokyo().height = "400";
                };

                一覧パネル高さ.prototype.サイズ450 = function () {
                    this.controls.dgShoKaishuJokyo().height = "450";
                };

                一覧パネル高さ.prototype.サイズ500 = function () {
                    this.controls.dgShoKaishuJokyo().height = "500";
                };
                return 一覧パネル高さ;
            })();
            Modes.一覧パネル高さ = 一覧パネル高さ;
        })(ShoKaishuJokyoList.Modes || (ShoKaishuJokyoList.Modes = {}));
        var Modes = ShoKaishuJokyoList.Modes;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoList.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var ShoKaishuJokyoShosai_Design = (function (_super) {
        __extends(ShoKaishuJokyoShosai_Design, _super);
        function ShoKaishuJokyoShosai_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShoKaishuJokyoShosai_Design.myLayout, fieldName);
        }
        ShoKaishuJokyoShosai_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShoKaishuJokyoShosai_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShoKaishuJokyoShosai_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShoKaishuJokyoShosai",
                    "items": [
                        {
                            "fieldName": "txtShoKofuShurui",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "160px",
                            "visible": true,
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
                            "selectControlID": "txtShoKofuShurui_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "交付証種類",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtKofuDate",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "90px",
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
                            "selectControlID": "txtKofuDate_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "交付日",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtYukoKigen",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "90px",
                            "visible": true,
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
                            "selectControlID": "txtYukoKigen_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "有効期限",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "txtKofuJiyu",
                            "items": [],
                            "controlType": "TextBox",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtKofuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "交付事由",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtKofuRiyu",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "800px",
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
                            "selectControlID": "txtKofuRiyu_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "height": "40px",
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "交付理由",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "limitLength": "200",
                            "countDisp": false
                        },
                        {
                            "fieldName": "txtKaishuDate",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
                            "width": "90px",
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
                            "selectControlID": "txtKaishuDate_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "回収日",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "ymdKubun": 2,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "ddlKaishuJiyu",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "ddlKaishuJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "回収事由",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "",
                            "dataSource": [
                                {
                                    "key": "",
                                    "value": ""
                                },
                                {
                                    "key": "00",
                                    "value": "転出"
                                },
                                {
                                    "key": "01",
                                    "value": "受給者転入"
                                },
                                {
                                    "key": "02",
                                    "value": "死亡"
                                },
                                {
                                    "key": "03",
                                    "value": "紛失等"
                                },
                                {
                                    "key": "04",
                                    "value": "汚損等"
                                },
                                {
                                    "key": "05",
                                    "value": "証記載内容変更"
                                },
                                {
                                    "key": "06",
                                    "value": "居宅サービス計画届出"
                                },
                                {
                                    "key": "07",
                                    "value": "医療保険脱退"
                                },
                                {
                                    "key": "08",
                                    "value": "適用除外施設入所"
                                },
                                {
                                    "key": "09",
                                    "value": "住所地特例適用"
                                },
                                {
                                    "key": "10",
                                    "value": "住所地特例変更"
                                },
                                {
                                    "key": "11",
                                    "value": "住所地特例解除"
                                },
                                {
                                    "key": "12",
                                    "value": "住所地特例終了"
                                },
                                {
                                    "key": "13",
                                    "value": "支払方法変更"
                                },
                                {
                                    "key": "14",
                                    "value": "支払方法変更終了"
                                },
                                {
                                    "key": "15",
                                    "value": "保険給付差止"
                                },
                                {
                                    "key": "16",
                                    "value": "保険給付差止終了"
                                },
                                {
                                    "key": "17",
                                    "value": "滞納保険料控除"
                                },
                                {
                                    "key": "18",
                                    "value": "給付額減額"
                                },
                                {
                                    "key": "19",
                                    "value": "給付額減額免除"
                                },
                                {
                                    "key": "20",
                                    "value": "給付額減額終了"
                                }
                            ],
                            "isBlankLine": false
                        },
                        {
                            "fieldName": "txtKaishuRiyu",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "800px",
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
                            "selectControlID": "txtKaishuRiyu_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "40px",
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "value": "",
                            "labelLText": "回収理由",
                            "labelRText": "",
                            "labelLWidth": "85px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "limitLength": "200",
                            "countDisp": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "942px",
                    "visible": true,
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
                    "selectControlID": "ShoKaishuJokyoShosai",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "証類交付情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ShoKaishuJokyoShosai"
                        }
                    ],
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
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 2,
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
            "controlName": "ShoKaishuJokyoShosai",
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
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return ShoKaishuJokyoShosai_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShoKaishuJokyoShosai_Design = ShoKaishuJokyoShosai_Design;

    (function (ShoKaishuJokyoShosai) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShoKaishuJokyoShosai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuJokyoShosai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuJokyoShosai = function () {
                return new UZA.Panel(this.convFiledName("ShoKaishuJokyoShosai"));
            };

            Controls.prototype.txtShoKofuShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtYukoKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            };

            Controls.prototype.txtKofuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            };

            Controls.prototype.txtKofuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            };

            Controls.prototype.txtKaishuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            };

            Controls.prototype.ddlKaishuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            };

            Controls.prototype.txtKaishuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            };
            return Controls;
        })();
        ShoKaishuJokyoShosai.Controls = Controls;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "表示方法"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.表示方法 = function () {
                return new Modes.表示方法(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoShosai.ModeController = ModeController;

        (function (Modes) {
            var 表示方法 = (function () {
                function 表示方法(controls) {
                    this.controls = controls;
                }
                表示方法.prototype.照会 = function () {
                    this.controls.ShoKaishuJokyoShosai().disabled = true;
                };

                表示方法.prototype.入力 = function () {
                    this.controls.ShoKaishuJokyoShosai().disabled = false;
                };
                return 表示方法;
            })();
            Modes.表示方法 = 表示方法;
        })(ShoKaishuJokyoShosai.Modes || (ShoKaishuJokyoShosai.Modes = {}));
        var Modes = ShoKaishuJokyoShosai.Modes;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoShosai.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onSelectByDblClick_dgShoKaishuJokyo", {
                get: function () {
                    return "onSelectByDblClick_dgShoKaishuJokyo";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnUpdateShoKaishuJokyo", {
                get: function () {
                    return "onClick_btnUpdateShoKaishuJokyo";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectBySelectButton_dgShoKaishuJokyo", {
                get: function () {
                    return "onSelectBySelectButton_dgShoKaishuJokyo";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "ShoKaishuKirokuKanri";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.ShoKaishuJokyoList = function () {
                return new DBZ.ShoKaishuJokyoList.ModeController("ShoKaishuJokyoList");
            };

            Controls.prototype.ShoKaishuJokyoShosai = function () {
                return new DBZ.ShoKaishuJokyoShosai.ModeController("ShoKaishuJokyoShosai");
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnUpdateShoKaishuJokyo = function () {
                return new UZA.Button(this.convFiledName("btnUpdateShoKaishuJokyo"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;

    var ShoKaishuKirokuKanri_Design = (function (_super) {
        __extends(ShoKaishuKirokuKanri_Design, _super);
        function ShoKaishuKirokuKanri_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShoKaishuKirokuKanri_Design.myLayout, fieldName);
        }
        Object.defineProperty(ShoKaishuKirokuKanri_Design.prototype, "onBlur_txtKaishuDate", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuDate"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuDate"] = value;
                } else {
                    this.layout.items[0].items[1]["onBlur_txtKaishuDate"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShoKaishuKirokuKanri_Design.prototype, "onChange_ddlKaishuJiyu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onChange_ddlKaishuJiyu"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onChange_ddlKaishuJiyu"] = value;
                } else {
                    this.layout.items[0].items[1]["onChange_ddlKaishuJiyu"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShoKaishuKirokuKanri_Design.prototype, "onBlur_txtKaishuRiyu", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuRiyu"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["onBlur_txtKaishuRiyu"] = value;
                } else {
                    this.layout.items[0].items[1]["onBlur_txtKaishuRiyu"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShoKaishuKirokuKanri_Design.prototype, "ShoKaishuJokyoShosai_panalDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_panelDisplay"] = value;
                } else {
                    this.layout.items[0].items[1]["ShoKaishuJokyoShosai_panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShoKaishuKirokuKanri_Design.prototype, "ShoKaishuJokyoShosai_canOpenAndClose", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_canOpenAndClose"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"])["ShoKaishuJokyoShosai_canOpenAndClose"] = value;
                } else {
                    this.layout.items[0].items[1]["ShoKaishuJokyoShosai_canOpenAndClose"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ShoKaishuKirokuKanri_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuDate");
            Uz.JSControlUtil.registProperty("onChange_ddlKaishuJiyu");
            Uz.JSControlUtil.registProperty("onBlur_txtKaishuRiyu");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_panalDisplay");
            Uz.JSControlUtil.registProperty("ShoKaishuJokyoShosai_canOpenAndClose");
        };

        ShoKaishuKirokuKanri_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["onBlur_txtKaishuDate"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onBlur_txtKaishuDate"];
            editablePropertyInfo["onChange_ddlKaishuJiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onChange_ddlKaishuJiyu"];
            editablePropertyInfo["onBlur_txtKaishuRiyu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["onBlur_txtKaishuRiyu"];
            editablePropertyInfo["ShoKaishuJokyoShosai_panalDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["ShoKaishuJokyoShosai_panelDisplay"];
            editablePropertyInfo["ShoKaishuJokyoShosai_canOpenAndClose"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["ShoKaishuJokyoShosai_canOpenAndClose"];

            return editablePropertyInfo;
        };
        ShoKaishuKirokuKanri_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShoKaishuKirokuKanri",
                    "items": [
                        {
                            "fieldName": "ShoKaishuJokyoList",
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
                            "selectControlID": "ShoKaishuJokyoList",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "businessId": "DBZ",
                            "controlName": "ShoKaishuJokyoList",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": true,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "選択",
                                        "dataName": "btnSelect",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "",
                                            "onClick": "onClick_btnSelect",
                                            "imageFileUrl": "/uz/uza/image/UZ_RowSelect_On.png",
                                            "imageWidth": "20",
                                            "imageHeight": "20"
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付証種類",
                                        "dataName": "kofushoShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 180,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付日",
                                        "dataName": "kofuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付事由Key",
                                        "dataName": "kofuJiyuKey",
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
                                        "columnName": "交付事由",
                                        "dataName": "kofuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "交付理由",
                                        "dataName": "kofuRiyu",
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
                                        "columnName": "回収日",
                                        "dataName": "kaishuDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "回収事由Key",
                                        "dataName": "kaishuJiyuKey",
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
                                        "columnName": "回収事由",
                                        "dataName": "kaishuJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "回収理由",
                                        "dataName": "kaishuRiyu",
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
                                        "columnName": "有効期限",
                                        "dataName": "yukoKigen",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "onSelectByDblClick": "onSelectByDblClick_dgShoKaishuJokyo",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgShoKaishuJokyo"
                        },
                        {
                            "fieldName": "ShoKaishuJokyoShosai",
                            "items": [],
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
                            "selectControlID": "ShoKaishuJokyoShosai",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "businessId": "DBZ",
                            "controlName": "ShoKaishuJokyoShosai",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "onBlur_txtKaishuDate": "",
                            "onChange_ddlKaishuJiyu": "",
                            "onBlur_txtKaishuRiyu": "",
                            "ShoKaishuJokyoShosai_panelDisplay": 0,
                            "ShoKaishuJokyoShosai_canOpenAndClose": true
                        },
                        {
                            "fieldName": "btnUpdateShoKaishuJokyo",
                            "items": [],
                            "controlType": "Button",
                            "width": "150",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnUpdateShoKaishuJokyo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnUpdateShoKaishuJokyo",
                            "text": "交付情報を確定する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1030",
                    "visible": true,
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
                    "selectControlID": "ShoKaishuKirokuKanri",
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
                            "postParameterPanelNames": "ShoKaishuKirokuKanri"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnSelect",
                            "requestUrl": "dbz/db/dbz/ShoKaishuKirokuKanri/onClick_btnSelect"
                        },
                        {
                            "eventName": "onClick_btnUpdateShoKaishuJokyo",
                            "requestUrl": "dbz/db/dbz/ShoKaishuKirokuKanri/onClick_btnUpdateShoKaishuJokyo"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "mode",
                            "value": ""
                        },
                        {
                            "propertyName": "selectRow",
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
            "controlName": "ShoKaishuKirokuKanri",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "ShoKaishuJokyoShosai",
                    "publicChildProperty": "onBlur_txtKaishuDate",
                    "newPropertyName": "onBlur_txtKaishuDate"
                },
                {
                    "publicChildFieldName": "ShoKaishuJokyoShosai",
                    "publicChildProperty": "onChange_ddlKaishuJiyu",
                    "newPropertyName": "onChange_ddlKaishuJiyu"
                },
                {
                    "publicChildFieldName": "ShoKaishuJokyoShosai",
                    "publicChildProperty": "onBlur_txtKaishuRiyu",
                    "newPropertyName": "onBlur_txtKaishuRiyu"
                },
                {
                    "publicChildFieldName": "ShoKaishuJokyoShosai",
                    "publicChildProperty": "ShoKaishuJokyoShosai_panelDisplay",
                    "newPropertyName": "ShoKaishuJokyoShosai_panalDisplay"
                },
                {
                    "publicChildFieldName": "ShoKaishuJokyoShosai",
                    "publicChildProperty": "ShoKaishuJokyoShosai_canOpenAndClose",
                    "newPropertyName": "ShoKaishuJokyoShosai_canOpenAndClose"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return ShoKaishuKirokuKanri_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShoKaishuKirokuKanri_Design = ShoKaishuKirokuKanri_Design;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onChange_ddlShinseishaKubun", {
                get: function () {
                    return "onChange_ddlShinseishaKubun";
                },
                enumerable: true,
                configurable: true
            });
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

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.ddlShinseishaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnHonninJohoCopy = function () {
                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtShinseishaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
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
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;

    var ShinseishaInfo_Design = (function (_super) {
        __extends(ShinseishaInfo_Design, _super);
        function ShinseishaInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShinseishaInfo_Design.myLayout, fieldName);
        }
        Object.defineProperty(ShinseishaInfo_Design.prototype, "btnJigyoshaInputGuide_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[5]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "txtUkestukeDate_displayNone", {
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


        Object.defineProperty(ShinseishaInfo_Design.prototype, "title", {
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


        Object.defineProperty(ShinseishaInfo_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "txtJigyoshaNo_disabled", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"])["disabled"] = value;
                } else {
                    this.layout.items[0].items[4]["disabled"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "txtShinseishaName_labelLText", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["labelLText"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"])["labelLText"] = value;
                } else {
                    this.layout.items[0].items[8]["labelLText"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "txtYubinNo_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[11]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "txtAddress_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[12]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "btnJigyoshaInputGuide_disabled", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["disabled"] = value;
                } else {
                    this.layout.items[0].items[5]["disabled"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShinseishaInfo_Design.prototype, "shinseishaInfo_eraseBorder", {
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


        ShinseishaInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_displayNone");
            Uz.JSControlUtil.registProperty("txtUkestukeDate_displayNone");
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("txtJigyoshaNo_disabled");
            Uz.JSControlUtil.registProperty("txtShinseishaName_labelLText");
            Uz.JSControlUtil.registProperty("txtYubinNo_displayNone");
            Uz.JSControlUtil.registProperty("txtAddress_displayNone");
            Uz.JSControlUtil.registProperty("btnJigyoshaInputGuide_disabled");
            Uz.JSControlUtil.registProperty("shinseishaInfo_eraseBorder");
        };

        ShinseishaInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnJigyoshaInputGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtUkestukeDate_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["txtJigyoshaNo_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[4]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["txtShinseishaName_labelLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[8]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["txtYubinNo_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["txtAddress_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["btnJigyoshaInputGuide_disabled"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["disabled"];
            editablePropertyInfo["shinseishaInfo_eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];

            return editablePropertyInfo;
        };
        ShinseishaInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShinseishaInfo",
                    "items": [
                        {
                            "fieldName": "txtShinseiDate",
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
                            "selectControlID": "txtShinseiDate_core",
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
                            "labelLText": "申請日",
                            "labelRText": "",
                            "labelLWidth": "65px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": "",
                            "textKind": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "ddlShinseishaKubun",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "150px",
                            "visible": true,
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
                            "marginRight": "XS",
                            "selectControlID": "ddlShinseishaKubun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
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
                                },
                                {
                                    "key": "blank",
                                    "value": ""
                                }
                            ],
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "onChange_ddlShinseishaKubun",
                            "labelLText": "申請者区分",
                            "labelRText": "",
                            "labelLWidth": "90px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "myself",
                            "isBlankLine": false,
                            "disabledItem": []
                        },
                        {
                            "fieldName": "txtUketsukeDate",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "90px",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtUketsukeDate_core",
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
                            "labelLText": "受付日",
                            "labelRText": "",
                            "labelLWidth": "55px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": "",
                            "textKind": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtShinseiRiyu",
                            "items": [],
                            "controlType": "TextBoxMultiLine",
                            "width": "560px",
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
                            "selectControlID": "txtShinseiRiyu_text_area",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "申請理由",
                            "labelRText": "",
                            "labelLWidth": "65px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textKind": 0,
                            "limitLength": "200",
                            "countDisp": true
                        },
                        {
                            "fieldName": "txtJigyoshaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "85px",
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
                            "selectControlID": "txtJigyoshaNo_core",
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
                            "labelLText": "事業者",
                            "labelRText": "",
                            "labelLWidth": "65px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": "",
                            "formatLength": "10"
                        },
                        {
                            "fieldName": "btnJigyoshaInputGuide",
                            "items": [],
                            "controlType": "ButtonDialog",
                            "width": "S",
                            "visible": true,
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
                            "text": "ButtonDialog1",
                            "onClick": "",
                            "icon": 0,
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
                                    "controlName": "txtJigyoshaNo"
                                },
                                {
                                    "key": "jigyoshaMeisho",
                                    "controlName": "txtShinseishaName"
                                }
                            ],
                            "visibleCloseButton": true,
                            "onOkClose": "",
                            "onBeforeOpenDialog": ""
                        },
                        {
                            "fieldName": "btnHonninJohoCopy",
                            "items": [],
                            "controlType": "Button",
                            "width": "200px",
                            "visible": true,
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
                            "selectControlID": "btnHonninJohoCopy",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "本人情報をコピーする",
                            "onClick": "",
                            "icon": 0,
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "ddlHokensha",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "120px",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "ddlHokensha_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "key0",
                                    "value": "value0"
                                },
                                {
                                    "key": "key1",
                                    "value": "value1"
                                }
                            ],
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "保険者",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": "key0",
                            "isBlankLine": false,
                            "disabledItem": []
                        },
                        {
                            "fieldName": "txtShinseishaNameKana",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "355px",
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
                            "selectControlID": "txtShinseishaNameKana_core",
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
                            "labelLText": "氏名",
                            "labelRText": "",
                            "labelLWidth": "65px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtShinseishaName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "355px",
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
                            "marginLeft": "73px",
                            "marginRight": "XS",
                            "selectControlID": "txtShinseishaName_core",
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
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "80px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtTelNo",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "S",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "0.3em",
                            "marginRight": "XS",
                            "selectControlID": "txtTelNo_core",
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
                            "labelLText": "電話番号",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtYubinNo",
                            "items": [],
                            "controlType": "TextBoxYubinNo",
                            "width": "65px",
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
                            "selectControlID": "txtYubinNo_core",
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
                            "labelLText": "住所",
                            "labelRText": "",
                            "labelLWidth": "65px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtAddress",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "481px",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "-0.2em",
                            "marginRight": "XS",
                            "selectControlID": "txtAddress_core",
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
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "645px",
                    "visible": true,
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
                    "marginRight": "XS",
                    "selectControlID": "ShinseishaInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "申請者情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 1,
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
            "controlName": "ShinseishaInfo",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "btnJigyoshaInputGuide",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnJigyoshaInputGuide_displayNone"
                },
                {
                    "publicChildFieldName": "txtUketsukeDate",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "txtUkestukeDate_displayNone"
                },
                {
                    "publicChildFieldName": "ShinseishaInfo",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "ShinseishaInfo",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                },
                {
                    "publicChildFieldName": "txtJigyoshaNo",
                    "publicChildProperty": "disabled",
                    "newPropertyName": "txtJigyoshaNo_disabled"
                },
                {
                    "publicChildFieldName": "txtShinseishaNameKana",
                    "publicChildProperty": "labelLText",
                    "newPropertyName": "txtShinseishaName_labelLText"
                },
                {
                    "publicChildFieldName": "txtYubinNo",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "txtYubinNo_displayNone"
                },
                {
                    "publicChildFieldName": "txtAddress",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "txtAddress_displayNone"
                },
                {
                    "publicChildFieldName": "btnJigyoshaInputGuide",
                    "publicChildProperty": "disabled",
                    "newPropertyName": "btnJigyoshaInputGuide_disabled"
                },
                {
                    "publicChildFieldName": "ShinseishaInfo",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "shinseishaInfo_eraseBorder"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": ""
        };
        return ShinseishaInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShinseishaInfo_Design = ShinseishaInfo_Design;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShinseishaInfo.ModeController = ModeController;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnJigyoshaInputGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtUkestukeDate_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtJigyoshaNo_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShinseishaName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtYubinNo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtAddress_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnJigyoshaInputGuide_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("shinseishaInfo_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_displayNone = function () {
                return this.controls.btnJigyoshaInputGuide().displayNone;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_displayNone = function (value) {
                this.controls.btnJigyoshaInputGuide().displayNone = value;
            };

            PublicProperties.prototype.gettxtUkestukeDate_displayNone = function () {
                return this.controls.txtUketsukeDate().displayNone;
            };

            PublicProperties.prototype.settxtUkestukeDate_displayNone = function (value) {
                this.controls.txtUketsukeDate().displayNone = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.ShinseishaInfo().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.ShinseishaInfo().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.ShinseishaInfo().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.ShinseishaInfo().panelDisplay = value;
            };

            PublicProperties.prototype.gettxtJigyoshaNo_disabled = function () {
                return this.controls.txtJigyoshaNo().disabled;
            };

            PublicProperties.prototype.settxtJigyoshaNo_disabled = function (value) {
                this.controls.txtJigyoshaNo().disabled = value;
            };

            PublicProperties.prototype.gettxtShinseishaName_labelLText = function () {
                return this.controls.txtShinseishaNameKana().labelLText;
            };

            PublicProperties.prototype.settxtShinseishaName_labelLText = function (value) {
                this.controls.txtShinseishaNameKana().labelLText = value;
            };

            PublicProperties.prototype.gettxtYubinNo_displayNone = function () {
                return this.controls.txtYubinNo().displayNone;
            };

            PublicProperties.prototype.settxtYubinNo_displayNone = function (value) {
                this.controls.txtYubinNo().displayNone = value;
            };

            PublicProperties.prototype.gettxtAddress_displayNone = function () {
                return this.controls.txtAddress().displayNone;
            };

            PublicProperties.prototype.settxtAddress_displayNone = function (value) {
                this.controls.txtAddress().displayNone = value;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_disabled = function () {
                return this.controls.btnJigyoshaInputGuide().disabled;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_disabled = function (value) {
                this.controls.btnJigyoshaInputGuide().disabled = value;
            };

            PublicProperties.prototype.getshinseishaInfo_eraseBorder = function () {
                return this.controls.ShinseishaInfo().eraseBorder;
            };

            PublicProperties.prototype.setshinseishaInfo_eraseBorder = function (value) {
                this.controls.ShinseishaInfo().eraseBorder = value;
            };
            return PublicProperties;
        })();
        ShinseishaInfo.PublicProperties = PublicProperties;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var KozaPayment_Design = (function (_super) {
        __extends(KozaPayment_Design, _super);
        function KozaPayment_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KozaPayment_Design.myLayout, fieldName);
        }
        Object.defineProperty(KozaPayment_Design.prototype, "title", {
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


        Object.defineProperty(KozaPayment_Design.prototype, "eraseBorder", {
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


        Object.defineProperty(KozaPayment_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KozaPayment_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
        };

        KozaPayment_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];

            return editablePropertyInfo;
        };
        KozaPayment_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KozaPayment",
                    "items": [
                        {
                            "fieldName": "txtKinyuKikanCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "32px",
                            "visible": true,
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
                            "selectControlID": "txtKinyuKikanCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "金融機関",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "4"
                        },
                        {
                            "fieldName": "txtKinyuKikanName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "220px",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "-0.2em",
                            "marginRight": "XS",
                            "selectControlID": "txtKinyuKikanName_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "radKozaShubetsu",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "210px",
                            "visible": true,
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
                            "selectControlID": "radKozaShubetsu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "onChange": "",
                            "labelLText": "口座種別",
                            "labelLWidth": "70px",
                            "labelLAlign": 2,
                            "onClick": "",
                            "icon": [],
                            "dataSource": [
                                {
                                    "key": "futsu",
                                    "value": "普通"
                                },
                                {
                                    "key": "toza",
                                    "value": "当座"
                                },
                                {
                                    "key": "other",
                                    "value": "その他"
                                }
                            ],
                            "selectedItem": null,
                            "newLineItemNumber": 3,
                            "spaceSize": "S",
                            "disabledItem": []
                        },
                        {
                            "fieldName": "txtKozaMeigininKana",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "250px",
                            "visible": true,
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
                            "marginRight": "XS",
                            "selectControlID": "txtKozaMeigininKana_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "口座名義人",
                            "labelRText": "",
                            "labelLWidth": "90px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKinyuKikanBrunchCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "32px",
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
                            "selectControlID": "txtKinyuKikanBrunchCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "支店",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "3"
                        },
                        {
                            "fieldName": "txtKinyuKikanBrunchName",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "220px",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "-0.2em",
                            "marginRight": "XS",
                            "selectControlID": "txtKinyuKikanBrunchName_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKozaNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "60px",
                            "visible": true,
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
                            "selectControlID": "txtKozaNo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "isComboBox": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "口座番号",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "7"
                        },
                        {
                            "fieldName": "txtKozaMeiginin",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "250px",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "14.8em",
                            "marginRight": "XS",
                            "selectControlID": "txtKozaMeiginin_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
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
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "80px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1013px",
                    "visible": true,
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
                    "selectControlID": "KozaPayment",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "口座払い",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
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
            "controlName": "KozaPayment",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
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
        return KozaPayment_Design;
    })(Uz.CommonChildDiv);
    DBZ.KozaPayment_Design = KozaPayment_Design;

    (function (KozaPayment) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KozaPayment.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KozaPayment";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KozaPayment = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            };

            Controls.prototype.txtKozaMeigininKana = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            };

            Controls.prototype.txtKinyuKikanBrunchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            };

            Controls.prototype.txtKinyuKikanBrunchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            };
            return Controls;
        })();
        KozaPayment.Controls = Controls;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KozaPayment.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KozaPayment.ModeController = ModeController;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KozaPayment.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KozaPayment().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KozaPayment().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KozaPayment().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KozaPayment().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KozaPayment().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KozaPayment().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KozaPayment.PublicProperties = PublicProperties;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentMethod.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "PaymentMethod";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.KozaPayment = function () {
                return new DBZ.KozaPayment.ModeController("KozaPayment");
            };

            Controls.prototype.PaymentMethod = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radPayMethod1 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));
            };

            Controls.prototype.JuryoininJoho = function () {
                return new UZA.Panel(this.convFiledName("JuryoininJoho"));
            };

            Controls.prototype.txtJuryoininKeiyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtJigyoshaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));
            };

            Controls.prototype.radPayMethod2 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));
            };

            Controls.prototype.radPayMethod3 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));
            };

            Controls.prototype.MadoguchiPayment = function () {
                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtShiharaiKaishiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));
            };

            Controls.prototype.txtShiharaiKaishiDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));
            };

            Controls.prototype.txtShiharaiKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            };

            Controls.prototype.txtShiharaiShuryoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));
            };

            Controls.prototype.txtShiharaiShuryoDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));
            };

            Controls.prototype.txtShiharaiShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        PaymentMethod.Controls = Controls;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;

    var PaymentMethod_Design = (function (_super) {
        __extends(PaymentMethod_Design, _super);
        function PaymentMethod_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, PaymentMethod_Design.myLayout, fieldName);
        }
        Object.defineProperty(PaymentMethod_Design.prototype, "title", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "KozaPayment_title", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"])["title"] = value;
                } else {
                    this.layout.items[0].items[3]["title"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "onClick_radPayMethod", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[0]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Juryoinin_displayNone", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "Madoguchi_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[5]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(PaymentMethod_Design.prototype, "Koza_displayNone", {
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


        Object.defineProperty(PaymentMethod_Design.prototype, "eraseBorder", {
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


        PaymentMethod_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("panelDisplay");
            Uz.JSControlUtil.registProperty("KozaPayment_title");
            Uz.JSControlUtil.registProperty("onClick_radPayMethod");
            Uz.JSControlUtil.registProperty("Juryoinin_displayNone");
            Uz.JSControlUtil.registProperty("Madoguchi_displayNone");
            Uz.JSControlUtil.registProperty("Koza_displayNone");
            Uz.JSControlUtil.registProperty("eraseBorder");
        };

        PaymentMethod_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];
            editablePropertyInfo["KozaPayment_title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["onClick_radPayMethod"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["Juryoinin_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Madoguchi_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[5]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["Koza_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];

            return editablePropertyInfo;
        };
        PaymentMethod_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "PaymentMethod",
                    "items": [
                        {
                            "fieldName": "radPayMethod1",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
                            "visible": true,
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
                            "selectControlID": "radPayMethod1_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToJuryoinin",
                                    "value": "受領委任払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": "payToJuryoinin",
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "JuryoininJoho",
                            "items": [
                                {
                                    "fieldName": "txtJuryoininKeiyakuNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "80px",
                                    "visible": true,
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
                                    "selectControlID": "txtJuryoininKeiyakuNo_core",
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
                                    "labelLText": "契約番号",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtJigyoshaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "80px",
                                    "visible": true,
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
                                    "selectControlID": "txtJigyoshaNo_core",
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
                                    "labelLText": "事業者",
                                    "labelRText": "",
                                    "labelLWidth": "55px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtJigyoshaName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "-0.2em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtJigyoshaName_core",
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
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtJigyoshaNameKana",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "L",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "20.1em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtJigyoshaNameKana_core",
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
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "845px",
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
                            "selectControlID": "JuryoininJoho",
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
                                    "postParameterPanelNames": "JuryoininJoho"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "canPost": true,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "radPayMethod2",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
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
                            "selectControlID": "radPayMethod2_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToKoza",
                                    "value": "口座払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "KozaPayment",
                            "items": [],
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
                            "marginRight": "0em",
                            "selectControlID": "KozaPayment",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "title": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "KozaPayment",
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
                            "panelDisplay": 2,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        },
                        {
                            "fieldName": "radPayMethod3",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "150px",
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
                            "selectControlID": "radPayMethod3_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "dataSource": [
                                {
                                    "key": "payToMadoguchi",
                                    "value": "窓口払い"
                                }
                            ],
                            "onChange": "",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "MadoguchiPayment",
                            "items": [
                                {
                                    "fieldName": "txtShiharaiBasho",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "445px",
                                    "visible": true,
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
                                    "selectControlID": "txtShiharaiBasho_core",
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
                                    "labelLText": "支払場所",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtShiharaiKaishiDate_core",
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
                                    "labelLText": "開始日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30px",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "-0.5em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiKaishiDay_core",
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
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13px",
                                    "labelRWidth": "13px",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiKaishiTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
                                    "width": "50px",
                                    "visible": true,
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
                                    "selectControlID": "txtShiharaiKaishiTime_core",
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
                                    "labelLText": "開始時間",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "displayFormat": 1,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "timeKubun": 1
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtShiharaiShuryoDate_core",
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
                                    "labelLText": "終了日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoDay",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "30px",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "-0.5em",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShiharaiShuryoDay_core",
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
                                    "labelLText": "（",
                                    "labelRText": "）",
                                    "labelLWidth": "13px",
                                    "labelRWidth": "13px",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 1,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShiharaiShuryoTime",
                                    "items": [],
                                    "controlType": "TextBoxTime",
                                    "width": "50px",
                                    "visible": true,
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
                                    "selectControlID": "txtShiharaiShuryoTime_core",
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
                                    "labelLText": "終了時間",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "displayFormat": 1,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "timeKubun": 1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "G2",
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
                            "selectControlID": "MadoguchiPayment",
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
                                    "postParameterPanelNames": "MadoguchiPayment"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": true,
                            "panelDisplay": 2,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "canPost": true,
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1040px",
                    "visible": true,
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
                    "marginRight": "XS",
                    "selectControlID": "PaymentMethod",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "支払方法",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 1,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
                    "canPost": true,
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false
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
            "controlName": "PaymentMethod",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "title",
                    "newPropertyName": "KozaPayment_title"
                },
                {
                    "publicChildFieldName": "radPayMethod1",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "onClick_radPayMethod"
                },
                {
                    "publicChildFieldName": "JuryoininJoho",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Juryoinin_displayNone"
                },
                {
                    "publicChildFieldName": "MadoguchiPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Madoguchi_displayNone"
                },
                {
                    "publicChildFieldName": "KozaPayment",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "Koza_displayNone"
                },
                {
                    "publicChildFieldName": "PaymentMethod",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": ""
        };
        return PaymentMethod_Design;
    })(Uz.CommonChildDiv);
    DBZ.PaymentMethod_Design = PaymentMethod_Design;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        PaymentMethod.ModeController = ModeController;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.PaymentMethod().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.PaymentMethod().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentMethod().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentMethod().panelDisplay = value;
            };

            PublicProperties.prototype.getonClick_radPayMethod = function () {
                return this.controls.radPayMethod1().onClick;
            };

            PublicProperties.prototype.setonClick_radPayMethod = function (value) {
                this.controls.radPayMethod1().onClick = value;
            };

            PublicProperties.prototype.getJuryoinin_displayNone = function () {
                return this.controls.JuryoininJoho().displayNone;
            };

            PublicProperties.prototype.setJuryoinin_displayNone = function (value) {
                this.controls.JuryoininJoho().displayNone = value;
            };

            PublicProperties.prototype.getMadoguchi_displayNone = function () {
                return this.controls.MadoguchiPayment().displayNone;
            };

            PublicProperties.prototype.setMadoguchi_displayNone = function (value) {
                this.controls.MadoguchiPayment().displayNone = value;
            };

            PublicProperties.prototype.getKoza_displayNone = function () {
                return this.controls.KozaPayment().Properties().displayNone;
            };

            PublicProperties.prototype.setKoza_displayNone = function (value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.PaymentMethod().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.PaymentMethod().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    var KogakuServicehiJudgementResult_Design = (function (_super) {
        __extends(KogakuServicehiJudgementResult_Design, _super);
        function KogakuServicehiJudgementResult_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KogakuServicehiJudgementResult_Design.myLayout, fieldName);
        }
        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "title", {
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


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "eraseBorder", {
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


        Object.defineProperty(KogakuServicehiJudgementResult_Design.prototype, "panelDisplay", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["panelDisplay"] = value;
                } else {
                    this.layout.items[0]["panelDisplay"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        KogakuServicehiJudgementResult_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorder");
            Uz.JSControlUtil.registProperty("panelDisplay");
        };

        KogakuServicehiJudgementResult_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorder"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorder"];
            editablePropertyInfo["panelDisplay"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["panelDisplay"];

            return editablePropertyInfo;
        };
        KogakuServicehiJudgementResult_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KogakuServicehiJudgementResult",
                    "items": [
                        {
                            "fieldName": "dgJudgementResult",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "980px",
                            "visible": true,
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
                            "selectControlID": "dgJudgementResult",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 1
                                },
                                "columns": [
                                    {
                                        "columnName": "事業者",
                                        "dataName": "txtJigyosha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 295,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJigyosha"
                                    },
                                    {
                                        "columnName": "サービス種類",
                                        "dataName": "txtServiceShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 190,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtServiceShurui"
                                    },
                                    {
                                        "columnName": "サービス<br>費用合計",
                                        "dataName": "txtServiceHiyoTotal",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 95,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtServiceHiyoTotal"
                                    },
                                    {
                                        "columnName": "利用者<br>負担額合計",
                                        "dataName": "txtRiyoshaFutanTotalAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtRiyoshaFutanTotalAmount"
                                    },
                                    {
                                        "columnName": "算定<br>基準額",
                                        "dataName": "txtSanteiKijunAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtSanteiKijunAmount"
                                    },
                                    {
                                        "columnName": "支払済<br>金額",
                                        "dataName": "txtShiharaizumiAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShiharaizumiAmount"
                                    },
                                    {
                                        "columnName": "高額<br>支給額",
                                        "dataName": "txtKogakuShikyuAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKogakuShikyuAmount"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "txtKogakuShikyuAmount",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "KogakuServicehiJudgementResultDetail1",
                            "items": [
                                {
                                    "fieldName": "txtUketsukeDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtUketsukeDate_core",
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
                                    "labelLText": "受付日",
                                    "labelRText": "",
                                    "labelLWidth": "96px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtHonninPaymentAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "S",
                                    "visible": true,
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
                                    "selectControlID": "txtHonninPaymentAmount_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "本人支払額",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "+-,.\\",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": true,
                                    "decimalPointLength": 0
                                },
                                {
                                    "fieldName": "txtKetteiDate",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "90px",
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
                                    "selectControlID": "txtKetteiDate_core",
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
                                    "labelLText": "決定日",
                                    "labelRText": "",
                                    "labelLWidth": "96px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "radShikyuKubun",
                                    "items": [],
                                    "controlType": "RadioButton",
                                    "width": "150px",
                                    "visible": true,
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
                                    "selectControlID": "radShikyuKubun_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "labelLText": "支給区分",
                                    "labelLWidth": "80px",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "icon": [],
                                    "dataSource": [
                                        {
                                            "key": "shikyu",
                                            "value": "支給"
                                        },
                                        {
                                            "key": "Fushikyu",
                                            "value": "不支給"
                                        }
                                    ],
                                    "selectedItem": "shikyu",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "S",
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtsetaiShuyakuNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "80px",
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
                                    "selectControlID": "txtsetaiShuyakuNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "世帯集約番号",
                                    "labelRText": "",
                                    "labelLWidth": "96px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtShikyuAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "S",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "M",
                                    "marginRight": "XS",
                                    "selectControlID": "txtShikyuAmount_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "支給金額",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "+-,.\\",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": true,
                                    "decimalPointLength": 0
                                },
                                {
                                    "fieldName": "radIsKogakuAutoShokan",
                                    "items": [],
                                    "controlType": "RadioButton",
                                    "width": "M",
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
                                    "selectControlID": "radIsKogakuAutoShokan_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "labelLText": "高額自動償還",
                                    "labelLWidth": "96px",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "icon": [],
                                    "dataSource": [
                                        {
                                            "key": "ari",
                                            "value": "あり"
                                        },
                                        {
                                            "key": "nashi",
                                            "value": "なし"
                                        }
                                    ],
                                    "selectedItem": "ari",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "M",
                                    "disabledItem": []
                                }
                            ],
                            "controlType": "Panel",
                            "width": "485px",
                            "visible": true,
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
                            "selectControlID": "KogakuServicehiJudgementResultDetail1",
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
                                    "postParameterPanelNames": "KogakuServicehiJudgementResultDetail1"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
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
                            "canPost": true
                        },
                        {
                            "fieldName": "KogakuServicehiJudgementResultDetail2",
                            "items": [
                                {
                                    "fieldName": "txtBiko",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtBiko_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "required": false,
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
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "備考",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "radJudgementMethod",
                                    "items": [],
                                    "controlType": "RadioButton",
                                    "width": "180px",
                                    "visible": true,
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
                                    "selectControlID": "radJudgementMethod_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "labelLText": "審査方法",
                                    "labelLWidth": "80px",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "icon": [],
                                    "dataSource": [
                                        {
                                            "key": "mishinsa",
                                            "value": "審査依頼"
                                        },
                                        {
                                            "key": "shinsaZumi",
                                            "value": "審査済み"
                                        }
                                    ],
                                    "selectedItem": "shinsaZumi",
                                    "newLineItemNumber": 2,
                                    "spaceSize": "S",
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtFushikyuRiyu",
                                    "items": [],
                                    "controlType": "TextBoxMultiLine",
                                    "width": "380px",
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
                                    "selectControlID": "txtFushikyuRiyu_text_area",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "XS",
                                    "required": false,
                                    "maxLength": "10000000000",
                                    "minLength": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "value": "",
                                    "labelLText": "不支給理由",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "limitLength": "100",
                                    "countDisp": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "490px",
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
                            "marginLeft": "-1.6em",
                            "marginRight": "XS",
                            "selectControlID": "KogakuServicehiJudgementResultDetail2",
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
                                    "postParameterPanelNames": "KogakuServicehiJudgementResultDetail2"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
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
                            "canPost": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "993px",
                    "visible": true,
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
                    "marginRight": "XS",
                    "selectControlID": "KogakuServicehiJudgementResult",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "判定結果",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KogakuServicehiJudgementResult"
                        }
                    ],
                    "requestSettings": [],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
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
            "controlName": "KogakuServicehiJudgementResult",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "title",
                    "newPropertyName": "title"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "eraseBorder",
                    "newPropertyName": "eraseBorder"
                },
                {
                    "publicChildFieldName": "KogakuServicehiJudgementResult",
                    "publicChildProperty": "panelDisplay",
                    "newPropertyName": "panelDisplay"
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
        return KogakuServicehiJudgementResult_Design;
    })(Uz.CommonChildDiv);
    DBZ.KogakuServicehiJudgementResult_Design = KogakuServicehiJudgementResult_Design;

    (function (KogakuServicehiJudgementResult) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiJudgementResult.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiJudgementResult";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiJudgementResult = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJudgementResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail1 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtHonninPaymentAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.radShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            };

            Controls.prototype.txtsetaiShuyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            };

            Controls.prototype.txtShikyuAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            };

            Controls.prototype.radIsKogakuAutoShokan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail2 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            };

            Controls.prototype.radJudgementMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            };

            Controls.prototype.txtFushikyuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            };
            return Controls;
        })();
        KogakuServicehiJudgementResult.Controls = Controls;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiJudgementResult.ModeController = ModeController;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiJudgementResult().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiJudgementResult().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiJudgementResult().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiJudgementResult().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiJudgementResult().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiJudgementResult().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiJudgementResult.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
