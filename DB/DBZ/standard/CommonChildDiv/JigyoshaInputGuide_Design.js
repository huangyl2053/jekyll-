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
                            "onChange": "",
                            "selectedItem": "keyJigyosha",
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
                            "labelLText": "",
                            "labelLWidth": "S",
                            "labelLAlign": 2,
                            "onClick": "",
                            "newLineItemNumber": 4,
                            "spaceSize": 1
                        },
                        {
                            "fieldName": "txtJigyoshaCode",
                            "items": [],
                            "controlType": "TextBoxCode",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "required": false,
                            "text": "",
                            "isPrivateInfo": false,
                            "onChange": "",
                            "labelLText": "事業者コード",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 2,
                            "isPassword": false,
                            "isComboBox": false,
                            "onKeyPress": "",
                            "suggest": [],
                            "value": "",
                            "permitCharactor": "",
                            "formatLength": 1
                        },
                        {
                            "fieldName": "btnSearchJigyosha",
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
                            "text": "該当する事業者を表示する",
                            "onClick": "",
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        },
                        {
                            "fieldName": "SearchResultJigyosha",
                            "items": [
                                {
                                    "fieldName": "dgSearchResultJigyosha",
                                    "items": [],
                                    "controlType": "DataGrid",
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
                                    "marginLeft": "S",
                                    "marginRight": "XS",
                                    "dataSource": [],
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
                                                "dataName": "select",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 40,
                                                "visible": true,
                                                "cellType": 8,
                                                "cellDetails": {
                                                    "cellType": 8,
                                                    "text": "■",
                                                    "onClick": "",
                                                    "imageFileUrl": "",
                                                    "imageWidth": "",
                                                    "imageHeight": ""
                                                },
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": "select"
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
                                                "width": 250,
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
                                                "cellType": 0,
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
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
                                                "cellType": 0,
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
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
                                    "height": "S",
                                    "onSort": "",
                                    "onSelect": "",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "sortOrder": "keigenTaisho",
                                    "isAscending": true,
                                    "filterList": [],
                                    "clickedRowId": -1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "950",
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
                            "eraseBorderTop": false,
                            "eraseBorderBottom": false,
                            "eraseBorderRight": false,
                            "eraseBorderLeft": false,
                            "backgroundColor": 0,
                            "widthAuto": true,
                            "isGroupBox": false
                        },
                        {
                            "fieldName": "btnKaigoHokenShisetsuReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "80",
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
                            "text": "キャンセル",
                            "onClick": "",
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
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
                    "onLoad": "",
                    "title": "事業者入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "HokenshaInputGuide"
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
            "relation": [],
            "businessId": "DBZ",
            "controlName": "JigyoshaInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return JigyoshaInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.JigyoshaInputGuide_Design = JigyoshaInputGuide_Design;
})(DBZ || (DBZ = {}));
