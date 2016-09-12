/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KokuhorenJohoSofu {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KokuhorenJohoSofu";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KokuhorenJohoSofu.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KokuhorenJohoSofu.Controls.myType() + "_" + fieldName;
            }

            public KokuhorenJohoSofu(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblChushutsuJoken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            }

            public txtShoriSaikuruKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoriSaikuruKubun"));
            }

            public txtShoritaishoNengetsu(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShoritaishoNengetsu"));
            }

            public txtsaishoriKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtsaishoriKubun"));
            }

            public txtFileName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFileName"));
            }

            public ddlSofuTaishojoho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSofuTaishojoho"));
            }

            public ShoriJikkoMaekakuninJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShoriJikkoMaekakuninJiko"));
            }

            public lblKakuninJiko1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakuninJiko1"));
            }

            public lblKakuninJiko2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKakuninJiko2"));
            }

        }

     }

}

