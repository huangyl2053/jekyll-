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
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "台帳種別",
                            "labelRText": "",
                            "labelLWidth": "70px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": null,
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
                            "onClick": "",
                            "icon": [],
                            "required": false,
                            "onChange": "onChange_radShisetsuShurui",
                            "labelLText": "施設種類",
                            "labelLWidth": "70px",
                            "labelLAlign": 2,
                            "selectedItem": null,
                            "newLineItemNumber": 3,
                            "spaceSize": "S",
                            "disabledItem": []
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
                            "text": "",
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "labelLText": "入所施設",
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
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "text": "",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
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
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "text": "■",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "20px",
                            "imageHeight": "15px",
                            "icon": 0,
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
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "text": "■",
                            "appearance": 2,
                            "imageFileUrl": "/uz/uza/image/UZ_Search.png",
                            "imageWidth": "20px",
                            "imageHeight": "15px",
                            "icon": 0,
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
                            "text": "",
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
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
                return new UZA.Panel(this.convFiledNameSelf());
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
                    "入力補助",
                    "表示モード"
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

            ModeController.prototype.表示モード = function () {
                return new Modes.表示モード(this.controls);
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

            var 表示モード = (function () {
                function 表示モード(controls) {
                    this.controls = controls;
                }
                表示モード.prototype.defaultView = function () {
                    this.controls.ShisetsuJoho().readOnly = false;
                    this.controls.ShisetsuJoho().displayNone = false;
                };

                表示モード.prototype.readOnly = function () {
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = false;
                };

                表示モード.prototype.displayNone = function () {
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = true;
                };
                return 表示モード;
            })();
            Modes.表示モード = 表示モード;
        })(ShisetsuJoho.Modes || (ShisetsuJoho.Modes = {}));
        var Modes = ShisetsuJoho.Modes;
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
                        },
                        {
                            "fieldName": "HenkoInput",
                            "items": [
                                {
                                    "fieldName": "txtHenkoDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtHenkoDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "変更日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": ""
                                },
                                {
                                    "fieldName": "txtHenkoTodokedeDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtHenkoTodokedeDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "変更届出日",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": ""
                                },
                                {
                                    "fieldName": "ddlHenkoJiyu",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "ddlHenkoJiyu_core",
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
                                    "labelLText": "変更事由",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "",
                                    "isBlankLine": true
                                },
                                {
                                    "fieldName": "HenkoHokenshaJoho",
                                    "items": [
                                        {
                                            "fieldName": "ddlHenkoShozaiHokensha",
                                            "items": [],
                                            "controlType": "DropDownList",
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
                                            "selectControlID": "ddlHenkoShozaiHokensha_core",
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
                                            "labelLText": "所在保険者",
                                            "labelRText": "",
                                            "labelLWidth": "80px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlHenkoSochimotoHokensha",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "ddlHenkoSochimotoHokensha_core",
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
                                            "labelLText": "措置元保険者",
                                            "labelRText": "",
                                            "labelLWidth": "100px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlHenkoKyuHokensha",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "ddlHenkoKyuHokensha_core",
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
                                            "labelLText": "旧保険者",
                                            "labelRText": "",
                                            "labelLWidth": "70px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlJuminJoho",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "750px",
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
                                            "selectControlID": "ddlJuminJoho_core",
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
                                            "labelLText": "住民情報",
                                            "labelRText": "",
                                            "labelLWidth": "80px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
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
                                    "selectControlID": "HenkoHokenshaJoho",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "保険者",
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
                                    "widthAuto": true,
                                    "panelDisplay": 1,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "focusPositionID": "labelRTextProperty",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "btnHenkoKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnHenkoKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnHenkoKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnHenkoTorikeshi",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnHenkoTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnHenkoTorikeshi",
                                    "text": "取消する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
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
                            "selectControlID": "HenkoInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "資格変更入力",
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
                            "readOnly": true,
                            "height": "Auto",
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "880px",
                    "visible": true,
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

            Events.onClick_btnHenkoKakutei = function () {
                return "onClick_btnHenkoKakutei";
            };

            Events.onClick_btnHenkoTorikeshi = function () {
                return "onClick_btnHenkoTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgHenko = function () {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            };

            Controls.prototype.HenkoInput = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput"));
            };

            Controls.prototype.txtHenkoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoDate"));
            };

            Controls.prototype.txtHenkoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTodokedeDate"));
            };

            Controls.prototype.ddlHenkoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoJiyu"));
            };

            Controls.prototype.HenkoHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput_HenkoHokenshaJoho"));
            };

            Controls.prototype.ddlHenkoShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoShozaiHokensha"));
            };

            Controls.prototype.ddlHenkoSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoSochimotoHokensha"));
            };

            Controls.prototype.ddlHenkoKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoKyuHokensha"));
            };

            Controls.prototype.ddlJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJuminJoho"));
            };

            Controls.prototype.btnHenkoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnHenkoKakutei"));
            };

            Controls.prototype.btnHenkoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnHenkoTorikeshi"));
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
                    "MeisaiMode",
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

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
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

                    this.controls.HenkoHokenshaJoho().displayNone = true;
                    this.controls.ddlHenkoShozaiHokensha().displayNone = true;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoShozaiHokensha().displayNone = true;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoShozaiHokensha().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = false;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoShozaiHokensha().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = false;

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

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.shokai = function () {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoShozaiHokensha().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = true;
                    this.controls.btnHenkoTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.toroku = function () {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = false;
                    this.controls.txtHenkoTodokedeDate().readOnly = false;
                    this.controls.ddlHenkoJiyu().readOnly = false;
                    this.controls.ddlHenkoShozaiHokensha().readOnly = false;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = false;
                    this.controls.ddlHenkoKyuHokensha().readOnly = false;
                    this.controls.ddlJuminJoho().readOnly = false;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoShozaiHokensha().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;

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
                        },
                        {
                            "fieldName": "IryoHokenInput",
                            "items": [
                                {
                                    "fieldName": "txtIryoHokenKanyuDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtIryoHokenKanyuDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "加入日",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
                                    "labelRWidth": "0px",
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
                                    "fieldName": "txtIryoHokenDattaiDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtIryoHokenDattaiDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "脱退日",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
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
                                    "fieldName": "ddlIryoHokenShubetsu",
                                    "items": [],
                                    "controlType": "DropDownList",
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
                                    "selectControlID": "ddlIryoHokenShubetsu_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "kyokai",
                                            "value": "協会健康保険"
                                        },
                                        {
                                            "key": "kumiai",
                                            "value": "組合健康保険"
                                        },
                                        {
                                            "key": "hiyatoi",
                                            "value": "日雇い健康保険"
                                        },
                                        {
                                            "key": "senin",
                                            "value": "船員健康保険"
                                        },
                                        {
                                            "key": "kyousai",
                                            "value": "共済組合保険"
                                        },
                                        {
                                            "key": "ippanKokuminn",
                                            "value": "一般国民健康保険"
                                        },
                                        {
                                            "key": "taishokuKokumin",
                                            "value": "退職国民健康保険"
                                        },
                                        {
                                            "key": "kukmiaiKokumin",
                                            "value": "組合国民健康保険"
                                        }
                                    ],
                                    "required": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "種別",
                                    "labelRText": "",
                                    "labelLWidth": "35px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "kyokai",
                                    "isBlankLine": false
                                },
                                {
                                    "fieldName": "txtIryoHokenHokenshaNo",
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
                                    "selectControlID": "txtIryoHokenHokenshaNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "onBlur_txtIryoHokenHokenshaNo",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "保険者",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": "0000000000",
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtIryoHokenHokenshaMeisho",
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
                                    "selectControlID": "txtIryoHokenHokenshaMeisho_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
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
                                    "fieldName": "txtIryoHokenKigoNo",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "440px",
                                    "visible": true,
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
                                    "selectControlID": "txtIryoHokenKigoNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "記号番号",
                                    "labelRText": "",
                                    "labelLWidth": "67px",
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
                                    "fieldName": "btnIryoHokenKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnIryoHokenKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnIryoHokenKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnIryoHokenTorikeshi",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "marginRight": "0em",
                                    "selectControlID": "btnIryoHokenTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnIryoHokenTorikeshi",
                                    "text": "取消する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
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
                            "marginLeft": "Default",
                            "marginRight": "Default",
                            "selectControlID": "IryoHokenInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "医療保険",
                            "marginTop": "Default",
                            "marginBottom": "Default",
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
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": true,
                            "height": "Auto",
                            "canPost": true
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

            Events.onBlur_txtIryoHokenHokenshaNo = function () {
                return "onBlur_txtIryoHokenHokenshaNo";
            };

            Events.onClick_btnIryoHokenKakutei = function () {
                return "onClick_btnIryoHokenKakutei";
            };

            Events.onClick_btnIryoHokenTorikeshi = function () {
                return "onClick_btnIryoHokenTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };

            Controls.prototype.IryoHokenInput = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            };

            Controls.prototype.txtIryoHokenKanyuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            };

            Controls.prototype.txtIryoHokenDattaiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            };

            Controls.prototype.ddlIryoHokenShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            };

            Controls.prototype.txtIryoHokenHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            };

            Controls.prototype.txtIryoHokenHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            };

            Controls.prototype.txtIryoHokenKigoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            };

            Controls.prototype.btnIryoHokenKakutei = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            };

            Controls.prototype.btnIryoHokenTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
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
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "WidthMode",
                    "MeisaiMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
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

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.toroku = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = false;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = true;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = true;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = true;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = true;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = true;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = true;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setReadOnly = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().displayNone = true;
                    this.controls.btnIryoHokenTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;
        })(IryoHokenRireki.Modes || (IryoHokenRireki.Modes = {}));
        var Modes = IryoHokenRireki.Modes;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
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
                        },
                        {
                            "fieldName": "JutokuInput",
                            "items": [
                                {
                                    "fieldName": "JutokuTekiyoInput",
                                    "items": [
                                        {
                                            "fieldName": "txtTekiyoDate",
                                            "items": [],
                                            "controlType": "TextBoxFlexibleDate",
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
                                            "selectControlID": "txtTekiyoDate_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "text": "",
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "labelLText": "適用日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "decorationClass": ""
                                        },
                                        {
                                            "fieldName": "txtTekiyoTodokedeDate",
                                            "items": [],
                                            "controlType": "TextBoxFlexibleDate",
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
                                            "selectControlID": "txtTekiyoTodokedeDate_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "text": "",
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "labelLText": "届出日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "decorationClass": ""
                                        },
                                        {
                                            "fieldName": "ddlTekiyoJiyu",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "140px",
                                            "visible": true,
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
                                            "selectControlID": "ddlTekiyoJiyu_core",
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
                                            "labelLText": "適用事由",
                                            "labelRText": "",
                                            "labelLWidth": "65px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "tekiyojiHokenshaJoho",
                                            "items": [
                                                {
                                                    "fieldName": "ddlTekiyojiShozaiHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlTekiyojiShozaiHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "所在保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "80px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiSochimotoHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlTekiyojiSochimotoHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "措置元保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "100px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiKyuHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlTekiyojiKyuHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "旧保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "70px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiJuminJoho",
                                                    "items": [],
                                                    "controlType": "DropDownList",
                                                    "width": "600px",
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
                                                    "selectControlID": "ddlTekiyojiJuminJoho_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "住民情報",
                                                    "labelRText": "",
                                                    "labelLWidth": "80px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
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
                                            "selectControlID": "tekiyojiHokenshaJoho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "保険者・住民情報",
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
                                            "widthAuto": true,
                                            "panelDisplay": 1,
                                            "isGroupBox": false,
                                            "readOnly": false,
                                            "height": "Auto",
                                            "focusPositionID": "labelRTextProperty",
                                            "canPost": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "800px",
                                    "visible": true,
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
                                    "selectControlID": "JutokuTekiyoInput",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "適用情報入力",
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
                                    "focusPositionID": "restoreLayoutButton",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "JutokuKaijoInput",
                                    "items": [
                                        {
                                            "fieldName": "txtKaijoDate",
                                            "items": [],
                                            "controlType": "TextBoxFlexibleDate",
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
                                            "selectControlID": "txtKaijoDate_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "text": "",
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "labelLText": "解除日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "decorationClass": ""
                                        },
                                        {
                                            "fieldName": "txtKaijoTodokedeDate",
                                            "items": [],
                                            "controlType": "TextBoxFlexibleDate",
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
                                            "selectControlID": "txtKaijoTodokedeDate_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "text": "",
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "labelLText": "届出日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "decorationClass": ""
                                        },
                                        {
                                            "fieldName": "ddlKaijoJiyu",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "140px",
                                            "visible": true,
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
                                            "selectControlID": "ddlKaijoJiyu_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": ""
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": ""
                                                }
                                            ],
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "解除事由",
                                            "labelRText": "",
                                            "labelLWidth": "65px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "kaijojiHokenshaJoho",
                                            "items": [
                                                {
                                                    "fieldName": "ddlKaijojiShozaiHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlKaijojiShozaiHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "所在保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "80px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiSochimotoHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlKaijojiSochimotoHokensha_core",
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
                                                    "labelLText": "措置元保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "100px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiKyuHokensha",
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
                                                    "marginLeft": "XS",
                                                    "marginRight": "XS",
                                                    "selectControlID": "ddlKaijojiKyuHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onChange": "",
                                                    "labelLText": "旧保険者",
                                                    "labelRText": "",
                                                    "labelLWidth": "70px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiJuminJono",
                                                    "items": [],
                                                    "controlType": "DropDownList",
                                                    "width": "600px",
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
                                                    "selectControlID": "ddlKaijojiJuminJono_core",
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
                                                    "labelLText": "住民情報",
                                                    "labelRText": "",
                                                    "labelLWidth": "80px",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "selectedItem": "",
                                                    "isBlankLine": true
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
                                            "selectControlID": "kaijojiHokenshaJoho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "保険者・住民情報",
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
                                            "widthAuto": true,
                                            "panelDisplay": 1,
                                            "isGroupBox": false,
                                            "readOnly": true,
                                            "height": "Auto",
                                            "focusPositionID": "labelRTextProperty",
                                            "canPost": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "800px",
                                    "visible": true,
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
                                    "selectControlID": "JutokuKaijoInput",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "解除情報入力",
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
                                    "eraseBorder": true,
                                    "backgroundColor": 0,
                                    "widthAuto": false,
                                    "panelDisplay": 1,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "focusPositionID": "restoreLayoutButton",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "btnJutokuKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnJutokuKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnJutokuKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnJutokuTorikeshi",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnJutokuTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnJutokuTorikeshi",
                                    "text": "取消する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "820px",
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
                            "selectControlID": "JutokuInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "",
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
                            "readOnly": true,
                            "height": "Auto",
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": false
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

            Events.onClick_btnJutokuKakutei = function () {
                return "onClick_btnJutokuKakutei";
            };

            Events.onClick_btnJutokuTorikeshi = function () {
                return "onClick_btnJutokuTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };

            Controls.prototype.JutokuInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            };

            Controls.prototype.JutokuTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.tekiyojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            };

            Controls.prototype.ddlTekiyojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            };

            Controls.prototype.ddlTekiyojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            };

            Controls.prototype.ddlTekiyojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            };

            Controls.prototype.ddlTekiyojiJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            };

            Controls.prototype.JutokuKaijoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            };

            Controls.prototype.txtKaijoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            };

            Controls.prototype.kaijojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            };

            Controls.prototype.ddlKaijojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            };

            Controls.prototype.ddlKaijojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            };

            Controls.prototype.ddlKaijojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            };

            Controls.prototype.ddlKaijojiJuminJono = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            };

            Controls.prototype.btnJutokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            };

            Controls.prototype.btnJutokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
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
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "BtnDisplayMode",
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

            ModeController.prototype.MeisaiDisplayMode = function () {
                return new Modes.MeisaiDisplayMode(this.controls);
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

            var MeisaiDisplayMode = (function () {
                function MeisaiDisplayMode(controls) {
                    this.controls = controls;
                }
                MeisaiDisplayMode.prototype.tekiyoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    this.controls.tekiyojiHokenshaJoho().readOnly = true;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = true;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.kaijoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    this.controls.kaijojiHokenshaJoho().readOnly = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = true;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.tekiyoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.kaijoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.TeiseiInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.displayNone = function () {
                    this.controls.JutokuInput().displayNone = true;
                };
                return MeisaiDisplayMode;
            })();
            Modes.MeisaiDisplayMode = MeisaiDisplayMode;

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

                    this.controls.tekiyojiHokenshaJoho().displayNone = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = true;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = true;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

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

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.btnAdd().disabled = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnAdd().disabled = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

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
                            "fieldName": "btnAddShikakuShutoku",
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
                            "selectControlID": "btnAddShikakuShutoku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAddShikakuShutoku",
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
                    "onLoad": "",
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
                    "eventName": "onClick_btnAddShikakuShutoku"
                },
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
            Events.onClick_btnAddShikakuShutoku = function () {
                return "onClick_btnAddShikakuShutoku";
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
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShikakuShutoku = function () {
                return new UZA.Button(this.convFiledName("btnAddShikakuShutoku"));
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

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

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
                    this.controls.btnAddShikakuShutoku().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAddShikakuShutoku().displayNone = true;
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
                DataGridHeight.prototype.SizeDefault = function () {
                    this.controls.dgShikakuShutokuRireki().height = 217;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size300 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 300;

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
                        },
                        {
                            "fieldName": "ShisetsuNyutaishoInput",
                            "items": [
                                {
                                    "fieldName": "txtNyushoDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtNyushoDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "入所日",
                                    "labelRText": "",
                                    "labelLWidth": "63px",
                                    "labelRWidth": "0px",
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
                                    "fieldName": "txtTaishoDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtTaishoDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "退所日",
                                    "labelRText": "",
                                    "labelLWidth": "60px",
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
                                    "fieldName": "ccdShisetsuJoho",
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
                                    "marginLeft": "0px",
                                    "marginRight": "0px",
                                    "selectControlID": "ccdShisetsuJoho",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "relation": [],
                                    "packageName": "",
                                    "businessId": "DBZ",
                                    "controlName": "ShisetsuJoho",
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
                                            "eventName": "onChange_radShisetsuShurui"
                                        }
                                    ],
                                    "publicEventsAlias": []
                                },
                                {
                                    "fieldName": "btnShisetsuNyutaishoKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnShisetsuNyutaishoKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnShisetsuNyutaishoKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnShisetsuNyutaishoTorikeshi",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "marginRight": "0em",
                                    "selectControlID": "btnShisetsuNyutaishoTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnShisetsuNyutaishoTorikeshi",
                                    "text": "取消する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "760px",
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
                            "selectControlID": "ShisetsuNyutaishoInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "施設入退所",
                            "marginTop": "Default",
                            "marginBottom": "Default",
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
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": true,
                            "height": "Auto",
                            "canPost": true
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

            Events.onClick_btnShisetsuNyutaishoKakutei = function () {
                return "onClick_btnShisetsuNyutaishoKakutei";
            };

            Events.onClick_btnShisetsuNyutaishoTorikeshi = function () {
                return "onClick_btnShisetsuNyutaishoTorikeshi";
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
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShisetsuNyutaisho = function () {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            };

            Controls.prototype.dgShisetsuNyutaishoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            };

            Controls.prototype.ShisetsuNyutaishoInput = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoInput"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.ccdShisetsuJoho = function () {
                return new DBZ.ShisetsuJoho.ModeController("ccdShisetsuJoho");
            };

            Controls.prototype.btnShisetsuNyutaishoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoKakutei"));
            };

            Controls.prototype.btnShisetsuNyutaishoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoTorikeshi"));
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
                    "台帳種別の列を",
                    "明細表示モード"
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

            ModeController.prototype.明細表示モード = function () {
                return new Modes.明細表示モード(this.controls);
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

                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別非表示する();

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

                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別表示する();

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 台帳種別の列を;
            })();
            Modes.台帳種別の列を = 台帳種別の列を;

            var 明細表示モード = (function () {
                function 明細表示モード(controls) {
                    this.controls = controls;
                }
                明細表示モード.prototype.追加_修正 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = false;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = false;
                    this.controls.ccdShisetsuJoho().表示モード().defaultView();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;
                };

                明細表示モード.prototype.削除 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;
                };

                明細表示モード.prototype.選択不可 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = true;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = true;
                };

                明細表示モード.prototype.非表示 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = true;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;
                };
                return 明細表示モード;
            })();
            Modes.明細表示モード = 明細表示モード;
        })(ShisetsuNyutaishoRirekiKanri.Modes || (ShisetsuNyutaishoRirekiKanri.Modes = {}));
        var Modes = ShisetsuNyutaishoRirekiKanri.Modes;
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
                            "width": "960px",
                            "visible": true,
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
                            "onSelect": "onSelect_dgShoKaishuJokyo",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgShoKaishuJokyo",
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
                    "width": "965px",
                    "visible": true,
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
            "publicEvents": [
                {
                    "eventName": "onSelect_dgShoKaishuJokyo"
                },
                {
                    "eventName": "onSelectBySelectButton_dgShoKaishuJokyo"
                }
            ],
            "publicEventsAlias": []
        };
        return ShoKaishuJokyoList_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShoKaishuJokyoList_Design = ShoKaishuJokyoList_Design;

    (function (ShoKaishuJokyoList) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgShoKaishuJokyo = function () {
                return "onSelect_dgShoKaishuJokyo";
            };

            Events.onSelectBySelectButton_dgShoKaishuJokyo = function () {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            };
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
                return new UZA.Panel(this.convFiledNameSelf());
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
                    "グリッド表示モード",
                    "一覧パネル高さ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.グリッド表示モード = function () {
                return new Modes.グリッド表示モード(this.controls);
            };

            ModeController.prototype.一覧パネル高さ = function () {
                return new Modes.一覧パネル高さ(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoList.ModeController = ModeController;

        (function (Modes) {
            var グリッド表示モード = (function () {
                function グリッド表示モード(controls) {
                    this.controls = controls;
                }
                グリッド表示モード.prototype.shokai = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };

                グリッド表示モード.prototype.toroku = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };

                グリッド表示モード.prototype.select = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };
                return グリッド表示モード;
            })();
            Modes.グリッド表示モード = グリッド表示モード;

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
                return new UZA.Panel(this.convFiledNameSelf());
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
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                表示方法.prototype.入力 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                表示方法.prototype.非表示 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
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
    var ShoKaishuKirokuKanri_Design = (function (_super) {
        __extends(ShoKaishuKirokuKanri_Design, _super);
        function ShoKaishuKirokuKanri_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShoKaishuKirokuKanri_Design.myLayout, fieldName);
        }
        ShoKaishuKirokuKanri_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShoKaishuKirokuKanri_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShoKaishuKirokuKanri_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShoKaishuKirokuKanri",
                    "items": [
                        {
                            "fieldName": "ccdShoKaishuJokyoList",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "ccdShoKaishuJokyoList",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "ShoKaishuJokyoList",
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
                            "publicEvents": [],
                            "publicEventsAlias": []
                        },
                        {
                            "fieldName": "ccdShoKaishuJokyoShosai",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "ccdShoKaishuJokyoShosai",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "ShoKaishuJokyoShosai",
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
                            "publicEvents": [],
                            "publicEventsAlias": []
                        },
                        {
                            "fieldName": "btnShoKaishuKakutei",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
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
                            "selectControlID": "btnShoKaishuKakutei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "onBeforeClick_btnShoKaishuKakutei",
                            "onAfterClick": "",
                            "onClick": "onClick_btnShoKaishuKakutei",
                            "text": "確定する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "btnShoKaishuTorikeshi",
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
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnShoKaishuTorikeshi",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnShoKaishuTorikeshi",
                            "text": "取消する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "970px",
                    "visible": true,
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
                    "selectControlID": "ShoKaishuKirokuKanri",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
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
            "controlName": "ShoKaishuKirokuKanri",
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
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return ShoKaishuKirokuKanri_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShoKaishuKirokuKanri_Design = ShoKaishuKirokuKanri_Design;

    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeClick_btnShoKaishuKakutei = function () {
                return "onBeforeClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuKakutei = function () {
                return "onClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuTorikeshi = function () {
                return "onClick_btnShoKaishuTorikeshi";
            };
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShoKaishuJokyoList = function () {
                return new DBZ.ShoKaishuJokyoList.ModeController("ccdShoKaishuJokyoList");
            };

            Controls.prototype.ccdShoKaishuJokyoShosai = function () {
                return new DBZ.ShoKaishuJokyoShosai.ModeController("ccdShoKaishuJokyoShosai");
            };

            Controls.prototype.btnShoKaishuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuKakutei"));
            };

            Controls.prototype.btnShoKaishuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuTorikeshi"));
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
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
                return [
                    "表示方法",
                    "グリッド表示モード",
                    "一覧パネル高さ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.表示方法 = function () {
                return new Modes.表示方法(this.controls);
            };

            ModeController.prototype.グリッド表示モード = function () {
                return new Modes.グリッド表示モード(this.controls);
            };

            ModeController.prototype.一覧パネル高さ = function () {
                return new Modes.一覧パネル高さ(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;

        (function (Modes) {
            var 表示方法 = (function () {
                function 表示方法(controls) {
                    this.controls = controls;
                }
                表示方法.prototype.照会 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().照会();
                    this.controls.btnShoKaishuKakutei().disabled = true;
                    this.controls.btnShoKaishuTorikeshi().disabled = true;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                };

                表示方法.prototype.入力 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().入力();
                    this.controls.btnShoKaishuKakutei().disabled = false;
                    this.controls.btnShoKaishuTorikeshi().disabled = false;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                };

                表示方法.prototype.非表示 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().非表示();
                    this.controls.btnShoKaishuKakutei().displayNone = true;
                    this.controls.btnShoKaishuTorikeshi().displayNone = true;
                };
                return 表示方法;
            })();
            Modes.表示方法 = 表示方法;

            var グリッド表示モード = (function () {
                function グリッド表示モード(controls) {
                    this.controls = controls;
                }
                グリッド表示モード.prototype.shokai = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().shokai();
                };

                グリッド表示モード.prototype.toroku = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().toroku();
                };

                グリッド表示モード.prototype.select = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().select();
                };
                return グリッド表示モード;
            })();
            Modes.グリッド表示モード = グリッド表示モード;

            var 一覧パネル高さ = (function () {
                function 一覧パネル高さ(controls) {
                    this.controls = controls;
                }
                一覧パネル高さ.prototype.サイズ200 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ200();
                };

                一覧パネル高さ.prototype.サイズ250 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ250();
                };

                一覧パネル高さ.prototype.サイズ300 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ300();
                };

                一覧パネル高さ.prototype.サイズ350 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ350();
                };

                一覧パネル高さ.prototype.サイズ400 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ400();
                };

                一覧パネル高さ.prototype.サイズ450 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ450();
                };

                一覧パネル高さ.prototype.サイズ500 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ500();
                };
                return 一覧パネル高さ;
            })();
            Modes.一覧パネル高さ = 一覧パネル高さ;
        })(ShoKaishuKirokuKanri.Modes || (ShoKaishuKirokuKanri.Modes = {}));
        var Modes = ShoKaishuKirokuKanri.Modes;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
