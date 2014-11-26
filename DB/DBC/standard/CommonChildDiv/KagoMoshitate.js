var DBC;
(function (DBC) {
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
    })(DBC.KagoMoshitate || (DBC.KagoMoshitate = {}));
    var KagoMoshitate = DBC.KagoMoshitate;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KagoMoshitate) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("isGroupBox", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getisGroupBox = function () {
                return this.controls.KagoMoshitate().isGroupBox;
            };

            PublicProperties.prototype.setisGroupBox = function (value) {
                this.controls.KagoMoshitate().isGroupBox = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KagoMoshitate().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KagoMoshitate().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KagoMoshitate().title = value;
            };
            return PublicProperties;
        })();
        KagoMoshitate.PublicProperties = PublicProperties;
    })(DBC.KagoMoshitate || (DBC.KagoMoshitate = {}));
    var KagoMoshitate = DBC.KagoMoshitate;
})(DBC || (DBC = {}));
