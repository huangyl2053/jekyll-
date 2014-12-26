/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./KyufugakuSummary.ts" />
/// <reference path="./ShinseishaInfo.ts" />

module DBC {

     export module JutakuKaishuJizenShinsei {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JutakuKaishuJizenShinsei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinsei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinsei.Controls.myType() + "_" + fieldName;
            }

            public JutakuKaishuJizenShinsei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public JutakuKaishuJizenShinseiContents(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents"));
            }

            public txtJutakuOwner(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            }

            public txtRelationWithHihokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            }

            public JutakuKaishuZizenShinseiDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuZizenShinseiDetail"));
            }

            public dgJutakuKaishuJizenShinseiDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            }

            public JutakuKaishuJizenShinseiKyufugakuSummary(): DBC.KyufugakuSummary.ModeController {
                return new DBC.KyufugakuSummary.ModeController(this.convFiledName("JutakuKaishuJizenShinseiKyufugakuSummary"));
            }

            public JutakuKaishuJizenShinseiSha(): DBC.ShinseishaInfo.ModeController {
                return new DBC.ShinseishaInfo.ModeController(this.convFiledName("JutakuKaishuJizenShinseiSha"));
            }

            public JutakuKaishuJizenShinseiReason(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuJizenShinseiReason"));
            }

            public txtCreateDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            }

            public txtCreationJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            }

            public btnSearchCreationJigyoshaName(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSearchCreationJigyoshaName"));
            }

            public txtCreationJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            }

            public txtCreatorKanaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            }

            public txtCreatorName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            }

            public JutakuKaishuJizenShinseiKozaInfoMock(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuJizenShinseiKozaInfoMock"));
            }

            public txtKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            }

            public txtKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            }

            public radKozaType(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaType"));
            }

            public txtKozaMeigininKanaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKanaName"));
            }

            public txtKinyuBranchCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuBranchCode"));
            }

            public txtKinyuBranchName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinyuBranchName"));
            }

            public txtKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            }

            public txtKozaMeigininName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininName"));
            }

            public JutakuKaishuJizenShinseiResult(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult"));
            }

            public JutakuKaishuJizenShinseiShinsaResult(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult_JutakuKaishuJizenShinseiShinsaResult"));
            }

            public txtJudgeDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJudgeDate"));
            }

            public radJudgeKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJudgeKubun"));
            }

            public txtShoninCondition(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShoninCondition"));
            }

            public txtFushoninReason(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninReason"));
            }

            public JutakuKaishuJizenShinseiResetInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult_JutakuKaishuJizenShinseiResetInfo"));
            }

            public chkResetInfo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            }

            public JutakuKaishuJizenShoninKetteiTsuchisho(): UZA.PanelPublish {
                return new UZA.PanelPublish(this.convFiledName("JutakuKaishuJizenShoninKetteiTsuchisho"));
            }

            public txtHakkoDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoDate"));
            }

        }

     }

}

