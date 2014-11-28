var DBC;
(function (DBC) {
    (function (PaymentMethod) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentMethod.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PaymentMethod";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.PaymentMethod.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.PaymentMethod.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PaymentMethod = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radPayMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod"));
            };

            Controls.prototype.URKoza = function () {
                return new UZA.Panel(this.convFiledName("URKoza"));
            };

            Controls.prototype.txtKari1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari1"));
            };

            Controls.prototype.DBZJuryoinin = function () {
                return new UZA.Panel(this.convFiledName("DBZJuryoinin"));
            };

            Controls.prototype.txtKari2 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari2"));
            };
            return Controls;
        })();
        PaymentMethod.Controls = Controls;
    })(DBC.PaymentMethod || (DBC.PaymentMethod = {}));
    var PaymentMethod = DBC.PaymentMethod;
})(DBC || (DBC = {}));
