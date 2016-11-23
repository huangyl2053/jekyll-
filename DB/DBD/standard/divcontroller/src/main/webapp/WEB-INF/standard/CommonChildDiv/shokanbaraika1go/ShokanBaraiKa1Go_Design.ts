/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ShokanBaraiKa1Go {

        export class Events {

            public static onOkClose_BtnTainoJokyo(): string {
                return "onOkClose_BtnTainoJokyo";
            }

            public static onBeforeOpenDialog_BtnTainoJokyo(): string {
                return "onBeforeOpenDialog_BtnTainoJokyo";
            }

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
                return "ShokanBaraiKa1Go";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.ShokanBaraiKa1Go.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.ShokanBaraiKa1Go.Controls.myType() + "_" + fieldName;
            }

            public ShokanBaraiKa1Go(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TorokuJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TorokuJokyo"));
            }

            public txtTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            }

            public txtTekiyoKikanKaishi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoKikanKaishi"));
            }

            public txtTekiyoKikanShuryo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTekiyoKikanShuryo"));
            }

            public ddlShuryoJokyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShuryoJokyo"));
            }

            public linTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuJokyo"));
            }

            public UketsukeKetteibi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("UketsukeKetteibi"));
            }

            public txtIraiJuriYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiJuriYMD"));
            }

            public txtYokokuTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYokokuTorokuYMD"));
            }

            public txtBemmeishoTeishutsuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBemmeishoTeishutsuKigenYMD"));
            }

            public txtYokokuTsuchiHakkoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtYokokuTsuchiHakkoYMD"));
            }

            public txtBemmeiUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBemmeiUketsukeYMD"));
            }

            public ddlBemmeiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBemmeiRiyu"));
            }

            public txtBemmeiNaiyoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBemmeiNaiyoKetteiYMD"));
            }

            public ddlBemmeiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBemmeiShinsaKekka"));
            }

            public txtHenkoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoKetteiYMD"));
            }

            public txtHokenshoTeishutsuKigenYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHokenshoTeishutsuKigenYMD"));
            }

            public txtHenkoTsuchiHakkoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoTsuchiHakkoYMD"));
            }

            public txtShinseiUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiUketsukeYMD"));
            }

            public ddlShinseiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiRiyu"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public txtShinseiNaiyoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiNaiyoKetteiYMD"));
            }

            public ddlShinseiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiShinsaKekka"));
            }

            public TainoJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            }

            public btnTainoJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTainoJokyo"));
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

