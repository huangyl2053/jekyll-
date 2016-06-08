/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ServiceInputGuide {

        export class Events {

            public static onClick_btnSearchJigyosha(): string {
                return "onClick_btnSearchJigyosha";
            }

            public static onSelectBySelectButton_SearchResultService(): string {
                return "onSelectBySelectButton_SearchResultService";
            }

            public static onClick_btnServiceInputGuideReturn(): string {
                return "onClick_btnServiceInputGuideReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType() + "_" + fieldName;
            }

            public ServiceInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtServiceShuruiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            }

            public txtServiceCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            }

            public txtKijyunYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKijyunYM"));
            }

            public btnSearchJService(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchJService"));
            }

            public SearchResultService(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchResultService"));
            }

            public dgSearchResultService(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultService"));
            }

            public btnServiceInputGuideReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnServiceInputGuideReturn"));
            }

        }

     }

}

