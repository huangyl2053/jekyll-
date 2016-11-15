var DBE;
(function (DBE) {
    (function (ImageDisplay) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ImageDisplay.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ImageDisplay.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ImageDisplay.ModeController = ModeController;
    })(DBE.ImageDisplay || (DBE.ImageDisplay = {}));
    var ImageDisplay = DBE.ImageDisplay;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ImageDisplay) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ImageDisplay.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ImageDisplay.PublicProperties = PublicProperties;
    })(DBE.ImageDisplay || (DBE.ImageDisplay = {}));
    var ImageDisplay = DBE.ImageDisplay;
})(DBE || (DBE = {}));
