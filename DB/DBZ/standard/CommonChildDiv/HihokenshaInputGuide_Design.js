var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var HihokenshaInputGuide_Design = (function (_super) {
        __extends(HihokenshaInputGuide_Design, _super);
        function HihokenshaInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, HihokenshaInputGuide_Design.myLayout, fieldName);
        }
        HihokenshaInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        HihokenshaInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        HihokenshaInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "HihokenshaInputGuide",
                    "items": [
                        {
                            "fieldName": "HihokenshaFinder",
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
                            "marginLeft": "0",
                            "marginRight": 0,
                            "selectControlID": "HihokenshaFinder",
                            "relation": [],
                            "businessId": "DBZ",
                            "controlName": "HihokenshaFinder",
                            "marginTop": 0,
                            "marginBottom": 0,
                            "originalProperty": [],
                            "dataPassingForDialog": [],
                            "dialogOkEventNameForDialog": "",
                            "dialogCancelEventNameForDialog": "",
                            "onClickBtnToSearch": "onClickBtnToSearch_HihokenshaFinder",
                            "onClickBtnToClear": ""
                        },
                        {
                            "fieldName": "lblSearchResultOfHihokensha",
                            "items": [],
                            "controlType": "Label",
                            "width": "180",
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
                            "selectControlID": "lblSearchResultOfHihokensha",
                            "required": false,
                            "align": 2,
                            "text": "被保険者検索該当者一覧",
                            "isPrivateInfo": false
                        },
                        {
                            "fieldName": "dgSearchResultOfHihokensha",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1030",
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
                            "selectControlID": "dgSearchResultOfHihokensha",
                            "dataSource": [],
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "選択",
                                        "dataName": "btnToDecide",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "",
                                            "onClick": "onClick_btnToDecide",
                                            "imageFileUrl": "/uz/uza/css/images/finger.png",
                                            "imageWidth": "20",
                                            "imageHeight": "20"
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "hihokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "識別コード",
                                        "dataName": "shikibetsuCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "被保険者区分",
                                        "dataName": "hihokenshaKubun",
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
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 180,
                                        "visible": false,
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
                                        "columnName": "カナ氏名",
                                        "dataName": "kanaShimsei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimeiAndKanaShimsei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 250,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "性別",
                                        "dataName": "gender",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "生年月日",
                                        "dataName": "birthDay",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "郵便番号",
                                        "dataName": "yubinNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
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
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "個人番号",
                                        "dataName": "kojinNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "住民種別",
                                        "dataName": "juminShubetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "世帯コード",
                                        "dataName": "setaiCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "height": "S",
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "sortOrder": "defaultDataName3",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "btnReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "210",
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
                            "selectControlID": "btnReturn",
                            "text": "被保険者入力ガイドを閉じる",
                            "onClick": "onClick_btnReturn",
                            "icon": 0,
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1050",
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
                    "selectControlID": "HihokenshaInputGuide",
                    "onLoad": "",
                    "title": "被保険者入力補助ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "HihokenshaInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClickBtnToSearch_HihokenshaFinder",
                            "requestUrl": "dbz/db/dbz/HihokenshaInputGuide/onClickBtnToSearch_HihokenshaFinder"
                        },
                        {
                            "eventName": "onClick_btnToDecide",
                            "requestUrl": "dbz/db/dbz/HihokenshaInputGuide/onClick_btnToDecide"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "hihokenshaNo",
                            "value": ""
                        },
                        {
                            "propertyName": "hihokenshaMeisho",
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
                    "readOnly": false
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
            "controlName": "HihokenshaInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "hihokenshaNo",
                    "controlName": "HihokenshaInputGuide.hihokenshaNo"
                },
                {
                    "key": "hihokenshaMeisho",
                    "controlName": "HihokenshaInputGuide.hihokenshaMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onClick_btnToDecide",
            "dialogCancelEventNameForDialog": "onClick_btnReturn"
        };
        return HihokenshaInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.HihokenshaInputGuide_Design = HihokenshaInputGuide_Design;
})(DBZ || (DBZ = {}));
