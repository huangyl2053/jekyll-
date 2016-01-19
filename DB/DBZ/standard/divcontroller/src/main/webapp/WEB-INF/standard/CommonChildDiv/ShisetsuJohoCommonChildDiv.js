var DBZ;
(function (DBZ) {
    (function (ShisetsuJohoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuJohoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuJohoCommonChildDiv.ModeController = ModeController;
    })(DBZ.ShisetsuJohoCommonChildDiv || (DBZ.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBZ.ShisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuJohoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuJohoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuJohoCommonChildDiv || (DBZ.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBZ.ShisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));
