/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../ShisetsuJohoCommonChildDiv.ts" />
/// <reference path="../../d.ts/URACommonChildDiv.d.ts" />
/// <reference path="../../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module NinteiShinseiTodokedesha {

        export class Events {

            public static onChanged_ddlTodokedeDaikoKubun(): string {
                return "onChanged_ddlTodokedeDaikoKubun";
            }

            public static onOkClose_seitai(): string {
                return "onOkClose_seitai";
            }

            public static onOkClose_atenKensaku(): string {
                return "onOkClose_atenKensaku";
            }

            public static onClick_btnZenkaiFukusha(): string {
                return "onClick_btnZenkaiFukusha";
            }

            public static onChangeChkKannaiKangai(): string {
                return "onChangeChkKannaiKangai";
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

            public ccdShisetsuJohoCommonChildDiv(): DBZ.ShisetsuJohoCommonChildDiv.ModeController {
                return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJohoCommonChildDiv"));
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

            public txtHonninKankeisei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHonninKankeisei"));
            }

            public radKannaiKangai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKannaiKangai"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public ccdChoikiInput(): URA.ChoikiInput.ModeController {
                return new URA.ChoikiInput.ModeController(this.convFiledName("ccdChoikiInput"));
            }

            public ccdZenkokuJushoInput(): URZ.ZenkokuJushoInput.ModeController {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdZenkokuJushoInput"));
            }

        }

     }

}

