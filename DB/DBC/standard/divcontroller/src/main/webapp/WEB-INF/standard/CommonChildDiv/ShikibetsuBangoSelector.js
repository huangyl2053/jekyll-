var DBC;
(function (DBC) {
    (function (ShikibetsuBangoSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikibetsuBangoSelector.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikibetsuBangoSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShikibetsuBangoSelector.ModeController = ModeController;
    })(DBC.ShikibetsuBangoSelector || (DBC.ShikibetsuBangoSelector = {}));
    var ShikibetsuBangoSelector = DBC.ShikibetsuBangoSelector;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShikibetsuBangoSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikibetsuBangoSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikibetsuBangoSelector.PublicProperties = PublicProperties;
    })(DBC.ShikibetsuBangoSelector || (DBC.ShikibetsuBangoSelector = {}));
    var ShikibetsuBangoSelector = DBC.ShikibetsuBangoSelector;
})(DBC || (DBC = {}));
