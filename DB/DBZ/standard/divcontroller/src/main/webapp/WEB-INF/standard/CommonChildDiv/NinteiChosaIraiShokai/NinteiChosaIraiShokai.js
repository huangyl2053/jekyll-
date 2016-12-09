var DBZ;
(function (DBZ) {
    (function (NinteiChosaIraiShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaIraiShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaIraiShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiChosaIraiShokai.ModeController = ModeController;
    })(DBZ.NinteiChosaIraiShokai || (DBZ.NinteiChosaIraiShokai = {}));
    var NinteiChosaIraiShokai = DBZ.NinteiChosaIraiShokai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaIraiShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaIraiShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaIraiShokai.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaIraiShokai || (DBZ.NinteiChosaIraiShokai = {}));
    var NinteiChosaIraiShokai = DBZ.NinteiChosaIraiShokai;
})(DBZ || (DBZ = {}));
