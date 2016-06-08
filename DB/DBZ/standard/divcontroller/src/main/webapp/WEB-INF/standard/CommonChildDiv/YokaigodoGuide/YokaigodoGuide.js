var DBZ;
(function (DBZ) {
    (function (YokaigodoGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigodoGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new YokaigodoGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        YokaigodoGuide.ModeController = ModeController;
    })(DBZ.YokaigodoGuide || (DBZ.YokaigodoGuide = {}));
    var YokaigodoGuide = DBZ.YokaigodoGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (YokaigodoGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigodoGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        YokaigodoGuide.PublicProperties = PublicProperties;
    })(DBZ.YokaigodoGuide || (DBZ.YokaigodoGuide = {}));
    var YokaigodoGuide = DBZ.YokaigodoGuide;
})(DBZ || (DBZ = {}));
