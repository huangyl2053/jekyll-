/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module RoreiFukushiNenkinShokai {

        export class Events {

            public static add(): string {
                return "add";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "RoreiFukushiNenkinShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.RoreiFukushiNenkinShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.RoreiFukushiNenkinShokai.Controls.myType() + "_" + fieldName;
            }

            public RoreiFukushiNenkinShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public panelRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelRireki"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public datagridRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("datagridRireki"));
            }

            public panelInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panelInput"));
            }

            public txtStartDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtStartDate"));
            }

            public txtEndDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtEndDate"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

