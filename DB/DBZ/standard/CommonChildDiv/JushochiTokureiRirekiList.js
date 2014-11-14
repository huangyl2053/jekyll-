var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var JushochiTokureiRirekiList_Design = (function (_super) {
        __extends(JushochiTokureiRirekiList_Design, _super);
        function JushochiTokureiRirekiList_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JushochiTokureiRirekiList_Design.myLayout, fieldName);
        }
        JushochiTokureiRirekiList_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JushochiTokureiRirekiList_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JushochiTokureiRirekiList_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JushochiTokureiRirekiList",
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
                            "text": "追加する",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgJutoku",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1070px",
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
                            "selectControlID": "dgJutoku",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "217px",
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
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "適用情報",
                                            "combineItem": [
                                                "tekiyoDate",
                                                "tekiyoTodokedeDate",
                                                "tekiyoJiyu",
                                                "tekiyoJiyuKey"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "解除情報",
                                            "combineItem": [
                                                "kaijoDate",
                                                "kaijoTodokedeDate",
                                                "kaijoJiyu",
                                                "kaijoJiyuKey"
                                            ]
                                        }
                                    ],
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
                                        "columnName": "適用日",
                                        "dataName": "tekiyoDate",
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
                                        "sortKey": "tekiyoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "tekiyoTodokedeDate",
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
                                        "sortKey": "tekiyoTodokedeDate"
                                    },
                                    {
                                        "columnName": "適用事由",
                                        "dataName": "tekiyoJiyu",
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
                                        "sortKey": "tekiyoJiyu"
                                    },
                                    {
                                        "columnName": "適用事由Key",
                                        "dataName": "tekiyoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "tekiyoJiyuKey"
                                    },
                                    {
                                        "columnName": "解除日",
                                        "dataName": "kaijoDate",
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
                                        "sortKey": "kaijoDate"
                                    },
                                    {
                                        "columnName": "届出日",
                                        "dataName": "kaijoTodokedeDate",
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
                                        "sortKey": "kaijoTodokedeDate"
                                    },
                                    {
                                        "columnName": "解除事由",
                                        "dataName": "kaijoJiyu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyu"
                                    },
                                    {
                                        "columnName": "解除事由Key",
                                        "dataName": "kaijoJiyuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 1,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyuKey"
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
                            "onSelect": "onSelect_dgJutoku",
                            "onSelectByDblClick": "onSelectByDblClick_dgJutoku",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgJutoku",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgJutoku",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "sortOrder": "tekiyoDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "JutokuInput",
                            "items": [
                                {
                                    "fieldName": "JutokuTekiyoInput",
                                    "items": [
                                        {
                                            "fieldName": "txtTekiyoDate",
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
                                            "selectControlID": "txtTekiyoDate_core",
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
                                            "value": "",
                                            "labelLText": "適用日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "txtTekiyoTodokedeDate",
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
                                            "selectControlID": "txtTekiyoTodokedeDate_core",
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
                                            "value": "",
                                            "labelLText": "届出日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "ddlTekiyoJiyu",
                                            "items": [],
                                            "controlType": "DropDownList",
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
                                            "selectControlID": "ddlTekiyoJiyu_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "適用事由",
                                            "labelRText": "",
                                            "labelLWidth": "65px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
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
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "tekiyojiHokenshaJoho",
                                            "items": [
                                                {
                                                    "fieldName": "ddlTekiyojiShozaiHokensha",
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
                                                    "selectControlID": "ddlTekiyojiShozaiHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiSochimotoHokensha",
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
                                                    "selectControlID": "ddlTekiyojiSochimotoHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiKyuHokensha",
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
                                                    "selectControlID": "ddlTekiyojiKyuHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlTekiyojiJuminJoho",
                                                    "items": [],
                                                    "controlType": "DropDownList",
                                                    "width": "600px",
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
                                                    "selectControlID": "ddlTekiyojiJuminJoho_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
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
                                            "selectControlID": "tekiyojiHokenshaJoho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "保険者・住民情報",
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
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "800px",
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
                                    "selectControlID": "JutokuTekiyoInput",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "適用情報入力",
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
                                    "panelDisplay": 1,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "focusPositionID": "restoreLayoutButton",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "JutokuKaijoInput",
                                    "items": [
                                        {
                                            "fieldName": "txtKaijoDate",
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
                                            "selectControlID": "txtKaijoDate_core",
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
                                            "value": "",
                                            "labelLText": "解除日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "txtKaijoTodokedeDate",
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
                                            "selectControlID": "txtKaijoTodokedeDate_core",
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
                                            "value": "",
                                            "labelLText": "届出日",
                                            "labelRText": "",
                                            "labelLWidth": "50px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "ddlKaijoJiyu",
                                            "items": [],
                                            "controlType": "DropDownList",
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
                                            "selectControlID": "ddlKaijoJiyu_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "解除事由",
                                            "labelRText": "",
                                            "labelLWidth": "65px",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "selectedItem": "",
                                            "dataSource": [
                                                {
                                                    "key": "key0",
                                                    "value": ""
                                                },
                                                {
                                                    "key": "key1",
                                                    "value": ""
                                                }
                                            ],
                                            "isBlankLine": true
                                        },
                                        {
                                            "fieldName": "kaijojiHokenshaJoho",
                                            "items": [
                                                {
                                                    "fieldName": "ddlKaijojiShozaiHokensha",
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
                                                    "selectControlID": "ddlKaijojiShozaiHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiSochimotoHokensha",
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
                                                    "selectControlID": "ddlKaijojiSochimotoHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiKyuHokensha",
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
                                                    "selectControlID": "ddlKaijojiKyuHokensha_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                                    "dataSource": [
                                                        {
                                                            "key": "key0",
                                                            "value": ""
                                                        },
                                                        {
                                                            "key": "key1",
                                                            "value": ""
                                                        }
                                                    ],
                                                    "isBlankLine": true
                                                },
                                                {
                                                    "fieldName": "ddlKaijojiJuminJono",
                                                    "items": [],
                                                    "controlType": "DropDownList",
                                                    "width": "600px",
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
                                                    "selectControlID": "ddlKaijojiJuminJono_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
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
                                            "selectControlID": "kaijojiHokenshaJoho",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "保険者・住民情報",
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
                                            "readOnly": true,
                                            "height": "Auto",
                                            "focusPositionID": "labelRTextProperty",
                                            "canPost": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "800px",
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
                                    "selectControlID": "JutokuKaijoInput",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "解除情報入力",
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
                                    "eraseBorder": true,
                                    "backgroundColor": 0,
                                    "widthAuto": false,
                                    "panelDisplay": 1,
                                    "isGroupBox": false,
                                    "readOnly": false,
                                    "height": "Auto",
                                    "focusPositionID": "restoreLayoutButton",
                                    "canPost": false
                                },
                                {
                                    "fieldName": "btnJutokuKakutei",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "110px",
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
                                    "selectControlID": "btnJutokuKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "確定する",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnJutokuKakutei",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnJutokuTorikeshi",
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
                                    "selectControlID": "btnJutokuTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "text": "取消する",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnJutokuTorikeshi",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "820px",
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
                            "marginLeft": "0em",
                            "marginRight": "XS",
                            "selectControlID": "JutokuInput",
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
                            "readOnly": true,
                            "height": "Auto",
                            "focusPositionID": "restoreLayoutButton",
                            "canPost": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1075px",
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
                    "selectControlID": "JushochiTokureiRirekiList",
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
            "controlName": "JushochiTokureiRirekiList",
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
                    "eventName": "onSelect_dgJutoku"
                },
                {
                    "eventName": "onSelectByDblClick_dgJutoku"
                },
                {
                    "eventName": "onSelectByModifyButton_dgJutoku"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgJutoku"
                }
            ],
            "publicEventsAlias": []
        };
        return JushochiTokureiRirekiList_Design;
    })(Uz.CommonChildDiv);
    DBZ.JushochiTokureiRirekiList_Design = JushochiTokureiRirekiList_Design;

    (function (JushochiTokureiRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJutoku = function () {
                return "onSelect_dgJutoku";
            };

            Events.onSelectByDblClick_dgJutoku = function () {
                return "onSelectByDblClick_dgJutoku";
            };

            Events.onSelectByModifyButton_dgJutoku = function () {
                return "onSelectByModifyButton_dgJutoku";
            };

            Events.onSelectByDeleteButton_dgJutoku = function () {
                return "onSelectByDeleteButton_dgJutoku";
            };

            Events.onClick_btnJutokuKakutei = function () {
                return "onClick_btnJutokuKakutei";
            };

            Events.onClick_btnJutokuTorikeshi = function () {
                return "onClick_btnJutokuTorikeshi";
            };
            return Events;
        })();
        JushochiTokureiRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };

            Controls.prototype.JutokuInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            };

            Controls.prototype.JutokuTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.tekiyojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            };

            Controls.prototype.ddlTekiyojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            };

            Controls.prototype.ddlTekiyojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            };

            Controls.prototype.ddlTekiyojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            };

            Controls.prototype.ddlTekiyojiJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            };

            Controls.prototype.JutokuKaijoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            };

            Controls.prototype.txtKaijoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            };

            Controls.prototype.kaijojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            };

            Controls.prototype.ddlKaijojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            };

            Controls.prototype.ddlKaijojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            };

            Controls.prototype.ddlKaijojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            };

            Controls.prototype.ddlKaijojiJuminJono = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            };

            Controls.prototype.btnJutokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            };

            Controls.prototype.btnJutokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "BtnDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.ShoriNichijiDisplayMode = function () {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            };

            ModeController.prototype.MeisaiDisplayMode = function () {
                return new Modes.MeisaiDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRirekiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var MeisaiDisplayMode = (function () {
                function MeisaiDisplayMode(controls) {
                    this.controls = controls;
                }
                MeisaiDisplayMode.prototype.tekiyoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    this.controls.tekiyojiHokenshaJoho().readOnly = true;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = true;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.kaijoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    this.controls.kaijojiHokenshaJoho().readOnly = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = true;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.tekiyoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.kaijoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.TeiseiInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.displayNone = function () {
                    this.controls.JutokuInput().displayNone = true;
                };
                return MeisaiDisplayMode;
            })();
            Modes.MeisaiDisplayMode = MeisaiDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = true;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = true;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgJutoku().width = 1070;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgJutoku().width = 1030;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgJutoku().width = 1020;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgJutoku().width = 950;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgJutoku().width = 910;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgJutoku().width = 900;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgJutoku().width = 830;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgJutoku().width = 790;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgJutoku().width = 780;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgJutoku().width = 710;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgJutoku().width = 660;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgJutoku().height = 450;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgJutoku().height = 400;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgJutoku().height = 350;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgJutoku().height = 300;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgJutoku().height = 250;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgJutoku().height = 200;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(JushochiTokureiRirekiList.Modes || (JushochiTokureiRirekiList.Modes = {}));
        var Modes = JushochiTokureiRirekiList.Modes;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
