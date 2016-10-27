var DBC;
(function (DBC) {
    (function (KaigoKyufuKokuhorenJohoTorikomi) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoKyufuKokuhorenJohoTorikomi";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KaigoKyufuKokuhorenJohoTorikomi.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KaigoKyufuKokuhorenJohoTorikomi.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoKyufuKokuhorenJohoTorikomi = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblChushutsuJoken = function () {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            };

            Controls.prototype.txtShoriYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShoriYmd"));
            };

            Controls.prototype.txtSaishoriKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishoriKubun"));
            };

            Controls.prototype.ShoriTaishoJoho = function () {
                return new UZA.Panel(this.convFiledName("ShoriTaishoJoho"));
            };

            Controls.prototype.lblShoriTaishoJoho = function () {
                return new UZA.Label(this.convFiledName("lblShoriTaishoJoho"));
            };

            Controls.prototype.chkTsuJobun = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTsuJobun"));
            };

            Controls.prototype.KakuninJikoMsg = function () {
                return new UZA.Panel(this.convFiledName("KakuninJikoMsg"));
            };

            Controls.prototype.lblKakuninJohoMsg = function () {
                return new UZA.Label(this.convFiledName("lblKakuninJohoMsg"));
            };

            Controls.prototype.lblAruBaiMsg = function () {
                return new UZA.Label(this.convFiledName("lblAruBaiMsg"));
            };

            Controls.prototype.lblNaiBaiMsg = function () {
                return new UZA.Label(this.convFiledName("lblNaiBaiMsg"));
            };

            Controls.prototype.txtShoriTaisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShoriTaisho"));
            };

            Controls.prototype.hdnShoriKubun = function () {
                return new UZA.TextBox(this.convFiledName("hdnShoriKubun"));
            };

            Controls.prototype.ShutsuRyokujun = function () {
                return new UZA.Panel(this.convFiledName("ShutsuRyokujun"));
            };
            return Controls;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.Controls = Controls;
    })(DBC.KaigoKyufuKokuhorenJohoTorikomi || (DBC.KaigoKyufuKokuhorenJohoTorikomi = {}));
    var KaigoKyufuKokuhorenJohoTorikomi = DBC.KaigoKyufuKokuhorenJohoTorikomi;
})(DBC || (DBC = {}));
