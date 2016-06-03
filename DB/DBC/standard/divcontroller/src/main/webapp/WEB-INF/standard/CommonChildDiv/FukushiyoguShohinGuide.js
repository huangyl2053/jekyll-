var DBC;
(function (DBC) {
    (function (FukushiyoguShohinGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukushiyoguShohinGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new FukushiyoguShohinGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        FukushiyoguShohinGuide.ModeController = ModeController;
    })(DBC.FukushiyoguShohinGuide || (DBC.FukushiyoguShohinGuide = {}));
    var FukushiyoguShohinGuide = DBC.FukushiyoguShohinGuide;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (FukushiyoguShohinGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukushiyoguShohinGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        FukushiyoguShohinGuide.PublicProperties = PublicProperties;
    })(DBC.FukushiyoguShohinGuide || (DBC.FukushiyoguShohinGuide = {}));
    var FukushiyoguShohinGuide = DBC.FukushiyoguShohinGuide;
})(DBC || (DBC = {}));
