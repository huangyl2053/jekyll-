/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShichosonSelector {

        export class Events {

            public static onClick_radShichosonKubun(): string {
                return "onClick_radShichosonKubun";
            }

            public static onClick_modoru(): string {
                return "onClick_modoru";
            }

            public static onClick_sentaku(): string {
                return "onClick_sentaku";
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

            public radShichosonKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShichosonKubun"));
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

