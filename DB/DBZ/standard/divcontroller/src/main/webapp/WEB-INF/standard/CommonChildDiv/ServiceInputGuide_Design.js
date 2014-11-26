var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnSearchJigyosha", {
                get: function () {
                    return "onClick_btnSearchJigyosha";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnServiceInputGuideReturn", {
                get: function () {
                    return "onClick_btnServiceInputGuideReturn";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onSelectBySelectButton_SearchResultService", {
                get: function () {
                    return "onSelectBySelectButton_SearchResultService";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        ServiceInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "ServiceInputGuide";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.ServiceInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            };

            Controls.prototype.txtServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            };

            Controls.prototype.txtKijyunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijyunYM"));
            };

            Controls.prototype.btnSearchJService = function () {
                return new UZA.Button(this.convFiledName("btnSearchJService"));
            };

            Controls.prototype.SearchResultService = function () {
                return new UZA.Panel(this.convFiledName("SearchResultService"));
            };

            Controls.prototype.dgSearchResultService = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultService"));
            };

            Controls.prototype.btnServiceInputGuideReturn = function () {
                return new UZA.Button(this.convFiledName("btnServiceInputGuideReturn"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        ServiceInputGuide.Controls = Controls;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;

    var ServiceInputGuide_Design = (function (_super) {
        __extends(ServiceInputGuide_Design, _super);
        function ServiceInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ServiceInputGuide_Design.myLayout, fieldName);
        }
        ServiceInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ServiceInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ServiceInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ServiceInputGuide",
                    "items": [
                        {
                            "fieldName": "txtServiceShuruiCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "25",
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
                            "selectControlID": "txtServiceShuruiCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
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
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "サービスコード",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "2"
                        },
                        {
                            "fieldName": "txtServiceCode",
                            "items": [],
                            "controlType": "TextBoxCode",
                            "width": "60",
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
                            "selectControlID": "txtServiceCode_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "required": false,
                            "maxLength": 100000000,
                            "minLength": 0,
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
                            "text": "",
                            "suggest": [],
                            "value": "",
                            "labelLText": "",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "4"
                        },
                        {
                            "fieldName": "txtKijyunYM",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "selectControlID": "txtKijyunYM_core",
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
                            "value": "",
                            "labelLText": "基準年月",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "permitCharactor": "./_-",
                            "ymdKubun": 1,
                            "displayFormat": 0
                        },
                        {
                            "fieldName": "btnSearchJService",
                            "items": [],
                            "controlType": "Button",
                            "width": "220",
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
                            "selectControlID": "btnSearchJService",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "該当するサービスを表示する",
                            "onClick": "onClick_btnSearchJigyosha",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "SearchResultService",
                            "items": [
                                {
                                    "fieldName": "dgSearchResultService",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "L",
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
                                    "selectControlID": "dgSearchResultService",
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
                                                "columnName": "サービスコード",
                                                "dataName": "serviceCode",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 150,
                                                "visible": true,
                                                "cellType": 4,
                                                "cellDetails": {
                                                    "cellType": 4,
                                                    "maxLength": "1000000000000",
                                                    "minLength": "0",
                                                    "formatLength": "6",
                                                    "onChange": "",
                                                    "isSetValueToToolTip": false,
                                                    "readOnly": true
                                                },
                                                "align": 1,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            },
                                            {
                                                "columnName": "サービス名称",
                                                "dataName": "serviceMeisho",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 570,
                                                "visible": true,
                                                "cellType": 0,
                                                "cellDetails": {
                                                    "cellType": 0
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": ""
                                            }
                                        ]
                                    },
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "",
                                    "onSelectBySelectButton": "onSelectBySelectButton_SearchResultService",
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
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "SearchResultService",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "サービス一覧",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SearchResultService"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": true,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnServiceInputGuideReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "220",
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
                            "selectControlID": "btnServiceInputGuideReturn",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "閉じる",
                            "onClick": "onClick_btnServiceInputGuideReturn",
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
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "ServiceInputGuide",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "サービス入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ServiceInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/ServiceInputGuide/onLoad"
                        },
                        {
                            "eventName": "onSelectBySelectButton_SearchResultService",
                            "requestUrl": "dbz/db/dbz/ServiceInputGuide/onSelectBySelectButton_SearchResultService"
                        },
                        {
                            "eventName": "onClick_btnSearchJigyosha",
                            "requestUrl": "dbz/db/dbz/ServiceInputGuide/onClick_btnSearchJigyosha"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "serviceCode",
                            "value": ""
                        },
                        {
                            "propertyName": "serviceMeisho",
                            "value": ""
                        },
                        {
                            "propertyName": "serviceTaishoYM",
                            "value": ""
                        },
                        {
                            "propertyName": "serviceCodeMeisho",
                            "value": ""
                        }
                    ],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": true,
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
            "businessId": "DBZ",
            "controlName": "ServiceInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "serviceCode",
                    "controlName": "ServiceInputGuide.serviceCode"
                },
                {
                    "key": "serviceMeisho",
                    "controlName": "ServiceInputGuide.serviceMeisho"
                },
                {
                    "key": "serviceTaishoYM",
                    "controlName": "txtKijyunYM"
                },
                {
                    "key": "serviceCodeMeisho",
                    "controlName": "ServiceInputGuide.serviceCodeMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySelectButton_SearchResultService",
            "dialogCancelEventNameForDialog": "onClick_btnServiceInputGuideReturn",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return ServiceInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.ServiceInputGuide_Design = ServiceInputGuide_Design;
})(DBZ || (DBZ = {}));
