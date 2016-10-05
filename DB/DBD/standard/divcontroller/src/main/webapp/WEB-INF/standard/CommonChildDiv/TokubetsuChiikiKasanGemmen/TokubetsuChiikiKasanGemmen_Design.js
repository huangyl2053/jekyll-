var DBD;
(function (DBD) {
    (function (TokubetsuChiikiKasanGemmen) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgTokubetsuChiikiKasanGemmenList = function () {
                return "onSelect_dgTokubetsuChiikiKasanGemmenList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        TokubetsuChiikiKasanGemmen.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokubetsuChiikiKasanGemmen";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.TokubetsuChiikiKasanGemmen.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.TokubetsuChiikiKasanGemmen.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokubetsuChiikiKasanGemmen = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTokubetsuChiikiKasanGemmenList = function () {
                return new UZA.DataGrid(this.convFiledName("dgTokubetsuChiikiKasanGemmenList"));
            };

            Controls.prototype.TokubetsuChiikiKasanGemmenDetail = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuChiikiKasanGemmenDetail"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.TokubetsuChiikiKasanGemmenRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuChiikiKasanGemmenRiyoshaFutan"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.txtKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtYukokigenDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            };

            Controls.prototype.txtGengakuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGengakuRitsu"));
            };

            Controls.prototype.txtKakuninNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKakuninNo"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        TokubetsuChiikiKasanGemmen.Controls = Controls;
    })(DBD.TokubetsuChiikiKasanGemmen || (DBD.TokubetsuChiikiKasanGemmen = {}));
    var TokubetsuChiikiKasanGemmen = DBD.TokubetsuChiikiKasanGemmen;
})(DBD || (DBD = {}));
