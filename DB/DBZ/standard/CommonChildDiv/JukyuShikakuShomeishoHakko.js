var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JukyuShikakuShomeishoHakko.ModeController = ModeController;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuShikakuShomeishoHakko.PublicProperties = PublicProperties;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
