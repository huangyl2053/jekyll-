var DBD;
(function (DBD) {
    (function (ShokanBaraiKa1Go) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClose_BtnTainoJokyo = function () {
                return "onOkClose_BtnTainoJokyo";
            };

            Events.onBeforeOpenDialog_BtnTainoJokyo = function () {
                return "onBeforeOpenDialog_BtnTainoJokyo";
            };

            Events.onClick_BtnKakutei = function () {
                return "onClick_BtnKakutei";
            };

            Events.onClick_BtnTorikeshi = function () {
                return "onClick_BtnTorikeshi";
            };
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

            Controls.prototype.TorokuJokyo = function () {
                return new UZA.Panel(this.convFiledName("TorokuJokyo"));
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

            Controls.prototype.ddlShuryoJokyo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShuryoJokyo"));
            };

            Controls.prototype.linTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuJokyo"));
            };

            Controls.prototype.UketsukeKetteibi = function () {
                return new UZA.Panel(this.convFiledName("UketsukeKetteibi"));
            };

            Controls.prototype.txtIraiJuriYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiJuriYMD"));
            };

            Controls.prototype.txtYokokuTorokuYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokokuTorokuYMD"));
            };

            Controls.prototype.txtBemmeishoTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBemmeishoTeishutsuKigenYMD"));
            };

            Controls.prototype.txtYokokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokokuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtBemmeiUketsukeYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBemmeiUketsukeYMD"));
            };

            Controls.prototype.ddlBemmeiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBemmeiRiyu"));
            };

            Controls.prototype.txtBemmeiNaiyoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBemmeiNaiyoKetteiYMD"));
            };

            Controls.prototype.ddlBemmeiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBemmeiShinsaKekka"));
            };

            Controls.prototype.txtHenkoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoKetteiYMD"));
            };

            Controls.prototype.txtHokenshoTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHokenshoTeishutsuKigenYMD"));
            };

            Controls.prototype.txtHenkoTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTsuchiHakkoYMD"));
            };

            Controls.prototype.txtShinseiUketsukeYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiUketsukeYMD"));
            };

            Controls.prototype.ddlShinseiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiRiyu"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtShinseiNaiyoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiNaiyoKetteiYMD"));
            };

            Controls.prototype.ddlShinseiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiShinsaKekka"));
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
