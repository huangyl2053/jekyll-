/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiDataTorikomiErrorList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiDataTorikomiErrorList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiDataTorikomiErrorList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiDataTorikomiErrorList.Controls.myType() + "_" + fieldName;
            }

            public NinteiDataTorikomiErrorList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgDataTorikomiErrorIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgDataTorikomiErrorIchiran"));
            }

        }

     }

}

