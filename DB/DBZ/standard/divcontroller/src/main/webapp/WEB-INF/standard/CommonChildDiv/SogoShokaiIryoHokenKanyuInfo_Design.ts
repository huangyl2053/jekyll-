/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiIryoHokenKanyuInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiIryoHokenKanyuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiIryoHokenKanyuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgSogoShokaiHokenKanyuList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSogoShokaiHokenKanyuList"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

