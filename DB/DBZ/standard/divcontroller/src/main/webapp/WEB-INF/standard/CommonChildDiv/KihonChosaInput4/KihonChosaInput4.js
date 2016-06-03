var DBZ;
(function (DBZ) {
    (function (KihonChosaInput4) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput4.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput4.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KihonChosaInput4.ModeController = ModeController;
    })(DBZ.KihonChosaInput4 || (DBZ.KihonChosaInput4 = {}));
    var KihonChosaInput4 = DBZ.KihonChosaInput4;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput4) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput4.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput4.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput4 || (DBZ.KihonChosaInput4 = {}));
    var KihonChosaInput4 = DBZ.KihonChosaInput4;
})(DBZ || (DBZ = {}));
