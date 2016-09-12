/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyufuseigenRirekiList {

        export class Events {

            public static onClose(): string {
                return "onClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyufuseigenRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyufuseigenRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyufuseigenRirekiList.Controls.myType() + "_" + fieldName;
            }

            public KyufuseigenRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlKyufuseigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlKyufuseigen"));
            }

            public dgKyufuseigenRirekiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKyufuseigenRirekiList"));
            }

            public pnlButton(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlButton"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

