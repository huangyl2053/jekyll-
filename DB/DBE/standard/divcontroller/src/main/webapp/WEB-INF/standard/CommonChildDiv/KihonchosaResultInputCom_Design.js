var DBE;
(function (DBE) {
    (function (KihonchosaResultInputCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KihonchosaResultInputCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonchosaResultInputCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.KihonchosaResultInputCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonchosaResultInputCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblItemNo = function () {
                return new UZA.Label(this.convFiledName("lblItemNo"));
            };

            Controls.prototype.lblItemName = function () {
                return new UZA.Label(this.convFiledName("lblItemName"));
            };

            Controls.prototype.txtAnswer = function () {
                return new UZA.TextBox(this.convFiledName("txtAnswer"));
            };

            Controls.prototype.radChoices = function () {
                return new UZA.RadioButton(this.convFiledName("radChoices"));
            };
            return Controls;
        })();
        KihonchosaResultInputCom.Controls = Controls;
    })(DBE.KihonchosaResultInputCom || (DBE.KihonchosaResultInputCom = {}));
    var KihonchosaResultInputCom = DBE.KihonchosaResultInputCom;
})(DBE || (DBE = {}));
