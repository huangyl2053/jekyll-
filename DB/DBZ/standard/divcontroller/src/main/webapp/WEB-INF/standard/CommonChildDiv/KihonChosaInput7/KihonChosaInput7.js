var DBZ;
(function (DBZ) {
    (function (KihonChosaInput7) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput7.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput7.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput7.ModeController = ModeController;
    })(DBZ.KihonChosaInput7 || (DBZ.KihonChosaInput7 = {}));
    var KihonChosaInput7 = DBZ.KihonChosaInput7;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput7) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput7.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput7.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput7 || (DBZ.KihonChosaInput7 = {}));
    var KihonChosaInput7 = DBZ.KihonChosaInput7;
})(DBZ || (DBZ = {}));
