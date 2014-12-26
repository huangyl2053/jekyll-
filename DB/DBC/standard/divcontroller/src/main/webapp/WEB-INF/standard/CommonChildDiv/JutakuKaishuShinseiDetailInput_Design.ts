/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JutakuKaishuShinseiDetailInput {

        export class Events {

            public static onSelectByModifyButton(): string {
                return "onSelectByModifyButton";
            }

            public static onSelectByDeleteButton(): string {
                return "onSelectByDeleteButton";
            }

            public static onClick_btnCopyAddress(): string {
                return "onClick_btnCopyAddress";
            }

            public static onClick_btnClearDetail(): string {
                return "onClick_btnClearDetail";
            }

            public static onClick_btnModifyDetail(): string {
                return "onClick_btnModifyDetail";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JutakuKaishuShinseiDetailInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JutakuKaishuShinseiDetailInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JutakuKaishuShinseiDetailInput.Controls.myType() + "_" + fieldName;
            }

            public JutakuKaishuShinseiDetailInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgJutakuKaishuDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));
            }

            public JutakuKaishuDetailInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuDetailInput"));
            }

            public txtKaishuContents(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));
            }

            public txtKaishuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));
            }

            public lblKaishuTaishoAddress(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaishuTaishoAddress"));
            }

            public btnCopyAddress(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCopyAddress"));
            }

            public txtKaishuTaishoAddress(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKaishuTaishoAddress"));
            }

            public txtChakkoDueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));
            }

            public txtKanseiDueDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));
            }

            public txtEstimatedAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));
            }

            public btnClearDetail(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClearDetail"));
            }

            public btnModifyDetail(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModifyDetail"));
            }

        }

     }

}

