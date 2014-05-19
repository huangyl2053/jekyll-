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
                            "fieldName": "txtShinseiDate",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "80",
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
                            "text": "",
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "value": "",
                            "labelLText": "申請日",
                            "labelRText": "",
                            "labelLWidth": "45",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "isPassword": false,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSeiriNo",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "80",
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
                            "text": "",
                            "required": false,
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "readOnly": false,
                            "placeHolder": "1234567890",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "value": "",
                            "labelLText": "整理番号",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "textAlign": 0,
                            "isPassword": false,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": "",
                            "formatLength": 1
                        },
                        {
                            "fieldName": "ddlJotaiKubun",
                            "items": [],
                            "controlType": "DropDownList",
                            "width": "S",
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
                            "dataSource": [
                                {
                                    "key": "yoshien1",
                                    "value": "要支援１"
                                },
                                {
                                    "key": "yoshien2",
                                    "value": "要支援２"
                                },
                                {
                                    "key": "yokaigo1",
                                    "value": "要介護１"
                                },
                                {
                                    "key": "yokaigo2",
                                    "value": "要介護２"
                                },
                                {
                                    "key": "yokaigo3",
                                    "value": "要介護３"
                                },
                                {
                                    "key": "yokaigo4",
                                    "value": "要介護４"
                                },
                                {
                                    "key": "yokaigo5",
                                    "value": "要介護５"
                                }
                            ],
                            "required": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "labelLText": "要介護状態区分",
                            "labelRText": "",
                            "labelLWidth": "105",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "selectedItem": ""
                        },
                        {
                            "fieldName": "dgJutakuKaishuRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "885",
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
                                        "columnName": "着工日",
                                        "dataName": "txtKaishuDueDate",
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
                                        "sortKey": "txtKaishuDueDate"
                                    },
                                    {
                                        "columnName": "完成日",
                                        "dataName": "txtKanseiDueDate",
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
                                        "sortKey": "txtKanseiDueDate"
                                    },
                                    {
                                        "columnName": "見積額",
                                        "dataName": "txtMitsumoriAmount",
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
                                            "onChange": ""
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtMitsumoriAmount"
                                    },
                                    {
                                        "columnName": "事業者",
                                        "dataName": "txtKaishuJigyosha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuJigyosha"
                                    },
                                    {
                                        "columnName": "対象住宅住所",
                                        "dataName": "txtKaishuTaishoAddress",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuTaishoAddress"
                                    },
                                    {
                                        "columnName": "改修内容",
                                        "dataName": "txtKaishuContents",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 250,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKaishuContents"
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
                            "dataSource": [],
                            "sortOrder": "txtKaishuContents",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        }
                    ],
                    "controlType": "Panel",
                    "width": "900",
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
                    "title": "住宅改修費履歴一覧",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JutakuKaishuhiRireki"
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
                    "widthAuto": false,
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
            "businessId": "DBC",
            "controlName": "JutakuKaishuhiRireki",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return JutakuKaishuhiRireki_Design;
    })(Uz.CommonChildDiv);
    DBC.JutakuKaishuhiRireki_Design = JutakuKaishuhiRireki_Design;
})(DBC || (DBC = {}));
