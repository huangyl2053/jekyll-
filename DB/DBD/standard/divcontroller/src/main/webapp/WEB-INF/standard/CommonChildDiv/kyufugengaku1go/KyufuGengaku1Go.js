var DBD;
(function (DBD) {
    (function (KyufuGengaku1Go) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuGengaku1Go.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KyufuGengaku1Go.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KyufuGengaku1Go.ModeController = ModeController;
    })(DBD.KyufuGengaku1Go || (DBD.KyufuGengaku1Go = {}));
    var KyufuGengaku1Go = DBD.KyufuGengaku1Go;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (KyufuGengaku1Go) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuGengaku1Go.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KyufuGengaku1Go.PublicProperties = PublicProperties;
    })(DBD.KyufuGengaku1Go || (DBD.KyufuGengaku1Go = {}));
    var KyufuGengaku1Go = DBD.KyufuGengaku1Go;
})(DBD || (DBD = {}));
