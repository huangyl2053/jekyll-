var DBC;
(function (DBC) {
    (function (PaymentMethod) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        PaymentMethod.ModeController = ModeController;
    })(DBC.PaymentMethod || (DBC.PaymentMethod = {}));
    var PaymentMethod = DBC.PaymentMethod;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBC.PaymentMethod || (DBC.PaymentMethod = {}));
    var PaymentMethod = DBC.PaymentMethod;
})(DBC || (DBC = {}));
