/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ServiceTeikyoShomeishoKeikakuList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceTeikyoShomeishoKeikakuList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoKeikakuList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoKeikakuList.Controls.myType() + "_" + fieldName;
            }

            public ServiceTeikyoShomeishoKeikakuList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgShokanShikyuTorokuShomeishoKeikakuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShokanShikyuTorokuShomeishoKeikakuList"));
            }

        }

     }

}

