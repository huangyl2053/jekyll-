var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialogButton) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuShokaiDialogButton.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShotokuShokaiDialogButton.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShotokuShokaiDialogButton.ModeController = ModeController;
    })(DBA.ShotokuShokaiDialogButton || (DBA.ShotokuShokaiDialogButton = {}));
    var ShotokuShokaiDialogButton = DBA.ShotokuShokaiDialogButton;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialogButton) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuShokaiDialogButton.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShotokuShokaiDialogButton.PublicProperties = PublicProperties;
    })(DBA.ShotokuShokaiDialogButton || (DBA.ShotokuShokaiDialogButton = {}));
    var ShotokuShokaiDialogButton = DBA.ShotokuShokaiDialogButton;
})(DBA || (DBA = {}));
