/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKekkaInfoKihon {

        export class Events {

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

            public txtChosaJisshiBashoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaJisshiBashoMeisho"));
            }

            public KihonChosaPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KihonChosaPanel"));
            }

            public dgKihonChosa(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKihonChosa"));
            }

            public txtNinchishoNichijoSeikatsuJiritsudoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtNinchishoNichijoSeikatsuJiritsudoCode"));
            }

            public txtShogaiNichijoSeikatsuJiritsudoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaiNichijoSeikatsuJiritsudoCode"));
            }

            public Button1(): UZA.Button {
                return new UZA.Button(this.convFiledName("Button1"));
            }

        }

     }

}

