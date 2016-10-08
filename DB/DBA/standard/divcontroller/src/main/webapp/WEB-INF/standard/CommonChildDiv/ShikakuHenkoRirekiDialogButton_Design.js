var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShikakuHenkoRirekiDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRirekiDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRirekiDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnShikakuHenkoRirekiDialog = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShikakuHenkoRirekiDialog"));
            };
            return Controls;
        })();
        ShikakuHenkoRirekiDialogButton.Controls = Controls;
    })(DBA.ShikakuHenkoRirekiDialogButton || (DBA.ShikakuHenkoRirekiDialogButton = {}));
    var ShikakuHenkoRirekiDialogButton = DBA.ShikakuHenkoRirekiDialogButton;
})(DBA || (DBA = {}));
