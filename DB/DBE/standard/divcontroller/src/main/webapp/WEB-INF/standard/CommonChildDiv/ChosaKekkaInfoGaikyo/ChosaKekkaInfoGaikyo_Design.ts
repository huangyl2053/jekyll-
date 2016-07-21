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

            public txtChosaJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            }

            public TokkiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokkiPanel"));
            }

            public txtTokki(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokki"));
            }

            public ServiceJokyoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceJokyoPanel"));
            }

            public dgServiceJokyo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceJokyo"));
            }

            public radServiceKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radServiceKubun"));
            }

            public rdoJutakuKaishu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdoJutakuKaishu"));
            }

            public KubetsuKyufuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KubetsuKyufuPanel"));
            }

            public txtkubetsuKyufu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtkubetsuKyufu"));
            }

            public ZaitakuServicePanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ZaitakuServicePanel"));
            }

            public txtZaitakuService(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtZaitakuService"));
            }

            public RiyoShisetsuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RiyoShisetsuPanel"));
            }

            public dgRiyoShisetsu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgRiyoShisetsu"));
            }

            public txtRiyoShisetsuShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuShimei"));
            }

            public txtRiyoShisetsuJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRiyoShisetsuJusho"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public GaikyoTokkiTextPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiTextPanel"));
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

            public lblTokuBetsuKyufuService(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuBetsuKyufuService"));
            }

            public txtTokuBetsuKyufuService(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokuBetsuKyufuService"));
            }

            public line2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line2"));
            }

            public lblTokkiZaitakuService(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokkiZaitakuService"));
            }

            public txtTokkiZaitakuService(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkiZaitakuService"));
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

            public GaikyoTokkiImagePanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GaikyoTokkiImagePanel"));
            }

            public gaikyoChosaImage(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("gaikyoChosaImage"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

