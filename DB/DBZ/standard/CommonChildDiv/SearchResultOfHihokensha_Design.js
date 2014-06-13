var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var SearchResultOfHihokensha_Design = (function (_super) {
        __extends(SearchResultOfHihokensha_Design, _super);
        function SearchResultOfHihokensha_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SearchResultOfHihokensha_Design.myLayout, fieldName);
        }
        Object.defineProperty(SearchResultOfHihokensha_Design.prototype, "onClickBtnToResearch", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[0]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[0]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[1].items[0]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        Object.defineProperty(SearchResultOfHihokensha_Design.prototype, "gridSetting", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"])["gridSetting"] = value;
                } else {
                    this.layout.items[0].items[0]["gridSetting"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        SearchResultOfHihokensha_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("onClickBtnToResearch");
            Uz.JSControlUtil.registProperty("gridSetting");
        };

        SearchResultOfHihokensha_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["onClickBtnToResearch"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[1]["fieldName"] + "_" + this.layout.items[0].items[1].items[0]["fieldName"]).getEditablePropertyInfo()["onClick"];
            editablePropertyInfo["gridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[0]["fieldName"]).getEditablePropertyInfo()["gridSetting"];

            return editablePropertyInfo;
        };
        SearchResultOfHihokensha_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SearchResultOfHihokensha",
                    "items": [
                        {
                            "fieldName": "dgSearchResult",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1075",
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
                            "selectControlID": "dgSearchResult",
                            "dataSource": [],
                            "gridSetting": {
                                "rowHeight": 50,
                                "isMultiSelectable": false,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": ""
                                },
                                "columns": [
                                    {
                                        "columnName": "",
                                        "dataName": "btnToDecide",
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "確定",
                                            "onClick": "",
                                            "imageFileUrl": ""
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "btnToDecide"
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "hihokenshaNo",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "hihokenshaNo"
                                    },
                                    {
                                        "columnName": "識別コード",
                                        "dataName": "shikibetsuCode",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shikibetsuCode"
                                    },
                                    {
                                        "columnName": "被保険者区分",
                                        "dataName": "hihokenshaKubun",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "hihokenshaKubun"
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimei",
                                        "width": 150,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "shimei"
                                    },
                                    {
                                        "columnName": "カナ氏名",
                                        "dataName": "kanaShimsei",
                                        "width": 150,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "kanaShimsei"
                                    },
                                    {
                                        "columnName": "氏名",
                                        "dataName": "shimeiAndKanaShimsei",
                                        "width": 150,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kanaShimsei"
                                    },
                                    {
                                        "columnName": "性別",
                                        "dataName": "gender",
                                        "width": 50,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "gender"
                                    },
                                    {
                                        "columnName": "生年月日",
                                        "dataName": "birthDay",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 3
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "birthDay"
                                    },
                                    {
                                        "columnName": "郵便番号",
                                        "dataName": "yubinNo",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "yubinNo"
                                    },
                                    {
                                        "columnName": "住所",
                                        "dataName": "jusho",
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jusho"
                                    },
                                    {
                                        "columnName": "個人番号",
                                        "dataName": "kojinNo",
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": "kojinNo"
                                    },
                                    {
                                        "columnName": "住民種別",
                                        "dataName": "juminShubetsu",
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "juminShubetsu"
                                    },
                                    {
                                        "columnName": "世帯コード",
                                        "dataName": "setaiCode",
                                        "width": 110,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "setaiCode"
                                    }
                                ]
                            },
                            "height": "S",
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "",
                            "onSelectByModifyButton": "",
                            "onSelectByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "sortOrder": "yubinNoAndJusho",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "ButtonsForSearchResultOfHihokensha",
                            "items": [
                                {
                                    "fieldName": "btnToResearch",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
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
                                    "selectControlID": "btnToResearch",
                                    "text": "再検索する",
                                    "onClick": "",
                                    "icon": 0,
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1075",
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
                            "selectControlID": "ButtonsForSearchResultOfHihokensha",
                            "onLoad": "",
                            "title": "",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "ButtonsForSearchResultOfHihokensha"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorderTop": true,
                            "eraseBorderBottom": true,
                            "eraseBorderRight": true,
                            "eraseBorderLeft": true,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1090",
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
                    "selectControlID": "SearchResultOfHihokensha",
                    "onLoad": "",
                    "title": "検索結果",
                    "marginTop": "XS",
                    "marginBottom": "XS",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SearchResultOfHihokensha"
                        }
                    ],
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
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false
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
            "selectControlID": "defaultLayout",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "SearchResultOfHihokensha",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnToResearch",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "onClickBtnToResearch"
                },
                {
                    "publicChildFieldName": "dgSearchResult",
                    "publicChildProperty": "gridSetting",
                    "newPropertyName": "gridSetting"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return SearchResultOfHihokensha_Design;
    })(Uz.CommonChildDiv);
    DBZ.SearchResultOfHihokensha_Design = SearchResultOfHihokensha_Design;
})(DBZ || (DBZ = {}));
