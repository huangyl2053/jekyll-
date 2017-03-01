var DBE;
(function (DBE) {
    (function (ChosaKekkaTokkiImages) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaTokkiImages.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaKekkaTokkiImages.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaKekkaTokkiImages.ModeController = ModeController;
    })(DBE.ChosaKekkaTokkiImages || (DBE.ChosaKekkaTokkiImages = {}));
    var ChosaKekkaTokkiImages = DBE.ChosaKekkaTokkiImages;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaKekkaTokkiImages) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaTokkiImages.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaKekkaTokkiImages.PublicProperties = PublicProperties;
    })(DBE.ChosaKekkaTokkiImages || (DBE.ChosaKekkaTokkiImages = {}));
    var ChosaKekkaTokkiImages = DBE.ChosaKekkaTokkiImages;
})(DBE || (DBE = {}));
