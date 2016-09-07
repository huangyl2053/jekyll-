var DBC;
(function (DBC) {
    (function (ShuruiGendoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShuruiGendoInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShuruiGendoInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShuruiGendoInfo.ModeController = ModeController;
    })(DBC.ShuruiGendoInfo || (DBC.ShuruiGendoInfo = {}));
    var ShuruiGendoInfo = DBC.ShuruiGendoInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShuruiGendoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShuruiGendoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShuruiGendoInfo.PublicProperties = PublicProperties;
    })(DBC.ShuruiGendoInfo || (DBC.ShuruiGendoInfo = {}));
    var ShuruiGendoInfo = DBC.ShuruiGendoInfo;
})(DBC || (DBC = {}));
