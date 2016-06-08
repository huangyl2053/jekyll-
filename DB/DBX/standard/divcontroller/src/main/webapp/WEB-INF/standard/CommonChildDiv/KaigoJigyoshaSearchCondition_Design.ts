/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./JigyoshaSearchConditionCommon.ts" />
// <reference path="./JigyoshaSearchConditionOption.ts" />

module DBX {

     export module KaigoJigyoshaSearchCondition {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoJigyoshaSearchCondition";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBX.KaigoJigyoshaSearchCondition.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBX.KaigoJigyoshaSearchCondition.Controls.myType() + "_" + fieldName;
            }

            public KaigoJigyoshaSearchCondition(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdJigyoshaSearchConditionCommon(): DBX.JigyoshaSearchConditionCommon.ModeController {
            //    return new DBX.JigyoshaSearchConditionCommon.ModeController(this.convFiledName("ccdJigyoshaSearchConditionCommon"));
            //}

            public ServiceJigyoshaSearchCondition(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceJigyoshaSearchCondition"));
            }

            public ddlSearchPrefecturesCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSearchPrefecturesCode"));
            }

            public ddlSearchJigyoshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSearchJigyoshaKubun"));
            }

            public ddlSearchToshiCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSearchToshiCode"));
            }

            public ddlSearchServiceType(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSearchServiceType"));
            }

            //public ccdJigyoshaSearchConditionOption(): DBX.JigyoshaSearchConditionOption.ModeController {
            //    return new DBX.JigyoshaSearchConditionOption.ModeController(this.convFiledName("ccdJigyoshaSearchConditionOption"));
            //}

        }

     }

}

