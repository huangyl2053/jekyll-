var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiShisetsuInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiShisetsuInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TekiyoJogaiShisetsuInputGuide.ModeController = ModeController;
    })(DBZ.TekiyoJogaiShisetsuInputGuide || (DBZ.TekiyoJogaiShisetsuInputGuide = {}));
    var TekiyoJogaiShisetsuInputGuide = DBZ.TekiyoJogaiShisetsuInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiShisetsuInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TekiyoJogaiShisetsuInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TekiyoJogaiShisetsuInputGuide.PublicProperties = PublicProperties;
    })(DBZ.TekiyoJogaiShisetsuInputGuide || (DBZ.TekiyoJogaiShisetsuInputGuide = {}));
    var TekiyoJogaiShisetsuInputGuide = DBZ.TekiyoJogaiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
