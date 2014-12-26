/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module JukyushaIdoRenrakuhyoSakuseiErrorList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyushaIdoRenrakuhyoSakuseiErrorList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyoSakuseiErrorList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyoSakuseiErrorList.Controls.myType() + "_" + fieldName;
            }

            public JukyushaIdoRenrakuhyoSakuseiErrorList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblErrorList(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblErrorList"));
            }

            public dgErrorList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgErrorList"));
            }

            public lblTeiseiList(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTeiseiList"));
            }

            public dgTeiseiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTeiseiList"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

