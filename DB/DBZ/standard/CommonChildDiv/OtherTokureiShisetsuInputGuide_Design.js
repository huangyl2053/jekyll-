var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var OtherTokureiShisetsuInputGuide_Design = (function (_super) {
        __extends(OtherTokureiShisetsuInputGuide_Design, _super);
        function OtherTokureiShisetsuInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, OtherTokureiShisetsuInputGuide_Design.myLayout, fieldName);
        }
        OtherTokureiShisetsuInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        OtherTokureiShisetsuInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        OtherTokureiShisetsuInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "OtherTokureiShisetsuInputGuide",
                    "items": [
                        {
                            "fieldName": "radkannaiKubun",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "340",
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
                            "onChange": "",
                            "selectedItem": "keyAll",
                            "dataSource": [
                                {
                                    "key": "keyAll",
                                    "value": "全て"
                                },
                                {
                                    "key": "keyKannai",
                                    "value": "管内"
                                },
                                {
                                    "key": "keyKangai",
                                    "value": "管外"
                                }
                            ],
                            "required": false,
                            "onClick": "",
                            "newLineItemNumber": 3,
                            "spaceSize": 1,
                            "labelLText": "管内・管外区分:",
                            "labelLWidth": "120",
                            "labelLAlign": 2
                        },
                        {
                            "fieldName": "btnSearchOtherShisetsu",
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
                            "onClick": "onClick_btnSearchOtherShisetsu",
                            "text": "該当する施設を表示する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        },
                        {
                            "fieldName": "SearchResultOtherShisetsu",
                            "items": [
                                {
                                    "fieldName": "dgSearchResultOtherTokureiShisetsu",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "710",
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
                                                    "onClick": "onClick_select",
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
                                    "onSelectByDblClick": "",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "sortOrder": "jusho",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
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
                            "onLoad": "",
                            "title": "その他特例施設一覧",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SearchResultOtherShisetsu"
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
                            "fieldName": "btnOtherShisetsuReturn",
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
                            "onClick": "onClick_btnOtherShisetsuReturn",
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
                    "title": "その他特例施設検索",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "OtherTokureiShisetsuInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnSearchOtherShisetsu",
                            "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onClick_btnSearchOtherShisetsu"
                        },
                        {
                            "eventName": "onClick_select",
                            "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onClick_select"
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
            "controlName": "OtherTokureiShisetsuInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "otherShisetsuCode",
                    "controlName": "OtherTokureiShisetsuInputGuide.shisetsuCode"
                },
                {
                    "key": "otherShisetsuMeisho",
                    "controlName": "OtherTokureiShisetsuInputGuide.shisetsuMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onClick_select",
            "dialogCancelEventNameForDialog": "onClick_btnOtherShisetsuReturn"
        };
        return OtherTokureiShisetsuInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.OtherTokureiShisetsuInputGuide_Design = OtherTokureiShisetsuInputGuide_Design;
})(DBZ || (DBZ = {}));
