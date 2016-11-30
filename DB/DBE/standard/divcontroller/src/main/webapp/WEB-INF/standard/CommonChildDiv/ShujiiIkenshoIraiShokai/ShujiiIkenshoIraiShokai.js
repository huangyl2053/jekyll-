var DBE;
(function (DBE) {
    (function (ShujiiIkenshoIraiShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIkenshoIraiShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIkenshoIraiShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShujiiIkenshoIraiShokai.ModeController = ModeController;
    })(DBE.ShujiiIkenshoIraiShokai || (DBE.ShujiiIkenshoIraiShokai = {}));
    var ShujiiIkenshoIraiShokai = DBE.ShujiiIkenshoIraiShokai;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShujiiIkenshoIraiShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIkenshoIraiShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIkenshoIraiShokai.PublicProperties = PublicProperties;
    })(DBE.ShujiiIkenshoIraiShokai || (DBE.ShujiiIkenshoIraiShokai = {}));
    var ShujiiIkenshoIraiShokai = DBE.ShujiiIkenshoIraiShokai;
})(DBE || (DBE = {}));
