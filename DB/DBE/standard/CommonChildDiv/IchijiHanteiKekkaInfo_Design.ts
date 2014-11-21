/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module IchijiHanteiKekkaInfo {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "IchijiHanteiKekkaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public IchijiHanteiKekkaInfo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtIchijiHanteibi() : UZA.TextBoxFlexibleDate {

                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchijiHanteibi"));

            }

            public txtIchijiHanteiKekka() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));

            }

            public txtKijunJikan() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKijunJikan"));

            }

            public lblChukanHyokaKomokuTokuten() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblChukanHyokaKomokuTokuten"));

            }

            public tblKijunJikan() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblKijunJikan"));

            }

            public celShokujiHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celShokujiHeader"));

            }

            public lblShokuji() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblShokuji"));

            }

            public celHaisetsuHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celHaisetsuHeader"));

            }

            public lblHaisetsu() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHaisetsu"));

            }

            public celShokuji() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celShokuji"));

            }

            public txtShokuji() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShokuji"));

            }

            public celHaisetsu() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celHaisetsu"));

            }

            public txtHaisetsu() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtHaisetsu"));

            }

            public celIdoHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celIdoHeader"));

            }

            public lblIdo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblIdo"));

            }

            public celSeiketsuHojiHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celSeiketsuHojiHeader"));

            }

            public lblSeiketsuhoji() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSeiketsuhoji"));

            }

            public celKansetsuCareHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celKansetsuCareHeader"));

            }

            public lblKansetsuCare() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKansetsuCare"));

            }

            public celBpsdKanrenHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celBpsdKanrenHeader"));

            }

            public lblBpsdKanren() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblBpsdKanren"));

            }

            public celKinoKunrenHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celKinoKunrenHeader"));

            }

            public lblKinoKunren() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKinoKunren"));

            }

            public celIryoKanrenHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celIryoKanrenHeader"));

            }

            public lblIryoKanren() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblIryoKanren"));

            }

            public celNinchishoKasanHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celNinchishoKasanHeader"));

            }

            public lblNinchishoKasan() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblNinchishoKasan"));

            }

            public celIdo() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celIdo"));

            }

            public txtIdo() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtIdo"));

            }

            public celSeiketsuHoji() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celSeiketsuHoji"));

            }

            public txtSeiketsuHoji() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtSeiketsuHoji"));

            }

            public celKansetsuCare() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celKansetsuCare"));

            }

            public txtKansetsuCare() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKansetsuCare"));

            }

            public celBpsdKanren() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celBpsdKanren"));

            }

            public txtBpsdKanren() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtBpsdKanren"));

            }

            public celKinoKunren() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celKinoKunren"));

            }

            public txtKinoKunren() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKinoKunren"));

            }

            public celIryoKanren() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celIryoKanren"));

            }

            public txtIryoKanren() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtIryoKanren"));

            }

            public celNinchishoKasan() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celNinchishoKasan"));

            }

            public txtNinchishoKasan() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtNinchishoKasan"));

            }

            public tblTyukanHyokaKomokuTokuten() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblTyukanHyokaKomokuTokuten"));

            }

            public celDai1gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai1gunHeader"));

            }

            public lblDai1gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai1gun"));

            }

            public celDai2gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai2gunHeader"));

            }

            public lblDai2gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai2gun"));

            }

            public celDai1gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai1gun"));

            }

            public txtDai1gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai1gun"));

            }

            public celDai2gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai2gun"));

            }

            public txtDai2gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai2gun"));

            }

            public celDai3gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai3gunHeader"));

            }

            public lblDai3gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai3gun"));

            }

            public celDai4gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai4gunHeader"));

            }

            public lblDai4gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai4gun"));

            }

            public celDai5gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai5gunHeader"));

            }

            public lblDai5gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai5gun"));

            }

            public celDai6gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai6gunHeader"));

            }

            public lblDai6gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai6gun"));

            }

            public celDai7gunHeader() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai7gunHeader"));

            }

            public lblDai7gun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblDai7gun"));

            }

            public celDai3gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai3gun"));

            }

            public txtDai3gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai3gun"));

            }

            public celDai4gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai4gun"));

            }

            public txtDai4gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai4gun"));

            }

            public celDai5gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai5gun"));

            }

            public txtDai5gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai5gun"));

            }

            public celDai6gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai6gun"));

            }

            public txtDai6gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai6gun"));

            }

            public celDai7gun() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celDai7gun"));

            }

            public txtDai7gun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtDai7gun"));

            }

            public lblNichiJyotaiHyokaKekka() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblNichiJyotaiHyokaKekka"));

            }

            public lblNinchiNichijyoSeikatsuJiritsudo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblNinchiNichijyoSeikatsuJiritsudo"));

            }

            public txtGaizensei() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtGaizensei"));

            }

            public txtJiritsudoChosa() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJiritsudoChosa"));

            }

            public txtJyotaiAnteisei() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJyotaiAnteisei"));

            }

            public txtJiritsudoIkensho() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtJiritsudoIkensho"));

            }

            public txtKyufuKbn() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKyufuKbn"));

            }

            public lblIchijiHanteiKeikokuCode() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblIchijiHanteiKeikokuCode"));

            }

            public dgIchijiHanteiKeikokuCode() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgIchijiHanteiKeikokuCode"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class IchijiHanteiKekkaInfo_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, IchijiHanteiKekkaInfo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            
            return editablePropertyInfo;
        }
        public static myLayout = {
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
}        
    }
}

