/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShikibetsuBangoSelector {

        export class Events {

            public static onClick_btnSearch(): string {
                return "onClick_btnSearch";
            }

            public static CloseCancel(): string {
                return "CloseCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShikibetsuBangoSelector";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShikibetsuBangoSelector.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShikibetsuBangoSelector.Controls.myType() + "_" + fieldName;
            }

            public ShikibetsuBangoSelector(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtShikibetsuCode"));
            }

            public txtShiyoCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShiyoCode"));
            }

            public txtKinjunYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKinjunYM"));
            }

            public btnSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearch"));
            }

            public dgDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgDetail"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

