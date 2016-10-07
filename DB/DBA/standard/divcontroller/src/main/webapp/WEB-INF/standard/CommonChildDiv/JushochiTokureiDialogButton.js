var DBA;
(function (DBA) {
    (function (JushochiTokureiDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushochiTokureiDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JushochiTokureiDialogButton.ModeController = ModeController;
    })(DBA.JushochiTokureiDialogButton || (DBA.JushochiTokureiDialogButton = {}));
    var JushochiTokureiDialogButton = DBA.JushochiTokureiDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (JushochiTokureiDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiDialogButton.PublicProperties = PublicProperties;
    })(DBA.JushochiTokureiDialogButton || (DBA.JushochiTokureiDialogButton = {}));
    var JushochiTokureiDialogButton = DBA.JushochiTokureiDialogButton;
})(DBA || (DBA = {}));
