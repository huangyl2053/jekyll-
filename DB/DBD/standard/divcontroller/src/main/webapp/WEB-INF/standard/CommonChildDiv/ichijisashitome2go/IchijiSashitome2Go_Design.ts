/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module IchijiSashitome2Go {

        export class Events {

            public static onClick_BtnKakutei(): string {
                return "onClick_BtnKakutei";
            }

            public static onClick_BtnTorikeshi(): string {
                return "onClick_BtnTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IchijiSashitome2Go";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.IchijiSashitome2Go.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.IchijiSashitome2Go.Controls.myType() + "_" + fieldName;
            }

            public IchijiSashitome2Go(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TorokuJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TorokuJokyo"));
            }

            public txtTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            }

            public txtTekiyoKaishi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoKaishi"));
            }

            public txtTekiyoShuryo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoShuryo"));
            }

            public ddlShuryoJokyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShuryoJokyo"));
            }

            public linTorokuTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuTorokuJokyo"));
            }

            public txtNigoYokokushaTorokuYokokuTorokubi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNigoYokokushaTorokuYokokuTorokubi"));
            }

            public txtBemmeishoTeishutsuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBemmeishoTeishutsuKigenYMD"));
            }

            public txtYokokuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokokuTsuchiHakkoYMD"));
            }

            public txtNigoBenmeishoJuriBenmeishoUketsukebi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNigoBenmeishoJuriBenmeishoUketsukebi"));
            }

            public ddlNigoBenmeishoJuriBenmeiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiRiyu"));
            }

            public txtBemmeiNaiyoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBemmeiNaiyoKetteiYMD"));
            }

            public ddlNigoBenmeishoJuriBenmeiShinsakekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiShinsakekka"));
            }

            public txtSashitomeKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSashitomeKetteiYMD"));
            }

            public txtHokenshaTeishutsuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHokenshaTeishutsuKigenYMD"));
            }

            public txtSashitomeTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTsuchiHakkoYMD"));
            }

            public txtIraiUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiUketsukeYMD"));
            }

            public ddlIraiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIraiRiyu"));
            }

            public txtNigoYokokushaTorokuIraiJuribi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNigoYokokushaTorokuIraiJuribi"));
            }

            public txtIraiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiYMD"));
            }

            public txtIraiNaiyoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiNaiyoKetteiYMD"));
            }

            public ddlIraiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIraiShinsaKekka"));
            }

            public KakuteiTorikeshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KakuteiTorikeshi"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

