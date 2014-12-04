/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiFukaInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiFukaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiFukaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtFukaChoteiNendo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaChoteiNendo"));
            }

            public txtFukaChoteiJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaChoteiJiyu"));
            }

            public txtFukaKoseiTsuki(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFukaKoseiTsuki"));
            }

            public txtFukaFukaNendo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaFukaNendo"));
            }

            public txtFukaKazeiKubunHonnin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunHonnin"));
            }

            public txtFukaKazeiKubunSetai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunSetai"));
            }

            public tblFuka(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblFuka"));
            }

            public celFuka11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka11"));
            }

            public celFuka12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka12"));
            }

            public lblFukaKijun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKijun"));
            }

            public celFuka21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka21"));
            }

            public lblFukaKijunYMD(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKijunYMD"));
            }

            public celFuka22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka22"));
            }

            public txtFukaKijunYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaKijunYMD"));
            }

            public celFuka31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka31"));
            }

            public celFuka32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka32"));
            }

            public lblZennendo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZennendo"));
            }

            public celFuka41(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka41"));
            }

            public lblShotokuDankai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShotokuDankai"));
            }

            public celFuka42(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka42"));
            }

            public txtShotokuDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShotokuDankai"));
            }

            public celFuka51(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka51"));
            }

            public lblHokenryoRitsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoRitsu"));
            }

            public celFuka52(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka52"));
            }

            public txtHokenryoRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenryoRitsu"));
            }

            public celFuka61(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka61"));
            }

            public lblNenHokenryo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNenHokenryo"));
            }

            public celFuka62(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka62"));
            }

            public txtNenHokenryo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNenHokenryo"));
            }

            public celFuka71(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka71"));
            }

            public lblTokubetsuSaishugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsuSaishugaku"));
            }

            public celFuka72(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka72"));
            }

            public txtTokubetsuSaishugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsuSaishugaku"));
            }

            public celFuka81(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka81"));
            }

            public lblFutsuSaishugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsuSaishugaku"));
            }

            public celFuka82(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka82"));
            }

            public txtFutsuSaishugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsuSaishugaku"));
            }

            public celFuka91(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka91"));
            }

            public celFuka92(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka92"));
            }

            public lblGenmen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenmen"));
            }

            public celFuka101(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka101"));
            }

            public lblGenmengaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenmengaku"));
            }

            public celFuka102(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka102"));
            }

            public txtGenmengaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmengaku"));
            }

            public celFuka111(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka111"));
            }

            public celFuka112(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka112"));
            }

            public lblEtc(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblEtc"));
            }

            public celFuka121(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka121"));
            }

            public lblZanteiGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZanteiGokei"));
            }

            public celFuka122(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka122"));
            }

            public txtZanteiGokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZanteiGokei"));
            }

            public celFuka131(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka131"));
            }

            public lblSudeniNofugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSudeniNofugaku"));
            }

            public celFuka132(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka132"));
            }

            public txtSudeniNofugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSudeniNofugaku"));
            }

            public celFuka141(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka141"));
            }

            public lblKongoNofugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKongoNofugaku"));
            }

            public celFuka142(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka142"));
            }

            public txtKongoNofugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKongoNofugaku"));
            }

            public celFuka151(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka151"));
            }

            public lblNofuzumigaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNofuzumigaku"));
            }

            public celFuka152(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuka152"));
            }

            public txtNofuzumigaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumigaku"));
            }

            public tblFutsuChoshu(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblFutsuChoshu"));
            }

            public celFutsuChoshu11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu11"));
            }

            public celFutsuChoshu12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu12"));
            }

            public lblFutsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu"));
            }

            public celFutsuChoshu21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu21"));
            }

            public lblFutsu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu1"));
            }

            public celFutsuChoshu22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu22"));
            }

            public txtFutsu1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu1"));
            }

            public celFutsuChoshu31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu31"));
            }

            public lblFutsu2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu2"));
            }

            public celFutsuChoshu32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu32"));
            }

            public txtFutsu2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu2"));
            }

            public celFutsuChoshu41(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu41"));
            }

            public lblFutsu3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu3"));
            }

            public celFutsuChoshu42(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu42"));
            }

            public txtFutsu3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu3"));
            }

            public celFutsuChoshu51(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu51"));
            }

            public lblFutsu4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu4"));
            }

            public celFutsuChoshu52(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu52"));
            }

            public txtFutsu4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu4"));
            }

            public celFutsuChoshu61(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu61"));
            }

            public lblFutsu5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu5"));
            }

            public celFutsuChoshu62(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu62"));
            }

            public txtFutsu5(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu5"));
            }

            public celFutsuChoshu71(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu71"));
            }

            public lblFutsu6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu6"));
            }

            public celFutsuChoshu72(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu72"));
            }

            public txtFutsu6(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu6"));
            }

            public celFutsuChoshu81(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu81"));
            }

            public lblFutsu7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu7"));
            }

            public celFutsuChoshu82(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu82"));
            }

            public txtFutsu7(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu7"));
            }

            public celFutsuChoshu91(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu91"));
            }

            public lblFutsu8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu8"));
            }

            public celFutsuChoshu92(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu92"));
            }

            public txtFutsu8(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu8"));
            }

            public celFutsuChoshu101(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu101"));
            }

            public lblFutsu9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu9"));
            }

            public celFutsuChoshu102(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu102"));
            }

            public txtFutsu9(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu9"));
            }

            public celFutsuChoshu111(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu111"));
            }

            public lblFutsu10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu10"));
            }

            public celFutsuChoshu112(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu112"));
            }

            public txtFutsu10(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu10"));
            }

            public celFutsuChoshu121(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu121"));
            }

            public lblFutsu11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu11"));
            }

            public celFutsuChoshu122(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu122"));
            }

            public txtFutsu11(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu11"));
            }

            public celFutsuChoshu131(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu131"));
            }

            public lblFutsu12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu12"));
            }

            public celFutsuChoshu132(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu132"));
            }

            public txtFutsu12(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu12"));
            }

            public celFutsuChoshu141(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu141"));
            }

            public lblFutsu13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu13"));
            }

            public celFutsuChoshu142(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu142"));
            }

            public txtFutsu13(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu13"));
            }

            public celFutsuChoshu151(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu151"));
            }

            public lblFutsu14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFutsu14"));
            }

            public celFutsuChoshu152(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu152"));
            }

            public txtFutsu14(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu14"));
            }

            public tblTokubetsuChoshu(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTokubetsuChoshu"));
            }

            public celTokubetsuChoshu11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu11"));
            }

            public celTokubetsuChoshu12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu12"));
            }

            public lblTokubetsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu"));
            }

            public celTokubetsuChoshu21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu21"));
            }

            public lblTokubetsu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu1"));
            }

            public celTokubetsuChoshu22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu22"));
            }

            public txtTokubetsu1(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu1"));
            }

            public celTokubetsuChoshu31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu31"));
            }

            public lblTokubetsu2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu2"));
            }

            public celTokubetsuChoshu32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu32"));
            }

            public txtTokubetsu2(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu2"));
            }

            public celTokubetsuChoshu41(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu41"));
            }

            public lblTokubetsu3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu3"));
            }

            public celTokubetsuChoshu42(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu42"));
            }

            public txtTokubetsu3(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu3"));
            }

            public celTokubetsuChoshu51(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu51"));
            }

            public lblTokubetsu4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu4"));
            }

            public celTokubetsuChoshu52(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu52"));
            }

            public txtTokubetsu4(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu4"));
            }

            public celTokubetsuChoshu61(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu61"));
            }

            public lblTokubetsu5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu5"));
            }

            public celTokubetsuChoshu62(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu62"));
            }

            public txtTokubetsu5(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu5"));
            }

            public celTokubetsuChoshu71(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu71"));
            }

            public lblTokubetsu6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokubetsu6"));
            }

            public celTokubetsuChoshu72(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu72"));
            }

            public txtTokubetsu6(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu6"));
            }

            public SogoShokaiFukaTokubetsuChoshu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiFukaTokubetsuChoshu"));
            }

            public txtFukaTokubetsuChoshuNenkin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuNenkin"));
            }

            public txtFukaTokubetsuChoshuGimusha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuGimusha"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

