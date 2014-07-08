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
                            "fieldName": "radKannaiKubun",
                            "items": [],
                            "controlType": "RadioButton",
                            "width": "230",
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
                            "selectControlID": "radKannaiKubun_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "onClick": "",
                            "icon": [],
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
                            "onChange": "",
                            "selectedItem": "keyAll",
                            "required": false,
                            "labelLText": "施設種類",
                            "labelLWidth": "70",
                            "labelLAlign": 2,
                            "newLineItemNumber": 3,
                            "spaceSize": "M",
                            "disabledItem": []
                        },
                        {
                            "fieldName": "btnSearchOtherShisetsu",
                            "items": [],
                            "controlType": "Button",
                            "width": "150",
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
                            "selectControlID": "btnSearchOtherShisetsu",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnSearchOtherShisetsu",
                            "text": "施設情報を表示する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "lblOtherShisetsuShurui",
                            "items": [],
                            "controlType": "Label",
                            "width": "100",
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
                            "selectControlID": "lblOtherShisetsuShurui",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "keyKannai",
                            "required": false,
                            "isPrivateInfo": false,
                            "align": 2,
                            "decorationClass": ""
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
                                    "marginLeft": "0.2",
                                    "marginRight": "0",
                                    "selectControlID": "dgSearchResultOtherTokureiShisetsu",
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
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "",
                                    "onSelectBySelectButton": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
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
                                    "sortOrder": "jusho",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
                                }
                            ],
                            "controlType": "Panel",
                            "width": "720",
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
                            "marginLeft": "0.15",
                            "marginRight": "XS",
                            "selectControlID": "SearchResultOtherShisetsu",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "その他特例施設一覧",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": false,
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
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnOtherShisetsuReturn",
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
                            "selectControlID": "btnOtherShisetsuReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnOtherShisetsuReturn",
                            "text": "閉じる",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "730",
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
                    "selectControlID": "OtherTokureiShisetsuInputGuide",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "その他特例施設入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "OtherTokureiShisetsuInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onLoad"
                        },
                        {
                            "eventName": "onClick_btnSearchOtherShisetsu",
                            "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onClick_btnSearchOtherShisetsu"
                        },
                        {
                            "eventName": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
                            "requestUrl": "dbz/db/dbz/OtherTokureiShisetsuInputGuide/onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu"
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
                },
                {
                    "key": "selectRadioButtonKey",
                    "controlName": "lblOtherShisetsuShurui"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu",
            "dialogCancelEventNameForDialog": "onClick_btnOtherShisetsuReturn",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return OtherTokureiShisetsuInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.OtherTokureiShisetsuInputGuide_Design = OtherTokureiShisetsuInputGuide_Design;
})(DBZ || (DBZ = {}));
