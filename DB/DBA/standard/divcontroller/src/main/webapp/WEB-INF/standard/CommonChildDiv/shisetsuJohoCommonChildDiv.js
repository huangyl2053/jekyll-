var DBA;
(function (DBA) {
    (function (shisetsuJohoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new shisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new shisetsuJohoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        shisetsuJohoCommonChildDiv.ModeController = ModeController;
    })(DBA.shisetsuJohoCommonChildDiv || (DBA.shisetsuJohoCommonChildDiv = {}));
    var shisetsuJohoCommonChildDiv = DBA.shisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (shisetsuJohoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new shisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        shisetsuJohoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.shisetsuJohoCommonChildDiv || (DBA.shisetsuJohoCommonChildDiv = {}));
    var shisetsuJohoCommonChildDiv = DBA.shisetsuJohoCommonChildDiv;
})(DBA || (DBA = {}));
