var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShichosonSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShichosonSelector.ModeController = ModeController;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShichosonSelector.PublicProperties = PublicProperties;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
