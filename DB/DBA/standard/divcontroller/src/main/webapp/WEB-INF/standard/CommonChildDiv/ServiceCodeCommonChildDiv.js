var DBA;
(function (DBA) {
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
    })(DBA.ServiceCodeCommonChildDiv || (DBA.ServiceCodeCommonChildDiv = {}));
    var ServiceCodeCommonChildDiv = DBA.ServiceCodeCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
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
    })(DBA.ServiceCodeCommonChildDiv || (DBA.ServiceCodeCommonChildDiv = {}));
    var ServiceCodeCommonChildDiv = DBA.ServiceCodeCommonChildDiv;
})(DBA || (DBA = {}));
