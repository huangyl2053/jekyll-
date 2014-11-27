var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KozaPayment.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KozaPayment";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KozaPayment = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            };

            Controls.prototype.txtKozaMeigininKana = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            };

            Controls.prototype.txtKinyuKikanBrunchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            };

            Controls.prototype.txtKinyuKikanBrunchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            };
            return Controls;
        })();
        KozaPayment.Controls = Controls;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
