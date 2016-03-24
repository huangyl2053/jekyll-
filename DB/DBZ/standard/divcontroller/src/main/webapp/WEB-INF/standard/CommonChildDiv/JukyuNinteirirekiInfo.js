var DBZ;
(function (DBZ) {
    (function (JukyuNinteirirekiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuNinteirirekiInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JukyuNinteirirekiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JukyuNinteirirekiInfo.ModeController = ModeController;
    })(DBZ.JukyuNinteirirekiInfo || (DBZ.JukyuNinteirirekiInfo = {}));
    var JukyuNinteirirekiInfo = DBZ.JukyuNinteirirekiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JukyuNinteirirekiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuNinteirirekiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuNinteirirekiInfo.PublicProperties = PublicProperties;
    })(DBZ.JukyuNinteirirekiInfo || (DBZ.JukyuNinteirirekiInfo = {}));
    var JukyuNinteirirekiInfo = DBZ.JukyuNinteirirekiInfo;
})(DBZ || (DBZ = {}));
