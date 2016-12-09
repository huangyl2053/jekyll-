/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ShujiiIkenshoIraiShokai {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShujiiIkenshoIraiShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType() + "_" + fieldName;
            }

            public ShujiiIkenshoIraiShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgIkenshoIraiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIkenshoIraiIchiran"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

        }

     }

}

