/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module OtherTokureiShisetsuInputGuide {

        export class Events {

            public static onClick_btnSearchOtherShisetsu(): string {
                return "onClick_btnSearchOtherShisetsu";
            }

            public static onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu(): string {
                return "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu";
            }

            public static onClick_btnOtherShisetsuReturn(): string {
                return "onClick_btnOtherShisetsuReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "OtherTokureiShisetsuInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            }

            public OtherTokureiShisetsuInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public radKannaiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKannaiKubun"));
            }

            public btnSearchOtherShisetsu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchOtherShisetsu"));
            }

            public lblOtherShisetsuShurui(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblOtherShisetsuShurui"));
            }

            public SearchResultOtherShisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchResultOtherShisetsu"));
            }

            public dgSearchResultOtherTokureiShisetsu(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOtherTokureiShisetsu"));
            }

            public btnOtherShisetsuReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOtherShisetsuReturn"));
            }

        }

     }

}

