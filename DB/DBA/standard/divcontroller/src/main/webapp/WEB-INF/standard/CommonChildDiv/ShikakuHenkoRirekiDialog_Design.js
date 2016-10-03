var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ShikakuHenkoRirekiDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRirekiDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShikakuHenkoRirekiDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRirekiDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShikakuHenkoRirekiDialog.Controls = Controls;
    })(DBA.ShikakuHenkoRirekiDialog || (DBA.ShikakuHenkoRirekiDialog = {}));
    var ShikakuHenkoRirekiDialog = DBA.ShikakuHenkoRirekiDialog;
})(DBA || (DBA = {}));
