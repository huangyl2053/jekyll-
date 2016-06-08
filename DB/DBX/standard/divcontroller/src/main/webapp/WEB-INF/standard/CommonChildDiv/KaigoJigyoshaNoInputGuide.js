var DBX;
(function (DBX) {
    (function (KaigoJigyoshaNoInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaNoInputGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoJigyoshaNoInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoJigyoshaNoInputGuide.ModeController = ModeController;
    })(DBX.KaigoJigyoshaNoInputGuide || (DBX.KaigoJigyoshaNoInputGuide = {}));
    var KaigoJigyoshaNoInputGuide = DBX.KaigoJigyoshaNoInputGuide;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (KaigoJigyoshaNoInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaNoInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoJigyoshaNoInputGuide.PublicProperties = PublicProperties;
    })(DBX.KaigoJigyoshaNoInputGuide || (DBX.KaigoJigyoshaNoInputGuide = {}));
    var KaigoJigyoshaNoInputGuide = DBX.KaigoJigyoshaNoInputGuide;
})(DBX || (DBX = {}));
