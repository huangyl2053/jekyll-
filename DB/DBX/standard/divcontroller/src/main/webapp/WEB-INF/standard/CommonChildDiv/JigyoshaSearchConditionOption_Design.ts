/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBX {

     export module JigyoshaSearchConditionOption {

        export class Events {

            public static onClick_radIncludeKyushiHaishi(): string {
                return "onClick_radIncludeKyushiHaishi";
            }

            public static onClick_radShowRireki(): string {
                return "onClick_radShowRireki";
            }

            public static onClick_btnSearch(): string {
                return "onClick_btnSearch";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JigyoshaSearchConditionOption";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.JigyoshaSearchConditionOption.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.JigyoshaSearchConditionOption.Controls.myType() + "_" + fieldName;
            }

            public JigyoshaSearchConditionOption(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public chkOutputKyushiHaishi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkOutputKyushiHaishi"));
            }

            public chkOutputShisetsuRireki(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkOutputShisetsuRireki"));
            }

            public txtMaxNum(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNum"));
            }

            public btnSearchShisetsu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchShisetsu"));
            }

        }

     }

}

