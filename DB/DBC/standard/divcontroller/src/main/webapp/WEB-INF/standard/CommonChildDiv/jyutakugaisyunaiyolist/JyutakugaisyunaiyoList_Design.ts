/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JyutakugaisyunaiyoList {

        export class Events {

            public static onClick_InsertButton(): string {
                return "onClick_InsertButton";
            }

            public static onClick_SelectButton(): string {
                return "onClick_SelectButton";
            }

            public static onClick_ModifyButton(): string {
                return "onClick_ModifyButton";
            }

            public static onClick_DeleteButton(): string {
                return "onClick_DeleteButton";
            }

            public static onClick_CopyButton(): string {
                return "onClick_CopyButton";
            }

            public static onClick_ClearButton(): string {
                return "onClick_ClearButton";
            }

            public static onClick_ConfirmButton(): string {
                return "onClick_ConfirmButton";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JyutakugaisyunaiyoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JyutakugaisyunaiyoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JyutakugaisyunaiyoList.Controls.myType() + "_" + fieldName;
            }

            public JyutakugaisyunaiyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public PnlGaisyuListArea(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("PnlGaisyuListArea"));
            }

            public btnDetailAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDetailAdd"));
            }

            public dgGaisyuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGaisyuList"));
            }

            public PnlNyuryokuArea(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("PnlNyuryokuArea"));
            }

            public txtKaisyunaiyo(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaisyunaiyo"));
            }

            public txtJigyosya(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyosya"));
            }

            public lblTaisyojyutakujyusyo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTaisyojyutakujyusyo"));
            }

            public btnHonnijyusyoCopy(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHonnijyusyoCopy"));
            }

            public txtJyusyo(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtJyusyo"));
            }

            public txtTyakkoyotebi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTyakkoyotebi"));
            }

            public txtKanseyotebi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseyotebi"));
            }

            public txtKaisyukingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisyukingaku"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public btnDetailConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDetailConfirm"));
            }

        }

     }

}

