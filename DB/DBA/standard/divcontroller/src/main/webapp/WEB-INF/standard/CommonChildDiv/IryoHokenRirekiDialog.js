var DBA;
(function (DBA) {
    (function (IryoHokenRirekiDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRirekiDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IryoHokenRirekiDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IryoHokenRirekiDialog.ModeController = ModeController;
    })(DBA.IryoHokenRirekiDialog || (DBA.IryoHokenRirekiDialog = {}));
    var IryoHokenRirekiDialog = DBA.IryoHokenRirekiDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (IryoHokenRirekiDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRirekiDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoHokenRirekiDialog.PublicProperties = PublicProperties;
    })(DBA.IryoHokenRirekiDialog || (DBA.IryoHokenRirekiDialog = {}));
    var IryoHokenRirekiDialog = DBA.IryoHokenRirekiDialog;
})(DBA || (DBA = {}));
