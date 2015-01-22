/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShichosonSelector {

        export class Events {

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

            public static onClick_btnDecision(): string {
                return "onClick_btnDecision";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShichosonSelector";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType() + "_" + fieldName;
            }

            public ShichosonSelector(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShichoson(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShichoson"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

            public btnDecision(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDecision"));
            }

        }

     }

}

