/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinseiTodokedesha {

        export class Events {

            public static onChanged_ddlTodokedeDaikoKubun(): string {
                return "onChanged_ddlTodokedeDaikoKubun";
            }

            public static onClick_btnZenkaiFukusha(): string {
                return "onClick_btnZenkaiFukusha";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinseiTodokedesha";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinseiTodokedesha.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinseiTodokedesha.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinseiTodokedesha(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlTodokledeDaikoKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTodokledeDaikoKubun"));
            }

            public btnSetaiIchiran(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiIchiran"));
            }

            public btnAtenaKensaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnAtenaKensaku"));
            }

            public btnZenkaiFukusha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            }

            public txtJigyoshaCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));
            }

            public btnJigyoshaGuide(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaGuide"));
            }

            public txtJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            }

            public ddlShinseiKankeisha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKankeisha"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtKanaShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKanaShimei"));
            }

            public txtHonninKankeisei(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHonninKankeisei"));
            }

            public lblHonninKankeiseiMei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHonninKankeiseiMei"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            }

        }

     }

}

