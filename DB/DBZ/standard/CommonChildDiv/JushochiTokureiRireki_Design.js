var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    var JushochiTokureiRireki_Design = (function (_super) {
        __extends(JushochiTokureiRireki_Design, _super);
        function JushochiTokureiRireki_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JushochiTokureiRireki_Design.myLayout, fieldName);
        }
        JushochiTokureiRireki_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        JushochiTokureiRireki_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JushochiTokureiRireki_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JushochiTokureiRireki",
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
                            "marginLeft": "0px",
                            "marginRight": "0px",
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
                            "heightTextBoxMatches": false
                        },
                        {
                            "fieldName": "dgJushochiTokureiRireki",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "1098px",
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
                            "selectControlID": "dgJushochiTokureiRireki",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "192px",
                            "gridSetting": {
                                "rowHeight": 25,
                                "isMultiSelectable": false,
                                "isShowHeader": true,
                                "isShowFooter": true,
                                "isShowFilter": false,
                                "isShowFilterButton": false,
                                "isShowRowState": false,
                                "isShowSelectButtonColumn": true,
                                "isShowModifyButtonColumn": true,
                                "isShowDeleteButtonColumn": true,
                                "limitRowCount": 0,
                                "selectedRowCount": 0,
                                "selectLimitRowCount": 0,
                                "header": {
                                    "combineColumns": [
                                        {
                                            "combineColumnName": "適用",
                                            "combineItem": [
                                                "tekiyoDate",
                                                "tekiyoTodokedeDate",
                                                "tekiyoJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "解除",
                                            "combineItem": [
                                                "kaijoDate",
                                                "kaijoTodokedeDate",
                                                "kaijoJiyu"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "措置元情報",
                                            "combineItem": [
                                                "sochiHokenshaMeisho",
                                                "sochiHihokenshaNo"
                                            ]
                                        },
                                        {
                                            "combineColumnName": "施設情報",
                                            "combineItem": [
                                                "nyushoDate",
                                                "taishoDate",
                                                "shisetsuShurui",
                                                "nyushoShisetsu"
                                            ]
                                        }
                                    ],
                                    "frozenColumn": "",
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "適用日",
                                        "dataName": "tekiyoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
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
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
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
                                        "width": 100,
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
                                        "columnName": "解除日",
                                        "dataName": "kaijoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
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
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
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
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "kaijoJiyu"
                                    },
                                    {
                                        "columnName": "保険者",
                                        "dataName": "sochiHokenshaMeisho",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 100,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochiHokenshaMeisho"
                                    },
                                    {
                                        "columnName": "被保番号",
                                        "dataName": "sochiHihokenshaNo",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 90,
                                        "visible": true,
                                        "cellType": 4,
                                        "cellDetails": {
                                            "cellType": 4,
                                            "maxLength": "100000000",
                                            "minLength": "0",
                                            "formatLength": "10",
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "sochiHihokenshaNo"
                                    },
                                    {
                                        "columnName": "入所日",
                                        "dataName": "nyushoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "nyushoDate"
                                    },
                                    {
                                        "columnName": "退所日",
                                        "dataName": "taishoDate",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 6,
                                        "cellDetails": {
                                            "cellType": 6,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "onChange": "",
                                            "isSetValueToToolTip": false,
                                            "readOnly": true
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "taishoDate"
                                    },
                                    {
                                        "columnName": "施設種類",
                                        "dataName": "shisetsuShurui",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 120,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "shisetsuShurui"
                                    },
                                    {
                                        "columnName": "入所施設",
                                        "dataName": "nyushoShisetsu",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 250,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "nyushoShisetsu"
                                    }
                                ]
                            },
                            "onSort": "",
                            "onSelect": "onSelect_dgJushochiTokureiRireki",
                            "onSelectByDblClick": "onSelectByDblClick_dgJushochiTokureiRireki",
                            "onSelectBySelectButton": "onSelectBySelectButton_dgJushochiTokureiRireki",
                            "onSelectByModifyButton": "onSelectByModifyButton_dgJushochiTokureiRireki",
                            "onSelectByDeleteButton": "onSelectByDeleteButton_dgJushochiTokureiRireki",
                            "onAfterRequest": "",
                            "onAfterRequestByDblClick": "",
                            "onAfterRequestBySelectButton": "",
                            "onAfterRequestByModifyButton": "",
                            "onAfterRequestByDeleteButton": "",
                            "onOnlyRow": "",
                            "onNoRow": "",
                            "onMultiRows": "",
                            "dataSource": [],
                            "sortOrder": "sochiHihokenshaNo",
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
                    "marginLeft": "Default",
                    "marginRight": "Default",
                    "selectControlID": "JushochiTokureiRireki",
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
            "controlName": "JushochiTokureiRireki",
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
                    "eventName": "onSelect_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByDblClick_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectBySelectButton_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByModifyButton_dgJushochiTokureiRireki"
                },
                {
                    "eventName": "onSelectByDeleteButton_dgJushochiTokureiRireki"
                }
            ],
            "publicEventsAlias": []
        };
        return JushochiTokureiRireki_Design;
    })(Uz.CommonChildDiv);
    DBZ.JushochiTokureiRireki_Design = JushochiTokureiRireki_Design;

    (function (JushochiTokureiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJushochiTokureiRireki = function () {
                return "onSelect_dgJushochiTokureiRireki";
            };

            Events.onSelectByDblClick_dgJushochiTokureiRireki = function () {
                return "onSelectByDblClick_dgJushochiTokureiRireki";
            };

            Events.onSelectBySelectButton_dgJushochiTokureiRireki = function () {
                return "onSelectBySelectButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByModifyButton_dgJushochiTokureiRireki = function () {
                return "onSelectByModifyButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByDeleteButton_dgJushochiTokureiRireki = function () {
                return "onSelectByDeleteButton_dgJushochiTokureiRireki";
            };
            return Events;
        })();
        JushochiTokureiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRireki = function () {
                return new UZA.Panel(this.convFiledName("JushochiTokureiRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJushochiTokureiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgJushochiTokureiRireki"));
            };
            return Controls;
        })();
        JushochiTokureiRireki.Controls = Controls;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
