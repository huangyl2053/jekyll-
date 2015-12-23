/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module IryohokenRirekiCommonChildDiv {

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

            public static onClick_btnIryohokenKakute(): string {
                return "onClick_btnIryohokenKakute";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryohokenRirekiCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBA.IryohokenRirekiCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.IryohokenRirekiCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public IryohokenRirekiCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public plIryohokenRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("plIryohokenRireki"));
            }

            public btnIryohokenTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryohokenTsuika"));
            }

            public dgIryohokenIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryohokenIchiran"));
            }

            public pnlIryohokenJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlIryohokenJoho"));
            }

            public tbdKanyubi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("tbdKanyubi"));
            }

            public tbdDattabi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("tbdDattabi"));
            }

            public ddlSyubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSyubetsu"));
            }

            public txtHokensyaKodo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensyaKodo"));
            }

            public txtHokensyaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensyaMeisho"));
            }

            public txtKigoBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKigoBango"));
            }

            public btnIryohokenKakute(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryohokenKakute"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

