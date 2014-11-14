var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var IryoHokenRireki_Design = (function (_super) {
        __extends(IryoHokenRireki_Design, _super);
        function IryoHokenRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, IryoHokenRireki_Design.myLayout, fieldName);
        }
        IryoHokenRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        IryoHokenRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        IryoHokenRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "IryoHokenRireki",
                    "items": [
                        {
                            "fieldName": "btnAddIryoHoken",
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
                            "selectControlID": "btnAddIryoHoken",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAddIryoHoken",
                            "text": "追加する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": true
                        },
                        {
                            "fieldName": "dgIryoHokenRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "980px",
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
                            "marginRight": "0em",
                            "selectControlID": "dgIryoHokenRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "S",
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
                                        "columnName": "加入日",
                                        "dataName": "kanyuDate",
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
                                        "sortKey": "kanyuDate"
                                    },
                                    {
                                        "columnName": "脱退日",
                                        "dataName": "dattaiDate",
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
                                        "sortKey": "dattaiDate"
                                    },
                                    {
                                        "columnName": "種別key",
                                        "dataName": "iryoHokenShubetsuKey",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 0,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "iryoHokenShubetsuKey"
                                    },
                                    {
                                        "columnName": "種別",
                                        "dataName": "iryoHokenShubetsu",
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
                                        "sortKey": "iryoHokenShubetsu"
                                    },
                                    {
                                        "columnName": "保険者番号",
                                        "dataName": "hokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 1,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "hokenshaNo"
                                    },
                                    {
                                        "columnName": "保険者名称",
                                        "dataName": "hokenshaMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
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
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "hokensha"
                                    },
                                    {
                                        "columnName": "記号番号",
                                        "dataName": "kigoNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 270,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kigoNo"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgIryoHokenRireki",
                            "onSelectByDblClick": "onSelectByDbClick_dgIryoHokenRireki",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgIryoHokenRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgIryoHokenRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "hokensha",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
                        },
                        {
                            "fieldName": "IryoHokenInput",
                            "items": [
                                {
                                    "fieldName": "txtIryoHokenKanyuDate",
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
                                    "selectControlID": "txtIryoHokenKanyuDate_core",
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
                                    "labelLText": "加入日",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
                                    "labelRWidth": "0px",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "textKind": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtIryoHokenDattaiDate",
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
                                    "selectControlID": "txtIryoHokenDattaiDate_core",
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
                                    "labelLText": "脱退日",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "textKind": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "ddlIryoHokenShubetsu",
                                    "items": [],
                                    "controlType": "DropDownList",
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
                                    "selectControlID": "ddlIryoHokenShubetsu_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "dataSource": [
                                        {
                                            "key": "kyokai",
                                            "value": "協会健康保険"
                                        },
                                        {
                                            "key": "kumiai",
                                            "value": "組合健康保険"
                                        },
                                        {
                                            "key": "hiyatoi",
                                            "value": "日雇い健康保険"
                                        },
                                        {
                                            "key": "senin",
                                            "value": "船員健康保険"
                                        },
                                        {
                                            "key": "kyousai",
                                            "value": "共済組合保険"
                                        },
                                        {
                                            "key": "ippanKokuminn",
                                            "value": "一般国民健康保険"
                                        },
                                        {
                                            "key": "taishokuKokumin",
                                            "value": "退職国民健康保険"
                                        },
                                        {
                                            "key": "kukmiaiKokumin",
                                            "value": "組合国民健康保険"
                                        }
                                    ],
                                    "required": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "labelLText": "種別",
                                    "labelRText": "",
                                    "labelLWidth": "35px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "selectedItem": "kyokai",
                                    "isBlankLine": false
                                },
                                {
                                    "fieldName": "txtIryoHokenHokenshaNo",
                                    "items": [],
                                    "controlType": "TextBoxCode",
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
                                    "selectControlID": "txtIryoHokenHokenshaNo_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": false,
                                    "text": "",
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "onBlur_txtIryoHokenHokenshaNo",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "labelLText": "保険者",
                                    "labelRText": "",
                                    "labelLWidth": "50px",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "decorationClass": "",
                                    "maxLength": 100000000,
                                    "minLength": "0000000000",
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtIryoHokenHokenshaMeisho",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "250px",
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
                                    "selectControlID": "txtIryoHokenHokenshaMeisho_core",
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
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
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
                                    "fieldName": "txtIryoHokenKigoNo",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "440px",
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
                                    "selectControlID": "txtIryoHokenKigoNo_core",
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
                                    "labelLText": "記号番号",
                                    "labelRText": "",
                                    "labelLWidth": "67px",
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
                                    "fieldName": "btnIryoHokenKakutei",
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
                                    "selectControlID": "btnIryoHokenKakutei",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnIryoHokenKakutei",
                                    "text": "確定する",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": "",
                                    "icon": 0,
                                    "heightTextBoxMatches": true
                                },
                                {
                                    "fieldName": "btnIryoHokenTorikeshi",
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
                                    "marginRight": "0em",
                                    "selectControlID": "btnIryoHokenTorikeshi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onBeforeClick": "",
                                    "onAfterClick": "",
                                    "onClick": "onClick_btnIryoHokenTorikeshi",
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
                            "width": "980px",
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
                            "marginLeft": "Default",
                            "marginRight": "Default",
                            "selectControlID": "IryoHokenInput",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "医療保険",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [],
                            "requestSettings": [
                                {
                                    "eventName": "onLoad",
                                    "requestUrl": ""
                                }
                            ],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": true,
                            "height": "Auto",
                            "canPost": true
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1015px",
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
                    "selectControlID": "IryoHokenRireki",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "IryoHokenRireki"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "mode",
                            "value": ""
                        }
                    ],
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
            "controlName": "IryoHokenRireki",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "",
                    "controlName": ""
                },
                {
                    "key": "",
                    "controlName": ""
                },
                {
                    "key": "",
                    "controlName": ""
                }
            ],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "M",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [
                {
                    "eventName": "onSelectByModifyButton_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelect_dgIryoHokenRireki"
                },
                {
                    "eventName": "onSelectByDbClick_dgIryoHokenRireki"
                },
                {
                    "eventName": "onClick_btnAddIryoHoken"
                }
            ],
            "publicEventsAlias": []
        };
        return IryoHokenRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.IryoHokenRireki_Design = IryoHokenRireki_Design;

    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddIryoHoken = function () {
                return "onClick_btnAddIryoHoken";
            };

            Events.onSelect_dgIryoHokenRireki = function () {
                return "onSelect_dgIryoHokenRireki";
            };

            Events.onSelectByDbClick_dgIryoHokenRireki = function () {
                return "onSelectByDbClick_dgIryoHokenRireki";
            };

            Events.onSelectByModifyButton_dgIryoHokenRireki = function () {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            };

            Events.onSelectByDeleteButton_dgIryoHokenRireki = function () {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            };

            Events.onBlur_txtIryoHokenHokenshaNo = function () {
                return "onBlur_txtIryoHokenHokenshaNo";
            };

            Events.onClick_btnIryoHokenKakutei = function () {
                return "onClick_btnIryoHokenKakutei";
            };

            Events.onClick_btnIryoHokenTorikeshi = function () {
                return "onClick_btnIryoHokenTorikeshi";
            };
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };

            Controls.prototype.IryoHokenInput = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            };

            Controls.prototype.txtIryoHokenKanyuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            };

            Controls.prototype.txtIryoHokenDattaiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            };

            Controls.prototype.ddlIryoHokenShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            };

            Controls.prototype.txtIryoHokenHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            };

            Controls.prototype.txtIryoHokenHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            };

            Controls.prototype.txtIryoHokenKigoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            };

            Controls.prototype.btnIryoHokenKakutei = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            };

            Controls.prototype.btnIryoHokenTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            };
            return Controls;
        })();
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "WidthMode",
                    "MeisaiMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Toroku = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.Shokai = function () {
                    this.controls.dgIryoHokenRireki().readOnly = true;
                    this.controls.btnAddIryoHoken().displayNone = true;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 940;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.ShikakuIdo = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;

            var WidthMode = (function () {
                function WidthMode(controls) {
                    this.controls = controls;
                }
                WidthMode.prototype.Width1 = function () {
                    this.controls.dgIryoHokenRireki().width = 800;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                WidthMode.prototype.Width2 = function () {
                    this.controls.dgIryoHokenRireki().width = 700;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return WidthMode;
            })();
            Modes.WidthMode = WidthMode;

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.toroku = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = false;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = true;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = true;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = true;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = true;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = true;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = true;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setReadOnly = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().displayNone = true;
                    this.controls.btnIryoHokenTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;
        })(IryoHokenRireki.Modes || (IryoHokenRireki.Modes = {}));
        var Modes = IryoHokenRireki.Modes;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
