var DBC;
(function (DBC) {
    (function (ShuruiGendoInfoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShuruiGendoInfoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShuruiGendoInfoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShuruiGendoInfoCommonChildDiv.ModeController = ModeController;
    })(DBC.ShuruiGendoInfoCommonChildDiv || (DBC.ShuruiGendoInfoCommonChildDiv = {}));
    var ShuruiGendoInfoCommonChildDiv = DBC.ShuruiGendoInfoCommonChildDiv;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShuruiGendoInfoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShuruiGendoInfoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShuruiGendoInfoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBC.ShuruiGendoInfoCommonChildDiv || (DBC.ShuruiGendoInfoCommonChildDiv = {}));
    var ShuruiGendoInfoCommonChildDiv = DBC.ShuruiGendoInfoCommonChildDiv;
})(DBC || (DBC = {}));
