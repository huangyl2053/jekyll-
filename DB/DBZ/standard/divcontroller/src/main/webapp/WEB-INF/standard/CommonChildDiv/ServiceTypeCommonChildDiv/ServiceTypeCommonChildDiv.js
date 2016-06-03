var DBZ;
(function (DBZ) {
    (function (ServiceTypeCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceTypeCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTypeCommonChildDiv.ModeController = ModeController;
    })(DBZ.ServiceTypeCommonChildDiv || (DBZ.ServiceTypeCommonChildDiv = {}));
    var ServiceTypeCommonChildDiv = DBZ.ServiceTypeCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceTypeCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceTypeCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ServiceTypeCommonChildDiv || (DBZ.ServiceTypeCommonChildDiv = {}));
    var ServiceTypeCommonChildDiv = DBZ.ServiceTypeCommonChildDiv;
})(DBZ || (DBZ = {}));
