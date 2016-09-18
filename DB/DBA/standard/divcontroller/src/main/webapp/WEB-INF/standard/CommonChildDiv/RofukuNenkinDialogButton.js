var DBA;
(function (DBA) {
    (function (RofukuNenkinDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RofukuNenkinDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RofukuNenkinDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RofukuNenkinDialogButton.ModeController = ModeController;
    })(DBA.RofukuNenkinDialogButton || (DBA.RofukuNenkinDialogButton = {}));
    var RofukuNenkinDialogButton = DBA.RofukuNenkinDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (RofukuNenkinDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RofukuNenkinDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RofukuNenkinDialogButton.PublicProperties = PublicProperties;
    })(DBA.RofukuNenkinDialogButton || (DBA.RofukuNenkinDialogButton = {}));
    var RofukuNenkinDialogButton = DBA.RofukuNenkinDialogButton;
})(DBA || (DBA = {}));
