/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module ServiceTeikyoShomeishoGokei {

        export class Events {

            public static onClick_btnServiceTeikyoShomeishoGokeiReturn(): string {
                return "onClick_btnServiceTeikyoShomeishoGokeiReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceTeikyoShomeishoGokei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoGokei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoGokei.Controls.myType() + "_" + fieldName;
            }

            public ServiceTeikyoShomeishoGokei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            }

            public txtHokengaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokengaku"));
            }

            public txtFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            }

            public txtRyoyohi(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRyoyohi"));
            }

            public txtShinryohi(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShinryohi"));
            }

            public txtShokujihi(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokujihi"));
            }

            public btnServiceTeikyoShomeishoGokeiReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnServiceTeikyoShomeishoGokeiReturn"));
            }

        }

     }

}

