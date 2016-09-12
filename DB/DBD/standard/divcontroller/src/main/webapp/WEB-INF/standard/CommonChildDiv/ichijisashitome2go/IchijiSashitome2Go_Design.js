var DBD;
(function (DBD) {
    (function (IchijiSashitome2Go) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnKakutei = function () {
                return "onClick_BtnKakutei";
            };

            Events.onClick_BtnTorikeshi = function () {
                return "onClick_BtnTorikeshi";
            };
            return Events;
        })();
        IchijiSashitome2Go.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IchijiSashitome2Go";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.IchijiSashitome2Go.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.IchijiSashitome2Go.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IchijiSashitome2Go = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TorokuJokyo = function () {
                return new UZA.Panel(this.convFiledName("TorokuJokyo"));
            };

            Controls.prototype.txtTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtTorokuJokyo"));
            };

            Controls.prototype.txtTekiyoKaishi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoKaishi"));
            };

            Controls.prototype.txtTekiyoShuryo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoShuryo"));
            };

            Controls.prototype.ddlShuryoJokyo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShuryoJokyo"));
            };

            Controls.prototype.linTorokuTorokuJokyo = function () {
                return new UZA.HorizontalLine(this.convFiledName("linTorokuTorokuJokyo"));
            };

            Controls.prototype.txtNigoYokokushaTorokuIraiJuribi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuIraiJuribi"));
            };

            Controls.prototype.txtNigoYokokushaTorokuYokokuTorokubi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuYokokuTorokubi"));
            };

            Controls.prototype.txtBemmeishoTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBemmeishoTeishutsuKigenYMD"));
            };

            Controls.prototype.txtYokokuTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYokokuTsuchiHakkoYMD"));
            };

            Controls.prototype.txtNigoBenmeishoJuriBenmeishoUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoBenmeishoJuriBenmeishoUketsukebi"));
            };

            Controls.prototype.ddlNigoBenmeishoJuriBenmeiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiRiyu"));
            };

            Controls.prototype.txtBemmeiNaiyoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBemmeiNaiyoKetteiYMD"));
            };

            Controls.prototype.ddlNigoBenmeishoJuriBenmeiShinsakekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiShinsakekka"));
            };

            Controls.prototype.txtSashitomeKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeKetteiYMD"));
            };

            Controls.prototype.txtHokenshaTeishutsuKigenYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHokenshaTeishutsuKigenYMD"));
            };

            Controls.prototype.txtSashitomeTsuchiHakkoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSashitomeTsuchiHakkoYMD"));
            };

            Controls.prototype.txtIraiUketsukeYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiUketsukeYMD"));
            };

            Controls.prototype.ddlIraiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIraiRiyu"));
            };

            Controls.prototype.txtIraiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiYMD"));
            };

            Controls.prototype.txtIraiNaiyoKetteiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiNaiyoKetteiYMD"));
            };

            Controls.prototype.ddlIraiShinsaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIraiShinsaKekka"));
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
        IchijiSashitome2Go.Controls = Controls;
    })(DBD.IchijiSashitome2Go || (DBD.IchijiSashitome2Go = {}));
    var IchijiSashitome2Go = DBD.IchijiSashitome2Go;
})(DBD || (DBD = {}));
