/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JukyuNinteirirekiInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JukyuNinteirirekiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JukyuNinteirirekiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JukyuNinteirirekiInfo.Controls.myType() + "_" + fieldName;
            }

            public JukyuNinteirirekiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgNinteiRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiRireki"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

