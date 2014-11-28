var DBC;
(function (DBC) {
    (function (PaymentDate) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentDate.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PaymentDate";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.PaymentDate.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.PaymentDate.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PaymentDate = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.PayToKoza = function () {
                return new UZA.Panel(this.convFiledName("PayToKoza"));
            };

            Controls.prototype.txtKozaPaymentDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKozaPaymentDate"));
            };

            Controls.prototype.PayToMadoguchi = function () {
                return new UZA.Panel(this.convFiledName("PayToMadoguchi"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtShiharaiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtShiharaiDateRange"));
            };

            Controls.prototype.txtShiharaiKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            };

            Controls.prototype.txtShiharaiShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            };
            return Controls;
        })();
        PaymentDate.Controls = Controls;
    })(DBC.PaymentDate || (DBC.PaymentDate = {}));
    var PaymentDate = DBC.PaymentDate;
})(DBC || (DBC = {}));
