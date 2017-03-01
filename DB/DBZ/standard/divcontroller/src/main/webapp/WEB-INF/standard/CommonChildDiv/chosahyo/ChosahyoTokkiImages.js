var DBZ;
(function (DBZ) {
    (function (ChosahyoTokkiImages) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosahyoTokkiImages.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosahyoTokkiImages.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosahyoTokkiImages.ModeController = ModeController;
    })(DBZ.ChosahyoTokkiImages || (DBZ.ChosahyoTokkiImages = {}));
    var ChosahyoTokkiImages = DBZ.ChosahyoTokkiImages;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosahyoTokkiImages) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosahyoTokkiImages.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosahyoTokkiImages.PublicProperties = PublicProperties;
    })(DBZ.ChosahyoTokkiImages || (DBZ.ChosahyoTokkiImages = {}));
    var ChosahyoTokkiImages = DBZ.ChosahyoTokkiImages;
})(DBZ || (DBZ = {}));
