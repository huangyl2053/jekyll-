var DBA;
(function (DBA) {
    (function (RofukuNenkinDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RofukuNenkinDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RofukuNenkinDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RofukuNenkinDialog.ModeController = ModeController;
    })(DBA.RofukuNenkinDialog || (DBA.RofukuNenkinDialog = {}));
    var RofukuNenkinDialog = DBA.RofukuNenkinDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (RofukuNenkinDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RofukuNenkinDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RofukuNenkinDialog.PublicProperties = PublicProperties;
    })(DBA.RofukuNenkinDialog || (DBA.RofukuNenkinDialog = {}));
    var RofukuNenkinDialog = DBA.RofukuNenkinDialog;
})(DBA || (DBA = {}));
