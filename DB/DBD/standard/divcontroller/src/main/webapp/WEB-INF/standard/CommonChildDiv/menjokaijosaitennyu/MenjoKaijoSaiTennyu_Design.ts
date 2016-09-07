/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module MenjoKaijoSaiTennyu {

        export class Events {

            public static selectedItem(): string {
                return "selectedItem";
            }

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

            public static onClick_btnToJiRu(): string {
                return "onClick_btnToJiRu";
            }

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

            public dgMenjoKaijoOrSaitennyu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgMenjoKaijoOrSaitennyu"));
            }

            public linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuGrid"));
            }

            public lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIchigoKyufugakuGengakuMenjoKaijoOrSaitennyu1"));
            }

            public lblExplanation2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblExplanation2"));
            }

            public lblExplanation3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblExplanation3"));
            }

            public lblExplanation4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblExplanation4"));
            }

            public lblExplanation5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblExplanation5"));
            }

            public KyufugakuGengakuToroku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyufugakuGengakuToroku"));
            }

            public txtTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            }

            public txtKyufugakuGengakuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufugakuGengakuKikan"));
            }

            public txtGengakuTekiyoKikanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTekiyoKikanKaishiYMD"));
            }

            public txtGengakuTekiyoKikanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTekiyoKikanShuryoYMD"));
            }

            public txtChoshukenShometsuKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChoshukenShometsuKikan"));
            }

            public txtNofuzumiKikan(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumiKikan"));
            }

            public linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuTorokuJokyo"));
            }

            public txtGengakuKetteiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuKetteiYMD"));
            }

            public txtTainoJokyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("txtTainoJokyo"));
            }

            public txtZenkaiKikanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanKaishiYMD"));
            }

            public txtZenkaiKikanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiKikanShuryoYMD"));
            }

            public txtGengakuTsuchiHakkoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtGengakuTsuchiHakkoYMD"));
            }

            public txtKonkaiKikanKaishiYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanKaishiYMD"));
            }

            public txtKonkaiKikanShuryoYMD(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKonkaiKikanShuryoYMD"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

            public btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIchigoKyufugakuGengakuMenjoKaijoOrSaitennyuKyufugakuGengakuTorokuClose"));
            }

        }

     }

}

