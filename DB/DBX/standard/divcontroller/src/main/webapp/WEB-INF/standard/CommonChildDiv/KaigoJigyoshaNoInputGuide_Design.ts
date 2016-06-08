/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module KaigoJigyoshaNoInputGuide {

        export class Events {

            public static onClick_btnCalc(): string {
                return "onClick_btnCalc";
            }

            public static onClick_btnSet(): string {
                return "onClick_btnSet";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoJigyoshaNoInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.KaigoJigyoshaNoInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.KaigoJigyoshaNoInputGuide.Controls.myType() + "_" + fieldName;
            }

            public KaigoJigyoshaNoInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlPrefecturesCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlPrefecturesCode"));
            }

            public ddlJigyoshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            }

            public ddlGunshiCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlGunshiCode"));
            }

            public txtTsuban(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTsuban"));
            }

            public txtCheckDigit(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCheckDigit"));
            }

            public btnCalcCheckDigit(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcCheckDigit"));
            }

            public btnCreateJigyoshaNo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCreateJigyoshaNo"));
            }

        }

     }

}

