/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module FukaRirekiAll {

        export class Events {

            public static onSelectByDblClick_dgFukaRirekiAll(): string {
                return "onSelectByDblClick_dgFukaRirekiAll";
            }

            public static onSelectBySelectButton_dgFukaRirekiAll(): string {
                return "onSelectBySelectButton_dgFukaRirekiAll";
            }

            public static onAfterRequestByDblClick_dgFukaRirekiAll(): string {
                return "onAfterRequestByDblClick_dgFukaRirekiAll";
            }

            public static onAfterRequestBySelectButton_dgFukaRirekiAll(): string {
                return "onAfterRequestBySelectButton_dgFukaRirekiAll";
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
                return this._myName + "_" + DBZ.FukaRirekiAll.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.FukaRirekiAll.Controls.myType() + "_" + fieldName;
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

