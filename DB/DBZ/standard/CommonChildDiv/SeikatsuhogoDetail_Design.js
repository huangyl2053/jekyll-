var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuhogoDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "SeikatsuhogoDetail";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.SeikatsuhogoDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SeikatsuhogoDetailSub = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub"));
            };

            Controls.prototype.txtJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            };

            Controls.prototype.txtKaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYM"));
            };

            Controls.prototype.txtHaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHaishiYM"));
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.btnHokenshaGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaGuide"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.HokenryoDairinofu = function () {
                return new UZA.Panel(this.convFiledName("HokenryoDairinofu"));
            };

            Controls.prototype.radDairinofuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            };

            Controls.prototype.txtNofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNofuYM"));
            };

            Controls.prototype.KyugoShisetsu = function () {
                return new UZA.Panel(this.convFiledName("KyugoShisetsu"));
            };

            Controls.prototype.radNyutaishoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.FujoShurui = function () {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            };

            Controls.prototype.chkFujyoShurui = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFujyoShurui"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        SeikatsuhogoDetail.Controls = Controls;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;

    var SeikatsuhogoDetail_Design = (function (_super) {
        __extends(SeikatsuhogoDetail_Design, _super);
        function SeikatsuhogoDetail_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SeikatsuhogoDetail_Design.myLayout, fieldName);
        }
        Object.defineProperty(SeikatsuhogoDetail_Design.prototype, "btnHokenshaGuide_displayNone", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"])["displayNone"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"])["displayNone"] = value;
                } else {
                    this.layout.items[0].items[0].items[4]["displayNone"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        SeikatsuhogoDetail_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("btnHokenshaGuide_displayNone");
        };

        SeikatsuhogoDetail_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["btnHokenshaGuide_displayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"] + "_" + this.layout.items[0].items[0].items[4]["fieldName"]).getEditablePropertyInfo()["displayNone"];

            return editablePropertyInfo;
        };
        SeikatsuhogoDetail_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SeikatsuhogoDetail",
                    "items": [
                        {
                            "fieldName": "SeikatsuhogoDetailSub",
                            "items": [
                                {
                                    "fieldName": "txtJukyushaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "65",
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
                                    "selectControlID": "txtJukyushaNo_core",
                                    "text": "",
                                    "required": true,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "受給者番号",
                                    "labelRText": "",
                                    "labelLWidth": "90",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": "",
                                    "formatLength": "8"
                                },
                                {
                                    "fieldName": "txtKaishiYM",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtKaishiYM_core",
                                    "text": "",
                                    "required": true,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "開始年月",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": "./_-",
                                    "ymdKubun": 1,
                                    "displayFormat": 0
                                },
                                {
                                    "fieldName": "txtHaishiYM",
                                    "items": [],
                                    "controlType": "TextBoxDate",
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
                                    "selectControlID": "txtHaishiYM_core",
                                    "text": "",
                                    "required": false,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "value": "",
                                    "labelLText": "廃止年月",
                                    "labelRText": "",
                                    "labelLWidth": "70",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": "./_-",
                                    "ymdKubun": 1,
                                    "displayFormat": 0
                                },
                                {
                                    "fieldName": "txtHokenshaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "50",
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
                                    "selectControlID": "txtHokenshaNo_core",
                                    "text": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "措置市町村",
                                    "labelRText": "",
                                    "labelLWidth": "90",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": "",
                                    "formatLength": "8"
                                },
                                {
                                    "fieldName": "btnHokenshaGuide",
                                    "items": [],
                                    "controlType": "ButtonDialog",
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
                                    "marginLeft": "-0.2",
                                    "marginRight": "XS",
                                    "selectControlID": "btnHokenshaGuide",
                                    "onClick": "",
                                    "text": "補助",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "displayChildDivName": "",
                                    "dataPassing": [],
                                    "visibleCloseButton": true,
                                    "onOkClose": "",
                                    "onBeforeOpenDialog": ""
                                },
                                {
                                    "fieldName": "txtHokenshaName",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "marginLeft": "-0.2",
                                    "marginRight": "XS",
                                    "selectControlID": "txtHokenshaName_core",
                                    "text": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "HokenryoDairinofu",
                                    "items": [
                                        {
                                            "fieldName": "radDairinofuKubun",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "150",
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
                                            "selectControlID": "radDairinofuKubun_core",
                                            "onClick": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "該当"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "非該当"
                                                }
                                            ],
                                            "onChange": "",
                                            "labelLText": "区分",
                                            "labelLWidth": "85",
                                            "labelLAlign": 2,
                                            "selectedItem": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": "M"
                                        },
                                        {
                                            "fieldName": "txtNofuYM",
                                            "items": [],
                                            "controlType": "TextBoxDate",
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
                                            "selectControlID": "txtNofuYM_core",
                                            "text": "",
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "value": "",
                                            "labelLText": "納付区分年月",
                                            "labelRText": "",
                                            "labelLWidth": "100",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 1,
                                            "displayFormat": 0
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "selectControlID": "HokenryoDairinofu",
                                    "onLoad": "",
                                    "title": "介護保険料代理納付",
                                    "marginTop": "M",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "HokenryoDairinofu"
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
                                    "panelDisplay": 1,
                                    "isGroupBox": false
                                },
                                {
                                    "fieldName": "KyugoShisetsu",
                                    "items": [
                                        {
                                            "fieldName": "radNyutaishoKubun",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "M",
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
                                            "selectControlID": "radNyutaishoKubun_core",
                                            "onClick": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "入所"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "退所"
                                                },
                                                {
                                                    "key": "",
                                                    "value": "未該当"
                                                }
                                            ],
                                            "onChange": "",
                                            "labelLText": "入退所区分",
                                            "labelLWidth": "85",
                                            "labelLAlign": 2,
                                            "selectedItem": "",
                                            "newLineItemNumber": 3,
                                            "spaceSize": "M"
                                        },
                                        {
                                            "fieldName": "txtNyushoDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
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
                                            "selectControlID": "txtNyushoDate_core",
                                            "text": "",
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "value": "",
                                            "labelLText": "入所日",
                                            "labelRText": "",
                                            "labelLWidth": "85",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "txtTaishoDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "90",
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
                                            "text": "",
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "value": "",
                                            "labelLText": "退所日",
                                            "labelRText": "",
                                            "labelLWidth": "70",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "selectControlID": "KyugoShisetsu",
                                    "onLoad": "",
                                    "title": "救護施設",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "KyugoShisetsu"
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
                                    "panelDisplay": 1,
                                    "isGroupBox": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "470",
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
                            "selectControlID": "SeikatsuhogoDetailSub",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "S",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SeikatsuhogoDetailSub"
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
                            "isGroupBox": false
                        },
                        {
                            "fieldName": "FujoShurui",
                            "items": [
                                {
                                    "fieldName": "chkFujyoShurui",
                                    "items": [],
                                    "controlType": "CheckBoxList",
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
                                    "selectControlID": "chkFujyoShurui_core",
                                    "onClick": "",
                                    "dataSource": [
                                        {
                                            "key": "seikatsu",
                                            "value": "生活扶助"
                                        },
                                        {
                                            "key": "kyoiku",
                                            "value": "教育扶助"
                                        },
                                        {
                                            "key": "jutaku",
                                            "value": "住宅扶助"
                                        },
                                        {
                                            "key": "iryo",
                                            "value": "医療扶助"
                                        },
                                        {
                                            "key": "kaigo",
                                            "value": "介護扶助"
                                        },
                                        {
                                            "key": "shussan",
                                            "value": "出産扶助"
                                        },
                                        {
                                            "key": "nariwai",
                                            "value": "生業扶助"
                                        },
                                        {
                                            "key": "sosai",
                                            "value": "葬祭扶助"
                                        },
                                        {
                                            "key": "zanryuhojin",
                                            "value": "残留邦人"
                                        }
                                    ],
                                    "required": true,
                                    "onChange": "",
                                    "labelLText": "",
                                    "labelLWidth": "M",
                                    "labelLAlign": 0,
                                    "selectedItem": "",
                                    "newLineItemNumber": 1,
                                    "spaceSize": "S",
                                    "selectedItems": [],
                                    "minCheckedItem": 0,
                                    "maxCheckedItem": 2,
                                    "isAllSelectable": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "M",
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
                            "selectControlID": "FujoShurui",
                            "onLoad": "",
                            "title": "扶助種類",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "FujoShurui"
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
                            "panelDisplay": 1,
                            "isGroupBox": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "M",
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
                    "selectControlID": "SeikatsuhogoDetail",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SeikatsuhogoDetail"
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
                    "isGroupBox": false
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
            "selectControlID": "defaultLayout",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "SeikatsuhogoDetail",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnHokenshaGuide",
                    "publicChildProperty": "displayNone",
                    "newPropertyName": "btnHokenshaGuide_displayNone"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return SeikatsuhogoDetail_Design;
    })(Uz.CommonChildDiv);
    DBZ.SeikatsuhogoDetail_Design = SeikatsuhogoDetail_Design;
})(DBZ || (DBZ = {}));
