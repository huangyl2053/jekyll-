/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module GemmenShurui {

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
                return "GemmenShurui";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.GemmenShurui.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.GemmenShurui.Controls.myType() + "_" + fieldName;
            }

            public GemmenShurui(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgGemmenShurui(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGemmenShurui"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

        }

     }

}

