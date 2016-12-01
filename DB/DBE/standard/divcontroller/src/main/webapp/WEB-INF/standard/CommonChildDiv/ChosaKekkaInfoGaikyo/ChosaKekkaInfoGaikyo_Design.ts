/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKekkaInfoGaikyo {

        export class Events {

            public static onClick_Moderu(): string {
                return "onClick_Moderu";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaKekkaInfoGaikyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ChosaKekkaInfoGaikyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaKekkaInfoGaikyo.Controls.myType() + "_" + fieldName;
            }

            public ChosaKekkaInfoGaikyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNinteichosaJisshiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteichosaJisshiYMD"));
            }

            public lblJisshiBasho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblJisshiBasho"));
            }

            public txtChosaJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            }

            public JisshiBashoMeishoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JisshiBashoMeishoPanel"));
            }

            public imgChosaJisshiBashoMeisho(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgChosaJisshiBashoMeisho"));
            }

            public GaikyoChosaTokkiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GaikyoChosaTokkiPanel"));
            }

            public txtGaikyoChosaTokki(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoChosaTokki"));
            }

            public imgGaikyoChosaTokki(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgGaikyoChosaTokki"));
            }

            public radServiceKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            }

            public rdoJutakuKaishu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdoJutakuKaishu"));
            }

            public ServiceJokyoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceJokyoPanel"));
            }

            public dgServiceJokyo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceJokyo"));
            }

            public ShisetsuRiyoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuRiyoPanel"));
            }

            public lblShisetsuShurui(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuShurui"));
            }

            public txtRiyoShisetsuShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuShurui"));
            }

            public lblShisetsuShimei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShisetsuShimei"));
            }

            public lblTelNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTelNo"));
            }

            public txtRiyoShisetsuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuMeisho"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public ShisetsuMeishoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuMeishoPanel"));
            }

            public imgRiyoShisetsuMeisho(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgRiyoShisetsuMeisho"));
            }

            public TelNoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TelNoPanel"));
            }

            public imgTelNo(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTelNo"));
            }

            public lblRiyoShisetsuJusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoShisetsuJusho"));
            }

            public txtRiyoShisetsuJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuJusho"));
            }

            public ShisetsuJushoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuJushoPanel"));
            }

            public imgRiyoShisetsuJusho(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgRiyoShisetsuJusho"));
            }

            public TokubetsuKyufuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuKyufuPanel"));
            }

            public txtTokubetsuKyufu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokubetsuKyufu"));
            }

            public imgTokubetsuKyufu(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokubetsuKyufu"));
            }

            public ZaitakuServicePanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaitakuServicePanel"));
            }

            public txtZaitakuService(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtZaitakuService"));
            }

            public imgZaitakuService(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgZaitakuService"));
            }

            public GaikyoTokkiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiPanel"));
            }

            public lblJutakuKaishu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblJutakuKaishu"));
            }

            public txtJutakuKaishu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJutakuKaishu"));
            }

            public line1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line1"));
            }

            public lblGaikyoTokkiTokubetsuKyufu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGaikyoTokkiTokubetsuKyufu"));
            }

            public txtGaikyoTokkiTokubetsuKyufu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoTokkiTokubetsuKyufu"));
            }

            public line2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line2"));
            }

            public lblZaitakuService(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblZaitakuService"));
            }

            public txtGaikyoTokkiZaitakuService(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtGaikyoTokkiZaitakuService"));
            }

            public line3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line3"));
            }

            public lblShuso(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShuso"));
            }

            public txtShuso(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShuso"));
            }

            public line4(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line4"));
            }

            public lblKazokuJokyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKazokuJokyo"));
            }

            public txtKazokuJokyo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKazokuJokyo"));
            }

            public line5(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line5"));
            }

            public lblKyojuKankyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyojuKankyo"));
            }

            public txtKyojuKankyo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKyojuKankyo"));
            }

            public line6(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line6"));
            }

            public lblKikaiKiki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKikaiKiki"));
            }

            public txtKikaiKiki(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKikaiKiki"));
            }

            public imgGaikyoTokki(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgGaikyoTokki"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

