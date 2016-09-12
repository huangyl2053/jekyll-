var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShisetsuNyutaishoDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShisetsuNyutaishoDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnShisetsuNyutaisho = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShisetsuNyutaisho"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoDialogButton.Controls = Controls;
    })(DBA.ShisetsuNyutaishoDialogButton || (DBA.ShisetsuNyutaishoDialogButton = {}));
    var ShisetsuNyutaishoDialogButton = DBA.ShisetsuNyutaishoDialogButton;
})(DBA || (DBA = {}));
