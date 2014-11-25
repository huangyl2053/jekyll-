var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IchijiHanteiKekkaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "IchijiHanteiKekkaInfo";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.IchijiHanteiKekkaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIchijiHanteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteibi"));
            };

            Controls.prototype.txtIchijiHanteiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            };

            Controls.prototype.txtKijunJikan = function () {
                return new UZA.TextBox(this.convFiledName("txtKijunJikan"));
            };

            Controls.prototype.lblChukanHyokaKomokuTokuten = function () {
                return new UZA.Label(this.convFiledName("lblChukanHyokaKomokuTokuten"));
            };

            Controls.prototype.tblKijunJikan = function () {
                return new UZA.TablePanel(this.convFiledName("tblKijunJikan"));
            };

            Controls.prototype.celShokujiHeader = function () {
                return new UZA.TableCell(this.convFiledName("celShokujiHeader"));
            };

            Controls.prototype.lblShokuji = function () {
                return new UZA.Label(this.convFiledName("lblShokuji"));
            };

            Controls.prototype.celHaisetsuHeader = function () {
                return new UZA.TableCell(this.convFiledName("celHaisetsuHeader"));
            };

            Controls.prototype.lblHaisetsu = function () {
                return new UZA.Label(this.convFiledName("lblHaisetsu"));
            };

            Controls.prototype.celShokuji = function () {
                return new UZA.TableCell(this.convFiledName("celShokuji"));
            };

            Controls.prototype.txtShokuji = function () {
                return new UZA.TextBox(this.convFiledName("txtShokuji"));
            };

            Controls.prototype.celHaisetsu = function () {
                return new UZA.TableCell(this.convFiledName("celHaisetsu"));
            };

            Controls.prototype.txtHaisetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtHaisetsu"));
            };

            Controls.prototype.celIdoHeader = function () {
                return new UZA.TableCell(this.convFiledName("celIdoHeader"));
            };

            Controls.prototype.lblIdo = function () {
                return new UZA.Label(this.convFiledName("lblIdo"));
            };

            Controls.prototype.celSeiketsuHojiHeader = function () {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHojiHeader"));
            };

            Controls.prototype.lblSeiketsuhoji = function () {
                return new UZA.Label(this.convFiledName("lblSeiketsuhoji"));
            };

            Controls.prototype.celKansetsuCareHeader = function () {
                return new UZA.TableCell(this.convFiledName("celKansetsuCareHeader"));
            };

            Controls.prototype.lblKansetsuCare = function () {
                return new UZA.Label(this.convFiledName("lblKansetsuCare"));
            };

            Controls.prototype.celBpsdKanrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celBpsdKanrenHeader"));
            };

            Controls.prototype.lblBpsdKanren = function () {
                return new UZA.Label(this.convFiledName("lblBpsdKanren"));
            };

            Controls.prototype.celKinoKunrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celKinoKunrenHeader"));
            };

            Controls.prototype.lblKinoKunren = function () {
                return new UZA.Label(this.convFiledName("lblKinoKunren"));
            };

            Controls.prototype.celIryoKanrenHeader = function () {
                return new UZA.TableCell(this.convFiledName("celIryoKanrenHeader"));
            };

            Controls.prototype.lblIryoKanren = function () {
                return new UZA.Label(this.convFiledName("lblIryoKanren"));
            };

            Controls.prototype.celNinchishoKasanHeader = function () {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasanHeader"));
            };

            Controls.prototype.lblNinchishoKasan = function () {
                return new UZA.Label(this.convFiledName("lblNinchishoKasan"));
            };

            Controls.prototype.celIdo = function () {
                return new UZA.TableCell(this.convFiledName("celIdo"));
            };

            Controls.prototype.txtIdo = function () {
                return new UZA.TextBox(this.convFiledName("txtIdo"));
            };

            Controls.prototype.celSeiketsuHoji = function () {
                return new UZA.TableCell(this.convFiledName("celSeiketsuHoji"));
            };

            Controls.prototype.txtSeiketsuHoji = function () {
                return new UZA.TextBox(this.convFiledName("txtSeiketsuHoji"));
            };

            Controls.prototype.celKansetsuCare = function () {
                return new UZA.TableCell(this.convFiledName("celKansetsuCare"));
            };

            Controls.prototype.txtKansetsuCare = function () {
                return new UZA.TextBox(this.convFiledName("txtKansetsuCare"));
            };

            Controls.prototype.celBpsdKanren = function () {
                return new UZA.TableCell(this.convFiledName("celBpsdKanren"));
            };

            Controls.prototype.txtBpsdKanren = function () {
                return new UZA.TextBox(this.convFiledName("txtBpsdKanren"));
            };

            Controls.prototype.celKinoKunren = function () {
                return new UZA.TableCell(this.convFiledName("celKinoKunren"));
            };

            Controls.prototype.txtKinoKunren = function () {
                return new UZA.TextBox(this.convFiledName("txtKinoKunren"));
            };

            Controls.prototype.celIryoKanren = function () {
                return new UZA.TableCell(this.convFiledName("celIryoKanren"));
            };

            Controls.prototype.txtIryoKanren = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKanren"));
            };

            Controls.prototype.celNinchishoKasan = function () {
                return new UZA.TableCell(this.convFiledName("celNinchishoKasan"));
            };

            Controls.prototype.txtNinchishoKasan = function () {
                return new UZA.TextBox(this.convFiledName("txtNinchishoKasan"));
            };

            Controls.prototype.tblTyukanHyokaKomokuTokuten = function () {
                return new UZA.TablePanel(this.convFiledName("tblTyukanHyokaKomokuTokuten"));
            };

            Controls.prototype.celDai1gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai1gunHeader"));
            };

            Controls.prototype.lblDai1gun = function () {
                return new UZA.Label(this.convFiledName("lblDai1gun"));
            };

            Controls.prototype.celDai2gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai2gunHeader"));
            };

            Controls.prototype.lblDai2gun = function () {
                return new UZA.Label(this.convFiledName("lblDai2gun"));
            };

            Controls.prototype.celDai1gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai1gun"));
            };

            Controls.prototype.txtDai1gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai1gun"));
            };

            Controls.prototype.celDai2gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai2gun"));
            };

            Controls.prototype.txtDai2gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai2gun"));
            };

            Controls.prototype.celDai3gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai3gunHeader"));
            };

            Controls.prototype.lblDai3gun = function () {
                return new UZA.Label(this.convFiledName("lblDai3gun"));
            };

            Controls.prototype.celDai4gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai4gunHeader"));
            };

            Controls.prototype.lblDai4gun = function () {
                return new UZA.Label(this.convFiledName("lblDai4gun"));
            };

            Controls.prototype.celDai5gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai5gunHeader"));
            };

            Controls.prototype.lblDai5gun = function () {
                return new UZA.Label(this.convFiledName("lblDai5gun"));
            };

            Controls.prototype.celDai6gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai6gunHeader"));
            };

            Controls.prototype.lblDai6gun = function () {
                return new UZA.Label(this.convFiledName("lblDai6gun"));
            };

            Controls.prototype.celDai7gunHeader = function () {
                return new UZA.TableCell(this.convFiledName("celDai7gunHeader"));
            };

            Controls.prototype.lblDai7gun = function () {
                return new UZA.Label(this.convFiledName("lblDai7gun"));
            };

            Controls.prototype.celDai3gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai3gun"));
            };

            Controls.prototype.txtDai3gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai3gun"));
            };

            Controls.prototype.celDai4gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai4gun"));
            };

            Controls.prototype.txtDai4gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai4gun"));
            };

            Controls.prototype.celDai5gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai5gun"));
            };

            Controls.prototype.txtDai5gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai5gun"));
            };

            Controls.prototype.celDai6gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai6gun"));
            };

            Controls.prototype.txtDai6gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai6gun"));
            };

            Controls.prototype.celDai7gun = function () {
                return new UZA.TableCell(this.convFiledName("celDai7gun"));
            };

            Controls.prototype.txtDai7gun = function () {
                return new UZA.TextBox(this.convFiledName("txtDai7gun"));
            };

            Controls.prototype.lblNichiJyotaiHyokaKekka = function () {
                return new UZA.Label(this.convFiledName("lblNichiJyotaiHyokaKekka"));
            };

            Controls.prototype.lblNinchiNichijyoSeikatsuJiritsudo = function () {
                return new UZA.Label(this.convFiledName("lblNinchiNichijyoSeikatsuJiritsudo"));
            };

            Controls.prototype.txtGaizensei = function () {
                return new UZA.TextBox(this.convFiledName("txtGaizensei"));
            };

            Controls.prototype.txtJiritsudoChosa = function () {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoChosa"));
            };

            Controls.prototype.txtJyotaiAnteisei = function () {
                return new UZA.TextBox(this.convFiledName("txtJyotaiAnteisei"));
            };

            Controls.prototype.txtJiritsudoIkensho = function () {
                return new UZA.TextBox(this.convFiledName("txtJiritsudoIkensho"));
            };

            Controls.prototype.txtKyufuKbn = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuKbn"));
            };

            Controls.prototype.lblIchijiHanteiKeikokuCode = function () {
                return new UZA.Label(this.convFiledName("lblIchijiHanteiKeikokuCode"));
            };

            Controls.prototype.dgIchijiHanteiKeikokuCode = function () {
                return new UZA.DataGrid(this.convFiledName("dgIchijiHanteiKeikokuCode"));
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        IchijiHanteiKekkaInfo.Controls = Controls;
    })(DBE.IchijiHanteiKekkaInfo || (DBE.IchijiHanteiKekkaInfo = {}));
    var IchijiHanteiKekkaInfo = DBE.IchijiHanteiKekkaInfo;

    var IchijiHanteiKekkaInfo_Design = (function (_super) {
        __extends(IchijiHanteiKekkaInfo_Design, _super);
        function IchijiHanteiKekkaInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, IchijiHanteiKekkaInfo_Design.myLayout, fieldName);
        }
        IchijiHanteiKekkaInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        IchijiHanteiKekkaInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        IchijiHanteiKekkaInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "IchijiHanteiKekkaInfo",
                    "items": [
                        {
                            "fieldName": "txtIchijiHanteibi",
                            "items": [],
                            "controlType": "TextBoxFlexibleDate",
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
                            "selectControlID": "txtIchijiHanteibi_core",
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
                            "labelLText": "一次判定日",
                            "labelRText": "",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 2,
                            "displayFormat": 0,
                            "value": ""
                        },
                        {
                            "fieldName": "txtIchijiHanteiKekka",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "140",
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
                            "selectControlID": "txtIchijiHanteiKekka_core",
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
                            "labelLText": "一次判定結果",
                            "labelRText": "",
                            "labelLWidth": "S",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtKijunJikan",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "150",
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
                            "selectControlID": "txtKijunJikan_core",
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
                            "labelLText": "基準時間",
                            "labelRText": "分",
                            "labelLWidth": "80",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "lblChukanHyokaKomokuTokuten",
                            "items": [],
                            "controlType": "Label",
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
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "lblChukanHyokaKomokuTokuten",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "中間評価項目得点",
                            "decorationClass": "",
                            "align": 2
                        },
                        {
                            "fieldName": "tblKijunJikan",
                            "items": [
                                {
                                    "fieldName": "celShokujiHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblShokuji",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblShokuji",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "食事<br><br>",
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
                                    "selectControlID": "celShokujiHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celHaisetsuHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblHaisetsu",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblHaisetsu",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "排泄<br><br>",
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
                                    "selectControlID": "celHaisetsuHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celShokuji",
                                    "items": [
                                        {
                                            "fieldName": "txtShokuji",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtShokuji_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celShokuji",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celHaisetsu",
                                    "items": [
                                        {
                                            "fieldName": "txtHaisetsu",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtHaisetsu_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celHaisetsu",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celIdoHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblIdo",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblIdo",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "移動<br><br>",
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
                                    "selectControlID": "celIdoHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C3"
                                },
                                {
                                    "fieldName": "celSeiketsuHojiHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblSeiketsuhoji",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblSeiketsuhoji",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "清潔<br>保持",
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
                                    "selectControlID": "celSeiketsuHojiHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C4"
                                },
                                {
                                    "fieldName": "celKansetsuCareHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblKansetsuCare",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblKansetsuCare",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "関節<br>ケア",
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
                                    "selectControlID": "celKansetsuCareHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C5"
                                },
                                {
                                    "fieldName": "celBpsdKanrenHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblBpsdKanren",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblBpsdKanren",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "BPSD<br>関連",
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
                                    "selectControlID": "celBpsdKanrenHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C6"
                                },
                                {
                                    "fieldName": "celKinoKunrenHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblKinoKunren",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblKinoKunren",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "機能<br>訓練",
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
                                    "selectControlID": "celKinoKunrenHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C7"
                                },
                                {
                                    "fieldName": "celIryoKanrenHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblIryoKanren",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblIryoKanren",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "医療<br>関連",
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
                                    "selectControlID": "celIryoKanrenHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C8"
                                },
                                {
                                    "fieldName": "celNinchishoKasanHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblNinchishoKasan",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "50",
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
                                            "selectControlID": "lblNinchishoKasan",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "認知症<br>加算",
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
                                    "selectControlID": "celNinchishoKasanHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C9"
                                },
                                {
                                    "fieldName": "celIdo",
                                    "items": [
                                        {
                                            "fieldName": "txtIdo",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtIdo_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celIdo",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "celSeiketsuHoji",
                                    "items": [
                                        {
                                            "fieldName": "txtSeiketsuHoji",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtSeiketsuHoji_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celSeiketsuHoji",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "celKansetsuCare",
                                    "items": [
                                        {
                                            "fieldName": "txtKansetsuCare",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtKansetsuCare_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celKansetsuCare",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "celBpsdKanren",
                                    "items": [
                                        {
                                            "fieldName": "txtBpsdKanren",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtBpsdKanren_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celBpsdKanren",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C6"
                                },
                                {
                                    "fieldName": "celKinoKunren",
                                    "items": [
                                        {
                                            "fieldName": "txtKinoKunren",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtKinoKunren_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celKinoKunren",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C7"
                                },
                                {
                                    "fieldName": "celIryoKanren",
                                    "items": [
                                        {
                                            "fieldName": "txtIryoKanren",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtIryoKanren_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celIryoKanren",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C8"
                                },
                                {
                                    "fieldName": "celNinchishoKasan",
                                    "items": [
                                        {
                                            "fieldName": "txtNinchishoKasan",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtNinchishoKasan_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celNinchishoKasan",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C9"
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
                            "marginLeft": "2",
                            "marginRight": "XS",
                            "selectControlID": "tblKijunJikan",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td><td id='R1C6'></td><td id='R1C7'></td><td id='R1C8'></td><td id='R1C9'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td><td id='R2C7'></td><td id='R2C8'></td><td id='R2C9'></td></tr>\n  </tbody>\n</table>\n"
                        },
                        {
                            "fieldName": "tblTyukanHyokaKomokuTokuten",
                            "items": [
                                {
                                    "fieldName": "celDai1gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai1gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblDai1gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第１群<br><br>",
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
                                    "selectControlID": "celDai1gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celDai2gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai2gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblDai2gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第２群<br><br>",
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
                                    "selectControlID": "celDai2gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celDai1gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai1gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtDai1gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai1gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celDai2gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai2gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtDai2gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai2gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celDai3gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai3gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblDai3gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第３群<br><br>",
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
                                    "selectControlID": "celDai3gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C3"
                                },
                                {
                                    "fieldName": "celDai4gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai4gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblDai4gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第４群<br><br>",
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
                                    "selectControlID": "celDai4gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C4"
                                },
                                {
                                    "fieldName": "celDai5gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai5gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
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
                                            "selectControlID": "lblDai5gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第５群<br><br>",
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
                                    "selectControlID": "celDai5gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C5"
                                },
                                {
                                    "fieldName": "celDai6gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai6gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
                                            "visible": false,
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
                                            "selectControlID": "lblDai6gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第６群<br><br>",
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
                                    "selectControlID": "celDai6gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C6"
                                },
                                {
                                    "fieldName": "celDai7gunHeader",
                                    "items": [
                                        {
                                            "fieldName": "lblDai7gun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "48",
                                            "visible": false,
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
                                            "selectControlID": "lblDai7gun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "第７群<br><br>",
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
                                    "selectControlID": "celDai7gunHeader",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C7"
                                },
                                {
                                    "fieldName": "celDai3gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai3gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtDai3gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai3gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C3"
                                },
                                {
                                    "fieldName": "celDai4gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai4gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtDai4gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai4gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C4"
                                },
                                {
                                    "fieldName": "celDai5gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai5gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
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
                                            "selectControlID": "txtDai5gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai5gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C5"
                                },
                                {
                                    "fieldName": "celDai6gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai6gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
                                            "visible": false,
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
                                            "selectControlID": "txtDai6gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai6gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C6"
                                },
                                {
                                    "fieldName": "celDai7gun",
                                    "items": [
                                        {
                                            "fieldName": "txtDai7gun",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "48",
                                            "visible": false,
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
                                            "selectControlID": "txtDai7gun_core",
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
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 1,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": ""
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
                                    "selectControlID": "celDai7gun",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C7"
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
                            "selectControlID": "tblTyukanHyokaKomokuTokuten",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table>\n  <tbody>\n    <tr><td id='R1C1'></td><td id='R1C2'></td><td id='R1C3'></td><td id='R1C4'></td><td id='R1C5'></td><td id='R1C6'></td><td id='R1C7'></td></tr>\n    <tr><td id='R2C1'></td><td id='R2C2'></td><td id='R2C3'></td><td id='R2C4'></td><td id='R2C5'></td><td id='R2C6'></td><td id='R2C7'></td></tr>\n  </tbody>\n</table>\n"
                        },
                        {
                            "fieldName": "lblNichiJyotaiHyokaKekka",
                            "items": [],
                            "controlType": "Label",
                            "width": "258",
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
                            "selectControlID": "lblNichiJyotaiHyokaKekka",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "認知機能・状態の安定性の評価結果",
                            "decorationClass": "",
                            "align": 2
                        },
                        {
                            "fieldName": "lblNinchiNichijyoSeikatsuJiritsudo",
                            "items": [],
                            "controlType": "Label",
                            "width": "225",
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
                            "selectControlID": "lblNinchiNichijyoSeikatsuJiritsudo",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "認知症高齢者の日常生活自立度",
                            "decorationClass": "",
                            "align": 2
                        },
                        {
                            "fieldName": "txtGaizensei",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "70",
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
                            "selectControlID": "txtGaizensei_core",
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
                            "labelLText": "認知症自立度Ⅱ以上の蓋然性",
                            "labelRText": "％",
                            "labelLWidth": "235",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJiritsudoChosa",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "40",
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
                            "selectControlID": "txtJiritsudoChosa_core",
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
                            "labelLText": "認定調査結果",
                            "labelRText": "",
                            "labelLWidth": "123",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJyotaiAnteisei",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "70",
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
                            "selectControlID": "txtJyotaiAnteisei_core",
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
                            "labelLText": "状態の安定性",
                            "labelRText": "",
                            "labelLWidth": "290",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtJiritsudoIkensho",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "40",
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
                            "selectControlID": "txtJiritsudoIkensho_core",
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
                            "labelLText": "主治医意見書",
                            "labelRText": "",
                            "labelLWidth": "123",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "txtKyufuKbn",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "70",
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
                            "selectControlID": "txtKyufuKbn_core",
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
                            "labelLText": "給付区分",
                            "labelRText": "",
                            "labelLWidth": "290",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 1,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": ""
                        },
                        {
                            "fieldName": "lblIchijiHanteiKeikokuCode",
                            "items": [],
                            "controlType": "Label",
                            "width": "165",
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
                            "marginLeft": "2",
                            "marginRight": "XS",
                            "selectControlID": "lblIchijiHanteiKeikokuCode",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "required": false,
                            "isPrivateInfo": false,
                            "text": "一次判定警告コード",
                            "decorationClass": "",
                            "align": 0
                        },
                        {
                            "fieldName": "dgIchijiHanteiKeikokuCode",
                            "items": [],
                            "controlType": "DataGrid",
                            "width": "930",
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
                            "marginLeft": "2",
                            "marginRight": "XS",
                            "selectControlID": "dgIchijiHanteiKeikokuCode",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": false,
                            "height": "130",
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
                                        "columnName": "No",
                                        "dataName": "no",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 45,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "no"
                                    },
                                    {
                                        "columnName": "コード",
                                        "dataName": "code",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 60,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": {
                                            "cellType": 0
                                        },
                                        "align": 1,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "code"
                                    },
                                    {
                                        "columnName": "説明",
                                        "dataName": "setsumei",
                                        "toolTip": "",
                                        "bgColor": 0,
                                        "width": 808,
                                        "visible": true,
                                        "cellType": 0,
                                        "cellDetails": null,
                                        "align": 0,
                                        "resize": true,
                                        "isPrivateInfo": false,
                                        "sortKey": "setsumei"
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
                            "sortOrder": "setsumei",
                            "isAscending": true,
                            "filterList": [],
                            "activeRowId": -1
                        }
                    ],
                    "controlType": "Panel",
                    "width": "975",
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
                    "selectControlID": "IchijiHanteiKekkaInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "一次判定結果確認",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "IchijiHanteiKekkaInfo"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbe/db/dbe/IchijiHanteiKekkaInfo/onLoad"
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
                    "height": "410"
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
            "businessId": "DBE",
            "controlName": "IchijiHanteiKekkaInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "",
            "canTransferEvent": true,
            "heightForDialog": "450"
        };
        return IchijiHanteiKekkaInfo_Design;
    })(Uz.CommonChildDiv);
    DBE.IchijiHanteiKekkaInfo_Design = IchijiHanteiKekkaInfo_Design;
})(DBE || (DBE = {}));
