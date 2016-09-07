/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JukyuIdoKeikakuRirekiList {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyuIdoKeikakuRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JukyuIdoKeikakuRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JukyuIdoKeikakuRirekiList.Controls.myType() + "_" + fieldName;
            }

            public JukyuIdoKeikakuRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlKyotakuKeikaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlKyotakuKeikaku"));
            }

            public dgKyotakuKeikaku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuKeikaku"));
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

