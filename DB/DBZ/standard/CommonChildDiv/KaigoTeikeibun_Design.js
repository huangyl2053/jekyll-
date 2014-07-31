var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var KaigoTeikeibun_Design = (function (_super) {
        __extends(KaigoTeikeibun_Design, _super);
        function KaigoTeikeibun_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, KaigoTeikeibun_Design.myLayout, fieldName);
        }
        KaigoTeikeibun_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        KaigoTeikeibun_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        KaigoTeikeibun_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "KaigoTeikeibun",
                    "items": [
                        {
                            "fieldName": "dgTeikeibun",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "513",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 1,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "dgTeikeibun",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "317",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
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
                                        "columnName": "コード",
                                        "dataName": "code",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 55,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "code"
                                    },
                                    {
                                        "columnName": "内容",
                                        "dataName": "naiyo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 400,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "naiyo"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "onSelectBySB_Teikeibun",
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
                            "sortOrder": "naiyo",
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
                            "wrap": false,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnClose",
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
                    "width": "533",
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
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "KaigoTeikeibun",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "定型文",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "KaigoTeikeibun"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/KaigoTeikeibunSelector/onLoad"
                        },
                        {
                            "eventName": "onSelectBySB_Teikeibun",
                            "requestUrl": "dbz/db/dbz/KaigoTeikeibunSelector/onSelectBySelectButton_dgTeikeibun"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "teikeiKbn",
                            "value": ""
                        },
                        {
                            "propertyName": "teikeiShubetsu",
                            "value": ""
                        },
                        {
                            "propertyName": "teikeibunNaiyo",
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
            "marginLeft": "0",
            "marginRight": "0",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "KaigoTeikeibun",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "teikeiKbn",
                    "controlName": "KaigoTeikeibun.teikeiKbn"
                },
                {
                    "key": "teikeiShubetsu",
                    "controlName": "KaigoTeikeibun.teikeiShubetsu"
                },
                {
                    "key": "teikeibunNaiyo",
                    "controlName": "KaigoTeikeibun.teikeibunNaiyo"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySB_Teikeibun",
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return KaigoTeikeibun_Design;
    })(Uz.CommonChildDiv);
    DBZ.KaigoTeikeibun_Design = KaigoTeikeibun_Design;
})(DBZ || (DBZ = {}));
