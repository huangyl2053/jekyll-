/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module KyufuGengaku1Go {

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
                return "KyufuGengaku1Go";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.KyufuGengaku1Go.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.KyufuGengaku1Go.Controls.myType() + "_" + fieldName;
            }

            public KyufuGengaku1Go(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            }

            public txtKyufugakuGengakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufugakuGengakuKikan"));
            }

            public txtGengakuTekiyoKikanKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGengakuTekiyoKikanKaishiYMD"));
            }

            public txtGengakuTekiyoKikanShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGengakuTekiyoKikanShuryoYMD"));
            }

            public txtChoshukenShometsuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoshukenShometsuKikan"));
            }

            public txtNofuzumiKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumiKikan"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public GengakuTorokuOrMenjoShinsei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GengakuTorokuOrMenjoShinsei"));
            }

            public txtGengakuKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtGengakuKetteiYMD"));
            }

            public txtZenkaiKikanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanKaishiYMD"));
            }

            public txtZenkaiKikanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanShuryoYMD"));
            }

            public txtKyufuGengakuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKyufuGengakuTsuchiHakkoYMD"));
            }

            public txtKonkaiKikanKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKonkaiKikanKaishiYMD"));
            }

            public txtKonkaiKikanShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKonkaiKikanShuryoYMD"));
            }

            public ddlMenjoShinseiJokyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlMenjoShinseiJokyo"));
            }

            public txtMenjoShinseiUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMenjoShinseiUketsukeYMD"));
            }

            public txtMenjoShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMenjoShinseiYMD"));
            }

            public ddlIMenjoShinseiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIMenjoShinseiRiyu"));
            }

            public txtMenjoNaiyoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMenjoNaiyoKetteiYMD"));
            }

            public ddlMenjoShinseiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlMenjoShinseiShinsaKekka"));
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

