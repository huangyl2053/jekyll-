/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module MenjoKaijoSaiTennyu {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "MenjoKaijoSaiTennyu";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.MenjoKaijoSaiTennyu.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.MenjoKaijoSaiTennyu.Controls.myType() + "_" + fieldName;
            }

            public MenjoKaijoSaiTennyu(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu2"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu3"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu4"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu5"));
            }

            public IchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuToroku"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuJokyo"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuKyufugakuGengakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuKyufugakuGengakuKikan"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishi"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryo"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuChoshukenShometsuKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuChoshukenShometsuKikan"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuNofuzumiKikan(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuNofuzumiKikan"));
            }

            public linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuKetteibi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuKetteibi"));
            }

            public btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTainoJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTainoJokyo"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanKaishi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanKaishi"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanShuryo(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuZenkaiKikanShuryo"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTsuchiHakkobi(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTsuchiHakkobi"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishiInput(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoKaishiInput"));
            }

            public txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryoInput(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuGengakuTekiyoShuryoInput"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

            public dgIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu"));
            }

            public btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose"));
            }

        }

     }

}

