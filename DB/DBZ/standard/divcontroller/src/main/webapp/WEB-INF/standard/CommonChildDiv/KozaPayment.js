var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KozaPayment.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KozaPayment.ModeController = ModeController;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KozaPayment.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KozaPayment().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KozaPayment().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KozaPayment().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KozaPayment().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KozaPayment().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KozaPayment().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KozaPayment.PublicProperties = PublicProperties;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
