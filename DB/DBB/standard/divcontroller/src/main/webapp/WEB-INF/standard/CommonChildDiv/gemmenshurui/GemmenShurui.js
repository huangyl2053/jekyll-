var DBB;
(function (DBB) {
    (function (GemmenShurui) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenShurui.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GemmenShurui.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GemmenShurui.ModeController = ModeController;
    })(DBB.GemmenShurui || (DBB.GemmenShurui = {}));
    var GemmenShurui = DBB.GemmenShurui;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (GemmenShurui) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenShurui.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GemmenShurui.PublicProperties = PublicProperties;
    })(DBB.GemmenShurui || (DBB.GemmenShurui = {}));
    var GemmenShurui = DBB.GemmenShurui;
})(DBB || (DBB = {}));
