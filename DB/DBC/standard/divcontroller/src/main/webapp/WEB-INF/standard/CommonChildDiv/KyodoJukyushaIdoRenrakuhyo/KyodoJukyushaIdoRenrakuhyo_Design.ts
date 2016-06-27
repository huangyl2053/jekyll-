/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KyodoJukyushaIdoRenrakuhyo {

        export class Events {

            public static onClick_onChange(): string {
                return "onClick_onChange";
            }

            public static onClick_chkChange(): string {
                return "onClick_chkChange";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyodoJukyushaIdoRenrakuhyo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            }

            public KyodoJukyushaIdoRenrakuhyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHiHokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHiHokenshaNo"));
            }

            public txtTaisyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoYM"));
            }

            public txtIdoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtIdoYMD"));
            }

            public txtShoKisaiHokenshaNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShoKisaiHokenshaNo"));
            }

            public radIdoKubunCode(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdoKubunCode"));
            }

            public ddlJukyushaIdoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJukyushaIdoJiyu"));
            }

            public KyodoJukyushaIdoRenrakuhyoTeisei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public txtTeiseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeiseiYMD"));
            }

            public radTeiseiKubunCode(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeiseiKubunCode"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            }

            public chkKihonSofuAdd(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKihonSofuAdd"));
            }

            public chkKihonSofuDelete(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKihonSofuDelete"));
            }

            public KyodoJukyushaIdoRenrakuhyoKihonPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihonPanel"));
            }

            public txtKihonIdoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKihonIdoYMD"));
            }

            public txtRirekiNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRirekiNo"));
            }

            public lin3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            }

            public txtHiHokenshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHiHokenshaName"));
            }

            public txtTelNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            }

            public txtChohyoOutputJunjyoCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChohyoOutputJunjyoCode"));
            }

            public txtYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            }

            public txtAddress(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            }

            public txtAddressKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtAddressKana"));
            }

            public chkShokanSofuAdd(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShokanSofuAdd"));
            }

            public chkShokanSofuDelete(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShokanSofuDelete"));
            }

            public KyodoJukyushaIdoRenrakuhyoShokanPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokanPanel"));
            }

            public txtShokanIdoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShokanIdoYMD"));
            }

            public txtShokanRirekiNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokanRirekiNo"));
            }

            public lin4(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin4"));
            }

            public txtHokenKyufuIchijiSashitomeYMD(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHokenKyufuIchijiSashitomeYMD"));
            }

            public ddlHokenkyufuIchijiSashitomeKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokenkyufuIchijiSashitomeKubun"));
            }

            public txtHokenkyufuIchijiSashitomeKingaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenkyufuIchijiSashitomeKingaku"));
            }

            public chkKogakuSofuAdd(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKogakuSofuAdd"));
            }

            public chkKogakuSofuDelete(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKogakuSofuDelete"));
            }

            public KyodoJukyushaIdoRenrakuhyoKogakuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogakuPanel"));
            }

            public txtKogakuIdoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuIdoYMD"));
            }

            public txtKogakuRirekiNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuRirekiNo"));
            }

            public lin5(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin5"));
            }

            public txtSetaiShuyakuNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSetaiShuyakuNo"));
            }

            public ddlSetaiShotokuKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSetaiShotokuKubun"));
            }

            public ddlShotokuKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShotokuKubun"));
            }

            public KogakuRadioBtnPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuRadioBtnPanel"));
            }

            public radRoureiFukushiNenkinJukyuAriFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRoureiFukushiNenkinJukyuAriFlag"));
            }

            public radRiyoshaFutan2DankaiAriFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutan2DankaiAriFlag"));
            }

            public radShikyuShinseishoOutputAriFlag(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShikyuShinseishoOutputAriFlag"));
            }

        }

     }

}

