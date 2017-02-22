var DBE;
(function (DBE) {
    (function (ShujiiIkenshoShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIkenshoShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIkenshoShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShujiiIkenshoShokai.ModeController = ModeController;
    })(DBE.ShujiiIkenshoShokai || (DBE.ShujiiIkenshoShokai = {}));
    var ShujiiIkenshoShokai = DBE.ShujiiIkenshoShokai;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShujiiIkenshoShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIkenshoShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIkenshoShokai.PublicProperties = PublicProperties;
    })(DBE.ShujiiIkenshoShokai || (DBE.ShujiiIkenshoShokai = {}));
    var ShujiiIkenshoShokai = DBE.ShujiiIkenshoShokai;
})(DBE || (DBE = {}));
