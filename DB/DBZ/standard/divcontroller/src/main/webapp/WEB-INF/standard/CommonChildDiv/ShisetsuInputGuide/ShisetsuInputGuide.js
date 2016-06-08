var DBZ;
(function (DBZ) {
    (function (ShisetsuInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuInputGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuInputGuide.ModeController = ModeController;
    })(DBZ.ShisetsuInputGuide || (DBZ.ShisetsuInputGuide = {}));
    var ShisetsuInputGuide = DBZ.ShisetsuInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuInputGuide.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuInputGuide || (DBZ.ShisetsuInputGuide = {}));
    var ShisetsuInputGuide = DBZ.ShisetsuInputGuide;
})(DBZ || (DBZ = {}));
