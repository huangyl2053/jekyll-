var DBZ;
(function (DBZ) {
    (function (ServiceTypeInputCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeInputCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceTypeInputCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTypeInputCommonChildDiv.ModeController = ModeController;
    })(DBZ.ServiceTypeInputCommonChildDiv || (DBZ.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBZ.ServiceTypeInputCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceTypeInputCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeInputCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceTypeInputCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ServiceTypeInputCommonChildDiv || (DBZ.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBZ.ServiceTypeInputCommonChildDiv;
})(DBZ || (DBZ = {}));
