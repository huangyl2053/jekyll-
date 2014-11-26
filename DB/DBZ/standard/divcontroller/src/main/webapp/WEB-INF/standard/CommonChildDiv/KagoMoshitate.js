var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KagoMoshitate.ModeController = ModeController;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KagoMoshitate().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KagoMoshitate().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KagoMoshitate().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KagoMoshitate().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KagoMoshitate().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KagoMoshitate.PublicProperties = PublicProperties;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
