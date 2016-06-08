var DBZ;
(function (DBZ) {
    (function (SonotaKikanGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SonotaKikanGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SonotaKikanGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SonotaKikanGuide.ModeController = ModeController;
    })(DBZ.SonotaKikanGuide || (DBZ.SonotaKikanGuide = {}));
    var SonotaKikanGuide = DBZ.SonotaKikanGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SonotaKikanGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SonotaKikanGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SonotaKikanGuide.PublicProperties = PublicProperties;
    })(DBZ.SonotaKikanGuide || (DBZ.SonotaKikanGuide = {}));
    var SonotaKikanGuide = DBZ.SonotaKikanGuide;
})(DBZ || (DBZ = {}));
