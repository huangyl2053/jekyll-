/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module SelectChoshuYuyoShurui {

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
                return "SelectChoshuYuyoShurui";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.SelectChoshuYuyoShurui.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.SelectChoshuYuyoShurui.Controls.myType() + "_" + fieldName;
            }

            public SelectChoshuYuyoShurui(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgYuyoShurui(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgYuyoShurui"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

