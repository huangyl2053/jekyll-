var DBX;
(function (DBX) {
    (function (KaigoHokenFukaKonkyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoHokenFukaKonkyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoHokenFukaKonkyo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoHokenFukaKonkyo.ModeController = ModeController;
    })(DBX.KaigoHokenFukaKonkyo || (DBX.KaigoHokenFukaKonkyo = {}));
    var KaigoHokenFukaKonkyo = DBX.KaigoHokenFukaKonkyo;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (KaigoHokenFukaKonkyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoHokenFukaKonkyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoHokenFukaKonkyo.PublicProperties = PublicProperties;
    })(DBX.KaigoHokenFukaKonkyo || (DBX.KaigoHokenFukaKonkyo = {}));
    var KaigoHokenFukaKonkyo = DBX.KaigoHokenFukaKonkyo;
})(DBX || (DBX = {}));
