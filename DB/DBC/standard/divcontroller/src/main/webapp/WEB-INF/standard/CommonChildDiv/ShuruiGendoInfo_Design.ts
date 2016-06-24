/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ShuruiGendoInfoCommonChildDiv {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShuruiGendoInfoCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ShuruiGendoInfoCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ShuruiGendoInfoCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ShuruiGendoInfoCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgGendoInfo(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgGendoInfo"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

            public Button1(): UZA.Button {
                return new UZA.Button(this.convFiledName("Button1"));
            }

        }

     }

}

