/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module HokenshaInputGuide {

        export class Events {

            public static onClick_btnSearchGaitoHokensha(): string {
                return "onClick_btnSearchGaitoHokensha";
            }

            public static onSelectBySelectButton_dgSearchResultHokensha(): string {
                return "onSelectBySelectButton_dgSearchResultHokensha";
            }

            public static onClick_btnHokenshaReturn(): string {
                return "onClick_btnHokenshaReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HokenshaInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType() + "_" + fieldName;
            }

            public HokenshaInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlHokenshaKenCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaKenCode"));
            }

            public btnSearchGaitoHokensha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchGaitoHokensha"));
            }

            public SearchResultHokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchResultHokensha"));
            }

            public dgSearchResultHokensha(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultHokensha"));
            }

            public btnHokenshaReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHokenshaReturn"));
            }

        }

     }

}

