/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseishaKihonInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseishaKihonInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseishaKihonInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseishaKihonInfo.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseishaKihonInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            }

            public txtHihokenshaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKubun"));
            }

            public txtHokenshaNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenshaNo"));
            }

            public txtHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            }

            public txtHihokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaName"));
            }

            public txtSeinenYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeinenYmd"));
            }

            public txtHihokenshaKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKana"));
            }

            public txtNenrei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNenrei"));
            }

            public txtSeibetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            }

            public txtYubibNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubibNo"));
            }

            public txtjusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtjusho"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtNinteiShinseibi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShinseibi"));
            }

            public txtShinseiKubunShinseiji(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinseiji"));
            }

            public txtShinseiKubunHoreiji(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHoreiji"));
            }

        }

     }

}

