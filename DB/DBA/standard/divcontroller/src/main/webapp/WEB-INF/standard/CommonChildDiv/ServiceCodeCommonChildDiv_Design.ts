/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBA {

     export module ServiceCodeCommonChildDiv {

        export class Events {

            public static onClick_Kensaku(): string {
                return "onClick_Kensaku";
            }

            public static onClick_btnYameru(): string {
                return "onClick_btnYameru";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

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
                return this._myName + "_" + DBA.ServiceCodeCommonChildDiv.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBA.ServiceCodeCommonChildDiv.Controls.myType() + "_" + fieldName;
            }

            public ServiceCodeCommonChildDiv(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            }

            public txtKomokuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKomokuCode"));
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

