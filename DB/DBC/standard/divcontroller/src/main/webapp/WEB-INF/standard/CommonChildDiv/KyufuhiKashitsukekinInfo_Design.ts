/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyufuhiKashitsukekinInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyufuhiKashitsukekinInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinInfo.Controls.myType() + "_" + fieldName;
            }

            public KyufuhiKashitsukekinInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tabKashitsukekinInfo(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabKashitsukekinInfo"));
            }

            public tplKashitsukekinShinsei(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinShinsei"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public txtRiyoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyoKikan"));
            }

            public txtSeikyugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSeikyugaku"));
            }

            public txtShinseiKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShinseiKingaku"));
            }

            public KashitsukeShinseiService(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiService"));
            }

            public txtService1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtService1"));
            }

            public txtService2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtService2"));
            }

            public txtService3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtService3"));
            }

            public txtService4(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtService4"));
            }

            public KashitsukeShinseisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseisha"));
            }

            public txtShinseishaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            }

            public txtShinseishaKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtShinseishaKana"));
            }

            public txtShinseishaKankei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaKankei"));
            }

            public txtShinseishaYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShinseishaYubinNo"));
            }

            public txtShinseishaTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaTelNo"));
            }

            public txtShinseishaJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaJusho"));
            }

            public KashitsukeShinseiHoshonin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiHoshonin"));
            }

            public txtHoshoninName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninName"));
            }

            public txtHoshoninSeiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHoshoninSeiYMD"));
            }

            public txtHoshoninSeibetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninSeibetsu"));
            }

            public txtHoshoninKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtHoshoninKana"));
            }

            public txtHoshoninKankei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKankei"));
            }

            public txtHoshoninYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtHoshoninYubinNo"));
            }

            public txtHoshoninTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninTelNo"));
            }

            public txtHoshoninJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninJusho"));
            }

            public KashitsukeShinseiHoshoninKinmu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiHoshonin_KashitsukeShinseiHoshoninKinmu"));
            }

            public txtHoshoninKinmuName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuName"));
            }

            public txtHoshoninKinmuTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuTelNo"));
            }

            public txtHoshoninKinmuJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuJusho"));
            }

            public KashitsukeShinseiTeishutsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiTeishutsu"));
            }

            public txtSeikyuRyoshusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeikyuRyoshusho"));
            }

            public txtTeishutsuKanriNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTeishutsuKanriNo"));
            }

            public tplKashitsukekinKettei(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKettei"));
            }

            public txtKetteiShoninKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetteiShoninKubun"));
            }

            public txtKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYMD"));
            }

            public KashitsukekinKetteiShonin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin"));
            }

            public txtShoninKanriNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoninKanriNo"));
            }

            public txtKashitsukeKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKashitsukeKingaku"));
            }

            public txtKashitsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKashitsukeYMD"));
            }

            public txtHenkanHoho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkanHoho"));
            }

            public txtShokanKigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShokanKigen"));
            }

            public txtShiharaiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKubun"));
            }

            public KashitsukekinKetteiShiharai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai"));
            }

            public KashitsukekinKetteiMado(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai_KashitsukekinKetteiMado"));
            }

            public txtShiharaiBasho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            }

            public txtKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            }

            public txtKaishiH(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaishiH"));
            }

            public txtKaishiM(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaishiM"));
            }

            public txtShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShuryoYMD"));
            }

            public txtShuryoH(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuryoH"));
            }

            public txtShuryoM(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuryoM"));
            }

            public KashitsukekinKetteiKoza(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai_KashitsukekinKetteiKoza"));
            }

            public txtKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            }

            public txtKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            }

            public txtKozaShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaShubetsu"));
            }

            public txtMeigininName(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtMeigininName"));
            }

            public txtShitenCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShitenCode"));
            }

            public txtShitenName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShitenName"));
            }

            public txtKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            }

            public txtMeigininKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtMeigininKana"));
            }

            public txtKetteiFushoninRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetteiFushoninRiyu"));
            }

            public tplKashitsukekinKariuke(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKariuke"));
            }

            public txtKariukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKariukeYMD"));
            }

            public KashitsukekinKariukenin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKariukenin"));
            }

            public txtKariukeninName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeninName"));
            }

            public txtKariukeninKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKariukeninKana"));
            }

            public txtKariukeninYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtKariukeninYubinNo"));
            }

            public txtKariukeninTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeninTelNo"));
            }

            public txtKariukeninJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeninJusho"));
            }

            public KashitsukekinKariukeHosho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinKariukeHosho"));
            }

            public txtKariukeHoshoName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoName"));
            }

            public txtKariukeHoshoKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKariukeHoshoKana"));
            }

            public txtKariukeHoshoYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtKariukeHoshoYubinNo"));
            }

            public txtKariukeHoshoTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoTelNo"));
            }

            public txtKariukeHoshoJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoJusho"));
            }

            public tplKashitsukekinHenko(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinHenko"));
            }

            public txtEnchoShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtEnchoShinseiYMD"));
            }

            public txtEnchoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtEnchoKikan"));
            }

            public txtMishokanKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMishokanKingaku"));
            }

            public txtEnchoRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtEnchoRiyu"));
            }

            public KashitsukekinHenkoKariuke(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinHenkoKariuke"));
            }

            public txtHenkoKariukeninName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninName"));
            }

            public txtHenkoKariukeninKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtHenkoKariukeninKana"));
            }

            public txtHenkoKariukeninYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtHenkoKariukeninYubinNo"));
            }

            public txtHenkoKariukeninTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninTelNo"));
            }

            public txtHenkoKariukeninJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninJusho"));
            }

            public KashitsukekinHenkoKettei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KashitsukekinHenkoKettei"));
            }

            public txtHenkoShoninKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkoShoninKubun"));
            }

            public txtHenkogoKigen(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkogoKigen"));
            }

            public txtHenkoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoKetteiYMD"));
            }

            public txtHenkoFushoninRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHenkoFushoninRiyu"));
            }

            public tplKashitsukekinKoza(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKoza"));
            }

            public txtKojinKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinKinyuKikanCode"));
            }

            public txtKojinKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojinKinyuKikanName"));
            }

            public txtKojinKozaShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojinKozaShubetsu"));
            }

            public txtKojinMeigininName(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKojinMeigininName"));
            }

            public txtKojinShitenCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinShitenCode"));
            }

            public txtKojinShitenName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojinShitenName"));
            }

            public txtKojinKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinKozaNo"));
            }

            public txtKojinMeigininKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKojinMeigininKana"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

