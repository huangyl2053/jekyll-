/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShoKaishuJokyoList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShoKaishuJokyoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType() + "_" + fieldName;
            }

            public ShoKaishuJokyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShoKaishuJokyo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShoKaishuJokyo"));
            }

        }

     }

}

