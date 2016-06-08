var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var HihokenshaFinder_Design = (function (_super) {
        __extends(HihokenshaFinder_Design, _super);
        function HihokenshaFinder_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, HihokenshaFinder_Design.myLayout, fieldName);
        }
        HihokenshaFinder_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        HihokenshaFinder_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        HihokenshaFinder_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "HihokenshaFinder",
                    "items": [
                        {
                            "fieldName": "KaigoFinder",
                            "items": [
                                {
                                    "fieldName": "ddlHokensha",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "M",
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
                                    "onChange": "",
                                    "selectedItem": "1",
                                    "dataSource": [
                                        {
                                            "key": "1",
                                            "value": "電算市"
                                        },
                                        {
                                            "key": "2",
                                            "value": "南魚沼市"
                                        }
                                    ],
                                    "required": false,
                                    "labelLText": "保険者",
                                    "labelRText": "",
                                    "labelLWidth": "110px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "isBlankLine": false,
                                    "text": "",
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtHihokenshaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "82px",
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
                                    "selectControlID": "txtHihokenshaNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "labelLText": "被保番号",
                                    "labelRText": "",
                                    "labelLWidth": "110px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "maxLength": "10",
                                    "minLength": "10",
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
                                    "fieldName": "txtTuchishoNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "130px",
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
                                    "selectControlID": "txtTuchishoNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "labelLText": "通知書番号",
                                    "labelRText": "",
                                    "labelLWidth": "90px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "maxLength": "16",
                                    "minLength": "1",
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
                                    "formatLength": "16"
                                },
                                {
                                    "fieldName": "ddlFukaNendo",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "88px",
                                    "visible": true,
                                    "displayNone": true,
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
                                    "selectControlID": "ddlFukaNendo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "selectedItem": null,
                                    "dataSource": [
                                        {
                                            "key": "9999",
                                            "value": "全年度"
                                        },
                                        {
                                            "key": "2014",
                                            "value": "平26"
                                        },
                                        {
                                            "key": "2013",
                                            "value": "平25"
                                        },
                                        {
                                            "key": "2014",
                                            "value": "平24"
                                        }
                                    ],
                                    "labelLText": "賦課年度　",
                                    "labelRText": "",
                                    "labelLWidth": "110px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "isBlankLine": false,
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "KaigoFinderDetail",
                                    "items": [
                                        {
                                            "fieldName": "lblHihokenshaJotai",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "155px",
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
                                            "marginRight": "2px",
                                            "selectControlID": "lblHihokenshaJotai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "被保険者状態",
                                            "decorationClass": "",
                                            "align": 2
                                        },
                                        {
                                            "fieldName": "chkHihokenshaDaicho",
                                            "items": [],
                                            "controlType": "CheckBoxList",
                                            "width": "165px",
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
                                            "marginRight": "XS",
                                            "selectControlID": "chkHihokenshaDaicho_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "被保険者台帳登録者"
                                                }
                                            ],
                                            "labelLText": "",
                                            "labelLWidth": "S",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "selectedItems": [],
                                            "newLineItemNumber": 1,
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": "1",
                                            "spaceSize": "M",
                                            "isAllSelectable": false,
                                            "isAllSelectableBreakLine": false,
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "chkJukyushaDaicho",
                                            "items": [],
                                            "controlType": "CheckBoxList",
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
                                            "marginLeft": "0px",
                                            "marginRight": "XS",
                                            "selectControlID": "chkJukyushaDaicho_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "受給者台帳登録者"
                                                }
                                            ],
                                            "labelLText": "",
                                            "labelLWidth": "S",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "selectedItems": [],
                                            "newLineItemNumber": 1,
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": "1",
                                            "spaceSize": "M",
                                            "isAllSelectable": false,
                                            "isAllSelectableBreakLine": false,
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "chkJushochiTokureisha",
                                            "items": [],
                                            "controlType": "CheckBoxList",
                                            "width": "120px",
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
                                            "marginRight": "XS",
                                            "selectControlID": "chkJushochiTokureisha_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "住所地特例者"
                                                }
                                            ],
                                            "labelLText": "",
                                            "labelLWidth": "S",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "selectedItems": [],
                                            "newLineItemNumber": 1,
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": "1",
                                            "spaceSize": "M",
                                            "isAllSelectable": false,
                                            "isAllSelectableBreakLine": false,
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "radMinashiNigo",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "160px",
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
                                            "selectControlID": "radMinashiNigo_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": "1",
                                            "dataSource": [
                                                {
                                                    "key": "1",
                                                    "value": "含む"
                                                },
                                                {
                                                    "key": "2",
                                                    "value": "含まない"
                                                }
                                            ],
                                            "labelLText": "みなし2号",
                                            "labelLWidth": "155px",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": "M",
                                            "disabledItem": [],
                                            "icon": []
                                        },
                                        {
                                            "fieldName": "chkMinashiNigo",
                                            "items": [],
                                            "controlType": "CheckBoxList",
                                            "width": "130px",
                                            "visible": true,
                                            "displayNone": true,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "163px",
                                            "marginRight": "XS",
                                            "selectControlID": "chkMinashiNigo_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": null,
                                            "dataSource": [
                                                {
                                                    "key": "1",
                                                    "value": "みなし2号のみ"
                                                }
                                            ],
                                            "labelLText": "",
                                            "labelLWidth": "S",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "selectedItems": [],
                                            "newLineItemNumber": 2,
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": 2,
                                            "spaceSize": "M",
                                            "isAllSelectable": false,
                                            "isAllSelectableBreakLine": false,
                                            "disabledItem": [],
                                            "icon": []
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "1085px",
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
                                    "selectControlID": "KaigoFinderDetail",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "詳細条件",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "KaigoFinderDetail"
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
                                    "canPost": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1100px",
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
                            "selectControlID": "KaigoFinder",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "介護検索条件",
                            "marginTop": "0em",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "KaigoFinder"
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
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto",
                            "canPost": true
                        },
                        {
                            "fieldName": "ccdAtenaFinder",
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "ccdAtenaFinder",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "URA",
                            "controlName": "AtenaFinder",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "canTransferEvent": true,
                            "heightForDialog": "M",
                            "firstFocusFieldName": "",
                            "lastFocusFieldName": "",
                            "modes": [
                                {
                                    "modeKey": "JuminShubetsuMode",
                                    "modeValue": "個人のみ"
                                },
                                {
                                    "modeKey": "ShosaiJokenRiyoMode",
                                    "modeValue": "詳細条件あり"
                                },
                                {
                                    "modeKey": "KojinNoHyoji",
                                    "modeValue": "優先エリアに表示する"
                                },
                                {
                                    "modeKey": "HojinNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "UketsukeNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "SeinengappiHyoji",
                                    "modeValue": "基本エリアに表示する"
                                },
                                {
                                    "modeKey": "ShikibetsuCodeHyoji",
                                    "modeValue": "基本エリアに表示する"
                                },
                                {
                                    "modeKey": "SetaiCodeHyoji",
                                    "modeValue": "詳細エリアに表示する"
                                },
                                {
                                    "modeKey": "JuminhyoCodeHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "ZairyuCardCodeHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "KokuhoNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "KokiKoreiHihokenshaNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "KaigoHihokenshaNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "KisoNenkinNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "InkanNoHyoji",
                                    "modeValue": "表示しない"
                                },
                                {
                                    "modeKey": "GyoseikuHyoji",
                                    "modeValue": "詳細エリアに表示する"
                                },
                                {
                                    "modeKey": "RenrakusakiHyoji",
                                    "modeValue": "詳細エリアに表示する"
                                },
                                {
                                    "modeKey": "MeishoUpLineHyoji",
                                    "modeValue": "表示する"
                                },
                                {
                                    "modeKey": "JushoDownLineHyoji",
                                    "modeValue": "表示する"
                                }
                            ],
                            "publicEvents": [],
                            "publicEventsAlias": [],
                            "AtenaFinder_title": "宛名検索条件",
                            "AtenaFinder_canOpenAndClose": false,
                            "AtenaFinder_width": "1100px",
                            "AtenaFinderShosai_title": "詳細条件",
                            "AtenaFinderShosai_width": "1085px",
                            "AtenaFinder_eraseBorder": false,
                            "txtBanchiCode4_displayNone": true
                        },
                        {
                            "fieldName": "ButtonsForHihokenshaFinder",
                            "items": [
                                {
                                    "fieldName": "btnClear",
                                    "items": [],
                                    "controlType": "Button",
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
                                    "selectControlID": "btnClear",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "条件をクリアする",
                                    "onClick": "onClick_btnClear",
                                    "icon": 0,
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "heightTextBoxMatches": false
                                },
                                {
                                    "fieldName": "btnSearch",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
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
                                    "selectControlID": "btnSearch",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "検索する",
                                    "onClick": "onClick_btnSearch",
                                    "icon": 0,
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "heightTextBoxMatches": false
                                },
                                {
                                    "fieldName": "txtMaxNumber",
                                    "items": [],
                                    "controlType": "TextBoxNum",
                                    "width": "XS",
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
                                    "selectControlID": "txtMaxNumber_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "required": false,
                                    "labelLText": "最大表示件数",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 1,
                                    "labelRAlign": 0,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
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
                                    "permitCharactor": "+-,.\\",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": false,
                                    "decimalPointLength": 0
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1100px",
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
                            "selectControlID": "ButtonsForHihokenshaFinder",
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
                                    "postParameterPanelNames": "ButtonsForHihokenshaFinder"
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
                            "fieldName": "ccdSaikinShorisha",
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
                            "marginLeft": "0em",
                            "marginRight": "0em",
                            "selectControlID": "ccdSaikinShorisha",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "relation": [],
                            "packageName": "",
                            "businessId": "DBZ",
                            "controlName": "KaigoSaikinShorishaRireki",
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
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1100px",
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
                    "selectControlID": "HihokenshaFinder",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "0em",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "HihokenshaFinder"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/HihokenshaFinder/onLoad"
                        },
                        {
                            "eventName": "onClick_btnClear",
                            "requestUrl": "dbz/db/dbz/HihokenshaFinder/onClick_btnClear"
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
            "controlName": "HihokenshaFinder",
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
                    "eventName": "onClick_btnSearch"
                }
            ],
            "publicEventsAlias": []
        };
        return HihokenshaFinder_Design;
    })(Uz.CommonChildDiv);
    DBZ.HihokenshaFinder_Design = HihokenshaFinder_Design;

    (function (HihokenshaFinder) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_btnSearch = function () {
                return "onClick_btnSearch";
            };
            return Events;
        })();
        HihokenshaFinder.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaFinder";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KaigoFinder = function () {
                return new UZA.Panel(this.convFiledName("KaigoFinder"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtTuchishoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTuchishoNo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.KaigoFinderDetail = function () {
                return new UZA.Panel(this.convFiledName("KaigoFinder_KaigoFinderDetail"));
            };

            Controls.prototype.lblHihokenshaJotai = function () {
                return new UZA.Label(this.convFiledName("lblHihokenshaJotai"));
            };

            Controls.prototype.chkHihokenshaDaicho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokenshaDaicho"));
            };

            Controls.prototype.chkJukyushaDaicho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJukyushaDaicho"));
            };

            Controls.prototype.chkJushochiTokureisha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJushochiTokureisha"));
            };

            Controls.prototype.radMinashiNigo = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiNigo"));
            };

            Controls.prototype.chkMinashiNigo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiNigo"));
            };

            Controls.prototype.ccdAtenaFinder = function () {
                return new URA.AtenaFinder.ModeController("ccdAtenaFinder");
            };

            Controls.prototype.ButtonsForHihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnSearch = function () {
                return new UZA.Button(this.convFiledName("btnSearch"));
            };

            Controls.prototype.txtMaxNumber = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            };

            Controls.prototype.ccdSaikinShorisha = function () {
                return new DBZ.KaigoSaikinShorishaRireki.ModeController("ccdSaikinShorisha");
            };
            return Controls;
        })();
        HihokenshaFinder.Controls = Controls;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
