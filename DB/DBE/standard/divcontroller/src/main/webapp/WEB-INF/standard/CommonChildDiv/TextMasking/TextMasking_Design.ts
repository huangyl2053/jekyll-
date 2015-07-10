/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module TextMasking {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TextMasking";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.TextMasking.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TextMasking.Controls.myType() + "_" + fieldName;
            }

            public TextMasking(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tblTextMasking(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTextMasking"));
            }

            public celTableCell1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell1"));
            }

            public txtChosaKomokuNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuNo"));
            }

            public celTableCell2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell2"));
            }

            public lblHyphen(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHyphen"));
            }

            public celTableCell3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell3"));
            }

            public txtChosaKomokuRenban(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtChosaKomokuRenban"));
            }

            public celTableCell6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell6"));
            }

            public txtChosaKomokuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuMeisho"));
            }

            public celTableCell4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            }

            public lblBeforeMasking(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblBeforeMasking"));
            }

            public celTableCell5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            }

            public txtBeforeMasking(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBeforeMasking"));
            }

            public celTableCell7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell7"));
            }

            public lblAfterMasking(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblAfterMasking"));
            }

            public celTableCell8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell8"));
            }

            public txtAfterMasking(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtAfterMasking"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnHozon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHozon"));
            }

        }

     }

}

