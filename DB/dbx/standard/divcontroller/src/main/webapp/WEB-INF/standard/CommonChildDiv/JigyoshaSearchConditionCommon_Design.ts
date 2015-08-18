/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module JigyoshaSearchConditionCommon {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JigyoshaSearchConditionCommon";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.JigyoshaSearchConditionCommon.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.JigyoshaSearchConditionCommon.Controls.myType() + "_" + fieldName;
            }

            public JigyoshaSearchConditionCommon(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSearchJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtSearchJigyoshaNo"));
            }

            public txtSearchJigyoshaKaishiDateRange(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchJigyoshaKaishiDateRange"));
            }

            public txtSearchJigyoshaMeiOrKanaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSearchJigyoshaMeiOrKanaMeisho"));
            }

            public ddlSearchMeishoMatchCondition(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSearchMeishoMatchCondition"));
            }

            public txtSearchYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtSearchYubinNo"));
            }

            public txtSearchJusho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSearchJusho"));
            }

        }

     }

}

