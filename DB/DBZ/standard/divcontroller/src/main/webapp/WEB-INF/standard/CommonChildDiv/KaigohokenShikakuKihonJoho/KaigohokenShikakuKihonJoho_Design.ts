/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigohokenShikakuKihonJoho {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigohokenShikakuKihonJoho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigohokenShikakuKihonJoho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigohokenShikakuKihonJoho.Controls.myType() + "_" + fieldName;
            }

            public KaigohokenShikakuKihonJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public gdKaigoHokenShikakuKihonJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("gdKaigoHokenShikakuKihonJoho"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

