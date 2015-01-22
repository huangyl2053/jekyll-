/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KagoMoshitate {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KagoMoshitate";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KagoMoshitate.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KagoMoshitate.Controls.myType() + "_" + fieldName;
            }

            public KagoMoshitate(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public txtJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            }

            public txtMoshitateshaKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtMoshitateshaKubun"));
            }

            public txtSendYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSendYM"));
            }

            public txtShokisaiHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            }

            public txtShokisaiHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShokisaiHokenshaName"));
            }

            public txtTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            }

            public txtKagoForm(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKagoForm"));
            }

            public txtMoshitateDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtMoshitateDate"));
            }

            public ddlKagoMoshitateRiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKagoMoshitateRiyu"));
            }

            public chkForDogetsuShinsa(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkForDogetsuShinsa"));
            }

        }

     }

}

