var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var JutakuKaishuhiRireki_Design = (function (_super) {
        __extends(JutakuKaishuhiRireki_Design, _super);
        function JutakuKaishuhiRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JutakuKaishuhiRireki_Design.myLayout, fieldName);
        }
        JutakuKaishuhiRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JutakuKaishuhiRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JutakuKaishuhiRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JutakuKaishuhiRireki",
                    "items": [
                        {
                            "fieldName": "dgJutakuKaishuRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1045",
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
                            "selectControlID": "dgJutakuKaishuRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "height": "Auto",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": true,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 1
                                },
                                "columns": [
                                    {
                                        "columnName": "提供<br>年月",
                                        "dataName": "txtTeikyoYM",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 60,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 1,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTeikyoYM"
                                    },
                                    {
                                        "columnName": "申請日",
                                        "dataName": "txtShinseiDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 85,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShinseiDate"
                                    },
                                    {
                                        "columnName": "決定日",
                                        "dataName": "txtKetteiDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 85,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKetteiDate"
                                    },
                                    {
                                        "columnName": "審査<br>結果",
                                        "dataName": "txtShinsaResult",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShinsaResult"
                                    },
                                    {
                                        "columnName": "費用額<br>合計",
                                        "dataName": "txtHiyogakuTotal",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHiyogakuTotal"
                                    },
                                    {
                                        "columnName": "保険対象<br>費用額",
                                        "dataName": "txtHokenTaishoHiyogaku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHokenTaishoHiyogaku"
                                    },
                                    {
                                        "columnName": "保険<br>給付額",
                                        "dataName": "txtHokenKyufugaku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHokenKyufugaku"
                                    },
                                    {
                                        "columnName": "利用者<br>負担額",
                                        "dataName": "txtRiyoshaFutangaku",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 5,
                                        "cellDetails": {
                                            "cellType": 5,
                                            "maxLength": "1000000000000",
                                            "minLength": "0",
                                            "maxValue": "1.7976931348623157e+308",
                                            "minValue": "0",
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": "0",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtRiyoshaFutangaku"
                                    },
                                    {
                                        "columnName": "転居",
                                        "dataName": "txtTenkyoReset",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 55,
                                        "visible": true,
                                        "cellType": 2,
                                        "cellDetails": {
                                            "cellType": 2,
                                            "disabled": false,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTenkyoReset"
                                    },
                                    {
                                        "columnName": "３段階",
                                        "dataName": "txt3DantaiReset",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 70,
                                        "visible": true,
                                        "cellType": 2,
                                        "cellDetails": {
                                            "cellType": 2,
                                            "disabled": false,
                                            "onChange": ""
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txt3DantaiReset"
                                    },
                                    {
                                        "columnName": "対象住宅住所",
                                        "dataName": "txtTaishoJutakuAddress",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 180,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTaishoJutakuAddress"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "txtTaishoJutakuAddress",
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
                            "onClick": "onClick_btnClose",
                            "text": "閉じる",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1060",
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
                    "selectControlID": "JutakuKaishuhiRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "住宅改修費履歴一覧",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JutakuKaishuhiRireki"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbc/db/dbc/JutakuKaishuhiRireki/onLoad"
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
            "businessId": "DBC",
            "controlName": "JutakuKaishuhiRireki",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "M"
        };
        return JutakuKaishuhiRireki_Design;
    })(Uz.CommonChildDiv);
    DBC.JutakuKaishuhiRireki_Design = JutakuKaishuhiRireki_Design;
})(DBC || (DBC = {}));
