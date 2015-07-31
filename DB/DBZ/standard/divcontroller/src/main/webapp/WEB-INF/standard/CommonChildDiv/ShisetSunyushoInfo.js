var DBZ;
(function (DBZ) {
    (function (ShisetSunyushoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetSunyushoInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetSunyushoInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetSunyushoInfo.ModeController = ModeController;
    })(DBZ.ShisetSunyushoInfo || (DBZ.ShisetSunyushoInfo = {}));
    var ShisetSunyushoInfo = DBZ.ShisetSunyushoInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetSunyushoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetSunyushoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetSunyushoInfo.PublicProperties = PublicProperties;
    })(DBZ.ShisetSunyushoInfo || (DBZ.ShisetSunyushoInfo = {}));
    var ShisetSunyushoInfo = DBZ.ShisetSunyushoInfo;
})(DBZ || (DBZ = {}));
