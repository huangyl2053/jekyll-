var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKogakuKaigoServicehiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKogakuKaigoServicehiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKogakuTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTeikyoYM"));
            };

            Controls.prototype.txtKogakuShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuShinseiYMD"));
            };

            Controls.prototype.txtKogakuShiharaigaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShiharaigaku"));
            };

            Controls.prototype.txtKogakuShiharaiHoho = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShiharaiHoho"));
            };

            Controls.prototype.txtKogakuKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKinyuKikanCode"));
            };

            Controls.prototype.txtKogakuKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKinyuKikanName"));
            };

            Controls.prototype.txtKogakuKozaShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaShubetsu"));
            };

            Controls.prototype.txtKogakuKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaMeiginin"));
            };

            Controls.prototype.txtKogakuShitenCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuShitenCode"));
            };

            Controls.prototype.txtKogakuShitenName = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShitenName"));
            };

            Controls.prototype.txtKogakuKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKozaNo"));
            };

            Controls.prototype.txtKogakuKozaMeigininKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKogakuKozaMeigininKana"));
            };

            Controls.prototype.txtKogakuKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKetteiYMD"));
            };

            Controls.prototype.txtKogakuShikyuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShikyuKubun"));
            };

            Controls.prototype.txtKogakuShikyugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyugaku"));
            };

            Controls.prototype.txtKogakuFushikyuRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuFushikyuRiyu"));
            };

            Controls.prototype.txtKogakuSetaiShuyakuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuSetaiShuyakuNo"));
            };

            Controls.prototype.SogoShokaiKogakuKokuhorenKettei = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenKettei"));
            };

            Controls.prototype.txtKogakuKokuhorenTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenTsuchishoNo"));
            };

            Controls.prototype.txtKogakuKokuhorenShikyuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenShikyuKubun"));
            };

            Controls.prototype.txtKogakuKokuhorenKetteiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenKetteiYM"));
            };

            Controls.prototype.txtKogakuKokuhorenFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenFutangaku"));
            };

            Controls.prototype.txtKogakuKokuhorenShikyugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenShikyugaku"));
            };

            Controls.prototype.txtKogakuTsuchishoSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTsuchishoSakuseiYMD"));
            };

            Controls.prototype.SogoShokaiKogakuFurikomi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuFurikomi"));
            };

            Controls.prototype.txtKogakuFurikomiMeisaiSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiMeisaiSakuseiYMD"));
            };

            Controls.prototype.txtKogakuFurikomiShiharaiYoteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiShiharaiYoteiYMD"));
            };

            Controls.prototype.SogoShokaiKogakuKokuhorenSofu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenSofu"));
            };

            Controls.prototype.txtKogakuKokuhorenSofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenSofuYM"));
            };

            Controls.prototype.txtKogakuKokuhorenUketoriYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenUketoriYM"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.Controls = Controls;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));
