var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJohoDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaJohoDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IchijiHanteiKekkaJohoDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IchijiHanteiKekkaJohoDialog.ModeController = ModeController;
    })(DBE.IchijiHanteiKekkaJohoDialog || (DBE.IchijiHanteiKekkaJohoDialog = {}));
    var IchijiHanteiKekkaJohoDialog = DBE.IchijiHanteiKekkaJohoDialog;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJohoDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaJohoDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiHanteiKekkaJohoDialog.PublicProperties = PublicProperties;
    })(DBE.IchijiHanteiKekkaJohoDialog || (DBE.IchijiHanteiKekkaJohoDialog = {}));
    var IchijiHanteiKekkaJohoDialog = DBE.IchijiHanteiKekkaJohoDialog;
})(DBE || (DBE = {}));
