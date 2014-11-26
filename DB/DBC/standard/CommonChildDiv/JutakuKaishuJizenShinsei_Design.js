var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinsei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JutakuKaishuJizenShinsei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "JutakuKaishuJizenShinsei";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.JutakuKaishuJizenShinseiKyufugakuSummary = function () {
                return new DBC.KyufugakuSummary.ModeController("JutakuKaishuJizenShinseiKyufugakuSummary");
            };

            Controls.prototype.JutakuKaishuJizenShinseiSha = function () {
                return new DBC.ShinseishaInfo.ModeController("JutakuKaishuJizenShinseiSha");
            };

            Controls.prototype.JutakuKaishuJizenShinsei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.JutakuKaishuJizenShinseiContents = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents"));
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.JutakuKaishuZizenShinseiDetail = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuZizenShinseiDetail"));
            };

            Controls.prototype.dgJutakuKaishuJizenShinseiDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiReason = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiReason"));
            };

            Controls.prototype.txtCreateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            };

            Controls.prototype.txtCreationJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            };

            Controls.prototype.btnSearchCreationJigyoshaName = function () {
                return new UZA.Button(this.convFiledName("btnSearchCreationJigyoshaName"));
            };

            Controls.prototype.txtCreationJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            };

            Controls.prototype.txtCreatorKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            };

            Controls.prototype.txtCreatorName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiKozaInfoMock = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiKozaInfoMock"));
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaType = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaType"));
            };

            Controls.prototype.txtKozaMeigininKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKanaName"));
            };

            Controls.prototype.txtKinyuBranchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuBranchCode"));
            };

            Controls.prototype.txtKinyuBranchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuBranchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeigininName = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininName"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiResult = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiShinsaResult = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiShinsaResult"));
            };

            Controls.prototype.txtJudgeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJudgeDate"));
            };

            Controls.prototype.radJudgeKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgeKubun"));
            };

            Controls.prototype.txtShoninCondition = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShoninCondition"));
            };

            Controls.prototype.txtFushoninReason = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninReason"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiResetInfo = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResetInfo"));
            };

            Controls.prototype.chkResetInfo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            };

            Controls.prototype.JutakuKaishuJizenShoninKetteiTsuchisho = function () {
                return new UZA.PanelPublish(this.convFiledName("JutakuKaishuJizenShoninKetteiTsuchisho"));
            };

            Controls.prototype.txtHakkoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoDate"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        JutakuKaishuJizenShinsei.Controls = Controls;
    })(DBC.JutakuKaishuJizenShinsei || (DBC.JutakuKaishuJizenShinsei = {}));
    var JutakuKaishuJizenShinsei = DBC.JutakuKaishuJizenShinsei;

    var JutakuKaishuJizenShinsei_Design = (function (_super) {
        __extends(JutakuKaishuJizenShinsei_Design, _super);
        function JutakuKaishuJizenShinsei_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JutakuKaishuJizenShinsei_Design.myLayout, fieldName);
        }
        JutakuKaishuJizenShinsei_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("");
        };

        JutakuKaishuJizenShinsei_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JutakuKaishuJizenShinsei_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JutakuKaishuJizenShinsei",
                    "items": [
                        {
                            "fieldName": "JutakuKaishuJizenShinseiContents",
                            "items": [
                                {
                                    "fieldName": "txtJutakuOwner",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "required": false,
                                    "maxLength": 1000000000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 0,
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
                                    "labelLText": "住宅所有者",
                                    "labelRText": "",
                                    "labelLWidth": "75",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtRelationWithHihokensha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "100",
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
                                    "required": false,
                                    "maxLength": 1000000000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "readOnly": false,
                                    "placeHolder": "",
                                    "textKind": 0,
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
                                    "labelLText": "被保険者（本人）との関係",
                                    "labelRText": "",
                                    "labelLWidth": "180",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "JutakuKaishuZizenShinseiDetail",
                                    "items": [
                                        {
                                            "fieldName": "dgJutakuKaishuJizenShinseiDetail",
                                            "items": [],
                                            "controlType": "DataGrid",
                                            "width": "965",
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
                                            "gridSetting": {
                                                "rowHeight": 25,
                                                "isMultiSelectable": false,
                                                "isShowFooter": true,
                                                "isShowFilter": false,
                                                "isShowFilterButton": false,
                                                "isShowRowState": false,
                                                "header": {
                                                    "combineColumns": [],
                                                    "frozenColumn": "",
                                                    "headerHeight": 1
                                                },
                                                "columns": [
                                                    {
                                                        "columnName": "着工<br>予定日",
                                                        "dataName": "txtChakkoDueDate",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 80,
                                                        "visible": true,
                                                        "cellType": 6,
                                                        "cellDetails": {
                                                            "cellType": 6,
                                                            "ymdKubun": 2,
                                                            "displayFormat": 0,
                                                            "onChange": ""
                                                        },
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtChakkoDueDate"
                                                    },
                                                    {
                                                        "columnName": "完成<br>予定日",
                                                        "dataName": "txtKanseiDueDate",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 80,
                                                        "visible": true,
                                                        "cellType": 6,
                                                        "cellDetails": {
                                                            "cellType": 6,
                                                            "ymdKubun": 2,
                                                            "displayFormat": 0,
                                                            "onChange": ""
                                                        },
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtKanseiDueDate"
                                                    },
                                                    {
                                                        "columnName": "見積金額",
                                                        "dataName": "txtMitsumoriAmount",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 100,
                                                        "visible": true,
                                                        "cellType": 5,
                                                        "cellDetails": {
                                                            "cellType": 5,
                                                            "maxLength": "1000000000000",
                                                            "minLength": "0",
                                                            "maxValue": "1.7976931348623157e+308",
                                                            "minValue": "0",
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": "0",
                                                            "onChange": ""
                                                        },
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtMitsumoriAmount"
                                                    },
                                                    {
                                                        "columnName": "事業者",
                                                        "dataName": "txtKaishuJigyosha",
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
                                                        "sortKey": "txtKaishuJigyosha"
                                                    },
                                                    {
                                                        "columnName": "対象住宅住所",
                                                        "dataName": "txtTaishoJutakuAddress",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 240,
                                                        "visible": true,
                                                        "cellType": 0,
                                                        "cellDetails": {
                                                            "cellType": 0
                                                        },
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtTaishoJutakuAddress"
                                                    },
                                                    {
                                                        "columnName": "改修内容",
                                                        "dataName": "txtKaishuContents",
                                                        "toolTip": "",
                                                        "bgColor": 0,
                                                        "width": 290,
                                                        "visible": true,
                                                        "cellType": 0,
                                                        "cellDetails": null,
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtKaishuContents"
                                                    }
                                                ]
                                            },
                                            "height": "150",
                                            "onSort": "",
                                            "onSelect": "",
                                            "onSelectByDblClick": "",
                                            "onOnlyRow": "",
                                            "onNoRow": "",
                                            "onMultiRows": "",
                                            "dataSource": [],
                                            "sortOrder": "txtMitsumoriAmount",
                                            "isAscending": true,
                                            "filterList": [],
                                            "activeRowId": -1
                                        },
                                        {
                                            "fieldName": "JutakuKaishuJizenShinseiKyufugakuSummary",
                                            "items": [],
                                            "controlType": "CommonChildDiv",
                                            "width": "XS",
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
                                            "marginLeft": 0,
                                            "marginRight": 0,
                                            "relation": [],
                                            "businessId": "DBC",
                                            "controlName": "KyufugakuSummary",
                                            "marginTop": "3.5",
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "btnLimitOverCheck_displayNone": true
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "985",
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
                                    "onLoad": "",
                                    "title": "住宅改修明細",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuZizenShinseiDetail"
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
                                    "isGroupBox": true
                                },
                                {
                                    "fieldName": "JutakuKaishuJizenShinseiSha",
                                    "items": [],
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
                                    "relation": [],
                                    "businessId": "DBC",
                                    "controlName": "ShinseishaInfo",
                                    "marginTop": 0,
                                    "marginBottom": 0,
                                    "originalProperty": [],
                                    "dataPassingForDialog": [],
                                    "dialogOkEventNameForDialog": "",
                                    "dialogCancelEventNameForDialog": ""
                                },
                                {
                                    "fieldName": "JutakuKaishuJizenShinseiReason",
                                    "items": [
                                        {
                                            "fieldName": "txtCreateDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "80",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "平26.07.01",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "作成日",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "txtCreationJigyoshaNo",
                                            "items": [],
                                            "controlType": "TextBoxCode",
                                            "width": "80",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "1234567890",
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
                                            "labelLText": "作成事業者",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "btnSearchCreationJigyoshaName",
                                            "items": [],
                                            "controlType": "Button",
                                            "width": "XS",
                                            "visible": true,
                                            "displayNone": true,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "-0.3",
                                            "marginRight": "XS",
                                            "text": "探",
                                            "onClick": "",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        {
                                            "fieldName": "txtCreationJigyoshaName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "300",
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
                                            "marginLeft": "6.3",
                                            "marginRight": "XS",
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtCreatorKanaName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "200",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "labelLText": "作成者氏名",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtCreatorName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "200",
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
                                            "marginLeft": "6.3",
                                            "marginRight": "XS",
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "permitCharactor": ""
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "490",
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
                                    "marginLeft": "-0.1",
                                    "marginRight": "XS",
                                    "onLoad": "",
                                    "title": "住宅改修理由書",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuJizenShinseiReason"
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
                                    "isGroupBox": true
                                },
                                {
                                    "fieldName": "JutakuKaishuJizenShinseiKozaInfoMock",
                                    "items": [
                                        {
                                            "fieldName": "txtKinyuKikanCode",
                                            "items": [],
                                            "controlType": "TextBoxCode",
                                            "width": "35",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "1234",
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
                                            "labelLText": "金融機関",
                                            "labelRText": "",
                                            "labelLWidth": "60",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "txtKinyuKikanName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "270",
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
                                            "marginLeft": "-0.3",
                                            "marginRight": "XS",
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "radKozaType",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "190",
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
                                            "required": false,
                                            "onChange": "",
                                            "labelLText": "口座種別",
                                            "labelLWidth": "60",
                                            "labelLAlign": 2,
                                            "dataSource": [
                                                {
                                                    "key": "futsu",
                                                    "value": "普通"
                                                },
                                                {
                                                    "key": "toza",
                                                    "value": "当座"
                                                },
                                                {
                                                    "key": "sonota",
                                                    "value": "その他"
                                                }
                                            ],
                                            "onClick": "",
                                            "selectedItem": "futsu",
                                            "newLineItemNumber": 3,
                                            "spaceSize": 0
                                        },
                                        {
                                            "fieldName": "txtKozaMeigininKanaName",
                                            "items": [],
                                            "controlType": "TextBox",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "labelLText": "口座名義人",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtKinyuBranchCode",
                                            "items": [],
                                            "controlType": "TextBoxCode",
                                            "width": "35",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "123",
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
                                            "labelLText": "支店",
                                            "labelRText": "",
                                            "labelLWidth": "60",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "txtKinyuBranchName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "270",
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
                                            "marginLeft": "-0.3",
                                            "marginRight": "XS",
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtKozaNo",
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
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "1234567",
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
                                            "labelLText": "口座番号",
                                            "labelRText": "",
                                            "labelLWidth": "60",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "txtKozaMeigininName",
                                            "items": [],
                                            "controlType": "TextBox",
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
                                            "marginLeft": "14.9",
                                            "marginRight": "XS",
                                            "required": false,
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
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
                                            "permitCharactor": ""
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "985",
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
                                    "onLoad": "",
                                    "title": "口座振替申請情報Mock（UR）",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": false,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuJizenShinseiKozaInfoMock"
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
                                    "isGroupBox": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1000",
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
                            "onLoad": "",
                            "title": "事前申請内容",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "JutakuKaishuJizenShinseiContents"
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
                            "isGroupBox": false
                        },
                        {
                            "fieldName": "JutakuKaishuJizenShinseiResult",
                            "items": [
                                {
                                    "fieldName": "JutakuKaishuJizenShinseiShinsaResult",
                                    "items": [
                                        {
                                            "fieldName": "txtJudgeDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "80",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "平26.07.01",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "判定決定日",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        },
                                        {
                                            "fieldName": "radJudgeKubun",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "M",
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
                                            "required": false,
                                            "onChange": "",
                                            "labelLText": "判定区分",
                                            "labelLWidth": "60",
                                            "labelLAlign": 2,
                                            "dataSource": [
                                                {
                                                    "key": "shonin",
                                                    "value": "承認"
                                                },
                                                {
                                                    "key": "fushonin",
                                                    "value": "不承認"
                                                }
                                            ],
                                            "onClick": "",
                                            "selectedItem": "",
                                            "newLineItemNumber": 2,
                                            "spaceSize": 1
                                        },
                                        {
                                            "fieldName": "txtShoninCondition",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "385",
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
                                            "required": false,
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "承認条件",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "height": "XS",
                                            "limitLength": "",
                                            "countDisp": false
                                        },
                                        {
                                            "fieldName": "txtFushoninReason",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "385",
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
                                            "required": false,
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "不承認理由",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "height": "XS",
                                            "limitLength": "",
                                            "countDisp": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "985",
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
                                    "marginRight": "0",
                                    "onLoad": "",
                                    "title": "審査結果",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuJizenShinseiShinsaResult"
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
                                    "isGroupBox": false
                                },
                                {
                                    "fieldName": "JutakuKaishuJizenShinseiResetInfo",
                                    "items": [
                                        {
                                            "fieldName": "chkResetInfo",
                                            "items": [],
                                            "controlType": "CheckBoxList",
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
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "required": false,
                                            "onChange": "",
                                            "labelLText": "",
                                            "labelLWidth": "S",
                                            "labelLAlign": 2,
                                            "dataSource": [
                                                {
                                                    "key": "threeUp",
                                                    "value": "要介護状態区分３段階変更による"
                                                },
                                                {
                                                    "key": "changeAddress",
                                                    "value": "住宅住所変更による"
                                                }
                                            ],
                                            "onClick": "",
                                            "selectedItem": "",
                                            "newLineItemNumber": 1,
                                            "spaceSize": 1,
                                            "selectedItems": [],
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": 2,
                                            "isAllSelectable": false
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "490",
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
                                    "onLoad": "",
                                    "title": "リセット情報",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuJizenShinseiResetInfo"
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
                                    "isGroupBox": false
                                },
                                {
                                    "fieldName": "JutakuKaishuJizenShoninKetteiTsuchisho",
                                    "items": [
                                        {
                                            "fieldName": "txtHakkoDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "80",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "平26.07.01",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "発行日",
                                            "labelRText": "",
                                            "labelLWidth": "45",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "permitCharactor": "./_-",
                                            "ymdKubun": 2,
                                            "displayFormat": 0
                                        }
                                    ],
                                    "controlType": "PanelPublish",
                                    "width": "490",
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
                                    "onLoad": "",
                                    "title": "住宅改修事前承認（不承認）決定通知書",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "JutakuKaishuJizenShoninKetteiTsuchisho"
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
                                    "isGroupBox": false,
                                    "isPublish": true
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1000",
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
                            "onLoad": "",
                            "title": "",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": true,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "JutakuKaishuJizenShinseiResult"
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
                            "isGroupBox": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1010",
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
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JutakuKaishuJizenShinsei"
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
            "relation": [],
            "businessId": "DBC",
            "controlName": "JutakuKaishuJizenShinsei",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "",
                    "publicChildProperty": "",
                    "newPropertyName": ""
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return JutakuKaishuJizenShinsei_Design;
    })(Uz.CommonChildDiv);
    DBC.JutakuKaishuJizenShinsei_Design = JutakuKaishuJizenShinsei_Design;
})(DBC || (DBC = {}));
