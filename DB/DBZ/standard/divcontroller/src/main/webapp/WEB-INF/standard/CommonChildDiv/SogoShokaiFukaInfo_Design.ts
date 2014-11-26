/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module SogoShokaiFukaInfo {

        export class Events {

            public static get onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "SogoShokaiFukaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public SogoShokaiFukaInfo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtFukaChoteiNendo() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtFukaChoteiNendo"));

            }

            public txtFukaChoteiJiyu() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtFukaChoteiJiyu"));

            }

            public txtFukaKoseiTsuki() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFukaKoseiTsuki"));

            }

            public txtFukaFukaNendo() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtFukaFukaNendo"));

            }

            public txtFukaKazeiKubunHonnin() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunHonnin"));

            }

            public txtFukaKazeiKubunSetai() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunSetai"));

            }

            public tblFuka() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblFuka"));

            }

            public celFuka11() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka11"));

            }

            public celFuka12() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka12"));

            }

            public lblFukaKijun() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFukaKijun"));

            }

            public celFuka21() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka21"));

            }

            public lblFukaKijunYMD() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFukaKijunYMD"));

            }

            public celFuka22() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka22"));

            }

            public txtFukaKijunYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtFukaKijunYMD"));

            }

            public celFuka31() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka31"));

            }

            public celFuka32() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka32"));

            }

            public lblZennendo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblZennendo"));

            }

            public celFuka41() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka41"));

            }

            public lblShotokuDankai() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblShotokuDankai"));

            }

            public celFuka42() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka42"));

            }

            public txtShotokuDankai() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShotokuDankai"));

            }

            public celFuka51() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka51"));

            }

            public lblHokenryoRitsu() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblHokenryoRitsu"));

            }

            public celFuka52() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka52"));

            }

            public txtHokenryoRitsu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtHokenryoRitsu"));

            }

            public celFuka61() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka61"));

            }

            public lblNenHokenryo() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblNenHokenryo"));

            }

            public celFuka62() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka62"));

            }

            public txtNenHokenryo() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtNenHokenryo"));

            }

            public celFuka71() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka71"));

            }

            public lblTokubetsuSaishugaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsuSaishugaku"));

            }

            public celFuka72() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka72"));

            }

            public txtTokubetsuSaishugaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsuSaishugaku"));

            }

            public celFuka81() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka81"));

            }

            public lblFutsuSaishugaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsuSaishugaku"));

            }

            public celFuka82() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka82"));

            }

            public txtFutsuSaishugaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsuSaishugaku"));

            }

            public celFuka91() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka91"));

            }

            public celFuka92() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka92"));

            }

            public lblGenmen() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblGenmen"));

            }

            public celFuka101() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka101"));

            }

            public lblGenmengaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblGenmengaku"));

            }

            public celFuka102() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka102"));

            }

            public txtGenmengaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtGenmengaku"));

            }

            public celFuka111() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka111"));

            }

            public celFuka112() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka112"));

            }

            public lblEtc() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblEtc"));

            }

            public celFuka121() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka121"));

            }

            public lblZanteiGokei() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblZanteiGokei"));

            }

            public celFuka122() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka122"));

            }

            public txtZanteiGokei() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtZanteiGokei"));

            }

            public celFuka131() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka131"));

            }

            public lblSudeniNofugaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblSudeniNofugaku"));

            }

            public celFuka132() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka132"));

            }

            public txtSudeniNofugaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtSudeniNofugaku"));

            }

            public celFuka141() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka141"));

            }

            public lblKongoNofugaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblKongoNofugaku"));

            }

            public celFuka142() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka142"));

            }

            public txtKongoNofugaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKongoNofugaku"));

            }

            public celFuka151() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka151"));

            }

            public lblNofuzumigaku() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblNofuzumigaku"));

            }

            public celFuka152() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFuka152"));

            }

            public txtNofuzumigaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumigaku"));

            }

            public tblFutsuChoshu() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblFutsuChoshu"));

            }

            public celFutsuChoshu11() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu11"));

            }

            public celFutsuChoshu12() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu12"));

            }

            public lblFutsu() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu"));

            }

            public celFutsuChoshu21() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu21"));

            }

            public lblFutsu1() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu1"));

            }

            public celFutsuChoshu22() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu22"));

            }

            public txtFutsu1() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu1"));

            }

            public celFutsuChoshu31() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu31"));

            }

            public lblFutsu2() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu2"));

            }

            public celFutsuChoshu32() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu32"));

            }

            public txtFutsu2() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu2"));

            }

            public celFutsuChoshu41() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu41"));

            }

            public lblFutsu3() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu3"));

            }

            public celFutsuChoshu42() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu42"));

            }

            public txtFutsu3() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu3"));

            }

            public celFutsuChoshu51() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu51"));

            }

            public lblFutsu4() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu4"));

            }

            public celFutsuChoshu52() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu52"));

            }

            public txtFutsu4() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu4"));

            }

            public celFutsuChoshu61() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu61"));

            }

            public lblFutsu5() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu5"));

            }

            public celFutsuChoshu62() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu62"));

            }

            public txtFutsu5() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu5"));

            }

            public celFutsuChoshu71() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu71"));

            }

            public lblFutsu6() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu6"));

            }

            public celFutsuChoshu72() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu72"));

            }

            public txtFutsu6() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu6"));

            }

            public celFutsuChoshu81() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu81"));

            }

            public lblFutsu7() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu7"));

            }

            public celFutsuChoshu82() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu82"));

            }

            public txtFutsu7() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu7"));

            }

            public celFutsuChoshu91() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu91"));

            }

            public lblFutsu8() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu8"));

            }

            public celFutsuChoshu92() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu92"));

            }

            public txtFutsu8() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu8"));

            }

            public celFutsuChoshu101() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu101"));

            }

            public lblFutsu9() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu9"));

            }

            public celFutsuChoshu102() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu102"));

            }

            public txtFutsu9() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu9"));

            }

            public celFutsuChoshu111() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu111"));

            }

            public lblFutsu10() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu10"));

            }

            public celFutsuChoshu112() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu112"));

            }

            public txtFutsu10() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu10"));

            }

            public celFutsuChoshu121() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu121"));

            }

            public lblFutsu11() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu11"));

            }

            public celFutsuChoshu122() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu122"));

            }

            public txtFutsu11() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu11"));

            }

            public celFutsuChoshu131() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu131"));

            }

            public lblFutsu12() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu12"));

            }

            public celFutsuChoshu132() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu132"));

            }

            public txtFutsu12() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu12"));

            }

            public celFutsuChoshu141() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu141"));

            }

            public lblFutsu13() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu13"));

            }

            public celFutsuChoshu142() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu142"));

            }

            public txtFutsu13() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu13"));

            }

            public celFutsuChoshu151() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu151"));

            }

            public lblFutsu14() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblFutsu14"));

            }

            public celFutsuChoshu152() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celFutsuChoshu152"));

            }

            public txtFutsu14() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtFutsu14"));

            }

            public tblTokubetsuChoshu() : UZA.TablePanel {

                return new UZA.TablePanel(this.convFiledName("tblTokubetsuChoshu"));

            }

            public celTokubetsuChoshu11() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu11"));

            }

            public celTokubetsuChoshu12() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu12"));

            }

            public lblTokubetsu() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu"));

            }

            public celTokubetsuChoshu21() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu21"));

            }

            public lblTokubetsu1() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu1"));

            }

            public celTokubetsuChoshu22() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu22"));

            }

            public txtTokubetsu1() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu1"));

            }

            public celTokubetsuChoshu31() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu31"));

            }

            public lblTokubetsu2() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu2"));

            }

            public celTokubetsuChoshu32() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu32"));

            }

            public txtTokubetsu2() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu2"));

            }

            public celTokubetsuChoshu41() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu41"));

            }

            public lblTokubetsu3() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu3"));

            }

            public celTokubetsuChoshu42() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu42"));

            }

            public txtTokubetsu3() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu3"));

            }

            public celTokubetsuChoshu51() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu51"));

            }

            public lblTokubetsu4() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu4"));

            }

            public celTokubetsuChoshu52() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu52"));

            }

            public txtTokubetsu4() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu4"));

            }

            public celTokubetsuChoshu61() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu61"));

            }

            public lblTokubetsu5() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu5"));

            }

            public celTokubetsuChoshu62() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu62"));

            }

            public txtTokubetsu5() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu5"));

            }

            public celTokubetsuChoshu71() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu71"));

            }

            public lblTokubetsu6() : UZA.Label {

                return new UZA.Label(this.convFiledName("lblTokubetsu6"));

            }

            public celTokubetsuChoshu72() : UZA.TableCell {

                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu72"));

            }

            public txtTokubetsu6() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu6"));

            }

            public SogoShokaiFukaTokubetsuChoshu() : UZA.Panel {

                return new UZA.Panel(this.convFiledName("SogoShokaiFukaTokubetsuChoshu"));

            }

            public txtFukaTokubetsuChoshuNenkin() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuNenkin"));

            }

            public txtFukaTokubetsuChoshuGimusha() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuGimusha"));

            }

            public btnClose() : UZA.Button {

                return new UZA.Button(this.convFiledName("btnClose"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class SogoShokaiFukaInfo_Design extends Uz.CommonChildDiv {
    
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, SogoShokaiFukaInfo_Design.myLayout, fieldName);
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
   "fieldName": "SogoShokaiFukaInfo",
   "items": [
    {
     "fieldName": "txtFukaChoteiNendo",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "60",
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
     "selectControlID": "txtFukaChoteiNendo_core",
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
     "labelLText": "調定年度",
     "labelRText": "",
     "labelLWidth": "75",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 0,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtFukaChoteiJiyu",
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
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtFukaChoteiJiyu_core",
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
     "labelLText": "調定事由",
     "labelRText": "",
     "labelLWidth": "73",
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
     "fieldName": "txtFukaKoseiTsuki",
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
     "selectControlID": "txtFukaKoseiTsuki_core",
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
     "labelLText": "更正月",
     "labelRText": "",
     "labelLWidth": "50",
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
     "isComma": false,
     "decimalPointLength": 0
    },
    {
     "fieldName": "txtFukaFukaNendo",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "60",
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
     "selectControlID": "txtFukaFukaNendo_core",
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
     "labelLText": "賦課年度",
     "labelRText": "",
     "labelLWidth": "75",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 0,
     "displayFormat": 0,
     "value": "",
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtFukaKazeiKubunHonnin",
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
     "selectControlID": "txtFukaKazeiKubunHonnin_core",
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
     "labelLText": "市町村民税課税区分(本人)",
     "labelRText": "",
     "labelLWidth": "200",
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
     "fieldName": "txtFukaKazeiKubunSetai",
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
     "selectControlID": "txtFukaKazeiKubunSetai_core",
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
     "labelLText": "市町村民税課税区分(世帯)",
     "labelRText": "",
     "labelLWidth": "200",
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
     "fieldName": "tblFuka",
     "items": [
      {
       "fieldName": "celFuka11",
       "items": [],
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
       "selectControlID": "celFuka11",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C1"
      },
      {
       "fieldName": "celFuka12",
       "items": [
        {
         "fieldName": "lblFukaKijun",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblFukaKijun",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "賦課基準",
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
       "selectControlID": "celFuka12",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C2"
      },
      {
       "fieldName": "celFuka21",
       "items": [
        {
         "fieldName": "lblFukaKijunYMD",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblFukaKijunYMD",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "賦課基準日",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka21",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C1"
      },
      {
       "fieldName": "celFuka22",
       "items": [
        {
         "fieldName": "txtFukaKijunYMD",
         "items": [],
         "controlType": "TextBoxDate",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFukaKijunYMD_core",
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
         "ymdKubun": 2,
         "displayFormat": 0,
         "value": "",
         "permitCharactor": "./_-"
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
       "selectControlID": "celFuka22",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C2"
      },
      {
       "fieldName": "celFuka31",
       "items": [],
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
       "selectControlID": "celFuka31",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C1"
      },
      {
       "fieldName": "celFuka32",
       "items": [
        {
         "fieldName": "lblZennendo",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblZennendo",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "前年度情報",
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
       "selectControlID": "celFuka32",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C2"
      },
      {
       "fieldName": "celFuka41",
       "items": [
        {
         "fieldName": "lblShotokuDankai",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblShotokuDankai",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "所得段階",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka41",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C1"
      },
      {
       "fieldName": "celFuka42",
       "items": [
        {
         "fieldName": "txtShotokuDankai",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtShotokuDankai_core",
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
         "textAlign": 0,
         "textKind": 0,
         "isComboBox": false,
         "suggest": [],
         "decorationClass": "",
         "permitCharactor": ""
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
       "selectControlID": "celFuka42",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C2"
      },
      {
       "fieldName": "celFuka51",
       "items": [
        {
         "fieldName": "lblHokenryoRitsu",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblHokenryoRitsu",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "保険料率",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka51",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C1"
      },
      {
       "fieldName": "celFuka52",
       "items": [
        {
         "fieldName": "txtHokenryoRitsu",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtHokenryoRitsu_core",
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
       "selectControlID": "celFuka52",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C2"
      },
      {
       "fieldName": "celFuka61",
       "items": [
        {
         "fieldName": "lblNenHokenryo",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblNenHokenryo",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "年額保険料",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka61",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C1"
      },
      {
       "fieldName": "celFuka62",
       "items": [
        {
         "fieldName": "txtNenHokenryo",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtNenHokenryo_core",
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
       "selectControlID": "celFuka62",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C2"
      },
      {
       "fieldName": "celFuka71",
       "items": [
        {
         "fieldName": "lblTokubetsuSaishugaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblTokubetsuSaishugaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "最終期保険料額(特)",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka71",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C1"
      },
      {
       "fieldName": "celFuka72",
       "items": [
        {
         "fieldName": "txtTokubetsuSaishugaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsuSaishugaku_core",
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
       "selectControlID": "celFuka72",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C2"
      },
      {
       "fieldName": "celFuka81",
       "items": [
        {
         "fieldName": "lblFutsuSaishugaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblFutsuSaishugaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "最終期保険料額(普)",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka81",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R8C1"
      },
      {
       "fieldName": "celFuka82",
       "items": [
        {
         "fieldName": "txtFutsuSaishugaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsuSaishugaku_core",
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
       "selectControlID": "celFuka82",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R8C2"
      },
      {
       "fieldName": "celFuka91",
       "items": [],
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
       "selectControlID": "celFuka91",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R9C1"
      },
      {
       "fieldName": "celFuka92",
       "items": [
        {
         "fieldName": "lblGenmen",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblGenmen",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "減免",
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
       "selectControlID": "celFuka92",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R9C2"
      },
      {
       "fieldName": "celFuka101",
       "items": [
        {
         "fieldName": "lblGenmengaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblGenmengaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "減免額",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka101",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R10C1"
      },
      {
       "fieldName": "celFuka102",
       "items": [
        {
         "fieldName": "txtGenmengaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtGenmengaku_core",
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
       "selectControlID": "celFuka102",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R10C2"
      },
      {
       "fieldName": "celFuka111",
       "items": [],
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
       "selectControlID": "celFuka111",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R11C1"
      },
      {
       "fieldName": "celFuka112",
       "items": [
        {
         "fieldName": "lblEtc",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblEtc",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "その他",
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
       "selectControlID": "celFuka112",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R11C2"
      },
      {
       "fieldName": "celFuka121",
       "items": [
        {
         "fieldName": "lblZanteiGokei",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblZanteiGokei",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "暫定保険料額合計",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka121",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R12C1"
      },
      {
       "fieldName": "celFuka122",
       "items": [
        {
         "fieldName": "txtZanteiGokei",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtZanteiGokei_core",
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
       "selectControlID": "celFuka122",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R12C2"
      },
      {
       "fieldName": "celFuka131",
       "items": [
        {
         "fieldName": "lblSudeniNofugaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblSudeniNofugaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "既に納付すべき額",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka131",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R13C1"
      },
      {
       "fieldName": "celFuka132",
       "items": [
        {
         "fieldName": "txtSudeniNofugaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtSudeniNofugaku_core",
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
       "selectControlID": "celFuka132",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R13C2"
      },
      {
       "fieldName": "celFuka141",
       "items": [
        {
         "fieldName": "lblKongoNofugaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblKongoNofugaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "今後納付すべき額",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka141",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R14C1"
      },
      {
       "fieldName": "celFuka142",
       "items": [
        {
         "fieldName": "txtKongoNofugaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtKongoNofugaku_core",
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
       "selectControlID": "celFuka142",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R14C2"
      },
      {
       "fieldName": "celFuka151",
       "items": [
        {
         "fieldName": "lblNofuzumigaku",
         "items": [],
         "controlType": "Label",
         "width": "160",
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
         "selectControlID": "lblNofuzumigaku",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "未到来期の納付済額",
         "decorationClass": "",
         "align": 0
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
       "selectControlID": "celFuka151",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R15C1"
      },
      {
       "fieldName": "celFuka152",
       "items": [
        {
         "fieldName": "txtNofuzumigaku",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtNofuzumigaku_core",
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
       "selectControlID": "celFuka152",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R15C2"
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
     "marginLeft": "S",
     "marginRight": "XS",
     "selectControlID": "tblFuka",
     "helpMessageID": "",
     "jpControlName": "",
     "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n    <tr><td id='R8C1' bgcolor=\"#d7ebf6\"></td><td id='R8C2'></td></tr>\n    <tr><td id='R9C1' bgcolor=\"#d7ebf6\"></td><td id='R9C2'></td></tr>\n    <tr><td id='R10C1' bgcolor=\"#d7ebf6\"></td><td id='R10C2'></td></tr>\n    <tr><td id='R11C1' bgcolor=\"#d7ebf6\"></td><td id='R11C2'></td></tr>\n    <tr><td id='R12C1' bgcolor=\"#d7ebf6\"></td><td id='R12C2'></td></tr>\n    <tr><td id='R13C1' bgcolor=\"#d7ebf6\"></td><td id='R13C2'></td></tr>\n    <tr><td id='R14C1' bgcolor=\"#d7ebf6\"></td><td id='R14C2'></td></tr>\n    <tr><td id='R15C1' bgcolor=\"#d7ebf6\"></td><td id='R15C2'></td></tr>\n  </tbody>\n</table>"
    },
    {
     "fieldName": "tblFutsuChoshu",
     "items": [
      {
       "fieldName": "celFutsuChoshu11",
       "items": [],
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
       "selectControlID": "celFutsuChoshu11",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C1"
      },
      {
       "fieldName": "celFutsuChoshu12",
       "items": [
        {
         "fieldName": "lblFutsu",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblFutsu",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "普徴",
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
       "selectControlID": "celFutsuChoshu12",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C2"
      },
      {
       "fieldName": "celFutsuChoshu21",
       "items": [
        {
         "fieldName": "lblFutsu1",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu1",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１期",
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
       "selectControlID": "celFutsuChoshu21",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C1"
      },
      {
       "fieldName": "celFutsuChoshu22",
       "items": [
        {
         "fieldName": "txtFutsu1",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu1_core",
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
       "selectControlID": "celFutsuChoshu22",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C2"
      },
      {
       "fieldName": "celFutsuChoshu31",
       "items": [
        {
         "fieldName": "lblFutsu2",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu2",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "２期",
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
       "selectControlID": "celFutsuChoshu31",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C1"
      },
      {
       "fieldName": "celFutsuChoshu32",
       "items": [
        {
         "fieldName": "txtFutsu2",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu2_core",
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
       "selectControlID": "celFutsuChoshu32",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C2"
      },
      {
       "fieldName": "celFutsuChoshu41",
       "items": [
        {
         "fieldName": "lblFutsu3",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu3",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "３期",
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
       "selectControlID": "celFutsuChoshu41",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C1"
      },
      {
       "fieldName": "celFutsuChoshu42",
       "items": [
        {
         "fieldName": "txtFutsu3",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu3_core",
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
       "selectControlID": "celFutsuChoshu42",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C2"
      },
      {
       "fieldName": "celFutsuChoshu51",
       "items": [
        {
         "fieldName": "lblFutsu4",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu4",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "４期",
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
       "selectControlID": "celFutsuChoshu51",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C1"
      },
      {
       "fieldName": "celFutsuChoshu52",
       "items": [
        {
         "fieldName": "txtFutsu4",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu4_core",
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
       "selectControlID": "celFutsuChoshu52",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C2"
      },
      {
       "fieldName": "celFutsuChoshu61",
       "items": [
        {
         "fieldName": "lblFutsu5",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu5",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "５期",
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
       "selectControlID": "celFutsuChoshu61",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C1"
      },
      {
       "fieldName": "celFutsuChoshu62",
       "items": [
        {
         "fieldName": "txtFutsu5",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu5_core",
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
       "selectControlID": "celFutsuChoshu62",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C2"
      },
      {
       "fieldName": "celFutsuChoshu71",
       "items": [
        {
         "fieldName": "lblFutsu6",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu6",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "６期",
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
       "selectControlID": "celFutsuChoshu71",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C1"
      },
      {
       "fieldName": "celFutsuChoshu72",
       "items": [
        {
         "fieldName": "txtFutsu6",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu6_core",
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
       "selectControlID": "celFutsuChoshu72",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C2"
      },
      {
       "fieldName": "celFutsuChoshu81",
       "items": [
        {
         "fieldName": "lblFutsu7",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu7",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "７期",
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
       "selectControlID": "celFutsuChoshu81",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R8C1"
      },
      {
       "fieldName": "celFutsuChoshu82",
       "items": [
        {
         "fieldName": "txtFutsu7",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu7_core",
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
       "selectControlID": "celFutsuChoshu82",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R8C2"
      },
      {
       "fieldName": "celFutsuChoshu91",
       "items": [
        {
         "fieldName": "lblFutsu8",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu8",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "８期",
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
       "selectControlID": "celFutsuChoshu91",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R9C1"
      },
      {
       "fieldName": "celFutsuChoshu92",
       "items": [
        {
         "fieldName": "txtFutsu8",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu8_core",
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
       "selectControlID": "celFutsuChoshu92",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R9C2"
      },
      {
       "fieldName": "celFutsuChoshu101",
       "items": [
        {
         "fieldName": "lblFutsu9",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu9",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "９期",
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
       "selectControlID": "celFutsuChoshu101",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R10C1"
      },
      {
       "fieldName": "celFutsuChoshu102",
       "items": [
        {
         "fieldName": "txtFutsu9",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu9_core",
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
         "labelLWidth": "0",
         "labelRWidth": "0",
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
       "selectControlID": "celFutsuChoshu102",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R10C2"
      },
      {
       "fieldName": "celFutsuChoshu111",
       "items": [
        {
         "fieldName": "lblFutsu10",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu10",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１０期",
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
       "selectControlID": "celFutsuChoshu111",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R11C1"
      },
      {
       "fieldName": "celFutsuChoshu112",
       "items": [
        {
         "fieldName": "txtFutsu10",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu10_core",
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
         "labelLWidth": "0",
         "labelRWidth": "0",
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
       "selectControlID": "celFutsuChoshu112",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R11C2"
      },
      {
       "fieldName": "celFutsuChoshu121",
       "items": [
        {
         "fieldName": "lblFutsu11",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu11",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１１期",
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
       "selectControlID": "celFutsuChoshu121",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R12C1"
      },
      {
       "fieldName": "celFutsuChoshu122",
       "items": [
        {
         "fieldName": "txtFutsu11",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu11_core",
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
       "selectControlID": "celFutsuChoshu122",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R12C2"
      },
      {
       "fieldName": "celFutsuChoshu131",
       "items": [
        {
         "fieldName": "lblFutsu12",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu12",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１２期",
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
       "selectControlID": "celFutsuChoshu131",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R13C1"
      },
      {
       "fieldName": "celFutsuChoshu132",
       "items": [
        {
         "fieldName": "txtFutsu12",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu12_core",
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
       "selectControlID": "celFutsuChoshu132",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R13C2"
      },
      {
       "fieldName": "celFutsuChoshu141",
       "items": [
        {
         "fieldName": "lblFutsu13",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu13",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１３期",
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
       "selectControlID": "celFutsuChoshu141",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R14C1"
      },
      {
       "fieldName": "celFutsuChoshu142",
       "items": [
        {
         "fieldName": "txtFutsu13",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu13_core",
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
       "selectControlID": "celFutsuChoshu142",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R14C2"
      },
      {
       "fieldName": "celFutsuChoshu151",
       "items": [
        {
         "fieldName": "lblFutsu14",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblFutsu14",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１４期",
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
       "selectControlID": "celFutsuChoshu151",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R15C1"
      },
      {
       "fieldName": "celFutsuChoshu152",
       "items": [
        {
         "fieldName": "txtFutsu14",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtFutsu14_core",
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
       "selectControlID": "celFutsuChoshu152",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R15C2"
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
     "selectControlID": "tblFutsuChoshu",
     "helpMessageID": "",
     "jpControlName": "",
     "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n    <tr><td id='R8C1' bgcolor=\"#d7ebf6\"></td><td id='R8C2'></td></tr>\n    <tr><td id='R9C1' bgcolor=\"#d7ebf6\"></td><td id='R9C2'></td></tr>\n    <tr><td id='R10C1' bgcolor=\"#d7ebf6\"></td><td id='R10C2'></td></tr>\n    <tr><td id='R11C1' bgcolor=\"#d7ebf6\"></td><td id='R11C2'></td></tr>\n    <tr><td id='R12C1' bgcolor=\"#d7ebf6\"></td><td id='R12C2'></td></tr>\n    <tr><td id='R13C1' bgcolor=\"#d7ebf6\"></td><td id='R13C2'></td></tr>\n    <tr><td id='R14C1' bgcolor=\"#d7ebf6\"></td><td id='R14C2'></td></tr>\n    <tr><td id='R15C1' bgcolor=\"#d7ebf6\"></td><td id='R15C2'></td></tr>\n  </tbody>\n</table>"
    },
    {
     "fieldName": "tblTokubetsuChoshu",
     "items": [
      {
       "fieldName": "celTokubetsuChoshu11",
       "items": [],
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
       "selectControlID": "celTokubetsuChoshu11",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C1"
      },
      {
       "fieldName": "celTokubetsuChoshu12",
       "items": [
        {
         "fieldName": "lblTokubetsu",
         "items": [],
         "controlType": "Label",
         "width": "100",
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
         "selectControlID": "lblTokubetsu",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "特徴",
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
       "selectControlID": "celTokubetsuChoshu12",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R1C2"
      },
      {
       "fieldName": "celTokubetsuChoshu21",
       "items": [
        {
         "fieldName": "lblTokubetsu1",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu1",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "１期",
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
       "selectControlID": "celTokubetsuChoshu21",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C1"
      },
      {
       "fieldName": "celTokubetsuChoshu22",
       "items": [
        {
         "fieldName": "txtTokubetsu1",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu1_core",
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
       "selectControlID": "celTokubetsuChoshu22",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R2C2"
      },
      {
       "fieldName": "celTokubetsuChoshu31",
       "items": [
        {
         "fieldName": "lblTokubetsu2",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu2",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "２期",
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
       "selectControlID": "celTokubetsuChoshu31",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C1"
      },
      {
       "fieldName": "celTokubetsuChoshu32",
       "items": [
        {
         "fieldName": "txtTokubetsu2",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu2_core",
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
       "selectControlID": "celTokubetsuChoshu32",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R3C2"
      },
      {
       "fieldName": "celTokubetsuChoshu41",
       "items": [
        {
         "fieldName": "lblTokubetsu3",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu3",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "３期",
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
       "selectControlID": "celTokubetsuChoshu41",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C1"
      },
      {
       "fieldName": "celTokubetsuChoshu42",
       "items": [
        {
         "fieldName": "txtTokubetsu3",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu3_core",
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
       "selectControlID": "celTokubetsuChoshu42",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R4C2"
      },
      {
       "fieldName": "celTokubetsuChoshu51",
       "items": [
        {
         "fieldName": "lblTokubetsu4",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu4",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "４期",
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
       "selectControlID": "celTokubetsuChoshu51",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C1"
      },
      {
       "fieldName": "celTokubetsuChoshu52",
       "items": [
        {
         "fieldName": "txtTokubetsu4",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu4_core",
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
       "selectControlID": "celTokubetsuChoshu52",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R5C2"
      },
      {
       "fieldName": "celTokubetsuChoshu61",
       "items": [
        {
         "fieldName": "lblTokubetsu5",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu5",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "５期",
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
       "selectControlID": "celTokubetsuChoshu61",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C1"
      },
      {
       "fieldName": "celTokubetsuChoshu62",
       "items": [
        {
         "fieldName": "txtTokubetsu5",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu5_core",
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
       "selectControlID": "celTokubetsuChoshu62",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R6C2"
      },
      {
       "fieldName": "celTokubetsuChoshu71",
       "items": [
        {
         "fieldName": "lblTokubetsu6",
         "items": [],
         "controlType": "Label",
         "width": "60",
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
         "selectControlID": "lblTokubetsu6",
         "helpMessageID": "",
         "jpControlName": "",
         "required": false,
         "isPrivateInfo": false,
         "text": "６期",
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
       "selectControlID": "celTokubetsuChoshu71",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C1"
      },
      {
       "fieldName": "celTokubetsuChoshu72",
       "items": [
        {
         "fieldName": "txtTokubetsu6",
         "items": [],
         "controlType": "TextBoxNum",
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
         "marginLeft": "0",
         "marginRight": "0",
         "selectControlID": "txtTokubetsu6_core",
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
       "selectControlID": "celTokubetsuChoshu72",
       "helpMessageID": "",
       "jpControlName": "",
       "connectTd": "R7C2"
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
     "selectControlID": "tblTokubetsuChoshu",
     "helpMessageID": "",
     "jpControlName": "",
     "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n  </tbody>\n</table>"
    },
    {
     "fieldName": "SogoShokaiFukaTokubetsuChoshu",
     "items": [
      {
       "fieldName": "txtFukaTokubetsuChoshuNenkin",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "txtFukaTokubetsuChoshuNenkin_core",
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
       "labelLText": "対象年金",
       "labelRText": "",
       "labelLWidth": "65",
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
       "fieldName": "txtFukaTokubetsuChoshuGimusha",
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
       "marginLeft": "XS",
       "marginRight": "XS",
       "selectControlID": "txtFukaTokubetsuChoshuGimusha_core",
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
       "labelLText": "義務者",
       "labelRText": "",
       "labelLWidth": "50",
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
     "width": "G2",
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
     "selectControlID": "SogoShokaiFukaTokubetsuChoshu",
     "helpMessageID": "",
     "jpControlName": "",
     "onLoad": "",
     "title": "特別徴収",
     "marginTop": "Default",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": false,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SogoShokaiFukaTokubetsuChoshu"
      }
     ],
     "requestSettings": [],
     "hiddenInput": [],
     "onOpen": "",
     "onClose": "",
     "session": {},
     "eraseBorder": false,
     "backgroundColor": 0,
     "widthAuto": true,
     "panelDisplay": 1,
     "isGroupBox": false,
     "readOnly": false,
     "height": "Auto"
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
   "selectControlID": "SogoShokaiFukaInfo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "賦課情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "SogoShokaiFukaInfo"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": "dbu/db/dbu/SogoShokaiInfo/onLoad_FukaInfo"
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
 "controlName": "SogoShokaiFukaInfo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": "onClick_btnClose",
 "canTransferEvent": true,
 "heightForDialog": "Auto"
}        
    }
}

