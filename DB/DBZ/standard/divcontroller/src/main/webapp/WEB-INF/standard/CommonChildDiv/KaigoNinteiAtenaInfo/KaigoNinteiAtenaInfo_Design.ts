/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoNinteiAtenaInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNinteiAtenaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoNinteiAtenaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoNinteiAtenaInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoNinteiAtenaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtBirthYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtBirthYMD"));
            }

            public txtNenrei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtNenrei"));
            }

            public txtSeibetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            }

            public imgJuminShubetsu(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgJuminShubetsu"));
            }

            public txtJuminShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJuminShubetsu"));
            }

            public txtShikiBetsuCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShikiBetsuCode"));
            }

            public btnKojinMemo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKojinMemo"));
            }

            public txtKojinNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKojinNo"));
            }

            public imgYubinNo(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgYubinNo"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtGyoseiku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGyoseiku"));
            }

            public txtSetaiCode(): UZA.TextBoxSetaiCode {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtSetaiCode"));
            }

            public btnSetaiMemo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiMemo"));
            }

        }

     }

}

