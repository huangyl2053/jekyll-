var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    (function (IryoKikanSelector) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onSelectByDC_IryoKikan", {
                get: function () {
                    return "onSelectByDC_IryoKikan";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelect_dgIryoKikanList", {
                get: function () {
                    return "onSelect_dgIryoKikanList";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectByDC_Ishi", {
                get: function () {
                    return "onSelectByDC_Ishi";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectBySB_IryoKikan", {
                get: function () {
                    return "onSelectBySB_IryoKikan";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnNonSelectReturn", {
                get: function () {
                    return "onClick_btnNonSelectReturn";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnSelectAndClose", {
                get: function () {
                    return "onClick_btnSelectAndClose";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectBySB_Ishi", {
                get: function () {
                    return "onSelectBySB_Ishi";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        IryoKikanSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "IryoKikanSelector";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.IryoKikanSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.IryoKikan = function () {
                return new UZA.Panel(this.convFiledName("IryoKikan"));
            };

            Controls.prototype.IryoKikanList = function () {
                return new UZA.Panel(this.convFiledName("IryoKikanList"));
            };

            Controls.prototype.btnToMentenanceIryoKikan = function () {
                return new UZA.Button(this.convFiledName("btnToMentenanceIryoKikan"));
            };

            Controls.prototype.dgIryoKikanList = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoKikanList"));
            };

            Controls.prototype.Ishi = function () {
                return new UZA.Panel(this.convFiledName("Ishi"));
            };

            Controls.prototype.spaIshi = function () {
                return new UZA.Space(this.convFiledName("spaIshi"));
            };

            Controls.prototype.IshiList = function () {
                return new UZA.Panel(this.convFiledName("IshiList"));
            };

            Controls.prototype.dgIshiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgIshiList"));
            };

            Controls.prototype.SelectedContents = function () {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            };

            Controls.prototype.txtiryoKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtiryoKikanCode"));
            };

            Controls.prototype.txtiryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtiryoKikanName"));
            };

            Controls.prototype.txtishiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtishiCode"));
            };

            Controls.prototype.txtishiName = function () {
                return new UZA.TextBox(this.convFiledName("txtishiName"));
            };

            Controls.prototype.btnSelectAndClose = function () {
                return new UZA.Button(this.convFiledName("btnSelectAndClose"));
            };

            Controls.prototype.btnNonSelectReturn = function () {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        IryoKikanSelector.Controls = Controls;
    })(DBE.IryoKikanSelector || (DBE.IryoKikanSelector = {}));
    var IryoKikanSelector = DBE.IryoKikanSelector;

    var IryoKikanSelector_Design = (function (_super) {
        __extends(IryoKikanSelector_Design, _super);
        function IryoKikanSelector_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, IryoKikanSelector_Design.myLayout, fieldName);
        }
        IryoKikanSelector_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        IryoKikanSelector_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        IryoKikanSelector_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "IryoKikanSelector",
                    "items": [
                        {
                            "fieldName": "IryoKikan",
                            "items": [
                                {
                                    "fieldName": "IryoKikanList",
                                    "items": [
                                        {
                                            "fieldName": "btnToMentenanceIryoKikan",
                                            "items": [],
                                            "controlType": "Button",
                                            "width": "200",
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
                                            "selectControlID": "btnToMentenanceIryoKikan",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onClick": "",
                                            "text": "医療機関情報を修正する",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": "",
                                            "icon": 0,
                                            "heightTextBoxMatches": false
                                        },
                                        {
                                            "fieldName": "dgIryoKikanList",
                                            "items": [],
                                            "controlType": "DataGrid",
                                            "width": "370",
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
                                            "selectControlID": "dgIryoKikanList",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "height": "220",
                                            "gridSetting": {
                                                "rowHeight": 25,
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
                                                        "columnName": "番号",
                                                        "dataName": "iryoKikanNo",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 82,
                                                        "visible": true,
                                                        "cellType": 0,
                                                        "cellDetails": {
                                                            "cellType": 0
                                                        },
                                                        "align": 1,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "iryoKikanNo"
                                                    },
                                                    {
                                                        "columnName": "名称",
                                                        "dataName": "iryoKikanName",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 230,
                                                        "visible": true,
                                                        "cellType": 0,
                                                        "cellDetails": {
                                                            "cellType": 0
                                                        },
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "iryoKikanName"
                                                    }
                                                ]
                                            },
                                            "onSort": "",
                                            "onSelect": "onSelect_dgIryoKikanList",
                                            "onSelectByDblClick": "onSelectByDC_IryoKikan",
                                            "onSelectBySelectButton": "onSelectBySB_IryoKikan",
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
                                            "sortOrder": "iryoKikanName",
                                            "isAscending": true,
                                            "filterList": [],
                                            "activeRowId": -1
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
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "IryoKikanList",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "0",
                                    "marginBottom": "0",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "IryoKikanList"
                                        }
                                    ],
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
                                    "height": "Auto"
                                },
                                {
                                    "fieldName": "Ishi",
                                    "items": [
                                        {
                                            "fieldName": "spaIshi",
                                            "items": [],
                                            "controlType": "Space",
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
                                            "selectControlID": "spaIshi",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "spaceCount": 1
                                        },
                                        {
                                            "fieldName": "IshiList",
                                            "items": [
                                                {
                                                    "fieldName": "dgIshiList",
                                                    "items": [],
                                                    "controlType": "DataGrid",
                                                    "width": "290",
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
                                                    "selectControlID": "dgIshiList",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "height": "190",
                                                    "gridSetting": {
                                                        "rowHeight": 25,
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
                                                                "columnName": "番号",
                                                                "dataName": "ishiNo",
                                                                "toolTip": "",
                                                                "bgColor": 0,
                                                                "width": 82,
                                                                "visible": true,
                                                                "cellType": 0,
                                                                "cellDetails": {
                                                                    "cellType": 0
                                                                },
                                                                "align": 1,
                                                                "resize": true,
                                                                "isPrivateInfo": false,
                                                                "sortKey": "ishiNo"
                                                            },
                                                            {
                                                                "columnName": "氏名",
                                                                "dataName": "ishiName",
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
                                                                "sortKey": "ishiName"
                                                            }
                                                        ]
                                                    },
                                                    "onSort": "",
                                                    "onSelect": "",
                                                    "onSelectByDblClick": "onSelectByDC_Ishi",
                                                    "onSelectBySelectButton": "onSelectBySB_Ishi",
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
                                                    "sortOrder": "IshiMeisho",
                                                    "isAscending": true,
                                                    "filterList": [],
                                                    "activeRowId": -1
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
                                            "selectControlID": "IshiList",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "所属医師",
                                            "marginTop": "Default",
                                            "marginBottom": "Default",
                                            "isOpen": true,
                                            "canOpenAndClose": false,
                                            "postParameterPanelNames": [
                                                {
                                                    "postParameterPanelNames": "IshiList"
                                                },
                                                {
                                                    "postParameterPanelNames": "IryoKikanList"
                                                }
                                            ],
                                            "requestSettings": [
                                                {
                                                    "eventName": "onLoad",
                                                    "requestUrl": ""
                                                },
                                                {
                                                    "eventName": "onSelect_dgIryoKikanList",
                                                    "requestUrl": "dbe/db/dbe/IryoKikanSelector/onSelect_dgIryoKikanList"
                                                }
                                            ],
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
                                            "height": "Auto"
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
                                    "marginRight": "0",
                                    "selectControlID": "Ishi",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "0",
                                    "marginBottom": "0",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "Ishi"
                                        }
                                    ],
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
                                    "height": "Auto"
                                }
                            ],
                            "controlType": "Panel",
                            "width": "720",
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
                            "selectControlID": "IryoKikan",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "医療機関",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "IryoKikan"
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
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "SelectedContents",
                            "items": [
                                {
                                    "fieldName": "txtiryoKikanCode",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "82",
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
                                    "selectControlID": "txtiryoKikanCode_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "text": "",
                                    "required": false,
                                    "maxLength": "10",
                                    "minLength": "10",
                                    "textAlign": 0,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "医療機関",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "10"
                                },
                                {
                                    "fieldName": "txtiryoKikanName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "250",
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
                                    "selectControlID": "txtiryoKikanName_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "text": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtishiCode",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "65",
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
                                    "selectControlID": "txtishiCode_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "text": "",
                                    "required": false,
                                    "maxLength": "8",
                                    "minLength": "8",
                                    "textAlign": 0,
                                    "placeHolder": "",
                                    "textKind": 2,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "医師",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "8"
                                },
                                {
                                    "fieldName": "txtishiName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "150",
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
                                    "selectControlID": "txtishiName_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "text": "",
                                    "required": false,
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "placeHolder": "",
                                    "textKind": 0,
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "isComboBox": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "suggest": [],
                                    "value": "",
                                    "labelLText": "",
                                    "labelRText": "",
                                    "labelLWidth": "S",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "720",
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
                            "selectControlID": "SelectedContents",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "選択内容",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SelectedContents"
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
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnSelectAndClose",
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
                            "marginRight": "S",
                            "selectControlID": "btnSelectAndClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnSelectAndClose",
                            "text": "確定",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "btnNonSelectReturn",
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
                            "selectControlID": "btnNonSelectReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onClick": "onClick_btnNonSelectReturn",
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
                    "width": "G8",
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
                    "selectControlID": "IryoKikanSelector",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "医療機関選択",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "IryoKikanSelector"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onLoad"
                        },
                        {
                            "eventName": "onSelectByDC_IryoKikan",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onSelectByDC_IryoKikan"
                        },
                        {
                            "eventName": "onSelectBySB_IryoKikan",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onSelectBySB_IryoKikan"
                        },
                        {
                            "eventName": "onSelectByDC_Ishi",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onSelectByDC_Ishi"
                        },
                        {
                            "eventName": "onSelectBySB_Ishi",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onSelectBySB_Ishi"
                        },
                        {
                            "eventName": "onClick_btnSelectAndClose",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onClick_btnSelectAndClose"
                        },
                        {
                            "eventName": "onClick_btnNonSelectReturn",
                            "requestUrl": "dbe/db/dbe/IryoKikanSelector/onClick_btnNonSelectReturn"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "iryoKikanCode",
                            "value": ""
                        },
                        {
                            "propertyName": "iryoKikanName",
                            "value": ""
                        },
                        {
                            "propertyName": "ishiCode",
                            "value": ""
                        },
                        {
                            "propertyName": "ishiName",
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
                    "height": "410"
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
            "controlName": "IryoKikanSelector",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "iryoKikanCode",
                    "controlName": "IryoKikanSelector.iryoKikanCode"
                },
                {
                    "key": "iryoKikanName",
                    "controlName": "IryoKikanSelector.iryoKikanName"
                },
                {
                    "key": "ishiCode",
                    "controlName": "IryoKikanSelector.ishiCode"
                },
                {
                    "key": "ishiName",
                    "controlName": "IryoKikanSelector.ishiName"
                }
            ],
            "dialogOkEventNameForDialog": "onClick_btnSelectAndClose",
            "dialogCancelEventNameForDialog": "onClick_btnNonSelectReturn",
            "canTransferEvent": true,
            "heightForDialog": "450"
        };
        return IryoKikanSelector_Design;
    })(Uz.CommonChildDiv);
    DBE.IryoKikanSelector_Design = IryoKikanSelector_Design;
})(DBE || (DBE = {}));
