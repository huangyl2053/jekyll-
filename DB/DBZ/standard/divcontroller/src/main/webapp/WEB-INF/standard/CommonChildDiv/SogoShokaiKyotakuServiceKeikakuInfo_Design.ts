/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiKyotakuServiceKeikakuInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiKyotakuServiceKeikakuInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiKyotakuServiceKeikakuInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiKyotakuServiceKeikakuInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiKyotakuServiceKeikakuInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKeikakuTodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuTodokedeYMD"));
            }

            public txtKeikakuHenkoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuHenkoYMD"));
            }

            public txtKeikakuJigyoshaShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaShurui"));
            }

            public txtKeikakuJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKeikakuJigyoshaNo"));
            }

            public txtKeikakuJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaName"));
            }

            public txtKeikakuServiceShurui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuServiceShurui"));
            }

            public txtKeikakuSakuseiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            }

            public txtKeikakuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuYM"));
            }

            public txtKeikakuKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeikakuKikan"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

