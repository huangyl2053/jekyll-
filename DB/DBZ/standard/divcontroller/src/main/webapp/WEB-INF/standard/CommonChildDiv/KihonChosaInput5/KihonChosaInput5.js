var DBZ;
(function (DBZ) {
    (function (KihonChosaInput5) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput5.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput5.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput5.ModeController = ModeController;
    })(DBZ.KihonChosaInput5 || (DBZ.KihonChosaInput5 = {}));
    var KihonChosaInput5 = DBZ.KihonChosaInput5;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput5) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput5.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput5.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput5 || (DBZ.KihonChosaInput5 = {}));
    var KihonChosaInput5 = DBZ.KihonChosaInput5;
})(DBZ || (DBZ = {}));
