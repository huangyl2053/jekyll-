var DBA;
(function (DBA) {
    (function (IryoHokenRirekiDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        IryoHokenRirekiDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRirekiDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.IryoHokenRirekiDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.IryoHokenRirekiDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRirekiDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        IryoHokenRirekiDialog.Controls = Controls;
    })(DBA.IryoHokenRirekiDialog || (DBA.IryoHokenRirekiDialog = {}));
    var IryoHokenRirekiDialog = DBA.IryoHokenRirekiDialog;
})(DBA || (DBA = {}));
