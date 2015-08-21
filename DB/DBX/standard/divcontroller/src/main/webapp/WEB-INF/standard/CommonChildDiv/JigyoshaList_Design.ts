/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module JigyoshaList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JigyoshaList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.JigyoshaList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.JigyoshaList.Controls.myType() + "_" + fieldName;
            }

            public JigyoshaList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            }

            public dgJigyoshaList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJigyoshaList"));
            }

        }

     }

}

