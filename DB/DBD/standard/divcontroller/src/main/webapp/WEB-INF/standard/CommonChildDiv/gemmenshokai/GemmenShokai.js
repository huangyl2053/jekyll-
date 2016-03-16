var DBD;
(function (DBD) {
    (function (GemmenShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GemmenShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GemmenShokai.ModeController = ModeController;
    })(DBD.GemmenShokai || (DBD.GemmenShokai = {}));
    var GemmenShokai = DBD.GemmenShokai;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (GemmenShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GemmenShokai.PublicProperties = PublicProperties;
    })(DBD.GemmenShokai || (DBD.GemmenShokai = {}));
    var GemmenShokai = DBD.GemmenShokai;
})(DBD || (DBD = {}));
