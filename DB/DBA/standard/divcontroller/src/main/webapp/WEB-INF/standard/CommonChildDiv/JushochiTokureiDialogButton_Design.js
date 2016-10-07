var DBA;
(function (DBA) {
    (function (JushochiTokureiDialogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JushochiTokureiDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.JushochiTokureiDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.JushochiTokureiDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnJushochiTokureiDialog = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJushochiTokureiDialog"));
            };
            return Controls;
        })();
        JushochiTokureiDialogButton.Controls = Controls;
    })(DBA.JushochiTokureiDialogButton || (DBA.JushochiTokureiDialogButton = {}));
    var JushochiTokureiDialogButton = DBA.JushochiTokureiDialogButton;
})(DBA || (DBA = {}));
