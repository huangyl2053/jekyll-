var DBZ;
(function (DBZ) {
    (function (KaigoToiawase) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoToiawase.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoToiawase.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoToiawase.ModeController = ModeController;
    })(DBZ.KaigoToiawase || (DBZ.KaigoToiawase = {}));
    var KaigoToiawase = DBZ.KaigoToiawase;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoToiawase) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoToiawase.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoToiawase.PublicProperties = PublicProperties;
    })(DBZ.KaigoToiawase || (DBZ.KaigoToiawase = {}));
    var KaigoToiawase = DBZ.KaigoToiawase;
})(DBZ || (DBZ = {}));
