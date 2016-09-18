var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuNyutaishoDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuNyutaishoDialog.ModeController = ModeController;
    })(DBA.ShisetsuNyutaishoDialog || (DBA.ShisetsuNyutaishoDialog = {}));
    var ShisetsuNyutaishoDialog = DBA.ShisetsuNyutaishoDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuNyutaishoDialog.PublicProperties = PublicProperties;
    })(DBA.ShisetsuNyutaishoDialog || (DBA.ShisetsuNyutaishoDialog = {}));
    var ShisetsuNyutaishoDialog = DBA.ShisetsuNyutaishoDialog;
})(DBA || (DBA = {}));
