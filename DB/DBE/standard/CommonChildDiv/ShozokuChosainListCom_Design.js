var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var ShozokuChosainListCom_Design = (function (_super) {
        __extends(ShozokuChosainListCom_Design, _super);
        function ShozokuChosainListCom_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShozokuChosainListCom_Design.myLayout, fieldName);
        }
        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "height", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["height"] = value;
                } else {
                    this.layout.items[0].items[0]["height"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSort", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSort"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSort"] = value;
                } else {
                    this.layout.items[0].items[0]["onSort"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSelect", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelect"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelect"] = value;
                } else {
                    this.layout.items[0].items[0]["onSelect"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSelectByDblClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onSelectByDblClick"] = value;
                } else {
                    this.layout.items[0].items[0]["onSelectByDblClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onOnlyRow", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onOnlyRow"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onOnlyRow"] = value;
                } else {
                    this.layout.items[0].items[0]["onOnlyRow"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onNoRow", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onNoRow"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onNoRow"] = value;
                } else {
                    this.layout.items[0].items[0]["onNoRow"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onMultiRows", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onMultiRows"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["onMultiRows"] = value;
                } else {
                    this.layout.items[0].items[0]["onMultiRows"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        ShozokuChosainListCom_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("height");
            Uz.JSControlUtil.registProperty("onSort");
            Uz.JSControlUtil.registProperty("onSelect");
            Uz.JSControlUtil.registProperty("onSelectByDblClick");
            Uz.JSControlUtil.registProperty("onOnlyRow");
            Uz.JSControlUtil.registProperty("onNoRow");
            Uz.JSControlUtil.registProperty("onMultiRows");
        };

        ShozokuChosainListCom_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];

            return editablePropertyInfo;
        };
        ShozokuChosainListCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShozokuChosainListCom",
                    "items": [
                        {
                            "fieldName": "dgShozokuChosainList",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "300px",
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
                            "selectControlID": "dgShozokuChosainList",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "150px",
                            "dataSource": [],
                            "gridSetting": {
                                "isShowModifyButtonColumn": false,
                                "rowHeight": 25,
                                "isShowFilter": false,
                                "isShowFooter": false,
                                "limitRowCount": 0,
                                "isShowDeleteButtonColumn": false,
                                "isShowFilterButton": false,
                                "isShowHeader": true,
                                "isMultiSelectable": false,
                                "isShowRowState": false,
                                "selectedRowCount": 0,
                                "isShowSelectButtonColumn": false,
                                "columns": [
                                    {
                                        "isPrivateInfo": false,
                                        "width": 50,
                                        "cellType": 8,
                                        "visible": false,
                                        "toolTip": "",
                                        "sortKey": "btnToBindChosain",
                                        "align": 0,
                                        "cellDetails": {
                                            "imageWidth": "",
                                            "cellType": 8,
                                            "text": "割付",
                                            "imageHeight": "",
                                            "imageFileUrl": "",
                                            "onClick": ""
                                        },
                                        "columnName": "",
                                        "dataName": "btnToBindChosain",
                                        "resize": false,
                                        "bgColor": 0
                                    },
                                    {
                                        "isPrivateInfo": false,
                                        "width": 75,
                                        "cellType": 0,
                                        "visible": true,
                                        "toolTip": "",
                                        "sortKey": "chosainNo",
                                        "align": 1,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "columnName": "番号<br>",
                                        "dataName": "chosainNo",
                                        "resize": true,
                                        "bgColor": 0
                                    },
                                    {
                                        "isPrivateInfo": false,
                                        "width": 150,
                                        "cellType": 0,
                                        "visible": true,
                                        "toolTip": "",
                                        "sortKey": "chosainName",
                                        "align": 0,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "columnName": "氏名<br>",
                                        "dataName": "chosainName",
                                        "resize": true,
                                        "bgColor": 0
                                    },
                                    {
                                        "isPrivateInfo": false,
                                        "width": 55,
                                        "cellType": 0,
                                        "visible": true,
                                        "toolTip": "",
                                        "sortKey": "waritsukeNum",
                                        "align": 2,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "columnName": "割付数<br>",
                                        "dataName": "waritsukeNum",
                                        "resize": true,
                                        "bgColor": 0
                                    },
                                    {
                                        "isPrivateInfo": false,
                                        "width": 125,
                                        "cellType": 0,
                                        "visible": false,
                                        "toolTip": "",
                                        "sortKey": "chiku",
                                        "align": 0,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "columnName": "地区",
                                        "dataName": "chiku",
                                        "resize": true,
                                        "bgColor": 0
                                    },
                                    {
                                        "isPrivateInfo": false,
                                        "width": 0,
                                        "cellType": 0,
                                        "visible": false,
                                        "toolTip": "",
                                        "sortKey": "chousaItakusakiNo",
                                        "align": 0,
                                        "cellDetails": {
                                            "cellType": 0,
                                            "isSetValueToToolTip": false
                                        },
                                        "columnName": "調査委託先番号",
                                        "dataName": "chousaItakusakiNo",
                                        "resize": false,
                                        "bgColor": 0
                                    }
                                ],
                                "header": {
                                    "headerHeight": 0,
                                    "frozenColumn": "",
                                    "combineColumns": []
                                }
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
                            "sortOrder": "chosainName",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
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
                    "selectControlID": "ShozokuChosainListCom",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "XS",
                    "marginBottom": "XS",
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
            "marginLeft": "XS",
            "marginRight": "XS",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "packageName": "",
            "businessId": "DBE",
            "controlName": "ShozokuChosainListCom",
            "marginTop": "0em",
            "marginBottom": "0em",
            "originalProperty": [
                {
                    "publicChildProperty": "height",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "height"
                },
                {
                    "publicChildProperty": "onSort",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onSort"
                },
                {
                    "publicChildProperty": "onSelect",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onSelect"
                },
                {
                    "publicChildProperty": "onSelectByDblClick",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onSelectByDblClick"
                },
                {
                    "publicChildProperty": "onOnlyRow",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onOnlyRow"
                },
                {
                    "publicChildProperty": "onNoRow",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onNoRow"
                },
                {
                    "publicChildProperty": "onMultiRows",
                    "publicChildFieldName": "dgShozokuChosainList",
                    "newPropertyName": "onMultiRows"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "",
            "firstFocusFieldName": "",
            "lastFocusFieldName": "",
            "modes": [],
            "publicEvents": [],
            "publicEventsAlias": []
        };
        return ShozokuChosainListCom_Design;
    })(Uz.CommonChildDiv);
    DBE.ShozokuChosainListCom_Design = ShozokuChosainListCom_Design;

    (function (ShozokuChosainListCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShozokuChosainListCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShozokuChosainListCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShozokuChosainListCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShozokuChosainList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShozokuChosainList"));
            };
            return Controls;
        })();
        ShozokuChosainListCom.Controls = Controls;
    })(DBE.ShozokuChosainListCom || (DBE.ShozokuChosainListCom = {}));
    var ShozokuChosainListCom = DBE.ShozokuChosainListCom;
})(DBE || (DBE = {}));
