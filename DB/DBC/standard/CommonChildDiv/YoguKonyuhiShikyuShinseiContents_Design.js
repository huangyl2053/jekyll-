var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiContents) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnReflect", {
                get: function () {
                    return "onClick_btnReflect";
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Events, "onClick_btnAddSeikyuDetail", {
                get: function () {
                    return "onClick_btnAddSeikyuDetail";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        YoguKonyuhiShikyuShinseiContents.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "YoguKonyuhiShikyuShinseiContents";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.YoguKonyuhiShikyuShinseiContents = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikyoYM"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtKyufuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            };

            Controls.prototype.btnInputDetail = function () {
                return new UZA.Button(this.convFiledName("btnInputDetail"));
            };

            Controls.prototype.dgSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetailInput = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.ddlShumoku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShumoku"));
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

            Controls.prototype.radShinsaMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radShinsaMethod"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnAddSeikyuDetail = function () {
                return new UZA.Button(this.convFiledName("btnAddSeikyuDetail"));
            };

            Controls.prototype.SeikyuSummary = function () {
                return new UZA.Panel(this.convFiledName("SeikyuSummary"));
            };

            Controls.prototype.tblSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            };

            Controls.prototype.cel11 = function () {
                return new UZA.TableCell(this.convFiledName("cel11"));
            };

            Controls.prototype.lblSummary = function () {
                return new UZA.Label(this.convFiledName("lblSummary"));
            };

            Controls.prototype.cel12 = function () {
                return new UZA.TableCell(this.convFiledName("cel12"));
            };

            Controls.prototype.lblPayTotal = function () {
                return new UZA.Label(this.convFiledName("lblPayTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenSeikyuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenSeikyuAmount"));
            };

            Controls.prototype.cel21 = function () {
                return new UZA.TableCell(this.convFiledName("cel21"));
            };

            Controls.prototype.lblSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            };

            Controls.prototype.cel22 = function () {
                return new UZA.TableCell(this.convFiledName("cel22"));
            };

            Controls.prototype.txtPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalMae"));
            };

            Controls.prototype.cel23 = function () {
                return new UZA.TableCell(this.convFiledName("cel23"));
            };

            Controls.prototype.txtHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountMae"));
            };

            Controls.prototype.cel31 = function () {
                return new UZA.TableCell(this.convFiledName("cel31"));
            };

            Controls.prototype.lblSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            };

            Controls.prototype.cel32 = function () {
                return new UZA.TableCell(this.convFiledName("cel32"));
            };

            Controls.prototype.txtPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalNow"));
            };

            Controls.prototype.cel33 = function () {
                return new UZA.TableCell(this.convFiledName("cel33"));
            };

            Controls.prototype.txtHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountNow"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblLimitOverAmount = function () {
                return new UZA.Label(this.convFiledName("lblLimitOverAmount"));
            };

            Controls.prototype.cel24 = function () {
                return new UZA.TableCell(this.convFiledName("cel24"));
            };

            Controls.prototype.txtRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            };

            Controls.prototype.cel25 = function () {
                return new UZA.TableCell(this.convFiledName("cel25"));
            };

            Controls.prototype.txtLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountMae"));
            };

            Controls.prototype.cel34 = function () {
                return new UZA.TableCell(this.convFiledName("cel34"));
            };

            Controls.prototype.txtRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            };

            Controls.prototype.cel35 = function () {
                return new UZA.TableCell(this.convFiledName("cel35"));
            };

            Controls.prototype.txtLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountNow"));
            };

            Controls.prototype.cel36 = function () {
                return new UZA.TableCell(this.convFiledName("cel36"));
            };

            Controls.prototype.btnLimitOverCheck = function () {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseishaJoho = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseisha = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseisha"));
            };

            Controls.prototype.radShinseishaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiPaymentMethod = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod"));
            };

            Controls.prototype.radPayMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod"));
            };

            Controls.prototype.URKoza = function () {
                return new UZA.Panel(this.convFiledName("URKoza"));
            };

            Controls.prototype.txtKari1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari1"));
            };

            Controls.prototype.DBZJuryoinin = function () {
                return new UZA.Panel(this.convFiledName("DBZJuryoinin"));
            };

            Controls.prototype.txtKari2 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari2"));
            };

            Controls.prototype.btnUpdateShikyuShinsei = function () {
                return new UZA.Button(this.convFiledName("btnUpdateShikyuShinsei"));
            };

            Controls.prototype.btnCancelShikyuShinsei = function () {
                return new UZA.Button(this.convFiledName("btnCancelShikyuShinsei"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        YoguKonyuhiShikyuShinseiContents.Controls = Controls;
    })(DBC.YoguKonyuhiShikyuShinseiContents || (DBC.YoguKonyuhiShikyuShinseiContents = {}));
    var YoguKonyuhiShikyuShinseiContents = DBC.YoguKonyuhiShikyuShinseiContents;

    var YoguKonyuhiShikyuShinseiContents_Design = (function (_super) {
        __extends(YoguKonyuhiShikyuShinseiContents_Design, _super);
        function YoguKonyuhiShikyuShinseiContents_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, YoguKonyuhiShikyuShinseiContents_Design.myLayout, fieldName);
        }
        Object.defineProperty(YoguKonyuhiShikyuShinseiContents_Design.prototype, "AddSeikyuDetailOnclick", {
            get: function () {
                return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"])["onClick"];
            },
            set: function (value) {
                if ($("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]).length > 0 && Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]) != undefined) {
                    Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"])["onClick"] = value;
                } else {
                    this.layout.items[0].items[3].items[2].items[9]["onClick"] = value;
                    this.raisePropertyChanged(this.layout);
                }
            },
            enumerable: true,
            configurable: true
        });


        YoguKonyuhiShikyuShinseiContents_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
            Uz.JSControlUtil.registProperty("AddSeikyuDetailOnclick");
        };

        YoguKonyuhiShikyuShinseiContents_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);
            editablePropertyInfo["AddSeikyuDetailOnclick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[3]["fieldName"] + "_" + this.layout.items[0].items[3].items[2]["fieldName"] + "_" + this.layout.items[0].items[3].items[2].items[9]["fieldName"]).getEditablePropertyInfo()["onClick"];

            return editablePropertyInfo;
        };
        YoguKonyuhiShikyuShinseiContents_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "YoguKonyuhiShikyuShinseiContents",
                    "items": [
                        {
                            "fieldName": "txtKeikyoYM",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "55",
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
                            "readOnly": true,
                            "placeHolder": "平26.06",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "提供年月",
                            "labelRText": "",
                            "labelLWidth": "60",
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
                            "controlType": "TextBox",
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
                            "readOnly": true,
                            "placeHolder": "",
                            "textKind": 0,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "整理番号",
                            "labelRText": "",
                            "labelLWidth": "60",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtKyufuRitsu",
                            "items": [],
                            "controlType": "TextBoxNum",
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
                            "required": false,
                            "readOnly": false,
                            "placeHolder": "90",
                            "textKind": 2,
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "給付率",
                            "labelRText": "％",
                            "labelLWidth": "45",
                            "labelRWidth": "15",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 1000000000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "maxValue": 1.7976931348623157e+308,
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0,
                            "permitCharactor": "+-,.\\"
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetail",
                            "items": [
                                {
                                    "fieldName": "btnInputDetail",
                                    "items": [],
                                    "controlType": "Button",
                                    "width": "M",
                                    "visible": false,
                                    "displayNone": true,
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
                                    "text": "明細を入力する",
                                    "onClick": "",
                                    "appearance": 0,
                                    "imageFileUrl": "",
                                    "imageWidth": "",
                                    "imageHeight": ""
                                },
                                {
                                    "fieldName": "dgSeikyuDetail",
                                    "items": [],
                                    "controlType": "DataGrid",
                                    "width": "760",
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
                                            "headerHeight": 0
                                        },
                                        "columns": [
                                            {
                                                "columnName": "修正",
                                                "dataName": "btnModify",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 50,
                                                "visible": true,
                                                "cellType": 8,
                                                "cellDetails": {
                                                    "cellType": 8,
                                                    "text": "修正",
                                                    "onClick": "onClick_dgMeisai_modify",
                                                    "imageFileUrl": "/uz/uza/css/Link.jpg",
                                                    "imageWidth": "",
                                                    "imageHeight": ""
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "btnModify"
                                            },
                                            {
                                                "columnName": "削除",
                                                "dataName": "btnDelete",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 50,
                                                "visible": true,
                                                "cellType": 8,
                                                "cellDetails": {
                                                    "cellType": 8,
                                                    "text": "...",
                                                    "onClick": "onClick_dgMeisai_delete",
                                                    "imageFileUrl": "/uz/uza/css/Link.jpg",
                                                    "imageWidth": "",
                                                    "imageHeight": ""
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "btnDelete"
                                            },
                                            {
                                                "columnName": "状態",
                                                "dataName": "txtRowState",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 50,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "15",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": ""
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "txtRowState"
                                            },
                                            {
                                                "columnName": "購入日",
                                                "dataName": "txtBuyYMD",
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
                                                "sortKey": "txtBuyYMD"
                                            },
                                            {
                                                "columnName": "種目",
                                                "dataName": "txtShumoku",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 120,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "1000000000000",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": ""
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
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "15",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": ""
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
                                                "sortKey": "txtBuyAmount"
                                            },
                                            {
                                                "columnName": "審査方法",
                                                "dataName": "txtShinsaMethod",
                                                "toolTip": "",
                                                "bgColor": 0,
                                                "width": 100,
                                                "visible": true,
                                                "cellType": 1,
                                                "cellDetails": {
                                                    "cellType": 1,
                                                    "maxLength": "1000000000000",
                                                    "minLength": "0",
                                                    "textAlign": 0,
                                                    "onChange": ""
                                                },
                                                "align": 0,
                                                "resize": true,
                                                "isPrivateInfo": false,
                                                "sortKey": "txtShinsaMethod"
                                            }
                                        ]
                                    },
                                    "height": "155",
                                    "onSort": "",
                                    "onSelect": "",
                                    "onSelectByDblClick": "",
                                    "onOnlyRow": "",
                                    "onNoRow": "",
                                    "onMultiRows": "",
                                    "dataSource": [],
                                    "sortOrder": "txtShinsaMethod",
                                    "isAscending": true,
                                    "filterList": [],
                                    "activeRowId": -1
                                },
                                {
                                    "fieldName": "YoguKonyuhiShikyuShinseiSeikyuDetailInput",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "平26.6.15",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "購入日",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "permitCharactor": "./_-"
                                        },
                                        {
                                            "fieldName": "ddlShumoku",
                                            "items": [],
                                            "controlType": "DropDownList",
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
                                            "required": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "labelLText": "種目",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "dataSource": [
                                                {
                                                    "key": "code01",
                                                    "value": "01:腰掛便座"
                                                },
                                                {
                                                    "key": "code02",
                                                    "value": "02:特殊尿器"
                                                },
                                                {
                                                    "key": "code03",
                                                    "value": "03:入浴補助用具"
                                                },
                                                {
                                                    "key": "code04",
                                                    "value": "04:簡易浴槽"
                                                },
                                                {
                                                    "key": "code05",
                                                    "value": "05:移動用リフトのつり具の部分"
                                                },
                                                {
                                                    "key": "code06",
                                                    "value": "06:自動排泄処理装置の交換可能部品"
                                                }
                                            ],
                                            "selectedItem": ""
                                        },
                                        {
                                            "fieldName": "txtShohinName",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "340",
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
                                            "readOnly": false,
                                            "placeHolder": "１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "商品名",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "製造事業者",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "販売事業者",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "購入金額",
                                            "labelRText": "円",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": false,
                                            "decimalPointLength": 0,
                                            "permitCharactor": "+-,.\\"
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "品目コード",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "radShinsaMethod",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "L",
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
                                            "onChange": "",
                                            "labelLText": "審査方法",
                                            "labelLWidth": "75",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "dataSource": [
                                                {
                                                    "key": "judgeRequest",
                                                    "value": "審査依頼"
                                                },
                                                {
                                                    "key": "judgeDone",
                                                    "value": "審査済み"
                                                }
                                            ],
                                            "selectedItem": "judgeDone",
                                            "newLineItemNumber": 2,
                                            "spaceSize": 1
                                        },
                                        {
                                            "fieldName": "btnClear",
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
                                            "text": "入力内容をクリアする",
                                            "onClick": "",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        },
                                        {
                                            "fieldName": "btnAddSeikyuDetail",
                                            "items": [],
                                            "controlType": "Button",
                                            "width": "M",
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
                                            "text": "明細を追加する",
                                            "onClick": "onClick_btnAddSeikyuDetail",
                                            "appearance": 0,
                                            "imageFileUrl": "",
                                            "imageWidth": "",
                                            "imageHeight": ""
                                        }
                                    ],
                                    "controlType": "Panel",
                                    "width": "450",
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
                                    "marginLeft": "0.2",
                                    "marginRight": "0",
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetailInput"
                                        }
                                    ],
                                    "requestSettings": [
                                        {
                                            "eventName": "onLoad",
                                            "requestUrl": ""
                                        },
                                        {
                                            "eventName": "onClick_btnAdd",
                                            "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
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
                                    "isGroupBox": false
                                },
                                {
                                    "fieldName": "SeikyuSummary",
                                    "items": [
                                        {
                                            "fieldName": "tblSeikyuSummary",
                                            "items": [
                                                {
                                                    "fieldName": "cel11",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblSummary",
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
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "集計",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R1C1"
                                                },
                                                {
                                                    "fieldName": "cel12",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblPayTotal",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "90",
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
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "支払金額合計",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R1C2"
                                                },
                                                {
                                                    "fieldName": "cel13",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblHokenSeikyuAmount",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "75",
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
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "保険請求額",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R1C3"
                                                },
                                                {
                                                    "fieldName": "cel21",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblSummaryMae",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "135",
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
                                                            "isPrivateInfo": false,
                                                            "text": "前回までの支払結果",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R2C1"
                                                },
                                                {
                                                    "fieldName": "cel22",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtPayTotalMae",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "0",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R2C2"
                                                },
                                                {
                                                    "fieldName": "cel23",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtHokenSeikyuAmountMae",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "0",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R2C3"
                                                },
                                                {
                                                    "fieldName": "cel31",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblSummaryNow",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "135",
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
                                                            "isPrivateInfo": false,
                                                            "text": "今回の支払状況",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C1"
                                                },
                                                {
                                                    "fieldName": "cel32",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtPayTotalNow",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "123456789",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C2"
                                                },
                                                {
                                                    "fieldName": "cel33",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtHokenSeikyuAmountNow",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "123456789",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C3"
                                                },
                                                {
                                                    "fieldName": "cel14",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblRiyoshaFutanAmount",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "90",
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
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "利用者負担額",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R1C4"
                                                },
                                                {
                                                    "fieldName": "cel15",
                                                    "items": [
                                                        {
                                                            "fieldName": "lblLimitOverAmount",
                                                            "items": [],
                                                            "controlType": "Label",
                                                            "width": "75",
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
                                                            "required": false,
                                                            "isPrivateInfo": false,
                                                            "text": "限度超過額",
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R1C5"
                                                },
                                                {
                                                    "fieldName": "cel24",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtRiyoshaFutanAmountMae",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "0",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R2C4"
                                                },
                                                {
                                                    "fieldName": "cel25",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtLimitOverAmountMae",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "0",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R2C5"
                                                },
                                                {
                                                    "fieldName": "cel34",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtRiyoshaFutanAmountNow",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "123456789",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C4"
                                                },
                                                {
                                                    "fieldName": "cel35",
                                                    "items": [
                                                        {
                                                            "fieldName": "txtLimitOverAmountNow",
                                                            "items": [],
                                                            "controlType": "TextBoxNum",
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
                                                            "placeHolder": "123456789",
                                                            "textKind": 2,
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
                                                            "maxLength": 1000000000000,
                                                            "minLength": 0,
                                                            "textAlign": 2,
                                                            "isComboBox": false,
                                                            "suggest": [],
                                                            "maxValue": 1.7976931348623157e+308,
                                                            "minValue": 0,
                                                            "isCurrency": false,
                                                            "isComma": true,
                                                            "decimalPointLength": 0,
                                                            "permitCharactor": "+-,.\\"
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C5"
                                                },
                                                {
                                                    "fieldName": "cel36",
                                                    "items": [
                                                        {
                                                            "fieldName": "btnLimitOverCheck",
                                                            "items": [],
                                                            "controlType": "Button",
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
                                                            "text": "限度額をチェックする",
                                                            "onClick": "",
                                                            "appearance": 0,
                                                            "imageFileUrl": "",
                                                            "imageWidth": "",
                                                            "imageHeight": ""
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
                                                    "marginLeft": 0,
                                                    "marginRight": 0,
                                                    "connectTd": "R3C6"
                                                }
                                            ],
                                            "controlType": "TablePanel",
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
                                            "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td></tr>\n    <tr><td id='R3C1'></td><td id='R3C2'></td><td id='R3C3'></td><td id='R3C4'></td><td id='R3C5'></td><td id='R3C6'></td></tr>\n  </tbody>\n</table>\n"
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "SeikyuSummary"
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
                                    "widthAuto": true,
                                    "isGroupBox": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1225",
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
                            "title": "請求明細",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "YoguKonyuhiShikyuShinseiSeikyuDetail"
                                }
                            ],
                            "requestSettings": [
                                {
                                    "eventName": "onLoad",
                                    "requestUrl": ""
                                },
                                {
                                    "eventName": "onClick_btnAddSeikyuDetail",
                                    "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiSeikyuDetail/onClick_btnAddSeikyuDetail"
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
                            "isGroupBox": true
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseishaJoho",
                            "items": [
                                {
                                    "fieldName": "txtShinseiYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "75",
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
                                    "labelLText": "申請日",
                                    "labelRText": "",
                                    "labelLWidth": "75",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "txtUketsukeYMD",
                                    "items": [],
                                    "controlType": "TextBoxDate",
                                    "width": "75",
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
                                    "labelLText": "受付日",
                                    "labelRText": "",
                                    "labelLWidth": "45",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "ymdKubun": 2,
                                    "displayFormat": 0,
                                    "value": "",
                                    "permitCharactor": "./_-"
                                },
                                {
                                    "fieldName": "YoguKonyuhiShikyuShinseisha",
                                    "items": [
                                        {
                                            "fieldName": "radShinseishaKubun",
                                            "items": [],
                                            "controlType": "RadioButton",
                                            "width": "500",
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
                                            "labelLText": "区分",
                                            "labelLWidth": "75",
                                            "labelLAlign": 2,
                                            "onClick": "",
                                            "dataSource": [
                                                {
                                                    "key": "myself",
                                                    "value": "本人"
                                                },
                                                {
                                                    "key": "family",
                                                    "value": "家族"
                                                },
                                                {
                                                    "key": "serviceJigyosha",
                                                    "value": "サービス事業者"
                                                },
                                                {
                                                    "key": "other",
                                                    "value": "その他"
                                                }
                                            ],
                                            "selectedItem": "family",
                                            "newLineItemNumber": 4,
                                            "spaceSize": 1
                                        },
                                        {
                                            "fieldName": "txtShinseishaName",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "氏名",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtYubinNo",
                                            "items": [],
                                            "controlType": "TextBoxYubinNo",
                                            "width": "S",
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
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 2,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "住所",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtAddress",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "700",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtTelNo",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "120",
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
                                            "readOnly": false,
                                            "placeHolder": "00000000000",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "電話番号",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        },
                                        {
                                            "fieldName": "txtJigyoshaNo",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "1234567890",
                                            "textKind": 2,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "事業者番号",
                                            "labelRText": "",
                                            "labelLWidth": "75",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": "",
                                            "formatLength": 1
                                        },
                                        {
                                            "fieldName": "btnSearchJigyosha",
                                            "items": [],
                                            "controlType": "Button",
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
                                            "marginRight": "XS",
                                            "text": "Button1",
                                            "onClick": "",
                                            "appearance": 1,
                                            "imageFileUrl": "/uz/uza/css/Link.jpg",
                                            "imageWidth": "18",
                                            "imageHeight": "20"
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "onLoad": "",
                                    "title": "",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseisha"
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
                                    "widthAuto": true,
                                    "isGroupBox": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1220",
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
                            "title": "申請者情報",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "YoguKonyuhiShikyuShinseishaJoho"
                                }
                            ],
                            "requestSettings": [
                                {
                                    "eventName": "onLoad",
                                    "requestUrl": ""
                                },
                                {
                                    "eventName": "onClick_btnAdd",
                                    "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
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
                            "isGroupBox": true
                        },
                        {
                            "fieldName": "YoguKonyuhiShikyuShinseiPaymentMethod",
                            "items": [
                                {
                                    "fieldName": "radPayMethod",
                                    "items": [],
                                    "controlType": "RadioButton",
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
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "required": false,
                                    "onChange": "",
                                    "labelLText": "",
                                    "labelLWidth": "60",
                                    "labelLAlign": 2,
                                    "onClick": "",
                                    "dataSource": [
                                        {
                                            "key": "payToKoza",
                                            "value": "口座払い"
                                        },
                                        {
                                            "key": "payToJuryoinin",
                                            "value": "受領委任払い"
                                        },
                                        {
                                            "key": "payToMadoguchi",
                                            "value": "窓口払い"
                                        }
                                    ],
                                    "selectedItem": "payToKoza",
                                    "newLineItemNumber": 3,
                                    "spaceSize": 1
                                },
                                {
                                    "fieldName": "URKoza",
                                    "items": [
                                        {
                                            "fieldName": "txtKari1",
                                            "items": [],
                                            "controlType": "TextBox",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "onLoad": "",
                                    "title": "口座払い（UR共有子Div）",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "DBZJuryoinin"
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
                                    "widthAuto": true,
                                    "isGroupBox": false
                                },
                                {
                                    "fieldName": "DBZJuryoinin",
                                    "items": [
                                        {
                                            "fieldName": "txtKari2",
                                            "items": [],
                                            "controlType": "TextBox",
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
                                            "required": false,
                                            "readOnly": false,
                                            "placeHolder": "",
                                            "textKind": 0,
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 1000000000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "permitCharactor": ""
                                        }
                                    ],
                                    "controlType": "Panel",
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
                                    "onLoad": "",
                                    "title": "受領委任払い（DBZ共有子Div）",
                                    "marginTop": "Default",
                                    "marginBottom": "Default",
                                    "isOpen": true,
                                    "canOpenAndClose": true,
                                    "postParameterPanelNames": [
                                        {
                                            "postParameterPanelNames": "DBZJuryoinin"
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
                                    "widthAuto": true,
                                    "isGroupBox": false
                                }
                            ],
                            "controlType": "Panel",
                            "width": "1220",
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
                            "title": "支払方法",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "YoguKonyuhiShikyuShinseiPaymentMethod"
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
                            "fieldName": "btnUpdateShikyuShinsei",
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
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "text": "申請を追加する",
                            "onClick": "onClick_btnReflect",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        },
                        {
                            "fieldName": "btnCancelShikyuShinsei",
                            "items": [],
                            "controlType": "Button",
                            "width": "M",
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
                            "text": "申請の追加をやめる",
                            "onClick": "onClick_btnReflect",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": ""
                        }
                    ],
                    "controlType": "Panel",
                    "width": "1235",
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
                    "title": "支給申請内容",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "YoguKonyuhiShikyuShinseiContents"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": ""
                        },
                        {
                            "eventName": "onClick_btnAdd",
                            "requestUrl": "dbc/db/dbc/YoguKonyuhiShikyuShinseiContents/onClick_btnAdd"
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
            "controlName": "YoguKonyuhiShikyuShinseiContents",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [
                {
                    "publicChildFieldName": "btnAddSeikyuDetail",
                    "publicChildProperty": "onClick",
                    "newPropertyName": "AddSeikyuDetailOnclick"
                }
            ],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": ""
        };
        return YoguKonyuhiShikyuShinseiContents_Design;
    })(Uz.CommonChildDiv);
    DBC.YoguKonyuhiShikyuShinseiContents_Design = YoguKonyuhiShikyuShinseiContents_Design;
})(DBC || (DBC = {}));
