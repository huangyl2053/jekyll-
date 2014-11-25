var DBZ;
(function (DBZ) {
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
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.PaymentMethod().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.PaymentMethod().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentMethod().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentMethod().panelDisplay = value;
            };

            PublicProperties.prototype.getonClick_radPayMethod = function () {
                return this.controls.radPayMethod1().onClick;
            };

            PublicProperties.prototype.setonClick_radPayMethod = function (value) {
                this.controls.radPayMethod1().onClick = value;
            };

            PublicProperties.prototype.getJuryoinin_displayNone = function () {
                return this.controls.JuryoininJoho().displayNone;
            };

            PublicProperties.prototype.setJuryoinin_displayNone = function (value) {
                this.controls.JuryoininJoho().displayNone = value;
            };

            PublicProperties.prototype.getMadoguchi_displayNone = function () {
                return this.controls.MadoguchiPayment().displayNone;
            };

            PublicProperties.prototype.setMadoguchi_displayNone = function (value) {
                this.controls.MadoguchiPayment().displayNone = value;
            };

            PublicProperties.prototype.getKoza_displayNone = function () {
                return this.controls.KozaPayment().Properties().displayNone;
            };

            PublicProperties.prototype.setKoza_displayNone = function (value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.PaymentMethod().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.PaymentMethod().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
