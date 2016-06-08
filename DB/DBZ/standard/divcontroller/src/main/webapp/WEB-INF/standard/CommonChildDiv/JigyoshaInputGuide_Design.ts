/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JigyoshaInputGuide {

        export class Events {

            public static onClick_btnSearchJigyosha(): string {
                return "onClick_btnSearchJigyosha";
            }

            public static onSelectBySelectButton_dgSearchResultJigyosha(): string {
                return "onSelectBySelectButton_dgSearchResultJigyosha";
            }

            public static onClick_btnKaigoHokenShisetsuReturn(): string {
                return "onClick_btnKaigoHokenShisetsuReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JigyoshaInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType() + "_" + fieldName;
            }

            public JigyoshaInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radJigyoshaSearchType(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJigyoshaSearchType"));
            }

            public txtJigyoshaCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));
            }

            public btnSearchJigyosha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            }

            public SearchResultJigyosha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchResultJigyosha"));
            }

            public dgSearchResultJigyosha(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultJigyosha"));
            }

            public btnKaigoHokenShisetsuReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKaigoHokenShisetsuReturn"));
            }

        }

     }

}

