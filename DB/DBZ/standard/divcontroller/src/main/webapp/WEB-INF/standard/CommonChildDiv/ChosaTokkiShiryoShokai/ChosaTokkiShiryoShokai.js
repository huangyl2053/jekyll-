var DBZ;
(function (DBZ) {
    (function (ChosaTokkiShiryoShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaTokkiShiryoShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaTokkiShiryoShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaTokkiShiryoShokai.ModeController = ModeController;
    })(DBZ.ChosaTokkiShiryoShokai || (DBZ.ChosaTokkiShiryoShokai = {}));
    var ChosaTokkiShiryoShokai = DBZ.ChosaTokkiShiryoShokai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaTokkiShiryoShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaTokkiShiryoShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaTokkiShiryoShokai.PublicProperties = PublicProperties;
    })(DBZ.ChosaTokkiShiryoShokai || (DBZ.ChosaTokkiShiryoShokai = {}));
    var ChosaTokkiShiryoShokai = DBZ.ChosaTokkiShiryoShokai;
})(DBZ || (DBZ = {}));
