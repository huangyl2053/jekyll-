/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module IchijiSashitome2Go {

        export class Events {

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

            public txtTekiyoKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKaishi"));
            }

            public txtTekiyoShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoShuryo"));
            }

            public ddlShuryoJokyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShuryoJokyo"));
            }

            public linTorokuTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuTorokuJokyo"));
            }

            public txtNigoYokokushaTorokuIraiJuribi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuIraiJuribi"));
            }

            public txtNigoYokokushaTorokuYokokuTorokubi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuYokokuTorokubi"));
            }

            public txtNigoYokokushaTorokuBenmeishoTeishutsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuBenmeishoTeishutsuKigen"));
            }

            public txtNigoYokokushaTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuTsuchiHakkobi"));
            }

            public txtNigoBenmeishoJuriBenmeishoUketsukebi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoBenmeishoJuriBenmeishoUketsukebi"));
            }

            public ddlNigoBenmeishoJuriBenmeiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiRiyu"));
            }

            public txtNigoBenmeishoJuriBenmeiNaiyoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoBenmeishoJuriBenmeiNaiyoKetteibi"));
            }

            public ddlNigoBenmeishoJuriBenmeiShinsakekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiShinsakekka"));
            }

            public txtNigoIchijiSashitomeTorokuSashitomeKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuSashitomeKetteibi"));
            }

            public txtNigoIchijiSashitomeTorokuHokenshoTeishitsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuHokenshoTeishitsuKigen"));
            }

            public txtNigoIchijiSashitomeTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuTsuchiHakkobi"));
            }

            public txtNigoIchijiSashitomeKaijoIraiUketsukebi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraiUketsukebi"));
            }

            public ddlNigoIchijiSashitomeKaijoIraiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoIchijiSashitomeKaijoIraiRiyu"));
            }

            public txtNigoIchijiSashitomeKaijoIraibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraibi"));
            }

            public txtNigoIchijiSashitomeKaijoIraiNaiyoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraiNaiyoKetteibi"));
            }

            public ddlNigoIchijiSashitomeKaijoIraiChosaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNigoIchijiSashitomeKaijoIraiChosaKekka"));
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

