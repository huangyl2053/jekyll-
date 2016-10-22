/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="../../d.ts/UAXCommonChildDiv.d.ts" />
/// <reference path="../../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module HihokenshaFinder {

        export class Events {

            public static onBlur_txtMaxNumber(): string {
                return "onBlur_txtMaxNumber";
            }

            public static onClick_btnHihokenshaFinderHyoji(): string {
                return "onClick_btnHihokenshaFinderHyoji";
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

            public KaigoFinder(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoFinder"));
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

            public KaigoFinderDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaigoFinderDetail"));
            }

            public lblHihokenshaJotai(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHihokenshaJotai"));
            }

            public chkHihokenshaDaicho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokenshaDaicho"));
            }

            public chkJukyushaDaicho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJukyushaDaicho"));
            }

            public chkJushochiTokureisha(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJushochiTokureisha"));
            }

            public ccdAtenaFinder(): UAX.AtenaFinder.ModeController {
                return new UAX.AtenaFinder.ModeController(this.convFiledName("ccdAtenaFinder"));
            }

            public ButtonsForHihokenshaFinder(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            }

            public txtMaxNumber(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            }

            public ccdSaikinShorisha(): URZ.SaikinShorishaRireki.ModeController {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("ccdSaikinShorisha"));
            }

            public btnHihokenshaFinderHyoji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHihokenshaFinderHyoji"));
            }

        }

     }

}

