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
                            "onBeforeClick": "",
                            "onAfterClick": "",
                            "onClick": "onClick_btnAdd",
                            "text": "追加する",
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
                            "dataSource": [],
                            "sortOrder": "tekiyoDate",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1,
                            "gridAction": []
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
                return new UZA.Panel(this.convFiledName("JushochiTokureiRirekiList"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
