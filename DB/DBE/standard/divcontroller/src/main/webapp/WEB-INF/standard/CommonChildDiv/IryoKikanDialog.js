var DBE;
(function (DBE) {
    (function (IryoKikanDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoKikanDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        IryoKikanDialog.ModeController = ModeController;
    })(DBE.IryoKikanDialog || (DBE.IryoKikanDialog = {}));
    var IryoKikanDialog = DBE.IryoKikanDialog;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IryoKikanDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IryoKikanDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoKikanDialog.PublicProperties = PublicProperties;
    })(DBE.IryoKikanDialog || (DBE.IryoKikanDialog = {}));
    var IryoKikanDialog = DBE.IryoKikanDialog;
})(DBE || (DBE = {}));
