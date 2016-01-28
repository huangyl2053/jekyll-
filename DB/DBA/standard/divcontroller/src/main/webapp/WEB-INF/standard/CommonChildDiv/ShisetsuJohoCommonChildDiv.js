var DBA;
(function (DBA) {
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
    })(DBA.ShisetsuJohoCommonChildDiv || (DBA.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBA.ShisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
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
    })(DBA.ShisetsuJohoCommonChildDiv || (DBA.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBA.ShisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));
