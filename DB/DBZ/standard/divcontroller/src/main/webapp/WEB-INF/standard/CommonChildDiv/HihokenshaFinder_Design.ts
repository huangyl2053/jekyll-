/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="../d.ts/URACommonChildDiv.d.ts" />
/// <reference path="./KaigoSaikinShorishaRireki.ts" />

module DBZ {

     export module HihokenshaFinder {

        export class Events {

            public static onClick_btnToClear(): string {
                return "onClick_btnToClear";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HihokenshaFinder";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType() + "_" + fieldName;
            }

            public HihokenshaFinder(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SearchCriteriaOfHihokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha"));
            }

            public ddlHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            }

            public txtHihokenshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            }

            public txtTuchishoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTuchishoNo"));
            }

            public ddlFukaNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            }

            public SearchCriteriaDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha_SearchCriteriaDetail"));
            }

            public chkHihokensha(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokensha"));
            }

            public radMinashiNigo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMinashiNigo"));
            }

            public chkMinashiNigo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiNigo"));
            }

            public KaigoAtenaFinder(): URA.AtenaFinder.ModeController {
                return new URA.AtenaFinder.ModeController(this.convFiledName("KaigoAtenaFinder"));
            }

            public ButtonsForHihokenshaFinder(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            }

            public btnToClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToClear"));
            }

            public btnToSearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            }

            public txtMaxNumber(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            }

            public saikinShorisha(): DBZ.KaigoSaikinShorishaRireki.ModeController {
                return new DBZ.KaigoSaikinShorishaRireki.ModeController(this.convFiledName("saikinShorisha"));
            }

        }

     }

}

