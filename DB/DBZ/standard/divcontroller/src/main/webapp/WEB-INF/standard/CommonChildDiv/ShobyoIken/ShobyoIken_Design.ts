/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShobyoIken {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShobyoIken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShobyoIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShobyoIken.Controls.myType() + "_" + fieldName;
            }

            public ShobyoIken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ShindanName(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShindanName"));
            }

            public txtShindanName1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName1"));
            }

            public txtShindanYMD1(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD1"));
            }

            public txtShindanName2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName2"));
            }

            public txtShindanYMD2(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD2"));
            }

            public txtShindanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShindanName"));
            }

            public txtShindanYMD3(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD3"));
            }

            public btnShuyoShippeiGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShuyoShippeiGuide"));
            }

            public txtShuyoShippeiCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShuyoShippeiCode"));
            }

            public ShojoAnteisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShojoAnteisei"));
            }

            public radShojoAnteisei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShojoAnteisei"));
            }

            public txtFuanteiShosaiJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFuanteiShosaiJokyo"));
            }

            public SeikatsuKinoGenin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuKinoGenin"));
            }

            public lblChiryoNaiyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblChiryoNaiyo"));
            }

            public imgChiryoNaiyo(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgChiryoNaiyo"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKoshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            }

        }

     }

}

