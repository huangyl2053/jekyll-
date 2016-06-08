var DBC;
(function (DBC) {
    (function (PaymentDate) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentDate.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        PaymentDate.ModeController = ModeController;
    })(DBC.PaymentDate || (DBC.PaymentDate = {}));
    var PaymentDate = DBC.PaymentDate;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (PaymentDate) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentDate.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentDate().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentDate().panelDisplay = value;
            };
            return PublicProperties;
        })();
        PaymentDate.PublicProperties = PublicProperties;
    })(DBC.PaymentDate || (DBC.PaymentDate = {}));
    var PaymentDate = DBC.PaymentDate;
})(DBC || (DBC = {}));
