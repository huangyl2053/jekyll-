var DBZ;
(function (DBZ) {
    (function (ShikakuRirekiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuRirekiInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuRirekiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShikakuRirekiInfo.ModeController = ModeController;
    })(DBZ.ShikakuRirekiInfo || (DBZ.ShikakuRirekiInfo = {}));
    var ShikakuRirekiInfo = DBZ.ShikakuRirekiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuRirekiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuRirekiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuRirekiInfo.PublicProperties = PublicProperties;
    })(DBZ.ShikakuRirekiInfo || (DBZ.ShikakuRirekiInfo = {}));
    var ShikakuRirekiInfo = DBZ.ShikakuRirekiInfo;
})(DBZ || (DBZ = {}));
