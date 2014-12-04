/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SeikatsuhogoRireki {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuhogoRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuhogoRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddRow(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddRow"));
            }

            public dgSeikatsuhogoRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSeikatsuhogoRireki"));
            }

        }

     }

}

