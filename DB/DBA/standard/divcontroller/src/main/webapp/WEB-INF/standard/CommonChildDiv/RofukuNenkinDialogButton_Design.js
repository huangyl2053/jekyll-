var DBA;
(function (DBA) {
    (function (RofukuNenkinDialogButton) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClose_btnRofukuNenkin = function () {
                return "onOkClose_btnRofukuNenkin";
            };
            return Events;
        })();
        RofukuNenkinDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RofukuNenkinDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.RofukuNenkinDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.RofukuNenkinDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RofukuNenkinDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnRofukuNenkin = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRofukuNenkin"));
            };
            return Controls;
        })();
        RofukuNenkinDialogButton.Controls = Controls;
    })(DBA.RofukuNenkinDialogButton || (DBA.RofukuNenkinDialogButton = {}));
    var RofukuNenkinDialogButton = DBA.RofukuNenkinDialogButton;
})(DBA || (DBA = {}));
