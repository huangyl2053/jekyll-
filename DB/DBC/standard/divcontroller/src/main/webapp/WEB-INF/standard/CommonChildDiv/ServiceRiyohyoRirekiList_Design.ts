/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ServiceRiyohyoRirekiList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceRiyohyoRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceRiyohyoRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceRiyohyoRirekiList.Controls.myType() + "_" + fieldName;
            }

            public ServiceRiyohyoRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgServiceRiyohyoRirekiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoRirekiList"));
            }

        }

     }

}

