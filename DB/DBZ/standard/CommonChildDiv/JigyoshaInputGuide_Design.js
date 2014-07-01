var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var JigyoshaInputGuide_Design = (function (_super) {
        __extends(JigyoshaInputGuide_Design, _super);
        function JigyoshaInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JigyoshaInputGuide_Design.myLayout, fieldName);
        }
        JigyoshaInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JigyoshaInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JigyoshaInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JigyoshaInputGuide",
                    "items": [
                        {
                            "fieldName": "radJigyoshaSearchType",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "500",
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
                            "selectControlID": "radJigyoshaSearchType_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "selectedItem": null,
                            "dataSource": [
                                {
                                    "key": "keyJigyosha",
                                    "value": "事業者検索"
                                },
                                {
                                    "key": "keyMeisho",
                                    "value": "名称検索"
                                },
                                {
                                    "key": "keyJusho",
                                    "value": "住所検索"
                                },
                                {
                                    "key": "keyJigyoshaCodeUchiwake",
                                    "value": "事業者コード内訳検索"
                                }
                            ],
                            "required": false,
                            "onClick": "",
                            "newLineItemNumber": 4,
                            "spaceSize": "M",
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "disabledItem": [],
                            "icon": []
                        },
                        {
                            "fieldName": "txtJigyoshaCode",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "100",
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
                            "selectControlID": "txtJigyoshaCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onChange": "",
                            "required": false,
                            "labelLText": "事業者コード",
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
                            "labelRText": "※前方一致",
                            "labelRWidth": "S",
                            "labelRAlign": 0,
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "btnSearchJigyosha",
                            "items": [],
                            "controlType": "Button",
                            "width": "200",
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
                            "selectControlID": "btnSearchJigyosha",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnSearchJigyosha",
                            "icon": 0,
                            "text": "該当する事業者を表示する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "SearchResultJigyosha",
                            "items": [
                                {
                                    "fieldName": "dgSearchResultJigyosha",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "1130",
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
                                    "selectControlID": "dgSearchResultJigyosha",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "S",
                                    "dataSource": [],
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
                                        "header": {
                                            "combineColumns": [],
                                            "frozenColumn": "",
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "事業者コード",
                                                "dataName": "jigyoshaCode",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 0,
                                                "visible": false,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": "jigyoshaCode"
                                            },
                                            {
                                                "columnName": "事業者名称",
                                                "dataName": "jigyoshaMeisho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 0,
                                                "visible": false,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": "jigyoshaMeisho"
                                            },
                                            {
                                                "columnName": "事業者",
                                                "dataName": "jigyosha",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 300,
                                                "visible": true,
                                                "cellType": 0,
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "jigyosha"
                                            },
                                            {
                                                "columnName": "住所",
                                                "dataName": "jusho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 350,
                                                "visible": true,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "jusho"
                                            },
                                            {
                                                "columnName": "サービス",
                                                "dataName": "service",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 80,
                                                "visible": true,
                                                "cellType": 0,
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "service"
                                            },
                                            {
                                                "columnName": "認定開始日",
                                                "dataName": "ninteiKaishiDate",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 100,
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
                                                "sortKey": "ninteiKaishiDate"
                                            },
                                            {
                                                "columnName": "認定終了日",
                                                "dataName": "ninteiShuryoDate",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 100,
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
                                                "sortKey": "ninteiShuryoDate"
                                            },
                                            {
                                                "columnName": "社福法人軽減対象",
                                                "dataName": "keigenTaisho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 140,
                                                "visible": true,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "keigenTaisho"
                                            }
                                        ]
                                    },
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "",
                                    "onSelectBySelectButton": "onSelectBySelectButton_dgSearchResultJigyosha",
                                    "onSelectByModifyButton": "",
                                    "onSelectByDeleteButton": "",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "sortOrder": "service",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1135",
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
                            "selectControlID": "SearchResultJigyosha",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "事業者一覧",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SearchResultJigyosha"
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
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnKaigoHokenShisetsuReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "200",
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
                            "selectControlID": "btnKaigoHokenShisetsuReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnKaigoHokenShisetsuReturn",
                            "icon": 0,
                            "text": "事業者入力ガイドを閉じる",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1145",
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
                    "selectControlID": "JigyoshaInputGuide",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "事業者入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JigyoshaInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onSelectBySelectButton_dgSearchResultJigyosha",
                            "requestUrl": "dbz/db/dbz/JigyoshaInputGuide/onSelectBySelectButton_dgSearchResultJigyosha"
                        },
                        {
                            "eventName": "onClick_btnSearchJigyosha",
                            "requestUrl": "dbz/db/dbz/JigyoshaInputGuide/onClick_btnSearchJigyosha"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "jigyoshaCode",
                            "value": ""
                        },
                        {
                            "propertyName": "jigyoshaMeisho",
                            "value": ""
                        }
                    ],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
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
            "controlName": "JigyoshaInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "jigyoshaCode",
                    "controlName": "JigyoshaInputGuide.jigyoshaCode"
                },
                {
                    "key": "jigyoshaMeisho",
                    "controlName": "JigyoshaInputGuide.jigyoshaMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySelectButton_dgSearchResultJigyosha",
            "dialogCancelEventNameForDialog": "onClick_btnKaigoHokenShisetsuReturn",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return JigyoshaInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.JigyoshaInputGuide_Design = JigyoshaInputGuide_Design;
})(DBZ || (DBZ = {}));
