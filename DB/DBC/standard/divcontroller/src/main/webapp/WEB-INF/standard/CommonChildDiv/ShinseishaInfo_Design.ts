/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShinseishaInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShinseishaInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShinseishaInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            }

            public ShinseishaInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public txtUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            }

            public radShinseishaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            }

            public txtShinseishaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtAddress(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public btnSearchJigyosha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            }

        }

     }

}

