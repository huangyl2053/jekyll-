/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ShozokuChosainListCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShozokuChosainListCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType() + "_" + fieldName;
            }

            public ShozokuChosainListCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShozokuChosainList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShozokuChosainList"));
            }

        }

     }

}

