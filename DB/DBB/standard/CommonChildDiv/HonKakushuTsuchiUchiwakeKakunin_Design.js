var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBB;
(function (DBB) {
    var HonKakushuTsuchiUchiwakeKakunin_Design = (function (_super) {
        __extends(HonKakushuTsuchiUchiwakeKakunin_Design, _super);
        function HonKakushuTsuchiUchiwakeKakunin_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, HonKakushuTsuchiUchiwakeKakunin_Design.myLayout, fieldName);
        }
        HonKakushuTsuchiUchiwakeKakunin_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        HonKakushuTsuchiUchiwakeKakunin_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        HonKakushuTsuchiUchiwakeKakunin_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "HonKakushuTsuchiUchiwakeKakunin",
                    "items": [
                        {
                            "fieldName": "HonKakushuTsuchiUchiwakeSentaku",
                            "items": [
                                {
                                    "fieldName": "dgKakushuTsuchiUchiwakeSentaku",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "640",
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
                                    "selectControlID": "dgKakushuTsuchiUchiwakeSentaku",
                                    "gridSetting": {
                                        "rowHeight": 25,
                                        "isMultiSelectable": false,
                                        "isShowFooter": true,
                                        "isShowFilter": false,
                                        "isShowFilterButton": false,
                                        "isShowRowState": false,
                                        "header": {
                                            "combineColumns": [],
                                            "frozenColumn": "",
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "",
                                                "dataName": "btnSentaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 50,
                                                "visible": true,
                                                "cellType": 8,
                                                "cellDetails": {
                                                    "cellType": 8,
                                                    "text": "選択",
                                                    "onClick": "onClick_Sentaku",
                                                    "imageFileUrl": "",
                                                    "imageWidth": "",
                                                    "imageHeight": ""
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "保存された打分け方法",
                                                "dataName": "txtJokenMeisho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 570,
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
                                                "columnName": "NoUchiwake",
                                                "dataName": "txtUchiwake",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 1,
                                                "visible": false,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            }
                                        ]
                                    },
                                    "height": "175",
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "onSelect_Uchiwake",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "dataSource": [],
                                    "sortOrder": "",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "660",
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
                            "selectControlID": "HonKakushuTsuchiUchiwakeSentaku",
                            "onLoad": "",
                            "title": "打分け方法を選択",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "HonKakushuTsuchiUchiwakeSentaku"
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
                            "panelDisplay": 1,
                            "isGroupBox": false
                        },
                        {
                            "fieldName": "dgTsuchishoSettei",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1070",
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
                            "selectControlID": "dgTsuchishoSettei",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 1
                                },
                                "columns": [
                                    {
                                        "columnName": "本算定後の<br>徴収方法",
                                        "dataName": "txtChosyuHoho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "状態",
                                        "dataName": "txtJotai",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 440,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "通知書",
                                        "dataName": "txtTsuchisyoShitei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 190,
                                        "visible": true,
                                        "cellType": 3,
                                        "cellDetails": {
                                            "cellType": 3,
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "決定通知書"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "変更兼特徴中止通知書"
                                                },
                                                {
                                                    "key": "key2",
                                                    "value": "発行しない"
                                                }
                                            ]
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "対象者<br>(口座/現金)",
                                        "dataName": "txtGenkinKozaShitei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 140,
                                        "visible": true,
                                        "cellType": 3,
                                        "cellDetails": {
                                            "cellType": 3,
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "すべて"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "口座振替者のみ"
                                                },
                                                {
                                                    "key": "key2",
                                                    "value": "現金納付者のみ"
                                                }
                                            ]
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "出力順グループ",
                                        "dataName": "txtHakkojiGroup",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 1,
                                        "cellDetails": {
                                            "cellType": 1,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "textAlign": 0,
                                            "onChange": ""
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHakkojiGroup"
                                    }
                                ]
                            },
                            "height": "Auto",
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "txtHakkojiGroup",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "txtTsuchishoSetteiHozonMeisho",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "335",
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
                            "selectControlID": "txtTsuchishoSetteiHozonMeisho_core",
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
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "保存名称",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0
                        },
                        {
                            "fieldName": "btnTsuchishoSetteiHozon",
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
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnTsuchishoSetteiHozon",
                            "text": "設定を保存する",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "btnTsuchishoSetteiKakutei",
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
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnTsuchishoSetteiKakutei",
                            "text": "確定する",
                            "onClick": "closeOK",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "btnTsuchishoSetteiModoru",
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
                            "selectControlID": "btnTsuchishoSetteiModoru",
                            "text": "確定せずに戻る",
                            "onClick": "closeCancel",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1086",
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
                    "selectControlID": "HonKakushuTsuchiUchiwakeKakunin",
                    "onLoad": "",
                    "title": "打分け方法確認",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "HonKakushuTsuchiUchiwakeKakunin"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbb/db/dbb/HonKakushuTsuchiUchiwakeKakunin/onLoad"
                        },
                        {
                            "eventName": "onSelect_Uchiwake",
                            "requestUrl": "dbb/db/dbb/HonKakushuTsuchiUchiwakeKakunin/onSelect"
                        },
                        {
                            "eventName": "onClick_Sentaku",
                            "requestUrl": "dbb/db/dbb/HonKakushuTsuchiUchiwakeKakunin/onClick"
                        }
                    ],
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
            "businessId": "DBB",
            "controlName": "HonKakushuTsuchiUchiwakeKakunin",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "closeOK",
            "dialogCancelEventNameForDialog": "closeCancel"
        };
        return HonKakushuTsuchiUchiwakeKakunin_Design;
    })(Uz.CommonChildDiv);
    DBB.HonKakushuTsuchiUchiwakeKakunin_Design = HonKakushuTsuchiUchiwakeKakunin_Design;
})(DBB || (DBB = {}));
