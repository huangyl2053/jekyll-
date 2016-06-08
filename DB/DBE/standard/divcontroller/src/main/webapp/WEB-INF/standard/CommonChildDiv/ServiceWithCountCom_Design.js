var DBE;
(function (DBE) {
    (function (ServiceWithCountCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceWithCountCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceWithCountCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ServiceWithCountCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceWithCountCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblServiceName = function () {
                return new UZA.Label(this.convFiledName("lblServiceName"));
            };

            Controls.prototype.txtNum = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNum"));
            };

            Controls.prototype.radKaigoOrYobo = function () {
                return new UZA.RadioButton(this.convFiledName("radKaigoOrYobo"));
            };
            return Controls;
        })();
        ServiceWithCountCom.Controls = Controls;
    })(DBE.ServiceWithCountCom || (DBE.ServiceWithCountCom = {}));
    var ServiceWithCountCom = DBE.ServiceWithCountCom;
})(DBE || (DBE = {}));
