var DBZ;
(function (DBZ) {
    (function (ChosaTokkiImageShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaTokkiImageShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaTokkiImageShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaTokkiImageShokai.ModeController = ModeController;
    })(DBZ.ChosaTokkiImageShokai || (DBZ.ChosaTokkiImageShokai = {}));
    var ChosaTokkiImageShokai = DBZ.ChosaTokkiImageShokai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaTokkiImageShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaTokkiImageShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaTokkiImageShokai.PublicProperties = PublicProperties;
    })(DBZ.ChosaTokkiImageShokai || (DBZ.ChosaTokkiImageShokai = {}));
    var ChosaTokkiImageShokai = DBZ.ChosaTokkiImageShokai;
})(DBZ || (DBZ = {}));
