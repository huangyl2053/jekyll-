var DBZ;
(function (DBZ) {
    (function (ServiceCodeInputCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceCodeInputCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceCodeInputCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ServiceCodeInputCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ServiceCodeInputCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceCodeInputCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblServiceCode = function () {
                return new UZA.Label(this.convFiledName("lblServiceCode"));
            };

            Controls.prototype.txtServiceCode1 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode1"));
            };

            Controls.prototype.txtServiceCode2 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode2"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtServiceCodeName = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceCodeName"));
            };
            return Controls;
        })();
        ServiceCodeInputCommonChildDiv.Controls = Controls;
    })(DBZ.ServiceCodeInputCommonChildDiv || (DBZ.ServiceCodeInputCommonChildDiv = {}));
    var ServiceCodeInputCommonChildDiv = DBZ.ServiceCodeInputCommonChildDiv;
})(DBZ || (DBZ = {}));
