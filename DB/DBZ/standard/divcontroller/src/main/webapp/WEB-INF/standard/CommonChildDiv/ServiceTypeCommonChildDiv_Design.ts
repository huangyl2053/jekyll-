/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ServiceTypeCommonChildDiv {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceTypeCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ServiceTypeCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ServiceTypeCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ServiceTypeCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgServiceType(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceType"));
            }

            public btnYameru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnYameru"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

