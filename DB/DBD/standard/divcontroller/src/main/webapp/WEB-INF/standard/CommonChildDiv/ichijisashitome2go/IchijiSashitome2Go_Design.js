var DBD;
(function (DBD) {
    (function (IchijiSashitome2Go) {
        var Events = (function () {
            function Events() {
            }
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

            Controls.prototype.txtNigoYokokushaTorokuBenmeishoTeishutsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuBenmeishoTeishutsuKigen"));
            };

            Controls.prototype.txtNigoYokokushaTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoYokokushaTorokuTsuchiHakkobi"));
            };

            Controls.prototype.txtNigoBenmeishoJuriBenmeishoUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoBenmeishoJuriBenmeishoUketsukebi"));
            };

            Controls.prototype.ddlNigoBenmeishoJuriBenmeiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiRiyu"));
            };

            Controls.prototype.txtNigoBenmeishoJuriBenmeiNaiyoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoBenmeishoJuriBenmeiNaiyoKetteibi"));
            };

            Controls.prototype.ddlNigoBenmeishoJuriBenmeiShinsakekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoBenmeishoJuriBenmeiShinsakekka"));
            };

            Controls.prototype.txtNigoIchijiSashitomeTorokuSashitomeKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuSashitomeKetteibi"));
            };

            Controls.prototype.txtNigoIchijiSashitomeTorokuHokenshoTeishitsuKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuHokenshoTeishitsuKigen"));
            };

            Controls.prototype.txtNigoIchijiSashitomeTorokuTsuchiHakkobi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeTorokuTsuchiHakkobi"));
            };

            Controls.prototype.txtNigoIchijiSashitomeKaijoIraiUketsukebi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraiUketsukebi"));
            };

            Controls.prototype.ddlNigoIchijiSashitomeKaijoIraiRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoIchijiSashitomeKaijoIraiRiyu"));
            };

            Controls.prototype.txtNigoIchijiSashitomeKaijoIraibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraibi"));
            };

            Controls.prototype.txtNigoIchijiSashitomeKaijoIraiNaiyoKetteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNigoIchijiSashitomeKaijoIraiNaiyoKetteibi"));
            };

            Controls.prototype.ddlNigoIchijiSashitomeKaijoIraiChosaKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNigoIchijiSashitomeKaijoIraiChosaKekka"));
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
