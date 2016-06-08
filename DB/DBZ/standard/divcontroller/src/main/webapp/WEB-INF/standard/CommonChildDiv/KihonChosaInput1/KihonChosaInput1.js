var DBZ;
(function (DBZ) {
    (function (KihonChosaInput1) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput1.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput1.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput1.ModeController = ModeController;
    })(DBZ.KihonChosaInput1 || (DBZ.KihonChosaInput1 = {}));
    var KihonChosaInput1 = DBZ.KihonChosaInput1;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput1) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput1.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput1.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput1 || (DBZ.KihonChosaInput1 = {}));
    var KihonChosaInput1 = DBZ.KihonChosaInput1;
})(DBZ || (DBZ = {}));
