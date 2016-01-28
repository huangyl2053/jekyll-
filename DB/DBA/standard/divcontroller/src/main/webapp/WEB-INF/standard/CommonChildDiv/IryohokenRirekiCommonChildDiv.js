var DBA;
(function (DBA) {
    (function (IryohokenRirekiCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRirekiCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IryohokenRirekiCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IryohokenRirekiCommonChildDiv.ModeController = ModeController;
    })(DBA.IryohokenRirekiCommonChildDiv || (DBA.IryohokenRirekiCommonChildDiv = {}));
    var IryohokenRirekiCommonChildDiv = DBA.IryohokenRirekiCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (IryohokenRirekiCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRirekiCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryohokenRirekiCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.IryohokenRirekiCommonChildDiv || (DBA.IryohokenRirekiCommonChildDiv = {}));
    var IryohokenRirekiCommonChildDiv = DBA.IryohokenRirekiCommonChildDiv;
})(DBA || (DBA = {}));
