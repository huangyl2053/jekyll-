var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinseiTab) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnClose", {
                get: function () {
                    return "onClick_btnClose";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        JutakuKaishuJizenShinseiTab.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "JutakuKaishuJizenShinseiTab";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.JutakuKaishuJizenShinseisha = function () {
                return new DBZ.ShinseishaInfo.ModeController("JutakuKaishuJizenShinseisha");
            };

            Controls.prototype.JutakuKaishuJizenShinseiKyufugakuSummary = function () {
                return new DBC.KyufugakuSummary.ModeController("JutakuKaishuJizenShinseiKyufugakuSummary");
            };

            Controls.prototype.PaymentMethod = function () {
                return new DBZ.PaymentMethod.ModeController("PaymentMethod");
            };

            Controls.prototype.JutakuKaishuJizenShinseiTab = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tabJizenShinsei = function () {
                return new UZA.TabContainer(this.convFiledName("tabJizenShinsei"));
            };

            Controls.prototype.tplJizenShinseiContents = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiContents"));
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.dgJutakuKaishuJizenShinseiDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiReasonForTab = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiReasonForTab"));
            };

            Controls.prototype.txtCreateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            };

            Controls.prototype.txtCreatorKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            };

            Controls.prototype.txtCreatorName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            };

            Controls.prototype.txtCreationJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            };

            Controls.prototype.txtCreationJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            };

            Controls.prototype.tplJizenShinseiResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiResult"));
            };

            Controls.prototype.hl = function () {
                return new UZA.HorizontalLine(this.convFiledName("hl"));
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

            Controls.prototype.chkResetInfo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            };

            Controls.prototype.tplJizenShinseiPayMethod = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiPayMethod"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        JutakuKaishuJizenShinseiTab.Controls = Controls;
    })(DBC.JutakuKaishuJizenShinseiTab || (DBC.JutakuKaishuJizenShinseiTab = {}));
    var JutakuKaishuJizenShinseiTab = DBC.JutakuKaishuJizenShinseiTab;

    var JutakuKaishuJizenShinseiTab_Design = (function (_super) {
        __extends(JutakuKaishuJizenShinseiTab_Design, _super);
        function JutakuKaishuJizenShinseiTab_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, JutakuKaishuJizenShinseiTab_Design.myLayout, fieldName);
        }
        JutakuKaishuJizenShinseiTab_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("");
        };

        JutakuKaishuJizenShinseiTab_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        JutakuKaishuJizenShinseiTab_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "JutakuKaishuJizenShinseiTab",
                    "items": [
                        {
                            "fieldName": "tabJizenShinsei",
                            "items": [
                                {
                                    "fieldName": "tplJizenShinseiContents",
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
                                            "selectControlID": "txtJutakuOwner_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
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
                                            "onKeyPress": "",
                                            "text": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "住宅所有者",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
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
                                            "selectControlID": "txtRelationWithHihokensha_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
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
                                            "onKeyPress": "",
                                            "text": "",
                                            "suggest": [],
                                            "value": "",
                                            "labelLText": "被保険者との関係",
                                            "labelRText": "",
                                            "labelLWidth": "140",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "decorationClass": "",
                                            "permitCharactor": ""
                                        },
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
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "dgJutakuKaishuJizenShinseiDetail",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "height": "155",
                                            "gridSetting": {
                                                "rowHeight": 25,
                                                "isMultiSelectable": false,
                                                "isShowHeader": true,
                                                "isShowFooter": true,
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
                                                    "headerHeight": 1
                                                },
                                                "columns": [
                                                    {
                                                        "columnName": "着工日",
                                                        "dataName": "txtChakkoDate",
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
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtChakkoDate"
                                                    },
                                                    {
                                                        "columnName": "完成日",
                                                        "dataName": "txtKanseiDate",
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
                                                        "align": 0,
                                                        "resize": true,
                                                        "isPrivateInfo": false,
                                                        "sortKey": "txtKanseiDate"
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
                                                            "onChange": "",
                                                            "isSetValueToToolTip": false,
                                                            "readOnly": true
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
                                            "dataSource": [],
                                            "sortOrder": "txtChakkoDate",
                                            "isAscending": true,
                                            "filterList": [],
                                            "activeRowId": -1
                                        },
                                        {
                                            "fieldName": "JutakuKaishuJizenShinseisha",
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
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "JutakuKaishuJizenShinseisha",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "title": "申請者情報",
                                            "relation": [],
                                            "businessId": "DBZ",
                                            "controlName": "ShinseishaInfo",
                                            "marginTop": 0,
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "panelDisplay": 1,
                                            "btnJigyoshaInputGuide_displayNone": false,
                                            "txtUkestukeDate_displayNone": true,
                                            "txtJigyoshaNo_disabled": true,
                                            "txtShinseishaName_labelLText": "氏名",
                                            "txtYubinNo_displayNone": false,
                                            "txtAddress_displayNone": false,
                                            "btnJigyoshaInputGuide_disabled": false
                                        },
                                        {
                                            "fieldName": "JutakuKaishuJizenShinseiReasonForTab",
                                            "items": [
                                                {
                                                    "fieldName": "txtCreateDate",
                                                    "items": [],
                                                    "controlType": "TextBoxDate",
                                                    "width": "85",
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
                                                    "selectControlID": "txtCreateDate_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "onChange": "",
                                                    "required": false,
                                                    "placeHolder": "",
                                                    "textKind": 0,
                                                    "isPrivateInfo": false,
                                                    "isPassword": false,
                                                    "onFocus": "",
                                                    "onBlur": "",
                                                    "onKeyPress": "",
                                                    "text": "",
                                                    "value": "",
                                                    "labelLText": "作成日",
                                                    "labelRText": "",
                                                    "labelLWidth": "90",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "ymdKubun": 2,
                                                    "displayFormat": 0,
                                                    "permitCharactor": "./_-"
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
                                                    "selectControlID": "txtCreatorKanaName_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "onChange": "",
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
                                                    "onKeyPress": "",
                                                    "text": "",
                                                    "suggest": [],
                                                    "value": "",
                                                    "labelLText": "作成者氏名",
                                                    "labelRText": "",
                                                    "labelLWidth": "90",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "decorationClass": "",
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
                                                    "marginLeft": "6.1",
                                                    "marginRight": "XS",
                                                    "selectControlID": "txtCreatorName_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "onChange": "",
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
                                                    "permitCharactor": ""
                                                },
                                                {
                                                    "fieldName": "txtCreationJigyoshaNo",
                                                    "items": [],
                                                    "controlType": "TextBoxCode",
                                                    "width": "85",
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
                                                    "selectControlID": "txtCreationJigyoshaNo_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "onChange": "",
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
                                                    "onKeyPress": "",
                                                    "text": "",
                                                    "suggest": [],
                                                    "value": "",
                                                    "labelLText": "作成事業者",
                                                    "labelRText": "",
                                                    "labelLWidth": "90",
                                                    "labelRWidth": "S",
                                                    "labelLAlign": 2,
                                                    "labelRAlign": 0,
                                                    "decorationClass": "",
                                                    "permitCharactor": "",
                                                    "formatLength": "10"
                                                },
                                                {
                                                    "fieldName": "txtCreationJigyoshaName",
                                                    "items": [],
                                                    "controlType": "TextBox",
                                                    "width": "320",
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
                                                    "marginLeft": "6.1",
                                                    "marginRight": "XS",
                                                    "selectControlID": "txtCreationJigyoshaName_core",
                                                    "helpMessageID": "",
                                                    "jpControlName": "",
                                                    "readOnly": false,
                                                    "onChange": "",
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
                                                    "permitCharactor": ""
                                                }
                                            ],
                                            "controlType": "Panel",
                                            "width": "440",
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
                                            "selectControlID": "JutakuKaishuJizenShinseiReasonForTab",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "onLoad": "",
                                            "title": "住宅改修理由書",
                                            "marginTop": "0",
                                            "marginBottom": "Default",
                                            "isOpen": true,
                                            "canOpenAndClose": false,
                                            "postParameterPanelNames": [
                                                {
                                                    "postParameterPanelNames": "JutakuKaishuJizenShinseiReasonForTab"
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
                                            "height": "Auto",
                                            "focusPositionID": "restoreLayoutButton",
                                            "eraseBorderTop": false,
                                            "eraseBorderBottom": false,
                                            "eraseBorderRight": false,
                                            "eraseBorderLeft": false
                                        }
                                    ],
                                    "controlType": "TabPanel",
                                    "width": "1085",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": true,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplJizenShinseiContents",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "事前申請内容",
                                    "onActive": "",
                                    "onFirstActive": ""
                                },
                                {
                                    "fieldName": "tplJizenShinseiResult",
                                    "items": [
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
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "JutakuKaishuJizenShinseiKyufugakuSummary",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "relation": [],
                                            "businessId": "DBC",
                                            "controlName": "KyufugakuSummary",
                                            "marginTop": "0",
                                            "marginBottom": 0,
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "btnLimitOverCheck_displayNone": true,
                                            "btnRireki_displayNone": true
                                        },
                                        {
                                            "fieldName": "hl",
                                            "items": [],
                                            "controlType": "HorizontalLine",
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
                                            "selectControlID": "hl",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "size": "960"
                                        },
                                        {
                                            "fieldName": "txtJudgeDate",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "85",
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
                                            "selectControlID": "txtJudgeDate_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "required": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "判定決定日",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "permitCharactor": "./_-"
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
                                            "selectControlID": "radJudgeKubun_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": null,
                                            "required": false,
                                            "labelLText": "判定区分",
                                            "labelLWidth": "75",
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
                                            "icon": [],
                                            "newLineItemNumber": 2,
                                            "spaceSize": "M",
                                            "disabledItem": []
                                        },
                                        {
                                            "fieldName": "txtShoninCondition",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "360",
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
                                            "selectControlID": "txtShoninCondition_text_area",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "height": "XS",
                                            "onChange": "",
                                            "required": false,
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "承認条件",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "limitLength": "",
                                            "countDisp": false
                                        },
                                        {
                                            "fieldName": "txtFushoninReason",
                                            "items": [],
                                            "controlType": "TextBoxMultiLine",
                                            "width": "360",
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
                                            "selectControlID": "txtFushoninReason_text_area",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "height": "XS",
                                            "onChange": "",
                                            "required": false,
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "value": "",
                                            "labelLText": "不承認理由",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "limitLength": "",
                                            "countDisp": false
                                        },
                                        {
                                            "fieldName": "chkResetInfo",
                                            "items": [],
                                            "controlType": "CheckBoxList",
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
                                            "selectControlID": "chkResetInfo_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": false,
                                            "onChange": "",
                                            "selectedItem": null,
                                            "required": false,
                                            "labelLText": "限度額リセット",
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
                                            "icon": [],
                                            "newLineItemNumber": 1,
                                            "spaceSize": 1,
                                            "disabledItem": [],
                                            "selectedItems": [],
                                            "minCheckedItem": 0,
                                            "maxCheckedItem": 2,
                                            "isAllSelectable": false,
                                            "isAllSelectableBreakLine": false
                                        }
                                    ],
                                    "controlType": "TabPanel",
                                    "width": "1085",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": true,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplJizenShinseiResult",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "事前申請結果",
                                    "onActive": "",
                                    "onFirstActive": ""
                                },
                                {
                                    "fieldName": "tplJizenShinseiPayMethod",
                                    "items": [
                                        {
                                            "fieldName": "PaymentMethod",
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
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "PaymentMethod",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "title": "",
                                            "relation": [],
                                            "businessId": "DBZ",
                                            "controlName": "PaymentMethod",
                                            "marginTop": 0,
                                            "marginBottom": "XS",
                                            "originalProperty": [],
                                            "dataPassingForDialog": [],
                                            "dialogOkEventNameForDialog": "",
                                            "dialogCancelEventNameForDialog": "",
                                            "canTransferEvent": true,
                                            "heightForDialog": "M",
                                            "eraseBorder": true,
                                            "panelDisplay": 0,
                                            "KozaPayment_title": "",
                                            "onClick_radPayMethod": "",
                                            "Juryoinin_displayNone": true,
                                            "Madoguchi_displayNone": true,
                                            "Koza_displayNone": false,
                                            "eraseBorderTop": false,
                                            "eraseBorderBottom": false,
                                            "eraseBorderRight": false,
                                            "eraseBorderLeft": false
                                        }
                                    ],
                                    "controlType": "TabPanel",
                                    "width": "1085",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": true,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "tplJizenShinseiPayMethod",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "title": "支払情報",
                                    "onActive": "",
                                    "onFirstActive": ""
                                }
                            ],
                            "controlType": "TabContainer",
                            "width": "1090",
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
                            "selectControlID": "tabJizenShinsei",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onChange": "",
                            "selectedItem": null,
                            "tabpanelPosition": [
                                "tplJizenShinseiContents",
                                "tplJizenShinseiResult",
                                "tplJizenShinseiPayMethod"
                            ],
                            "isDraggable": false,
                            "selectedItemFieldName": "tplJizenShinseiContents",
                            "initialTab": 0,
                            "isLazyLoading": false
                        },
                        {
                            "fieldName": "btnClose",
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
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "閉じる",
                            "onClick": "onClick_btnClose",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G12",
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
                    "selectControlID": "JutakuKaishuJizenShinseiTab",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "JutakuKaishuJizenShinseiTab"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbc/db/dbc/JutakuKaishuJizenShinseiTab/onLoad"
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": false,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "435",
                    "focusPositionID": "restoreLayoutButton",
                    "eraseBorderTop": false,
                    "eraseBorderBottom": false,
                    "eraseBorderRight": false,
                    "eraseBorderLeft": false
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
            "businessId": "DBC",
            "controlName": "JutakuKaishuJizenShinseiTab",
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
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "485"
        };
        return JutakuKaishuJizenShinseiTab_Design;
    })(Uz.CommonChildDiv);
    DBC.JutakuKaishuJizenShinseiTab_Design = JutakuKaishuJizenShinseiTab_Design;
})(DBC || (DBC = {}));
