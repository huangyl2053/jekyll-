var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuNyutaishoDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuNyutaishoDialogButton.ModeController = ModeController;
    })(DBA.ShisetsuNyutaishoDialogButton || (DBA.ShisetsuNyutaishoDialogButton = {}));
    var ShisetsuNyutaishoDialogButton = DBA.ShisetsuNyutaishoDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShisetsuNyutaishoDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuNyutaishoDialogButton.PublicProperties = PublicProperties;
    })(DBA.ShisetsuNyutaishoDialogButton || (DBA.ShisetsuNyutaishoDialogButton = {}));
    var ShisetsuNyutaishoDialogButton = DBA.ShisetsuNyutaishoDialogButton;
})(DBA || (DBA = {}));
