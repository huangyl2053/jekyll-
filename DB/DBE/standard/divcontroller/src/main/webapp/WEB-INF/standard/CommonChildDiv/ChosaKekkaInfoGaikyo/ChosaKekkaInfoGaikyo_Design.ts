/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKekkaInfoGaikyo {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
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

            public txtChosaJisshiBashoCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoCode"));
            }

            public txtChosaJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            }

            public ChosaItakusakiAndChosainGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaItakusakiAndChosainGuide"));
            }

            public txtChosaItakusakiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCode"));
            }

            public txtChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            }

            public txtNinteiChosainCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosainCode"));
            }

            public txtNinteiChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            }

            public JisshiBashoMeishoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JisshiBashoMeishoPanel"));
            }

            public imgChosaJisshiBashoMeisho(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgChosaJisshiBashoMeisho"));
            }

            public lblNoImageJisshiBasho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageJisshiBasho"));
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

            public lblNoImageGaikyoChosaTokki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageGaikyoChosaTokki"));
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

            public lblNoImageRiyoShisetsuMeisho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageRiyoShisetsuMeisho"));
            }

            public TelNoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TelNoPanel"));
            }

            public imgTelNo(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTelNo"));
            }

            public lblNoImageTelNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageTelNo"));
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

            public lblNoImageRiyoShisetsuJusho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageRiyoShisetsuJusho"));
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

            public lblNoImageTokubetsuKyufu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageTokubetsuKyufu"));
            }

            public TokubetsuKyufuSmallPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuKyufuSmallPanel"));
            }

            public imgTokubetsuKyufuSmall(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgTokubetsuKyufuSmall"));
            }

            public lblImgTokubetsuKyufuSmall(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImgTokubetsuKyufuSmall"));
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

            public lblNoImageZaitakuService(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageZaitakuService"));
            }

            public ZaitakuServiceSmallPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaitakuServiceSmallPanel"));
            }

            public imgZaitakuServiceSmall(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgZaitakuServiceSmall"));
            }

            public lblImgZaitakuServiceSmall(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblImgZaitakuServiceSmall"));
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

            public lblNoImageGaikyoTokki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImageGaikyoTokki"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

