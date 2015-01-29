/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBB {

     export module KaigoNonyutuchishoHakkoJoken {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoNonyutuchishoHakkoJoken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.KaigoNonyutuchishoHakkoJoken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.KaigoNonyutuchishoHakkoJoken.Controls.myType() + "_" + fieldName;
            }

            public KaigoNonyutuchishoHakkoJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHakkoYmd(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoYmd"));
            }

            public lblMsg(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMsg"));
            }

            public txtShutsuryokuKi(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShutsuryokuKi"));
            }

            public ddlShutsuryokuKi(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShutsuryokuKi"));
            }

            public chkTaishosha(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTaishosha"));
            }

            public radSeiho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeiho"));
            }

            public radYamawake(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radYamawake"));
            }

        }

     }

}

