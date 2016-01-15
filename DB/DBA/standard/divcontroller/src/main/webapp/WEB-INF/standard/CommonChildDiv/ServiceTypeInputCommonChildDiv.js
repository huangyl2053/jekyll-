var DBA;
(function (DBA) {
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
    })(DBA.ServiceTypeInputCommonChildDiv || (DBA.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBA.ServiceTypeInputCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
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
    })(DBA.ServiceTypeInputCommonChildDiv || (DBA.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBA.ServiceTypeInputCommonChildDiv;
})(DBA || (DBA = {}));
