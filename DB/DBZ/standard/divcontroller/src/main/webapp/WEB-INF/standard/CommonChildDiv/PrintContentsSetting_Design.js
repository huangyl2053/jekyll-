var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PrintContentsSetting.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PrintContentsSetting";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PrintContentsSetting = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIssueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIssueDate"));
            };

            Controls.prototype.txtSendDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendDate"));
            };
            return Controls;
        })();
        PrintContentsSetting.Controls = Controls;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));
