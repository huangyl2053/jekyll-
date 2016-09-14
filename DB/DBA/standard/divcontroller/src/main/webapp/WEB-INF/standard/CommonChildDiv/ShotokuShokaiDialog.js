var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuShokaiDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShotokuShokaiDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShotokuShokaiDialog.ModeController = ModeController;
    })(DBA.ShotokuShokaiDialog || (DBA.ShotokuShokaiDialog = {}));
    var ShotokuShokaiDialog = DBA.ShotokuShokaiDialog;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShotokuShokaiDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShotokuShokaiDialog.PublicProperties = PublicProperties;
    })(DBA.ShotokuShokaiDialog || (DBA.ShotokuShokaiDialog = {}));
    var ShotokuShokaiDialog = DBA.ShotokuShokaiDialog;
})(DBA || (DBA = {}));
