var DBC;
(function (DBC) {
    (function (ServiceCodeCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceCodeCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceCodeCommonChildDiv.ModeController = ModeController;
    })(DBC.ServiceCodeCommonChildDiv || (DBC.ServiceCodeCommonChildDiv = {}));
    var ServiceCodeCommonChildDiv = DBC.ServiceCodeCommonChildDiv;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceCodeCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceCodeCommonChildDiv.PublicProperties = PublicProperties;
    })(DBC.ServiceCodeCommonChildDiv || (DBC.ServiceCodeCommonChildDiv = {}));
    var ServiceCodeCommonChildDiv = DBC.ServiceCodeCommonChildDiv;
})(DBC || (DBC = {}));
