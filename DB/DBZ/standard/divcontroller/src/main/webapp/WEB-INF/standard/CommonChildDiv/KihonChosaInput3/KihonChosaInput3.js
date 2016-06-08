var DBZ;
(function (DBZ) {
    (function (KihonChosaInput3) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput3.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput3.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput3.ModeController = ModeController;
    })(DBZ.KihonChosaInput3 || (DBZ.KihonChosaInput3 = {}));
    var KihonChosaInput3 = DBZ.KihonChosaInput3;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput3) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput3.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput3.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput3 || (DBZ.KihonChosaInput3 = {}));
    var KihonChosaInput3 = DBZ.KihonChosaInput3;
})(DBZ || (DBZ = {}));
