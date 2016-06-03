var DBB;
(function (DBB) {
    (function (GemmenTorikeshiShurui) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenTorikeshiShurui.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GemmenTorikeshiShurui.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GemmenTorikeshiShurui.ModeController = ModeController;
    })(DBB.GemmenTorikeshiShurui || (DBB.GemmenTorikeshiShurui = {}));
    var GemmenTorikeshiShurui = DBB.GemmenTorikeshiShurui;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (GemmenTorikeshiShurui) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenTorikeshiShurui.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GemmenTorikeshiShurui.PublicProperties = PublicProperties;
    })(DBB.GemmenTorikeshiShurui || (DBB.GemmenTorikeshiShurui = {}));
    var GemmenTorikeshiShurui = DBB.GemmenTorikeshiShurui;
})(DBB || (DBB = {}));
