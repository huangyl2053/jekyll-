/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ImageMasking {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ImageMasking";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType() + "_" + fieldName;
            }

            public ImageMasking(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tblImageMasking(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblImageMasking"));
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

            public celTableCell4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell4"));
            }

            public lblOkikaeru(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblOkikaeru"));
            }

            public celTableCell5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTableCell5"));
            }

            public txtChosaKomokuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaKomokuMeisho"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnIchijiHozon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIchijiHozon"));
            }

        }

     }

}

