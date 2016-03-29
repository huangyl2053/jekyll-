var DBB;
(function (DBB) {
    (function (KaigoNonyutuchishoHakkoJoken) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNonyutuchishoHakkoJoken.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNonyutuchishoHakkoJoken.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoNonyutuchishoHakkoJoken.ModeController = ModeController;
    })(DBB.KaigoNonyutuchishoHakkoJoken || (DBB.KaigoNonyutuchishoHakkoJoken = {}));
    var KaigoNonyutuchishoHakkoJoken = DBB.KaigoNonyutuchishoHakkoJoken;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (KaigoNonyutuchishoHakkoJoken) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNonyutuchishoHakkoJoken.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNonyutuchishoHakkoJoken.PublicProperties = PublicProperties;
    })(DBB.KaigoNonyutuchishoHakkoJoken || (DBB.KaigoNonyutuchishoHakkoJoken = {}));
    var KaigoNonyutuchishoHakkoJoken = DBB.KaigoNonyutuchishoHakkoJoken;
})(DBB || (DBB = {}));
