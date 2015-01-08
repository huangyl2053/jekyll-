var DBZ;
(function (DBZ) {
    (function (Kiwarigaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new Kiwarigaku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new Kiwarigaku.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        Kiwarigaku.ModeController = ModeController;
    })(DBZ.Kiwarigaku || (DBZ.Kiwarigaku = {}));
    var Kiwarigaku = DBZ.Kiwarigaku;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (Kiwarigaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new Kiwarigaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        Kiwarigaku.PublicProperties = PublicProperties;
    })(DBZ.Kiwarigaku || (DBZ.Kiwarigaku = {}));
    var Kiwarigaku = DBZ.Kiwarigaku;
})(DBZ || (DBZ = {}));
