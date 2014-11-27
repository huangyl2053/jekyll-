var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var GenGakuInfo_Design = (function (_super) {
        __extends(GenGakuInfo_Design, _super);
        function GenGakuInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, GenGakuInfo_Design.myLayout, fieldName);
        }
        GenGakuInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        GenGakuInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        GenGakuInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "GenGakuInfo",
                    "items": [
                        {
                            "fieldName": "TainoNendo",
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
                                    "fieldName": "dgGenGaku",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "560px",
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
                                    "selectControlID": "dgGenGaku",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "Auto",
                                    "gridSetting": {
                                        "rowHeight": 25,
                                        "isMultiSelectable": false,
                                        "isShowHeader": true,
                                        "isShowFooter": false,
                                        "isShowFilter": false,
                                        "isShowFilterButton": false,
                                        "isShowRowState": false,
                                        "isShowSelectButtonColumn": true,
                                        "isShowModifyButtonColumn": false,
                                        "isShowDeleteButtonColumn": false,
                                        "limitRowCount": 0,
                                        "selectedRowCount": 0,
                                        "selectLimitRowCount": 0,
                                        "header": {
                                            "combineColumns": [],
                                            "frozenColumn": "",
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "調定年度",
                                                "dataName": "txtChoteiNendo",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 130,
                                                "visible": true,
                                                "cellType": 6,
                                                "cellDetails": {
                                                    "cellType": 6,
                                                    "ymdKubun": 0,
                                                    "displayFormat": 0,
                                                    "onChange": "",
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "調定額",
                                                "dataName": "txtChoteiGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 130,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "10",
                                                    "minLength": "0",
                                                    "maxValue": "99999999",
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "収入額",
                                                "dataName": "txtShunyuGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 130,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "10",
                                                    "minLength": "0",
                                                    "maxValue": "99999999",
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "時効到来未納額",
                                                "dataName": "txtJikoMinoGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 130,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "10",
                                                    "minLength": "0",
                                                    "maxValue": "99999999",
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
                                                "sortKey": ""
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
                                    "fieldName": "GenGakuKeisan",
                                    "items": [
                                        {
                                            "fieldName": "ChoshuKenKeimetsuKikan1",
                                            "items": [
                                                {
                                                    "fieldName": "lblChoShushometsu1",
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
                                                    "marginLeft": "3px",
                                                    "marginRight": "XS",
                                                    "selectControlID": "lblChoShushometsu1",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "required": false,
                                                    "isPrivateInfo": false,
                                                    "text": "徴収権消滅期間",
                                                    "decorationClass": "",
                                                    "align": 0
                                                },
                                                {
                                                    "fieldName": "txtChoShushometsu1",
                                                    "items": [],
                                                    "controlType": "TextBoxNum",
                                                    "width": "100px",
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
                                                    "marginLeft": "6px",
                                                    "marginRight": "XS",
                                                    "selectControlID": "txtChoShushometsu1_core",
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
                                                    "labelLText": "",
                                                    "labelRText": "",
                                                    "labelLWidth": "S",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "value": "",
                                                    "decorationClass": "",
                                                    "maxLength": "5",
                                                    "minLength": 0,
                                                    "textAlign": 2,
                                                    "textKind": 2,
                                                    "isComboBox": false,
                                                    "suggest": [],
                                                    "maxValue": "1",
                                                    "minValue": 0,
                                                    "isCurrency": false,
                                                    "isComma": false,
                                                    "decimalPointLength": "3",
                                                    "permitCharactor": "+-,.\\"
                                                },
                                                {
                                                    "fieldName": "Kakesan",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblKakesan",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "16px",
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
                                                            "marginRight": "0px",
                                                            "selectControlID": "lblKakesan",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "×",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "G2",
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
                                                    "marginRight": "0px",
                                                    "selectControlID": "Kakesan",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "-10px",
                                                    "marginBottom": "Default",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": true,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "Auto",
                                                    "focusPositionID": "accessKeyProperty",
                                                    "canPost": false
                                                }
                                            ],
                                            "controlType": "Panel",
                                            "width": "150px",
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
                                            "marginRight": "0px",
                                            "selectControlID": "ChoshuKenKeimetsuKikan1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "",
                                            "marginTop": "35px",
                                            "marginBottom": "Default",
                                            "isOpen": true,
                                            "canOpenAndClose": true,
                                            "postParameterPanelNames": [],
                                            "requestSettings": [],
                                            "hiddenInput": [],
                                            "onOpen": "",
                                            "onClose": "",
                                            "session": {},
                                            "eraseBorder": true,
                                            "backgroundColor": 0,
                                            "widthAuto": false,
                                            "panelDisplay": 0,
                                            "isGroupBox": false,
                                            "readOnly": false,
                                            "height": "Auto",
                                            "focusPositionID": "GenGakuInfo_panel_body_area",
                                            "canPost": false
                                        },
                                        {
                                            "fieldName": "ChoshuKenKeimetsuKikan2",
                                            "items": [
                                                {
                                                    "fieldName": "ChoshuKenKeimetsuKikan3",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblChoShushometsu2",
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
                                                            "marginLeft": "3px",
                                                            "marginRight": "XS",
                                                            "selectControlID": "lblChoShushometsu2",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "徴収権消滅期間",
                                                            "decorationClass": "",
                                                            "align": 0
                                                        },
                                                        {
                                                            "fieldName": "txtChoShushometsu2",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
                                                            "width": "100px",
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
                                                            "selectControlID": "txtChoShushometsu2_core",
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
                                                            "labelLText": "",
                                                            "labelRText": "",
                                                            "labelLWidth": "S",
                                                            "labelRWidth": "S",
                                                            "labelLAlign": 2,
                                                            "labelRAlign": 0,
                                                            "value": "",
                                                            "decorationClass": "",
                                                            "maxLength": "5",
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "textKind": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": "1",
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": "3",
                                                            "permitCharactor": "+-,.\\"
                                                        },
                                                        {
                                                            "fieldName": "lblLine",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "300px",
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
                                                            "marginLeft": "-80px",
                                                            "marginRight": "0px",
                                                            "selectControlID": "lblLine",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "──────────────────",
                                                            "decorationClass": "",
                                                            "align": 0
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "125px",
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
                                                    "selectControlID": "ChoshuKenKeimetsuKikan3",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "0px",
                                                    "marginBottom": "0px",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": false,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "50px",
                                                    "focusPositionID": "restoreLayoutButton",
                                                    "canPost": false
                                                },
                                                {
                                                    "fieldName": "ChoshuKenKeimetsuKikan4",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblChoShushometsu3",
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
                                                            "marginLeft": "3px",
                                                            "marginRight": "XS",
                                                            "selectControlID": "lblChoShushometsu3",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "徴収権消滅期間",
                                                            "decorationClass": "",
                                                            "align": 0
                                                        },
                                                        {
                                                            "fieldName": "txtChoShushometsu3",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
                                                            "width": "100px",
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
                                                            "selectControlID": "txtChoShushometsu3_core",
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
                                                            "labelLText": "",
                                                            "labelRText": "",
                                                            "labelLWidth": "S",
                                                            "labelRWidth": "S",
                                                            "labelLAlign": 2,
                                                            "labelRAlign": 0,
                                                            "value": "",
                                                            "decorationClass": "",
                                                            "maxLength": "5",
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "textKind": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": "1",
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": false,
                                                            "decimalPointLength": "3",
                                                            "permitCharactor": "+-,.\\"
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "125px",
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
                                                    "selectControlID": "ChoshuKenKeimetsuKikan4",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "0px",
                                                    "marginBottom": "0px",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": false,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "50px",
                                                    "focusPositionID": "restoreLayoutButton",
                                                    "canPost": false
                                                },
                                                {
                                                    "fieldName": "Kasan",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblKasan",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "16px",
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
                                                            "selectControlID": "lblKasan",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "＋",
                                                            "decorationClass": "",
                                                            "align": 2
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "G2",
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
                                                    "selectControlID": "Kasan",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "15px",
                                                    "marginBottom": "Default",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": true,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "Auto",
                                                    "focusPositionID": "accessKeyProperty",
                                                    "canPost": false
                                                },
                                                {
                                                    "fieldName": "NofuZumiKikan",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblNofuZumiKikan",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "100px",
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
                                                            "selectControlID": "lblNofuZumiKikan",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "納付済期間",
                                                            "decorationClass": "",
                                                            "align": 1
                                                        },
                                                        {
                                                            "fieldName": "txtNofuZumiKikan",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
                                                            "width": "100px",
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
                                                            "selectControlID": "txtNofuZumiKikan_core",
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
                                                            "labelLText": "",
                                                            "labelRText": "",
                                                            "labelLWidth": "80px",
                                                            "labelRWidth": "S",
                                                            "labelLAlign": 2,
                                                            "labelRAlign": 0,
                                                            "value": "",
                                                            "decorationClass": "",
                                                            "maxLength": "5",
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "textKind": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": "1",
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": false,
                                                            "decimalPointLength": "3",
                                                            "permitCharactor": "+-,.\\"
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "G2",
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
                                                    "selectControlID": "NofuZumiKikan",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "0px",
                                                    "marginBottom": "Default",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": true,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "Auto",
                                                    "focusPositionID": "restoreLayoutButton",
                                                    "canPost": false
                                                }
                                            ],
                                            "controlType": "Panel",
                                            "width": "320px",
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
                                            "marginLeft": "0px",
                                            "marginRight": "0px",
                                            "selectControlID": "ChoshuKenKeimetsuKikan2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "",
                                            "marginTop": "Default",
                                            "marginBottom": "Default",
                                            "isOpen": true,
                                            "canOpenAndClose": true,
                                            "postParameterPanelNames": [],
                                            "requestSettings": [],
                                            "hiddenInput": [],
                                            "onOpen": "",
                                            "onClose": "",
                                            "session": {},
                                            "eraseBorder": true,
                                            "backgroundColor": 0,
                                            "widthAuto": false,
                                            "panelDisplay": 0,
                                            "isGroupBox": false,
                                            "readOnly": false,
                                            "height": "Auto",
                                            "focusPositionID": "wrapProperty",
                                            "canPost": false
                                        },
                                        {
                                            "fieldName": "GnegakuKikan",
                                            "items": [
                                                {
                                                    "fieldName": "lblKeisanShiki",
                                                    "items": [],
                                                    "controlType": "Label",
                                                    "width": "160px",
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
                                                    "selectControlID": "lblKeisanShiki",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "required": false,
                                                    "isPrivateInfo": false,
                                                    "text": "× １／２ × １２ ＝",
                                                    "decorationClass": "",
                                                    "align": 0
                                                },
                                                {
                                                    "fieldName": "GenGakuKikan2",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblGenGakuKikan",
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
                                                            "float": 1,
                                                            "toolTip": "",
                                                            "authorityMode": 0,
                                                            "marginLeft": "XS",
                                                            "marginRight": "XS",
                                                            "selectControlID": "lblGenGakuKikan",
                                                            "helpMessageID": "",
                                                            "jpControlName": "",
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "給付額減額期間",
                                                            "decorationClass": "",
                                                            "align": 0
                                                        },
                                                        {
                                                            "fieldName": "txtGenGakuKikan",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
                                                            "width": "30px",
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
                                                            "marginLeft": "30px",
                                                            "marginRight": "XS",
                                                            "selectControlID": "txtGenGakuKikan_core",
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
                                                            "labelLText": "",
                                                            "labelRText": "ヵ月",
                                                            "labelLWidth": "30px",
                                                            "labelRWidth": "40px",
                                                            "labelLAlign": 2,
                                                            "labelRAlign": 0,
                                                            "value": "",
                                                            "decorationClass": "",
                                                            "maxLength": "3",
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "textKind": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": "1",
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": false,
                                                            "decimalPointLength": "",
                                                            "permitCharactor": "+-,.\\"
                                                        }
                                                    ],
                                                    "controlType": "Panel",
                                                    "width": "G2",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "XS",
                                                    "selectControlID": "GenGakuKikan2",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "onLoad": "",
                                                    "title": "",
                                                    "marginTop": "-10px",
                                                    "marginBottom": "Default",
                                                    "isOpen": true,
                                                    "canOpenAndClose": true,
                                                    "postParameterPanelNames": [],
                                                    "requestSettings": [],
                                                    "hiddenInput": [],
                                                    "onOpen": "",
                                                    "onClose": "",
                                                    "session": {},
                                                    "eraseBorder": true,
                                                    "backgroundColor": 0,
                                                    "widthAuto": true,
                                                    "panelDisplay": 0,
                                                    "isGroupBox": false,
                                                    "readOnly": false,
                                                    "height": "Auto",
                                                    "focusPositionID": "restoreLayoutButton",
                                                    "canPost": false
                                                }
                                            ],
                                            "controlType": "Panel",
                                            "width": "320px",
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
                                            "marginLeft": "0px",
                                            "marginRight": "XS",
                                            "selectControlID": "GnegakuKikan",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "",
                                            "marginTop": "50px",
                                            "marginBottom": "Default",
                                            "isOpen": true,
                                            "canOpenAndClose": true,
                                            "postParameterPanelNames": [],
                                            "requestSettings": [],
                                            "hiddenInput": [],
                                            "onOpen": "",
                                            "onClose": "",
                                            "session": {},
                                            "eraseBorder": true,
                                            "backgroundColor": 0,
                                            "widthAuto": false,
                                            "panelDisplay": 0,
                                            "isGroupBox": false,
                                            "readOnly": false,
                                            "height": "Auto",
                                            "focusPositionID": "GenGakuInfo_panel_body_area",
                                            "canPost": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "810px",
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
                                    "selectControlID": "GenGakuKeisan",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [],
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
                                    "focusPositionID": "GenGakuInfo_panel_body_area",
                                    "canPost": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1110px",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "TainoNendo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "収納情報",
                            "marginTop": "0px",
                            "marginBottom": "0px",
                            "isOpen": false,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [],
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
                            "canPost": false
                        },
                        {
                            "fieldName": "TainoGengakuShosaiInfo",
                            "items": [
                                {
                                    "fieldName": "chkHyojiKirikae",
                                    "items": [],
                                    "controlType": "CheckBoxList",
                                    "width": "380px",
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
                                    "marginRight": "200px",
                                    "selectControlID": "chkHyojiKirikae_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "onChange": "",
                                    "labelLText": "",
                                    "labelLWidth": "S",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "icon": [],
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "賦課年度、徴収方法、通知書番号を全行表示する"
                                        }
                                    ],
                                    "selectedItem": "",
                                    "selectedItems": [
                                        {
                                            "key": "key0",
                                            "value": "賦課年度、徴収方法、通知書番号を全行表示する"
                                        }
                                    ],
                                    "newLineItemNumber": 1,
                                    "minCheckedItem": 0,
                                    "maxCheckedItem": 2,
                                    "spaceSize": "M",
                                    "isAllSelectable": false,
                                    "isAllSelectableBreakLine": false,
                                    "disabledItem": []
                                },
                                {
                                    "fieldName": "txtNendo",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "40px",
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
                                    "selectControlID": "txtNendo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "required": false,
                                    "placeHolder": "平26",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "年度保険料",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 0,
                                    "labelRAlign": 0,
                                    "ymdKubun": 0,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "dgTainoShosaiInfo",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "890px",
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
                                    "selectControlID": "dgTainoShosaiInfo",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "height": "400px",
                                    "gridSetting": {
                                        "rowHeight": 25,
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
                                            "frozenColumn": "",
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "賦課年度",
                                                "dataName": "txtFukaNendo",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 70,
                                                "visible": true,
                                                "cellType": 6,
                                                "cellDetails": {
                                                    "cellType": 6,
                                                    "ymdKubun": 0,
                                                    "displayFormat": 0,
                                                    "onChange": "",
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "普／特",
                                                "dataName": "txtChoshuHoHo",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 60,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "2",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": "",
                                                    "textKind": 0,
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "通知書番号",
                                                "dataName": "txttsuchishoNo",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 140,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "16",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": "",
                                                    "textKind": 2,
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "期",
                                                "dataName": "txtKi",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 40,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "3",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": "",
                                                    "textKind": 0,
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "調定額",
                                                "dataName": "txtChoteiGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 80,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "7",
                                                    "minLength": "0",
                                                    "maxValue": "999999",
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "納期限",
                                                "dataName": "txtNokiGen",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 90,
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "収入額",
                                                "dataName": "txtShunyuGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 80,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "7",
                                                    "minLength": "0",
                                                    "maxValue": "999999",
                                                    "minValue": "0",
                                                    "isCurrency": false,
                                                    "isComma": false,
                                                    "decimalPointLength": "0",
                                                    "onChange": "",
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 2,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "未納額",
                                                "dataName": "txtMinoGaku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 80,
                                                "visible": true,
                                                "cellType": 5,
                                                "cellDetails": {
                                                    "cellType": 5,
                                                    "maxLength": "7",
                                                    "minLength": "0",
                                                    "maxValue": "999999",
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "今回",
                                                "dataName": "txtKokai",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 40,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "1",
                                                    "minLength": "0",
                                                    "textAlign": 1,
                                                    "onChange": "",
                                                    "textKind": 0,
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "時効起算日",
                                                "dataName": "txtJikoKisanYMD",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 90,
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
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "時効起算日事由",
                                                "dataName": "txtJikoKisanKbn",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 120,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "10",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": "",
                                                    "textKind": 0,
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 0,
                                                "resize": false,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
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
                                    "fieldName": "tblComment",
                                    "items": [
                                        {
                                            "fieldName": "celTainocolorKanno",
                                            "items": [
                                                {
                                                    "fieldName": "TainocolorKanno",
                                                    "items": [
                                                        {
                                                            "fieldName": "celWhite",
                                                            "items": [
                                                                {
                                                                    "fieldName": "lblColorWhite",
                                                                    "items": [],
                                                                    "controlType": "Label",
                                                                    "width": "20px",
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
                                                                    "marginLeft": "0px",
                                                                    "marginRight": "0px",
                                                                    "selectControlID": "lblColorWhite",
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
                                                            "selectControlID": "celWhite",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "TainocolorKanno",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='white'></td></tr>\n  </tbody>\n</table>\n"
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
                                            "selectControlID": "celTainocolorKanno",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R1C1"
                                        },
                                        {
                                            "fieldName": "celTainoSetsumeiKanno",
                                            "items": [
                                                {
                                                    "fieldName": "lblTainoSetsumeiKanno",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "lblTainoSetsumeiKanno",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "required": false,
                                                    "isPrivateInfo": false,
                                                    "text": "完納／未来納期",
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
                                            "selectControlID": "celTainoSetsumeiKanno",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R1C2"
                                        },
                                        {
                                            "fieldName": "celTainocolorMitorai",
                                            "items": [
                                                {
                                                    "fieldName": "TainocolorMitorai",
                                                    "items": [
                                                        {
                                                            "fieldName": "celDummyYellow",
                                                            "items": [
                                                                {
                                                                    "fieldName": "lblDummyYellow",
                                                                    "items": [],
                                                                    "controlType": "Label",
                                                                    "width": "20px",
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
                                                                    "marginLeft": "0px",
                                                                    "marginRight": "0px",
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
                                                            "selectControlID": "celDummyYellow",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "TainocolorMitorai",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='yellow'></td></tr>\n  </tbody>\n</table>\n"
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
                                            "selectControlID": "celTainocolorMitorai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R2C1"
                                        },
                                        {
                                            "fieldName": "celTainoSetsumeiMiTorai",
                                            "items": [
                                                {
                                                    "fieldName": "lblTainoSetsumeiMiTorai",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "lblTainoSetsumeiMiTorai",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "required": false,
                                                    "isPrivateInfo": false,
                                                    "text": "未納・時効未到来",
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
                                            "selectControlID": "celTainoSetsumeiMiTorai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R2C2"
                                        },
                                        {
                                            "fieldName": "celTainocolorTorai",
                                            "items": [
                                                {
                                                    "fieldName": "TainocolorTorai",
                                                    "items": [
                                                        {
                                                            "fieldName": "celDummyRed",
                                                            "items": [
                                                                {
                                                                    "fieldName": "lblDummyRed",
                                                                    "items": [],
                                                                    "controlType": "Label",
                                                                    "width": "20px",
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
                                                                    "marginLeft": "0px",
                                                                    "marginRight": "0px",
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
                                                            "selectControlID": "celDummyRed",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "TainocolorTorai",
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
                                            "selectControlID": "celTainocolorTorai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R3C1"
                                        },
                                        {
                                            "fieldName": "celTainoSetsumeiTorai",
                                            "items": [
                                                {
                                                    "fieldName": "lblTainoSetsumeiTorai",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "lblTainoSetsumeiTorai",
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
                                            "selectControlID": "celTainoSetsumeiTorai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R3C2"
                                        },
                                        {
                                            "fieldName": "celTainocolorTaishoGai",
                                            "items": [
                                                {
                                                    "fieldName": "TainocolorTaishoGai",
                                                    "items": [
                                                        {
                                                            "fieldName": "celLightSalmon",
                                                            "items": [
                                                                {
                                                                    "fieldName": "lblLightSalmon",
                                                                    "items": [],
                                                                    "controlType": "Label",
                                                                    "width": "20px",
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
                                                                    "marginLeft": "0px",
                                                                    "marginRight": "0px",
                                                                    "selectControlID": "lblLightSalmon",
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
                                                            "selectControlID": "celLightSalmon",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "TainocolorTaishoGai",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "html": "<table border=\"1\" cellspacing=0 cellpadding=0 span style=\"font-size:4pt\">\n  <tbody>\n    <tr><td id='R1C1' bgcolor='lightsalmon'></td></tr>\n  </tbody>\n</table>\n"
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
                                            "selectControlID": "celTainocolorTaishoGai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R4C1"
                                        },
                                        {
                                            "fieldName": "celTainoSetsumeiTaishoGai",
                                            "items": [
                                                {
                                                    "fieldName": "lblTainoSetsumeiTaishoGai",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "XS",
                                                    "selectControlID": "lblTainoSetsumeiTaishoGai",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "required": false,
                                                    "isPrivateInfo": false,
                                                    "text": "未納・時効対象外",
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
                                            "selectControlID": "celTainoSetsumeiTaishoGai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R4C2"
                                        },
                                        {
                                            "fieldName": "celTainocolorKano",
                                            "items": [
                                                {
                                                    "fieldName": "TainocolorKano",
                                                    "items": [
                                                        {
                                                            "fieldName": "celDummyGreen",
                                                            "items": [
                                                                {
                                                                    "fieldName": "lblDummyGreen",
                                                                    "items": [],
                                                                    "controlType": "Label",
                                                                    "width": "20px",
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
                                                                    "marginLeft": "0px",
                                                                    "marginRight": "0px",
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
                                                            "selectControlID": "celDummyGreen",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
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
                                            "selectControlID": "celTainocolorKano",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R5C1"
                                        },
                                        {
                                            "fieldName": "celTainoSetsumeiKano",
                                            "items": [
                                                {
                                                    "fieldName": "lblTainoSetsumeiKano",
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
                                                    "marginLeft": "0px",
                                                    "marginRight": "0px",
                                                    "selectControlID": "lblTainoSetsumeiKano",
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
                                            "selectControlID": "celTainoSetsumeiKano",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "connectTd": "R5C2"
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
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tblComment",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1'></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1'></td><td id='R5C2'></td></tr>\n  </tbody>\n</table>\n"
                                },
                                {
                                    "fieldName": "Modoru",
                                    "items": [
                                        {
                                            "fieldName": "btnModoru",
                                            "items": [],
                                            "controlType": "Button",
                                            "width": "140px",
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
                                            "selectControlID": "btnModoru",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "text": "収納情報に戻る",
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
                                    "width": "G2",
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
                                    "marginRight": "0px",
                                    "selectControlID": "Modoru",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "200px",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [],
                                    "requestSettings": [],
                                    "hiddenInput": [],
                                    "onOpen": "",
                                    "onClose": "",
                                    "session": {},
                                    "eraseBorder": true,
                                    "backgroundColor": 0,
                                    "widthAuto": true,
                                    "panelDisplay": 0,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "canPost": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1110px",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
                            "selectControlID": "TainoGengakuShosaiInfo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "滞納状況詳細（減額用）",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [],
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
                            "focusPositionID": "GenGakuInfo_panel_body_area",
                            "canPost": false
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
                    "width": "1110px",
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
                    "selectControlID": "GenGakuInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "減額情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [],
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
                    "focusPositionID": "restoreLayoutButton",
                    "canPost": false
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
            "marginLeft": "0px",
            "marginRight": "0px",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBZ",
            "controlName": "GenGakuInfo",
            "marginTop": "0px",
            "marginBottom": "0px",
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
        return GenGakuInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.GenGakuInfo_Design = GenGakuInfo_Design;

    (function (GenGakuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        GenGakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GenGakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.GenGakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.GenGakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GenGakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TainoNendo = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo"));
            };

            Controls.prototype.txtHanteiKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.dgGenGaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgGenGaku"));
            };

            Controls.prototype.GenGakuKeisan = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan1 = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan1"));
            };

            Controls.prototype.lblChoShushometsu1 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu1"));
            };

            Controls.prototype.txtChoShushometsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu1"));
            };

            Controls.prototype.Kakesan = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan1_Kakesan"));
            };

            Controls.prototype.lblKakesan = function () {
                return new UZA.Label(this.convFiledName("lblKakesan"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan2 = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan3 = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_ChoshuKenKeimetsuKikan3"));
            };

            Controls.prototype.lblChoShushometsu2 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu2"));
            };

            Controls.prototype.txtChoShushometsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu2"));
            };

            Controls.prototype.lblLine = function () {
                return new UZA.Label(this.convFiledName("lblLine"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan4 = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_ChoshuKenKeimetsuKikan4"));
            };

            Controls.prototype.lblChoShushometsu3 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu3"));
            };

            Controls.prototype.txtChoShushometsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu3"));
            };

            Controls.prototype.Kasan = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_Kasan"));
            };

            Controls.prototype.lblKasan = function () {
                return new UZA.Label(this.convFiledName("lblKasan"));
            };

            Controls.prototype.NofuZumiKikan = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_ChoshuKenKeimetsuKikan2_NofuZumiKikan"));
            };

            Controls.prototype.lblNofuZumiKikan = function () {
                return new UZA.Label(this.convFiledName("lblNofuZumiKikan"));
            };

            Controls.prototype.txtNofuZumiKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuZumiKikan"));
            };

            Controls.prototype.GnegakuKikan = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_GnegakuKikan"));
            };

            Controls.prototype.lblKeisanShiki = function () {
                return new UZA.Label(this.convFiledName("lblKeisanShiki"));
            };

            Controls.prototype.GenGakuKikan2 = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo_GenGakuKeisan_GnegakuKikan_GenGakuKikan2"));
            };

            Controls.prototype.lblGenGakuKikan = function () {
                return new UZA.Label(this.convFiledName("lblGenGakuKikan"));
            };

            Controls.prototype.txtGenGakuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenGakuKikan"));
            };

            Controls.prototype.TainoGengakuShosaiInfo = function () {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo"));
            };

            Controls.prototype.chkHyojiKirikae = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHyojiKirikae"));
            };

            Controls.prototype.txtNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNendo"));
            };

            Controls.prototype.dgTainoShosaiInfo = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoShosaiInfo"));
            };

            Controls.prototype.tblComment = function () {
                return new UZA.TablePanel(this.convFiledName("tblComment"));
            };

            Controls.prototype.celTainocolorKanno = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorKanno"));
            };

            Controls.prototype.TainocolorKanno = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            };

            Controls.prototype.celWhite = function () {
                return new UZA.TableCell(this.convFiledName("celWhite"));
            };

            Controls.prototype.lblColorWhite = function () {
                return new UZA.Label(this.convFiledName("lblColorWhite"));
            };

            Controls.prototype.celTainoSetsumeiKanno = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKanno"));
            };

            Controls.prototype.lblTainoSetsumeiKanno = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKanno"));
            };

            Controls.prototype.celTainocolorMitorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorMitorai"));
            };

            Controls.prototype.TainocolorMitorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            };

            Controls.prototype.celDummyYellow = function () {
                return new UZA.TableCell(this.convFiledName("celDummyYellow"));
            };

            Controls.prototype.lblDummyYellow = function () {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            };

            Controls.prototype.celTainoSetsumeiMiTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiMiTorai"));
            };

            Controls.prototype.lblTainoSetsumeiMiTorai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiMiTorai"));
            };

            Controls.prototype.celTainocolorTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorTorai"));
            };

            Controls.prototype.TainocolorTorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorTorai"));
            };

            Controls.prototype.celDummyRed = function () {
                return new UZA.TableCell(this.convFiledName("celDummyRed"));
            };

            Controls.prototype.lblDummyRed = function () {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            };

            Controls.prototype.celTainoSetsumeiTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTorai"));
            };

            Controls.prototype.lblTainoSetsumeiTorai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTorai"));
            };

            Controls.prototype.celTainocolorTaishoGai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorTaishoGai"));
            };

            Controls.prototype.TainocolorTaishoGai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorTaishoGai"));
            };

            Controls.prototype.celLightSalmon = function () {
                return new UZA.TableCell(this.convFiledName("celLightSalmon"));
            };

            Controls.prototype.lblLightSalmon = function () {
                return new UZA.Label(this.convFiledName("lblLightSalmon"));
            };

            Controls.prototype.celTainoSetsumeiTaishoGai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTaishoGai"));
            };

            Controls.prototype.lblTainoSetsumeiTaishoGai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTaishoGai"));
            };

            Controls.prototype.celTainocolorKano = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorKano"));
            };

            Controls.prototype.TainocolorKano = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            };

            Controls.prototype.celDummyGreen = function () {
                return new UZA.TableCell(this.convFiledName("celDummyGreen"));
            };

            Controls.prototype.lblDummyGreen = function () {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            };

            Controls.prototype.celTainoSetsumeiKano = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKano"));
            };

            Controls.prototype.lblTainoSetsumeiKano = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKano"));
            };

            Controls.prototype.Modoru = function () {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo_Modoru"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        GenGakuInfo.Controls = Controls;
    })(DBZ.GenGakuInfo || (DBZ.GenGakuInfo = {}));
    var GenGakuInfo = DBZ.GenGakuInfo;
})(DBZ || (DBZ = {}));
