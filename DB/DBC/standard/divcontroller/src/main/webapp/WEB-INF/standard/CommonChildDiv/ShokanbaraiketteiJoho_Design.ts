/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShokanbaraiketteiJoho {

        export class Events {

            public static onChange_rdoShikyukubun(): string {
                return "onChange_rdoShikyukubun";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShokanbaraiketteiJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShokanbaraiketteiJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShokanbaraiketteiJoho.Controls.myType() + "_" + fieldName;
            }

            public ShokanbaraiketteiJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgSyokanbaraikete(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSyokanbaraikete"));
            }

            public hlLine1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("hlLine1"));
            }

            public txtSagakuGoke(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSagakuGoke"));
            }

            public txtKetebi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetebi"));
            }

            public rdoShikyukubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdoShikyukubun"));
            }

            public txtZogenriyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtZogenriyu"));
            }

            public txtShiharaikingakugoke(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaikingakugoke"));
            }

            public txtFuSyikyuriyu1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFuSyikyuriyu1"));
            }

            public txtZogentani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZogentani"));
            }

            public txtFushikyuriyu2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFushikyuriyu2"));
            }

            public lblKokuhorenkete(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKokuhorenkete"));
            }

            public lblGyomuCode(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGyomuCode"));
            }

        }

     }

}

