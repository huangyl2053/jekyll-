var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ShisetsuNyutaishoDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoDialog.Controls = Controls;
    })(DBA.ShisetsuNyutaishoDialog || (DBA.ShisetsuNyutaishoDialog = {}));
    var ShisetsuNyutaishoDialog = DBA.ShisetsuNyutaishoDialog;
})(DBA || (DBA = {}));
