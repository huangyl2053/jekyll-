var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShoKaishuKirokuDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnShoKaishu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShoKaishu"));
            };
            return Controls;
        })();
        ShoKaishuKirokuDialogButton.Controls = Controls;
    })(DBA.ShoKaishuKirokuDialogButton || (DBA.ShoKaishuKirokuDialogButton = {}));
    var ShoKaishuKirokuDialogButton = DBA.ShoKaishuKirokuDialogButton;
})(DBA || (DBA = {}));
