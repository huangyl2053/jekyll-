var DBA;
(function (DBA) {
    (function (ServiceCodeInputCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeInputCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceCodeInputCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceCodeInputCommonChildDiv.ModeController = ModeController;
    })(DBA.ServiceCodeInputCommonChildDiv || (DBA.ServiceCodeInputCommonChildDiv = {}));
    var ServiceCodeInputCommonChildDiv = DBA.ServiceCodeInputCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ServiceCodeInputCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeInputCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceCodeInputCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.ServiceCodeInputCommonChildDiv || (DBA.ServiceCodeInputCommonChildDiv = {}));
    var ServiceCodeInputCommonChildDiv = DBA.ServiceCodeInputCommonChildDiv;
})(DBA || (DBA = {}));
