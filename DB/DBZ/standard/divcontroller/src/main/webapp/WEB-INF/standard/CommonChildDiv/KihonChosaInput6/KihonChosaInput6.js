var DBZ;
(function (DBZ) {
    (function (KihonChosaInput6) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput6.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput6.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput6.ModeController = ModeController;
    })(DBZ.KihonChosaInput6 || (DBZ.KihonChosaInput6 = {}));
    var KihonChosaInput6 = DBZ.KihonChosaInput6;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput6) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput6.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput6.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput6 || (DBZ.KihonChosaInput6 = {}));
    var KihonChosaInput6 = DBZ.KihonChosaInput6;
})(DBZ || (DBZ = {}));
