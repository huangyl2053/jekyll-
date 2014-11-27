/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShinseishaInfo.ts" />
/// <reference path="./PaymentMethod.ts" />
/// <reference path="./KogakuServicehiJudgementResult.ts" />

module DBZ {

     export module KogakuServicehiDetail {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuServicehiDetail";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            }

            public KogakuServicehiDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            }

            public tabKogakuServicehiDetail(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            }

            public tplShinseisha(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            }

            public Shinseisha(): DBZ.ShinseishaInfo.ModeController {
                return new DBZ.ShinseishaInfo.ModeController(this.convFiledName("Shinseisha"));
            }

            public txtShiharaiTotalAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            }

            public txtShinseiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            }

            public tplKoza(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            }

            public PaymentMethod(): DBZ.PaymentMethod.ModeController {
                return new DBZ.PaymentMethod.ModeController(this.convFiledName("PaymentMethod"));
            }

            public tplJudgementResult(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            }

            public JudgementResult(): DBZ.KogakuServicehiJudgementResult.ModeController {
                return new DBZ.KogakuServicehiJudgementResult.ModeController(this.convFiledName("JudgementResult"));
            }

            public tplKetteiJoho(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            }

        }

     }

}

