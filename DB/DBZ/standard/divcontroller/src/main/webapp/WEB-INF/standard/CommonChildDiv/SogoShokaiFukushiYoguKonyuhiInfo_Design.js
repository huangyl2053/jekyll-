var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
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
        SogoShokaiFukushiYoguKonyuhiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "SogoShokaiFukushiYoguKonyuhiInfo";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.SogoShokaiFukushiYoguKonyuhiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            };

            Controls.prototype.dgYoguSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgYoguSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.txtShumoku = function () {
                return new UZA.TextBox(this.convFiledName("txtShumoku"));
            };

            Controls.prototype.txtShohinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohinName"));
            };

            Controls.prototype.txtSeizoJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));
            };

            Controls.prototype.txtHanbaiJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));
            };

            Controls.prototype.txtBuyAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));
            };

            Controls.prototype.txtHinmokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));
            };

            Controls.prototype.txtShinsaMethod = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaMethod"));
            };

            Controls.prototype.tblYoguSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblYoguSeikyuSummary"));
            };

            Controls.prototype.celYogu11 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu11"));
            };

            Controls.prototype.lblYoguSummary = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummary"));
            };

            Controls.prototype.celYogu12 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu12"));
            };

            Controls.prototype.lblYoguPayTotal = function () {
                return new UZA.Label(this.convFiledName("lblYoguPayTotal"));
            };

            Controls.prototype.celYogu13 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu13"));
            };

            Controls.prototype.lblYoguHokenSeikyuAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguHokenSeikyuAmount"));
            };

            Controls.prototype.celYogu21 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu21"));
            };

            Controls.prototype.lblYoguSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryMae"));
            };

            Controls.prototype.celYogu22 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu22"));
            };

            Controls.prototype.txtYoguPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalMae"));
            };

            Controls.prototype.celYogu23 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu23"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountMae"));
            };

            Controls.prototype.celYogu31 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu31"));
            };

            Controls.prototype.lblYoguSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryNow"));
            };

            Controls.prototype.celYogu32 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu32"));
            };

            Controls.prototype.txtYoguPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalNow"));
            };

            Controls.prototype.celYogu33 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu33"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountNow"));
            };

            Controls.prototype.celYogu14 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu14"));
            };

            Controls.prototype.lblYoguRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguRiyoshaFutanAmount"));
            };

            Controls.prototype.celYogu15 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu15"));
            };

            Controls.prototype.lblYoguLimitOverAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguLimitOverAmount"));
            };

            Controls.prototype.celYogu24 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu24"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountMae"));
            };

            Controls.prototype.celYogu25 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu25"));
            };

            Controls.prototype.txtYoguLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountMae"));
            };

            Controls.prototype.celYogu34 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu34"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountNow"));
            };

            Controls.prototype.celYogu35 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu35"));
            };

            Controls.prototype.txtYoguLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountNow"));
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
        SogoShokaiFukushiYoguKonyuhiInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;

    var SogoShokaiFukushiYoguKonyuhiInfo_Design = (function (_super) {
        __extends(SogoShokaiFukushiYoguKonyuhiInfo_Design, _super);
        function SogoShokaiFukushiYoguKonyuhiInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SogoShokaiFukushiYoguKonyuhiInfo_Design.myLayout, fieldName);
        }
        SogoShokaiFukushiYoguKonyuhiInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        SogoShokaiFukushiYoguKonyuhiInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        SogoShokaiFukushiYoguKonyuhiInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SogoShokaiFukushiYoguKonyuhiInfo",
                    "items": [
                        {
                            "fieldName": "txtTeikyoYM",
                            "items": [],
                            "controlType": "TextBoxDate",
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
                            "selectControlID": "txtTeikyoYM_core",
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
                            "labelLText": "提供年月",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 1,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtSeiriNo",
                            "items": [],
                            "controlType": "TextBoxCode",
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
                            "selectControlID": "txtSeiriNo_core",
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
                            "labelLText": "整理番号",
                            "labelRText": "",
                            "labelLWidth": "70",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": "",
                            "formatLength": "10"
                        },
                        {
                            "fieldName": "txtKyufuritsu",
                            "items": [],
                            "controlType": "TextBoxNum",
                            "width": "40",
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
                            "selectControlID": "txtKyufuritsu_core",
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
                            "labelLText": "給付率",
                            "labelRText": "％",
                            "labelLWidth": "55",
                            "labelRWidth": "15",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": "+-,.\\",
                            "maxValue": 1.7976931348623157e+308,
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0
                        },
                        {
                            "fieldName": "dgYoguSeikyuDetail",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "450",
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
                            "selectControlID": "dgYoguSeikyuDetail",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "175",
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
                                    "headerHeight": 0
                                },
                                "columns": [
                                    {
                                        "columnName": "",
                                        "dataName": "btnSelect",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 35,
                                        "visible": true,
                                        "cellType": 8,
                                        "cellDetails": {
                                            "cellType": 8,
                                            "text": "",
                                            "onClick": "onClick_btnSelectYoguKonyuhi",
                                            "imageFileUrl": "/uz/uza/image/UZ_RowSelect_On.png",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "btnSelect"
                                    },
                                    {
                                        "columnName": "購入日",
                                        "dataName": "txtBuyYMD",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtBuyYMD"
                                    },
                                    {
                                        "columnName": "種目",
                                        "dataName": "txtShumoku",
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
                                        "sortKey": "txtShumoku"
                                    },
                                    {
                                        "columnName": "商品名",
                                        "dataName": "txtShohinName",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 210,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtShohinName"
                                    },
                                    {
                                        "columnName": "購入金額",
                                        "dataName": "txtBuyAmount",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 80,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 2,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "txtBuyAmount"
                                    },
                                    {
                                        "columnName": "審査方法",
                                        "dataName": "txtShinsaMethod",
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
                                        "sortKey": "txtShinsaMethod"
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
                            "sortOrder": "txtBuyAmount",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
                            "items": [
                                {
                                    "fieldName": "txtBuyYMD",
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
                                    "selectControlID": "txtBuyYMD_core",
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
                                    "labelLText": "購入日",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "textKind": 0,
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtShumoku",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "250",
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
                                    "selectControlID": "txtShumoku_core",
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
                                    "labelLText": "種目",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtShohinName",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
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
                                    "selectControlID": "txtShohinName_core",
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
                                    "labelLText": "商品名",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtSeizoJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
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
                                    "selectControlID": "txtSeizoJigyosha_core",
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
                                    "labelLText": "製造事業者",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtHanbaiJigyosha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
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
                                    "selectControlID": "txtHanbaiJigyosha_core",
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
                                    "labelLText": "販売事業者",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtBuyAmount",
                                    "items": [],
                                    "controlType": "TextBoxNum",
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
                                    "selectControlID": "txtBuyAmount_core",
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
                                    "labelLText": "購入金額",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 2,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": "+-,.\\",
                                    "maxValue": 1.7976931348623157e+308,
                                    "minValue": 0,
                                    "isCurrency": false,
                                    "isComma": true,
                                    "decimalPointLength": 0
                                },
                                {
                                    "fieldName": "txtHinmokuCode",
                                    "items": [],
                                    "controlType": "TextBoxCode",
                                    "width": "300",
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
                                    "selectControlID": "txtHinmokuCode_core",
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
                                    "labelLText": "品目コード",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 2,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": "",
                                    "formatLength": "16"
                                },
                                {
                                    "fieldName": "txtShinsaMethod",
                                    "items": [],
                                    "controlType": "TextBox",
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
                                    "selectControlID": "txtShinsaMethod_core",
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
                                    "labelLText": "審査方法",
                                    "labelRText": "",
                                    "labelLWidth": "85",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "405",
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
                            "selectControlID": "YoguKonyuhiShikyuShinseiSeikyuDetail",
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
                                    "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetail"
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
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": false,
                            "panelDisplay": 0,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "tblYoguSeikyuSummary",
                            "items": [
                                {
                                    "fieldName": "celYogu11",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguSummary",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "XS",
                                            "visible": true,
                                            "displayNone": true,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblYoguSummary",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "集計",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celYogu12",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguPayTotal",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "115",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblYoguPayTotal",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "支払金額合計",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celYogu13",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguHokenSeikyuAmount",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "115",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblYoguHokenSeikyuAmount",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "保険請求額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu13",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C3"
                                },
                                {
                                    "fieldName": "celYogu21",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguSummaryMae",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "150",
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
                                            "selectControlID": "lblYoguSummaryMae",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "前回までの支払結果",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu21",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celYogu22",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguPayTotalMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguPayTotalMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu22",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celYogu23",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguHokenSeikyuAmountMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguHokenSeikyuAmountMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu23",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "celYogu31",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguSummaryNow",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "150",
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
                                            "selectControlID": "lblYoguSummaryNow",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "今回の支払状況",
                                            "decorationClass": "",
                                            "align": 2
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu31",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celYogu32",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguPayTotalNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguPayTotalNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu32",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celYogu33",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguHokenSeikyuAmountNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguHokenSeikyuAmountNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu33",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C3"
                                },
                                {
                                    "fieldName": "celYogu14",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguRiyoshaFutanAmount",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "115",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblYoguRiyoshaFutanAmount",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "利用者負担額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu14",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C4"
                                },
                                {
                                    "fieldName": "celYogu15",
                                    "items": [
                                        {
                                            "fieldName": "lblYoguLimitOverAmount",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "115",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblYoguLimitOverAmount",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "限度超過額",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu15",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C5"
                                },
                                {
                                    "fieldName": "celYogu24",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguRiyoshaFutanAmountMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguRiyoshaFutanAmountMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu24",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "celYogu25",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguLimitOverAmountMae",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguLimitOverAmountMae_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu25",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "celYogu34",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguRiyoshaFutanAmountNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguRiyoshaFutanAmountNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu34",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C4"
                                },
                                {
                                    "fieldName": "celYogu35",
                                    "items": [
                                        {
                                            "fieldName": "txtYoguLimitOverAmountNow",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "80",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "txtYoguLimitOverAmountNow_core",
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
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "90",
                                            "labelRWidth": "15",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
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
                                    "selectControlID": "celYogu35",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C5"
                                }
                            ],
                            "controlType": "TablePanel",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "tblYoguSeikyuSummary",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td><td id='R1C3' bgcolor=\"#d7ebf6\"></td><td id='R1C4' bgcolor=\"#d7ebf6\"></td><td id='R1C5' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td></tr>\n  </tbody>\n</table>\n"
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
                            "wrap": true,
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
                    "marginLeft": "0",
                    "marginRight": "0",
                    "selectControlID": "SogoShokaiFukushiYoguKonyuhiInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "福祉用具購入費情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SogoShokaiFukushiYoguKonyuhiInfo"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbu/db/dbu/SogoShokaiInfo/onLoad_FukushiYoguKonyuhiInfo"
                        },
                        {
                            "eventName": "onClick_btnSelectYoguKonyuhi",
                            "requestUrl": "dbu/db/dbu/SogoShokaiInfo/onClick_btnSelectYoguKonyuhi"
                        }
                    ],
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
            "controlName": "SogoShokaiFukushiYoguKonyuhiInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return SogoShokaiFukushiYoguKonyuhiInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.SogoShokaiFukushiYoguKonyuhiInfo_Design = SogoShokaiFukushiYoguKonyuhiInfo_Design;
})(DBZ || (DBZ = {}));
