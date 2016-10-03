var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRirekiDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuHenkoRirekiDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShikakuHenkoRirekiDialogButton.ModeController = ModeController;
    })(DBA.ShikakuHenkoRirekiDialogButton || (DBA.ShikakuHenkoRirekiDialogButton = {}));
    var ShikakuHenkoRirekiDialogButton = DBA.ShikakuHenkoRirekiDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRirekiDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuHenkoRirekiDialogButton.PublicProperties = PublicProperties;
    })(DBA.ShikakuHenkoRirekiDialogButton || (DBA.ShikakuHenkoRirekiDialogButton = {}));
    var ShikakuHenkoRirekiDialogButton = DBA.ShikakuHenkoRirekiDialogButton;
})(DBA || (DBA = {}));
