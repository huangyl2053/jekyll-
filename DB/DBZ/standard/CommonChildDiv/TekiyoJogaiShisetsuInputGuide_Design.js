var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var TekiyoJogaiShisetsuInputGuide_Design = (function (_super) {
        __extends(TekiyoJogaiShisetsuInputGuide_Design, _super);
        function TekiyoJogaiShisetsuInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, TekiyoJogaiShisetsuInputGuide_Design.myLayout, fieldName);
        }
        TekiyoJogaiShisetsuInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        TekiyoJogaiShisetsuInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        TekiyoJogaiShisetsuInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "TekiyoJogaiShisetsuInputGuide",
                    "items": [
                        {
                            "fieldName": "dgTekiyoJogaiShisetsu",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "660",
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
                                        "dataName": "btnSelect",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "■",
                                            "onClick": "onClick_btnSelect",
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "btnSelect"
                                    },
                                    {
                                        "columnName": "事業者番号",
                                        "dataName": "jigyoshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jigyoshaNo"
                                    },
                                    {
                                        "columnName": "事業者名称",
                                        "dataName": "jigyoshaMeisho",
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
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jusho"
                                    }
                                ]
                            },
                            "height": "S",
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "onClick_btnSelect",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "btnReturn",
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
                            "onClick": "onClick_btnReturn",
                            "text": "キャンセル",
                            "appearance": 0,
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
                    "title": "適用除外施設情報入力補助ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "TekiyoJogaiShisetsuInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/TekiyoJogaiShisetsuInputGuide/onLoad"
                        },
                        {
                            "eventName": "onClick_btnSelect",
                            "requestUrl": "dbz/db/dbz/TekiyoJogaiShisetsuInputGuide/onClick_btnSelect"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "shisetsuCode",
                            "value": ""
                        },
                        {
                            "propertyName": "shisetsuMeisho",
                            "value": ""
                        }
                    ],
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
            "controlName": "TekiyoJogaiShisetsuInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "shisetsuCode",
                    "controlName": "TekiyoJogaiShisetsuInputGuide.shisetsuCode"
                },
                {
                    "key": "shisetsuMeisho",
                    "controlName": "TekiyoJogaiShisetsuInputGuide.shisetsuMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onClick_btnSelect",
            "dialogCancelEventNameForDialog": "onClick_btnReturn"
        };
        return TekiyoJogaiShisetsuInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.TekiyoJogaiShisetsuInputGuide_Design = TekiyoJogaiShisetsuInputGuide_Design;
})(DBZ || (DBZ = {}));
