var DBZ;
(function (DBZ) {
    (function (KihonChosaInput2) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput2.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput2.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput2.ModeController = ModeController;
    })(DBZ.KihonChosaInput2 || (DBZ.KihonChosaInput2 = {}));
    var KihonChosaInput2 = DBZ.KihonChosaInput2;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput2) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput2.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput2.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput2 || (DBZ.KihonChosaInput2 = {}));
    var KihonChosaInput2 = DBZ.KihonChosaInput2;
})(DBZ || (DBZ = {}));
