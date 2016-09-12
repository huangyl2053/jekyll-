var DBC;
(function (DBC) {
    (function (KogakuServicehiDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtJotai = function () {
                return new UZA.TextBox(this.convFiledName("txtJotai"));
            };

            Controls.prototype.txtKanriBango = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKanriBango"));
            };

            Controls.prototype.tabKogakuServicehiDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            };

            Controls.prototype.tplShinseisha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.rdbShinseisyaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbShinseisyaKubun"));
            };

            Controls.prototype.txtHokenJyaBango = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenJyaBango"));
            };

            Controls.prototype.chkKokuhorenSaiso = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKokuhorenSaiso"));
            };

            Controls.prototype.txtShimeiKanji = function () {
                return new UZA.TextBox(this.convFiledName("txtShimeiKanji"));
            };

            Controls.prototype.txtShimeiKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtShimeiKana"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.txtShiharaiTotalAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            };

            Controls.prototype.txtKotei = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKotei"));
            };

            Controls.prototype.tplKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            };

            Controls.prototype.tplJudgementResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            };

            Controls.prototype.txtUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            };

            Controls.prototype.txtHonninShiharaiGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninShiharaiGaku"));
            };

            Controls.prototype.txtKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYMD"));
            };

            Controls.prototype.rdbShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbShikyuKubun"));
            };

            Controls.prototype.rdbShinsaHohoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbShinsaHohoKubun"));
            };

            Controls.prototype.txtSetaiSyuyakuBango = function () {
                return new UZA.TextBox(this.convFiledName("txtSetaiSyuyakuBango"));
            };

            Controls.prototype.txtShikyuKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuKingaku"));
            };

            Controls.prototype.rdbKogakuJidoSyokanTaisyo = function () {
                return new UZA.RadioButton(this.convFiledName("rdbKogakuJidoSyokanTaisyo"));
            };

            Controls.prototype.txtShikyusinaiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShikyusinaiRiyu"));
            };

            Controls.prototype.tplKetteiJoho = function () {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            };

            Controls.prototype.KokuhorenKetteiJohoPanel1 = function () {
                return new UZA.Panel(this.convFiledName("KokuhorenKetteiJohoPanel1"));
            };

            Controls.prototype.txtTsuchiBango = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTsuchiBango"));
            };

            Controls.prototype.txtShikyuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShikyuKubun"));
            };

            Controls.prototype.txtKetteiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYM"));
            };

            Controls.prototype.txtShiharaiKingakuGokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiKingakuGokei"));
            };

            Controls.prototype.txtKogakuShikyuGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyuGaku"));
            };

            Controls.prototype.SakuseiPanel = function () {
                return new UZA.Panel(this.convFiledName("SakuseiPanel"));
            };

            Controls.prototype.KokuhorenKetteiJohoPanel2 = function () {
                return new UZA.Panel(this.convFiledName("KokuhorenKetteiJohoPanel2"));
            };

            Controls.prototype.txtSakuseiYMD1 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD1"));
            };

            Controls.prototype.FurikomiMeisaiJohoPanel = function () {
                return new UZA.Panel(this.convFiledName("FurikomiMeisaiJohoPanel"));
            };

            Controls.prototype.txtSakuseiYMD2 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD2"));
            };

            Controls.prototype.KokuhorenSoufuJohoPanel = function () {
                return new UZA.Panel(this.convFiledName("KokuhorenSoufuJohoPanel"));
            };

            Controls.prototype.txtTaisyoUketoriYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaisyoUketoriYM"));
            };

            Controls.prototype.txtKekkaSoufuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKekkaSoufuYM"));
            };

            Controls.prototype.txtKetteiSyaUketoriYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiSyaUketoriYM"));
            };
            return Controls;
        })();
        KogakuServicehiDetail.Controls = Controls;
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));
