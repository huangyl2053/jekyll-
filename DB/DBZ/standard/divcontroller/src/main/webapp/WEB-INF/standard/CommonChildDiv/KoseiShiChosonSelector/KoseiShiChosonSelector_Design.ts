/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KoseiShiChosonSelector {

        export class Events {

            public static onClick_Kensaku(): string {
                return "onClick_Kensaku";
            }

            public static onClick_Moderu(): string {
                return "onClick_Moderu";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KoseiShiChosonSelector";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KoseiShiChosonSelector.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KoseiShiChosonSelector.Controls.myType() + "_" + fieldName;
            }

            public KoseiShiChosonSelector(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgKoseiShichosonList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKoseiShichosonList"));
            }

            public btnback(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnback"));
            }

        }

     }

}

