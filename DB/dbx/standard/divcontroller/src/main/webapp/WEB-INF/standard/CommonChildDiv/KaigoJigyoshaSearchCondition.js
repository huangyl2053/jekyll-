var DBX;
(function (DBX) {
    (function (KaigoJigyoshaSearchCondition) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaSearchCondition.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoJigyoshaSearchCondition.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoJigyoshaSearchCondition.ModeController = ModeController;
    })(DBX.KaigoJigyoshaSearchCondition || (DBX.KaigoJigyoshaSearchCondition = {}));
    var KaigoJigyoshaSearchCondition = DBX.KaigoJigyoshaSearchCondition;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (KaigoJigyoshaSearchCondition) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaSearchCondition.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoJigyoshaSearchCondition.PublicProperties = PublicProperties;
    })(DBX.KaigoJigyoshaSearchCondition || (DBX.KaigoJigyoshaSearchCondition = {}));
    var KaigoJigyoshaSearchCondition = DBX.KaigoJigyoshaSearchCondition;
})(DBX || (DBX = {}));
