/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JutakuKaishuhiRireki {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JutakuKaishuhiRireki";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JutakuKaishuhiRireki.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JutakuKaishuhiRireki.Controls.myType() + "_" + fieldName;
            }

            public JutakuKaishuhiRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgJutakuKaishuRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuRireki"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

