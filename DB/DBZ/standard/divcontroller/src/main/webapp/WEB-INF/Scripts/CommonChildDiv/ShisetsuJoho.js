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
                    "利用機能",
                    "台帳種別",
                    "施設種類",
                    "入力補助",
                    "表示モード"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.利用機能 = function () {
                return new Modes.利用機能(this.controls);
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
            var 利用機能 = (function () {
                function 利用機能(controls) {
                    this.controls = controls;
                }
                利用機能.prototype.台帳種別表示機能 = function () {
                };

                利用機能.prototype.全施設対象機能 = function () {
                };

                利用機能.prototype.被保険者対象機能 = function () {
                };

                利用機能.prototype.他市町村住所地特例者対象機能 = function () {
                };

                利用機能.prototype.適用除外者対象機能 = function () {
                };
                return 利用機能;
            })();
            Modes.利用機能 = 利用機能;

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
