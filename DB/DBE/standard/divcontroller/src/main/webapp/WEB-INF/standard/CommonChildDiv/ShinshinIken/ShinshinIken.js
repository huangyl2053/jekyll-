var DBE;
(function (DBE) {
    (function (ShinshinIken) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinshinIken.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinshinIken.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShinshinIken.ModeController = ModeController;
    })(DBE.ShinshinIken || (DBE.ShinshinIken = {}));
    var ShinshinIken = DBE.ShinshinIken;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShinshinIken) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinshinIken.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShinshinIken.PublicProperties = PublicProperties;
    })(DBE.ShinshinIken || (DBE.ShinshinIken = {}));
    var ShinshinIken = DBE.ShinshinIken;
})(DBE || (DBE = {}));
