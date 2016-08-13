/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="./ShiharaiHohoJyoho/ShiharaiHohoJyoho.ts" />
// <reference path="./KogakuKyufuTaishoList/KogakuKyufuTaishoList.ts" />

module DBC {

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
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            }

            public KogakuServicehiDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            }

            public txtJotai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJotai"));
            }

            public txtKanriBango(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKanriBango"));
            }

            public tabKogakuServicehiDetail(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            }

            public tplShinseisha(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            }

            public txtShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            }

            public rdbShinseisyaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbShinseisyaKubun"));
            }

            public txtHokenJyaBango(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenJyaBango"));
            }

            public chkKokuhorenSaiso(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKokuhorenSaiso"));
            }

            public txtShimeiKanji(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimeiKanji"));
            }

            public txtShimeiKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtShimeiKana"));
            }

            public txtTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            }

            public txtShinseiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            }

            public txtShiharaiTotalAmount(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            }

            public txtKotei(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKotei"));
            }

            public tplKoza(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            }

            //public ccdShiharaiHohoJyoho(): DBC.ShiharaiHohoJyoho.ModeController {
            //    return new DBC.ShiharaiHohoJyoho.ModeController(this.convFiledName("ccdShiharaiHohoJyoho"));
            //}

            public tplJudgementResult(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            }

            //public ccdKogakuKyufuTaishoList(): DBC.KogakuKyufuTaishoList.ModeController {
            //    return new DBC.KogakuKyufuTaishoList.ModeController(this.convFiledName("ccdKogakuKyufuTaishoList"));
            //}

            public txtUketsukeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            }

            public txtHonninShiharaiGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninShiharaiGaku"));
            }

            public txtKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYMD"));
            }

            public rdbShikyuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbShikyuKubun"));
            }

            public rdbShinsaHohoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbShinsaHohoKubun"));
            }

            public txtSetaiSyuyakuBango(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSetaiSyuyakuBango"));
            }

            public txtShikyuKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuKingaku"));
            }

            public rdbKogakuJidoSyokanTaisyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbKogakuJidoSyokanTaisyo"));
            }

            public txtShikyusinaiRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShikyusinaiRiyu"));
            }

            public tplKetteiJoho(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            }

            public KokuhorenKetteiJohoPanel1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokuhorenKetteiJohoPanel1"));
            }

            public txtTsuchiBango(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTsuchiBango"));
            }

            public txtShikyuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShikyuKubun"));
            }

            public txtKetteiYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYM"));
            }

            public txtShiharaiKingakuGokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiKingakuGokei"));
            }

            public txtKogakuShikyuGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyuGaku"));
            }

            public SakuseiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SakuseiPanel"));
            }

            public KokuhorenKetteiJohoPanel2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokuhorenKetteiJohoPanel2"));
            }

            public txtSakuseiYMD1(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD1"));
            }

            public FurikomiMeisaiJohoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FurikomiMeisaiJohoPanel"));
            }

            public txtSakuseiYMD2(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD2"));
            }

            public KokuhorenSoufuJohoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KokuhorenSoufuJohoPanel"));
            }

            public txtTaisyoUketoriYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoUketoriYM"));
            }

            public txtKekkaSoufuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKekkaSoufuYM"));
            }

            public txtKetteiSyaUketoriYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiSyaUketoriYM"));
            }

        }

     }

}

