/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module SearchServiceCodeDialog {

        export class Events {

            public static onClick_btnCloseDialog(): string {
                return "onClick_btnCloseDialog";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SearchServiceCodeDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.SearchServiceCodeDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.SearchServiceCodeDialog.Controls.myType() + "_" + fieldName;
            }

            public SearchServiceCodeDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceShuruiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            }

            public txtServiceItemCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceItemCode"));
            }

            public txtKijunYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYM"));
            }

            public btnSearchServiceCode(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchServiceCode"));
            }

            public dgServiceCode(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceCode"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

