var DBZ;
(function (DBZ) {
    (function (SaikinShorisha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SaikinShorisha.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SaikinShorisha.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SaikinShorisha.ModeController = ModeController;
    })(DBZ.SaikinShorisha || (DBZ.SaikinShorisha = {}));
    var SaikinShorisha = DBZ.SaikinShorisha;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SaikinShorisha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SaikinShorisha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SaikinShorisha.PublicProperties = PublicProperties;
    })(DBZ.SaikinShorisha || (DBZ.SaikinShorisha = {}));
    var SaikinShorisha = DBZ.SaikinShorisha;
})(DBZ || (DBZ = {}));
