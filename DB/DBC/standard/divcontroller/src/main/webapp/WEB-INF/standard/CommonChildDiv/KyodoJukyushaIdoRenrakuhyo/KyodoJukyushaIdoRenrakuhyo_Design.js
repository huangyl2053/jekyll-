var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_onChange = function () {
                return "onClick_onChange";
            };

            Events.onClick_chkChange = function () {
                return "onClick_chkChange";
            };
            return Events;
        })();
        KyodoJukyushaIdoRenrakuhyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyodoJukyushaIdoRenrakuhyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyodoJukyushaIdoRenrakuhyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHiHokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHiHokenshaNo"));
            };

            Controls.prototype.txtTaisyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoYM"));
            };

            Controls.prototype.txtIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIdoYMD"));
            };

            Controls.prototype.txtShoKisaiHokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtShoKisaiHokenshaNo"));
            };

            Controls.prototype.radIdoKubunCode = function () {
                return new UZA.RadioButton(this.convFiledName("radIdoKubunCode"));
            };

            Controls.prototype.ddlJukyushaIdoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJukyushaIdoJiyu"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoTeisei = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoTeisei"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.txtTeiseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeiseiYMD"));
            };

            Controls.prototype.radTeiseiKubunCode = function () {
                return new UZA.RadioButton(this.convFiledName("radTeiseiKubunCode"));
            };

            Controls.prototype.lin2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            };

            Controls.prototype.chkKihonSofuAdd = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKihonSofuAdd"));
            };

            Controls.prototype.chkKihonSofuDelete = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKihonSofuDelete"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKihonPanel = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKihonPanel"));
            };

            Controls.prototype.txtKihonIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKihonIdoYMD"));
            };

            Controls.prototype.txtRirekiNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRirekiNo"));
            };

            Controls.prototype.lin3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            };

            Controls.prototype.txtHiHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHiHokenshaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtChohyoOutputJunjyoCode = function () {
                return new UZA.TextBox(this.convFiledName("txtChohyoOutputJunjyoCode"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };

            Controls.prototype.txtAddressKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtAddressKana"));
            };

            Controls.prototype.chkShokanSofuAdd = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShokanSofuAdd"));
            };

            Controls.prototype.chkShokanSofuDelete = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShokanSofuDelete"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoShokanPanel = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoShokanPanel"));
            };

            Controls.prototype.txtShokanIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShokanIdoYMD"));
            };

            Controls.prototype.txtShokanRirekiNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokanRirekiNo"));
            };

            Controls.prototype.lin4 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin4"));
            };

            Controls.prototype.txtHokenKyufuIchijiSashitomeYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHokenKyufuIchijiSashitomeYMD"));
            };

            Controls.prototype.ddlHokenkyufuIchijiSashitomeKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokenkyufuIchijiSashitomeKubun"));
            };

            Controls.prototype.txtHokenkyufuIchijiSashitomeKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenkyufuIchijiSashitomeKingaku"));
            };

            Controls.prototype.chkKogakuSofuAdd = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKogakuSofuAdd"));
            };

            Controls.prototype.chkKogakuSofuDelete = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKogakuSofuDelete"));
            };

            Controls.prototype.KyodoJukyushaIdoRenrakuhyoKogakuPanel = function () {
                return new UZA.Panel(this.convFiledName("KyodoJukyushaIdoRenrakuhyoKogakuPanel"));
            };

            Controls.prototype.txtKogakuIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuIdoYMD"));
            };

            Controls.prototype.txtKogakuRirekiNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuRirekiNo"));
            };

            Controls.prototype.lin5 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin5"));
            };

            Controls.prototype.txtSetaiShuyakuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtSetaiShuyakuNo"));
            };

            Controls.prototype.ddlSetaiShotokuKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSetaiShotokuKubun"));
            };

            Controls.prototype.ddlShotokuKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShotokuKubun"));
            };

            Controls.prototype.KogakuRadioBtnPanel = function () {
                return new UZA.Panel(this.convFiledName("KogakuRadioBtnPanel"));
            };

            Controls.prototype.radRoureiFukushiNenkinJukyuAriFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radRoureiFukushiNenkinJukyuAriFlag"));
            };

            Controls.prototype.radRiyoshaFutan2DankaiAriFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radRiyoshaFutan2DankaiAriFlag"));
            };

            Controls.prototype.radShikyuShinseishoOutputAriFlag = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuShinseishoOutputAriFlag"));
            };
            return Controls;
        })();
        KyodoJukyushaIdoRenrakuhyo.Controls = Controls;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
