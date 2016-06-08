var DBZ;
(function (DBZ) {
    (function (TeikeibunGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TeikeibunGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TeikeibunGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TeikeibunGuide.ModeController = ModeController;
    })(DBZ.TeikeibunGuide || (DBZ.TeikeibunGuide = {}));
    var TeikeibunGuide = DBZ.TeikeibunGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TeikeibunGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TeikeibunGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TeikeibunGuide.PublicProperties = PublicProperties;
    })(DBZ.TeikeibunGuide || (DBZ.TeikeibunGuide = {}));
    var TeikeibunGuide = DBZ.TeikeibunGuide;
})(DBZ || (DBZ = {}));
