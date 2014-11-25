var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnReturn", {
                get: function () {
                    return "onClick_btnReturn";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnDecision", {
                get: function () {
                    return "onClick_btnDecision";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        ShichosonSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "ShichosonSelector";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.ShichosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShichoson = function () {
                return new UZA.DataGrid(this.convFiledName("dgShichoson"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnDecision = function () {
                return new UZA.Button(this.convFiledName("btnDecision"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        ShichosonSelector.Controls = Controls;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;

    var ShichosonSelector_Design = (function (_super) {
        __extends(ShichosonSelector_Design, _super);
        function ShichosonSelector_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, ShichosonSelector_Design.myLayout, fieldName);
        }
        ShichosonSelector_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        ShichosonSelector_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        ShichosonSelector_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ShichosonSelector",
                    "items": [
                        {
                            "fieldName": "dgShichoson",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "350",
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
                            "selectControlID": "dgShichoson",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "市町村コード",
                                        "dataName": "shichosonCode",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "市町村名",
                                        "dataName": "shichosonMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    },
                                    {
                                        "columnName": "市町村",
                                        "dataName": "shichoson",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": false,
                                        "isPrivateInfo": false,
                                        "sortKey": ""
                                    }
                                ]
                            },
                            "height": "S",
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "btnReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "150",
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
                            "onClick": "onClick_btnReturn",
                            "text": "戻る",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        },
                        {
                            "fieldName": "btnDecision",
                            "items": [],
                            "controlType": "Button",
                            "width": "150",
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
                            "selectControlID": "btnDecision",
                            "onClick": "onClick_btnDecision",
                            "text": "市町村選択を確定する",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0
                        }
                    ],
                    "controlType": "Panel",
                    "width": "370",
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
                    "selectControlID": "ShichosonSelector",
                    "onLoad": "",
                    "title": "市町村選択",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "ShichosonSelector"
                        }
                    ],
                    "requestSettings": [],
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
                    "isGroupBox": false
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
            "controlName": "ShichosonSelector",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "onClick_btnDecision",
            "dialogCancelEventNameForDialog": "onClick_btnReturn"
        };
        return ShichosonSelector_Design;
    })(Uz.CommonChildDiv);
    DBZ.ShichosonSelector_Design = ShichosonSelector_Design;
})(DBZ || (DBZ = {}));
