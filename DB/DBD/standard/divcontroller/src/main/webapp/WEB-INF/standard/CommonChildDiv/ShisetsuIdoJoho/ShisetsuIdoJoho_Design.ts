/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ShisetsuIdoJoho {

        export class Events {

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuIdoJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.ShisetsuIdoJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.ShisetsuIdoJoho.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuIdoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShisetsuIdoJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuIdoJoho"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

