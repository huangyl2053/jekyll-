/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ServiceCodeCommonChildDiv {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceCodeCommonChildDiv";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ServiceCodeCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ServiceCodeCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ServiceCodeCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            }

            public txtKijunYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYM"));
            }

            public btnServiceCodeKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnServiceCodeKensaku"));
            }

            public dgCodeIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgCodeIchiran"));
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

