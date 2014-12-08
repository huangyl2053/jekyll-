var DBE;
(function (DBE) {
    (function (ChosaKikanDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKikanDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ChosaKikanDialog.ModeController = ModeController;
    })(DBE.ChosaKikanDialog || (DBE.ChosaKikanDialog = {}));
    var ChosaKikanDialog = DBE.ChosaKikanDialog;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaKikanDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ChosaKikanDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaKikanDialog.PublicProperties = PublicProperties;
    })(DBE.ChosaKikanDialog || (DBE.ChosaKikanDialog = {}));
    var ChosaKikanDialog = DBE.ChosaKikanDialog;
})(DBE || (DBE = {}));
