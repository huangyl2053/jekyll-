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
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["height"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["height"] = value;
                } else {
                    this.layout.items[0]["height"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSort", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSort"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSort"] = value;
                } else {
                    this.layout.items[0]["onSort"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSelect", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelect"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelect"] = value;
                } else {
                    this.layout.items[0]["onSelect"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onSelectByDblClick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelectByDblClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onSelectByDblClick"] = value;
                } else {
                    this.layout.items[0]["onSelectByDblClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onOnlyRow", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onOnlyRow"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onOnlyRow"] = value;
                } else {
                    this.layout.items[0]["onOnlyRow"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onNoRow", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onNoRow"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onNoRow"] = value;
                } else {
                    this.layout.items[0]["onNoRow"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(ShozokuChosainListCom_Design.prototype, "onMultiRows", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onMultiRows"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["onMultiRows"] = value;
                } else {
                    this.layout.items[0]["onMultiRows"] = value;
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
            editablePropertyInfo["height"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["onSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["onSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["onSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["onOnlyRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onOnlyRow"];
            editablePropertyInfo["onNoRow"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onNoRow"];
            editablePropertyInfo["onMultiRows"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["onMultiRows"];

            return editablePropertyInfo;
        };
        ShozokuChosainListCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "dgShozokuChosainList",
                    "items": [],
                    "controlType": "DataGrid",
                    "width": "460",
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
                        "header": {
                            "combineColumns": [],
                            "frozenColumn": "",
                            "headerHeight": 0
                        },
                        "columns": [
                            {
                                "columnName": "",
                                "dataName": "btnToBindChosain",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 50,
                                "visible": false,
                                "cellType": 8,
                                "cellDetails": {
                                    "cellType": 8,
                                    "text": "割付",
                                    "onClick": "",
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": ""
                                },
                                "align": 0,
                                "resize": false,
                                "isPrivateInfo": false,
                                "sortKey": "btnToBindChosain"
                            },
                            {
                                "columnName": "番号",
                                "dataName": "chosainNo",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 100,
                                "visible": true,
                                "cellType": 0,
                                "cellDetails": {
                                    "cellType": 0,
                                    "isSetValueToToolTip": false
                                },
                                "align": 1,
                                "resize": true,
                                "isPrivateInfo": false,
                                "sortKey": "chosainNo"
                            },
                            {
                                "columnName": "氏名",
                                "dataName": "chosainName",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 150,
                                "visible": true,
                                "cellType": 0,
                                "cellDetails": {
                                    "cellType": 0,
                                    "isSetValueToToolTip": false
                                },
                                "align": 0,
                                "resize": true,
                                "isPrivateInfo": false,
                                "sortKey": "chosainName"
                            },
                            {
                                "columnName": "割付数",
                                "dataName": "waritsukeNum",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 60,
                                "visible": true,
                                "cellType": 0,
                                "cellDetails": {
                                    "cellType": 0,
                                    "isSetValueToToolTip": false
                                },
                                "align": 2,
                                "resize": true,
                                "isPrivateInfo": false,
                                "sortKey": "waritsukeNum"
                            },
                            {
                                "columnName": "地区",
                                "dataName": "chiku",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 125,
                                "visible": true,
                                "cellType": 0,
                                "cellDetails": {
                                    "cellType": 0,
                                    "isSetValueToToolTip": false
                                },
                                "align": 0,
                                "resize": true,
                                "isPrivateInfo": false,
                                "sortKey": "chiku"
                            },
                            {
                                "columnName": "調査委託先番号",
                                "dataName": "chousaItakusakiNo",
                                "toolTip": "",
                                "bgColor": 0,
                                "width": 0,
                                "visible": false,
                                "cellType": 0,
                                "cellDetails": {
                                    "cellType": 0,
                                    "isSetValueToToolTip": false
                                },
                                "align": 0,
                                "resize": false,
                                "isPrivateInfo": false,
                                "sortKey": "chousaItakusakiNo"
                            }
                        ]
                    },
                    "height": "150",
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
                    "sortOrder": "chosainName",
                    "isAscending": true,
                    "filterList": [],
                    "activeRowId": -1
                }
            ],
            "controlType": "CompositeControl",
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
            "businessId": "DBE",
            "controlName": "ShozokuChosainListCom",
            "originalProperty": [
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "height",
                    "newPropertyName": "height"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onSort",
                    "newPropertyName": "onSort"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onSelect",
                    "newPropertyName": "onSelect"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onSelectByDblClick",
                    "newPropertyName": "onSelectByDblClick"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onOnlyRow",
                    "newPropertyName": "onOnlyRow"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onNoRow",
                    "newPropertyName": "onNoRow"
                },
                {
                    "publicChildFieldName": "dgShozokuChosainList",
                    "publicChildProperty": "onMultiRows",
                    "newPropertyName": "onMultiRows"
                }
            ]
        };
        return ShozokuChosainListCom_Design;
    })(Uz.CompositeControl);
    DBE.ShozokuChosainListCom_Design = ShozokuChosainListCom_Design;
})(DBE || (DBE = {}));
