/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShokanShinseiList {

        export class Events {

            public static onClick_InsertButton(): string {
                return "onClick_InsertButton";
            }

            public static onSelectByDbClick(): string {
                return "onSelectByDbClick";
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

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShokanShinseiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShokanShinseiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShokanShinseiList.Controls.myType() + "_" + fieldName;
            }

            public ShokanShinseiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYM"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public line(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("line"));
            }

            public txtServiceYMFrom(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYMFrom"));
            }

            public txtServiceYMTo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYMTo"));
            }

            public btnSelect(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelect"));
            }

            public dgShinseiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinseiList"));
            }

        }

     }

}

