var DBZ;
(function (DBZ) {
    (function (KoseiShiChosonSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KoseiShiChosonSelector.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KoseiShiChosonSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KoseiShiChosonSelector.ModeController = ModeController;
    })(DBZ.KoseiShiChosonSelector || (DBZ.KoseiShiChosonSelector = {}));
    var KoseiShiChosonSelector = DBZ.KoseiShiChosonSelector;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KoseiShiChosonSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KoseiShiChosonSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KoseiShiChosonSelector.PublicProperties = PublicProperties;
    })(DBZ.KoseiShiChosonSelector || (DBZ.KoseiShiChosonSelector = {}));
    var KoseiShiChosonSelector = DBZ.KoseiShiChosonSelector;
})(DBZ || (DBZ = {}));
