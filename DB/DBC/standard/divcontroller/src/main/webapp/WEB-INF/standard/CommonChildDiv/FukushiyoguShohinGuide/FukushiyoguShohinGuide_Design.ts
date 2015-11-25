/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module FukushiyoguShohinGuide {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "FukushiyoguShohinGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.FukushiyoguShohinGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.FukushiyoguShohinGuide.Controls.myType() + "_" + fieldName;
            }

            public FukushiyoguShohinGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKijunDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunDay"));
            }

            public btnSelect(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelect"));
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgFukushiyoguShohin(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFukushiyoguShohin"));
            }

            public panInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("panInput"));
            }

            public txtKanriKaishiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKanriKaishiDay"));
            }

            public txtKanriShuryoDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKanriShuryoDay"));
            }

            public txtShohinmei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShohinmei"));
            }

            public txtHinmokuCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHinmokuCode"));
            }

            public txtSeizoJigyoshamei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyoshamei"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

