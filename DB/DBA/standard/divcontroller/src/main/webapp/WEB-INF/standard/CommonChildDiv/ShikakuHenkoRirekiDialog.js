var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRirekiDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuHenkoRirekiDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShikakuHenkoRirekiDialog.ModeController = ModeController;
    })(DBA.ShikakuHenkoRirekiDialog || (DBA.ShikakuHenkoRirekiDialog = {}));
    var ShikakuHenkoRirekiDialog = DBA.ShikakuHenkoRirekiDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShikakuHenkoRirekiDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRirekiDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuHenkoRirekiDialog.PublicProperties = PublicProperties;
    })(DBA.ShikakuHenkoRirekiDialog || (DBA.ShikakuHenkoRirekiDialog = {}));
    var ShikakuHenkoRirekiDialog = DBA.ShikakuHenkoRirekiDialog;
})(DBA || (DBA = {}));
