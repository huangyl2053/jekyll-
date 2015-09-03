var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionCommon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaSearchConditionCommon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoshaSearchConditionCommon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaSearchConditionCommon.ModeController = ModeController;
    })(DBX.JigyoshaSearchConditionCommon || (DBX.JigyoshaSearchConditionCommon = {}));
    var JigyoshaSearchConditionCommon = DBX.JigyoshaSearchConditionCommon;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionCommon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaSearchConditionCommon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaSearchConditionCommon.PublicProperties = PublicProperties;
    })(DBX.JigyoshaSearchConditionCommon || (DBX.JigyoshaSearchConditionCommon = {}));
    var JigyoshaSearchConditionCommon = DBX.JigyoshaSearchConditionCommon;
})(DBX || (DBX = {}));
