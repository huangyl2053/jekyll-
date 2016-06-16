/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KogakuShinseiList {

        export class Events {

            public static onMulti_dgKyufuJissekiMeisaiList(): string {
                return "onMulti_dgKyufuJissekiMeisaiList";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuShinseiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KogakuShinseiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KogakuShinseiList.Controls.myType() + "_" + fieldName;
            }

            public KogakuShinseiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceYM(): UZA.TextBoxYearMonth {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYM"));
            }

            public txtShokisai(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisai"));
            }

            public btnShinseiJohoTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShinseiJohoTsuika"));
            }

            public btnTaishosyaJoho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTaishosyaJoho"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public txtServiceYMFrom(): UZA.TextBoxYearMonth {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYMFrom"));
            }

            public txtServiceYMTo(): UZA.TextBoxYearMonth {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYMTo"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public dgShinseiJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinseiJoho"));
            }

        }

     }

}

