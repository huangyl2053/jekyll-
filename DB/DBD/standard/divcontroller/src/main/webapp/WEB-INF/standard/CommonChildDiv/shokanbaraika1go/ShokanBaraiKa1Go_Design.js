var DBD;
(function (DBD) {
    (function (ShokanBaraiKa1Go) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShokanBaraiKa1Go.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShokanBaraiKa1Go";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.ShokanBaraiKa1Go.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.ShokanBaraiKa1Go.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShokanBaraiKa1Go = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            };

            Controls.prototype.txtTekiyoKikanKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKikanKaishi"));
            };

            Controls.prototype.txtTekiyoKikanShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKikanShuryo"));
            };

            Controls.prototype.txtShuryoJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtShuryoJokyo"));
            };

            Controls.prototype.linTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuJokyo"));
            };

            Controls.prototype.UketsukeKetteibi = function () {
                return new UZA.Panel(this.convFiledName("UketsukeKetteibi"));
            };

            Controls.prototype.txtiIchigoYokokushaTorokuIraiJuribi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtiIchigoYokokushaTorokuIraiJuribi"));
            };

            Controls.prototype.txtIchigoYokokushaTorokuYokokuTorokubi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuYokokuTorokubi"));
            };

            Controls.prototype.txtIchigoYokokushaTorokuBenmeishoTeishutsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuBenmeishoTeishutsuKigen"));
            };

            Controls.prototype.txtIchigoYokokushaTorokuTuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoYokokushaTorokuTuchiHakkobi"));
            };

            Controls.prototype.txtIchigoBenmeishoJuriBenmeiUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoBenmeishoJuriBenmeiUketsukebi"));
            };

            Controls.prototype.ddlIchigoBenmeishoJuriBenmeiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoBenmeishoJuriBenmeiRiyu"));
            };

            Controls.prototype.txtIchigoBenmeishoJuriBenmeiNaiyoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIchigoBenmeishoJuriBenmeiNaiyoKetteibi"));
            };

            Controls.prototype.ddlIchigoBenmeishoJuriBenmeiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIchigoBenmeishoJuriBenmeiShinsaKekka"));
            };

            Controls.prototype.txtShokanBaraikaTorokuHenkoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuHenkoKetteibi"));
            };

            Controls.prototype.txtShokanBaraikaTorokuHokenshoTeishutsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuHokenshoTeishutsuKigen"));
            };

            Controls.prototype.txtShokanBaraikaTorokuTuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaTorokuTuchiHakkobi"));
            };

            Controls.prototype.txtShokanBaraikaShuryoShinseiShinseiUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseiUketsukebi"));
            };

            Controls.prototype.ddlShokanBaraikaShuryoShinseiShinseiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShokanBaraikaShuryoShinseiShinseiRiyu"));
            };

            Controls.prototype.txtShokanBaraikaShuryoShinseiShinseibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseibi"));
            };

            Controls.prototype.txtShokanBaraikaShuryoShinseiShinseiNaiyoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShokanBaraikaShuryoShinseiShinseiNaiyoKetteibi"));
            };

            Controls.prototype.ddlShokanBaraikaShuryoShinseiShinseiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShokanBaraikaShuryoShinseiShinseiShinsaKekka"));
            };

            Controls.prototype.TainoJokyo = function () {
                return new UZA.Panel(this.convFiledName("TainoJokyo"));
            };

            Controls.prototype.btnTainoJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTainoJokyo"));
            };

            Controls.prototype.KakuteiTorikeshi = function () {
                return new UZA.Panel(this.convFiledName("KakuteiTorikeshi"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        ShokanBaraiKa1Go.Controls = Controls;
    })(DBD.ShokanBaraiKa1Go || (DBD.ShokanBaraiKa1Go = {}));
    var ShokanBaraiKa1Go = DBD.ShokanBaraiKa1Go;
})(DBD || (DBD = {}));
