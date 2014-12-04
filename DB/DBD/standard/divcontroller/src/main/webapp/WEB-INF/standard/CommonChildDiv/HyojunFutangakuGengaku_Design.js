var DBD;
(function (DBD) {
    (function (HyojunFutangakuGengaku) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgHyojunFutangakuGengakuList = function () {
                return "onSelect_dgHyojunFutangakuGengakuList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        HyojunFutangakuGengaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HyojunFutangakuGengaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.HyojunFutangakuGengaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.HyojunFutangakuGengaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HyojunFutangakuGengaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHiddenHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHiddenHihokenshaNo"));
            };

            Controls.prototype.dgHyojunFutangakuGengakuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgHyojunFutangakuGengakuList"));
            };

            Controls.prototype.HyojunFutangakuGemmenDetail = function () {
                return new UZA.Panel(this.convFiledName("HyojunFutangakuGemmenDetail"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.HyojunFutangakuGemmenRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("HyojunFutangakuGemmenDetail_HyojunFutangakuGemmenRiyoshaFutan"));
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

            Controls.prototype.txtGengakuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGengakuKubun"));
            };

            Controls.prototype.txtFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        HyojunFutangakuGengaku.Controls = Controls;
    })(DBD.HyojunFutangakuGengaku || (DBD.HyojunFutangakuGengaku = {}));
    var HyojunFutangakuGengaku = DBD.HyojunFutangakuGengaku;
})(DBD || (DBD = {}));
