/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module FukaRirekiAll {

        export class Events {

            public static onSelectByDblClick_dgFukaRirekiAll(): string {
                return "onSelectByDblClick_dgFukaRirekiAll";
            }

            public static onSelectBySelectButton_dgFukaRirekiAll(): string {
                return "onSelectBySelectButton_dgFukaRirekiAll";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "FukaRirekiAll";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.FukaRirekiAll.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.FukaRirekiAll.Controls.myType() + "_" + fieldName;
            }

            public FukaRirekiAll(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgFukaRirekiAll(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFukaRirekiAll"));
            }

        }

     }

}

