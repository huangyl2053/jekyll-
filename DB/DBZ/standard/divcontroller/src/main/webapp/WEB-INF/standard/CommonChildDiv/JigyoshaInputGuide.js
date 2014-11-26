var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaInputGuide.ModeController = ModeController;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JigyoshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));
