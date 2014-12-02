var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ImageMasking.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ImageMasking.ModeController = ModeController;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ImageMasking.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ImageMasking.PublicProperties = PublicProperties;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));
