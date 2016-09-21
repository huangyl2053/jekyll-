var DBD;
(function (DBD) {
    (function (RiyoshaFutangakuGemmen) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgRiyoshaFutangakuGemmenList = function () {
                return "onSelect_dgRiyoshaFutangakuGemmenList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        RiyoshaFutangakuGemmen.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RiyoshaFutangakuGemmen";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.RiyoshaFutangakuGemmen.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.RiyoshaFutangakuGemmen.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RiyoshaFutangakuGemmen = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgRiyoshaFutangakuGemmenList = function () {
                return new UZA.DataGrid(this.convFiledName("dgRiyoshaFutangakuGemmenList"));
            };

            Controls.prototype.RiyoshaFutangakuGemmenDetail = function () {
                return new UZA.Panel(this.convFiledName("RiyoshaFutangakuGemmenDetail"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.RiyoshaFutangakuGemmenRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("RiyoshaFutangakuGemmenRiyoshaFutan"));
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

            Controls.prototype.txtKyufuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        RiyoshaFutangakuGemmen.Controls = Controls;
    })(DBD.RiyoshaFutangakuGemmen || (DBD.RiyoshaFutangakuGemmen = {}));
    var RiyoshaFutangakuGemmen = DBD.RiyoshaFutangakuGemmen;
})(DBD || (DBD = {}));
