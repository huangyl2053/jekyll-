var DBB;
(function (DBB) {
    (function (KaigoFukaKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoFukaKihon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoFukaKihon.ModeController = ModeController;
    })(DBB.KaigoFukaKihon || (DBB.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBB.KaigoFukaKihon;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (KaigoFukaKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoFukaKihon.PublicProperties = PublicProperties;
    })(DBB.KaigoFukaKihon || (DBB.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBB.KaigoFukaKihon;
})(DBB || (DBB = {}));
