var DBE;
(function (DBE) {
    (function (TextMasking) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TextMasking.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TextMasking.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TextMasking.ModeController = ModeController;
    })(DBE.TextMasking || (DBE.TextMasking = {}));
    var TextMasking = DBE.TextMasking;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TextMasking) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TextMasking.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TextMasking.PublicProperties = PublicProperties;
    })(DBE.TextMasking || (DBE.TextMasking = {}));
    var TextMasking = DBE.TextMasking;
})(DBE || (DBE = {}));
