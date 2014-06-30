var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var ShinsakaiIinList_Design = (function (_super) {
        __extends(ShinsakaiIinList_Design, _super);
        function ShinsakaiIinList_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShinsakaiIinList_Design.myLayout, fieldName);
        }
        ShinsakaiIinList_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShinsakaiIinList_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShinsakaiIinList_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShinsakaiIinList",
                    "items": [
                        {
                            "fieldName": "dgShinsakaiIinChildList",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "814",
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
                            "selectControlID": "dgShinsakaiIinChildList",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
                            "gridSetting": {
                                "rowHeight": 35,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": true,
                                "isShowFilterButton": true,
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
                                        "columnName": "選択",
                                        "dataName": "btnToSelect",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": false,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "選択",
                                            "onClick": "",
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "btnToSelect"
                                    },
                                    {
                                        "columnName": "審査会委員番号",
                                        "dataName": "shinsakaiIinNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shinsakaiIinNo"
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "shimei"
                                    },
                                    {
                                        "columnName": "カナ氏名",
                                        "dataName": "kanaShimei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "kanaShimei"
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimeiAndKanaShimei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 210,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shimeiAndKanaShimei"
                                    },
                                    {
                                        "columnName": "所属機関",
                                        "dataName": "shozokuKikan",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 210,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shozokuKikan"
                                    },
                                    {
                                        "columnName": "性別",
                                        "dataName": "gender",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 60,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "gender"
                                    },
                                    {
                                        "columnName": "資格",
                                        "dataName": "shikaku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 160,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shikaku"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
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
                            "sortOrder": "gender",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "btnClose",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
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
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "CloseCancel",
                            "text": "取消",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G9",
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
                    "selectControlID": "ShinsakaiIinList",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "審査会委員一覧",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ShinsakaiIinList"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbe/db/dbe/ShinsakaiIinList/onLoad"
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
            "businessId": "DBE",
            "controlName": "ShinsakaiIinList",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "CloseCancel",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return ShinsakaiIinList_Design;
    })(Uz.CommonChildDiv);
    DBE.ShinsakaiIinList_Design = ShinsakaiIinList_Design;
})(DBE || (DBE = {}));
