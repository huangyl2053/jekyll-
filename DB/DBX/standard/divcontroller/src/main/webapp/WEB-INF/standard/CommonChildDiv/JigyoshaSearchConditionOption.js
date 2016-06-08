var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionOption) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaSearchConditionOption.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoshaSearchConditionOption.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaSearchConditionOption.ModeController = ModeController;
    })(DBX.JigyoshaSearchConditionOption || (DBX.JigyoshaSearchConditionOption = {}));
    var JigyoshaSearchConditionOption = DBX.JigyoshaSearchConditionOption;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionOption) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaSearchConditionOption.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaSearchConditionOption.PublicProperties = PublicProperties;
    })(DBX.JigyoshaSearchConditionOption || (DBX.JigyoshaSearchConditionOption = {}));
    var JigyoshaSearchConditionOption = DBX.JigyoshaSearchConditionOption;
})(DBX || (DBX = {}));
