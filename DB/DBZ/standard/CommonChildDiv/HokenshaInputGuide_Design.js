var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var HokenshaInputGuide_Design = (function (_super) {
        __extends(HokenshaInputGuide_Design, _super);
        function HokenshaInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, HokenshaInputGuide_Design.myLayout, fieldName);
        }
        HokenshaInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        HokenshaInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        HokenshaInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "HokenshaInputGuide",
                    "items": [
                        {
                            "fieldName": "ddlHokenshaKenCode",
                            "items": [],
                            "controlType": "DropDownList",
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
                            "selectControlID": "ddlHokenshaKenCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onChange": "",
                            "selectedItem": "20",
                            "dataSource": [
                                {
                                    "key": "20",
                                    "value": "20 長野"
                                },
                                {
                                    "key": "47",
                                    "value": "47 沖縄"
                                }
                            ],
                            "required": false,
                            "labelLText": "県コード",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "onFocus": "",
                            "onBlur": "",
                            "text": ""
                        },
                        {
                            "fieldName": "btnSearchGaitoHokensha",
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
                            "selectControlID": "btnSearchGaitoHokensha",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnSearchGaitoHokensha",
                            "text": "該当する保険者を表示する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "SearchResultHokensha",
                            "items": [
                                {
                                    "fieldName": "dgSearchResultHokensha",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "360",
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
                                    "selectControlID": "dgSearchResultHokensha",
                                    "helpMessageID": "",
                                    "jpControlName": "",
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
                                        "header": {
                                            "combineColumns": [],
                                            "frozenColumn": "",
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "保険者番号",
                                                "dataName": "hokenshaNo",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 0,
                                                "visible": false,
                                                "cellType": 0,
                                                "cellDetails": null,
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": "hokenshaNo"
                                            },
                                            {
                                                "columnName": "保険者名称",
                                                "dataName": "hokenshaMeisho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 0,
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
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "hokensha"
                                            }
                                        ]
                                    },
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "",
                                    "onSelectBySelectButton": "onSelectBySelectButton_dgSearchResultHokensha",
                                    "onSelectByModifyButton": "",
                                    "onSelectByDeleteButton": "",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "sortOrder": "hokensha",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
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
                            "selectControlID": "SearchResultHokensha",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "保険者一覧",
                            "marginTop": "XS",
                            "marginBottom": "XS",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SearchResultHokensha"
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
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnHokenshaReturn",
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
                            "selectControlID": "btnHokenshaReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnHokenshaReturn",
                            "text": "保険者入力ガイドを閉じる",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "460",
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
                    "selectControlID": "HokenshaInputGuide",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "保険者入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "HokenshaInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnSearchGaitoHokensha",
                            "requestUrl": "dbz/db/dbz/HokenshaInputGuide/onClick_btnSearchGaitoHokensha"
                        },
                        {
                            "eventName": "onSelectBySelectButton_dgSearchResultHokensha",
                            "requestUrl": "dbz/db/dbz/HokenshaInputGuide/onSelectBySelectButton_dgSearchResultHokensha"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "hokenshaNo",
                            "value": ""
                        },
                        {
                            "propertyName": "hokenshaMeisho",
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
            "controlName": "HokenshaInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "hokenshaNo",
                    "controlName": "HokenshaInputGuide.hokenshaNo"
                },
                {
                    "key": "hokenshaMeisho",
                    "controlName": "HokenshaInputGuide.hokenshaMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySelectButton_dgSearchResultHokensha",
            "dialogCancelEventNameForDialog": "onClick_btnHokenshaReturn"
        };
        return HokenshaInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.HokenshaInputGuide_Design = HokenshaInputGuide_Design;
})(DBZ || (DBZ = {}));
