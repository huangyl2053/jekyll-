/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module SelectTorikeshiShurui {

        export class Events {

            public static onClick_btnSelect(): string {
                return "onClick_btnSelect";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SelectTorikeshiShurui";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.SelectTorikeshiShurui.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.SelectTorikeshiShurui.Controls.myType() + "_" + fieldName;
            }

            public SelectTorikeshiShurui(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgTorikeshiShurui(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTorikeshiShurui"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

