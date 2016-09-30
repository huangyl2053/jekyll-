/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module GemmenGengakuRirekiList {

        export class Events {

            public static onClose(): string {
                return "onClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "GemmenGengakuRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.GemmenGengakuRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.GemmenGengakuRirekiList.Controls.myType() + "_" + fieldName;
            }

            public GemmenGengakuRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlFutangendogakuRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlFutangendogakuRireki"));
            }

            public dgFutanGendogakuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFutanGendogakuList"));
            }

            public pnlTaGemmenGengakuRireki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlTaGemmenGengakuRireki"));
            }

            public dgTaGemmenGengakuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTaGemmenGengakuList"));
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

