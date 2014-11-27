var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var TainoInfo_Design = (function (_super) {
        __extends(TainoInfo_Design, _super);
        function TainoInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, TainoInfo_Design.myLayout, fieldName);
        }
        TainoInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        TainoInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        TainoInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "TainoInfo",
                    "items": [
                        {
                            "fieldName": "txtHanteiKijunYMD",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "80px",
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
                            "selectControlID": "txtHanteiKijunYMD_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "滞納判定基準日",
                            "labelRText": "",
                            "labelLWidth": "120px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "btnKensaku",
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
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnKensaku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "基準日で検索する",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "txtSaikoNokigen",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "80px",
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
                            "selectControlID": "txtSaikoNokigen_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "最古滞納納期限",
                            "labelRText": "",
                            "labelLWidth": "120px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": "",
                            "decorationClass": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtKeikaNen",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "20px",
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
                            "marginRight": "0em",
                            "selectControlID": "txtKeikaNen_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "最古の保険料納期限からの経過月数",
                            "labelRText": "",
                            "labelLWidth": "260px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKeikaTsuki",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "20px",
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
                            "marginLeft": "0em",
                            "marginRight": "XS",
                            "selectControlID": "txtKeikaTsuki_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "年",
                            "labelRText": "ヵ月",
                            "labelLWidth": "20px",
                            "labelRWidth": "50px",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "linTaino1",
                            "items": [],
                            "controlType": "HorizontalLine",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "linTaino1",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "size": "Default"
                        },
                        {
                            "fieldName": "txtHokenryoNendo1",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "35px",
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
                            "selectControlID": "txtHokenryoNendo1_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "保険料年度",
                            "labelRText": "",
                            "labelLWidth": "90px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtHokenryoNendo2",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "35px",
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
                            "selectControlID": "txtHokenryoNendo2_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "保険料年度",
                            "labelRText": "",
                            "labelLWidth": "310px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtHokenryoNendo3",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "35px",
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
                            "selectControlID": "txtHokenryoNendo3_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "保険料年度",
                            "labelRText": "",
                            "labelLWidth": "310px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "dgTainoJokyo1",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "350px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgTainoJokyo1",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "373px",
                            "gridSetting": {
                                "rowHeight": 22,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": false,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "txtKi",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "期",
                                        "dataName": "txtKi",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKi"
                                    },
                                    {
                                        "columnName": "保険料",
                                        "dataName": "txtHokenryo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHokenryo"
                                    },
                                    {
                                        "columnName": "納期限",
                                        "dataName": "txtNokigen",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtNokigen"
                                    },
                                    {
                                        "columnName": "滞納",
                                        "dataName": "txtTaino",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTaino"
                                    },
                                    {
                                        "columnName": "時効起算日",
                                        "dataName": "txtJikoKisanYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanYMD"
                                    },
                                    {
                                        "columnName": "時効起算日<br>区分",
                                        "dataName": "txtJikoKisanbiKbn",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanbiKbn"
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
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "dgTainoJokyo2",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "350px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgTainoJokyo2",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "373px",
                            "gridSetting": {
                                "rowHeight": 22,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": false,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "txtKi",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "期",
                                        "dataName": "txtKi",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKi"
                                    },
                                    {
                                        "columnName": "保険料",
                                        "dataName": "txtHokenryo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHokenryo"
                                    },
                                    {
                                        "columnName": "納期限",
                                        "dataName": "txtNokigen",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtNokigen"
                                    },
                                    {
                                        "columnName": "滞納",
                                        "dataName": "txtTaino",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTaino"
                                    },
                                    {
                                        "columnName": "時効起算日",
                                        "dataName": "txtJikoKisanYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanYMD"
                                    },
                                    {
                                        "columnName": "時効起算日<br>区分",
                                        "dataName": "txtJikoKisanbiKbn",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanbiKbn"
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
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "dgTainoJokyo3",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "350px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgTainoJokyo3",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "373px",
                            "gridSetting": {
                                "rowHeight": 22,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": false,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": false,
                                "isShowDeleteButtonColumn": false,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "txtKi",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "期",
                                        "dataName": "txtKi",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtKi"
                                    },
                                    {
                                        "columnName": "保険料",
                                        "dataName": "txtHokenryo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 2,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtHokenryo"
                                    },
                                    {
                                        "columnName": "納期限",
                                        "dataName": "txtNokigen",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtNokigen"
                                    },
                                    {
                                        "columnName": "滞納",
                                        "dataName": "txtTaino",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 40,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtTaino"
                                    },
                                    {
                                        "columnName": "時効起算日",
                                        "dataName": "txtJikoKisanYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanYMD"
                                    },
                                    {
                                        "columnName": "時効起算日<br>区分",
                                        "dataName": "txtJikoKisanbiKbn",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtJikoKisanbiKbn"
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
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "txtSonotaHokenryo",
                            "items": [],
                            "controlType": "TextBoxNum",
                            "width": "90px",
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
                            "marginRight": "0em",
                            "selectControlID": "txtSonotaHokenryo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "表示年度以前の滞納状況　保険料額",
                            "labelRText": "",
                            "labelLWidth": "260px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": "10",
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "maxValue": "99999999",
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0,
                            "permitCharactor": "+-,.\\"
                        },
                        {
                            "fieldName": "txtSonotatainoGaku",
                            "items": [],
                            "controlType": "TextBoxNum",
                            "width": "90px",
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
                            "selectControlID": "txtSonotatainoGaku_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "うち滞納額",
                            "labelRText": "",
                            "labelLWidth": "80px",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "decorationClass": "",
                            "maxLength": "10",
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "maxValue": 1.7976931348623157e+308,
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0,
                            "permitCharactor": "+-,.\\"
                        },
                        {
                            "fieldName": "TainoSetsumei",
                            "items": [
                                {
                                    "fieldName": "celTainoSetsumei1",
                                    "items": [
                                        {
                                            "fieldName": "TainocolorKanno",
                                            "items": [
                                                {
                                                    "fieldName": "WhiteCell",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblDummyWhite",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "64px",
                                                            "visible": false,
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
                                                            "selectControlID": "lblDummyWhite",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "label",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "TableCell",
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
                                                    "marginLeft": "0em",
                                                    "marginRight": "0em",
                                                    "selectControlID": "WhiteCell",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "connectTd": "R1C1"
                                                }
                                            ],
                                            "controlType": "TablePanel",
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
                                            "selectControlID": "TainocolorKanno",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='white'></td></tr>\n  </tbody>\n</table>\n"
                                        },
                                        {
                                            "fieldName": "TainocolorMino",
                                            "items": [
                                                {
                                                    "fieldName": "RedCell",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblDummyRed",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "64px",
                                                            "visible": false,
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
                                                            "selectControlID": "lblDummyRed",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "label",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "TableCell",
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
                                                    "marginLeft": "0em",
                                                    "marginRight": "0em",
                                                    "selectControlID": "RedCell",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "connectTd": "R1C1"
                                                }
                                            ],
                                            "controlType": "TablePanel",
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
                                            "selectControlID": "TainocolorMino",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='red'></td></tr>\n  </tbody>\n</table>\n"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celTainoSetsumei1",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celTainoSetsumei2",
                                    "items": [
                                        {
                                            "fieldName": "lblMassage1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "120px",
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
                                            "selectControlID": "lblMassage1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "完納／未来納期",
                                            "decorationClass": "",
                                            "align": 0
                                        },
                                        {
                                            "fieldName": "lblMassage2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "120px",
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
                                            "selectControlID": "lblMassage2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "未納・時効到来",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celTainoSetsumei2",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celTainoSetsumei3",
                                    "items": [
                                        {
                                            "fieldName": "TainocolorMitorai",
                                            "items": [
                                                {
                                                    "fieldName": "YellowCell",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblDummyYellow",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "64px",
                                                            "visible": false,
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
                                                            "selectControlID": "lblDummyYellow",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "label",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "TableCell",
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
                                                    "marginLeft": "0em",
                                                    "marginRight": "0em",
                                                    "selectControlID": "YellowCell",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "connectTd": "R1C1"
                                                }
                                            ],
                                            "controlType": "TablePanel",
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
                                            "selectControlID": "TainocolorMitorai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='yellow'></td></tr>\n  </tbody>\n</table>\n"
                                        },
                                        {
                                            "fieldName": "TainocolorKano",
                                            "items": [
                                                {
                                                    "fieldName": "GreenCell1",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblDummyGreen",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "64px",
                                                            "visible": false,
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
                                                            "selectControlID": "lblDummyGreen",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "label",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "TableCell",
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
                                                    "marginLeft": "0em",
                                                    "marginRight": "0em",
                                                    "selectControlID": "GreenCell1",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "connectTd": "R1C1"
                                                }
                                            ],
                                            "controlType": "TablePanel",
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
                                            "selectControlID": "TainocolorKano",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='lightGreen'></td></tr>\n  </tbody>\n</table>\n"
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celTainoSetsumei3",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C3"
                                },
                                {
                                    "fieldName": "celTainoSetsumei4",
                                    "items": [
                                        {
                                            "fieldName": "lblMassage3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "130px",
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
                                            "selectControlID": "lblMassage3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "未納・時効未到来",
                                            "decorationClass": "",
                                            "align": 0
                                        },
                                        {
                                            "fieldName": "lblMassage4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "130px",
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
                                            "selectControlID": "lblMassage4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "過納",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "marginLeft": "0em",
                                    "marginRight": "0em",
                                    "selectControlID": "celTainoSetsumei4",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C4"
                                }
                            ],
                            "controlType": "TablePanel",
                            "width": "XS",
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
                            "selectControlID": "TainoSetsumei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table cellspacing=0 cellpadding=0 span style=\"font-size:11pt\">\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td></tr>\n  </tbody>\n</table>\n"
                        },
                        {
                            "fieldName": "btnReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "100px",
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
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "閉じる",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnReturn",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "btnKakutei",
                            "items": [],
                            "controlType": "Button",
                            "width": "100px",
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
                            "selectControlID": "btnKakutei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "確定する",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1090px",
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
                    "selectControlID": "TainoInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "滞納状況",
                    "marginTop": "1px",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "TainoInfo"
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
                    "height": "Auto",
                    "focusPositionID": "createFile",
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
            "marginLeft": "0em",
            "marginRight": "0em",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "TainoInfo",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return TainoInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.TainoInfo_Design = TainoInfo_Design;

    (function (TainoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        TainoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TainoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.TainoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TainoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TainoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHanteiKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtSaikoNokigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaikoNokigen"));
            };

            Controls.prototype.txtKeikaNen = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikaNen"));
            };

            Controls.prototype.txtKeikaTsuki = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikaTsuki"));
            };

            Controls.prototype.linTaino1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linTaino1"));
            };

            Controls.prototype.txtHokenryoNendo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoNendo1"));
            };

            Controls.prototype.txtHokenryoNendo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoNendo2"));
            };

            Controls.prototype.txtHokenryoNendo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoNendo3"));
            };

            Controls.prototype.dgTainoJokyo1 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo1"));
            };

            Controls.prototype.dgTainoJokyo2 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo2"));
            };

            Controls.prototype.dgTainoJokyo3 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo3"));
            };

            Controls.prototype.txtSonotaHokenryo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotaHokenryo"));
            };

            Controls.prototype.txtSonotatainoGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotatainoGaku"));
            };

            Controls.prototype.TainoSetsumei = function () {
                return new UZA.TablePanel(this.convFiledName("TainoSetsumei"));
            };

            Controls.prototype.celTainoSetsumei1 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei1"));
            };

            Controls.prototype.TainocolorKanno = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            };

            Controls.prototype.WhiteCell = function () {
                return new UZA.TableCell(this.convFiledName("WhiteCell"));
            };

            Controls.prototype.lblDummyWhite = function () {
                return new UZA.Label(this.convFiledName("lblDummyWhite"));
            };

            Controls.prototype.TainocolorMino = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMino"));
            };

            Controls.prototype.RedCell = function () {
                return new UZA.TableCell(this.convFiledName("RedCell"));
            };

            Controls.prototype.lblDummyRed = function () {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            };

            Controls.prototype.celTainoSetsumei2 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei2"));
            };

            Controls.prototype.lblMassage1 = function () {
                return new UZA.Label(this.convFiledName("lblMassage1"));
            };

            Controls.prototype.lblMassage2 = function () {
                return new UZA.Label(this.convFiledName("lblMassage2"));
            };

            Controls.prototype.celTainoSetsumei3 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei3"));
            };

            Controls.prototype.TainocolorMitorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            };

            Controls.prototype.YellowCell = function () {
                return new UZA.TableCell(this.convFiledName("YellowCell"));
            };

            Controls.prototype.lblDummyYellow = function () {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            };

            Controls.prototype.TainocolorKano = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            };

            Controls.prototype.GreenCell1 = function () {
                return new UZA.TableCell(this.convFiledName("GreenCell1"));
            };

            Controls.prototype.lblDummyGreen = function () {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            };

            Controls.prototype.celTainoSetsumei4 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei4"));
            };

            Controls.prototype.lblMassage3 = function () {
                return new UZA.Label(this.convFiledName("lblMassage3"));
            };

            Controls.prototype.lblMassage4 = function () {
                return new UZA.Label(this.convFiledName("lblMassage4"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        TainoInfo.Controls = Controls;
    })(DBZ.TainoInfo || (DBZ.TainoInfo = {}));
    var TainoInfo = DBZ.TainoInfo;
})(DBZ || (DBZ = {}));
