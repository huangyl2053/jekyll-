var DBE;
(function (DBE) {
    (function (ShujiiIkenshoShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        ShujiiIkenshoShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIkenshoShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShujiiIkenshoShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShujiiIkenshoShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIkenshoShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJiritsudo = function () {
                return new UZA.TextBox(this.convFiledName("txtJiritsudo"));
            };

            Controls.prototype.txtTankiKioku = function () {
                return new UZA.TextBox(this.convFiledName("txtTankiKioku"));
            };

            Controls.prototype.txtNinchiNoryoku = function () {
                return new UZA.TextBox(this.convFiledName("txtNinchiNoryoku"));
            };

            Controls.prototype.txtDentatsuNoryoku = function () {
                return new UZA.TextBox(this.convFiledName("txtDentatsuNoryoku"));
            };

            Controls.prototype.txtShokujiKoi = function () {
                return new UZA.TextBox(this.convFiledName("txtShokujiKoi"));
            };

            Controls.prototype.txtTest = function () {
                return new UZA.TextBox(this.convFiledName("txtTest"));
            };

            Controls.prototype.txtTest2 = function () {
                return new UZA.TextBox(this.convFiledName("txtTest2"));
            };

            Controls.prototype.txtTest3 = function () {
                return new UZA.TextBox(this.convFiledName("txtTest3"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ShujiiIkenshoShokai.Controls = Controls;
    })(DBE.ShujiiIkenshoShokai || (DBE.ShujiiIkenshoShokai = {}));
    var ShujiiIkenshoShokai = DBE.ShujiiIkenshoShokai;
})(DBE || (DBE = {}));
