var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiShisetsuInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onSelectBySelectButton_dgTekiyoJogaiShisetsu", {
                get: function () {
                    return "onSelectBySelectButton_dgTekiyoJogaiShisetsu";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnReturn", {
                get: function () {
                    return "onClick_btnReturn";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        TekiyoJogaiShisetsuInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "TekiyoJogaiShisetsuInputGuide";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.TekiyoJogaiShisetsuInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTekiyoJogaiShisetsu = function () {
                return new UZA.DataGrid(this.convFiledName("dgTekiyoJogaiShisetsu"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        TekiyoJogaiShisetsuInputGuide.Controls = Controls;
    })(DBZ.TekiyoJogaiShisetsuInputGuide || (DBZ.TekiyoJogaiShisetsuInputGuide = {}));
    var TekiyoJogaiShisetsuInputGuide = DBZ.TekiyoJogaiShisetsuInputGuide;

    var TekiyoJogaiShisetsuInputGuide_Design = (function (_super) {
        __extends(TekiyoJogaiShisetsuInputGuide_Design, _super);
        function TekiyoJogaiShisetsuInputGuide_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, TekiyoJogaiShisetsuInputGuide_Design.myLayout, fieldName);
        }
        TekiyoJogaiShisetsuInputGuide_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        TekiyoJogaiShisetsuInputGuide_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        TekiyoJogaiShisetsuInputGuide_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "TekiyoJogaiShisetsuInputGuide",
                    "items": [
                        {
                            "fieldName": "dgTekiyoJogaiShisetsu",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "660",
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
                            "selectControlID": "dgTekiyoJogaiShisetsu",
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
                                "header": {
                                    "combineColumns": [],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "事業者番号",
                                        "dataName": "jigyoshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jigyoshaNo"
                                    },
                                    {
                                        "columnName": "事業者名称",
                                        "dataName": "jigyoshaMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 200,
                                        "visible": false,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jigyoshaMeisho"
                                    },
                                    {
                                        "columnName": "事業者",
                                        "dataName": "jigyosha",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jigyosha"
                                    },
                                    {
                                        "columnName": "住所",
                                        "dataName": "jusho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 300,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "jusho"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "",
                            "onSelectByDblClick": "",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgTekiyoJogaiShisetsu",
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
                        },
                        {
                            "fieldName": "btnReturn",
                            "items": [],
                            "controlType": "Button",
                            "width": "100",
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
                            "onClick": "onClick_btnReturn",
                            "text": "閉じる",
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
                    "marginLeft": "XS",
                    "marginRight": "XS",
                    "selectControlID": "TekiyoJogaiShisetsuInputGuide",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "適用除外施設入力ガイド",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": false,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "TekiyoJogaiShisetsuInputGuide"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbz/db/dbz/TekiyoJogaiShisetsuInputGuide/onLoad"
                        },
                        {
                            "eventName": "onSelectBySelectButton_dgTekiyoJogaiShisetsu",
                            "requestUrl": "dbz/db/dbz/TekiyoJogaiShisetsuInputGuide/onSelectBySelectButton_dgTekiyoJogaiShisetsu"
                        }
                    ],
                    "hiddenInput": [
                        {
                            "propertyName": "shisetsuCode",
                            "value": ""
                        },
                        {
                            "propertyName": "shisetsuMeisho",
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
            "controlName": "TekiyoJogaiShisetsuInputGuide",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [
                {
                    "key": "shisetsuCode",
                    "controlName": "TekiyoJogaiShisetsuInputGuide.shisetsuCode"
                },
                {
                    "key": "shisetsuMeisho",
                    "controlName": "TekiyoJogaiShisetsuInputGuide.shisetsuMeisho"
                }
            ],
            "dialogOkEventNameForDialog": "onSelectBySelectButton_dgTekiyoJogaiShisetsu",
            "dialogCancelEventNameForDialog": "onClick_btnReturn",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return TekiyoJogaiShisetsuInputGuide_Design;
    })(Uz.CommonChildDiv);
    DBZ.TekiyoJogaiShisetsuInputGuide_Design = TekiyoJogaiShisetsuInputGuide_Design;
})(DBZ || (DBZ = {}));
