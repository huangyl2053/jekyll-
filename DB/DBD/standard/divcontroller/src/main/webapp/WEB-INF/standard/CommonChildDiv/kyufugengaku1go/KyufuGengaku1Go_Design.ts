/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module KyufuGengaku1Go {

        export class Events {

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

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuKyufugakuGengakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuKyufugakuGengakuKikan"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishi"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryo"));
            }

            public txtIchigoKyufugakuGengakuGengakuMenjoShinseiChoshukenShometsuKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiChoshukenShometsuKikan"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuNofuzumiKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuNofuzumiKikan"));
            }

            public linIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuKyugugakuGengakuTorokuTorokuJokyo"));
            }

            public IchigoKyufugakuGengakuTorokuSinsei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchigoKyufugakuGengakuTorokuSinsei"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuKetteibi"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanKaishi"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuZenkaiKikanShuryo"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuTsuchiHakkobi"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishiInput(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoKaishiInput"));
            }

            public txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryoInput(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuKyugugakuGengakuTorokuGengakuTekiyoShuryoInput"));
            }

            public ddlIchigoKyufugakuGengakuGengakuMenjoShinseiJokyo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiJokyo"));
            }

            public txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiUketsukebi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiUketsukebi"));
            }

            public txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiShinseibi"));
            }

            public ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinseiRiyu"));
            }

            public txtIchigoKyufugakuGengakuGengakuMenjoShinseiNaiyoKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuGengakuMenjoShinseiNaiyoKetteibi"));
            }

            public ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinsaKekka(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoKyufugakuGengakuGengakuMenjoShinseiShinsaKekka"));
            }

            public TainoJokyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            }

            public btnIchigoKyufugakuGengakuTainoJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIchigoKyufugakuGengakuTainoJokyo"));
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

