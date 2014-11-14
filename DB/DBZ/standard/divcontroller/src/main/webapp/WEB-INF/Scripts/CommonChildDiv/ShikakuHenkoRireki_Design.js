var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var ShikakuHenkoRireki_Design = (function (_super) {
        __extends(ShikakuHenkoRireki_Design, _super);
        function ShikakuHenkoRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShikakuHenkoRireki_Design.myLayout, fieldName);
        }
        ShikakuHenkoRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShikakuHenkoRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShikakuHenkoRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShikakuHenkoRireki",
                    "items": [
                        {
                            "fieldName": "btnAdd",
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
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnAdd",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgHenko",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "870px",
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
                            "selectControlID": "dgHenko",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "217px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": false,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
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
                                        "columnName": "状態",
                                        "dataName": "state",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "state"
                                    },
                                    {
                                        "columnName": "変更日",
                                        "dataName": "henkoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "henkoTodokedeDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoTodokedeDate"
                                    },
                                    {
                                        "columnName": "変更事由",
                                        "dataName": "henkoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoJiyu"
                                    },
                                    {
                                        "columnName": "変更事由Key",
                                        "dataName": "henkoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "henkoJiyuKey"
                                    },
                                    {
                                        "columnName": "所在保険者",
                                        "dataName": "shozaiHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shozaiHokensha"
                                    },
                                    {
                                        "columnName": "措置元保険者",
                                        "dataName": "sochimotoHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochimotoHokensha"
                                    },
                                    {
                                        "columnName": "旧保険者",
                                        "dataName": "kyuHokensha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kyuHokensha"
                                    },
                                    {
                                        "columnName": "処理日時",
                                        "dataName": "shoriDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 7,
                                        "cellDetails": {
                                            "cellType": 7,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shoriDate"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgHenko",
                            "onSelectByDblClick": "onSelectByDblClick_dgHenko",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgHenko",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgHenko",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "henkoTodokedeDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "HenkoInput",
                            "items": [
                                {
                                    "fieldName": "txtHenkoDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtHenkoDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "変更日",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": ""
                                },
                                {
                                    "fieldName": "txtHenkoTodokedeDate",
                                    "items": [],
                                    "controlType": "TextBoxFlexibleDate",
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
                                    "selectControlID": "txtHenkoTodokedeDate_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "変更届出日",
                                    "labelRText": "",
                                    "labelLWidth": "80px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": ""
                                },
                                {
                                    "fieldName": "ddlHenkoJiyu",
                                    "items": [],
                                    "controlType": "DropDownList",
                                    "width": "150px",
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
                                    "selectControlID": "ddlHenkoJiyu_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "key0",
                                            "value": "value0"
                                        },
                                        {
                                            "key": "key1",
                                            "value": "value1"
                                        }
                                    ],
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "変更事由",
                                    "labelRText": "",
                                    "labelLWidth": "70px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "",
                                    "isBlankLine": true
                                },
                                {
                                    "fieldName": "HenkoHokenshaJoho",
                                    "items": [
                                        {
                                            "fieldName": "ddlHenkoShozaiHokensha",
                                            "items": [],
                                            "controlType": "DropDownList",
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
                                            "marginRight": "XS",
                                            "selectControlID": "ddlHenkoShozaiHokensha_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "value0"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "value1"
                                                }
                                            ],
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "所在保険者",
                                            "labelRText": "",
                                            "labelLWidth": "80px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlHenkoSochimotoHokensha",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "150px",
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
                                            "selectControlID": "ddlHenkoSochimotoHokensha_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "value0"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "value1"
                                                }
                                            ],
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "措置元保険者",
                                            "labelRText": "",
                                            "labelLWidth": "100px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlHenkoKyuHokensha",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "150px",
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
                                            "selectControlID": "ddlHenkoKyuHokensha_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "value0"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "value1"
                                                }
                                            ],
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "旧保険者",
                                            "labelRText": "",
                                            "labelLWidth": "70px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "ddlJuminJoho",
                                            "items": [],
                                            "controlType": "DropDownList",
                                            "width": "750px",
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
                                            "selectControlID": "ddlJuminJoho_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": "value0"
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": "value1"
                                                }
                                            ],
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "住民情報",
                                            "labelRText": "",
                                            "labelLWidth": "80px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "isBlankLine": true
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "G2",
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
                                    "selectControlID": "HenkoHokenshaJoho",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "保険者",
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
                                    "widthAuto": true,
                                    "panelDisplay": 1,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "focusPositionID": "labelRTextProperty",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "btnHenkoKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnHenkoKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnHenkoKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnHenkoTorikeshi",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnHenkoTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnHenkoTorikeshi",
                                    "text": "取消する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "870px",
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
                            "selectControlID": "HenkoInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "資格変更入力",
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
                            "readOnly": true,
                            "height": "Auto",
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "880px",
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
                    "selectControlID": "ShikakuHenkoRireki",
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
                    "widthAuto": true,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto",
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
            "controlName": "ShikakuHenkoRireki",
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
            "publicEvents": [
                {
                    "eventName": "onClick_btnAdd"
                },
                {
                    "eventName": "onSelect_dgHenko"
                },
                {
                    "eventName": "onSelectByDblClick_dgHenko"
                },
                {
                    "eventName": "onSelectByModifyButton_dgHenko"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgHenko"
                }
            ],
            "publicEventsAlias": []
        };
        return ShikakuHenkoRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShikakuHenkoRireki_Design = ShikakuHenkoRireki_Design;

    (function (ShikakuHenkoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgHenko = function () {
                return "onSelect_dgHenko";
            };

            Events.onSelectByDblClick_dgHenko = function () {
                return "onSelectByDblClick_dgHenko";
            };

            Events.onSelectByModifyButton_dgHenko = function () {
                return "onSelectByModifyButton_dgHenko";
            };

            Events.onSelectByDeleteButton_dgHenko = function () {
                return "onSelectByDeleteButton_dgHenko";
            };

            Events.onClick_btnHenkoKakutei = function () {
                return "onClick_btnHenkoKakutei";
            };

            Events.onClick_btnHenkoTorikeshi = function () {
                return "onClick_btnHenkoTorikeshi";
            };
            return Events;
        })();
        ShikakuHenkoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgHenko = function () {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            };

            Controls.prototype.HenkoInput = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput"));
            };

            Controls.prototype.txtHenkoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoDate"));
            };

            Controls.prototype.txtHenkoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTodokedeDate"));
            };

            Controls.prototype.ddlHenkoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoJiyu"));
            };

            Controls.prototype.HenkoHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput_HenkoHokenshaJoho"));
            };

            Controls.prototype.ddlHenkoShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoShozaiHokensha"));
            };

            Controls.prototype.ddlHenkoSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoSochimotoHokensha"));
            };

            Controls.prototype.ddlHenkoKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoKyuHokensha"));
            };

            Controls.prototype.ddlJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJuminJoho"));
            };

            Controls.prototype.btnHenkoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnHenkoKakutei"));
            };

            Controls.prototype.btnHenkoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnHenkoTorikeshi"));
            };
            return Controls;
        })();
        ShikakuHenkoRireki.Controls = Controls;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
