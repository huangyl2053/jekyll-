var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput.ModeController = ModeController;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));
