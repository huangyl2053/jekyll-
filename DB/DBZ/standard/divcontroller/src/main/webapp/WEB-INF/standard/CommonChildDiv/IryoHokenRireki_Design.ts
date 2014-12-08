/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module IryoHokenRireki {

        export class Events {

            public static onClick_btnAddIryoHoken(): string {
                return "onClick_btnAddIryoHoken";
            }

            public static onSelect_dgIryoHokenRireki(): string {
                return "onSelect_dgIryoHokenRireki";
            }

            public static onSelectByDbClick_dgIryoHokenRireki(): string {
                return "onSelectByDbClick_dgIryoHokenRireki";
            }

            public static onSelectByModifyButton_dgIryoHokenRireki(): string {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            }

            public static onSelectByDeleteButton_dgIryoHokenRireki(): string {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            }

            public static onBlur_txtIryoHokenHokenshaNo(): string {
                return "onBlur_txtIryoHokenHokenshaNo";
            }

            public static onClick_btnIryoHokenKakutei(): string {
                return "onClick_btnIryoHokenKakutei";
            }

            public static onClick_btnIryoHokenTorikeshi(): string {
                return "onClick_btnIryoHokenTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "IryoHokenRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            }

            public IryoHokenRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddIryoHoken(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            }

            public dgIryoHokenRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            }

            public IryoHokenInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            }

            public txtIryoHokenKanyuDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            }

            public txtIryoHokenDattaiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            }

            public ddlIryoHokenShubetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            }

            public txtIryoHokenHokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            }

            public txtIryoHokenHokenshaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            }

            public txtIryoHokenKigoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            }

            public btnIryoHokenKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            }

            public btnIryoHokenTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            }

        }

     }

}

