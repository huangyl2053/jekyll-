/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />
// <reference path="./KyufugakuSummary.ts" />

module DBC {

     export module JutakuKaishuJizenShinseiTab {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JutakuKaishuJizenShinseiTab";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinseiTab.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinseiTab.Controls.myType() + "_" + fieldName;
            }

            public JutakuKaishuJizenShinseiTab(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tabJizenShinsei(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabJizenShinsei"));
            }

            public tplJizenShinseiContents(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiContents"));
            }

            public txtJutakuOwner(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            }

            public txtRelationWithHihokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            }

            public dgJutakuKaishuJizenShinseiDetail(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            }

            //public JutakuKaishuJizenShinseisha(): DBZ.ShinseishaInfo.ModeController {
            //    return new DBZ.ShinseishaInfo.ModeController(this.convFiledName("JutakuKaishuJizenShinseisha"));
            //}

            public JutakuKaishuJizenShinseiReasonForTab(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiReasonForTab"));
            }

            public txtCreateDate(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            }

            public txtCreatorKanaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            }

            public txtCreatorName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            }

            public txtCreationJigyoshaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            }

            public txtCreationJigyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            }

            public tplJizenShinseiResult(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiResult"));
            }

            //public JutakuKaishuJizenShinseiKyufugakuSummary(): DBC.KyufugakuSummary.ModeController {
            //    return new DBC.KyufugakuSummary.ModeController(this.convFiledName("JutakuKaishuJizenShinseiKyufugakuSummary"));
            //}

            public hl(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("hl"));
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

            public chkResetInfo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            }

            public tplJizenShinseiPayMethod(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiPayMethod"));
            }

            //public PaymentMethod(): DBZ.PaymentMethod.ModeController {
            //    return new DBZ.PaymentMethod.ModeController(this.convFiledName("PaymentMethod"));
            //}

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

