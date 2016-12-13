/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKekkaInfoKihon {

        export class Events {

            public static onBeforeOpenDialog_btnShogaiKoreishaTokki(): string {
                return "onBeforeOpenDialog_btnShogaiKoreishaTokki";
            }

            public static onBeforeOpenDialog_btnChosaTokkiImageShokai(): string {
                return "onBeforeOpenDialog_btnChosaTokkiImageShokai";
            }

            public static onBeforeOpenDialog_btnNinchiKoreishaTokki(): string {
                return "onBeforeOpenDialog_btnNinchiKoreishaTokki";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaKekkaInfoKihon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ChosaKekkaInfoKihon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaKekkaInfoKihon.Controls.myType() + "_" + fieldName;
            }

            public ChosaKekkaInfoKihon(): UZA.Panel {
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

            public KihonChosaPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KihonChosaPanel"));
            }

            public dgKihonChosa(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKihonChosa"));
            }

            public btnShogaiKoreishaTokki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShogaiKoreishaTokki"));
            }

            public txtShogaiNichijoSeikatsuJiritsudoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaiNichijoSeikatsuJiritsudoCode"));
            }

            public btnChosaTokkiImageShokai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaTokkiImageShokai"));
            }

            public btnNinchiKoreishaTokki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinchiKoreishaTokki"));
            }

            public txtNinchishoNichijoSeikatsuJiritsudoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinchishoNichijoSeikatsuJiritsudoCode"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

