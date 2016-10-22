/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module DankaibetsuShinseiList {

        export class Events {

            public static onClick_btnToSearch(): string {
                return "onClick_btnToSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "DankaibetsuShinseiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType() + "_" + fieldName;
            }

            public DankaibetsuShinseiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnToSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            }

            public txtKanryo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKanryo"));
            }

            public txtGokei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGokei"));
            }

            public btnNarabikae(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNarabikae"));
            }

            public dgTaishoIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTaishoIchiran"));
            }

        }

     }

}

