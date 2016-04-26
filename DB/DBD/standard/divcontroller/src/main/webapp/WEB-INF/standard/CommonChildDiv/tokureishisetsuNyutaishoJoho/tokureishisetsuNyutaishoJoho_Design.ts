/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module tokureishisetsuNyutaishoJoho {

        export class Events {

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "tokureishisetsuNyutaishoJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.tokureishisetsuNyutaishoJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.tokureishisetsuNyutaishoJoho.Controls.myType() + "_" + fieldName;
            }

            public tokureishisetsuNyutaishoJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgtokureishisetsuNyutaishoJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgtokureishisetsuNyutaishoJoho"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

