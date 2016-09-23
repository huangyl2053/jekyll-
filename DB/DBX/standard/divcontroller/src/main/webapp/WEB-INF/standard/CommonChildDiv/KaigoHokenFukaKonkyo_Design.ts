/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module KaigoHokenFukaKonkyo {

        export class Events {

            public static onChange_ddlChoteiNendo(): string {
                return "onChange_ddlChoteiNendo";
            }

            public static onChange_ddlFukaNendo(): string {
                return "onChange_ddlFukaNendo";
            }

            public static onClick_btnSearch(): string {
                return "onClick_btnSearch";
            }

            public static onClick_btnAfter(): string {
                return "onClick_btnAfter";
            }

            public static onClick_btnBefore(): string {
                return "onClick_btnBefore";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoHokenFukaKonkyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.KaigoHokenFukaKonkyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.KaigoHokenFukaKonkyo.Controls.myType() + "_" + fieldName;
            }

            public KaigoHokenFukaKonkyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlChoteiNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChoteiNendo"));
            }

            public ddlFukaNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            }

            public ddlTsuchishoNo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTsuchishoNo"));
            }

            public btnSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearch"));
            }

            public txtHihokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            }

            public txtShikibetsuCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShikibetsuCode"));
            }

            public btnAfter(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfter"));
            }

            public btnBefore(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBefore"));
            }

            public txtRirekiNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRirekiNo"));
            }

            public tblFukaKonkyo(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblFukaKonkyo"));
            }

            public celFukaKonkyo11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo11"));
            }

            public lblFukaKijunbi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKijunbi"));
            }

            public celFukaKonkyo21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo21"));
            }

            public lblFukaKijunbiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKijunbiData"));
            }

            public celFukaKonkyo31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo31"));
            }

            public lblMaenendoHokenryoDankai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMaenendoHokenryoDankai"));
            }

            public lblHonninKazei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHonninKazei"));
            }

            public celFukaKonkyo41(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo41"));
            }

            public lblFukaKonkyoData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData1"));
            }

            public celFukaKonkyo51(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo51"));
            }

            public lblKarisanteiKeisanjoHokenryogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKarisanteiKeisanjoHokenryogaku"));
            }

            public lblKeisanjoNenkanHokenryogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKeisanjoNenkanHokenryogaku"));
            }

            public celFukaKonkyo61(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo61"));
            }

            public lblFukaKonkyoData6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData6"));
            }

            public celFukaKonkyo12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo12"));
            }

            public lblShikakuShutokubi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShikakuShutokubi"));
            }

            public celFukaKonkyo22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo22"));
            }

            public lblShikakuShutokubiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShikakuShutokubiData"));
            }

            public celFukaKonkyo32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo32"));
            }

            public lblZennendoHokenryoRitsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZennendoHokenryoRitsu"));
            }

            public lblSetaiKazei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSetaiKazei"));
            }

            public celFukaKonkyo42(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo42"));
            }

            public lblFukaKonkyoData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData2"));
            }

            public celFukaKonkyo52(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo52"));
            }

            public lblGenmengaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenmengaku"));
            }

            public celFukaKonkyo62(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo62"));
            }

            public lblFukaKonkyoData7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData7"));
            }

            public celFukaKonkyo13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo13"));
            }

            public lblSoshitsubi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSoshitsubi"));
            }

            public celFukaKonkyo23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo23"));
            }

            public lblSoshitsubiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSoshitsubiData"));
            }

            public celFukaKonkyo33(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo33"));
            }

            public lblZennendoNengakuHokenryo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZennendoNengakuHokenryo"));
            }

            public lblGokeiShotokuKingaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGokeiShotokuKingaku"));
            }

            public celFukaKonkyo43(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo43"));
            }

            public lblFukaKonkyoData3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData3"));
            }

            public celFukaKonkyo53(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo53"));
            }

            public lblKarisanteiHokenryogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKarisanteiHokenryogaku"));
            }

            public lblKakuteiNenkanHokenryogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakuteiNenkanHokenryogaku"));
            }

            public celFukaKonkyo63(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo63"));
            }

            public lblFukaKonkyoData8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData8"));
            }

            public celFukaKonkyo14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo14"));
            }

            public lblSeihoKaishibi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeihoKaishibi"));
            }

            public celFukaKonkyo24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo24"));
            }

            public lblSeihoKaishibiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeihoKaishibiData"));
            }

            public celFukaKonkyo34(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo34"));
            }

            public lblNenkinShunyugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNenkinShunyugaku"));
            }

            public celFukaKonkyo44(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo44"));
            }

            public lblFukaKonkyoData4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData4"));
            }

            public celFukaKonkyo54(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo54"));
            }

            public celFukaKonkyo64(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo64"));
            }

            public celFukaKonkyo15(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo15"));
            }

            public lblSeihoShuryobi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeihoShuryobi"));
            }

            public celFukaKonkyo25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo25"));
            }

            public lblSeihoShuryobiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSeihoShuryobiData"));
            }

            public celFukaKonkyo35(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo35"));
            }

            public lblHokenryoDankai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoDankai"));
            }

            public celFukaKonkyo45(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo45"));
            }

            public lblFukaKonkyoData5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData5"));
            }

            public celFukaKonkyo55(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo55"));
            }

            public celFukaKonkyo65(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo65"));
            }

            public celFukaKonkyo16(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo16"));
            }

            public lblronenKaishibi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblronenKaishibi"));
            }

            public celFukaKonkyo26(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo26"));
            }

            public lblronenKaishibiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblronenKaishibiData"));
            }

            public celFukaKonkyo36(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo36"));
            }

            public celFukaKonkyo46(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo46"));
            }

            public celFukaKonkyo56(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo56"));
            }

            public celFukaKonkyo66(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo66"));
            }

            public celFukaKonkyo17(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo17"));
            }

            public lblRonenShuryobi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRonenShuryobi"));
            }

            public celFukaKonkyo27(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo27"));
            }

            public lblRonenShuryobiData(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRonenShuryobiData"));
            }

            public celFukaKonkyo37(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo37"));
            }

            public celFukaKonkyo47(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo47"));
            }

            public celFukaKonkyo57(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo57"));
            }

            public celFukaKonkyo67(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo67"));
            }

            public spcKikan(): UZA.Space {
                return new UZA.Space(this.convFiledName("spcKikan"));
            }

            public tblKikan(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKikan"));
            }

            public celKikan11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan11"));
            }

            public lblKikan(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKikan"));
            }

            public celKikan21(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan21"));
            }

            public lblGessu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGessu"));
            }

            public celKikan31(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan31"));
            }

            public lblHokenryoDankaiKubun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubun"));
            }

            public celKikan41(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan41"));
            }

            public lblHokenryoritsu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoritsu"));
            }

            public celKikan51(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan51"));
            }

            public lblHokenryoSanshutsugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugaku"));
            }

            public celKikan12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan12"));
            }

            public lblKikanData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKikanData1"));
            }

            public celKikan22(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan22"));
            }

            public lblGessuData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGessuData1"));
            }

            public celKikan32(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan32"));
            }

            public lblHokenryoDankaiKubunData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubunData1"));
            }

            public celKikan42(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan42"));
            }

            public lblHokenryoritsuData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoritsuData1"));
            }

            public celKikan52(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan52"));
            }

            public lblHokenryoSanshutsugakuData1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugakuData1"));
            }

            public celKikan13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan13"));
            }

            public lblKikanData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKikanData2"));
            }

            public celKikan23(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan23"));
            }

            public lblGessuData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGessuData2"));
            }

            public celKikan33(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan33"));
            }

            public lblHokenryoDankaiKubunData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubunData2"));
            }

            public celKikan43(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan43"));
            }

            public lblHokenryoritsuData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoritsuData2"));
            }

            public celKikan53(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKikan53"));
            }

            public lblHokenryoSanshutsugakuData2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugakuData2"));
            }

            public txtChoteiJiyu1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu1"));
            }

            public txtChoteiJiyu2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu2"));
            }

            public txtChoteiJiyu3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu3"));
            }

            public txtChoteiJiyu4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu4"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

