var DBA;
(function (DBA) {
    (function (IryoHokenRirekiDialogButton) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClose_btnIryoHokenRireki = function () {
                return "onOkClose_btnIryoHokenRireki";
            };
            return Events;
        })();
        IryoHokenRirekiDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRirekiDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.IryoHokenRirekiDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.IryoHokenRirekiDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRirekiDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnIryoHokenRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIryoHokenRireki"));
            };
            return Controls;
        })();
        IryoHokenRirekiDialogButton.Controls = Controls;
    })(DBA.IryoHokenRirekiDialogButton || (DBA.IryoHokenRirekiDialogButton = {}));
    var IryoHokenRirekiDialogButton = DBA.IryoHokenRirekiDialogButton;
})(DBA || (DBA = {}));
