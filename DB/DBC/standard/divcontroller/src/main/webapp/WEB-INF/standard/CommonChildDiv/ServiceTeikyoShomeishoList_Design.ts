/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ServiceTeikyoShomeishoList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceTeikyoShomeishoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoList.Controls.myType() + "_" + fieldName;
            }

            public ServiceTeikyoShomeishoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgServiceTeikyoShomeishoList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoList"));
            }

        }

     }

}

