var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoGokei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTeikyoShomeishoGokei.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTeikyoShomeishoGokei.ModeController = ModeController;
    })(DBC.ServiceTeikyoShomeishoGokei || (DBC.ServiceTeikyoShomeishoGokei = {}));
    var ServiceTeikyoShomeishoGokei = DBC.ServiceTeikyoShomeishoGokei;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoGokei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceTeikyoShomeishoGokei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceTeikyoShomeishoGokei.PublicProperties = PublicProperties;
    })(DBC.ServiceTeikyoShomeishoGokei || (DBC.ServiceTeikyoShomeishoGokei = {}));
    var ServiceTeikyoShomeishoGokei = DBC.ServiceTeikyoShomeishoGokei;
})(DBC || (DBC = {}));
