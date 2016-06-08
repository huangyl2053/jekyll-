/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ShokanBaraiKa1Go {

        export class Events {

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

            public txtTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            }

            public txtTekiyoKikanKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKikanKaishi"));
            }

            public txtTekiyoKikanShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKikanShuryo"));
            }

            public txtShuryoJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShuryoJokyo"));
            }

            public linTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuJokyo"));
            }

            public UketsukeKetteibi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("UketsukeKetteibi"));
            }

            public txtiIchigoYokokushaTorokuIraiJuribi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtiIchigoYokokushaTorokuIraiJuribi"));
            }

            public txtIchigoYokokushaTorokuYokokuTorokubi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuYokokuTorokubi"));
            }

            public txtIchigoYokokushaTorokuBenmeishoTeishutsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuBenmeishoTeishutsuKigen"));
            }

            public txtIchigoYokokushaTorokuTuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuTuchiHakkobi"));
            }

            public txtIchigoBenmeishoJuriBenmeiUketsukebi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoBenmeishoJuriBenmeiUketsukebi"));
            }

            public ddlIchigoBenmeishoJuriBenmeiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoBenmeishoJuriBenmeiRiyu"));
            }

            public txtIchigoBenmeishoJuriBenmeiNaiyoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoBenmeishoJuriBenmeiNaiyoKetteibi"));
            }

            public ddlIchigoBenmeishoJuriBenmeiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoBenmeishoJuriBenmeiShinsaKekka"));
            }

            public txtShokanBaraikaTorokuHenkoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuHenkoKetteibi"));
            }

            public txtShokanBaraikaTorokuHokenshoTeishutsuKigen(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuHokenshoTeishutsuKigen"));
            }

            public txtShokanBaraikaTorokuTuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuTuchiHakkobi"));
            }

            public txtShokanBaraikaShuryoShinseiShinseiUketsukebi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseiUketsukebi"));
            }

            public ddlShokanBaraikaShuryoShinseiShinseiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShokanBaraikaShuryoShinseiShinseiRiyu"));
            }

            public txtShokanBaraikaShuryoShinseiShinseibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseibi"));
            }

            public txtShokanBaraikaShuryoShinseiShinseiNaiyoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseiNaiyoKetteibi"));
            }

            public ddlShokanBaraikaShuryoShinseiShinseiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShokanBaraikaShuryoShinseiShinseiShinsaKekka"));
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

